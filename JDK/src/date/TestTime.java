/**
 * 
 */
package date;

import java.sql.Time;
import java.util.Date;

import org.junit.Test;

/**
 * 
 *
 * @author hwj
 * @date 2018年8月6日 下午3:39:20 
 *
 */
public class TestTime {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Date date = new Date();
		int hours = date.getHours();
		System.out.println(hours);
	}

	@Test
	public void test1() {
		System.out.println(System.nanoTime());
	}
}
