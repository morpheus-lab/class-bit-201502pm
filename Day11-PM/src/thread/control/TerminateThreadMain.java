package thread.control;

import java.util.Scanner;

class TerminateThread extends Thread {
	
	private boolean flag = true;
	
	public boolean getFlag() {
		return flag;
	}
	
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
	@Override
	public void run() {
		
		System.out.println(getName() + " 시작");
		
		while (flag) {
			// TODO
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println(getName() + " 종료");
		
	}
	
}

public class TerminateThreadMain {
	
	public static void main(String[] args) {
		
		System.out.println("main 메소드 시작");
		/*
		TerminateThread t = new TerminateThread();
		t.start();	// 스레드 시작
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
//		t.stop();	// 스레드 종료 (안전하지 못한 방법)
		t.setFlag(false);	// 스레드 종료
							// (반복문을 벗어나도록해서 run메소드가 자연스럽게
							// 종료될 수 있게 만드는 방법)
		*/
		
		// TerminateThread 객체 3개 생성
		TerminateThread t1 = new TerminateThread();
		TerminateThread t2 = new TerminateThread();
		TerminateThread t3 = new TerminateThread();
		
		// 모두 시작
		t1.start();
		t2.start();
		t3.start();
		
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			System.out.print("종료할 스레드(T1/T2/T3/M): ");
			String threadToStop = sc.nextLine();	// 사용자 입력 받기
			
			if (threadToStop.equalsIgnoreCase("T1")) {
//				if (t1.getFlag()) {
					t1.setFlag(false);	// t1 스레드 종료
//				} else {
//					t1.start();
//				}
			}
			else if (threadToStop.equalsIgnoreCase("T2")) {
				t2.setFlag(false);	// t2 스레드 종료
			}
			else if (threadToStop.equalsIgnoreCase("T3")) {
				t3.setFlag(false);	// t3 스레드 종료
			}
			else if (threadToStop.equalsIgnoreCase("M")) {
				t1.setFlag(false);
				t2.setFlag(false);
				t3.setFlag(false);
				break;	// while 문을 빠져나가 main 스레드가 종료되도록
			}
		}
		
		System.out.println("main 메소드 종료");
		
	}
	
}











