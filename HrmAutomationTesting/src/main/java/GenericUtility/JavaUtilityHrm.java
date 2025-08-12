package GenericUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtilityHrm {
	
	public String RandomNo() {
		Random r = new Random();
		int rNo = r.nextInt(999);
		return null;
	}
	
	public String currentDate() {
	Date date = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	String cDate = sdf.format(date);
	return cDate;
	
	}
	
	public String nextDate(int days) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String cDate = sdf.format(date);
		Calendar cal = sdf.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, days);
	    String nextDate = sdf.format(cal.getTime());
		return nextDate;
		
	}
	
	public String getCurrentDateTime() {
		String cDateTime = new Date().toString();
		String ssdateTime = cDateTime.replace(" ", "_").replace(":", "_");
		return ssdateTime;
		
		
	}
}
