package clazz;

public class ClassForNameTest {
	
	static String dbDriverName = "clazz.MSSQLDriver";
	
	public static void main(String[] args) throws Exception {
		
		Class c = Class.forName(dbDriverName);
		
		DBDriver driver = (DBDriver) c.newInstance();
		
		// DB ÀÛ¾÷
		driver.connect();
		
		driver.query("SELECT * FROM DUAL");
		
		driver.disconnect();
		
		
	}
	
}
