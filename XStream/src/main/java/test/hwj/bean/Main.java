package test.hwj.bean;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.basic.DateConverter;
import org.junit.Test;

import java.util.*;

/**
 * @author hwj
 * @date 2019/4/8 9:00
 */
public class Main {

	@Test
	public void test1() {
		BookBag bookBag = new BookBag();
		bookBag.setPrice(100);
		bookBag.setName("张三");
		bookBag.setDate(new Date());

		Book book1 = new Book("西游记");
		Book book2 = new Book("红楼梦");

		ArrayList<Book> books = new ArrayList<>();
		books.add(book1);
		books.add(book2);

		bookBag.setBooks(books);

		XStream xStream = new XStream();

		// 开启注释
		xStream.autodetectAnnotations(true);
		// 注册转换器
		xStream.registerConverter(new DateConverter("yyyy-MM-dd HH:mm:ss", null));

		String s = xStream.toXML(bookBag);
		System.out.println(s);
	}
}
