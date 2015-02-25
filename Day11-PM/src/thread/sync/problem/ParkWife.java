package thread.sync.problem;

public class ParkWife extends Thread {
	
	private BankAccount bankAccount;
	
	public ParkWife(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}
	
	@Override
	public void run() {
		// 출금
		
		// 잔액 조회
		int balance = bankAccount.getBalance();
		
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// 잔액 - 출금액
		balance = balance - 3000;
		
		// 잔액 저장
		bankAccount.setBalance(balance);
	}
	
}
