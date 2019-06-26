package test.hwj.utils;

import java.util.Random;

/**
 * @author hwj
 * @date 2019/4/21 15:12
 */
public class Tools {
	public static void randomPause(int i) {
		try {
			// Thread.sleep(new Random(i).nextInt());
			Thread.sleep(i);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
