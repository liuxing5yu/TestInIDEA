package singleton.test1;

/**
 * @date 2019/4/11 14:11
 */
//双重检查锁
public final class DoubleCheckedSingleton {
	private static DoubleCheckedSingleton singObj = null;

	private DoubleCheckedSingleton() {
	}

	public static DoubleCheckedSingleton getSingleInstance() {
		if (null == singObj) {
			synchronized (DoubleCheckedSingleton.class) {
				if (null == singObj) {
					singObj = new DoubleCheckedSingleton();
				}
			}
		}
		return singObj;
	}
}
