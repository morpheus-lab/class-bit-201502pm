package thread.sync.problem;

public class ParkWife extends Thread {
	
	private BankAccount bankAccount;
	
	public ParkWife(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}
	
	@Override
	public void run() {
		// ���
		
		// �ܾ� ��ȸ
		int balance = bankAccount.getBalance();
		
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// �ܾ� - ��ݾ�
		balance = balance - 3000;
		
		// �ܾ� ����
		bankAccount.setBalance(balance);
	}
	
}
