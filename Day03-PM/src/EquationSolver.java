
public class EquationSolver {
	
	public static void main(String[] args) {
		
		// 방정식 2x + 4y = 10의 모든 해를 구하시오.
		// 단, x, y는 정수, 0<= x <=10, 0 <= y <= 10
		for (int x = 0; x <= 10; x++) {
			for (int y = 0; y <= 10; y++) {
				
				if (x * 2 + y * 4 == 10) {
					System.out.println("x=" + x + ", y=" + y);
				}
				
			}
		}
		
	}
	
}
