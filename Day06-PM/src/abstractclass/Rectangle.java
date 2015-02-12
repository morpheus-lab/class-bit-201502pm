package abstractclass;

public class Rectangle extends Shape {

	private double width; // 너비
	private double height; // 높이

	public Rectangle() {
	}

	public Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
	}
	
	// 재정의(override) - 나만의 방법으로 일을 하도록
	public void makeArea() {
		area = width * height;
	}
	
	// 재정의(override) - 나만의 방법으로 일을 하도록
	public void makeCircum() {
		circum = (width + height) * 2;
	}
	
	public double getWidth() {
		return width;
	}

	public double getHeight() {
		return height;
	}

}
