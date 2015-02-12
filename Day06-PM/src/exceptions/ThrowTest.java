package exceptions;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class ThrowTest {
	
	public int factorial(int a) throws Exception {	// throws: ���ܸ� ���� ó������ �ʰ�
											//		   ���� ȣ���� ������
											//		   �������������� ����
		
		if (a < 0) {
			// Exception �߻���Ŵ
			throw new Exception("���� ������ ���� ����� ���ǵǾ� ���� ����");
		}
		
		int f = 1;
		
		if (a == 0) {
			
		} else if(a > 0) {
			for (int i = a; i > 0; i--) {
				f *= i;
			}
		}
		
		return f;
	}
	
	public static void main(String[] args) {
		
		ThrowTest t = new ThrowTest();
		
		try {
			System.out.println(t.factorial(3));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(t.toString());
		
		Object o = new Object();
		
		System.out.println(o.toString());
		
		// Class Ŭ���� Ȱ��
		Class c = t.getClass();
		System.out.println("t ��ü�� Ŭ���� �̸�: " + c.getName());
		
		// t ��ü�� ��� �޼ҵ� ����
		System.out.println("t ��ü�� �޼ҵ�: ");
		
		Method[] methods = c.getMethods();
		for (int i = 0; i < methods.length; i++) {
			System.out.println("\t" + methods[i].getName());
			Parameter[] params = methods[i].getParameters();
			for (int j = 0; j < params.length; j++) {
				System.out.println("\t\t" + params[j].getName() + " : " + params[j].getType());
			}
		}
		
	}
	
}




























