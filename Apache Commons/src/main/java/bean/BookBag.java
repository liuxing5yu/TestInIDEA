package bean;

import java.util.List;

/**
 * @author hwj
 * @date 2019/5/13 10:14
 */
public class BookBag {
	private String name;

	private List<Book> books;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
}
