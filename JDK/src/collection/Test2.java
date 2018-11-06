/**
 * 
 */
package collection;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 *
 * @author hwj
 * @date 2018年3月22日 下午1:49:46 
 *
 */
public class Test2 {

	/**
	 * 
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		A a = new A();
		a.setS("a");
		List<A> list1 = new ArrayList<A>();
		List<A> list2 = new ArrayList<A>();
		
	}

}

class A {
	private String s;

	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}

}
