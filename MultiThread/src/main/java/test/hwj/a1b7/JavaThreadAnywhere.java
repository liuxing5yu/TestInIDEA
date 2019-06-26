package test.hwj.a1b7;

/**
 * @author hwj
 * @date 2019/4/21 19:20
 */
public class JavaThreadAnywhere {
	public static void main(String[] args) {
		Thread currentThread = Thread.currentThread();

		String name = currentThread.getName();

		System.out.printf("The main method was executed by Thread:%s%n", currentThread);

		Helper helper = new Helper("Java Thread AnyWhere");
		helper.run();
	}
}
