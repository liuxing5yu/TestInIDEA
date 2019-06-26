package string;

/**
 * @author hwj
 * @date 2019/6/24 14:04
 */
public class Test5 {
	public static void main(String[] args) {
		Object obj = null;
		String s1 = (String) obj;
		String s2 = String.valueOf(obj);
		System.out.println(s1);
		System.out.println(s2);
	}
}
