package string;

public class StringBufferTest {
	
	public static void main(String[] args) {
		
		String s = "abc";
		s += "d";	// String ��ü ���� ����
		s += "e";	// String ��ü ���� ����
		s += "f";	// String ��ü ���� ����
		s += "g";	// String ��ü ���� ����
		// ...
		
		// String�� ���ڿ��� �ٿ������� �ͺ��� ȿ������ �������
		// ���ڿ����� �̾� ����
		
		StringBuffer sb = new StringBuffer("abc");
		
		sb.append("d");	// ��������ҿ� ���� ������ �߰�
		sb.append("e");	// ��������ҿ� ���� ������ �߰�
		sb.append("f");	// ��������ҿ� ���� ������ �߰�
		sb.append("g");	// ��������ҿ� ���� ������ �߰�
		sb.append("h").append("i");
		// ...
		
		String str = sb.toString();	// String ��ü ���� ����
		
		
		
		StringBuilder sBuilder = new StringBuilder("abc");
		// StringBuffer�� ���� ������ ����� �ϴ� Ŭ����
		// Java 1.5���� ó�� ����
		
		
	}
	
}
