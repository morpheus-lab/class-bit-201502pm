package chatting.server.chatroom;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

//���� ���忡�� Ŭ���̾�Ʈ�� ����ϴ� ������
public class ChatClientThread extends Thread {
	// [tip]
	// �̸������ Ŀ���� �̸��� �ΰ�
	// <Alt>+<Shift>+R
	
	private Socket sock;	// Ŭ���̾�Ʈ�� ���� ���
	
	private Scanner in;
	private PrintWriter out;
	
	private ChatRoom chatRoom;
	
	public ChatClientThread(Socket sock) throws IOException {
		this.sock = sock;
		in = new Scanner(sock.getInputStream());
		out = new PrintWriter(sock.getOutputStream(), true);
	}
	
	// [tip] getters / setters �� �ڵ����� �����: "<Alt>+<Shift>+S, R"
	public ChatRoom getChatRoom() {
		return chatRoom;
	}

	public void setChatRoom(ChatRoom chatRoom) {
		this.chatRoom = chatRoom;
	}

	// �޽����� Ŭ���̾�Ʈ���� ����
	public void sendMessage(String msg) {
		out.println(msg);
	}
	
	@Override
	public void run() {
		// Ŭ���̾�Ʈ�� �����ϴ� �޽����� ó��
		
		// Ŭ���̾�Ʈ�� ȯ�� �޽��� ����
		sendMessage("/------------------------/");
		sendMessage("  Welcome!");
		sendMessage("/------------------------/");
		
		while (true) {
			// �޴� ����
			sendMessage("---------- �޴� ----------");
			sendMessage("[1] ä�ù� ��� ��ȸ");
			sendMessage("[2] ä�ù� �����");
			sendMessage("[3] ä�ù� ����");
			sendMessage("[0] ���� ����");
			sendMessage("�޴��� �����ϼ���:");
			
			String menu = in.nextLine();
			
//			if (menu.equals("1")) {	// menu�� null�̸� NullPointerException �߻�
//			}
			if ("1".equals(menu)) {	// menu�� null�̾ NullPointerException �߻����� ����
				// ��� ��ȸ
			}
			else if ("2".equals(menu)) {
				// ä�ù� ����
			}
			else if ("3".equals(menu)) {
				// ä�ù� ����
			}
			else if ("0".equals(menu)) {
				// ���� ����
				sendMessage("/------------------------/");
				sendMessage("  Bye~");
				sendMessage("/------------------------/");
				
				break;
			}
		}
		
		in.close();
		out.close();
		try {
			sock.close();
		} catch (IOException e) {}
		
	}
	
}
