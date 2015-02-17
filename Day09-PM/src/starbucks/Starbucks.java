package starbucks;

public class Starbucks {
	
	public static void main(String[] args) {
		
		Beverage b = new Espresso();	// 베이스 음료
		
		b = new SteamedMilk(b);	// 스팀 밀크 추가
		
//		b = new MochaSyrup(b);	// 모카 시럽 추가
		
		b = new Whip(b);		// 휘핑 크림 추가
		
		System.out.println(b.getDescription());
		System.out.println(b.cost());
		
	}
	
}
