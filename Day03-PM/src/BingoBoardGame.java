import java.util.Random;
import java.util.Scanner;


public class BingoBoardGame {
	
	public static void main(String[] args) {
		
		int[][] board = new int[5][5];
		
		int num = 0;
		
		Math.random();	// double Ÿ�� ������ ��ȯ. 0�̻� ~ 1�̸��� �Ǽ�
		
		num = (int) (Math.random() * 25) + 1;	// 1 �̻� ~ 25 ���� ����
		
		Random random = new Random();
		random.nextInt(25); // 0 �̻� bound �̸��� int Ÿ�� ���� ���� ��ȯ
		
		num = random.nextInt(25) + 1;	// 1 �̻� ~ 25 ���� ����
		
		for (int y = 0; y < 5; y++) {
			for (int x = 0; x < 5; x++) {
				
				board[x][y] = random.nextInt(25) + 1;
				
				// ���� ���� ���ؼ� �ߺ��� ���� ������ �ٽ�
				LOOP_COMPARE:
				for (int y1 = 0; y1 < 5; y1++) {
					for (int x1 = 0; x1 < 5; x1++) {
						// �ڱ� �ڽŰ� �� �� break
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
			// ������ ���
			for (int y = 0; y < 5; y++) {
				for (int x = 0; x < 5; x++) {
					System.out.print(board[x][y] + "\t");
				}
				System.out.println();
			}
			
			// ����ڷκ��� ���� �Է¹ް�
			System.out.print("������ ���ڸ� �Է��ϼ���: ");
			int inputNum = sc.nextInt();
			
			// �Է� ���ڸ� �����ǿ��� ����
			LOOP_DELETE:
			for (int y = 0; y < 5; y++) {
				for (int x = 0; x < 5; x++) {
					if (board[x][y] == inputNum) {
						board[x][y] = 0;
						break LOOP_DELETE;
					}
				}
			}
			// ���� �ϼ� �˻�
			int lineCount = 0;
			boolean completed = true;
			// (1) ���� ���� �˻�
			for (int y = 0; y < 5; y++) {
				completed = true;
				for (int x = 0; x < 5; x++) {
					if (board[x][y] != 0) {
						completed = false;
						break;
					}
				}
				if (completed) {
					// x�� ���� �˻� ��� ��� 0�� ���
					lineCount ++;	// ���� ī��Ʈ 1 ����
				}
			}
			// (2) ���� ���� �˻�
			for (int x = 0; x < 5; x++) {
				completed = true;
				for (int y = 0; y < 5; y++) {
					if (board[x][y] != 0) {
						completed = false;
						break;
					}
				}
				if (completed) {
					// y�� ���� �˻� ��� ��� 0�� ���
					lineCount ++;	// ���� ī��Ʈ 1 ����
				}
			}
			// (3) ���� �� -- ������ �Ʒ� �밢��
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
			// (4) ���� �Ʒ� -- ������ �� �밢��
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
			
			// ���� �ϼ��ƴٸ� while �ݺ��� �����
			if (lineCount >= 5) {
				System.out.println("����!!!");
				break;
			}
			
		}
	}
	
}






















