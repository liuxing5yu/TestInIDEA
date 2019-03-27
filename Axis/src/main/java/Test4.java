import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.XMLType;
import org.apache.axis.encoding.ser.BeanDeserializerFactory;
import org.apache.axis.encoding.ser.BeanSerializerFactory;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;
import javax.xml.rpc.encoding.TypeMapping;
import javax.xml.rpc.encoding.TypeMappingRegistry;
import java.awt.print.Book;
import java.util.Queue;

/**
 * 返回对象
 *
 * @author hwj
 * @date 2019/3/25 17:16
 */
public class Test4 {

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
			String method = "sayHello2";
			//调用接口的参数的名字
			String[] paramNames = {"name"};
			//调用接口的参数的值
			String[] paramValues = {"aaaxx"};

			Service service = new Service();
			Call call = (Call) service.createCall();
			// call.setTimeout(new Integer(20000));  //设置超时时间
			call.setSOAPActionURI(soapActionURI);
			call.setTargetEndpointAddress(new java.net.URL(endpoint));  //设置目标接口的地址
			call.setEncodingStyle(encodingStyle);//设置传入服务端的字符集格式如utf-8等
			call.setOperationName(new QName(targetNamespace, method));// 具体调用的方法名，可以由接口提供方告诉你，也可以自己从WSDL中找
			call.setUseSOAPAction(false);
			call.addParameter(new QName(paramNames[0]), XMLType.XSD_STRING, ParameterMode.IN);// 接口的参数
			call.setReturnClass(QueueUnit.class); //返回类型

			QName qname = new QName("queueUnit");//注册实体对象
			call.setReturnType(qname);
			call.registerTypeMapping(QueueUnit.class, qname, new BeanSerializerFactory(QueueUnit.class, qname), new BeanDeserializerFactory(QueueUnit.class, qname));

			// 给方法传递参数，并且调用方法 ，如果无参，则new Obe
			QueueUnit result = (QueueUnit) call.invoke(new Object[]{paramValues[0]});
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	// public void test3(){
	// 	TypeMappingRegistry registry = service.getTypeMappingRegistry();
	// 	TypeMapping mapping = registry.createTypeMapping();
	// 	registerBeanMapping(mapping, GetSubscriptionReq.class,new javax.xml.namespace. QName("http://req.portalEngine.ismp.chinatelecom.com", "GetSubscriptionReq"));
	// 	registerBeanMapping(mapping, GetSubscriptionRsp.class,new javax.xml.namespace. QName("http://rsp.portalEngine.ismp.chinatelecom.com", "GetSubscriptionRsp"));
	// 	registerBeanMapping(mapping, SubInfo.class,new javax.xml.namespace. QName("http://rsp.portalEngine.ismp.chinatelecom.com", "SubInfo"));
	// 	registry.register("http://schemas.xmlsoap.org/soap/encoding/", mapping);
	// 	protected void registerBeanMapping(TypeMapping mapping, Class type,
	// 			                                                              javax.xml.namespace.QName qname) {
	// 		mapping.register(type, qname, new BeanSerializerFactory(type, qname),
	// 				new BeanDeserializerFactory(type, qname));
	// 	}
	// }

	// GetSubscriptionReq input = new GetSubscriptionReq();
	// GetSubscriptionRsp output = null;
	// Service service = new Service();
	// Call call = (Call)service.createCall();
	// 	call.setTimeout(new Integer(20000));
	// org.apache.axis.description.OperationDesc oper;
	// org.apache.axis.description.ParameterDesc param;
	// oper = new org.apache.axis.description.OperationDesc();
	//     oper.setName("getSubscription");
	// param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://portalEngine.ismp.chinatelecom.com", "getSubscriptionReq"),
	// org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://req.portalEngine.ismp.chinatelecom.com", "GetSubscriptionReq"),
	// GetSubscriptionReq.class, false, false);
	//     oper.addParameter(param);
	//     oper.setReturnType(new javax.xml.namespace.QName("http://rsp.portalEngine.ismp.chinatelecom.com", "GetSubscriptionRsp"));
	//     oper.setReturnClass(GetSubscriptionRsp.class);
	//     oper.setReturnQName(new javax.xml.namespace.QName("http://portalEngine.ismp.chinatelecom.com", "getSubscriptionRsp"));
	//     oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
	//     oper.setUse(org.apache.axis.constants.Use.LITERAL);
	//     call.setOperation(oper);
	//     call.setOperationName("getSubscription");
	//     call.setTargetEndpointAddress("http://"+service_addr+"/PortalEngineService");
	//
	//
	//     try{
	// 		output = (GetSubscriptionRsp)call.invoke(new Object[]{input});//调用webservices服务
	// 	}catch(Exception e)
	// 	{
	// 		throw new ServantException("core_invoke_webservices_failure",e.getMessage());
	// 	}
}
