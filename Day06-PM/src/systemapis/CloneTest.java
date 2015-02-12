package systemapis;

public class CloneTest implements Cloneable {
	
	int i;
	
	// protected clone()
	
	CloneTest makeClone() throws CloneNotSupportedException {
		return (CloneTest) clone();
	}
	
	@Override
	protected void finalize() throws Throwable {
		System.out.println(toString() + " - �� ���� �ູ�߳�..");
		super.finalize();
	}
	
	public static void main(String[] args) throws CloneNotSupportedException {
		
		CloneTest t = new CloneTest();
		t.i = 1000;
		
		CloneTest t1 = t.makeClone();
		
		// t�� t1 ��ü�� �ؽ��ڵ� ���
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
		
		System.out.println(t);	// println�޼ҵ�� ��ü�� toString()�� ȭ�鿡 ���
		
		String str1 = "Hello, Java~!";
		
		System.out.println(str1);
		System.out.println(str1.toString());
		
	}
	
}
