
public class A {
	
	static long count = 0;
	
	public static void main(String[] args) {
		
		System.out.println("A�� main �޼ҵ� ����");
		
		System.out.println(count++);
		
		B.main(args);
		
		System.out.println("A�� main �޼ҵ� ����");
		
	}
	
}
