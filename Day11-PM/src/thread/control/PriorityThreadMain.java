package thread.control;

class PriorityThread extends Thread {	// thread.control.PriorityThread
	
	@Override
	public void run() {
		int i = 0;
		
		System.out.println(getName() + " [�켱��: " + getPriority() + "] ����");
		
		while (i < 10000) {
			i++;
			try {
				Thread.sleep(1);	// 1ms ���� NotRunnable ���·�
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		System.out.println(getName() + " [�켱��: " + getPriority() + "] ����");
	}
	
}

public class PriorityThreadMain {
	
	public static void main(String[] args) {
		
		System.out.println("main �޼ҵ� ����");
		
		for (int i = 1; i <= 10; i++) {
			PriorityThread t = new PriorityThread();
			t.setPriority(i);
			t.start(); 
		}
		
		System.out.println("main �޼ҵ� ����");
		
	}
	
}
