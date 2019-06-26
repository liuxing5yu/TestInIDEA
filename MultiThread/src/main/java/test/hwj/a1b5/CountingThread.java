package test.hwj.a1b5;

import test.hwj.utils.Tools;

/**
 * @author hwj
 * @date 2019/4/21 15:10
 */
public class CountingThread extends Thread {
	private Counter counter = new Counter();

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			doSomething();
			counter.increment();
		}
		System.out.println("CountingThread:" + counter.value());

	}

	private void doSomething() {
		Tools.randomPause(80);
	}
}
