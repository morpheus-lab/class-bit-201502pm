package utils;

import java.util.*;

public class CollectionAndMap {
	
	static void test(Collection c) {
		c.add(new String("first"));
		c.add(new Integer(3));
		c.add(new String("second"));
		c.add(new Integer(3));
		c.add(new Boolean(false));
		System.out.println(c);
	}
	
	static void test(Map m) {
		m.put("1", new String("first"));
		m.put("2", new Integer(3));
		m.put("3", new String("second"));
		m.put("4", new Integer(3));
		m.put("5", new Boolean(false));
		System.out.println(m);
	}
	
	public static void main(String[] args) {
		
		test(new ArrayList());
		
		test(new TreeMap());
	}
	
}
