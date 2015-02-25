package network.echoserver.multiclient;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiClientEchoServer {
	
	static class EchoThread extends Thread {	// Ŭ���̾�Ʈ ���� �� ������ ��ü �����ǰ�
												// �� Ŭ���̾�Ʈ�� �޽����� ó��
		Socket sock = null;
		BufferedReader reader = null;
		BufferedWriter writer = null;
		
		public EchoThread(Socket sock) throws IOException {
			this.sock = sock;
			reader = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			writer = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()));
		}
		
		@Override
		public void run() {
			try {
				while (true) {
					// �޽��� ����
					String msg = reader.readLine();
					// ȭ�鿡 ���
					System.out.println(msg);
					// �޽��� �״�� �ٽ� �۽�
					writer.write(msg + "\n");
					writer.flush();
				}
			} catch (IOException e) {
				// ���� ���� ���� ���� �߻��� ���
				// IOException�� �߻��ϸ� while�� �������� �̰��� ����
			} finally {
				if (reader != null) {
					try {
						reader.close();
					} catch (IOException e) {}
				}
				if (writer != null) {
					try {
						writer.close();
					} catch (IOException e) {}
				}
				if (sock != null) {
					try {
						sock.close();
					} catch (IOException e) {}
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		
		ServerSocket ss = null;
		
		try {
			ss = new ServerSocket(3000);
			System.out.println("������ �����մϴ�.");
			while (true) {
				Socket sock = ss.accept();
				
				// �����û�� �����Ǿ� ������ �����Ǹ� �� ������ �Ѿ��
				try {
					// sock ��ü�� ���� Echo ����� ó���� �� �ִ� ������ �����带 �����
					EchoThread t = new EchoThread(sock);
					// start()
					t.start();
				} catch (IOException e) {
					// (3) new EchoThread �������� IOException �߻��� ���
					// => �ش� Ŭ���̾�Ʈ �����ϰ� ���� Ŭ���̾�Ʈ�� accept�� �� �ֵ��� �Ѿ
				}
			}
		} catch (IOException e) {
			// (1) new ServerSocket �������� IOException �߻��� ���
			// (2) accept() ���� IOException �߻��� ���
		} finally {
			System.out.println("������ �����մϴ�.");
			try {
				ss.close();
			} catch (IOException e) {}
		}
		
	}
	
}
