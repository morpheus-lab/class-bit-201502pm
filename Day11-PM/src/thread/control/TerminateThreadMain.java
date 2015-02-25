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
		
		System.out.println(getName() + " ����");
		
		while (flag) {
			// TODO
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println(getName() + " ����");
		
	}
	
}

public class TerminateThreadMain {
	
	public static void main(String[] args) {
		
		System.out.println("main �޼ҵ� ����");
		/*
		TerminateThread t = new TerminateThread();
		t.start();	// ������ ����
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
//		t.stop();	// ������ ���� (�������� ���� ���)
		t.setFlag(false);	// ������ ����
							// (�ݺ����� ��������ؼ� run�޼ҵ尡 �ڿ�������
							// ����� �� �ְ� ����� ���)
		*/
		
		// TerminateThread ��ü 3�� ����
		TerminateThread t1 = new TerminateThread();
		TerminateThread t2 = new TerminateThread();
		TerminateThread t3 = new TerminateThread();
		
		// ��� ����
		t1.start();
		t2.start();
		t3.start();
		
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			System.out.print("������ ������(T1/T2/T3/M): ");
			String threadToStop = sc.nextLine();	// ����� �Է� �ޱ�
			
			if (threadToStop.equalsIgnoreCase("T1")) {
//				if (t1.getFlag()) {
					t1.setFlag(false);	// t1 ������ ����
//				} else {
//					t1.start();
//				}
			}
			else if (threadToStop.equalsIgnoreCase("T2")) {
				t2.setFlag(false);	// t2 ������ ����
			}
			else if (threadToStop.equalsIgnoreCase("T3")) {
				t3.setFlag(false);	// t3 ������ ����
			}
			else if (threadToStop.equalsIgnoreCase("M")) {
				t1.setFlag(false);
				t2.setFlag(false);
				t3.setFlag(false);
				break;	// while ���� �������� main �����尡 ����ǵ���
			}
		}
		
		System.out.println("main �޼ҵ� ����");
		
	}
	
}











