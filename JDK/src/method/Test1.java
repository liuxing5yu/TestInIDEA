package method;

import java.util.Arrays;

import org.junit.Test;

public class Test1 {

	/**
	 *  Java语言的方法调用只支持值传递
	 * 	基本类型：不改变值
	 * 	引用类型：改变对象，不改变引用
	 */

	@Test
	public void test1() {
		int a = 10;
		addOne(a);
		System.out.println(a);
		int[] arr = new int[] { 1, 2, 3 };
		System.out.println(Arrays.toString(arr));
		addTwo(arr);
		System.out.println(Arrays.toString(arr));
		addThree(arr);
		System.out.println(Arrays.toString(arr));
		addFour(arr);
		System.out.println(Arrays.toString(arr));
	}

	/**
	 * 在方法内可以改变对象的值
	 * @param arr
	 */
	private void addFour(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = arr[i] + 1;
		}
	}

	/**
	 * 使用foreach遍历数组的方式不能改变数组内的值
	 */
	private void addThree(int[] arr) {
		for (int i : arr) {
			System.out.println(i);
			i = i + 1;
			System.out.println(i);
		}
		System.out.println(Arrays.toString(arr));
	}

	/**
	 * 在方法内改变引用指向的对象是没用的
	 * @param arr
	 */
	private void addTwo(int[] arr) {
		arr = new int[] { 1, 2, 3, 4 };
	}

	/**
	 * 在方法内改变基本数据类型的值是没用的
	 * @param a
	 */
	private void addOne(int a) {
		a = a + 1;
	}
}
