package inheritance;

public class B extends A {
	
	// int f;
	// void m() {}
	
	int f = 100;	// A와 같은 이름의 변수 선언
	int f2 = 1000;
	
	void m() {
		System.out.println("B의 m() 호출됨~");
	}
	
	void superM() {
		super.m();
	}
	
	void m2() {
		System.out.println("B의 m2() 호출됨~~!!!");
	}
	
	void showSuperF() {
		System.out.println("A로부터 물려받은 f = " + super.f);
	}
	
	public static void main(String[] args) {
		A a = new A();
		System.out.println("a.f = " + a.f);
		a.m();
//		System.out.println(a.f2++);
//		a.m2();
		
		System.out.println("------------------------");
		
		B b = new B();
		b.m();
		b.m2();
		System.out.println("b.f = " + b.f);
		System.out.println("b.f2 = " + b.f2);
		b.showSuperF();	// A로부터 물려받은 f
		b.superM();	// A로부터 물려받은 m()
		
	}
	
}
