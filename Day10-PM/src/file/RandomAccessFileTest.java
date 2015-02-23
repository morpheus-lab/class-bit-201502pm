package file;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileTest {
	
	public static void main(String[] args) throws IOException {
		String s = "I love normal java";
		String q = "jabook";
		
		RandomAccessFile rf = new RandomAccessFile("D:\\temp\\raccess.txt", "rw");
		rf.writeBytes(s);
		rf.close();
		
		RandomAccessFile rf2 = new RandomAccessFile("D:\\temp\\raccess.txt", "rw");
		rf2.seek(7);	// 파일의 첫 부분으로부터 7바이트 뒤로 커서를 이동
		rf2.writeBytes(q);
		rf2.close();
		
		RandomAccessFile rf3 = new RandomAccessFile("D:\\temp\\raccess.txt", "r");
		System.out.println(rf3.readLine());
		rf3.close();
		
	}
	
}
