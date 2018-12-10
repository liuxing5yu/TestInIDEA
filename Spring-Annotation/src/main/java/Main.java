import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import test.hwj.config.MyConfig;
import test.hwj.config.NoAnnotationClass;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext acac = new AnnotationConfigApplicationContext(MyConfig.class);
        String[] strArr = acac.getBeanDefinitionNames();
        for (String str : strArr) {
            System.out.println(str);
        }

        System.out.println("=====================");

    }
}
