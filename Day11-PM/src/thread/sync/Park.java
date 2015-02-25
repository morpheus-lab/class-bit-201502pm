package thread.sync;

public class Park extends Thread {
	
	public Park() {
		
	}
	
	@Override
	public void run() {
		synchronized (BankTest.sharedAccount) {
			// ют╠щ
			BankTest.sharedAccount.add(1000);
		}
	}
	
}
