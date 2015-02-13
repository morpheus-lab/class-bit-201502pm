package string;

public class StringUtil {
	
	/*
	 * 문자열 str 중 문자 ch를 찾아 그 중 가장 첫 번째 인덱스 리턴
	 * ch 문자가 없으면 -1 리턴
	 */
	public static int indexOf(String str, int ch) {
		char[] value = str.toCharArray();
		for (int i = 0; i < value.length; i++) {
			if (value[i] == ch) {
				return i;
			}
		}
		return -1;
	}
	
	/*
	 * 문자열 str 중 문자 ch를 찾아 그 중 가장 마지막 인덱스 리턴
	 * ch 문자가 없으면 -1 리턴
	 */
	public static int lastIndexOf(String str, int ch) {
		char[] value = str.toCharArray();
		for (int i = value.length - 1; i >= 0; i--) {
			if (value[i] == ch) {
				return i;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		
		String str = "Oh My God.";
		
		System.out.println(str.indexOf('y'));
		
		System.out.println(StringUtil.indexOf(str, 'y'));
		
		System.out.println(str.lastIndexOf('d'));
		
		System.out.println(StringUtil.lastIndexOf(str, 'd'));
		
		
	}
	
}
