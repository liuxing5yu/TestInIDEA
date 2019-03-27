import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.XMLType;
import org.apache.axis.encoding.ser.BeanDeserializerFactory;
import org.apache.axis.encoding.ser.BeanSerializerFactory;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;
import javax.xml.rpc.encoding.TypeMapping;
import javax.xml.rpc.encoding.TypeMappingRegistry;

/**
 * @author hwj
 * @date 2019/3/25 17:16
 */
public class Test2 {
	public static void main(String[] args) {
		try {
			//字符集
			String encodingStyle = "utf-8";
			//WSDL的地址
			String endpoint = "http://localhost:8090/webservice/ws/QueueInfo?wsdl";
			//命名空间，在WSDL中对应的标签是：参见说明第3条                                    
			String targetNamespace = "http://queue.ws.ks.neusoft.com/";
			//具体方法的调用URI，在WSDL中对应的标签是：参见说明第4条
			String soapActionURI = "";
			//具体调用的方法名，在WSDL中对应的标签是：参见说明第5条
			String method = "query";
			//调用接口的参数的名字
			String[] paramNames = {"idcardno"};
			//调用接口的参数的值
			String[] paramValues = {"320523192902240018"};

			Service service = new Service();
			Call call = (Call) service.createCall();
			// call.setTimeout(new Integer(20000));  //设置超时时间
			call.setSOAPActionURI(soapActionURI);
			call.setTargetEndpointAddress(new java.net.URL(endpoint));  //设置目标接口的地址
			call.setEncodingStyle(encodingStyle);//设置传入服务端的字符集格式如utf-8等
			call.setOperationName(new QName(targetNamespace, method));// 具体调用的方法名，可以由接口提供方告诉你，也可以自己从WSDL中找
			call.setUseSOAPAction(false);
			call.addParameter(new QName(paramNames[0]), XMLType.XSD_STRING, ParameterMode.IN);// 接口的参数
			//call.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING);// 设置返回类型  ，如String
			//call.setReturnClass(java.lang.Object[].class); //返回字符串数组类型
			call.setReturnClass(QueueInfoResult.class); //返回类型
			// QName qn = new QName("return");
			//call.registerTypeMapping(QueueInfoResult.class, qn, new BeanSerializerFactory(QueueInfoResult.class, qn), new BeanDeserializerFactory(QueueInfoResult.class, qn));

			QName qname_queueInfoResult = new QName("queueInfoResult");//注册实体对象
			QName qname = new QName("queueUnit");//注册实体对象
			call.registerTypeMapping(QueueInfoResult.class, qname_queueInfoResult, new BeanSerializerFactory(QueueInfoResult.class, qname_queueInfoResult), new BeanDeserializerFactory(QueueInfoResult.class, qname_queueInfoResult));
			call.registerTypeMapping(QueueUnit.class, qname, new BeanSerializerFactory(QueueUnit.class, qname), new BeanDeserializerFactory(QueueUnit.class, qname));

			// 给方法传递参数，并且调用方法 ，如果无参，则new Obe
			QueueInfoResult result = (QueueInfoResult) call.invoke(new Object[]{paramValues[0]});
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
