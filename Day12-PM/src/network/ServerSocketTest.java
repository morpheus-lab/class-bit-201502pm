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
		
		Socket sock = ss.accept();	// ���� ��û�� ����ϰ� �ִٰ�
									// ���� ���ϰ� ����Ǵ� ���� ��ü �����ؼ� ����
		
		// sock ��ü�� ����� ����� ���� ��ü
		
		InputStream in = sock.getInputStream();
		OutputStream out = sock.getOutputStream();
		
//		in = new BufferedInputStream(in);
//		out = new BufferedOutputStream(out);
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
		
		while (true) {
			String line = reader.readLine();	// Ŭ���̾�Ʈ�� ������ ���ڿ��� ����
			System.out.println("���Ÿ޽���: " + line);			// Ŭ���̾�Ʈ�� ���� ���ڿ��� ȭ�鿡 ���
			writer.write(line + "\n");			// Ŭ���̾�Ʈ�� ���� ���ڿ��� �״�� Ŭ���̾�Ʈ���� ����
			writer.flush();	// ���� �۽� (���۰� �������� �ʾҴ���)
		}
	}
	
}
