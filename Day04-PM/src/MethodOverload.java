
public class MethodOverload {
	
	// method overload
	
	static void f(char c) {
		System.out.println("f(char) »£√‚µ !!!");
	}
	
	static void f(short s) {
		System.out.println("f(short) »£√‚µ !!!");
	}
	
	static void f(int i) {
		System.out.println("f(int) »£√‚µ !!!");
	}
	
//	static int f(int i) {
//		System.out.println("f(int) »£√‚µ !!!");
//		return 0;
//	}
	
	static void f(int i, int j) {
		System.out.println("f(int, int) »£√‚µ !!!");
	}
	
	static void f(long l) {
		System.out.println("f(long) »£√‚µ !!!");
	}
	
	static void f(double d) {
		System.out.println("f(double) »£√‚µ !!!");
	}
	
	public static void main(String[] args) {
//		char c = 'a';
//		f(c);
		
//		int i = 3;
//		f(i);
		
//		byte b = 1;
//		f(b);
		
//		short s = 2;
//		f(s);
		
//		long l = 100L;
//		f(l);
		
		double d = 3.0;
		f(d);
	}
	
}
