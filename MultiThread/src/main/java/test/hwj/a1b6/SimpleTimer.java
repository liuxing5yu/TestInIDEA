package test.hwj.a1b6;

/**
 * @author hwj
 * @date 2019/4/21 17:48
 */
public class SimpleTimer {
	private static int count;

	public static void main(String[] args) {
		count = args.length >= 1 ? Integer.valueOf(args[0]) : 1000;
		int remaining;
		while (true) {
			remaining = countDown();
			if (0 == remaining) {
				break;
			} else {
				System.out.println("Remaining " + count + " second(s)");
			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private static int countDown() {
		return count--;
	}
}
