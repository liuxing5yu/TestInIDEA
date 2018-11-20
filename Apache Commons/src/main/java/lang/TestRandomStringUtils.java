package lang;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

/**
 * @author hwj
 * @date 2018/11/8 14:49
 */
public class TestRandomStringUtils {
	public static void main(String[] args) {
		String s1 = RandomStringUtils.randomAlphabetic(20);
		System.out.println(s1);

		String s2 = RandomStringUtils.randomAscii(20);
		System.out.println(s2);

		String s3 = RandomStringUtils.randomAlphanumeric(20);
		System.out.println(s3);

		String s4 = RandomStringUtils.randomGraph(20);
		System.out.println(s4);

		String s5 = RandomStringUtils.randomNumeric(20);
		System.out.println(s5);

		String s6 = RandomStringUtils.randomPrint(20);
		System.out.println(s6);
	}

}
