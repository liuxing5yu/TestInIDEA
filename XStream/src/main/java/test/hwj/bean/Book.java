package test.hwj.bean;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAliasType;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * @author hwj
 * @date 2019/4/8 8:45
 */
// @XStreamAlias("Book")
@XStreamAliasType("bookType")    // 在@XStreamAlias注解不存在的情况下起作用
public class Book {

	@XStreamAsAttribute     // <bookType BookName="西游记"/>
	@XStreamAlias("BookName")
	private String name;

	public Book() {
	}

	public Book(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
