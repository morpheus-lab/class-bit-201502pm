package thread;

public class RunnableTest {
	
	public static void main(String[] args) {
		
		System.out.println("main �޼ҵ� ����");
		
		// Runnable ��ü ����
		CountDownTimer cdtimer = new CountDownTimer();
		
		// Runnable ��ü�� ������ ����
//		Thread t = new Thread(cdtimer);	// cdtimer ��ü�� Runnable�� up-casting�ż� ���ڷ� ��
		
		// �����带 ����
//		t.start();
		
		System.out.println("main �޼ҵ� ��");
		
	}
	
}
