package xstream;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @author hwj
 * @date 2019/4/8 9:07
 */
public @XStreamAlias("student")
class Student {

	private String firstName;
	private String lastName;

	public Student(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String toString() {
		return "Student [ firstName: " + firstName + ", lastName: " + lastName + " ]";
	}
}
