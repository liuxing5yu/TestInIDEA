package thread;

/**
 * 简单使用wait，notify
 *
 * @author hwj
 * @date 2019/6/18 16:10
 */
public class Test5 {
	public static void main(String[] args) throws InterruptedException {
		Object object = new Object();

		new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (object) {
					System.out.println(Thread.currentThread().getName() + "==>" + "Wait Before");
					try {
						object.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + "==>" + "Wait After");
				}
			}
		}, "TTT").start();

		Thread.sleep(2000);

		System.out.println(Thread.currentThread().getName() + "==>" + "notifyAll Before");
		synchronized (object) {
			object.notifyAll();
		}
		System.out.println(Thread.currentThread().getName() + "==>" + "notifyAll After");
	}
}
