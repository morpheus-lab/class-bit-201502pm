package string;

public class StringBufferTest {
	
	public static void main(String[] args) {
		
		String s = "abc";
		s += "d";	// String 객체 새로 만듦
		s += "e";	// String 객체 새로 만듦
		s += "f";	// String 객체 새로 만듦
		s += "g";	// String 객체 새로 만듦
		// ...
		
		// String에 문자열을 붙여나가는 것보다 효율적인 방법으로
		// 문자열들을 이어 나감
		
		StringBuffer sb = new StringBuffer("abc");
		
		sb.append("d");	// 내부저장소에 문자 데이터 추가
		sb.append("e");	// 내부저장소에 문자 데이터 추가
		sb.append("f");	// 내부저장소에 문자 데이터 추가
		sb.append("g");	// 내부저장소에 문자 데이터 추가
		sb.append("h").append("i");
		// ...
		
		String str = sb.toString();	// String 객체 새로 만듦
		
		
		
		StringBuilder sBuilder = new StringBuilder("abc");
		// StringBuffer와 거의 동일한 기능을 하는 클래스
		// Java 1.5에서 처음 등장
		
		
	}
	
}
