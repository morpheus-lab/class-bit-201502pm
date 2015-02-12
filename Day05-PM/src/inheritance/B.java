package inheritance;

public class B extends A {
	
	// int f;
	// void m() {}
	
	int f = 100;	// A�� ���� �̸��� ���� ����
	int f2 = 1000;
	
	void m() {
		System.out.println("B�� m() ȣ���~");
	}
	
	void superM() {
		super.m();
	}
	
	void m2() {
		System.out.println("B�� m2() ȣ���~~!!!");
	}
	
	void showSuperF() {
		System.out.println("A�κ��� �������� f = " + super.f);
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
		b.showSuperF();	// A�κ��� �������� f
		b.superM();	// A�κ��� �������� m()
		
	}
	
}
