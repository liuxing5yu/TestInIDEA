package test.hwj.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig2 {

    @Bean("No1")
    public NoAnnotationClass noAnnotationClass(){
        return new NoAnnotationClass();
    }
}
