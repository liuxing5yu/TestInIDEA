/**
 * 
 */
package date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

/**
 * 
 *
 * @author hwj
 * @date 2018年4月13日 上午10:56:51 
 *
 */
public class DateFormatTest {

	@Test
	public void test1() throws ParseException {
		String str = "2018-04-13 09:39:38.221";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = simpleDateFormat.parse(str);
		System.out.println(date);
	}
}
