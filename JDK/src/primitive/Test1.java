package primitive;

/**
 * 测试基本类型和包装类
 * @author 80953
 * @see https://segmentfault.com/a/1190000004417288#articleHeader0
 * 
 */
public class Test1 {
	/**
	 * 方法匹配时向下兼容
	 * @param args
	 */
	public static void main(String[] args) {
		m1(10);// this is double
		m1((Integer) 10);// this is integer
	}

	public static void m1(Integer i) {
		System.out.println("this is integer");
	}

	public static void m1(double d) {
		System.out.println("this is double");
	}
}
