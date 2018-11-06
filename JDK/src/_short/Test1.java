package _short;

import org.junit.Test;

public class Test1 {

	@Test
	public void test1() {
		// short s1 = 1;
		// s1 = s1 + 1;// +1后是int型，不能赋值给short
		// System.out.println(s1);

		short s2 = 1;
		s2 += 1;
		System.out.println(s2);// 这里有隐藏的强制类型转换
	}
}
