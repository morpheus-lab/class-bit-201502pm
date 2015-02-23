package file;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class M {
	
	static File[] drives = File.listRoots();
	
	static void printFileList(File dir) throws IOException {
		
		dir = dir.getCanonicalFile();
		
		System.out.println("=================================================");
		System.out.println("[현재 경로] " + dir.getAbsolutePath());
		System.out.println("-------------------------------------------------");
		// 드라이브 출력
		drives = File.listRoots();
		for (int i = 0; i < drives.length; i++) {
			System.out.print("[D" + (i + 1) + "] " + drives[i].getAbsolutePath() + "\t");
		}
		System.out.println();
		
		if (dir != null && dir.isDirectory()) {
			
			// 상위 디렉토리가 존재하면 "..\\"을 출력
			File parentDir = dir.getParentFile();
			if (parentDir != null) {
				System.out.println("[0] ..\\");
			}
			
			File[] files = dir.listFiles();	// 하위 디렉토리 및 파일의 이름 반환
			for (int i = 0; i < files.length; i++) {
				if (files[i].isHidden()) {
					continue;	// 숨김 파일인 경우 건너뜀
				}
				
				String suffix = "";
				if (files[i].isDirectory()) {
					suffix = "\\";
				}
				System.out.print("[" + (i + 1) + "] " + files[i].getName() + suffix);
				if (files[i].isFile()) {
					System.out.print("\t" + printFileLength(files[i]));
				}
				System.out.println();
			}
		}
		System.out.println("=================================================");

	}
	
	static String printFileLength(File file) {
		if (file != null && file.isFile()) {
			long bytes = file.length();
			if (bytes < 1024) {
				return String.format("%d B", bytes);
			} else if (bytes < Math.pow(1024, 2)) {
				return String.format("%.2f kB", ((double) bytes / 1024));
			} else if (bytes < Math.pow(1024, 3)) {
				return String.format("%.2f MB", (bytes / Math.pow(1024, 2)));
			} else {
				return String.format("%.2f GB", (bytes / Math.pow(1024, 3)));
			}
		}
		return null;
	}
	
	static File changeDir(File currentDir, int index) throws IOException {
		currentDir = currentDir.getCanonicalFile();
		
		if (index == 0) {
			// 상위 디렉토리로 이동
			if (currentDir.getParentFile() != null) {
				printFileList(currentDir.getParentFile());	// 상위 디렉토리의 내용 출력
				return currentDir.getParentFile();
			}
		}
		else if (index > 0) {
			File[] subDirs = currentDir.listFiles();
			
			if (subDirs == null) {
				return null;
			}
			
			// 선택한 번호의 디렉토리로 이동
			File dirToMove = subDirs[index - 1];
			
			// 숨김 파일이면 이동하지 못하도록
			if (dirToMove.isHidden()) {
				return null;
			}
			
			if (dirToMove.isDirectory()) {
				printFileList(dirToMove);
				return dirToMove;
			}
		}
		return null;	// 이동되지 않았음
	}
	
	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		File currentDir = new File(".");	// 상대경로 표기에서 "."은 현재 디렉토리
											// ".."은 상위 디렉토리
		printFileList(currentDir);
		
		while (true) {
			System.out.print("선택: ");
			String input = sc.nextLine();
			
			if (input.toUpperCase().startsWith("D")) {
				// 드라이브 변경
				try {
					int index = Integer.parseInt(input.substring(1));	// 두 번째 문자부터 끝까지
					File drive = drives[index - 1];
					currentDir = drive;
					printFileList(currentDir);
				} catch (NumberFormatException e) {
					// Integer.parseInt 중에 예외 발생한 경우
					System.out.println("드라이브 인덱스를 정확히 입력하세요.");
				} catch (ArrayIndexOutOfBoundsException e) {
					// drives 배열 접근 중 예외 발생한 경우
					System.out.println("드라이브 인덱스를 정확히 입력하세요.");
				}
			} else {
				try {
					int index = Integer.parseInt(input);
					if (index == -1) {
						break;
					}
					
					File changedDir = changeDir(currentDir, index);	// ArrayIndexOutOfBoundsException이 발생한다면,
																	// 잘못된 번호를 입력한 경우
					
					if (changedDir != null) {	// 디렉토리 이동이 발생
						currentDir = changedDir;
					} else {
						// changedDir == null인 경우는, 디렉토리가 아닌 경우
						System.out.println("디렉토리로만 이동할 수 있습니다.");
					}
				} catch (ArrayIndexOutOfBoundsException e) {
					System.out.println("잘못 입력하셨습니다.");
				} catch (NumberFormatException e) {
					System.out.println("잘못 입력하셨습니다.");
				}
			}
		}
		
		
		
		
		sc.close();
		
	}
	
}
































