
public class Employee {
	
	// ��� ���� (�ʵ�, fields) ����
	// �ν��Ͻ� ��� ����
	String name;
	String no;
	String dept;
//	this();	// �Ұ�!!!
	
	// ������ ����
	
	// ������ #1
	public Employee() {
//		name = "�̸�����"; no = "�ӽû��"; dept = "�ӽúμ�";
//		this();
//		int a = 10;
		this("�̸�����", "�ӽû��", "�ӽúμ�");
		System.out.println("���� ���� �����ڰ� ȣ���!!!");
	}
	
	// ������ #2
	public Employee(String na, String n, String d) {
		name = na; no = n; dept = d;
		System.out.println("���� �� ��¥�� ������ ȣ���!!!");
	}
	
	// �޼ҵ� ����
	public void print() {
//		this();	// �Ұ�!!!
		System.out.println(name + ", " + no + ", " + dept);
	}
	
}
