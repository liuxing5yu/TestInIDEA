package _static;

class A {

	static {
		System.out.print("1");
	}

	public A() {
		System.out.print("2");
	}
}

class B extends A {

	static {
		System.out.print("a");
	}

	public B() {
		System.out.print("b");
	}
}

/**
 * 测试类成员的初始化顺序
 * @author 80953
 *
 */
public class Test1 {

	static {
		System.out.println("Test1 static...");
	}

	public static void main(String[] args) {
		A ab = new B();
		ab = new B();
	}

}
