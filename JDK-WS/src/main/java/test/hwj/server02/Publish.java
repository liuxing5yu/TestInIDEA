package test.hwj.server02;

import javax.xml.ws.Endpoint;

public class Publish {
    public static void main(String[] args) {
        Endpoint.publish("http://127.0.0.1:9999/hi", new HiServiceImpl());
        System.out.println("发布完成");
    }
}
