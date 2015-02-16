package utils;

/*
 * 배열로 구현한 큐
 */
public class ArrayQueue {
	
	private Object[] data;
	private int front = 0;	// 이 곳에 들어가야 할 차례
	private int rear = -1;	// 여기까지 데이터가 들어가 있다
	
	public ArrayQueue() {
		this(10);
	}
	
	public ArrayQueue(int capacity) {
		data = new Object[capacity];
	}
	
	public boolean empty() {
		return (front - 1 == rear);
	}
	
	public boolean full() {
		return (rear == data.length - 1);
	}
	
	public void insert(Object o) {
		// 가득 찬 경우
		if (full()) {
			throw new ArrayIndexOutOfBoundsException("FULL");
		}
		// 가득 차지 않은 경우
		else {
			data[++rear] = o;
		}
	}
	
	public Object remove() {
		// 비어 있는 경우
		if (empty()) {
			throw new ArrayIndexOutOfBoundsException("EMPTY");
		}
		// 비어 있지 않은 경우
		else {
			return data[front++];
		}
	}
	
}














