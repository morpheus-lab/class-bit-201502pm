package abstractclass;

public class Circle extends Shape {

	private double radius; // ������

	public Circle() {
		super(2);
		System.out.println("Circle ������ ȣ��~~!!!");
	}

	public Circle(double radius) {
		super("Shape�� ������ 3 ȣ��");
		System.out.println("Circle ������2 ȣ��~~!!!");
		this.radius = radius;
	}
	
	public static void staticMethod() {
		System.out.println("Circle.staticMethod()!!!!");
	}
	
	// ������(override) - ������ ������� ���� �ϵ���
	public void makeArea() {
		area = Math.PI * radius * radius;
	}
	
	// ������(override) - ������ ������� ���� �ϵ���
	public void makeCircum() {
		circum = Math.PI * radius * 2;
	}
	
	public double getRadius() {
		return radius;
	}

}
