package chatting.chatroom.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Iterator;
import java.util.Scanner;

//서버 입장에서 클라이언트를 담당하는 스레드
public class ChatClientThread extends Thread {
	// [tip]
	// 이름변경시 커서를 이름에 두고
	// <Alt>+<Shift>+R
	
	private String nick;	// 대화명
	
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
		// 대화명 설정
		nick = in.nextLine();
		
		// 클라이언트가 전송하는 메시지를 처리
		
		// 클라이언트에 환영 메시지 전송
		sendMessage("/------------------------/");
		sendMessage("  Welcome!");
		sendMessage("/------------------------/");
		sendMessage("");
		
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
				sendMessage("--------- 방목록 ---------");
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
						sendMessage("[" + room.roomNum + "] " + room.title);	// [1] 드루와
																				// [2] 어서오세요
					}
					*/
				}
				sendMessage("--------------------------");
				sendMessage("");
			}
			else if ("2".equals(menu)) {
				// 채팅방 개설
				// 사용자로부터 정보 입력 받기
				// 채팅방 제목?
				sendMessage("방제목을 입력하세요.");
				String roomTitle = in.nextLine();
				// ChatRoom 객체 생성
				ChatRoom room = new ChatRoom(this);	// 방장 설정
				room.title = roomTitle;	// 방 제목 설정
				// 방 목록 리스트에 채팅방 객체 추가
				synchronized (ChatRoomServer.rooms) {
					ChatRoomServer.rooms.put(room.roomNum, room);
//					ChatRoomServer.rooms.add(room);
				}
				// 방장을 채팅 방에 입장시키기
				room.enter(this);	// 채팅방 객체가 갖고 있는 클라이언트 목록에 추가
			}
			else if ("3".equals(menu)) {
				// 채팅방 입장
				sendMessage("입장 방번호를 입력하세요.");
				int roomNum = Integer.parseInt(in.nextLine());
				ChatRoom room = null;
				synchronized (ChatRoomServer.rooms) {
					// 방번호로 방 찾기
					room = ChatRoomServer.rooms.get(roomNum);
				}
				if (room != null) {
					// 그 방으로 입장시키기
					room.enter(this);	// 채팅방 객체가 갖고 있는 클라이언트 목록에 추가
				} else {
					sendMessage("선택하신 방이 존재하지 않습니다.");
				}
			}
			else if ("0".equals(menu)) {
				// 접속 종료
				sendMessage("/------------------------/");
				sendMessage("  Bye~");
				sendMessage("/------------------------/");
				
				break;
			}
			
			// 메뉴 처리 후
			if (this.chatRoom != null) {
				// 입장하는 클라이언트에게만 메시지 출력
//				sendMessage("[" + this.chatRoom.title + "] 채팅방에 입장했습니다.");
				
				this.chatRoom.sendMessageToAll(nick + "님이 입장하였습니다.");
			}
			while (this.chatRoom != null) {
				// this.chatRoom이 null이 아니란 말은
				// 이 클라이언트가 chatRoom에 들어갔다는 말
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
