package chatting.server.chatroom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ChatRoom {
	
	// 이 방에 입장한 클라이언트 목록
	private List<ChatClientThread> clientsInThisRoom = new ArrayList<>();
	
	// 방장
	ChatClientThread boss;
	
	public ChatRoom(ChatClientThread boss) {
		this.boss = boss;
	}
	
	// 이 방 안의 모든 클라이언트에게 메시지 전송
	public synchronized void sendMessageToAll(String msg) {
		Iterator<ChatClientThread> iter = clientsInThisRoom.iterator();
		while (iter.hasNext()) {
			iter.next().sendMessage(msg);
		}
	}
	
	// 이 방으로 입장시킴
	public synchronized void enter(ChatClientThread client) {
		client.setChatRoom(this);
		clientsInThisRoom.add(client);
	}
	
	// 이 방에서 내보내기
	public synchronized void leave(ChatClientThread client) {
		clientsInThisRoom.remove(client);
		client.setChatRoom(null);
	}
	
}
