package network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketTest {
	
	public static void main(String[] args) throws IOException {
		
		ServerSocket ss = new ServerSocket(3000);
		
		Socket sock = ss.accept();	// 연결 요청을 대기하고 있다가
									// 상대방 소켓과 연결되는 소켓 객체 생성해서 리턴
		
		// sock 객체는 상대방과 연결된 소켓 객체
		
		InputStream in = sock.getInputStream();
		OutputStream out = sock.getOutputStream();
		
//		in = new BufferedInputStream(in);
//		out = new BufferedOutputStream(out);
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
		
		while (true) {
			String line = reader.readLine();	// 클라이언트가 보내는 문자열을 읽음
			System.out.println("수신메시지: " + line);			// 클라이언트가 보낸 문자열을 화면에 출력
			writer.write(line + "\n");			// 클라이언트가 보낸 문자열을 그대로 클라이언트에게 전송
			writer.flush();	// 강제 송신 (버퍼가 가득차지 않았더라도)
		}
	}
	
}
