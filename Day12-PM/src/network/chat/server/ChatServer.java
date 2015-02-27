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
	
	static class ChatThread extends Thread {	// 클라이언트 마다 이 스레드 객체 생성되고
												// 그 클라이언트의 메시지를 처리
		String nick = null;
		Socket sock = null;
		BufferedReader reader = null;
		BufferedWriter writer = null;
		
		public ChatThread(Socket sock) throws IOException {
			this.sock = sock;
			reader = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			writer = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()));
		}
		
		// 이 스레드가 담당하고 있는 클라이언트에 메시지 송신
		public void sendMessage(String msg, ChatThread sender) throws IOException {
			if (writer != null) {
				if (sender == null) {
					writer.write("<<<" + msg + ">>>\n");
				} else {
					String senderNick = (sender == this) ? "나" : sender.nick;
					writer.write(senderNick + "> " + msg + "\n");
				}
				writer.flush();
			}
		}
		
		@Override
		public void run() {
			try {
				
				while (true) {
					String nick = reader.readLine();	// 최초 수신 메시지 => 대화명
					// 중복 체크
					if (isAvailableNick(nick)) {
						this.nick = nick;
						// 사용 가능 대화명이라면 "OK" 문자열 전송
						sendMessage("OK", null);	// "<<<OK>>>"
						break;
					} else {
						// 가능 하지 않다면 "NOT_OK" 문자열 전송
						sendMessage("NOT_OK", null);
						// 다시 대화명 수신하도록
					}
				}
				
				// 이 클라이언트의 nick을 알 수 있는 최초 지점
				// 모든 클라이언트에게 xxx가 접속했습니다. 메시지 송신
				synchronized (clients) {
					// 모든 클라이언트에 메시지 송신
					Iterator<ChatThread> iter = clients.iterator();
					while (iter.hasNext()) {
						ChatThread t = iter.next();
						if (t == this) {	// 본인에게는 접속 메시지 알리지 않음
							continue;
						}
						t.sendMessage(nick + "님이 접속하였습니다.", null);
					}
				}
				
				while (true) {
					// 클라이언트가 보낸 메시지 수신
					String msg = reader.readLine();
					
					// 화면에 출력
					System.out.println(msg);
					
					synchronized (clients) {
						// 모든 클라이언트에 메시지 송신
						Iterator<ChatThread> iter = clients.iterator();
						while (iter.hasNext()) {
							ChatThread t = iter.next();
							// t 객체에게 메시지 송신 시킴
							t.sendMessage(msg, this);
						}
					}
				}
			} catch (IOException e) {
				// 접속 끊김 등의 예외 발생한 경우
				// IOException이 발생하며 while문 빠져나와 이곳에 도달
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
	
	// 중복 대화명 체크
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
	
	// 접속된 클라이언트 목록
	static List<ChatThread> clients = new ArrayList<ChatThread>();
	
	public static void main(String[] args) {
		
		ServerSocket ss = null;
		
		try {
			ss = new ServerSocket(3000);
			System.out.println("서버를 시작합니다.");
			while (true) {
				Socket sock = ss.accept();
				
				// 연결요청이 수락되어 연결이 수립되면 이 곳으로 넘어옴
				try {
					// sock 객체를 통해 Chat 기능을 처리할 수 있는 별도의 스레드를 만들고
					ChatThread t = new ChatThread(sock);
					
					synchronized (clients) {	// clients는 여러 스레드가 사용하는 공유 자원
						// 접속된 클라이언트 목록에 ChatThread 추가
						clients.add(t);
					}
					
					// start()
					t.start();
				} catch (IOException e) {
					// (3) new EchoThread 과정에서 IOException 발생한 경우
					// => 해당 클라이언트 무시하고 다음 클라이언트를 accept할 수 있도록 넘어감
				}
			}
		} catch (IOException e) {
			// (1) new ServerSocket 과정에서 IOException 발생한 경우
			// (2) accept() 도중 IOException 발생한 경우
		} finally {
			System.out.println("서버를 종료합니다.");
			try {
				ss.close();
			} catch (IOException e) {}
		}
		
	}
	
}
