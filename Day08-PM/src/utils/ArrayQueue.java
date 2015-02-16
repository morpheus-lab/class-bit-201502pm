package utils;

/*
 * �迭�� ������ ť
 */
public class ArrayQueue {
	
	private Object[] data;
	private int front = 0;	// �� ���� ���� �� ����
	private int rear = -1;	// ������� �����Ͱ� �� �ִ�
	
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
		// ���� �� ���
		if (full()) {
			throw new ArrayIndexOutOfBoundsException("FULL");
		}
		// ���� ���� ���� ���
		else {
			data[++rear] = o;
		}
	}
	
	public Object remove() {
		// ��� �ִ� ���
		if (empty()) {
			throw new ArrayIndexOutOfBoundsException("EMPTY");
		}
		// ��� ���� ���� ���
		else {
			return data[front++];
		}
	}
	
}














