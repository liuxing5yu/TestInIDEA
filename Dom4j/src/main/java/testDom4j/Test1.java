/**
 * 
 */
package testDom4j;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

/**
 * 
 *
 * @author hwj
 * @date 2018年7月9日 下午5:19:45 
 *
 */
public class Test1 {

	/**
	 * 通过网络URL读取XML
	 *
	 * @throws DocumentException
	 */
	@Test
	public void test1() throws DocumentException {
		SAXReader reader = new SAXReader();
		Document document = reader.read("http://www.webxml.com.cn/WebServices/WeatherWebService.asmx?wsdl");
		System.out.println(document.asXML());
	}

	@Test
	public void test2() throws DocumentException {
		SAXReader reader = new SAXReader();
		reader.setStringInternEnabled(false);
		Document document = reader.read("pom.xml");
		Element rootElement = document.getRootElement();
		System.out.println(document.asXML()); // 有声明
		System.out.println("=========================================");
		System.out.println(rootElement.asXML()); // 没有声明
	}
}
