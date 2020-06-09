package com.fuck.cloudnative.docker.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* DESCRIPTION:
* 
* @author zouyan
* @create 2020/5/27-上午11:04
* created by fuck~ 
**/
@RestController
@SpringBootApplication
public class DockerDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DockerDemoApplication.class, args);
    }

    @GetMapping("/hello") public String sayHello() {
        return "docker demo Hello World!";
    }
}
