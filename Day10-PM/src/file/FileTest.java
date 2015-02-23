package file;

import java.io.File;
import java.net.URI;

public class FileTest {
	
	public static void main(String[] args) throws Exception {
		
		// File 생성자
		File f1 = new File("D:\\temp");
		File f2 = new File("D:\\temp", "input2.txt");
		File f3 = new File(f1, "input2.txt");
		File f4 = new File(new URI("file:///D:/temp"));
		File f5 = new File("input2.txt");	// 프로그램을 실행하는 곳으로부터의 상대경로
		
		// getAbsolutePath() : 파일의 절대 경로
		System.out.println(f1.getAbsolutePath());
		System.out.println(f2.getAbsolutePath());
		System.out.println(f3.getAbsolutePath());
		System.out.println(f4.getAbsolutePath());
		System.out.println(f5.getAbsolutePath());
		
		System.out.println(f2.canExecute());	// 파일을 실행할 권한 조회
		System.out.println(f2.canRead());		// 파일을 읽을 권한 조회
		System.out.println(f2.canWrite());		// 파일을 쓸 권한 조회
		
		System.out.println("Free Space: " + f1.getFreeSpace());
		
		
		File dirA = new File(f1, "a");
		if (!dirA.exists()) {
			boolean created = dirA.mkdir();	// mkdir: make directory 명령
			System.out.println(dirA.getAbsolutePath() + " 디렉토리 생성");
			System.out.println(created);	// mkdir() 결과 - 성공: true, 실패: false
		}
			
		File dirB2 = new File(f1, "b\\b1\\b2");
		if (!dirB2.exists()) {
			boolean created = dirB2.mkdirs();
			System.out.print(dirB2.getAbsolutePath() + " 디렉토리 생성 ");
			System.out.println(created ? "성공" : "실패");
		}
		
		// 새 파일 만들기
		File aFile = new File(f1, "a.txt");	// 만들 파일명으로 파일 객체 생성
		if (!aFile.exists()) {
			boolean created = aFile.createNewFile();
			System.out.print(aFile.getAbsolutePath() + " 파일 생성 ");
			System.out.println(created ? "성공" : "실패");
		}
	}
	
}





















