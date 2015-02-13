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
		
		// substring(int beginIndex, int endIndex) => beginIndex ���� endIndex - 1 ������ �κ� ���ڿ�
		//										   => substring�� ���ؼ� ����Ǵ� �κ� ���ڿ��� ����: (endIndex - beginIndex)
		String partial = str.substring(10, 15);	// StringIndexOutOfBoundsException �߻��� �� ����
		System.out.println(partial);
		
		// trim() => ù ��° ������ �ƴ� ������ ��, ������ ������ �ƴ� ������ �ڿ� �ִ� ���� ����(space, line feed, tab, ...)���� ����
		str = "   Hello Java 	\n         ";
		System.out.println("'" + str.trim() + "'");
		
		str = str.trim();
		// toUpperCase()	=> ��� ���ڸ� �빮�ڷ�
		// toLowerCase()	=> ��� ���ڸ� �ҹ��ڷ�
		System.out.println("toUpperCase(): " + str.toUpperCase());
		System.out.println("toLowerCase(): " + str.toLowerCase());
		
		// replace(char oldChar, char newChar)	=> oldChar ���ڸ� newChar ���ڷ� ġȯ
		System.out.println(str.replace('a', 'u'));
		
		
		
		// ���ڿ� Ž�� �޼ҵ�
		
		// startsWith(String prefix)	=> prefix ���ڿ��� ���۵Ǵ� ���ڿ����� ����
		System.out.println("str.startsWith() : " + str.startsWith("Ho"));
		
		// endsWith(String suffix)	=> suffix ���ڿ��� ������ ���ڿ����� ����
		System.out.println("str.endsWith() : " + str.endsWith("java"));
		
		// ��ҹ��� ���о��� Ư�� ���ڿ��� ���۵Ǵ��� �˻縦 �Ϸ���?
		System.out.println("\"HEL\"�� ����? (��ҹ��� ����X) : " + str.toUpperCase().startsWith("HEL"));
		
		// indexOf(int ch)	=> ch ���ڰ� ó������ �߰ߵǴ� ���� �ε����� ����
		// Hello Java
		System.out.println("str.indexOf('a') : " + str.indexOf('a'));
		
		// lastIndexOf(int ch)	=>
		System.out.println("str.lastIndexOf('a') : " + str.lastIndexOf('a'));
		
	}
	
}



























