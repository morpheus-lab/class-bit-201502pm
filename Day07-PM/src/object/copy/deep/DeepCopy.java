package object.copy.deep;

public class DeepCopy {
	
	static class A implements Cloneable {
		int a = 0;
		double b = 0;
		int[] c = {1, 3, 5, 7, 9};
		
		A deepCopy() throws CloneNotSupportedException {
			// Deep Copy를 하려면
			// 참조 변수도 모두 clone 해야 함
			
			A clone = (A) this.clone();
			clone.c = this.c.clone();
			
			return clone;
		}
	}
	
	public static void main(String[] args) throws CloneNotSupportedException {
		
		A a1 = new A();
		A a2 = a1.deepCopy();
		
		System.out.println(a1);
		System.out.println(a2);
		
		System.out.println(a1.c);
		System.out.println(a2.c);
		
		a1.c[0] = 99;
		System.out.println(a1.c[0]);
		System.out.println(a2.c[0]);
		
	}
	
}
