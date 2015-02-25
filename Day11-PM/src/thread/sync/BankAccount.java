package thread.sync;

public class BankAccount {
	
	private int balance;	// �ܾ�

	public int getBalance() {	// getter �޼ҵ�
		return balance;
	}

	public void setBalance(int balance) {	// setter �޼ҵ�
		this.balance = balance;
	}
	
	public void add(int amount) {	// �޼ҵ忡 synchronized Ű���带 ���̸�
												// �ڱ� �ڽ� ��ü�� ���� LOCK�� ����
												// ��������� �޼ҵ� ��ü�� synchronized(this)��
												// ������ �Ͱ� ����
		// �ܾ� ��ȸ
		int balance = this.balance;
		
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// �ܾ� ����
		this.balance = balance + amount;
	}
	
	public void minus(int amount) {
		// �ܾ� ��ȸ
		int balance = this.balance;
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// �ܾ� ����
		this.balance = balance - amount;
	}
	
}
