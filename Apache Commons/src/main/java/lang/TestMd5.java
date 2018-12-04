package lang;

import org.apache.commons.codec.digest.DigestUtils;

import java.security.MessageDigest;

/**
 * MD5通用类
 *
 * @author 浩令天下
 * @version 1.0.0_1
 * @since 2017.04.15
 */
public class TestMd5 {
	/**
	 * MD5方法
	 *
	 * @param text 明文
	 * @param key  密钥
	 * @return 密文
	 *
	 * @throws Exception
	 */
	public static String md5(String text, String key) {
		//加密后的字符串
		String encodeStr = DigestUtils.md5Hex(text + key);
		System.out.println("MD5加密后的字符串为:encodeStr=" + encodeStr);
		return encodeStr;
	}

	/**
	 * MD5验证方法
	 *
	 * @param text 明文
	 * @param key  密钥
	 * @param md5  密文
	 * @return true/false
	 *
	 * @throws Exception
	 */
	public static boolean verify(String text, String key, String md5) {
		//根据传入的密钥进行验证
		String md5Text = md5(text, key);
		if (md5Text.equalsIgnoreCase(md5)) {
			System.out.println("MD5验证通过");
			return true;
		}

		return false;
	}

	public static void main(String[] args) {
		String md5Str = md5("text", "key");
		System.out.println(md5Str);

		boolean verify = verify("text", "key", "2da42e99d59372135b00c4a0a61ba191");
		System.out.println(verify);


	}
}