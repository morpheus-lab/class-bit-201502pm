package exceptions;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class ThrowTest {
	
	public int factorial(int a) throws Exception {	// throws: 예외를 내가 처리하지 않고
											//		   나를 호출한 곳으로
											//		   던져버리겠음을 선언
		
		if (a < 0) {
			// Exception 발생시킴
			throw new Exception("음의 정수에 대한 계승은 정의되어 있지 않음");
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
		
		// Class 클래스 활용
		Class c = t.getClass();
		System.out.println("t 객체의 클래스 이름: " + c.getName());
		
		// t 객체의 멤버 메소드 정보
		System.out.println("t 객체의 메소드: ");
		
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




























