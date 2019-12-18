package com.kunlong.service.dongxw;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DemoLoggerA {
    private static final Logger logger = LoggerFactory.getLogger(DemoLoggerA.class);

    public void t() {
        logger.info("com.kunlong.service.dongxw.DemoLoggerA info getLogger");
    }

    public static void main(String[] args) {
        System.out.println(1);
        new DemoLoggerA().t();
    }
}
