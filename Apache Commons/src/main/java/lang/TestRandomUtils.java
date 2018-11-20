package lang;

import org.apache.commons.lang3.RandomUtils;

/**
 * @author hwj
 * @date 2018/11/8 14:56
 */
public class TestRandomUtils {
	public static void main(String[] args) {
		System.out.println(RandomUtils.nextInt());
		for (int i = 0; i <20; i++) {

			System.out.println(RandomUtils.nextInt(10, 20));
		}
	}
}
