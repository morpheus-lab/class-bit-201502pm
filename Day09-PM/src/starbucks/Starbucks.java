package starbucks;

public class Starbucks {
	
	public static void main(String[] args) {
		
		Beverage b = new Espresso();	// ���̽� ����
		
		b = new SteamedMilk(b);	// ���� ��ũ �߰�
		
//		b = new MochaSyrup(b);	// ��ī �÷� �߰�
		
		b = new Whip(b);		// ���� ũ�� �߰�
		
		System.out.println(b.getDescription());
		System.out.println(b.cost());
		
	}
	
}
