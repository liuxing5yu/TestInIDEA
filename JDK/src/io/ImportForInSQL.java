/**
 * 
 */
package io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 将一个包含数字的文本打印成SQL的in语句格式
 *
 * @author hwj
 * @date 2017年11月16日 下午2:51:52 
 *
 */
public class ImportForInSQL {
	public static void main(String[] args) {

		String header = "drugcode in (";

		BufferedReader bfr;
		try {
			bfr = new BufferedReader(new FileReader("D:\\Develop\\workspace\\eclipse\\Test\\src\\io\\1.txt"));

			int c = 0;
			StringBuilder result = new StringBuilder(header);
			String str;
			while ((str = bfr.readLine()) != null) {
				if ((c + 1) % 100 == 0) {
					result.substring(0, result.length() - 2);

					result.deleteCharAt(result.length() - 1);
					System.out.println(result + ") or");

					result = new StringBuilder(header);
				}
				if (!str.trim().equals("")) {
					c++;
					result.append("'" + str.trim() + "',");
				}
			}
			bfr.close();

			if (result.length() > header.length()) {
				result.deleteCharAt(result.length() - 1);
				System.out.println(result + ")");
			}

			System.out.println("共" + c + "条数据");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
