package thread;

public class ThreadTest {
	
	public static void main(String[] args) {
		
		System.out.println("main �޼ҵ� ����");
		
		// ī��Ʈ�ٿ� ������ ����
		CountDownThread cdt1 = new CountDownThread();
		CountDownThread cdt2 = new CountDownThread();
		
		cdt2.setPriority(Thread.MAX_PRIORITY);
		
		System.out.println(cdt1.getName() + "�� �켱��: " + cdt1.getPriority());
		System.out.println(cdt2.getName() + "�� �켱��: " + cdt2.getPriority());
		
		// ������ ����
		cdt1.start();
		cdt2.start();
		
		System.out.println("main �޼ҵ� ��");
		
	}
	
}
