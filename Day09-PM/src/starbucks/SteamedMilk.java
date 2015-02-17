package starbucks;

public class SteamedMilk extends CondimentDecorator {
	
	private Beverage baseBeverage;
	
	public SteamedMilk(Beverage baseBeverage) {
		this.baseBeverage = baseBeverage;
		description = "½ºÆÀ ¹ÐÅ©";
	}
	
	@Override
	public String getDescription() {
		return baseBeverage.getDescription()
				+ " + " + description;
	}

	@Override
	public double cost() {
		return baseBeverage.cost() + 1000;
	}
	
}
