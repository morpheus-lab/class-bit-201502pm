package thread.videoshop.goodkeeper;

import java.util.ArrayList;
import java.util.List;

class VideoShop {
	private List shelf = new ArrayList();
	
	public VideoShop() {
		shelf.add("����ö��999-0");	// 0
		shelf.add("����ö��999-1");	// 1
//		shelf.add("����ö��999-2");	// 2
//		shelf.add("����ö��999-3");	// 3
//		shelf.add("����ö��999-4");	// 4
	}
	
	public synchronized String lendVideo() throws InterruptedException {	// ���� ������ �뿩
		// �� �޼ҵ带 �����ϴ� �����尡 � �༮?
		Thread t = Thread.currentThread();
		
		while (shelf.size() == 0) {
			System.out.println(t.getName() + ": ��� ���� ����");
			this.wait();	// this ��ü�� ���� wait�϶�
							// => this ��ü�� ���� notify�� �� ������ ���
							// wait()�� �����ϴ� �����带 NotRunnable ���·� ����
			System.out.println(t.getName() + ": ��� ���� ����");
		}
		String v = (String) shelf.remove(shelf.size() - 1);
		return v;
	}
	
	public synchronized void returnVideo(String v) {	// ���� ������ �ݳ�
		shelf.add(v);
//		this.notify();	// this ��ü�� ���� wait�ϰ��ִ� �����带 Runnable ���·� ����
		this.notifyAll();	// this ��ü�� ���� wait�ϰ� �ִ� ��� �����带 Runnable ���·� ���� 
	}
}

class Person extends Thread {
	@Override
	public void run() {
		try {
			String video = GoodKeeperMain.vShop.lendVideo();
			
			System.out.println(getName() + ": " + video + " �뿩");
			System.out.println(getName() + ": " + video + " ���� ��");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(getName() + ": " + video + " �ݳ�");
			GoodKeeperMain.vShop.returnVideo(video);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

public class GoodKeeperMain {
	
	static VideoShop vShop = new VideoShop();
	
	public static void main(String[] args) {
		
		Person p1 = new Person();
		Person p2 = new Person();
		Person p3 = new Person();
		Person p4 = new Person();
		Person p5 = new Person();
		Person p6 = new Person();
		
		p1.start();
		p2.start();
		p3.start();
		p4.start();
		p5.start();
		p6.start();
		
	}
	
}
