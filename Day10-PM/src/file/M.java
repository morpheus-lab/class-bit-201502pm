package file;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class M {
	
	static File[] drives = File.listRoots();
	
	static void printFileList(File dir) throws IOException {
		
		dir = dir.getCanonicalFile();
		
		System.out.println("=================================================");
		System.out.println("[���� ���] " + dir.getAbsolutePath());
		System.out.println("-------------------------------------------------");
		// ����̺� ���
		drives = File.listRoots();
		for (int i = 0; i < drives.length; i++) {
			System.out.print("[D" + (i + 1) + "] " + drives[i].getAbsolutePath() + "\t");
		}
		System.out.println();
		
		if (dir != null && dir.isDirectory()) {
			
			// ���� ���丮�� �����ϸ� "..\\"�� ���
			File parentDir = dir.getParentFile();
			if (parentDir != null) {
				System.out.println("[0] ..\\");
			}
			
			File[] files = dir.listFiles();	// ���� ���丮 �� ������ �̸� ��ȯ
			for (int i = 0; i < files.length; i++) {
				if (files[i].isHidden()) {
					continue;	// ���� ������ ��� �ǳʶ�
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
			// ���� ���丮�� �̵�
			if (currentDir.getParentFile() != null) {
				printFileList(currentDir.getParentFile());	// ���� ���丮�� ���� ���
				return currentDir.getParentFile();
			}
		}
		else if (index > 0) {
			File[] subDirs = currentDir.listFiles();
			
			if (subDirs == null) {
				return null;
			}
			
			// ������ ��ȣ�� ���丮�� �̵�
			File dirToMove = subDirs[index - 1];
			
			// ���� �����̸� �̵����� ���ϵ���
			if (dirToMove.isHidden()) {
				return null;
			}
			
			if (dirToMove.isDirectory()) {
				printFileList(dirToMove);
				return dirToMove;
			}
		}
		return null;	// �̵����� �ʾ���
	}
	
	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		File currentDir = new File(".");	// ����� ǥ�⿡�� "."�� ���� ���丮
											// ".."�� ���� ���丮
		printFileList(currentDir);
		
		while (true) {
			System.out.print("����: ");
			String input = sc.nextLine();
			
			if (input.toUpperCase().startsWith("D")) {
				// ����̺� ����
				try {
					int index = Integer.parseInt(input.substring(1));	// �� ��° ���ں��� ������
					File drive = drives[index - 1];
					currentDir = drive;
					printFileList(currentDir);
				} catch (NumberFormatException e) {
					// Integer.parseInt �߿� ���� �߻��� ���
					System.out.println("����̺� �ε����� ��Ȯ�� �Է��ϼ���.");
				} catch (ArrayIndexOutOfBoundsException e) {
					// drives �迭 ���� �� ���� �߻��� ���
					System.out.println("����̺� �ε����� ��Ȯ�� �Է��ϼ���.");
				}
			} else {
				try {
					int index = Integer.parseInt(input);
					if (index == -1) {
						break;
					}
					
					File changedDir = changeDir(currentDir, index);	// ArrayIndexOutOfBoundsException�� �߻��Ѵٸ�,
																	// �߸��� ��ȣ�� �Է��� ���
					
					if (changedDir != null) {	// ���丮 �̵��� �߻�
						currentDir = changedDir;
					} else {
						// changedDir == null�� ����, ���丮�� �ƴ� ���
						System.out.println("���丮�θ� �̵��� �� �ֽ��ϴ�.");
					}
				} catch (ArrayIndexOutOfBoundsException e) {
					System.out.println("�߸� �Է��ϼ̽��ϴ�.");
				} catch (NumberFormatException e) {
					System.out.println("�߸� �Է��ϼ̽��ϴ�.");
				}
			}
		}
		
		
		
		
		sc.close();
		
	}
	
}
































