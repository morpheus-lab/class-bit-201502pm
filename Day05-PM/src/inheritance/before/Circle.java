package inheritance.before;

public class Circle {

	private double radius; // ������
	private double area; // ����
	private double circum; // �ѷ�

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
		System.out.println("������ " + area + ", �ѷ��� " + circum);
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
