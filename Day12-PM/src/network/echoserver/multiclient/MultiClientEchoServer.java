package network.echoserver.multiclient;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiClientEchoServer {
	
	static class EchoThread extends Thread {	// 클라이언트 마다 이 스레드 객체 생성되고
												// 그 클라이언트의 메시지를 처리
		Socket sock = null;
		BufferedReader reader = null;
		BufferedWriter writer = null;
		
		public EchoThread(Socket sock) throws IOException {
			this.sock = sock;
			reader = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			writer = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()));
		}
		
		@Override
		public void run() {
			try {
				while (true) {
					// 메시지 수신
					String msg = reader.readLine();
					// 화면에 출력
					System.out.println(msg);
					// 메시지 그대로 다시 송신
					writer.write(msg + "\n");
					writer.flush();
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
			}
		}
		
	}
	
	public static void main(String[] args) {
		
		ServerSocket ss = null;
		
		try {
			ss = new ServerSocket(3000);
			System.out.println("서버를 시작합니다.");
			while (true) {
				Socket sock = ss.accept();
				
				// 연결요청이 수락되어 연결이 수립되면 이 곳으로 넘어옴
				try {
					// sock 객체를 통해 Echo 기능을 처리할 수 있는 별도의 스레드를 만들고
					EchoThread t = new EchoThread(sock);
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
