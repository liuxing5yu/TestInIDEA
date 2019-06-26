package system;

import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * System.getevn和System.getProperty的区别
 *
 *
 * getenv是获取环境变量，这是操作系统级的变量，
 * getProperty是获取Java属性，这是JVM级的变量，可以通过-D或程序设置。
 *
 * @author hwj
 * @date 2019/6/25 13:49
 */
public class TestSystem01 {
	public static void main(String[] args) {
		Properties properties = System.getProperties();
		Set<Object> set = properties.keySet();
		System.out.println("System.getProperties：");
		for (Object key : set) {
			System.out.println(key + " ==> " + properties.get(key));
		}

		System.out.println("********************************");
		System.out.println("********************************");
		System.out.println("********************************");

		System.out.println("System.getenv：");
		Map<String, String> env = System.getenv();
		Set<String> envSet = env.keySet();
		for (String key : envSet) {
			System.out.println(key + " ==> " + env.get(key));
		}
	}
}
