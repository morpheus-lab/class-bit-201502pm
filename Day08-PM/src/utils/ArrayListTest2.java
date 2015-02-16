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
			System.out.println(lit.next());		// ���������� Ŀ���� �̵�
		}
		
		// Ŀ���� �������� ������ �� �� next() ȣ���ϸ�
//		lit.next();	// NoSuchElementException �߻�
		
		System.out.println("----------------------");
		
		lit.add("5");
		
		System.out.println("----------------------");
		
		while (lit.hasPrevious()) {
			System.out.println(lit.previous());	// ���������� Ŀ���� �̵�
		}
		
		// lit Ŀ���� ������ �� �տ� ��ġ
		
		lit.add("a");
		
		System.out.println(list);
		
		lit.add("b");	// �������� add �� �� �ٷ� �ڿ� Ŀ���� ��ġ
		
		System.out.println(list);
		
		// Ŀ���� "b" �ٷ� �ڿ� �ְ���
		
		lit.previous();	// Ŀ���� "b" ������ �̵�
		
		lit.add("c");	// Ŀ���� "c" �ٷ� �ڿ� ��ġ
		
		System.out.println(list);
		
		lit.next();
		lit.next();	// Ŀ���� "1" �ڿ�
		
		lit.add("z");
		
		System.out.println(list);
		
	}
	
}





















