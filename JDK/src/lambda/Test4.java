/**
 * 
 */
package lambda;

interface I1 {
	default void removeAll() {
		System.out.println("I1 removeAll...");
	}
}

interface I2 extends I1 {
	default void removeAll() {
		System.out.println("I2 removeAll...");
	}
}

interface I3 {
	default void removeAll() {
		System.out.println("I3 removeAll...");
	}
}

interface I4 extends I2, I3 {
	default void removeAll() {
		// I2.super.removeAll();
	}
}

/**
 * 
 *
 * @author hwj
 * @date 2018年7月2日 下午7:47:23 
 *
 */
public class Test4 {

}
