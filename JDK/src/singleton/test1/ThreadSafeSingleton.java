package singleton.test1;

/**
 * @date 2019/4/11 14:04
 */
//懒汉模式加Synchronized
public final class ThreadSafeSingleton {
	private static ThreadSafeSingleton singObj = null;

	private ThreadSafeSingleton() {
	}

	public static synchronized ThreadSafeSingleton getSingleInstance() {
		if (null == singObj) {
			singObj = new ThreadSafeSingleton();
		}
		return singObj;
	}
}
