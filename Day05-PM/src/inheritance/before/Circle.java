package inheritance.before;

public class Circle {

	private double radius; // 반지름
	private double area; // 면적
	private double circum; // 둘레

	public Circle() {
	}

	public Circle(double radius) {
		this.radius = radius;
	}

	public void makeArea() {
		area = Math.PI * radius * radius;
	}

	public void makeCircum() {
		circum = Math.PI * radius * 2;
	}

	public void display() {
		System.out.println("면적은 " + area + ", 둘레는 " + circum);
	}

	public double getArea() {
		return area;
	}

	public double getCircum() {
		return circum;
	}

	public double getRadius() {
		return radius;
	}

}
