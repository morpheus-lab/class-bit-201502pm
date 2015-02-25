package network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class SocketTest {
	
	public static void main(String[] args) throws Exception {
		Socket sock = new Socket("121.138.83.1", 3000);
		
		// sock 객체가 정상적으로 생성이 되면
		
		// 입/출력 스트림 객체 얻기
		OutputStream out = sock.getOutputStream();
		InputStream in = sock.getInputStream();
		
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		
		// 사용자로부터 입력 받기 위한 Scanner 객체
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			System.out.print("보낼 메시지: ");
			String msg = sc.nextLine();
			
			// 서버로 메시지 전송
			writer.write(msg + "\n");
			// 버퍼가 가득차지 않아도 강제 송신
			writer.flush();	// 버퍼에 있던 내용이 바로 송신
			
			// 서버로부터 메시지 수신
			msg = reader.readLine();
			// 화면에 수신 메시지 출력
			System.out.println("수신: " + msg);
		}
		
	}
	
}
















