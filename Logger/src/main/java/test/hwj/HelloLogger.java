package test.hwj;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author hwj
 * @date 2018/11/20 11:30
 */
public class HelloLogger {
	public static void main(String[] args) {
		Logger logger = LoggerFactory.getLogger(HelloLogger.class);
		logger.info("info...");
	}
}
