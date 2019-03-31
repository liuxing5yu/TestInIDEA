package test.hwj.client;

import test.hwj.client.test.hwj.server.HelloServiceImpl;
import test.hwj.client.test.hwj.server.HelloServiceImplService;

public class Invoker {
    public static void main(String[] args) {
        HelloServiceImpl helloServiceImpl = new HelloServiceImplService().getHelloServiceImplPort();
        System.out.println(helloServiceImpl.getClass());
        String zhangsan = helloServiceImpl.sayHello("zhangsan");
        System.out.println(zhangsan);
    }
}
