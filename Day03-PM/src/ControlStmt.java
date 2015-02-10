
public class ControlStmt {
	
	static int mul(int a, int b) {
		int x = a * b;
		
		// b가 홀수인 경우 정상 값을 리턴하지 않고, -1을 리턴
		if (b % 2 == 1) {
			return -1;
		}
		
		return x;
	}
	
	public static void main(String[] args) {
		
		int dan = 2;
		int i = 1;
		
		while (true) {
			// 각 단에 대해
			i = 0;
			while (true) {
				// 각 곱셈에 대해
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
