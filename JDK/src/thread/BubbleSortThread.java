package thread;

/**
 * @see https://segmentfault.com/a/1190000004417288#articleHeader10
 *
 * @since  JDK1.1
 */
public class BubbleSortThread extends Thread {
	private int[] numbers;

	public BubbleSortThread(int[] numbers) {
		setName("Simple Thread");
		setUncaughtExceptionHandler(new SimpleThreadExceptionHandler());
		this.numbers = numbers;
	}

	public void run() {
		int index = numbers.length;
		boolean finished = false;
		while (!finished) {
			index--;
			finished = true;
			for (int i = 0; i < index; i++) {
				// Create error condition
				if (numbers[i + 1] < 0) {
					throw new IllegalArgumentException("Cannot pass negative numbers into this thread!");
				}
				if (numbers[i] > numbers[i + 1]) {
					// swap
					int temp = numbers[i];
					numbers[i] = numbers[i + 1];
					numbers[i + 1] = temp;
					finished = false;
				}
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName());
		new BubbleSortThread(new int[] { -1, -2, 3, 4, 5 }).start();
	}
}

class SimpleThreadExceptionHandler implements Thread.UncaughtExceptionHandler {
	public void uncaughtException(Thread t, Throwable e) {
		System.err.printf("%s: %s at line %d of %s%n", t.getName(), e.toString(), e.getStackTrace()[0].getLineNumber(),
				e.getStackTrace()[0].getFileName());
	}
}
