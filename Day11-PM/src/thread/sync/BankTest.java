package thread.sync;

public class BankTest {
	
	static BankAccount sharedAccount = new BankAccount();
	static {
		sharedAccount.setBalance(10000);
	}
	
	public static void main(String[] args) {
		
		Park p = new Park();
		ParkWife w = new ParkWife();
		
		p.start();
		w.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("°èÁÂ ÀÜ¾×: " + sharedAccount.getBalance());
		
	}
	
}
