package starbucks;

public class MochaSyrup extends CondimentDecorator {
	
	private Beverage baseBeverage;
	
	public MochaSyrup(Beverage baseBeverage) {
		this.baseBeverage = baseBeverage;
		description = "모카 시럽";
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
