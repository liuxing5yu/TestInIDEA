/**
 * 
 */
package autocloseable;

public class TryWithResource implements AutoCloseable {

	@Override
	public void close() throws Exception {
		StackTraceElement stack[] = Thread.currentThread().getStackTrace();
		for (StackTraceElement ste : stack) {
			System.out
					.println("called by " + ste.getClassName() + "." + ste.getMethodName() + " / " + ste.getFileName());
		}
	}

	public static void main(String[] args) {
		try (TryWithResource twr = new TryWithResource()) {
			System.out.println("use end...");
			throw new Exception("xxx");
		} catch (Exception e) {
			System.out.println("close error...");
		}
	}
}
