package test.hwj.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;
import java.io.StringWriter;

/**
 * @author hwj
 * @date 2019/5/13 9:37
 */
public class XMLPrintTest {
	public static void main(String[] args) {
		XmlDTO xmlDTO = new XmlDTO();
		xmlDTO.status = 1;
		System.out.println(xmlDTO);


		String s = convertToXml(xmlDTO);
		System.out.println(s);

	}

	public static String convertToXml(Object obj) {
		// 创建输出流
		StringWriter sw = new StringWriter();
		try {
			// 利用jdk中自带的转换类实现
			JAXBContext context = JAXBContext.newInstance(obj.getClass());

			Marshaller marshaller = context.createMarshaller();
			// 格式化xml输出的格式
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");

			// 隐藏声明中的 standalone="yes"
			marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);

			// 避免在类上添加@XmlRootElement注解
			QName q = new QName(obj.getClass().getSimpleName());
			JAXBElement jaxbPerson = new JAXBElement(q, obj.getClass(), obj);

			// 将对象转换成输出流形式的xml
			marshaller.marshal(jaxbPerson, sw);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return sw.toString();
	}
}
