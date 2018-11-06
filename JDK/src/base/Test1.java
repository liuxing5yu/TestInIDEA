package base;

import org.junit.Assert;
import org.junit.Test;

import bean.Point;

/**
 * 
 * 问题：将参数传给Java方法时，到底传递的是值，还是引用？调用结束后，会不会改变参数的值？
 * <p>
 * 结论：Java中方法参数传递方式是按值传递。
 *		如果参数是基本类型，传递的是基本类型的字面量值的拷贝。
 *		如果参数是引用类型，传递的是该参量所引用的对象在堆中地址值的拷贝。
 * 
 * @author hwj
 * @date 2017年10月28日 下午9:10:48 
 * @see <a href="http://www.importnew.com/3559.html">Java到底是传引用还是传值?</a> 
 */
public class Test1 {

	/**
	 * 参数为基础类型的方法内交换不会改变原来的值
	 */
	@Test
	public void test1() {
		int a = 1;
		int b = 2;
		badSwap(a, b);
		Assert.assertEquals(true, a == 2);// false
	}

	private void badSwap(int var1, int var2) {
		int temp = var1;
		var1 = var2;
		var2 = temp;
	}

	/**
	 * 传向函数的引用实际上是原始引用的副本
	 */
	@Test
	public void test2() {
		Point pnt1 = new Point(0, 0);
		Point pnt2 = new Point(0, 0);
		System.out.println("X: " + pnt1.getX() + " Y: " + pnt1.getY());// X: 0 Y: 0
		System.out.println("X: " + pnt2.getX() + " Y: " + pnt2.getY());// X: 0 Y: 0
		System.out.println(" ");
		tricky(pnt1, pnt2);
		System.out.println("X: " + pnt1.getX() + " Y: " + pnt1.getY());// X: 100 Y: 100
		System.out.println("X: " + pnt2.getX() + " Y: " + pnt2.getY());// X: 0 Y: 0
	}

	public void tricky(Point point1, Point point2) {
		point1.setX(100);
		point1.setY(100);

		point1 = point2;
		// 这里打印的值为point2的值，而test2()中的pnt1的值仍然是100,100，说明point1只是pnt1的副本，而不是同一个引用
		System.out.println("point1.." + point1);// point1..Point [x=0, y=0]

		Point temp = point1;
		point1 = point2;
		point2 = temp;
	}

	@Test
	public void test3() {
		String str1 = "a", str2 = "b";
		changeStr(str1, str2);
		System.out.println(str1);
	}

	/**
	 * @param str1
	 * @param str2 
	 */
	private void changeStr(String str1, String str2) {
		str1 = str2;
	}
}
