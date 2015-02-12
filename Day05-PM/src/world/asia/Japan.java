package world.asia;

public class Japan {
	
	void attackKorea(Korea korea) {
		
//		korea.population -= 10000;	// Korea의 private 필드
		korea.capital = "동경";		// package
//		korea.special[1] = "나가사키 카스테라";	// Korea의 private 필드
		korea.name = "일본";			// public
		korea.president = "아베";	// protected
		
	}
	
}
