package test.hwj.config;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;

@Import(MyConfig2.class)
@Configuration
@ComponentScan(basePackages = {"test.hwj"})
public class MyConfig {

    @Lazy(false)
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    @Bean
    public NoAnnotationClass noAnnotationClass(){
        System.out.println("创建noAnnotationClass...");
        return new NoAnnotationClass();
    }
}
