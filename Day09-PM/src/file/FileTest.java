package file;

import java.io.File;

public class FileTest {
	
	public static void main(String[] args) {
		
		File file = new File("D:\\temp");
		
//		System.out.println(file.exists());
		
//		System.out.println(file.isFile());
		
//		System.out.println(file.isDirectory());
		
		if (file.isDirectory()) {
			
			// 하위에 있는 파일 리스트
			
			File[] subFiles = file.listFiles();
			if (subFiles != null) {
				for (int i = 0; i < subFiles.length; i++) {
					
					File subFile = subFiles[i];
					if (subFile.isDirectory()) {
						System.out.print("[D] ");
					}
					System.out.println(subFile.getName());
					
				}
			}
			
		}
		
	}
	
}
