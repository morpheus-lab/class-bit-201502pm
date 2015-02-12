package inheritance.after;

public class ShapeTest {
	
	public void m(Shape s) {
		/*
		if (s instanceof Circle) {
			Circle c = (Circle) s;
			c.makeAC();
		}
		else if (s instanceof Rectangle) {
			Rectangle r = (Rectangle) s;
			r.makeAR();
		}
		*/
		s.makeArea();
		s.display();
	}
	
	public static void main(String[] args) {
		
//		ShapeTest t = new ShapeTest();
//		
//		t.m(new Shape());
//		t.m(new Circle(5));
//		t.m(new Rectangle(4, 5));
//		
		Circle c = new Circle(6);
//		c.staticMethod();
		
	}
	
}
