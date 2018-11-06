package arrays;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class Test1 {

	public static void main(String[] args) {
		String[] strArr = new String[] { "A", "B", "C", "D", "E" };
		String[] copyOf = Arrays.copyOf(strArr, strArr.length);

		System.out.println(strArr == copyOf);
		System.out.println(Arrays.equals(strArr, copyOf));

		String[] strArr2 = new String[10];
		System.arraycopy(strArr, 0, strArr2, 0, 5);

		System.out.println("strArr2: " + Arrays.toString(strArr2));
		System.out.println(strArr == strArr2);
		System.out.println(Arrays.equals(strArr, strArr2));
	}

	/**
	 * System.arraycopy
	 */
	@Test
	public void test1() {
		int[] src = new int[] { 1, 2, 3, 4, 5 };
		int[] dest = new int[5];
		try {
			System.arraycopy(src, 0, dest, 2, 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(Arrays.toString(src));
		System.out.println(Arrays.toString(dest));
	}

	/**
	 * Arrays.copyOf
	 */
	@Test
	public void test2() {
		int[] src = new int[] { 1, 2, 3, 4, 5 };
		int[] dest = new int[5];
		try {
			dest = Arrays.copyOf(src, 10);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(Arrays.toString(src));
		System.out.println(Arrays.toString(dest));
	}

	@Test
	public void test3() {
		String[] strArr = new String[] { "a", "b" };
		List<String> list = Arrays.asList(strArr);

		System.out.println(list);

		strArr[0] = "c";
		System.out.println(list);
	}
}
