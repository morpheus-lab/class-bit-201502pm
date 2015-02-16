package utils;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class ArrayListCapacity {
	
	static int getCapacity(ArrayList<?> l) throws Exception {
        Field dataField = ArrayList.class.getDeclaredField("elementData");
        dataField.setAccessible(true);
        return ((Object[]) dataField.get(l)).length;
    }
	
	public static void main(String[] args) throws Exception {
		
		ArrayList list = new ArrayList();
		
		for (int i = 0; i < 100; i++) {
			list.add(i);
			System.out.println(getCapacity(list));
		}
		
	}
	
}
