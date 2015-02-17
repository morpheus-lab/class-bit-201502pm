import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;


public class PropertiesTest {
	
	public static void main(String[] args) throws IOException {
		/*
		Properties props = System.getProperties();
		
		// Ű��� �̷���� �ִ� Enumeration ��ü ��ȯ
		Enumeration keys = props.keys();
		while (keys.hasMoreElements()) {	// ���� Ŀ�� �ڿ� �����Ͱ� �ֳ�?
			String key = (String) keys.nextElement();
			String val = (String) props.get(key);
			
			System.out.println(key + " = " + val);
		}
		*/
		
		// properties ���� �ҷ�����
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



























