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
		
		System.out.print("��ħ�� ���� ��� ����: ");
		morningEggs = reader.readLine();
		
		System.out.print("���ɿ� ���� ��� ����: ");
		lunchEggs = reader.readLine();
		
		System.out.print("���ῡ ���� ��� ����: ");
		dinnerEggs = reader.readLine();
		
		totalEggs = Integer.parseInt(morningEggs)
				+ Integer.parseInt(lunchEggs)
				+ Integer.parseInt(dinnerEggs);
		
		System.out.println("���� �Ϸ� ���� ��� " + totalEggs + "���� ��̱���!");
		
		if (totalEggs > 10) {
			System.out.println("Ʈ���� ����������.. ����...");
		}
		
	}
	
}
