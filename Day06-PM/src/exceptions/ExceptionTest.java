package exceptions;

public class ExceptionTest {
	
	public void m(int i) {
		int j = 99 / i;
		System.out.println("99를 " + i + "로 나눈 몫은 " + j);
	}
	
	// java ExceptionTest<enter>
	// args = new String[0];
	
	public static void main(String[] args) {
		
		int i = -1;
		
		try {
			
			i = Integer.parseInt("hello");
			// ArrayIndexOutOfBoundsException 발생할 수도 있음
			// NumberFormatException 발생할 수도 있음
			
		} catch (ArrayIndexOutOfBoundsException e) {
			
			String message = e.getMessage();
			System.out.println("EXCEPTION 발생!!! - 메시지: " + message);
			
		} /*catch (NumberFormatException e) {
			
			System.out.println("숫자 형식이 아니네요.");
			
			e.printStackTrace();
			
		} catch (Exception e) {
			
			// 모든 Exception이 처리됨
			
		}*/
		
		
		ExceptionTest et = new ExceptionTest();
		
		try {
			et.m(i);
		} catch (ArithmeticException e) {
			
		}
		
		System.out.println("main 메소드 끝~");
		
	}
	
}
