package interfaces;

public class FlyingCar extends Car implements FlyingObject {

	@Override
	public void takeoff() {
		
		System.out.println(FlyingObject.fly);
//		FlyingObject.fly = "land";
		
		System.out.println("ÀÌ·úÇÕ´Ï´Ù");
	}

	@Override
	public void land() {
		System.out.println("Âø·ú!");
	}


}
