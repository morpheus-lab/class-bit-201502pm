package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EggMonster {
	
	public static void main(String[] args) throws IOException {
		
		String morningEggs;
		String lunchEggs;
		String dinnerEggs;
		
		int totalEggs = 0;
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("아침에 먹은 계란 개수: ");
		morningEggs = reader.readLine();
		
		System.out.print("점심에 먹은 계란 개수: ");
		lunchEggs = reader.readLine();
		
		System.out.print("저녁에 먹은 계란 개수: ");
		dinnerEggs = reader.readLine();
		
		totalEggs = Integer.parseInt(morningEggs)
				+ Integer.parseInt(lunchEggs)
				+ Integer.parseInt(dinnerEggs);
		
		System.out.println("오늘 하루 동안 계란 " + totalEggs + "개를 드셨군요!");
		
		if (totalEggs > 10) {
			System.out.println("트림은 하지마세요.. 제발...");
		}
		
	}
	
}
