/**
 * 
 */
package thread;

/**
 * @author hwj
 * @date 2017年10月7日 下午7:57:27 
 *
 * @see Java 里如何实现线程间通信？ http://wingjay.com/2017/04/09/Java%E9%87%8C%E5%A6%82%E4%BD%95%E5%AE%9E%E7%8E%B0%E7%BA%BF%E7%A8%8B%E9%97%B4%E9%80%9A%E4%BF%A1%EF%BC%9F/
 * 
 * 有问题！！！
 */
public class Test1 {

	public static void main(String[] args) {
		// demo1(); // 两个线程同时执行
		// demo2();// 两个县城依次执行
		demo3();// A 1, B 1, B 2, B 3, A 2, A 3
	}

	private static void demo1() {
		Thread A = new Thread(new Runnable() {
			@Override
			public void run() {
				printNumber("A");
			}
		});

		Thread B = new Thread(new Runnable() {
			@Override
			public void run() {
				printNumber("B");
			}
		});

		A.start();
		B.start();
	}

	private static void demo2() {
		Thread A = new Thread(new Runnable() {
			@Override
			public void run() {
				printNumber("A");
			}
		});

		Thread B = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("B 开始等待 A");
				try {
					A.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				printNumber("B");
			}
		});

		B.start();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		A.start();
	}

	/**
	 * A 1, B 1, B 2, B 3, A 2, A 3
	 */
	private static void demo3() {
		Object lock = new Object();
		Thread A = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (lock) {
					System.out.println("A 1");
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("A 2");
					System.out.println("A 3");
				}
			}
		});
		Thread B = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (lock) {
					System.out.println("B 1");
					System.out.println("B 2");
					System.out.println("B 3");
					lock.notify();
				}
			}
		});

		B.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		A.start();
	}

	private static void printNumber(String threadName) {
		int i = 0;
		while (i++ < 3) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(threadName + " print: " + i);
		}
	}
}
