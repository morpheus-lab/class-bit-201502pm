package thread;

public class CountDownThread extends Thread {
	
	@Override
	public void run() {	// 이 스레드가 할 일
		
		for (int i = 10000; i > 0; i--) {
			System.out.println(getName() + " - " + i);
//			try {
//				Thread.sleep(10);	// 이 스레드를 지정된 시간(ms)만큼 쉬도록
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
		}
		
	}
	
}
