package thread;

public class ThreadTest {
	
	public static void main(String[] args) {
		
		System.out.println("main 메소드 시작");
		
		// 카운트다운 스레드 생성
		CountDownThread cdt1 = new CountDownThread();
		CountDownThread cdt2 = new CountDownThread();
		
		cdt2.setPriority(Thread.MAX_PRIORITY);
		
		System.out.println(cdt1.getName() + "의 우선권: " + cdt1.getPriority());
		System.out.println(cdt2.getName() + "의 우선권: " + cdt2.getPriority());
		
		// 스레드 시작
		cdt1.start();
		cdt2.start();
		
		System.out.println("main 메소드 끝");
		
	}
	
}
