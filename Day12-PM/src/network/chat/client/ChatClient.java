package network.chat.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
	
	static class MsgReceiver extends Thread {
		
		BufferedReader reader = null;
		boolean flag = true;
		
		public MsgReceiver(BufferedReader reader) {
			this.reader = reader;
		}
		
		@Override
		public void run() {
			while (flag) {
				try {
					// 서버로부터 메시지 수신
					String msg = reader.readLine();
					// 화면에 출력
					System.out.println(msg);
				} catch (IOException e) {
					flag = false;
				}
			}
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		// 사용자로부터 입력 받기 위한 Scanner 객체
		Scanner sc = new Scanner(System.in);
		
		System.out.print("사용할 대화명: ");
		String nick = sc.nextLine();
		
		Socket sock = new Socket("121.138.83.1", 3000);
		
		// sock 객체가 정상적으로 생성이 되면
		
		// 입/출력 스트림 객체 얻기
		OutputStream out = sock.getOutputStream();
		InputStream in = sock.getInputStream();
		
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		
		// 대화명 설정
		writer.write(nick + "\n");
		writer.flush();
		
		MsgReceiver receiver = new MsgReceiver(reader);
		receiver.start();	// 메시지 수신 시작
		
		while (true) {
//			System.out.print("보낼 메시지: ");
			String msg = sc.nextLine();
			
			// 서버로 메시지 전송
			writer.write(msg + "\n");
			// 버퍼가 가득차지 않아도 강제 송신
			writer.flush();	// 버퍼에 있던 내용이 바로 송신
		}
		
	}
	
}
















