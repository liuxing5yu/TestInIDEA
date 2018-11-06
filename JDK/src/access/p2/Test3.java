package access.p2;

import access.p1.Test1;

public class Test3 extends Test1 {
	public static void main(String[] args) {
		Test3 test3 = new Test3();
		String s1 = test3.s1;// public
		String s3 = test3.s3;// protected
	}
}
