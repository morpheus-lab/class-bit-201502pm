package utils;

public class ArrayStackTest {
	
	public static void main(String[] args) {
		
		ArrayStack stack = new ArrayStack(5);
		
		stack.push("1");
		stack.push("2");
		stack.push("3");
		stack.push("4");
		stack.push("5");
//		stack.push("6");
		
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
//		System.out.println(stack.pop());
		
	}
	
}
