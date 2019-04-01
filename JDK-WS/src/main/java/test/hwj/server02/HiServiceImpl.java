package test.hwj.server02;

import javax.jws.WebService;

@WebService(endpointInterface = "test.hwj.server02.IHiService")
public class HiServiceImpl implements IHiService {
    public String sayHi(String name) {
        return "Hi " + name;
    }
}
