/**
 * 
 */
package lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 
 *
 * @author hwj
 * @date 2018年7月2日 下午7:56:53 
 *
 */
public class Test5 {
	public static void main(String[] args) {

		List<Person> list = new ArrayList<>();
		list.add(new Person("B"));
		list.add(new Person("A"));
		list.add(new Person("D"));
		list.add(new Person("C"));
		System.out.println("1: " + list);
		// Collections.sort(list, new Comparator<Person>() {
		// public int compare(Person x, Person y) {
		// return x.getLastName().compareTo(y.getLastName());
		// }
		// });
		// Collections.sort(list, (Person x, Person y) -> x.getLastName().compareTo(y.getLastName()));
		// Collections.sort(list, Comparator.comparing((Person p) -> p.getLastName()));
		// Collections.sort(list, Comparator.comparing(p -> p.getLastName()));
		// Collections.sort(list, Comparator.comparing(Person::getLastName));
		// list.sort(Comparator.comparing(Person::getLastName));

		list.sort(Comparator.comparing(Person::getLastName).reversed());
		System.out.println("2: " + list);

	}

}

class Person {
	String lastName;

	public Person(String lastName) {
		super();
		this.lastName = lastName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Person [lastName=" + lastName + "]";
	}

}
