
import java.util.*;

public class MapTest {
	
	public static void main(String[] args) {
		
		HashMap map = new HashMap();
//		TreeMap map = new TreeMap();
		
		map.put("banana", new String("banana"));
		map.put("obj", new Object());
		map.put("apple", new MapTest());
		
		// 해시맵 내 데이터 조회
		Set keys = map.keySet();	// 모든 데이터의 키(이름표)를 추출
		Iterator keyIter = keys.iterator();
		while (keyIter.hasNext()) {
			Object key = keyIter.next();
			Object value = map.get(key);
			
			System.out.println(key + " = " + value);
		}
		
		// 키를 알고 있다면 저장된 데이터를 쉽게 조회 가능
		System.out.println(map.get("apple"));
	}
	
}



































