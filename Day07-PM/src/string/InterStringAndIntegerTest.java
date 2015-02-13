package string;

import java.util.ArrayList;

public class InterStringAndIntegerTest {
	
	public static void main(String[] args) {
		
		// String -> Integer (Wrapper Class)
		Integer i1 = new Integer("01246");
		System.out.println("new Integer(\"01246\") : " + i1);
		
		Integer i2 = Integer.valueOf("134547");
		System.out.println("Integer.valueOf(\"134547\") : " + i2);
		
		Integer i3 = Integer.valueOf("10", 10);
		System.out.println("Integer.valueOf(\"10\", 10) : " + i3);
		
		i3 = Integer.valueOf("10", 16);
		System.out.println("Integer.valueOf(\"10\", 16) : " + i3);
		
		// ArrayList => Object 타입의 객체를 저장할 수 있는 리스트
//		ArrayList list = new ArrayList();
//		list.add((int) 1);
//		list.add(new Integer(1));
		
		// Integer -> String
		String s1 = i1.toString();
		System.out.println("s1 : " + s1);
		
		String s2 = String.valueOf(i2);
		System.out.println("s2 : " + s2);
		
		
		
		// String -> int
		int i4 = Integer.parseInt("36");
		int i5 = Integer.parseInt("10101", 2);
		
		// int -> String
		String s3 = Integer.toString(48);
		String s4 = Integer.toString(44, 8);
		
	}
	
}
























