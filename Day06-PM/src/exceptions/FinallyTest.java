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
			
			System.out.println(filePath + " 파일의 크기: " + count + " 바이트");
			
			
		} catch (FileNotFoundException e) {
			
			System.err.println(filePath + " 파일이 존재하지 않습니다.");
		
		} catch (IOException e) {
			
			System.err.println("IOException 발생");
			e.printStackTrace();
		
		} finally {
			
			if (in != null) {
				try {
					in.close();	// FileInputStream 객체 닫기 시도
				} catch (IOException e) {
					// 이 Exception은 어찌할 방법이 없네..
				}
			}
			
			System.out.println("여기는 finally~!!");
			
		}
		
	}
	
}
