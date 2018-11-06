/**
 * 
 */
package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.junit.Test;

/**
 * 
 *
 * @author hwj
 * @date 2018年3月6日 上午8:27:08 
 *
 */
public class Test1 {
	@Test
	public void test1() {
		Runnable r = () -> System.out.println("do something.");
		new Thread(r).start();
	}

	/**
	 * 消费型接口示例
	 *
	 */
	@Test
	public void test3() {
		donation(1000, money -> System.out.println("好心的麦乐迪为Blade捐赠了" + money + "元"));
	}

	public static void donation(Integer money, Consumer<Integer> consumer) {
		consumer.accept(money);
	}

	/**
	 * 供给型接口示例
	 *
	 */
	@Test
	public void test4() {
		List<Integer> list = supply(10, () -> (int) (Math.random() * 100));
		list.forEach(System.out::println);
	}

	public static List<Integer> supply(Integer num, Supplier<Integer> supplier) {
		List<Integer> resultList = new ArrayList<Integer>();
		for (int x = 0; x < num; x++)
			resultList.add(supplier.get());
		return resultList;
	}

	/**
	 * 函数型接口示例
	 *
	 */
	@Test
	public void test5() {
		Integer value = convert("00222", x -> Integer.parseInt(x));
		System.out.println(value);
	}

	public static Integer convert(String str, Function<String, Integer> function) {
		return function.apply(str);
	}

	/**
	 * 断言型接口示例
	 *
	 */
	@Test
	public void test6() {
		List<String> fruit = Arrays.asList("香蕉", "哈密瓜", "榴莲", "火龙果", "水蜜桃");
		List<String> newFruit = filter(fruit, (f) -> f.length() == 2);
		System.out.println(newFruit);
	}

	public static List<String> filter(List<String> fruit, Predicate<String> predicate) {
		List<String> f = new ArrayList<>();
		for (String s : fruit) {
			if (predicate.test(s)) {
				f.add(s);
			}
		}
		return f;
	}

}
