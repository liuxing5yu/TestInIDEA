package test.hwj.server;

import javax.xml.ws.Endpoint;

public class Publish {
    public static void main(String[] args) {
        Endpoint endpoint = Endpoint.publish("http://127.0.0.1:8888/hello", new HelloServiceImpl());
        System.out.println("�����ɹ� " + endpoint);
        // ���Ե�ַ
        // http://127.0.0.1:8888/hello?wsdl
    }
}
