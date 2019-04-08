package _calendar;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Java Calendar类的使用注意事项
 * https://www.jianshu.com/p/37fc4394101c
 *
 * @author hwj
 * @date 2019/4/8 10:27
 */
public class Test1 {

	/**
	 * 设置Calendar的容错性
	 */
	@Test
	public void test1() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");

		Calendar calendar = Calendar.getInstance();

		calendar.set(Calendar.MONTH, 13); // ①

		// 调试查看
		System.out.println(simpleDateFormat.format(calendar.getTime()));
		// 关闭容错性
		calendar.setLenient(false);

		// calendar.set(Calendar.MONTH, 13); // ②

		System.out.println(simpleDateFormat.format(calendar.getTime()));
	}

	/**
	 * set()方法延迟修改
	 */
	@Test
	public void test2() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		Calendar calendar = Calendar.getInstance();

		calendar.set(2003, 7, 31);

		calendar.set(Calendar.MONTH, 8);

		System.out.println(simpleDateFormat.format(calendar.getTime())); // ①

		calendar.set(Calendar.DATE, 5);

		System.out.println(simpleDateFormat.format(calendar.getTime()));
	}
}
