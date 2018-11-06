/**
 * 
 */
package lambda;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * 
 *
 * @author hwj
 * @date 2018年7月2日 上午7:43:06 
 *
 */
public class Test3 {
	Consumer<Integer> b1 = System::exit; // void exit(int status)
	Consumer<String[]> b2 = Arrays::sort; // void sort(Object[] a)
	// Consumer<String> b3 = MyProgram::main; // void main(String... args)
	// Runnable r = Myprogram::mapToInt // void main(String... args)

	public static Supplier<Integer> testClosure() {
		int i = 1;
		// i++; // 会报错
		return () -> {
			return i;
		};
	}
}