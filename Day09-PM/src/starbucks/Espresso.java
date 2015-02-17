package starbucks;

public class Espresso extends Beverage {
	
	public Espresso() {
		description = "에스프레소";
	}
	
	// 상속받은 getDescription()이 있음
	
	@Override
	public double cost() {
		return 1500;
	}
	
}
