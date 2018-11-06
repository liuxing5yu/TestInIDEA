package socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

import org.junit.Test;

public class Test1 {
	@Test
	public void server() {
		ServerSocket ss = null;
		Socket s = null;
		InputStream is = null;
		OutputStream os = null;
		try {
			ss = new ServerSocket(9090);
			s = ss.accept();
			is = s.getInputStream();

			byte[] b = new byte[20];
			int len;
			while ((len = is.read(b)) != -1) {
				String str = new String(b, 0, len);
				System.out.println(str);
				// System.out.println(new String(b, 0, len));
			}
			System.out.println();

			os = s.getOutputStream();
			os.write("我已收到你的情谊".getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				os.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				s.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				ss.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Test
	public void client() {
		Socket s = null;
		OutputStream os = null;
		try {
			s = new Socket("127.0.0.1", 9090);
			os = s.getOutputStream();
			os.write("你好，我是client()！！！".getBytes());
			s.shutdownOutput();

			InputStream is = s.getInputStream();
			byte[] b = new byte[20];
			int len;
			while ((len = is.read(b)) != -1) {
				String str = new String(b, 0, len);
				System.out.println(str);
				// System.out.print(new String(b, 0, len));
			}
			System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (s != null) {
				try {
					s.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
