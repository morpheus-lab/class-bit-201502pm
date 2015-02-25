
public class B {
	
	public static void main(String[] args) {
		
		System.out.println("B의 main 메소드 시작");
		
		System.out.println(A.count++);
		
		A.main(args);
		
		System.out.println("B의 main 메소드 종료");
		
	}
	
}
