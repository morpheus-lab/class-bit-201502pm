package clazz;

import java.lang.reflect.*;
//import java.lang.reflect.Field;
//import java.lang.reflect.Method;

public class ClassClassTest {
	
	public int a;
	public int b;
	public int[] c;
	public String d;
	
	public void m1() {
		
	}
	
	public void m2(int a) {
		
	}
	
	public static void main(String[] args) throws Exception {
		
		ClassClassTest t = new ClassClassTest();
		
		Class classInfo = t.getClass();	// ��ü t�� Ŭ���� ���� ���
		
		// ��ü t�� �ʵ� (��� ����) ��ȸ
		Field[] fields = classInfo.getFields();
		for (int i = 0; i < fields.length; i++) {
			Field f = fields[i];
			System.out.println(f.getName() + ": " + f.getType());
		}
		
		System.out.println("-------------------");
		
		// ��ü t�� �޼ҵ� ��ȸ
		Method[] methods = classInfo.getMethods();
		for (int i = 0; i < methods.length; i++) {
			Method m = methods[i];
			System.out.println(m.getName());
		}
		
		System.out.println("-------------------");
		
		Object obj = classInfo.newInstance();
		
		System.out.println(t);
		
		System.out.println(obj);
		
		
	}
	
}






























