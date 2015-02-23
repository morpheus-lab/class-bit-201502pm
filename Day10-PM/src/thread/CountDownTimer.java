package thread;

public class CountDownTimer extends Timer implements Runnable {
	
	public CountDownTimer() {
		new Thread(this).start();
	}
	
	// int startNum
	// void countDown
	
	@Override
	public void run() {
		while (startNum >= 0) {
			countDown();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
