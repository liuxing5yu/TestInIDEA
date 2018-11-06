package _finally;

public class Test1 {

	public static void main(String[] args) {
		int re = bar();
		System.out.println(re);
	}

	private static int bar() {
		try {
			return 5;
		} finally {
			System.out.println("finally");
		}
	}
	/*输出：
	finally
	5
	*/

}
