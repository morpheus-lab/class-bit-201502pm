package thread.control;

class PriorityThread extends Thread {	// thread.control.PriorityThread
	
	@Override
	public void run() {
		int i = 0;
		
		System.out.println(getName() + " [우선권: " + getPriority() + "] 시작");
		
		while (i < 10000) {
			i++;
			try {
				Thread.sleep(1);	// 1ms 동안 NotRunnable 상태로
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		System.out.println(getName() + " [우선권: " + getPriority() + "] 종료");
	}
	
}

public class PriorityThreadMain {
	
	public static void main(String[] args) {
		
		System.out.println("main 메소드 시작");
		
		for (int i = 1; i <= 10; i++) {
			PriorityThread t = new PriorityThread();
			t.setPriority(i);
			t.start(); 
		}
		
		System.out.println("main 메소드 종료");
		
	}
	
}
