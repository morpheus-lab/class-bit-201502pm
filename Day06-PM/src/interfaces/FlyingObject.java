package interfaces;

public interface FlyingObject {
	
	/* static final */ String fly = "Fly!!!";	// ��Ŭ�������� ���Ÿ� ���� ��Ʈ�� ǥ�õǴ� ���� => static ����
	
	void run();
	
	/* public abstract */ void takeoff();
	
	void land();
	
}
