
public class StaticTest {
	
	public static void main(String[] args) {
		
		A.i2++;
		
		A a1 = new A();
		A a2 = new A();
		
		a1.i++;
		a1.i2++;
		
		System.out.println("a1.i  = " + a1.i);
		System.out.println("a1.i2 = " + a1.i2);
		
		System.out.println("a2.i  = " + a2.i);
		System.out.println("a2.i2 = " + a2.i2);
		
		System.out.println(Math.PI);
		System.out.println(Math.E);
		
		System.out.println(a1.c);
		System.out.println(a1.d);
		
	}
	
}
