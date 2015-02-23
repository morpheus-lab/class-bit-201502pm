package thread;

public class RunnableTest {
	
	public static void main(String[] args) {
		
		System.out.println("main 메소드 시작");
		
		// Runnable 객체 생성
		CountDownTimer cdtimer = new CountDownTimer();
		
		// Runnable 객체로 스레드 생성
//		Thread t = new Thread(cdtimer);	// cdtimer 객체가 Runnable로 up-casting돼서 인자로 들어감
		
		// 스레드를 시작
//		t.start();
		
		System.out.println("main 메소드 끝");
		
	}
	
}
