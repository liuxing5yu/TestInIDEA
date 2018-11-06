package sort;

import java.util.Comparator;

/**
 * 	用来区别 java.lang.Comparable<T> 和 java.util.Comparator<T>
 * 
 *  Comparable & Comparator 都是用来实现集合中元素的比较、排序的，
 *  只是 Comparable 是在集合内部定义的方法实现的排序，Comparator 是在集合外部实现的排序，
 *  所以，如想实现排序，就需要在集合外定义 Comparator 接口的方法或在集合内实现 Comparable 接口的方法。
 * @author 80953
 *
 */
public class Compare {

}

class ACompare implements Comparable<Object> {

	public int compareTo(Object o) {
		return 0;
	}

}

class BCompare implements Comparator<Object> {

	public int compare(Object o1, Object o2) {

		return 0;
	}
}