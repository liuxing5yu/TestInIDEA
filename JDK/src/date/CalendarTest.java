package date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

/**
 * @author : lzq
 * @Date : 2015年7月30日 下午1:49:05
 * @Comments : Calendar工具类
 * @Version : 1.0.0
 */
public class CalendarTest {

	public static void main(String[] args) {
		// Calendar的子类
		// GregorianCalendar
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		// 设置日期为2011-07-24 09：59:50
		calendar.set(2011, 06, 24, 9, 59, 50);
		// 12小时制
		int temp12Hour = Calendar.HOUR;
		// 24小时制
		int temp24Hour = calendar.HOUR_OF_DAY;
		// 显示年份
		int yearIndex = Calendar.YEAR;
		int year = calendar.get(yearIndex);
		System.out.println("yearIndex=" + yearIndex);
		System.out.println("year=" + year);
		// 显示月份 (从0开始, 实际显示要加一)
		int monthIndex = Calendar.MONTH;
		int month = calendar.get(monthIndex) + 1;
		System.out.println("monthIndex=" + monthIndex);
		System.out.println("month=" + month);
		// 今年的第几天
		int dayOfYearIndex = Calendar.DAY_OF_YEAR;
		int dayOfYear = calendar.get(dayOfYearIndex);
		System.out.println("dayOfYearIndex=" + dayOfYearIndex);
		System.out.println("dayOfYear=" + dayOfYear);
		// 本月的第N天
		int dayOfMonthIndex = Calendar.DAY_OF_MONTH;
		int dayOfMonth = calendar.get(dayOfMonthIndex);
		System.out.println("dayOfMonthIndex=" + dayOfMonthIndex);
		System.out.println("dayOfMonth=" + dayOfMonth);
		// 本周第N天，从周日开始
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		if (dayOfWeek == 0) {
			dayOfWeek = 7;
		}
		System.out.println("dayOfWeek=" + dayOfWeek);
		// 三小时以后
		int hourOfDayIndex = Calendar.HOUR_OF_DAY;
		calendar.add(hourOfDayIndex, 3);
		int afterThreeHour = calendar.get(hourOfDayIndex);
		System.out.println("afterThreeHour=" + afterThreeHour);
		// 当前分钟数
		int minuteIndex = Calendar.MINUTE;
		int minute = calendar.get(minuteIndex);
		System.out.println("minuteIndex=" + minuteIndex);
		System.out.println("minute=" + minute);
		// 15分钟以后
		calendar.add(minuteIndex, 15);
		minute = calendar.get(minuteIndex);
		System.out.println("minute+15=" + minute);
		// 30分钟以前
		calendar.add(minuteIndex, -30);
		minute = calendar.get(minuteIndex);
		System.out.println("minute-30=" + minute);
		// 格式化显示
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS");
		String time = sdf.format(calendar.getTime());
		System.out.println(time);
		// 重置Calendar显示当前时间
		calendar.setTime(new Date());
		time = sdf.format(calendar.getTime());
		System.out.println(time);
		// 创建一个Calendar 用于比较时间
		Calendar calendarNew = Calendar.getInstance();
		// 设定为5小时以前，后者大，显示-1
		calendarNew.add(Calendar.HOUR, -5);
		System.out.println("时间比较：" + calendarNew.compareTo(calendar));
		// 设定7小时以后，前者大 ，显示1
		calendarNew.add(Calendar.HOUR, +7);
		System.out.println("时间比较：" + calendarNew.compareTo(calendar));
		// 退回2小时，时间相同，显示0
		calendarNew.add(Calendar.HOUR, -2);
		System.out.println("时间比较：" + calendarNew.compareTo(calendar));
		// 创建两个日历对象
		Calendar cal = Calendar.getInstance();
		Calendar future = Calendar.getInstance();
		// 打印当前日期
		System.out.println("Current date: " + cal.getTime());
		// 改变年份
		future.set(Calendar.YEAR, 2066);
		System.out.println("Year is " + future.get(Calendar.YEAR));
		// 检查日期是否在当前日期之后
		if (future.after(cal)) {
			System.out.println("Date " + future.getTime() + " is after current date.");
		}
	}
	
	@Test
	public void test1() {
		 Calendar cal = Calendar.getInstance();
	        int year = cal.get(Calendar.YEAR);//获取年份
	        int month=cal.get(Calendar.MONTH);//获取月份
	        int day=cal.get(Calendar.DATE);//获取日
	        int hour=cal.get(Calendar.HOUR);//小时
	        int minute=cal.get(Calendar.MINUTE);//分           
	        int second=cal.get(Calendar.SECOND);//秒
	        int WeekOfYear = cal.get(Calendar.DAY_OF_WEEK);//一周的第几天
	        System.out.println("现在的时间是：公元"+year+"年"+month+"月"+day+"日      "+hour+"时"+minute+"分"+second+"秒       星期"+WeekOfYear);
	  
	}

}