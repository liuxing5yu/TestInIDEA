package singleton.test1;

/**
 * @author hwj
 * @date 2019/4/11 15:08
 */
public class Test1 {
	/*
	// 饿汉式
	private static Test1 test1 = new Test1();

	private Test1() {

	}

	public static Test1 getInstance() {
		return test1;
	}
	*/

	/*
	// 懒汉式
	private static Test1 test1 = null;

	private Test1() {

	}

	public static Test1 getInstance() {
		if (test1 == null) {
			test1 = new Test1();
		}
		return test1;
	}
	*/

	// 线程安全
	/*
	private static Test1 test1 = null;

	private Test1() {

	}

	public static synchronized Test1 getInstance() {
		if (test1 == null) {
			test1 = new Test1();
		}
		return test1;
	}
	*/

}
