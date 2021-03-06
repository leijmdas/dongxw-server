package com.kunlong.dongxw;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubboConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;


//@ImportResource({"classpath:appcontext.xml"})
// mvn deploy:deploy-file -DgroupId=app -DartifactId=app-support -Dversion=1.1 -Dpackaging=jar -Dfile=app-support-1.1.jar -Durl=http://localhost:8081/repository/maven-releases/ -DrepositoryId=nexus
//https://github.com/macrozheng/mall
@EnableAutoConfiguration
@Configuration
@SpringBootApplication(scanBasePackages = {"com.kunlong"})
@EnableDubbo
@EnableDubboConfig
@EnableSwagger2
@MapperScan(basePackages={"com.kunlong.dongxw.data.dao"})
public class DongxwApp {
    private static final Logger logger = LoggerFactory.getLogger(DongxwApp.class);

    public static void main(String[] args) {

        SpringApplication.run(new Class[]{DongxwApp.class}, args);

    }
}