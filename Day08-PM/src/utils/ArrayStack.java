package utils;

/*
 * 배열로 구현한 스택
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
		// 스택이 가득찼나?
		if (top < data.length - 1) {	// 여유공간 있음
			data[++top] = o;
		}
		else {
			throw new ArrayIndexOutOfBoundsException("FULL");
		}
	}
	
	public Object pop() {
		// 스택이 비어있다면
		if (top < 0) {
			throw new ArrayIndexOutOfBoundsException("EMPTY");
		}
		// 스택이 비어있지 않다면
		else {
			return data[top--];	// stack[top]을 리턴하고 top -= 1;
		}
	}
	
}
