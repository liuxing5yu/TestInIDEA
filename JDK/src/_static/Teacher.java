package _static;
class Person {
	public Person() {
		System.out.println("this is a Person");
	}
}

public class Teacher extends Person {
	static int x = 10;// ；4．
	static {
		x += 5;
	}// 5．

	public static void main(String args[])// 6．
	{
		System.out.println("x=" + x);
	}

	static {
		x /= 3;
	}

}
