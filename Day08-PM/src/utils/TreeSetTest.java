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
//				return o1.data - o2.data;	// o1.data - o2.data == 5 => 양수 => o1이 뒤에 배치
				return o2.data - o1.data;	// o2.data - o1.data == -5 => 음수 => o1이 앞에 배치
				// 음수 리턴하면: o1이 순서가 앞선다
				// 0 리턴하는 경우: o1과 o2의 순서가 같다
				// 양수 리턴하면: o1이 o2보다 순서가 뒤선다
			}
			
		};
		
		TreeSet<Data> set = new TreeSet<Data>(comparator);	// TreeSet이 사용할 정렬의 기준
															// comparator를 지정하는 경우
		set.add(new Data(5));
		set.add(new Data(10));
		set.add(new Data(3));
		set.add(new Data(8));
		set.add(new Data(1));
		
		System.out.println(set);
		
	}
	
}
