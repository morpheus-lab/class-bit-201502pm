package world.america;

import world.asia.Korea;

public class USA {
	
	void mergeKorea(Korea korea) {
		
//		korea.population -= 10000;	// Korea의 private 필드
//		korea.capital = "워싱턴";		// package
//		korea.special[1] = "캘리포니아 오렌지";	// Korea의 private 필드
		korea.name = "미국";			// public
//		korea.president = "오바마";	// protected
		
	}
	
}
