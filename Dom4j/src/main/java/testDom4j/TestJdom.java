/**
 * 
 */
package testDom4j;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.junit.Test;

/**
 * 
 *
 * @author hwj
 * @date 2018年7月9日 下午6:33:45 
 *
 */
public class TestJdom {
	/**
	 * JDOM
	 * @throws IOException 
	 * @throws JDOMException 
	 *
	 */
	@Test
	public void test1() throws JDOMException, IOException {
		SAXBuilder saxBuilder = new SAXBuilder();
		InputStream in = new FileInputStream("pom.xml");
		Document document = saxBuilder.build(in);
		System.out.println(document);
	}
}
