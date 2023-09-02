package bean_practice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnotherConfig {

    @Bean("Str1")
    String addText1(){
        return "Welcome to World";
    }
    @Bean("Str2")
    String addText2(){
        return "Spring Core Practice";
    }
}
