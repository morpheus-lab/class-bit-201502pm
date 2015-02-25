package thread.sync.problem;

public class ThreadSyncProblem {
	
	public static void main(String[] args) {
		
		BankAccount account = new BankAccount();
		account.setBalance(10000);
		
		Park p = new Park(account);
		ParkWife w = new ParkWife(account);
		
		p.start();
		w.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("°èÁÂ ÀÜ¾×: " + account.getBalance());
		
	}
	
}
