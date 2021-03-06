package com.kunlong.dongxw;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubboConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


// mvn deploy:deploy-file -DgroupId=app -DartifactId=app-support -Dversion=1.1 -Dpackaging=jar -Dfile=app-support-1.1.jar -Durl=http://localhost:8081/repository/maven-releases/ -DrepositoryId=nexus
//https://github.com/macrozheng/mall
@EnableAutoConfiguration
@Configuration
@SpringBootApplication(scanBasePackages = {"com.kunlong"})
@EnableDubbo
@EnableDubboConfig
@EnableSwagger2
public class CustomerApp {

    public static void main(String[] args) {

        SpringApplication.run( new Class[]{CustomerApp.class}, args);

    }
}