package string;

public class StringUtil {
	
	/*
	 * ���ڿ� str �� ���� ch�� ã�� �� �� ���� ù ��° �ε��� ����
	 * ch ���ڰ� ������ -1 ����
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
	 * ���ڿ� str �� ���� ch�� ã�� �� �� ���� ������ �ε��� ����
	 * ch ���ڰ� ������ -1 ����
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
