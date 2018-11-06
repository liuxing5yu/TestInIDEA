/**
 * 
 */
package date;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import org.junit.Test;

/**
 * Java8日期和时间API
 * https://blog.csdn.net/a80596890555/article/details/58687444
 *
 * @author hwj
 * @date 2018年4月26日 下午4:10:22 
 *
 */
public class TestJava8DateAPI {
	public static void main(String[] args) {
		String strDate, strTime = "";
		Date objDate = new Date();
		System.out.println("今天的日期是：" + objDate);
		long time = objDate.getTime();
		System.out.println("自1970年1月1日起以毫秒为单位的时间（GMT）：" + time);
		strDate = objDate.toString();
		// 提取 GMT 时间
		strTime = strDate.substring(11, (strDate.length() - 4));
		// 按小时、分钟和秒提取时间
		strTime = "时间：" + strTime.substring(0, 8);
		System.out.println(strTime);
	}

	@Test
	public void testInstant() throws InterruptedException {
		Instant start = Instant.now();
		Thread.sleep(1000);
		Instant end = Instant.now();
		Duration timeElapsed = Duration.between(start, end);
		long millis = timeElapsed.toMillis();
		System.out.println("millis = " + millis);

		long hours = timeElapsed.toHours();
		System.out.println("hours = " + hours);
	}

	@Test
	public void testLocalDate() {
		// 获取当前日期
		LocalDate now = LocalDate.now();
		System.out.println("1-" + now);
		// 2017-01-01
		LocalDate newYear = LocalDate.of(2017, 1, 1);
		System.out.println("2-" + newYear);

		// 三天后
		System.out.println("3-" + now.plusDays(3));
		System.out.println("4-" + now);
		// 一周后
		System.out.println("5-" + now.plusWeeks(1));
		// 两天前
		System.out.println("6-" + now.minusDays(2));
		// 增加一个月不会出现2017-02-31 而是会返回该月的最后一个有效日期，即2017-02-28
		System.out.println("7-" + LocalDate.of(2017, 1, 31).plusMonths(1));
		System.out.println("7-2-" + LocalDate.of(2017, 3, 31).minusMonths(1));
		LocalDate feb = LocalDate.of(2017, 2, 1);
		System.out.println("8-" + feb);
		// withXxx()表示以该日期为基础，修改年、月、日字段，并返回一个新的日期
		// 2019-2-1
		System.out.println("9-" + feb.withYear(2019));
		// 2017-1-10
		System.out.println("10-" + feb.withDayOfYear(10));
		// 2017-2-10
		System.out.println("11-" + feb.withDayOfMonth(10));

		// 2019-02-01
		System.out.println("12-" + feb.plus(Period.ofYears(2)));
		// 2015-02-01
		System.out.println("13-" + feb.minus(Period.ofYears(2)));

		// 输出P9D，表示相差9天
		System.out.println("14-" + feb.until(LocalDate.of(2017, 2, 10)));

		// 比较日期前后
		System.out.println("15-" + feb.isBefore(LocalDate.of(2017, 3, 1)));
		System.out.println("16-" + feb.isAfter(LocalDate.of(2017, 3, 1)));

		// 是否闰年
		System.out.println("17-" + feb.isLeapYear());

		// DayOfWeek相关
		// SUNDAY
		System.out.println("18-" + feb.getDayOfWeek());
		System.out.println("19-" + feb.getEra());
		// TUESDAY
		System.out.println("20-" + DayOfWeek.SUNDAY.plus(2));

		// TemporalAdjusters相关
		// 2017-02-03的下一个星期五(包含当天) 2017-03-03
		System.out.println("21-" + LocalDate.of(2017, 2, 3).with(TemporalAdjusters.nextOrSame(DayOfWeek.FRIDAY)));
		// 2017-02-03的下一个星期五(不包含当天) 2017-02-10
		System.out.println("22-" + LocalDate.of(2017, 2, 3).with(TemporalAdjusters.next(DayOfWeek.FRIDAY)));
		// 2月中的第3个星期五 2017-02-17
		System.out.println(
				"23-" + LocalDate.of(2017, 2, 3).with(TemporalAdjusters.dayOfWeekInMonth(3, DayOfWeek.FRIDAY)));
		// 2月中的最后一个星期五 2017-02-24
		System.out.println("24-" + LocalDate.of(2017, 2, 3).with(TemporalAdjusters.lastInMonth(DayOfWeek.FRIDAY)));
		// 下个月的第一天
		System.out.println("25-" + LocalDate.of(2017, 2, 3).with(TemporalAdjusters.firstDayOfNextMonth()));

	}

	@Test
	public void testZoneId() {
		// 获得所有可用的时区 size=590
		System.out.println("1-" + ZoneId.getAvailableZoneIds().size());
		// 获取默认ZoneId对象
		ZoneId defZoneId = ZoneId.systemDefault();
		System.out.println("2-" + defZoneId);
		// 获取指定时区的ZoneId对象
		ZoneId shanghaiZoneId = ZoneId.of("Asia/Shanghai");
		System.out.println("3-" + shanghaiZoneId);
		// ZoneId.SHORT_IDS返回一个Map<String, String> 是时区的简称与全称的映射。下面可以得到字符串 Asia/Shanghai
		String shanghai = ZoneId.SHORT_IDS.get("CTT");
		System.out.println("4-" + shanghai);
	}

	@Test
	public void testZonedDateTime() {
		// 2017-01-20T17:35:20.885+08:00[Asia/Shanghai]
		System.out.println("1-" + ZonedDateTime.now());
		// 2017-01-01T12:00+08:00[Asia/Shanghai]
		System.out.println("2-" + ZonedDateTime.of(2017, 1, 1, 12, 0, 0, 0, ZoneId.of("Asia/Shanghai")));
		// 使用一个准确的时间点来创建ZonedDateTime，下面这个代码会得到当前的UTC时间，会比北京时间早8个小时
		System.out.println("3-" + ZonedDateTime.ofInstant(Instant.now(), ZoneId.of("UTC")));

		ZonedDateTime utcDateTime = ZonedDateTime.of(2017, 1, 1, 12, 0, 0, 0, ZoneId.of("UTC"));// 2017-01-01T12:00Z[UTC]
		System.out.println("4-" + utcDateTime);
		// withZoneSameLocal返回指定时区中的一个新ZonedDateTime，替换时区为指定时区，表示相同的本地时间的该时区时间。
		System.out.println("5-" + utcDateTime.withZoneSameLocal(ZoneId.of("Asia/Shanghai")));// 2017-01-01T12:00+08:00[Asia/Shanghai]
		// withZoneSameInstant返回指定时区中的一个新ZonedDateTime，替换为指定时区，表示相同时间点的该时区时间。
		System.out.println("6-" + utcDateTime.withZoneSameInstant(ZoneId.of("Asia/Shanghai")));// 2017-01-01T20:00+08:00[Asia/Shanghai]

		System.out.println("7-" + utcDateTime.plus(Duration.ofDays(7)));// 不能处理夏令时
		System.out.println("8-" + utcDateTime.plus(Period.ofDays(7)));// 正确方式
	}

	/**
	 * 
	 *
	 */
	@Test
	public void testLocalDateTime2ZonedDateTime() {
		// atZone方法可以将LocalDateTime转换为ZonedDateTime，下面的方法将时区设置为UTC。
		// 假设现在的LocalDateTime是2017-01-20 17:55:00 转换后的时间为2017-01-20 17:55:00[UTC]
		System.out.println("0-" + ZonedDateTime.now());
		System.out.println("1-" + LocalDateTime.now().atZone(ZoneId.of("UTC")));
		// 使用静态of方法创建zonedDateTime
		System.out.println("2-" + ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("UTC")));
	}

	/**
	 * 
	 *
	 */
	@Test
	public void testDateTimeFormatter() {
		// 2017-01-01
		System.out.println("1-" + DateTimeFormatter.ISO_LOCAL_DATE.format(LocalDate.of(2017, 1, 1)));
		// 20170101
		System.out.println("2-" + DateTimeFormatter.BASIC_ISO_DATE.format(LocalDate.of(2017, 1, 1)));
		// 2017-01-01T09:10:00
		System.out.println("3-" + DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(LocalDateTime.of(2017, 1, 1, 9, 10, 0)));

		// 2017年1月1日 星期日
		System.out.println("4-" + DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).format(LocalDate.of(2017, 1, 1)));
		// 上午09时10分00秒
		System.out.println("5-" + DateTimeFormatter.ofLocalizedTime(FormatStyle.LONG).format(LocalTime.of(9, 10, 0)));
		// 2017-2-27 22:32:03
		System.out
				.println("6-" + DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).format(LocalDateTime.now()));

		// Feb 27, 2017 10:34:36 PM
		System.out.println("7-" + DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).withLocale(Locale.US)
				.format(LocalDateTime.now()));

		// 2017-02-27 22:48:52
		System.out.println("8-" + DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now()));

		// 使用的ISO_LOCAL_DATE格式解析 2017-01-01
		System.out.println("9-" + LocalDate.parse("2017-01-01"));
		// 使用自定义格式解析 2017-01-01T08:08:08
		System.out.println(
				"10-" + LocalDateTime.parse("2017-01-01 08:08:08", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
	}

	@Test
	public void testTrans2OldAPI() {
		// Date --> Instant
		Instant timestamp = new Date().toInstant();
		// Instant --> Date
		Date.from(Instant.now());

		// GregorianCalendar --> ZonedDateTime
		ZonedDateTime zonedDateTime = new GregorianCalendar().toZonedDateTime();
		// ZonedDateTime --> GregorianCalendar
		GregorianCalendar.from(zonedDateTime);

		// 2017-02-27T21:16:13.647
		LocalDateTime.ofInstant(timestamp, ZoneId.of(ZoneId.SHORT_IDS.get("PST")));

		// Calendar --> Instant
		// 2017-02-28T05:16:13.656Z
		Calendar.getInstance().toInstant();
	}
}
