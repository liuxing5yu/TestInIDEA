package test.hwj.a1b7;

/**
 * @author hwj
 * @date 2019/4/21 19:22
 */
public class Helper implements Runnable {
	private final String message;

	public Helper(String message) {
		this.message = message;
	}

	private void doSomething(String message) {
		Thread currentThread = Thread.currentThread();

		String name = currentThread.getName();

		System.out.printf("The main method was executed by Thread:%s%n", currentThread);
		System.out.println("Do something with " + message);
	}

	@Override
	public void run() {
		doSomething(message);
	}
}
