/**
 * 
 */
package thread;

import java.util.concurrent.CountDownLatch;

import org.junit.Test;

/**
 * @author hwj
 * @date 2017年10月7日 下午8:05:52 
 *
 *
 * 解决Junit测试多线程的问题
 */
public class Test2 {
	private int i = 3;
	/*
	 *  线程计数器
	 * 	将线程数量初始化
	 * 	每执行完成一条线程，调用countDown()使计数器减1
	 * 	主线程调用方法await()使其等待，当计数器为0时才被执行
	 */
	private CountDownLatch latch = new CountDownLatch(i);

	@Test
	public void test() {

		for (int i = 0; i < this.i; i++) {
			new Thread(new Runner()).start();
		}

		try {
			latch.await(); // 主线程等待
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	class Runner implements Runnable {

		@Override
		public void run() {
			System.out.println(123);
			latch.countDown(); // 执行完毕，计数器减1
		}
	}
}
