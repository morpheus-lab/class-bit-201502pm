package file;

import java.io.File;
import java.net.URI;

public class FileTest {
	
	public static void main(String[] args) throws Exception {
		
		// File ������
		File f1 = new File("D:\\temp");
		File f2 = new File("D:\\temp", "input2.txt");
		File f3 = new File(f1, "input2.txt");
		File f4 = new File(new URI("file:///D:/temp"));
		File f5 = new File("input2.txt");	// ���α׷��� �����ϴ� �����κ����� �����
		
		// getAbsolutePath() : ������ ���� ���
		System.out.println(f1.getAbsolutePath());
		System.out.println(f2.getAbsolutePath());
		System.out.println(f3.getAbsolutePath());
		System.out.println(f4.getAbsolutePath());
		System.out.println(f5.getAbsolutePath());
		
		System.out.println(f2.canExecute());	// ������ ������ ���� ��ȸ
		System.out.println(f2.canRead());		// ������ ���� ���� ��ȸ
		System.out.println(f2.canWrite());		// ������ �� ���� ��ȸ
		
		System.out.println("Free Space: " + f1.getFreeSpace());
		
		
		File dirA = new File(f1, "a");
		if (!dirA.exists()) {
			boolean created = dirA.mkdir();	// mkdir: make directory ���
			System.out.println(dirA.getAbsolutePath() + " ���丮 ����");
			System.out.println(created);	// mkdir() ��� - ����: true, ����: false
		}
			
		File dirB2 = new File(f1, "b\\b1\\b2");
		if (!dirB2.exists()) {
			boolean created = dirB2.mkdirs();
			System.out.print(dirB2.getAbsolutePath() + " ���丮 ���� ");
			System.out.println(created ? "����" : "����");
		}
		
		// �� ���� �����
		File aFile = new File(f1, "a.txt");	// ���� ���ϸ����� ���� ��ü ����
		if (!aFile.exists()) {
			boolean created = aFile.createNewFile();
			System.out.print(aFile.getAbsolutePath() + " ���� ���� ");
			System.out.println(created ? "����" : "����");
		}
	}
	
}





















