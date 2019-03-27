import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.XMLType;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;

/**
 * 返回String
 *
 * @author hwj
 * @date 2019/3/26 11:11
 */
public class Test3 {
	public static void main(String[] args) {
		try {
			//字符集
			String encodingStyle = "utf-8";
			//WSDL的地址
			String endpoint = "http://localhost:8090/webservice/ws/Hello?wsdl";
			//命名空间，在WSDL中对应的标签是：参见说明第3条                                    
			String targetNamespace = "http://hello.ws.ks.neusoft.com/";
			//具体方法的调用URI，在WSDL中对应的标签是：参见说明第4条
			String soapActionURI = "";
			//具体调用的方法名，在WSDL中对应的标签是：参见说明第5条
			String method = "sayHello";
			//调用接口的参数的名字
			String[] paramNames = {"name"};
			//调用接口的参数的值
			String[] paramValues = {"xxy"};

			Service service = new Service();
			Call call = (Call) service.createCall();
			call.setTimeout(new Integer(2000));  //设置超时时间
			call.setSOAPActionURI(soapActionURI);
			call.setTargetEndpointAddress(new java.net.URL(endpoint));  //设置目标接口的地址
			call.setEncodingStyle(encodingStyle);//设置传入服务端的字符集格式如utf-8等
			call.setOperationName(new QName(targetNamespace, method));// 具体调用的方法名，可以由接口提供方告诉你，也可以自己从WSDL中找
			call.setUseSOAPAction(true);
			call.addParameter(new QName(paramNames[0]), XMLType.XSD_STRING, ParameterMode.IN);// 接口的参数
			// call.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING);// 设置返回类型  ，如String
			call.setReturnClass(java.lang.String.class); //返回类型
			// 给方法传递参数，并且调用方法 ，如果无参，则new Obe
			String result = (String) call.invoke(new Object[]{paramValues[0]});
			// 打印返回值
			System.out.println("result is " + result.toString());

		} catch (Exception e) {
			System.err.println(e.toString());
		}
	}
}
