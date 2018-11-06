package slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloWorld {
	public static void main(String[] args) {
		Logger logger = LoggerFactory.getLogger(HelloWorld.class);
		logger.error("Hello World");
		System.out.println(logger.getClass());
	}
}
