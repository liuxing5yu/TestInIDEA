package singleton.test1;

/**
 * @author hwj
 * @date 2019/4/11 15:03
 */
// 使用内部类来做到延迟加载对象
public class InnerClassSingleton {
	private static class SingletonHolder {
		public final static InnerClassSingleton instance = new InnerClassSingleton();
	}

	public static InnerClassSingleton getInstance() {
		return SingletonHolder.instance;
	}
}
