package starbucks;

public class Whip extends CondimentDecorator {
	
	private Beverage baseBeverage;
	
	public Whip(Beverage baseBeverage) {
		this.baseBeverage = baseBeverage;
		description = "»÷«Œ ≈©∏≤";
	}
	
	@Override
	public String getDescription() {
		return baseBeverage.getDescription()
				+ " + " + description;
	}

	@Override
	public double cost() {
		return baseBeverage.cost() + 500;
	}
	
}
