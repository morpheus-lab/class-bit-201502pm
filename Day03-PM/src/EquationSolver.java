
public class EquationSolver {
	
	public static void main(String[] args) {
		
		// ������ 2x + 4y = 10�� ��� �ظ� ���Ͻÿ�.
		// ��, x, y�� ����, 0<= x <=10, 0 <= y <= 10
		for (int x = 0; x <= 10; x++) {
			for (int y = 0; y <= 10; y++) {
				
				if (x * 2 + y * 4 == 10) {
					System.out.println("x=" + x + ", y=" + y);
				}
				
			}
		}
		
	}
	
}
