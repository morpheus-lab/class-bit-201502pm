package starbucks;

public class Espresso extends Beverage {
	
	public Espresso() {
		description = "����������";
	}
	
	// ��ӹ��� getDescription()�� ����
	
	@Override
	public double cost() {
		return 1500;
	}
	
}
