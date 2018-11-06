/**
 * 
 */
package testDom4j;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 *
 * @author hwj
 * @date 2018年7月12日 上午9:34:33 
 *
 */
public class TestXPath {
	private SAXReader reader = null;
	private Document document = null;

	@Before
	public void before() throws DocumentException {
		reader = new SAXReader();
		document = reader.read("pom.xml");
	}

	@Test
	public void test1() {
		List<Node> selectNodes = document.selectNodes("//groupId");
		Node node = selectNodes.get(0);
		System.out.println(node);
		Node parentNode = node.selectSingleNode("..");
		System.out.println(parentNode);
	}

	@Test
	public void test2() {
		Object object = document.selectObject("//project.build.sourceEncoding");
		System.out.println(object.getClass().getName());
		System.out.println(object);
	}

	@Test
	public void test3() {
		List<Node> selectNodes = document.selectNodes("//@*");
		System.out.println(selectNodes);
	}
	
	@Test
	public void test4() {
		List<Node> selectNodes = document.selectNodes("//node()");
		System.out.println(selectNodes);
	}
	
	@Test
	public void test5() {
		List<Node> selectNodes = document.selectNodes("child::book");
		System.out.println(selectNodes);
		
		Element rootElement = document.getRootElement();
		List<Node> selectNodes2 = rootElement.selectNodes("child::book");
		System.out.println(selectNodes2);
	}
}
