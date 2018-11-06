package datetime;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.MonthDay;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

import org.junit.Test;

/**
 * test java8 中的处理 date、time的新的API
 * {@link http://biezhi.me/2017/07/20/keep-up-with-java8-datetime.html}
 * @author 80953
 *
 */
public class TestDateTime {

	@Test
	public void testLocalDate() {
		// now()
		LocalDate localDate = LocalDate.now();
		System.out.println("localDate: " + localDate);

		// of()、parse()方法得到LocalDate对象
		LocalDate date1 = LocalDate.of(2017, 07, 20);
		System.out.println(date1);
		LocalDate date2 = LocalDate.parse("2017-07-20");
		System.out.println(date2);

		// 加一天
		LocalDate tomorrow = LocalDate.now().plusDays(1);
		System.out.println(tomorrow);

		// 减一个月
		LocalDate prevMonth = LocalDate.now().minus(1, ChronoUnit.MONTHS);
		System.out.println(prevMonth);

		// 获取每周中的星期和每月中的日
		DayOfWeek thursday = LocalDate.parse("2017-07-20").getDayOfWeek();
		System.out.println("周四: " + thursday);
		int twenty = LocalDate.parse("2017-07-20").getDayOfMonth();
		System.out.println("twenty: " + twenty);

		// 是不是闰年
		boolean leapYear = LocalDate.now().isLeapYear();
		System.out.println("是否闰年: " + leapYear);

		// 判断是否在日期之前或之后:
		boolean isBefore = LocalDate.parse("2017-07-20").isBefore(LocalDate.parse("2017-07-22"));
		System.out.println("isBefore: " + isBefore);
		boolean isAfter = LocalDate.parse("2017-07-20").isAfter(LocalDate.parse("2017-07-22"));
		System.out.println("isAfter: " + isAfter);

		// 获取这个月的第一天
		LocalDate firstDayOfMonth = LocalDate.parse("2017-07-20").with(TemporalAdjusters.firstDayOfMonth());
		System.out.println("这个月的第一天: " + firstDayOfMonth);
		firstDayOfMonth = firstDayOfMonth.withDayOfMonth(1);
		System.out.println("这个月的第一天: " + firstDayOfMonth);

		// 判断今天是否是我的生日
		LocalDate birthday = LocalDate.of(2009, 07, 20);
		MonthDay birthdayMd = MonthDay.of(birthday.getMonth(), birthday.getDayOfMonth());
		MonthDay today = MonthDay.from(LocalDate.now());
		System.out.println("今天是否是我的生日: " + today.equals(birthdayMd));
	}

	@Test
	public void testLocalTime() {
		// 获取现在的时间
		LocalTime now = LocalTime.now();
		System.out.println("现在的时间: " + now);

		// 将一个字符串时间解析为LocalTime
		LocalTime nowTime = LocalTime.parse("15:02");
		System.out.println("时间是: " + nowTime);

		// 使用静态方法of创建一个时间
		nowTime = LocalTime.of(15, 03);
		System.out.println("时间是: " + nowTime);

		// 使用解析字符串的方式并添加一小时，输出16:02
		LocalTime nextHour = LocalTime.parse("15:02").plus(1, ChronoUnit.HOURS);
		System.out.println("下一个小时: " + nextHour);

		// 获取时间的小时、分钟
		int hour = LocalTime.parse("15:02").getHour();
		System.out.println("小时: " + hour);
		int minute = LocalTime.parse("15:02").getMinute();
		System.out.println("分钟: " + minute);

		// 通过之前类似的API检查一个时间是否在另一个时间之前、之后
		boolean isBefore = LocalTime.parse("15:02").isBefore(LocalTime.parse("16:02"));
		boolean isAfter = LocalTime.parse("15:02").isAfter(LocalTime.parse("16:02"));
		System.out.println("isBefore: " + isBefore);
		System.out.println("isAfter: " + isAfter);

		// 在LocalTime类中也将每天的开始和结束作为常量供我们使用:
		System.out.println(LocalTime.MAX);
		System.out.println(LocalTime.MIN);
	}

	@Test
	public void testLocalDateTime() {
		// 获取当前的日期和时间:
		LocalDateTime now = LocalDateTime.now();
		System.out.println("现在: " + now);

		// 使用静态方法和字符串的方式分别创建LocalDateTime对象
		LocalDateTime.of(2017, Month.JULY, 20, 15, 18);
		LocalDateTime.parse("2017-07-20T15:18:00");

		// LocalDateTime也提供了相关API来对日期和时间进行增减操作:
		LocalDateTime tomorrow = now.plusDays(1);
		System.out.println("明天的这个时间: " + tomorrow);
		LocalDateTime minusTowHour = now.minusHours(2);
		System.out.println("两小时前: " + minusTowHour);

		// 这个类也提供一系列的get方法来获取特定单位:
		Month month = now.getMonth();
		System.out.println("当前月份: " + month);

	}

	/**
	 * 日期格式化
	 */
	@Test
	public void testFormat() {
		// 在日常开发中我们用到最多的也许就是日期、时间的格式化了，那在Java8种该如何操作呢？
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		System.out.println("默认格式化: " + now);
		System.out.println("自定义格式化: " + now.format(dateTimeFormatter));
		LocalDateTime localDateTime = LocalDateTime.parse("2017-07-20 15:27:44", dateTimeFormatter);
		System.out.println("字符串转LocalDateTime: " + localDateTime);

		// 也可以使用DateTimeFormatter的format方法将日期、时间格式化为字符串
		dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String dateString = dateTimeFormatter.format(LocalDate.now());
		System.out.println("日期转字符串: " + dateString);

	}

	/**
	 * 日期周期
	 */
	@Test
	public void testPeriod() {
		// 给初始化的日期添加5天:
		LocalDate initialDate = LocalDate.parse("2017-07-20");
		LocalDate finalDate = initialDate.plus(Period.ofDays(5));
		System.out.println("初始化日期: " + initialDate);
		System.out.println("加日期之后: " + finalDate);

		// 周期API中提供给我们可以比较两个日期的差别，像下面这样获取差距天数:
		long between = ChronoUnit.DAYS.between(initialDate, finalDate);
		System.out.println("差距天数: " + between);
	}

	/**
	 * 与遗留代码转换
	 */
	@Test
	public void testWithOldAPI() {
		// Date 和 Instant互相转换
		Date date = Date.from(Instant.now());
		Instant instant = date.toInstant();

		ZoneId zoneId = ZoneId.systemDefault();

		// Date 转换为 LocalDateTime
		LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zoneId);

		// LocalDateTime 转 Date
		date = Date.from(localDateTime.atZone(zoneId).toInstant());

		// LocalDate 转 Date
		date = Date.from(LocalDate.now().atStartOfDay().atZone(zoneId).toInstant());

	}
}
