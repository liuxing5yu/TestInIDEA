/**
 * 
 */
package properties;

import java.util.ResourceBundle;

/**
 * 
 *
 * @author hwj
 * @date 2018年7月25日 下午1:27:52 
 *
 */
public class Test1 {
	private static ResourceBundle rb = ResourceBundle.getBundle("properties/xmlsign");
	
	public static void main(String[] args) {
		String encoding = rb.getString("xml.signature.encoding"); 
		System.out.println(encoding);
	}
	
}
