
public class B {
	
	public static void main(String[] args) {
		
		System.out.println("B�� main �޼ҵ� ����");
		
		System.out.println(A.count++);
		
		A.main(args);
		
		System.out.println("B�� main �޼ҵ� ����");
		
	}
	
}
