package com.kunlong.dongxw;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


// mvn deploy:deploy-file -DgroupId=app -DartifactId=app-support -Dversion=1.1 -Dpackaging=jar -Dfile=app-support-1.1.jar -Durl=http://localhost:8081/repository/maven-releases/ -DrepositoryId=nexus
//https://github.com/macrozheng/mall
@EnableAutoConfiguration
@Configuration
@SpringBootApplication(scanBasePackages = {"com.kunlong.dongxw","com.kunlong.api"})
//@EnableDubbo
//@EnableDubboConfig
//@ImportResource({"classpath:appcontext.xml"})
@EnableSwagger2
public class DongxwCtrlApp {
    private static final Logger logger = LoggerFactory.getLogger(DongxwCtrlApp.class);


    public static void main(String[] args) {

        Class[] classes = new Class[]{
                DongxwCtrlApp.class
        };
        SpringApplication.run(classes, args);

    }
}