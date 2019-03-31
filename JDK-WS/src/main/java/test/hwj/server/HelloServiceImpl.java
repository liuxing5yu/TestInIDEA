package test.hwj.server;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class HelloServiceImpl {
    @WebMethod
    public String sayHello(String name) {
        return "Hello " + name;
    }
}
