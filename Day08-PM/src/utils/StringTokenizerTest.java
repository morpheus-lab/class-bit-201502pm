package utils;

import java.util.StringTokenizer;

public class StringTokenizerTest {
	
	public static void main(String[] args) {
		
		String str = "hello;hi;have a nice day";
		
//		StringTokenizer st = new StringTokenizer(str);	// 공백 문자를 기준으로 자름
//		StringTokenizer st = new StringTokenizer(str, ";");	// 두 번째 인자 문자열을 기준으로 자름
		StringTokenizer st = new StringTokenizer(str, ";ah", false);	// 세 번째 인자: 구분문자도 토큰으로 만들 것인지?
		
		// 두 번째 인자인 delimiter 문자열을 이루는 문자 하나하나가 구분자가 됨
		
		while (st.hasMoreTokens()) {	// 또는 st1.hasMoreElements()
			
			String token = st.nextToken();	// 또는 st1.nextElement()
//			Object token = st.nextElement();
			
			// token 이용
			System.out.println(token);
			
		}
		
	}
	
}
