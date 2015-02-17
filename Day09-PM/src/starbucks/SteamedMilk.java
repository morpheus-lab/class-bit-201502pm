package starbucks;

public class SteamedMilk extends CondimentDecorator {
	
	private Beverage baseBeverage;
	
	public SteamedMilk(Beverage baseBeverage) {
		this.baseBeverage = baseBeverage;
		description = "���� ��ũ";
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
