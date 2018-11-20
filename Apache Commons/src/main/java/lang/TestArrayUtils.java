package lang;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

/**
 * @author hwj
 * @date 2018/11/8 14:30
 */
public class TestArrayUtils {
	public static void main(String[] args) {
		String[] strArr = new String[]{"a","b","c"};
		System.out.println(ArrayUtils.toString(strArr));
		System.out.println(Arrays.toString(strArr));

		System.out.println(ArrayUtils.toMap(strArr));
	}
}
