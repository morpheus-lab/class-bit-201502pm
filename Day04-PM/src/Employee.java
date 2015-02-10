
public class Employee {
	
	// 멤버 변수 (필드, fields) 정의
	// 인스턴스 멤버 변수
	String name;
	String no;
	String dept;
//	this();	// 불가!!!
	
	// 생성자 정의
	
	// 생성자 #1
	public Employee() {
//		name = "이름없음"; no = "임시사번"; dept = "임시부서";
//		this();
//		int a = 10;
		this("이름없음", "임시사번", "임시부서");
		System.out.println("인자 없는 생성자가 호출됨!!!");
	}
	
	// 생성자 #2
	public Employee(String na, String n, String d) {
		name = na; no = n; dept = d;
		System.out.println("인자 세 개짜리 생성자 호출됨!!!");
	}
	
	// 메소드 정의
	public void print() {
//		this();	// 불가!!!
		System.out.println(name + ", " + no + ", " + dept);
	}
	
}
