package thread.videoshop.goodkeeper;

import java.util.ArrayList;
import java.util.List;

class VideoShop {
	private List shelf = new ArrayList();
	
	public VideoShop() {
		shelf.add("은하철도999-0");	// 0
		shelf.add("은하철도999-1");	// 1
//		shelf.add("은하철도999-2");	// 2
//		shelf.add("은하철도999-3");	// 3
//		shelf.add("은하철도999-4");	// 4
	}
	
	public synchronized String lendVideo() throws InterruptedException {	// 비디오 테이프 대여
		// 이 메소드를 실행하는 스레드가 어떤 녀석?
		Thread t = Thread.currentThread();
		
		while (shelf.size() == 0) {
			System.out.println(t.getName() + ": 대기 상태 진입");
			this.wait();	// this 객체에 대해 wait하라
							// => this 객체에 대해 notify가 될 때까지 대기
							// wait()를 실행하는 스레드를 NotRunnable 상태로 만듦
			System.out.println(t.getName() + ": 대기 상태 해제");
		}
		String v = (String) shelf.remove(shelf.size() - 1);
		return v;
	}
	
	public synchronized void returnVideo(String v) {	// 비디오 테이프 반납
		shelf.add(v);
//		this.notify();	// this 객체에 대해 wait하고있는 스레드를 Runnable 상태로 만듦
		this.notifyAll();	// this 객체에 대해 wait하고 있는 모든 스레드를 Runnable 상태로 만듦 
	}
}

class Person extends Thread {
	@Override
	public void run() {
		try {
			String video = GoodKeeperMain.vShop.lendVideo();
			
			System.out.println(getName() + ": " + video + " 대여");
			System.out.println(getName() + ": " + video + " 보는 중");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(getName() + ": " + video + " 반납");
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
