
public class Circle {
	
	double radius;
	double area;
	
	public Circle setRadius(double radius) {
		this.radius = radius;
		AreaUtil.calcArea(this);
		return this;
	}
	
//	public double getArea() {
//		return Math.PI * radius * radius;
//	}
	
	public Circle display() {
		System.out.println("�� ���� �������� " + radius
				+ "�̰�, ���̴� " + area);
		return this;
	}
	
}
