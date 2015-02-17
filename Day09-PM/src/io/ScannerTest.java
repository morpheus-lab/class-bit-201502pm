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
		
		System.out.print("��ħ�� ���� ��� ����: ");
		try {
			morningEggs = Integer.parseInt(sc.nextLine());
		} catch (Exception e) {
			System.err.println("��ħ ��� �Է� ����!");
		}
		
		System.out.print("���ɿ� ���� ��� ����: ");
		try {
			lunchEggs = Integer.parseInt(sc.nextLine());
		} catch (Exception e) {
			System.err.println("���� ��� �Է� ����!");
		}
		
		System.out.print("���ῡ ���� ��� ����: ");
		try {
			dinnerEggs = Integer.parseInt(sc.nextLine());
		} catch (Exception e) {
			System.err.println("���� ��� �Է� ����!");
		}
		
		totalEggs = morningEggs + lunchEggs + dinnerEggs;
		
		System.out.println("���� �Ϸ� ���� ��� " + totalEggs + "���� ��̱���!");
		
		if (totalEggs > 10) {
			System.out.println("Ʈ���� ����������.. ����...");
		}
		
	}
	
}
