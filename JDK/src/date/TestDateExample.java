/**
 * 
 */
package date;

import java.time.Clock;
import java.time.DateTimeException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.MonthDay;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

import org.junit.Test;

/**
 * Java 8时间和日期API 20例
 * http://www.importnew.com/15637.html
 *
 * @author hwj
 * @date 2018年4月27日 下午1:15:51 
 *
 */
public class TestDateExample {

	private LocalDate today = LocalDate.now();

	/**
	 * 在Java 8中获取今天的日期
	 *
	 */
	@Test
	public void test1() {
		LocalDate today = LocalDate.now();
		System.out.println("Today's Local date : " + today);
	}

	/**
	 * 在Java 8中获取年、月、日信息
	 *
	 */
	@Test
	public void test2() {
		LocalDate today = LocalDate.now();
		int year = today.getYear();
		int month = today.getMonthValue();
		int day = today.getDayOfMonth();
		System.out.printf("Year : %d  Month : %d  day : %d t %n", year, month, day);

		Month month2 = today.getMonth();
		System.out.println(month2);
	}

	/**
	 * 在Java 8中处理特定日期
	 *
	 * @throws Exception
	 */
	@Test
	public void test3() throws Exception {
		LocalDate dateOfBirth = LocalDate.of(2010, 01, 14);
		System.out.println("Your Date of birth is : " + dateOfBirth);
	}

	/**
	 * 在Java 8中判断两个日期是否相等
	 *
	 * @throws Exception
	 */
	@Test
	public void test4() throws Exception {
		LocalDate date = LocalDate.of(2018, 4, 1);
		LocalDate today = LocalDate.now();
		if (date.equals(today)) {
			System.out.printf("Today %s and date1 %s are same date %n", today, date);
		} else {
			System.out.printf("Today %s and date1 %s are not same date %n", today, date);
		}
	}

	/**
	 * 在Java 8中检查像生日这种周期性事件
	 *
	 * @throws Exception
	 */
	@Test
	public void test5() throws Exception {
		LocalDate dateOfBirth = LocalDate.of(2010, 4, 27);
		MonthDay birthday = MonthDay.of(dateOfBirth.getMonth(), dateOfBirth.getDayOfMonth());
		MonthDay currentMonthDay = MonthDay.from(LocalDate.now());

		if (currentMonthDay.equals(birthday)) {
			System.out.println("Many Many happy returns of the day !!");
		} else {
			System.out.println("Sorry, today is not your birthday");
		}
	}

	/**
	 * 在Java 8中获取当前时间
	 *
	 * @throws Exception
	 */
	@Test
	public void test6() throws Exception {
		LocalTime time = LocalTime.now();
		System.out.println("local time now : " + time);
	}

	/**
	 * 如何在现有的时间上增加小时
	 * 
	 *
	 * @throws Exception
	 */
	@Test
	public void test7() throws Exception {
		LocalTime time = LocalTime.now();
		LocalTime newTime = time.plusHours(2); // adding two hours
		System.out.println("Time after 2 hours : " + newTime);
	}

	/**
	 * 如何计算一周后的日期
	 *
	 * @throws Exception
	 */
	@Test
	public void test8() throws Exception {
		LocalDate today = LocalDate.now();
		LocalDate nextWeek = today.plus(1, ChronoUnit.WEEKS);
		System.out.println("Today is : " + today);
		System.out.println("Date after 1 week : " + nextWeek);
	}

	/**
	 * 计算一年前或一年后的日期
	 *
	 * @throws Exception
	 */
	@Test
	public void test9() throws Exception {
		LocalDate previousYear = today.minus(1, ChronoUnit.YEARS);
		System.out.println("Date before 1 year : " + previousYear);

		LocalDate nextYear = today.plus(1, ChronoUnit.YEARS);
		System.out.println("Date after 1 year : " + nextYear);
	}

	/**
	 * 使用Java 8的Clock时钟类
	 *
	 * @throws Exception
	 */
	@Test
	public void test10() throws Exception {
		// Returns the current time based on your system clock and set to UTC.
		Clock clock = Clock.systemUTC();
		System.out.println("Clock : " + clock);

		// Returns time based on system clock zone
		Clock defaultClock = Clock.systemDefaultZone();
		System.out.println("Clock : " + defaultClock);
	}

	/**
	 * 如何用Java判断日期是早于还是晚于另一个日期
	 *
	 * @throws Exception
	 */
	@Test
	public void test11() throws Exception {
		LocalDate tomorrow = LocalDate.of(2014, 1, 15);
		if (tomorrow.isAfter(today)) {
			System.out.println("Tomorrow comes after today");
		}

		LocalDate yesterday = today.minus(1, ChronoUnit.DAYS);

		if (yesterday.isBefore(today)) {
			System.out.println("Yesterday is day before today");
		}
	}

	/**
	 * 在Java 8中处理时区
	 *
	 * @throws Exception
	 */
	@Test
	public void test12() throws Exception {
		// Date and time with timezone in Java 8
		ZoneId america = ZoneId.of("America/New_York");
		LocalDateTime localtDateAndTime = LocalDateTime.now();
		ZonedDateTime dateAndTimeInNewYork = ZonedDateTime.of(localtDateAndTime, america);
		System.out.println("Current date and time in a particular timezone : " + dateAndTimeInNewYork);
	}

	/**
	 * 如何表示信用卡到期这类固定日期，答案就在YearMonth
	 *
	 * @throws Exception
	 */
	@Test
	public void test13() throws Exception {
		YearMonth currentYearMonth = YearMonth.now();
		System.out.printf("Days in month year %s: %d%n", currentYearMonth, currentYearMonth.lengthOfMonth());
		YearMonth creditCardExpiry = YearMonth.of(2018, Month.FEBRUARY);
		System.out.printf("Your credit card expires on %s %n", creditCardExpiry);
	}

	/**
	 * 如何在Java 8中检查闰年
	 *
	 * @throws Exception
	 */
	@Test
	public void test14() throws Exception {
		if (today.isLeapYear()) {
			System.out.println("This year is Leap year");
		} else {
			System.out.println("2014 is not a Leap year");
		}
	}

	/**
	 * 计算两个日期之间的天数和月数
	 *
	 * @throws Exception
	 */
	@Test
	public void test15() throws Exception {
		LocalDate java8Release = LocalDate.of(2019, Month.MARCH, 14);
		Period periodToNextJavaRelease = Period.between(today, java8Release);
		System.out.println("Months left between today and Java 8 release : " + periodToNextJavaRelease.getMonths());
	}

	/**
	 * 包含时差信息的日期和时间
	 *
	 * @throws Exception
	 */
	@Test
	public void test16() throws Exception {
		LocalDateTime datetime = LocalDateTime.now();
		ZoneOffset offset = ZoneOffset.of("+05:30");
		OffsetDateTime date = OffsetDateTime.of(datetime, offset);
		System.out.println("Date and Time with timezone offset in Java : " + date);
	}

	/**
	 * 在Java 8中获取当前的时间戳
	 *
	 * @throws Exception
	 */
	@Test
	public void test17() throws Exception {
		Instant timestamp = Instant.now();
		System.out.println("What is value of this instant " + timestamp);

		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println(localDateTime);
	}

	/**
	 * 在Java 8中如何使用预定义的格式化工具去解析或格式化日期
	 *
	 * @throws Exception
	 */
	@Test
	public void test18() throws Exception {
		String dayAfterTommorrow = "20140116";
		LocalDate formatted = LocalDate.parse(dayAfterTommorrow, DateTimeFormatter.BASIC_ISO_DATE);
		System.out.printf("Date generated from String %s is %s %n", dayAfterTommorrow, formatted);
	}

	/**
	 * 如何在Java中使用自定义格式化工具解析日期
	 *
	 * @throws Exception
	 */
	@Test
	public void test19() throws Exception {
		String goodFriday = "01 18 2014";
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM dd yyyy");
			LocalDate holiday = LocalDate.parse(goodFriday, formatter);
			System.out.printf("Successfully parsed String %s, date is %s%n", goodFriday, holiday);
		} catch (DateTimeParseException ex) {
			System.out.printf("%s is not parsable!%n", goodFriday);
			ex.printStackTrace();
		}
	}

	/**
	 * 在Java 8中如何把日期转换成字符串
	 *
	 * @throws Exception
	 */
	@Test
	public void test20() throws Exception {
		LocalDateTime arrivalDate = LocalDateTime.now();
		try {
			DateTimeFormatter format = DateTimeFormatter.ofPattern("MMM dd yyyy  hh:mm a");
			String landing = arrivalDate.format(format);
			System.out.printf("Arriving at :  %s %n", landing);
		} catch (DateTimeException ex) {
			System.out.printf("%s can't be formatted!%n", arrivalDate);
			ex.printStackTrace();
		}
	}
}
