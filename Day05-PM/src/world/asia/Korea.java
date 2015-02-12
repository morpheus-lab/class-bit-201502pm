package world.asia;

public class Korea {

	private int population;			// 인구
	
	String capital;					// 수도
	
	private String[] special = {
			"진주실크", "대구사과", "천안호도과자" };
	
	public String name;
	
	protected String president;
	
	public void setPopulation(int population) {
		if (population > 0) {
			this.population = population;
		}
	}
	
	void doSomething() {
		population += 100000;
		capital = "서울";
		special[0] = "한산모시";
		name = "대한민국";
		president = "박근혜";
	}
	
}














