package threadlocal;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 根据JDK1.6注释
 * JDK1.6注释中的例子有问题，getCurrentThreadId中的应该是uniqueNum.get而不是uniqueId.get
 */
public class UniqueThreadIdGenerator {

	private static final AtomicInteger uniqueId = new AtomicInteger(0);

	private static final ThreadLocal<Integer> uniqueNum = new ThreadLocal<Integer>() {
		@Override
		protected Integer initialValue() {
			return uniqueId.getAndIncrement();
		}
	};

	public static int getCurrentThreadId() {
		return uniqueNum.get();
	}

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					ThreadId uniqueThreadIdGenerator = new ThreadId();
					System.out.println(Thread.currentThread().getName() + "===" + getCurrentThreadId());
				}
			}).start();
		}
	}
}
