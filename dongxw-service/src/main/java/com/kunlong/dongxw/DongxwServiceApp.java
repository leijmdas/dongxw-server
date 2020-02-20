package com.kunlong.dongxw;

import com.kunlong.dongxw.config.DongxwTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.spring.annotation.MapperScan;


// mvn deploy:deploy-file -DgroupId=app -DartifactId=app-support -Dversion=1.1 -Dpackaging=jar -Dfile=app-support-1.1.jar -Durl=http://localhost:8081/repository/maven-releases/ -DrepositoryId=nexus

@EnableAutoConfiguration(exclude = {
        SecurityAutoConfiguration.class
})
@Configuration
@SpringBootApplication(scanBasePackages = {"com.kunlong.data","com.kunlong.dongxw"})
//@EnableDubbo//@EnableDubboConfig
//@ImportResource({"classpath:appcontext.xml"})
@MapperScan(basePackages={"com.kunlong.dongxw.data.dao"})
public class DongxwServiceApp {
    private static final Logger logger = LoggerFactory.getLogger(DongxwServiceApp.class);

    public static void main(String[] args) {

         Class[] classes = new Class[]{
                  DongxwServiceApp.class
        };
        SpringApplication.run(classes, args);
    }

}
