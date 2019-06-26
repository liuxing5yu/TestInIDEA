package test.hwj.a1b5;

import test.hwj.utils.Tools;

/**
 * @author hwj
 * @date 2019/4/21 15:08
 */
public class CountingTask implements Runnable {
	private Counter counter = new Counter();

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			doSomething();
			counter.increment();
		}
		System.out.println("CountingTask:" + counter.value());
	}

	private void doSomething() {
		// 使当前线程休眠随机时间
		Tools.randomPause(80);
	}
}
