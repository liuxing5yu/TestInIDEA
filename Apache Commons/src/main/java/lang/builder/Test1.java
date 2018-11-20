/**
 *
 */
package lang.builder;

import org.apache.commons.lang3.builder.*;

/**
 * @author hwj
 * @date 2018年5月16日 下午4:33:49
 */
public class Test1 {


	class A implements Comparable<A>, Diffable<A> {


		private String a;
		private String b;

		public A() {
		}

		public A(String a, String b) {
			this.a = a;
			this.b = b;
		}

		public String getA() {
			return a;
		}

		public void setA(String a) {
			this.a = a;
		}

		@Override
		public int compareTo(A o) {
			return new CompareToBuilder().append(a, o.getA()).append(b, o.b).toComparison();
		}

		@Override
		public DiffResult diff(A o) {
			return new DiffBuilder(this, o, ToStringBuilder.getDefaultStyle()).append("a", a, o.a).append("b", b, o.b)
					       .build();
		}
	}


	public static void main(String[] args) {
		A a1 = new Test1().new A("a1", "b1");
		A a2 = new Test1().new A("a1", "b2");

		System.out.println(CompareToBuilder.reflectionCompare(a1, a2));
		System.out.println(a1.diff(a2));

	}
}
