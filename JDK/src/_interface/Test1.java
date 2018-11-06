package _interface;

/**
 * 如果一个类继承的两个接口中有一样的field，会怎样？
 * 编译不能通过，有歧义
 * @author 80953
 *
 */
public class Test1 implements I1, I2 {
	public static void main(String[] args) {
		// System.out.println(NAME);
		System.out.println(111);
	}
}

interface I1 {
	String NAME = "codemonkeyism";
}

interface I2 {
	String NAME = "stephan";
}
