package singleton.test1;

/**
 * @date 2019/4/11 14:01
 */
//饥饿模式
public final class EagerSingleton {
	private static EagerSingleton singObj = new EagerSingleton();

	private EagerSingleton() {
	}

	public static EagerSingleton getSingleInstance() {
		return singObj;
	}
}
