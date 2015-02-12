package inheritance.after;

public class Shape {
	
	protected double area;
	protected double circum;
	
	public Shape() {
		System.out.println("Shape 생성자 호출~~");
	}
	
	public Shape(int i) {
		System.out.println("Shape 생성자2 호출~~");
	}
	
	public Shape(String s) {
		System.out.println("Shape 생성자3 호출~~");
	}
	
	public static void staticMethod() {
		System.out.println("Shape.staticMethod()~~~");
	}
	
	public void makeArea() {
	}

	public void makeCircum() {
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
	
}
