package network.chat.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
	
	static class MsgReceiver extends Thread {
		
		BufferedReader reader = null;
		boolean flag = true;
		
		public MsgReceiver(BufferedReader reader) {
			this.reader = reader;
		}
		
		@Override
		public void run() {
			while (flag) {
				try {
					// �����κ��� �޽��� ����
					String msg = reader.readLine();
					// ȭ�鿡 ���
					System.out.println(msg);
				} catch (IOException e) {
					flag = false;
				}
			}
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		// ����ڷκ��� �Է� �ޱ� ���� Scanner ��ü
		Scanner sc = new Scanner(System.in);
		
		System.out.print("����� ��ȭ��: ");
		String nick = sc.nextLine();
		
		Socket sock = new Socket("121.138.83.1", 3000);
		
		// sock ��ü�� ���������� ������ �Ǹ�
		
		// ��/��� ��Ʈ�� ��ü ���
		OutputStream out = sock.getOutputStream();
		InputStream in = sock.getInputStream();
		
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		
		// ��ȭ�� ����
		writer.write(nick + "\n");
		writer.flush();
		
		MsgReceiver receiver = new MsgReceiver(reader);
		receiver.start();	// �޽��� ���� ����
		
		while (true) {
//			System.out.print("���� �޽���: ");
			String msg = sc.nextLine();
			
			// ������ �޽��� ����
			writer.write(msg + "\n");
			// ���۰� �������� �ʾƵ� ���� �۽�
			writer.flush();	// ���ۿ� �ִ� ������ �ٷ� �۽�
		}
		
	}
	
}
















