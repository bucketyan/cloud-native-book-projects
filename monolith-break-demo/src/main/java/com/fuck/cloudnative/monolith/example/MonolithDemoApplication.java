package com.fuck.cloudnative.monolith.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class MonolithDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MonolithDemoApplication.class, args);
    }

}


/*
@EnableSwagger2
@SpringBootApplication
public class MonolithDemoApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(MonolithDemoApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(MonolithDemoApplication.class);
    }

}
*/
