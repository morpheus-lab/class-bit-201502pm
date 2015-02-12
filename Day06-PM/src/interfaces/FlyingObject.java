package interfaces;

public interface FlyingObject {
	
	/* static final */ String fly = "Fly!!!";	// 이클립스에서 이탤릭 볼드 폰트로 표시되는 변수 => static 변수
	
	void run();
	
	/* public abstract */ void takeoff();
	
	void land();
	
}
