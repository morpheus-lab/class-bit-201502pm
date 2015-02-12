package inheritance.before;

public class Rectangle {

	private double width; // �ʺ�
	private double height; // ����
	private double area; // ����
	private double circum; // �ѷ�

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
		System.out.println("������ " + area + ", �ѷ��� " + circum);
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
