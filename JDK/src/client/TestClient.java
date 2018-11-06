/**
 * 
 */
package client;

/**
 * 
 *
 * @author hwj
 * @date 2018年3月27日 上午9:25:37 
 *
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/** 
 *  
 * <p>Title: HttpClient.java</p> 
 * <p>Description:HttpURLConnection调用方式</p> 
 */
public class TestClient {

	public static void main(String[] args) throws IOException {
		String path = "http://localhost:8888/shrimp/ws/chmWebService";

		// 第一步：创建服务地址，不是WSDL地址
		URL url = new URL(path);
		// 第二步：打开一个通向服务地址的连接
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		// 第三步：设置参数
		// 3.1发送方式设置：POST必须大写
		connection.setRequestMethod("POST");
		// 3.2设置数据格式：content-type
		connection.setRequestProperty("content-type", "text/xml;charset=utf-8");
		// 3.3设置输入输出，因为默认新创建的connection没有读写权限，
		connection.setDoInput(true);
		connection.setDoOutput(true);

		// 第四步：组织SOAP数据，发送请求
		// String soapXML = getXML("15226466316");
		String soapXML = getXML3("429004199301151594");
		OutputStream os = connection.getOutputStream();
		os.write(soapXML.getBytes());
		// 第五步：接收服务端响应，打印
		int responseCode = connection.getResponseCode();
		if (200 == responseCode) {// 表示服务端响应成功
			InputStream is = connection.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);

			StringBuilder sb = new StringBuilder();
			String temp = null;
			while (null != (temp = br.readLine())) {
				sb.append(temp);
			}
			System.out.println(sb.toString());

			is.close();
			isr.close();
			br.close();
		} else {
			System.out.println("出错了！！！" + responseCode);
		}

		os.close();
	}

	/**
	 * <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:web="http://webservice.neusoft.com/">
	<soapenv:Header/>
	<soapenv:Body>
	  <web:webService>
	     <!--Optional:-->
	     <arg0>0001</arg0>
	     <!--Optional:-->
	     <arg1>429004199301151594</arg1>
	  </web:webService>
	</soapenv:Body>
	</soapenv:Envelope>
	 * 
	 *
	 * @param string
	 * @return
	 */
	private static String getXML3(String idCardNo) {
		String soapXML = "<?xml version=\"1.0\" encoding=\"utf-8\"?>"
				+ "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:web=\"http://webservice.neusoft.com/\">"
				+ "<soapenv:Header/>" + "<soapenv:Body>" + "<web:webService>" + "<arg0>" + "0001" + "</arg0>" + "<arg1>"
				+ idCardNo + "</arg1>" + "</web:webService>" + "</soapenv:Body>" + "</soapenv:Envelope>";

		return soapXML;
	}

	/*
	 * <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:base="http://base.webservice.sample.neusoft.com/">
	<soapenv:Header/>
	<soapenv:Body>
	  <base:sayHi>
	     <!--Optional:-->
	     <arg0>?</arg0>
	  </base:sayHi>
	</soapenv:Body>
	</soapenv:Envelope>
	 */
	private static String getXML2(String name) {
		String soapXML = "<?xml version=\"1.0\" encoding=\"utf-8\"?>"
				+ "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:base=\"http://base.webservice.sample.neusoft.com/\">"
				+ "<soapenv:Header/>" + "<soapenv:Body>" + "<base:sayHi>" + "<arg0>" + name + "</arg0>"
				+ "</base:sayHi>" + "</soapenv:Body>" + "</soapenv:Envelope>";

		return soapXML;
	}

	/** 
	 * <?xml version="1.0" encoding="utf-8"?> 
	<soap:Envelope xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/"> 
	<soap:Body> 
	<getMobileCodeInfo xmlns="http://WebXml.com.cn/"> 
	  <mobileCode>string</mobileCode> 
	  <userID>string</userID> 
	</getMobileCodeInfo> 
	</soap:Body> 
	</soap:Envelope> 
	 * @param phoneNum 
	 * @return 
	 */
	public static String getXML(String phoneNum) {
		String soapXML = "<?xml version=\"1.0\" encoding=\"utf-8\"?>"
				+ "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">"
				+ "<soap:Body>" + "<getMobileCodeInfo xmlns=\"http://WebXml.com.cn/\">" + "<mobileCode>" + phoneNum
				+ "</mobileCode>" + "<userID></userID>" + "</getMobileCodeInfo>" + "</soap:Body>" + "</soap:Envelope>";
		return soapXML;
	}
}