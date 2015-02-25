package thread;

public class RunnableTest {
	
	static class CountDown implements Runnable {
		@Override
		public void run() {
			System.out.println("CountDown의 run()");
		}
	}
	
	public static void main(String[] args) {
		
		// Runnable 객체 생성
		Runnable r = new CountDown();
		
		// 위 Runnable 객체를 Thread에 넣어서 스레드 객체 생성
		Thread t = new Thread(r);
		t.start();
		
	}
	
}
