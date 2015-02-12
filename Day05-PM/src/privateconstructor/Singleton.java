package privateconstructor;

public class Singleton {	// �̱��� ����: �ý��� �� �� Ŭ���� Ÿ���� ��ü��
							//			 �� �� ���� �����ϵ��� ����� ���
	
	private static Singleton instance;
	
	private Singleton() {	// ������� new.. ���� ���ϵ���
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
