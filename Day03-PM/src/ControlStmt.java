
public class ControlStmt {
	
	static int mul(int a, int b) {
		int x = a * b;
		
		// b�� Ȧ���� ��� ���� ���� �������� �ʰ�, -1�� ����
		if (b % 2 == 1) {
			return -1;
		}
		
		return x;
	}
	
	public static void main(String[] args) {
		
		int dan = 2;
		int i = 1;
		
		while (true) {
			// �� �ܿ� ����
			i = 0;
			while (true) {
				// �� ������ ����
				i ++;
				if (i == 10) {
					break;
				}
//				if (i % 2 == 1) {
//					continue;
//				}
				System.out.println(dan + " * " + i + " = " + mul(dan, i));
			}
			dan ++;
			System.out.println();
			if (dan == 10) {
				break;
			}
		}
		
	}
	
}
