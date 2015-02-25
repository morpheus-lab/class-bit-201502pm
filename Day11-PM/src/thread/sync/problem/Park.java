package thread.sync.problem;

public class Park extends Thread {
	
	private BankAccount bankAccount;

	public Park(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}
	
	@Override
	public void run() {
		// �Ա�
		
		// �ܾ� ��ȸ
		int balance = bankAccount.getBalance();
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// �ܾ� + �Աݾ�
		balance = balance + 1000;
		
		// �ܾ� ����
		bankAccount.setBalance(balance);
		
	}
	
}
