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
			
			in = new BufferedInputStream(in);	// ���� �Է� ��Ʈ�� + ����
			out = new BufferedOutputStream(out);	// ���� ��� ��Ʈ�� + ����
			
			int b = 0;	// ������ �ӽ� ����
			
			while ((b = in.read()) != -1) {	// InputStream���κ��� 1����Ʈ �о b�� ����
				out.write(b);	// OutputStream�� b�� ����� ������ ����
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
