package utils;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListTest {
	
	public static void main(String[] args) {
		
		ArrayList list = new ArrayList();
		
		System.out.println("list isEmpty(): " + list.isEmpty());
		
		list.add("1");
		list.add("2");
		list.add("3");
		
		System.out.println("list isEmpty(): " + list.isEmpty());
		
		ArrayList list2 = new ArrayList();
		list2.addAll(list);		// list 컬렉션의 모든 데이터를 한번에 추가
		
		list2.add("4");
		list2.add("5");
		
		Iterator it = list2.iterator();
		while (it.hasNext()) {	// 순회할 아이템이 더 남아 있는지?
			Object item = it.next();
			System.out.println(item);
		}
		
		System.out.println(list2.contains("2"));
		System.out.println(list2.contains("6"));
		
		// list => {1, 2, 3}
		// list2 => {1, 2, 3, 4, 5}
		
		System.out.println(list2.containsAll(list));
		System.out.println(list.containsAll(list2));
		
//		list2.removeAll(list);	// 교집합을 모두 제거
//		System.out.println(list2);	// ArrayList의 toString()이 재정의 되어 있기 때문에
									// 그냥 출력해도 보기 좋은 형태로 되어 있음
		
		list2.retainAll(list);	// 교집합이 아닌 요소를 모두 제거
		System.out.println(list2);
		
		Object[] items = list2.toArray();	// 컬렉션 내에 저장된 모든 데이터를
											// 배열 객체로 꺼냄
		for (int i = 0; i < items.length; i++) {
			System.out.println(items[i]);
		}
		
	}
	
}























