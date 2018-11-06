/**
 * 
 */
package random;

import java.util.Random;
import java.util.UUID;

import org.junit.Test;

/**
 * 
 *
 * @author hwj
 * @date 2018年1月14日 下午4:23:17 
 *
 */
public class Test1 {
	@Test
	public void test1() {
		UUID randomUUID = UUID.randomUUID();
		System.out.println(randomUUID);
	}

	@Test
	public void test2() {
		Random random = new Random();
		System.out.println(random.nextInt(10));
	}

}
