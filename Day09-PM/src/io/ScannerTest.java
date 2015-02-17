package io;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ScannerTest {
	
	public static void main(String[] args) {
		
		int morningEggs = 0;
		int lunchEggs = 0;
		int dinnerEggs = 0;
		
		int totalEggs = 0;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("아침에 먹은 계란 개수: ");
		try {
			morningEggs = Integer.parseInt(sc.nextLine());
		} catch (Exception e) {
			System.err.println("아침 계란 입력 오류!");
		}
		
		System.out.print("점심에 먹은 계란 개수: ");
		try {
			lunchEggs = Integer.parseInt(sc.nextLine());
		} catch (Exception e) {
			System.err.println("점심 계란 입력 오류!");
		}
		
		System.out.print("저녁에 먹은 계란 개수: ");
		try {
			dinnerEggs = Integer.parseInt(sc.nextLine());
		} catch (Exception e) {
			System.err.println("저녁 계란 입력 오류!");
		}
		
		totalEggs = morningEggs + lunchEggs + dinnerEggs;
		
		System.out.println("오늘 하루 동안 계란 " + totalEggs + "개를 드셨군요!");
		
		if (totalEggs > 10) {
			System.out.println("트림은 하지마세요.. 제발...");
		}
		
	}
	
}
