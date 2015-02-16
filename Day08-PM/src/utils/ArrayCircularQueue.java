package utils;

/*
 * 배열로 구현한 원형 큐
 */
public class ArrayCircularQueue {
	
	private Object[] data;
	private int front = 0;
	private int rear = -1;
	
	public ArrayCircularQueue() {
		this(10);
	}
	
	public ArrayCircularQueue(int capacity) {
		data = new Object[capacity + 1];
	}
	
	public boolean empty() {
		return (front == (rear + 1) % data.length);
	}
	
	public boolean full() {
		return (front == (rear + 2) % data.length);
	}
	
	public void insert(Object o) {
		if (full()) {
			throw new ArrayIndexOutOfBoundsException("FULL");
		}
		else {
			rear = (rear + 1) % data.length;
			data[rear] = o;
		}
	}
	
	public Object remove() {
		if (empty()) {
			throw new ArrayIndexOutOfBoundsException("EMPTY");
		}
		else {
			Object d = data[front];
			front = (front + 1) % data.length;
			return d;
		}
	}
	
}

























