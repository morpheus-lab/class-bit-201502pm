package thread.sync;

public class ParkWife extends Thread {
	
	public ParkWife() {
		
	}
	
	@Override
	public void run() {
		synchronized (BankTest.sharedAccount) {
			// √‚±›
			BankTest.sharedAccount.minus(3000);
		}
	}
	
}
