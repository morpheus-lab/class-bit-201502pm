package starbucks;

/**
 * 음료에 추가할 수 있는 첨가물
 */
public abstract class CondimentDecorator extends Beverage {
	
	public abstract String getDescription();	// 현재 클래스 하위의 클래스가
												// getDescription() 메소드를 반드시 재정의하도록
												// 강제하기 위해
	
}
