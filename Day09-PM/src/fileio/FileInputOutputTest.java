package fileio;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileInputOutputTest {
	
	public static void main(String[] args) {
		
		InputStream in = null;
		OutputStream out = null;
		
		try {
			in = new FileInputStream("D:\\input.txt");
			out = new FileOutputStream("D:\\output.txt");
			
			in = new BufferedInputStream(in);	// 파일 입력 스트림 + 버퍼
			out = new BufferedOutputStream(out);	// 파일 출력 스트림 + 버퍼
			
			int b = 0;	// 데이터 임시 저장
			
			while ((b = in.read()) != -1) {	// InputStream으로부터 1바이트 읽어서 b에 저장
				out.write(b);	// OutputStream에 b에 저장된 데이터 쓰기
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {}
			}
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {}
			}
		}
		
	}
	
}
