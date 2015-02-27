package chatting.chatroom.server;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ChatRoom {
	
	static int r = 1;
	
	// �� �濡 ������ Ŭ���̾�Ʈ ���
	private List<ChatClientThread> clientsInThisRoom = new ArrayList<>();
	
	// ����
	ChatClientThread boss;
	
	// ���ȣ
	Integer roomNum = r++;	// ó�� �����Ǵ� ChatRoom ��ü�� roomNum = 1
							// �� ��° �����Ǵ� ChatRoom ��ü�� roomNum = 2
							// �� ��° �����Ǵ� ChatRoom ��ü�� roomNum = 3
	
	// ������
	String title;
	
	public ChatRoom(ChatClientThread boss) {
		this.boss = boss;
	}
	
	// �� �� ���� ��� Ŭ���̾�Ʈ���� �޽��� ����
	public synchronized void sendMessageToAll(String msg) {
		Iterator<ChatClientThread> iter = clientsInThisRoom.iterator();
		while (iter.hasNext()) {
			iter.next().sendMessage(msg);
		}
	}
	
	// �� ������ �����Ŵ
	public synchronized void enter(ChatClientThread client) {
		client.setChatRoom(this);
		clientsInThisRoom.add(client);
	}
	
	// �� �濡�� ��������
	public synchronized void leave(ChatClientThread client) {
		clientsInThisRoom.remove(client);
		client.setChatRoom(null);
	}
	
}
