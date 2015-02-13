package string;

public class StringTest {
	
	public static void main(String[] args) {
		
		// String 객체에 "+" 연산자로 문자열을 추가한 경우
		
		String s = "hello";
		
		String oldS = s;
		
		String newS = s + ", java";	// "hello, java"
		
		System.out.println(oldS == newS);	// 참조값 비교
		
		
		
		// String 객체를 생성하는 방법
		
		String s1 = "hi";
		
		String s2 = "hi";
		
		System.out.println("s1 == s2: " + (s1 == s2));
		
		String s3 = new String("hello");
		String s4 = new String("hello");
		
		System.out.println("s3 == s4: " + (s3 == s4));
		
		// length()
		System.out.println("s1.length() : " + s1.length());
		System.out.println("s3.length() : " + s3.length());
		
		// 문자열 비교
		String str1 = new String("TGIF");
		String str2 = new String("Thanks God, It's Friday");
		String str3 = new String("ThaThankan, It's Thursday");
		
		System.out.println("str1.equals(str2): " + str1.equals(str2));
		System.out.println("str1.equalsIgnoreCase(str2): " + str1.equalsIgnoreCase(str2));
		System.out.println("str2.compareTo(str3): " + str2.compareTo(str3));
		
		System.out.println(str2.regionMatches(true, 0, str3, 3, 5));
		
	}
	
}


























