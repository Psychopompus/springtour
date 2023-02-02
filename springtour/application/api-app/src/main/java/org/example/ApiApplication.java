package org.example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import java.util.Arrays;

@Slf4j
@SpringBootApplication
public class ApiApplication {
    public static void main(String[] args) {
        /*
        1.
         */
        ConfigurableApplicationContext ctx = SpringApplication.run(ApiApplication.class, args);

        /*
        2. getBean 메서드는 인자에 맍는 스프링 빈 객체를 리턴한다.
            application.properties 에 저장된 키-밸류 값을 확인하기 위해 Environment 객체를 가져온다.
         */
        Environment env = ctx.getBean(Environment.class);
        /*
        3. 키가 server.port 인 밸류 값을 portValue 변수에 저장한다.
         */
        String portValue = env.getProperty("server.port");
        log.info("Customised Port : {}", portValue);

        /*
        4. ApplicationContext 객체가 관리하고 있는 스프링 빈들의 이름을 String[] 배열로 가져온다.
         */
        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.stream(beanNames).forEach(name -> log.info("Bean Name : {}", name));
    }
}
