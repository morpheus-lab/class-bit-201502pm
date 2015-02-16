package utils;

public class QueueTest {
	
	public static void main(String[] args) {
		
//		ArrayQueue queue = new ArrayQueue(5);
		ArrayCircularQueue queue = new ArrayCircularQueue(5);
		
		queue.insert("1");
		queue.insert("2");
		queue.insert("3");
		queue.insert("4");
		queue.insert("5");
//		queue.insert("6");
		
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		System.out.println(queue.remove());
//		System.out.println(queue.remove());
		
		queue.insert("6");
		System.out.println(queue.remove());
		
		
		
		
	}
	
}
