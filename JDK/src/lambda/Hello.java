/**
 * 
 */
package lambda;

public class Hello {
	Runnable r1 = () -> {
		System.out.println(this);
	};

	Runnable r2 = new Runnable() {
		public void run() {
			System.out.println(this);
		}
	};

	public String toString() {
		return "Hello, world";
	}

	public static void main(String... args) {
		new Hello().r1.run();	// Hello, world
		new Hello().r2.run();	// lambda.Hello$1@1fb3ebeb
	}
}
