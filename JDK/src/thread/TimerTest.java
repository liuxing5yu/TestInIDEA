/**
 * 
 */
package thread;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import org.junit.Test;

/**
 * 
 *
 * @author hwj
 * @date 2018年8月1日 下午7:36:28 
 *
 */
public class TimerTest {
	public static void main(String[] args) {
		System.out.println(new Date().toLocaleString() + "：开始执行");
		Timer timer = new Timer();
		Task task = new Task();
		timer.schedule(task, new Date(), 5000);

	}

	@Test
	public void test1() {
		Timer timer = new Timer();
		Task task = new Task();
		timer.schedule(task, new Date(), 5000);
	}
}

class Task extends TimerTask {

	@Override
	public void run() {
		System.out.println(new Date().toLocaleString() + "：Do work...");
	}
}
