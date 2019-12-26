package com.kunlong.dongxw.context;

import com.kunlong.api.service.AuthApiService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class DongxwContext implements ApplicationContextAware {

    @Reference(lazy = true, version = "${dubbo.service.version}")
    public AuthApiService authApiService;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        appCtxt = applicationContext;


    }

    public static ApplicationContext getAppCtxt() {
        return appCtxt;
    }


    private static ApplicationContext appCtxt;


}