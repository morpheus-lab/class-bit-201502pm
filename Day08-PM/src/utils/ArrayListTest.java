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
		list2.addAll(list);		// list �÷����� ��� �����͸� �ѹ��� �߰�
		
		list2.add("4");
		list2.add("5");
		
		Iterator it = list2.iterator();
		while (it.hasNext()) {	// ��ȸ�� �������� �� ���� �ִ���?
			Object item = it.next();
			System.out.println(item);
		}
		
		System.out.println(list2.contains("2"));
		System.out.println(list2.contains("6"));
		
		// list => {1, 2, 3}
		// list2 => {1, 2, 3, 4, 5}
		
		System.out.println(list2.containsAll(list));
		System.out.println(list.containsAll(list2));
		
//		list2.removeAll(list);	// �������� ��� ����
//		System.out.println(list2);	// ArrayList�� toString()�� ������ �Ǿ� �ֱ� ������
									// �׳� ����ص� ���� ���� ���·� �Ǿ� ����
		
		list2.retainAll(list);	// �������� �ƴ� ��Ҹ� ��� ����
		System.out.println(list2);
		
		Object[] items = list2.toArray();	// �÷��� ���� ����� ��� �����͸�
											// �迭 ��ü�� ����
		for (int i = 0; i < items.length; i++) {
			System.out.println(items[i]);
		}
		
	}
	
}























