package _finally;

public class Test2 {
	public static void main(String[] args) {
		int result;

		result = foo();
		System.out.println(result); ///////// 2

		result = bar();
		System.out.println(result); ///////// 2
	}

	@SuppressWarnings("finally")
	public static int foo() {
		try {
			int a = 5 / 0;
		} catch (Exception e) {
			return 1;
		} finally {
			return 2;
		}

	}

	@SuppressWarnings("finally")
	public static int bar() {
		try {
			return 1;
		} finally {
			return 2;
		}
	}
}
