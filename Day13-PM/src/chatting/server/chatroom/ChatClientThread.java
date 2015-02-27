package chatting.server.chatroom;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

//서버 입장에서 클라이언트를 담당하는 스레드
public class ChatClientThread extends Thread {
	// [tip]
	// 이름변경시 커서를 이름에 두고
	// <Alt>+<Shift>+R
	
	private Socket sock;	// 클라이언트와 연결 담당
	
	private Scanner in;
	private PrintWriter out;
	
	private ChatRoom chatRoom;
	
	public ChatClientThread(Socket sock) throws IOException {
		this.sock = sock;
		in = new Scanner(sock.getInputStream());
		out = new PrintWriter(sock.getOutputStream(), true);
	}
	
	// [tip] getters / setters 를 자동으로 만들기: "<Alt>+<Shift>+S, R"
	public ChatRoom getChatRoom() {
		return chatRoom;
	}

	public void setChatRoom(ChatRoom chatRoom) {
		this.chatRoom = chatRoom;
	}

	// 메시지를 클라이언트에게 전송
	public void sendMessage(String msg) {
		out.println(msg);
	}
	
	@Override
	public void run() {
		// 클라이언트가 전송하는 메시지를 처리
		
		// 클라이언트에 환영 메시지 전송
		sendMessage("/------------------------/");
		sendMessage("  Welcome!");
		sendMessage("/------------------------/");
		
		while (true) {
			// 메뉴 전송
			sendMessage("---------- 메뉴 ----------");
			sendMessage("[1] 채팅방 목록 조회");
			sendMessage("[2] 채팅방 만들기");
			sendMessage("[3] 채팅방 입장");
			sendMessage("[0] 접속 종료");
			sendMessage("메뉴를 선택하세요:");
			
			String menu = in.nextLine();
			
//			if (menu.equals("1")) {	// menu가 null이면 NullPointerException 발생
//			}
			if ("1".equals(menu)) {	// menu가 null이어도 NullPointerException 발생하지 않음
				// 목록 조회
			}
			else if ("2".equals(menu)) {
				// 채팅방 개설
			}
			else if ("3".equals(menu)) {
				// 채팅방 입장
			}
			else if ("0".equals(menu)) {
				// 접속 종료
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
