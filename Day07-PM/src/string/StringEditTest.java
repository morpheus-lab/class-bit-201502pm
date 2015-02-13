package string;

public class StringEditTest {
	
	public static void main(String[] args) {
		
		String str = "Hello, everybody. Java is one of powerful programming languages.";
		
//		System.out.println(str.length());
		
		// charAt(int index)
		char c = str.charAt(0);
		System.out.println(c);
		
		c = str.charAt(2);
		System.out.println(c);
		
		c = str.charAt(4);
		System.out.println(c);
		
		// substring(int beginIndex, int endIndex) => beginIndex 부터 endIndex - 1 까지의 부분 문자열
		//										   => substring에 의해서 추출되는 부분 문자열의 길이: (endIndex - beginIndex)
		String partial = str.substring(10, 15);	// StringIndexOutOfBoundsException 발생될 수 있음
		System.out.println(partial);
		
		// trim() => 첫 번째 공백이 아닌 문자의 앞, 마지막 공백이 아닌 문자의 뒤에 있는 공백 문자(space, line feed, tab, ...)들을 제거
		str = "   Hello Java 	\n         ";
		System.out.println("'" + str.trim() + "'");
		
		str = str.trim();
		// toUpperCase()	=> 모든 문자를 대문자로
		// toLowerCase()	=> 모든 문자를 소문자로
		System.out.println("toUpperCase(): " + str.toUpperCase());
		System.out.println("toLowerCase(): " + str.toLowerCase());
		
		// replace(char oldChar, char newChar)	=> oldChar 문자를 newChar 문자로 치환
		System.out.println(str.replace('a', 'u'));
		
		
		
		// 문자열 탐색 메소드
		
		// startsWith(String prefix)	=> prefix 문자열로 시작되는 문자열인지 여부
		System.out.println("str.startsWith() : " + str.startsWith("Ho"));
		
		// endsWith(String suffix)	=> suffix 문자열로 끝나는 문자열인지 여부
		System.out.println("str.endsWith() : " + str.endsWith("java"));
		
		// 대소문자 구분없이 특정 문자열로 시작되는지 검사를 하려면?
		System.out.println("\"HEL\"로 시작? (대소문자 구분X) : " + str.toUpperCase().startsWith("HEL"));
		
		// indexOf(int ch)	=> ch 문자가 처음으로 발견되는 곳의 인덱스를 리턴
		// Hello Java
		System.out.println("str.indexOf('a') : " + str.indexOf('a'));
		
		// lastIndexOf(int ch)	=>
		System.out.println("str.lastIndexOf('a') : " + str.lastIndexOf('a'));
		
	}
	
}



























