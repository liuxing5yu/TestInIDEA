package inetAddress;

import java.net.InetAddress;

import org.junit.Test;

public class Test1 {

	//
	@Test
	public void test1() {
		try {
			InetAddress inetAddress = InetAddress.getByName("www.baidu.com");
			// inetAddress = InetAddress.getByName("111.13.100.91");
			System.out.println(inetAddress);
			System.out.println(inetAddress.getHostName());
			System.out.println(inetAddress.getHostAddress());

			InetAddress localHost = InetAddress.getLocalHost();
			System.out.println(localHost);
			System.out.println(localHost.getHostName());
			System.out.println(localHost.getHostAddress());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
