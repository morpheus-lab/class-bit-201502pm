

public class MethodTest {

	void m1() {	// ��ȯ �����Ͱ� ���� - void
				// �̸��� m1
				// �Ķ���ʹ� ����
		
	}
	
	int m2() {	// ��ȯ �����Ͱ� �ִµ� int Ÿ���̴�
				// �̸��� m2
				// �Ķ���ʹ� ����
		m1();
		return 0;
	}
	
	int m3(int a, int b) {	// ��ȯ �����Ͱ� �ְ� Ÿ���� int
							// �̸��� m3
							// �Ķ���ʹ� 2��, int, int Ÿ��
		return a + b;
	}
	
	public static void main(String[] args) {
		
		MethodTest mt = new MethodTest();
		mt.m1();
		int r1 = mt.m2();
		System.out.println(r1);
//		System.out.println(mt.m2());
		int r2 = mt.m3(0, 1);
		System.out.println(r2);
		
	}

}
