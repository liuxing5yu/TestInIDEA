/**
 * 
 */
package thread;

/**
 * @author hwj
 * @date 2017年10月7日 下午8:42:15 
 *
 * Java多线程的启动问题
 */
public class Test3 {

	public static void main(String[] args) {
		Test3 test3 = new Test3();

		for (int i = 0; i < 10; i++) {
			new Thread(test3.new TestRunner(i)).start();
		}
	}

	private class TestRunner implements Runnable {

		int i;

		public TestRunner(int i) {
			this.i = i;
		}

		public void run() {
			System.out.println(Thread.currentThread().getName() + " : " + i);
		}
	}

}
