package thread;

public class RunnableTest {
	
	static class CountDown implements Runnable {
		@Override
		public void run() {
			System.out.println("CountDown�� run()");
		}
	}
	
	public static void main(String[] args) {
		
		// Runnable ��ü ����
		Runnable r = new CountDown();
		
		// �� Runnable ��ü�� Thread�� �־ ������ ��ü ����
		Thread t = new Thread(r);
		t.start();
		
	}
	
}
