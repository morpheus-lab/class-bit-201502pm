package thread;

public class CountDownThread extends Thread {
	
	@Override
	public void run() {	// �� �����尡 �� ��
		
		for (int i = 10000; i > 0; i--) {
			System.out.println(getName() + " - " + i);
//			try {
//				Thread.sleep(10);	// �� �����带 ������ �ð�(ms)��ŭ ������
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
		}
		
	}
	
}
