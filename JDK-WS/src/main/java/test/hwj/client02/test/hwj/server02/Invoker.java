package test.hwj.client02.test.hwj.server02;

import test.hwj.server02.IHiService;

public class Invoker {
    public static void main(String[] args) {
        HiServiceImplService hiServiceImplService = new HiServiceImplService();
        IHiService hiServiceImplPort = hiServiceImplService.getHiServiceImplPort();
        String xxx = hiServiceImplPort.sayHi("XXX");
        System.out.println(xxx);
    }
}
