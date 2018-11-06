/**
 * 
 */
package testDom4j;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Namespace;
import org.dom4j.Node;
import org.dom4j.XPath;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

/**
 * 
 *
 * @author hwj
 * @date 2018年7月9日 下午6:35:27 
 *
 */
public class TestDom4j {

	/**
	 * 解析XML
	 *
	 * @throws DocumentException
	 */
	@Test
	public void test1() throws DocumentException {
		SAXReader reader = new SAXReader();
		Document document = reader.read("pom.xml");
		System.out.println(document.asXML()); // 有声明
		System.out.println("=========================================");
		Element rootElement = document.getRootElement();
		System.out.println(rootElement.asXML()); // 没有声明
	}

	/**
	 * @throws DocumentException 
	 * 
	 *
	 */
	@Test
	public void test2() throws DocumentException {
		SAXReader reader = new SAXReader();
		Document document = reader.read("pom.xml");
		Element rootElement = document.getRootElement();
		for (Iterator<Element> it = rootElement.elementIterator(); it.hasNext();) {
			Element element = it.next();
			// System.out.println(element.asXML());
			System.out.println(element.getNamespacePrefix());
			System.out.println(element.getNamespaceURI());
			System.out.println(element.getNamespace());
			System.out.println(element.getQName().getNamespace().getPrefix());
			System.out.println("=========================================");
		}

		System.out.println("=========================================");

		Element dependencies = rootElement.element("dependencies");
		for (Iterator<Element> it = dependencies.elementIterator("dependency"); it.hasNext();) {
			Element element = it.next();
			System.out.println(element.asXML());
			System.out.println("=========================================");
		}
	}

	@Test
	public void test3() throws DocumentException {
		SAXReader reader = new SAXReader();
		Document document = reader.read("pom.xml");
		System.out.println(document.asXML());

		// List<Node> selectNodes = document.selectNodes("//packaging");
		// System.out.println(selectNodes.size());

		Node node = document.selectSingleNode("//packaging");
		System.out.println(node.getText());
	}

	@Test
	public void test4() throws DocumentException {
		SAXReader saxReader = new SAXReader();
		File file = new File("pom.xml");
		Document document = saxReader.read(file);

		Element rootElement = document.getRootElement();
		Namespace namespace = rootElement.getNamespace();
		String xPathNameStep = namespace.getXPathNameStep();
		System.out.println(xPathNameStep);

		String namespaceURI = rootElement.getNamespaceURI();
		System.out.println(namespaceURI);

		Map map = new HashMap();
		map.put("design", "http://maven.apache.org/POM/4.0.0");
		XPath x = document.createXPath("//design:packaging");
		x.setNamespaceURIs(map);
		List nodelist = x.selectNodes(document);
		System.out.println(nodelist.size());
	}

	@Test
	public void test5() throws DocumentException {
		SAXReader saxReader = new SAXReader();
		File file = new File("dom.xml");
		Document document = saxReader.read(file);

		Node nnn = document.selectSingleNode("//dependency");
		System.out.println(nnn.asXML());

		// 多个相同名称的节点
		List<Node> nodeList = document.selectNodes("//dependency");
		System.out.println(nodeList.size());

		// 单个节点
		Node node = document.selectSingleNode("//version");
		System.out.println(node.getText());

		// 节点的属性
		String name = node.valueOf("@name");
		System.out.println(name);
	}

	@Test
	public void test6() throws DocumentException {
		SAXReader saxReader = new SAXReader();
		File file = new File("dom.xml");
		Document document = saxReader.read(file);

		treeWalk(document);
	}

	public void treeWalk(Document document) {
		treeWalk(document.getRootElement());
	}

	public void treeWalk(Element element) {
		for (int i = 0, size = element.nodeCount(); i < size; i++) {
			Node node = element.node(i);
			if (node instanceof Element) {
				treeWalk((Element) node);
			} else {
				// do something…
			}
		}
	}

	@Test
	public void test7() {
		Document document = DocumentHelper.createDocument();
		System.out.println(document.asXML());
		// Element root = document.addElement("root");
		//
		// Element author1 = root.addElement("author").addAttribute("name", "James").addAttribute("location", "UK")
		// .addText("James Strachan");
		//
		// Element author2 = root.addElement("author").addAttribute("name", "Bob").addAttribute("location", "US")
		// .addText("Bob McWhirter");

	}

	/**
	 * 将XML导出到文件中
	 *
	 * @throws IOException
	 */
	@Test
	public void test8() throws IOException {
		Document document = DocumentHelper.createDocument();

		FileWriter out = new FileWriter("foo.xml");
		document.write(out);
		out.close();
	}

	@Test
	public void test9() throws DocumentException {
		String text = "<person> <name>James</name> </person>";
		Document document = DocumentHelper.parseText(text);
		System.out.println(document.asXML());
	}

	@Test
	public void test10() throws DocumentException, IOException {
		SAXReader reader = new SAXReader();
		Document document = reader.read("pom.xml");

		// Pretty print the document to System.out
		OutputFormat format = OutputFormat.createPrettyPrint();
		XMLWriter writer = new XMLWriter(System.out, format);
		writer.write(document);

		System.out.println("====================================");

		// Compact format to System.out
		format = OutputFormat.createCompactFormat();
		writer = new XMLWriter(System.out, format);
		writer.write(document);
		writer.close();
	}

	@Test
	public void test11() throws DocumentException, IOException {
		SAXReader reader = new SAXReader();
		Document document = reader.read("pom.xml");
		
		// 设置XML文档格式
        OutputFormat outputFormat = OutputFormat.createPrettyPrint();  
        // 设置XML编码方式,即是用指定的编码方式保存XML文档到字符串(String),这里也可以指定为GBK或是ISO8859-1  
        outputFormat.setEncoding("UTF-8");
        
		// stringWriter字符串是用来保存XML文档的
		StringWriter stringWriter = new StringWriter();
		// xmlWriter是用来把XML文档写入字符串的(工具)
		XMLWriter xmlWriter = new XMLWriter(stringWriter, outputFormat);

		// 把创建好的XML文档写入字符串
		xmlWriter.write(document);

		// 打印字符串,即是XML文档
		System.out.println(stringWriter.toString());
	}

}
