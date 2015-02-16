package utils;

/*
 * �迭�� ������ ����
 */
public class ArrayStack {
	
	private Object[] data;
	private int top = -1;
	
	public ArrayStack() {
		this(10);
	}
	
	public ArrayStack(int capacity) {
		data = new Object[capacity];
	}
	
	public boolean full() {
		return (top == data.length - 1);
	}
	
	public boolean empty() {
		return (top < 0);
	}
	
	public void push(Object o) {
		// ������ ����á��?
		if (top < data.length - 1) {	// �������� ����
			data[++top] = o;
		}
		else {
			throw new ArrayIndexOutOfBoundsException("FULL");
		}
	}
	
	public Object pop() {
		// ������ ����ִٸ�
		if (top < 0) {
			throw new ArrayIndexOutOfBoundsException("EMPTY");
		}
		// ������ ������� �ʴٸ�
		else {
			return data[top--];	// stack[top]�� �����ϰ� top -= 1;
		}
	}
	
}
