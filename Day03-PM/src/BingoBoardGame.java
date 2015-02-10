import java.util.Random;
import java.util.Scanner;


public class BingoBoardGame {
	
	public static void main(String[] args) {
		
		int[][] board = new int[5][5];
		
		int num = 0;
		
		Math.random();	// double 타입 데이터 반환. 0이상 ~ 1미만의 실수
		
		num = (int) (Math.random() * 25) + 1;	// 1 이상 ~ 25 이하 정수
		
		Random random = new Random();
		random.nextInt(25); // 0 이상 bound 미만의 int 타입 랜덤 숫자 반환
		
		num = random.nextInt(25) + 1;	// 1 이상 ~ 25 이하 정수
		
		for (int y = 0; y < 5; y++) {
			for (int x = 0; x < 5; x++) {
				
				board[x][y] = random.nextInt(25) + 1;
				
				// 이전 값과 비교해서 중복된 값이 있으면 다시
				LOOP_COMPARE:
				for (int y1 = 0; y1 < 5; y1++) {
					for (int x1 = 0; x1 < 5; x1++) {
						// 자기 자신과 비교 시 break
						if (x == x1 && y == y1) {
							break LOOP_COMPARE;
						}
						if (board[x][y] == board[x1][y1]) {
							x --;
							break LOOP_COMPARE;
						}
					}
				}
			}
		}
		
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			// 게임판 출력
			for (int y = 0; y < 5; y++) {
				for (int x = 0; x < 5; x++) {
					System.out.print(board[x][y] + "\t");
				}
				System.out.println();
			}
			
			// 사용자로부터 숫자 입력받고
			System.out.print("삭제할 숫자를 입력하세요: ");
			int inputNum = sc.nextInt();
			
			// 입력 숫자를 게임판에서 삭제
			LOOP_DELETE:
			for (int y = 0; y < 5; y++) {
				for (int x = 0; x < 5; x++) {
					if (board[x][y] == inputNum) {
						board[x][y] = 0;
						break LOOP_DELETE;
					}
				}
			}
			// 빙고 완성 검사
			int lineCount = 0;
			boolean completed = true;
			// (1) 가로 방향 검사
			for (int y = 0; y < 5; y++) {
				completed = true;
				for (int x = 0; x < 5; x++) {
					if (board[x][y] != 0) {
						completed = false;
						break;
					}
				}
				if (completed) {
					// x축 방향 검사 결과 모두 0인 경우
					lineCount ++;	// 라인 카운트 1 증가
				}
			}
			// (2) 세로 방향 검사
			for (int x = 0; x < 5; x++) {
				completed = true;
				for (int y = 0; y < 5; y++) {
					if (board[x][y] != 0) {
						completed = false;
						break;
					}
				}
				if (completed) {
					// y축 방향 검사 결과 모두 0인 경우
					lineCount ++;	// 라인 카운트 1 증가
				}
			}
			// (3) 왼쪽 위 -- 오른쪽 아래 대각선
			completed = true;
			for (int i = 0; i < 5; i++) {
				if (board[i][i] != 0) {
					completed = false;
					break;
				}
			}
			if (completed) {
				lineCount ++;
			}
			// (4) 왼쪽 아래 -- 오른쪽 위 대각선
			completed = true;
			for (int i = 0; i < 5; i++) {
				if (board[i][5 - i - 1] != 0) {
					completed = false;
					break;
				}
			}
			if (completed) {
				lineCount ++;
			}
			
			// 빙고가 완성됐다면 while 반복문 벗어나기
			if (lineCount >= 5) {
				System.out.println("빙고!!!");
				break;
			}
			
		}
	}
	
}






















