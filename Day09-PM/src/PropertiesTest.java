import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;


public class PropertiesTest {
	
	public static void main(String[] args) throws IOException {
		/*
		Properties props = System.getProperties();
		
		// 키들로 이루어져 있는 Enumeration 객체 반환
		Enumeration keys = props.keys();
		while (keys.hasMoreElements()) {	// 현재 커서 뒤에 데이터가 있나?
			String key = (String) keys.nextElement();
			String val = (String) props.get(key);
			
			System.out.println(key + " = " + val);
		}
		*/
		
		// properties 파일 불러오기
		Properties props = new Properties();
		props.load(PropertiesTest.class.getResourceAsStream("a.properties"));
		
		Enumeration keys = props.keys();
		while (keys.hasMoreElements()) {
			String key = (String) keys.nextElement();
			String val = (String) props.get(key);
			
			System.out.println(key + " = " + val);
		}
	}
	
}



























