package exceptions;

public class ExceptionTest {
	
	public void m(int i) {
		int j = 99 / i;
		System.out.println("99�� " + i + "�� ���� ���� " + j);
	}
	
	// java ExceptionTest<enter>
	// args = new String[0];
	
	public static void main(String[] args) {
		
		int i = -1;
		
		try {
			
			i = Integer.parseInt("hello");
			// ArrayIndexOutOfBoundsException �߻��� ���� ����
			// NumberFormatException �߻��� ���� ����
			
		} catch (ArrayIndexOutOfBoundsException e) {
			
			String message = e.getMessage();
			System.out.println("EXCEPTION �߻�!!! - �޽���: " + message);
			
		} /*catch (NumberFormatException e) {
			
			System.out.println("���� ������ �ƴϳ׿�.");
			
			e.printStackTrace();
			
		} catch (Exception e) {
			
			// ��� Exception�� ó����
			
		}*/
		
		
		ExceptionTest et = new ExceptionTest();
		
		try {
			et.m(i);
		} catch (ArithmeticException e) {
			
		}
		
		System.out.println("main �޼ҵ� ��~");
		
	}
	
}
