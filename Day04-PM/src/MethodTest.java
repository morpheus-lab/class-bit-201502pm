

public class MethodTest {

	void m1() {	// 반환 데이터가 없음 - void
				// 이름은 m1
				// 파라미터는 없음
		
	}
	
	int m2() {	// 반환 데이터가 있는데 int 타입이다
				// 이름은 m2
				// 파라미터는 없음
		m1();
		return 0;
	}
	
	int m3(int a, int b) {	// 반환 데이터가 있고 타입이 int
							// 이름은 m3
							// 파라미터는 2개, int, int 타입
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
