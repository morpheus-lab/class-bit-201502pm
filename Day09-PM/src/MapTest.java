
import java.util.*;

public class MapTest {
	
	public static void main(String[] args) {
		
		HashMap map = new HashMap();
//		TreeMap map = new TreeMap();
		
		map.put("banana", new String("banana"));
		map.put("obj", new Object());
		map.put("apple", new MapTest());
		
		// �ؽø� �� ������ ��ȸ
		Set keys = map.keySet();	// ��� �������� Ű(�̸�ǥ)�� ����
		Iterator keyIter = keys.iterator();
		while (keyIter.hasNext()) {
			Object key = keyIter.next();
			Object value = map.get(key);
			
			System.out.println(key + " = " + value);
		}
		
		// Ű�� �˰� �ִٸ� ����� �����͸� ���� ��ȸ ����
		System.out.println(map.get("apple"));
	}
	
}



































