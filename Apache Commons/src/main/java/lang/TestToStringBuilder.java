package lang;

import bean.Book;
import bean.BookBag;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.ArrayList;

/**
 * @author hwj
 * @date 2019/5/13 10:14
 */
public class TestToStringBuilder {
	public static void main(String[] args) {
		BookBag bookBag = new BookBag();
		bookBag.setName("BookBag11");
		ArrayList<Book> books = new ArrayList<>();
		bookBag.setBooks(books);
		Book book = new Book();
		book.setBookName("BookName11");
		books.add(book);

		String s = ToStringBuilder.reflectionToString(bookBag, ToStringStyle.JSON_STYLE);
		System.out.println(s);
	}
}
