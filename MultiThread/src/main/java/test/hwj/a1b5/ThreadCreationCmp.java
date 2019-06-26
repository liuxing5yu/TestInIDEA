package test.hwj.a1b5;

/**
 * 清单1.5    P27
 * 线程的两种创建方式的区别
 *
 * @author hwj
 * @date 2019/4/21 15:03
 */
public class ThreadCreationCmp {
	public static void main(String[] args) {
		Thread t;
		CountingTask ct = new CountingTask();

		final int numberOfProceesors = Runtime.getRuntime().availableProcessors();

		System.out.println("共有处理器个数：" + numberOfProceesors);

		for (int i = 0; i < 2 * numberOfProceesors; i++) {

			// 直接创建线程
			t = new Thread(ct);
			t.start();
		}

		/*for (int i = 0; i < 2 * numberOfProceesors; i++) {
			// 以子类的方式创建线程

			t = new CountingThread();
			t.start();

		}*/
	}
}
