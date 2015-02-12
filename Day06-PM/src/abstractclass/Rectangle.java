package abstractclass;

public class Rectangle extends Shape {

	private double width; // �ʺ�
	private double height; // ����

	public Rectangle() {
	}

	public Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
	}
	
	// ������(override) - ������ ������� ���� �ϵ���
	public void makeArea() {
		area = width * height;
	}
	
	// ������(override) - ������ ������� ���� �ϵ���
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
