/**
 * 
 */
package sort;

import java.util.Objects;
import java.util.TreeSet;

import org.junit.Test;

/**
 * TreeMap 和 String 的连用
 *
 * @author hwj
 * @date 2017年11月14日 下午6:02:11 
 *
 */
public class TreeMapAndString {

	/**
	 * TreeSet可以将实现了Comparable接口的String排序
	 *
	 */
	@Test
	public void test1() {
		TreeSet<String> set = new TreeSet<>();
		set.add("c");
		set.add("b");
		set.add("a");
		set.add("d");

		System.out.println(set);
	}

	/**
	 * TreeSet可以将任何实现了Comparable接口的类排序
	 *
	 */
	@Test
	public void test2() {
		TreeSet<Person> set = new TreeSet<>();
		set.add(new Person(1));
		set.add(new Person(5));
		set.add(new Person(3));
		set.add(new Person(2));

		System.out.println(set);
	}

	private class Person implements Comparable<Person> {
		private int age;

		public Person(int age) {
			this.age = age;
		}

		public int compareTo(Person p) {
			return age - p.age;
		}

		@Override
		public String toString() {
			return age + "";
		}
	}
}
