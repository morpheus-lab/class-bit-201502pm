package utils;

import java.util.StringTokenizer;

public class StringTokenizerTest {
	
	public static void main(String[] args) {
		
		String str = "hello;hi;have a nice day";
		
//		StringTokenizer st = new StringTokenizer(str);	// ���� ���ڸ� �������� �ڸ�
//		StringTokenizer st = new StringTokenizer(str, ";");	// �� ��° ���� ���ڿ��� �������� �ڸ�
		StringTokenizer st = new StringTokenizer(str, ";ah", false);	// �� ��° ����: ���й��ڵ� ��ū���� ���� ������?
		
		// �� ��° ������ delimiter ���ڿ��� �̷�� ���� �ϳ��ϳ��� �����ڰ� ��
		
		while (st.hasMoreTokens()) {	// �Ǵ� st1.hasMoreElements()
			
			String token = st.nextToken();	// �Ǵ� st1.nextElement()
//			Object token = st.nextElement();
			
			// token �̿�
			System.out.println(token);
			
		}
		
	}
	
}
