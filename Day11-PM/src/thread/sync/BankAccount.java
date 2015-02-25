package thread.sync;

public class BankAccount {
	
	private int balance;	// 잔액

	public int getBalance() {	// getter 메소드
		return balance;
	}

	public void setBalance(int balance) {	// setter 메소드
		this.balance = balance;
	}
	
	public void add(int amount) {	// 메소드에 synchronized 키워드를 붙이면
												// 자기 자신 객체에 대해 LOCK을 설정
												// 결과적으로 메소드 전체에 synchronized(this)로
												// 감싸준 것과 같음
		// 잔액 조회
		int balance = this.balance;
		
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// 잔액 저장
		this.balance = balance + amount;
	}
	
	public void minus(int amount) {
		// 잔액 조회
		int balance = this.balance;
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// 잔액 저장
		this.balance = balance - amount;
	}
	
}
