package string;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * 
 * @author hwj
 * @date 2017年10月5日 下午8:35:16 
 * @see http://www.cnblogs.com/senzjx/archive/2009/09/21/1570950.html
 * 
 */
public class Test2 {
	@Test
	public void testString() {
		String str1 = "abc";
		String str2 = "abc";
		String str3 = new String("abc");
		String str4 = str1;
		System.out.println("is str1 = str2?" + (str1 == str2));
		System.out.println("is str1 = str3?" + (str1 == str3));
		System.out.println("is str1 refer to str3?" + (str1.intern() == str3.intern()));
		System.out.println("is str1 = str4" + (str1 == str4));
		System.out.println("is str2 = str4" + (str2 == str4));
		System.out.println("is str4 refer to str3?" + (str4.intern() == str3.intern()));

	}

	@Test
	public void testSubString() {
		List<String> handler = new ArrayList<String>();
		for (int i = 0; i < 1000; i++) {
			// HugeStr h = new HugeStr();
			ImprovedHugeStr h1 = new ImprovedHugeStr();
			// handler.add(h.getSubString(1, 5));
			handler.add(h1.getSubString(1, 5));
		}
	}

	static class HugeStr {
		private String str = new String(new char[800000]);

		public String getSubString(int begin, int end) {
			return str.substring(begin, end);
		}
	}

	static class ImprovedHugeStr {
		private String str = new String(new char[10000000]);

		public String getSubString(int begin, int end) {
			return new String(str.substring(begin, end));
		}
	}

}
