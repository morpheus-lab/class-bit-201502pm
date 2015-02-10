
public class Gugudan {

	public static void main(String[] args) {
		
		/*
		for (;;) {
			// 무한 반복
		}
		*/
		
		int dan = 2;
		for (; dan <= 9; dan++) {
		
			for (int i = 1; i <= 9; i++) {
				System.out.println(dan + " * " + i + " = " + (dan * i));
			}
			
			// 단 하나가 출력 완료되는 시점
			System.out.println();
		
		}
		
		
		
	}

}























