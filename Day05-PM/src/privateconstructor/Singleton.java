package privateconstructor;

public class Singleton {	// 싱글턴 패턴: 시스템 상에 이 클래스 타입의 객체가
							//			 단 한 개만 존재하도록 만드는 기법
	
	private static Singleton instance;
	
	private Singleton() {	// 마음대로 new.. 하지 못하도록
	}
	
	public static Singleton getInstance() {
		if (instance == null) {
			instance = new Singleton();
		}
		return instance;
	}
	
}

class SingletonUser {
	public static void main(String[] args) {
//		Singleton s = new Singleton();
		Singleton s = Singleton.getInstance();
		
		Singleton s2 = Singleton.getInstance();
	}
}
