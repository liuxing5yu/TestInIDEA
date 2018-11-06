package string;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

import org.junit.Test;

public class Test1 {

	public static void main(String[] args) {
		String s1 = "java";
		String s2 = "android";
		String s3 = "java" + "android";
		String s4 = s1 + s2;
		System.out.println(s3 == s4);// false
		String s5 = s4.intern();
		System.out.println(s3 == s4);// false
		System.out.println(s3 == s5);// true
		System.out.println(s4 == s5);// false
		System.out.println(s3.hashCode());
		System.out.println(s4.hashCode());
		System.out.println(s5.hashCode());

		System.out.println(s1.concat(s2));
	}

	/**
	 * @throws UnsupportedEncodingException 
	 * 
	 */
	@Test
	public void test1() throws UnsupportedEncodingException {
		String s1 = "打印完毕！！！";
		String s2 = "hello world!";

		byte[] b1 = s1.getBytes();
		byte[] b2 = s2.getBytes();

		System.out.println(new String(b1, 0, b1.length));
		// System.out.println(b2.length);
		// System.out.println(Arrays.toString(b1));
		// System.out.println(Arrays.toString(b2));
	}

	@Test
	public void testEquals() {
		String nullStr = null;
		if ("str".equals(nullStr)) {
		}
		System.out.println(2);
		if (nullStr.equals("str")) {
		}
		System.out.println(1);

	}
}
