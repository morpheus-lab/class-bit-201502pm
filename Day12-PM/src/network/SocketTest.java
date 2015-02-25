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
		
		// sock ��ü�� ���������� ������ �Ǹ�
		
		// ��/��� ��Ʈ�� ��ü ���
		OutputStream out = sock.getOutputStream();
		InputStream in = sock.getInputStream();
		
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		
		// ����ڷκ��� �Է� �ޱ� ���� Scanner ��ü
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			System.out.print("���� �޽���: ");
			String msg = sc.nextLine();
			
			// ������ �޽��� ����
			writer.write(msg + "\n");
			// ���۰� �������� �ʾƵ� ���� �۽�
			writer.flush();	// ���ۿ� �ִ� ������ �ٷ� �۽�
			
			// �����κ��� �޽��� ����
			msg = reader.readLine();
			// ȭ�鿡 ���� �޽��� ���
			System.out.println("����: " + msg);
		}
		
	}
	
}
















