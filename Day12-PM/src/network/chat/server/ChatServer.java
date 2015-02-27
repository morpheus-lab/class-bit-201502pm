package network.chat.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import network.chat.server.ChatServer.ChatThread;

public class ChatServer {
	
	static class ChatThread extends Thread {	// Ŭ���̾�Ʈ ���� �� ������ ��ü �����ǰ�
												// �� Ŭ���̾�Ʈ�� �޽����� ó��
		String nick = null;
		Socket sock = null;
		BufferedReader reader = null;
		BufferedWriter writer = null;
		
		public ChatThread(Socket sock) throws IOException {
			this.sock = sock;
			reader = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			writer = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()));
		}
		
		// �� �����尡 ����ϰ� �ִ� Ŭ���̾�Ʈ�� �޽��� �۽�
		public void sendMessage(String msg, ChatThread sender) throws IOException {
			if (writer != null) {
				if (sender == null) {
					writer.write("<<<" + msg + ">>>\n");
				} else {
					String senderNick = (sender == this) ? "��" : sender.nick;
					writer.write(senderNick + "> " + msg + "\n");
				}
				writer.flush();
			}
		}
		
		@Override
		public void run() {
			try {
				
				while (true) {
					String nick = reader.readLine();	// ���� ���� �޽��� => ��ȭ��
					// �ߺ� üũ
					if (isAvailableNick(nick)) {
						this.nick = nick;
						// ��� ���� ��ȭ���̶�� "OK" ���ڿ� ����
						sendMessage("OK", null);	// "<<<OK>>>"
						break;
					} else {
						// ���� ���� �ʴٸ� "NOT_OK" ���ڿ� ����
						sendMessage("NOT_OK", null);
						// �ٽ� ��ȭ�� �����ϵ���
					}
				}
				
				// �� Ŭ���̾�Ʈ�� nick�� �� �� �ִ� ���� ����
				// ��� Ŭ���̾�Ʈ���� xxx�� �����߽��ϴ�. �޽��� �۽�
				synchronized (clients) {
					// ��� Ŭ���̾�Ʈ�� �޽��� �۽�
					Iterator<ChatThread> iter = clients.iterator();
					while (iter.hasNext()) {
						ChatThread t = iter.next();
						if (t == this) {	// ���ο��Դ� ���� �޽��� �˸��� ����
							continue;
						}
						t.sendMessage(nick + "���� �����Ͽ����ϴ�.", null);
					}
				}
				
				while (true) {
					// Ŭ���̾�Ʈ�� ���� �޽��� ����
					String msg = reader.readLine();
					
					// ȭ�鿡 ���
					System.out.println(msg);
					
					synchronized (clients) {
						// ��� Ŭ���̾�Ʈ�� �޽��� �۽�
						Iterator<ChatThread> iter = clients.iterator();
						while (iter.hasNext()) {
							ChatThread t = iter.next();
							// t ��ü���� �޽��� �۽� ��Ŵ
							t.sendMessage(msg, this);
						}
					}
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
				synchronized (clients) {
					clients.remove(this);
				}
			}
		}
		
	}
	
	// �ߺ� ��ȭ�� üũ
	static boolean isAvailableNick(String nick) {
		synchronized (clients) {
			Iterator<ChatThread> iter = clients.iterator();
			while (iter.hasNext()) {
				if (nick.equals(iter.next().nick)) {
					return false;
				}
			}
			return true;
		}
	}
	
	// ���ӵ� Ŭ���̾�Ʈ ���
	static List<ChatThread> clients = new ArrayList<ChatThread>();
	
	public static void main(String[] args) {
		
		ServerSocket ss = null;
		
		try {
			ss = new ServerSocket(3000);
			System.out.println("������ �����մϴ�.");
			while (true) {
				Socket sock = ss.accept();
				
				// �����û�� �����Ǿ� ������ �����Ǹ� �� ������ �Ѿ��
				try {
					// sock ��ü�� ���� Chat ����� ó���� �� �ִ� ������ �����带 �����
					ChatThread t = new ChatThread(sock);
					
					synchronized (clients) {	// clients�� ���� �����尡 ����ϴ� ���� �ڿ�
						// ���ӵ� Ŭ���̾�Ʈ ��Ͽ� ChatThread �߰�
						clients.add(t);
					}
					
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
