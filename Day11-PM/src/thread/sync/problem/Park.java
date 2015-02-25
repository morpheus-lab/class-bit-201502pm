package thread.sync.problem;

public class Park extends Thread {
	
	private BankAccount bankAccount;

	public Park(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}
	
	@Override
	public void run() {
		// 입금
		
		// 잔액 조회
		int balance = bankAccount.getBalance();
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// 잔액 + 입금액
		balance = balance + 1000;
		
		// 잔액 저장
		bankAccount.setBalance(balance);
		
	}
	
}
