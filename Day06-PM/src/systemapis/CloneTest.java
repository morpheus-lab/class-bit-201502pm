package systemapis;

public class CloneTest implements Cloneable {
	
	int i;
	
	// protected clone()
	
	CloneTest makeClone() throws CloneNotSupportedException {
		return (CloneTest) clone();
	}
	
	@Override
	protected void finalize() throws Throwable {
		System.out.println(toString() + " - 그 동안 행복했네..");
		super.finalize();
	}
	
	public static void main(String[] args) throws CloneNotSupportedException {
		
		CloneTest t = new CloneTest();
		t.i = 1000;
		
		CloneTest t1 = t.makeClone();
		
		// t와 t1 객체의 해시코드 출력
		System.out.println(t.toString());
		System.out.println(t1.toString());
		
		System.out.println(Integer.toHexString(t.hashCode()));
		System.out.println(Integer.toHexString(t1.hashCode()));
		
//		System.out.println(t.i);
//		System.out.println(t1.i);
		
//		t = null;
//		t1 = null;
//		
//		System.gc();
		
		System.out.println(t);	// println메소드는 객체의 toString()을 화면에 출력
		
		String str1 = "Hello, Java~!";
		
		System.out.println(str1);
		System.out.println(str1.toString());
		
	}
	
}
