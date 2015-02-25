package thread.videoshop;

import java.util.ArrayList;
import java.util.List;

class VideoShop {
	private List shelf = new ArrayList();
	
	public VideoShop() {
		shelf.add("����ö��999-0");	// 0
		shelf.add("����ö��999-1");	// 1
		shelf.add("����ö��999-2");	// 2
		shelf.add("����ö��999-3");	// 3
		shelf.add("����ö��999-4");	// 4
	}
	
	public synchronized String lendVideo() {	// ���� ������ �뿩
		String v = null;
		if (shelf.size() > 0) {
			v = (String) shelf.remove(shelf.size() - 1);
		}
		return v;
	}
	
	public synchronized void returnVideo(String v) {	// ���� ������ �ݳ�
		shelf.add(v);
	}
}

class Person extends Thread {
	@Override
	public void run() {
//		synchronized (VideoShopMain.vShop) {
			String video = VideoShopMain.vShop.lendVideo();
			if (video == null) {
				System.out.println("������ ������.. �Ⱥ��ϴ�.");
			} else {
				System.out.println(video + " �뿩");
				System.out.println(video + " ���� ��");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(video + " �ݳ�");
				VideoShopMain.vShop.returnVideo(video);
			}
//		}
	}
}

public class VideoShopMain {
	
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
