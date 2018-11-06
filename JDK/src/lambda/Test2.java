/**
 * 
 */
package lambda;

/**
 * 
 *
 * @author hwj
 * @date 2018年7月2日 上午7:28:16 
 *
 */
public class Test2 {
	/*
	一个接口，如果只有一个显式声明的抽象方法，
	那么它就是一个函数接口。
	一般用@FunctionalInterface标注出来（也可以不标）
	*/
	interface Inteface1 {
		// 可以不用abstract修饰
		public abstract void test(int x, int y);

		// public void test1();//会报错,不能有两个方法,尽管没有使用abstract修饰
		public boolean equals(Object o);// equals属于Object的方法,所以不会报错
	}

	public static void main(String args[]) {
		Inteface1 f1 = (x, y) -> {
			System.out.println(x + y);
		};
		f1.test(3, 4);
		Inteface1 f2 = (int x, int y) -> {
			System.out.println("Hello Lambda!\t the result is " + (x + y));
		};
		f2.test(3, 4);
	}
}
