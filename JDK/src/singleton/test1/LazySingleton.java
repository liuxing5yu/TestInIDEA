package singleton.test1;

/**
 * @date 2019/4/11 14:03
 */
//懒汉模式
public final class LazySingleton {
	private static LazySingleton singObj = null;

	private LazySingleton() {
	}

	public static LazySingleton getSingleInstance() {
		if (null == singObj) {
			singObj = new LazySingleton();
		}
		return singObj;
	}
}
