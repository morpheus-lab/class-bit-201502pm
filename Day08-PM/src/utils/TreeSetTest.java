package utils;

import java.util.*;

public class TreeSetTest {
	
	public static class Data {
		int data;
		
		public Data(int data) {
			this.data = data;
		}
		
		@Override
		public String toString() {
			return String.valueOf(data);
		}
	}
	
	public static void main(String[] args) {
		
		Comparator<Data> comparator = new Comparator<Data>() {

			@Override
			public int compare(Data o1, Data o2) {
				// o1.data == 8
				// o2.data == 3
//				return o1.data - o2.data;	// o1.data - o2.data == 5 => ��� => o1�� �ڿ� ��ġ
				return o2.data - o1.data;	// o2.data - o1.data == -5 => ���� => o1�� �տ� ��ġ
				// ���� �����ϸ�: o1�� ������ �ռ���
				// 0 �����ϴ� ���: o1�� o2�� ������ ����
				// ��� �����ϸ�: o1�� o2���� ������ �ڼ���
			}
			
		};
		
		TreeSet<Data> set = new TreeSet<Data>(comparator);	// TreeSet�� ����� ������ ����
															// comparator�� �����ϴ� ���
		set.add(new Data(5));
		set.add(new Data(10));
		set.add(new Data(3));
		set.add(new Data(8));
		set.add(new Data(1));
		
		System.out.println(set);
		
	}
	
}
