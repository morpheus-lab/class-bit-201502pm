
public class ObjectTest {
	
	private static class B {	// 내부 클래스 (inner class)
		// => 내부 클래스가 컴파일되면 "{외부클래스명}${내부클래스명}.class" 이름으로 클래스 파일 생성됨.
		// private 내부 클래스를 만들면, 외부에서는 접근할 수 없는
		// ObjectTest 클래스 내에서만 사용하는 클래스를 정의할 수 있다.
		
		int i;
		
		B(int a) {
			i = a;
		}
		
		@Override
		public String toString() {
			return i + "";
		}
		
	}
	
	private static class NameCard {
		String name;
		String tel;
		String addr;
		String org;
		
		public NameCard() {}
		
		public NameCard(String name, String tel, String addr, String org) {
			this.name = name;
			this.tel = tel;
			this.addr = addr;
			this.org = org;
		}
		
		@Override
		public String toString() {
			return "{이름: " + name
					+ ", 전화: " + tel
					+ ", 주소: " + addr
					+ ", 소속: " + org + "}";
		}
		
		// name이 같은 경우 같은 객체로 본다는 규칙이 있는 경우
		// 아래와 같이 equals를 override해주면 된다.
		@Override
		public boolean equals(Object obj) {
			if (obj == null) {
				return false;
			}
			if (obj instanceof NameCard) {
				if (((NameCard) obj).name.equals(this.name)) {
					return true;
				}
			}
			return false;
		}
		
	}
	
	public static void print(Object o) {
		System.out.println(o);
	}
	
	public static void equalsTest(Object o1, Object o2) {
		System.out.println(o1 == o2);		// 참조값을 비교 (같은 객체라면 true)
		System.out.println(o1.equals(o2));	// Object.equals() 메소드를 테스트
	}
	
	public static void main(String[] args) {
		
		B b1 = new B(3), b2 = new B(10);
		
		print(b1);
		print(b2);
		
		equalsTest(b1, b2);
		
		System.out.println("alkdghalkdgh");	// String의 toString()이 override되지 않았다면?
											// java.lang.String@123c34de => 이런식으로 출력됐을 것임
		
		NameCard card = new NameCard("홍길동", "02-1111-2222", "서울시 서초구", "비트");
		System.out.println(card);
		
		String s1 = new String("hello");
		String s2 = new String("hello");
		
		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2));
		
	}
	
}















