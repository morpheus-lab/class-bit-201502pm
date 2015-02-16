package utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class ArrayListTest2 {
	
	public static void main(String[] args) {
		
		ArrayList list = new ArrayList();
		
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		
		Iterator it = list.iterator();
		
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		
		System.out.println("----------------------");
		
		ListIterator lit = list.listIterator();
		
		while (lit.hasNext()) {
			System.out.println(lit.next());		// 정방향으로 커서를 이동
		}
		
		// 커서가 마지막에 도달한 후 또 next() 호출하면
//		lit.next();	// NoSuchElementException 발생
		
		System.out.println("----------------------");
		
		lit.add("5");
		
		System.out.println("----------------------");
		
		while (lit.hasPrevious()) {
			System.out.println(lit.previous());	// 역방향으로 커서를 이동
		}
		
		// lit 커서는 아이템 맨 앞에 위치
		
		lit.add("a");
		
		System.out.println(list);
		
		lit.add("b");	// 아이템을 add 후 그 바로 뒤에 커서가 위치
		
		System.out.println(list);
		
		// 커서가 "b" 바로 뒤에 있겠죠
		
		lit.previous();	// 커서가 "b" 앞으로 이동
		
		lit.add("c");	// 커서가 "c" 바로 뒤에 위치
		
		System.out.println(list);
		
		lit.next();
		lit.next();	// 커서가 "1" 뒤에
		
		lit.add("z");
		
		System.out.println(list);
		
	}
	
}





















