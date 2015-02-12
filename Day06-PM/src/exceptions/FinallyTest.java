package exceptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FinallyTest {
	
	public static void main(String[] args) {
		
		FileInputStream in = null;
		
		String filePath = "D:\\java.png";
		
		try {
			in = new FileInputStream(filePath);
			int count = 0;
			int len = 0;
			byte[] buffer = new byte[4];
			
			while ((len = in.read(buffer)) != -1) {
				count += len;
			}
			
			System.out.println(filePath + " ������ ũ��: " + count + " ����Ʈ");
			
			
		} catch (FileNotFoundException e) {
			
			System.err.println(filePath + " ������ �������� �ʽ��ϴ�.");
		
		} catch (IOException e) {
			
			System.err.println("IOException �߻�");
			e.printStackTrace();
		
		} finally {
			
			if (in != null) {
				try {
					in.close();	// FileInputStream ��ü �ݱ� �õ�
				} catch (IOException e) {
					// �� Exception�� ������ ����� ����..
				}
			}
			
			System.out.println("����� finally~!!");
			
		}
		
	}
	
}
