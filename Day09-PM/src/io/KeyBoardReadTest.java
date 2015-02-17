package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class KeyBoardReadTest {
	
	public static void main(String[] args) {
		
		InputStream in = System.in;	// Ű���带 ���� �ԷµǴ� �����͸� �о� ���� �� �ִ�
									// �⺻ InputStream (Byte Stream)
		
		InputStreamReader reader = new InputStreamReader(in);	// in ��ü�� ���� ���� �б� ��� �߰�
		
		BufferedReader bReader = new BufferedReader(reader);	// reader ��ü�� ���۸� �߰��ؼ� �� ������ ���� �б� ��� �߰�
		
		try {
			while (true) {
				System.out.println("���ڿ��� �Է��ϼ���.");
				String s = bReader.readLine();
				System.out.println(s);
				
				if (s.equals("/quit")) {
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bReader != null) {
				try {
					bReader.close();
				} catch (IOException e) {}
			}
		}
		
	}
	
}
