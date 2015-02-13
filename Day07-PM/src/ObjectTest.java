
public class ObjectTest {
	
	private static class B {	// ���� Ŭ���� (inner class)
		// => ���� Ŭ������ �����ϵǸ� "{�ܺ�Ŭ������}${����Ŭ������}.class" �̸����� Ŭ���� ���� ������.
		// private ���� Ŭ������ �����, �ܺο����� ������ �� ����
		// ObjectTest Ŭ���� �������� ����ϴ� Ŭ������ ������ �� �ִ�.
		
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
			return "{�̸�: " + name
					+ ", ��ȭ: " + tel
					+ ", �ּ�: " + addr
					+ ", �Ҽ�: " + org + "}";
		}
		
		// name�� ���� ��� ���� ��ü�� ���ٴ� ��Ģ�� �ִ� ���
		// �Ʒ��� ���� equals�� override���ָ� �ȴ�.
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
		System.out.println(o1 == o2);		// �������� �� (���� ��ü��� true)
		System.out.println(o1.equals(o2));	// Object.equals() �޼ҵ带 �׽�Ʈ
	}
	
	public static void main(String[] args) {
		
		B b1 = new B(3), b2 = new B(10);
		
		print(b1);
		print(b2);
		
		equalsTest(b1, b2);
		
		System.out.println("alkdghalkdgh");	// String�� toString()�� override���� �ʾҴٸ�?
											// java.lang.String@123c34de => �̷������� ��µ��� ����
		
		NameCard card = new NameCard("ȫ�浿", "02-1111-2222", "����� ���ʱ�", "��Ʈ");
		System.out.println(card);
		
		String s1 = new String("hello");
		String s2 = new String("hello");
		
		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2));
		
	}
	
}















