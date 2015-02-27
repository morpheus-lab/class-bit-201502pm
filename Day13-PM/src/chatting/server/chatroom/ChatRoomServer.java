package chatting.server.chatroom;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatRoomServer {
	
	// �� ���
	static List<ChatRoom> rooms = new ArrayList<>();
	
	static ServerSocket serverSock;
	
	public static void main(String[] args) {
		try {
			serverSock = new ServerSocket(3000);
			
			while (true) {
				Socket sock = serverSock.accept();
				// ChatClientThread ����
				ChatClientThread t = new ChatClientThread(sock);
				t.start();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("������ ������ �� �����ϴ�.");
		}
	}
	
}
