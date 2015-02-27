package chatting.chatroom.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Iterator;
import java.util.Scanner;

//���� ���忡�� Ŭ���̾�Ʈ�� ����ϴ� ������
public class ChatClientThread extends Thread {
	// [tip]
	// �̸������ Ŀ���� �̸��� �ΰ�
	// <Alt>+<Shift>+R
	
	private String nick;	// ��ȭ��
	
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
		// ��ȭ�� ����
		nick = in.nextLine();
		
		// Ŭ���̾�Ʈ�� �����ϴ� �޽����� ó��
		
		// Ŭ���̾�Ʈ�� ȯ�� �޽��� ����
		sendMessage("/------------------------/");
		sendMessage("  Welcome!");
		sendMessage("/------------------------/");
		sendMessage("");
		
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
				sendMessage("--------- ���� ---------");
				synchronized (ChatRoomServer.rooms) {
					Iterator<Integer> nums = ChatRoomServer.rooms.keySet().iterator();
					while (nums.hasNext()) {
						ChatRoom room = ChatRoomServer.rooms.get(nums.next());
						sendMessage("[" + room.roomNum + "] " + room.title);
					}
					/*
					Iterator<ChatRoom> iter = ChatRoomServer.rooms.iterator();
					while (iter.hasNext()) {
						ChatRoom room = iter.next();
						sendMessage("[" + room.roomNum + "] " + room.title);	// [1] ����
																				// [2] �������
					}
					*/
				}
				sendMessage("--------------------------");
				sendMessage("");
			}
			else if ("2".equals(menu)) {
				// ä�ù� ����
				// ����ڷκ��� ���� �Է� �ޱ�
				// ä�ù� ����?
				sendMessage("�������� �Է��ϼ���.");
				String roomTitle = in.nextLine();
				// ChatRoom ��ü ����
				ChatRoom room = new ChatRoom(this);	// ���� ����
				room.title = roomTitle;	// �� ���� ����
				// �� ��� ����Ʈ�� ä�ù� ��ü �߰�
				synchronized (ChatRoomServer.rooms) {
					ChatRoomServer.rooms.put(room.roomNum, room);
//					ChatRoomServer.rooms.add(room);
				}
				// ������ ä�� �濡 �����Ű��
				room.enter(this);	// ä�ù� ��ü�� ���� �ִ� Ŭ���̾�Ʈ ��Ͽ� �߰�
			}
			else if ("3".equals(menu)) {
				// ä�ù� ����
				sendMessage("���� ���ȣ�� �Է��ϼ���.");
				int roomNum = Integer.parseInt(in.nextLine());
				ChatRoom room = null;
				synchronized (ChatRoomServer.rooms) {
					// ���ȣ�� �� ã��
					room = ChatRoomServer.rooms.get(roomNum);
				}
				if (room != null) {
					// �� ������ �����Ű��
					room.enter(this);	// ä�ù� ��ü�� ���� �ִ� Ŭ���̾�Ʈ ��Ͽ� �߰�
				} else {
					sendMessage("�����Ͻ� ���� �������� �ʽ��ϴ�.");
				}
			}
			else if ("0".equals(menu)) {
				// ���� ����
				sendMessage("/------------------------/");
				sendMessage("  Bye~");
				sendMessage("/------------------------/");
				
				break;
			}
			
			// �޴� ó�� ��
			if (this.chatRoom != null) {
				// �����ϴ� Ŭ���̾�Ʈ���Ը� �޽��� ���
//				sendMessage("[" + this.chatRoom.title + "] ä�ù濡 �����߽��ϴ�.");
				
				this.chatRoom.sendMessageToAll(nick + "���� �����Ͽ����ϴ�.");
			}
			while (this.chatRoom != null) {
				// this.chatRoom�� null�� �ƴ϶� ����
				// �� Ŭ���̾�Ʈ�� chatRoom�� ���ٴ� ��
				String msg = in.nextLine();
				chatRoom.sendMessageToAll(nick + ": " + msg);
			}
		}
		
		in.close();
		out.close();
		try {
			sock.close();
		} catch (IOException e) {}
		
	}
	
}
