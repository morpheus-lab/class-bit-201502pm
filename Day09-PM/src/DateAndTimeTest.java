import java.util.Calendar;


public class DateAndTimeTest {
	
	public static void main(String[] args) {
		
		Calendar calendar = Calendar.getInstance();
		
		System.out.println(calendar);
		
		int year = calendar.get(Calendar.YEAR);	// Calendar.YEAR == 1
		System.out.println(year);
		
		int month = calendar.get(Calendar.MONTH);	// 0: 1��, 1: 2��, ...
		System.out.println(month);
		
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		System.out.println(day);
		
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		System.out.println(hour);
		
		int minute = calendar.get(Calendar.MINUTE);
		System.out.println(minute);
		
		int second = calendar.get(Calendar.SECOND);
		System.out.println(second);
		
		int millis = calendar.get(Calendar.MILLISECOND);
		System.out.println(millis);
		
		// ������ ������ ��ȸ
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		System.out.println(dayOfWeek);
		// 1: �Ͽ���, 2: ������, ..., 7: �����
		
		// �⵵�� 2016������ ����
		calendar.set(Calendar.YEAR, 2016);
		
		System.out.println(calendar);
		
	}
	
}


























