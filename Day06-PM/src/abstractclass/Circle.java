package abstractclass;

public class Circle extends Shape {

	private double radius; // 반지름

	public Circle() {
		super(2);
		System.out.println("Circle 생성자 호출~~!!!");
	}

	public Circle(double radius) {
		super("Shape의 생성자 3 호출");
		System.out.println("Circle 생성자2 호출~~!!!");
		this.radius = radius;
	}
	
	public static void staticMethod() {
		System.out.println("Circle.staticMethod()!!!!");
	}
	
	// 재정의(override) - 나만의 방법으로 일을 하도록
	public void makeArea() {
		area = Math.PI * radius * radius;
	}
	
	// 재정의(override) - 나만의 방법으로 일을 하도록
	public void makeCircum() {
		circum = Math.PI * radius * 2;
	}
	
	public double getRadius() {
		return radius;
	}

}
