package inheritance.after;

public class Shape {
	
	protected double area;
	protected double circum;
	
	public Shape() {
		System.out.println("Shape ������ ȣ��~~");
	}
	
	public Shape(int i) {
		System.out.println("Shape ������2 ȣ��~~");
	}
	
	public Shape(String s) {
		System.out.println("Shape ������3 ȣ��~~");
	}
	
	public static void staticMethod() {
		System.out.println("Shape.staticMethod()~~~");
	}
	
	public void makeArea() {
	}

	public void makeCircum() {
	}

	public void display() {
		System.out.println("������ " + area + ", �ѷ��� " + circum);
	}

	public double getArea() {
		return area;
	}

	public double getCircum() {
		return circum;
	}
	
}
