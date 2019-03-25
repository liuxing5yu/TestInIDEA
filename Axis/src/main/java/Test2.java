import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

import javax.xml.namespace.QName;

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
			String[] paramValues = {"320523194408305137"};

			Service service = new Service();
			Call call = (Call) service.createCall();
			// call.setTimeout(new Integer(20000));  //设置超时时间
			call.setSOAPActionURI(soapActionURI);
			call.setTargetEndpointAddress(new java.net.URL(endpoint));  //设置目标接口的地址
			call.setEncodingStyle(encodingStyle);//设置传入服务端的字符集格式如utf-8等
			call.setOperationName(new QName(targetNamespace, method));// 具体调用的方法名，可以由接口提供方告诉你，也可以自己从WSDL中找
			call.setUseSOAPAction(true);
			call.addParameter(new QName(targetNamespace, paramNames[0]), org.apache.axis.encoding.XMLType.XSD_INTEGER, javax.xml.rpc.ParameterMode.IN);// 接口的参数
			// call.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING);// 设置返回类型  ，如String
			call.setReturnClass(java.lang.String[].class); //返回字符串数组类型
			// 给方法传递参数，并且调用方法 ，如果无参，则new Obe
			String[] result = (String[]) call.invoke(new Object[]{paramValues[0]});
			// 打印返回值
			System.out.println("result is " + result.toString());
			if (result != null && result.length > 0) {
				for (int i = 0; i < result.length; i++) {
					System.out.println(result[i]);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
