package com.kunlong.dongxw.customer.context;

import com.kunlong.dubbo.api.service.AuthApiService;
import com.alibaba.dubbo.config.annotation.Reference;
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