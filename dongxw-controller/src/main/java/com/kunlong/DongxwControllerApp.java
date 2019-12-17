package com.kunlong;

import com.kunlong.dongxw.DemoLoggerA;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


// mvn deploy:deploy-file -DgroupId=app -DartifactId=app-support -Dversion=1.1 -Dpackaging=jar -Dfile=app-support-1.1.jar -Durl=http://localhost:8081/repository/maven-releases/ -DrepositoryId=nexus

//
//@EnableAutoConfiguration
//@Configuration
@SpringBootApplication(scanBasePackages = {"com.kunlong"})
//@EnableDubbo
//@EnableDubboConfig
//@ImportResource({"classpath:appcontext.xml"})
public class DongxwControllerApp {
    private static final Logger logger = LoggerFactory.getLogger(DongxwControllerApp.class);


    public static void main(String[] args) {

         Class[] classes = new Class[]{
                DongxwControllerApp.class
        };
        SpringApplication.run(classes, args);
        new DemoLoggerA().t();
    }
}
