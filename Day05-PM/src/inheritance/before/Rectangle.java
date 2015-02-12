package inheritance.before;

public class Rectangle {

	private double width; // 너비
	private double height; // 높이
	private double area; // 넓이
	private double circum; // 둘레

	public Rectangle() {
	}

	public Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
	}

	public void makeArea() {
		area = width * height;
	}

	public void makeCircum() {
		circum = (width + height) * 2;
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

	public double getWidth() {
		return width;
	}

	public double getHeight() {
		return height;
	}

}
