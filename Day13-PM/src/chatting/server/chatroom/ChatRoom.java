package chatting.server.chatroom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ChatRoom {
	
	// �� �濡 ������ Ŭ���̾�Ʈ ���
	private List<ChatClientThread> clientsInThisRoom = new ArrayList<>();
	
	// ����
	ChatClientThread boss;
	
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
