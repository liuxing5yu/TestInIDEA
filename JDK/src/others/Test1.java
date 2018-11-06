/**
 * 
 */
package others;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

/**
 * @author hwj
 * @date 2017年10月29日 下午8:21:03 
 *
 */
public class Test1 {

	private String strxx;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Collections.sort(null);

		Collections.sort(null);

		Collections.sort(null);

	}

	public void test1() {
		getCalendar();
		System.out.println(strxx);
		
	}

	/**
	 * 
	 */
	private void getCalendar() {
		Calendar calendar = Calendar.getInstance();
		int i = calendar.get(0);
		String calendarType = calendar.getCalendarType();
		String x = i + calendarType;
		System.out.println(x);
		
	}

	public void test2() {

	}

	public String getStrxx() {
		return strxx;
	}

	public void setStrxx(String str) {
		this.strxx = str;
	}
}
