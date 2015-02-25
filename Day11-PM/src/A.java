
public class A {
	
	static long count = 0;
	
	public static void main(String[] args) {
		
		System.out.println("A의 main 메소드 시작");
		
		System.out.println(count++);
		
		B.main(args);
		
		System.out.println("A의 main 메소드 종료");
		
	}
	
}
