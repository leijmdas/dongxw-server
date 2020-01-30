package com.kunlong.dongxw.context;


import javassist.bytecode.SignatureAttribute;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
//
//@Aspect
//@Component
//public class KunongAspect {
//
//    @Pointcut("@annotation(KunlongAnnotation)")
//    public void annotationPointcut() {
//    }
//
//    @Before("annotationPointcut()")
//    public void beforePointcut(JoinPoint joinPoint) {
//        SignatureAttribute.MethodSignature methodSignature = (SignatureAttribute.MethodSignature) joinPoint.getSignature();
//        Method method = methodSignature.getMethod();
//        KunlongAnnotation annotation = method.getAnnotation(KunlongAnnotation.class);
//        String value = annotation.value();
//        System.out.println("准备" + value);
//    }
//
//    @After("annotationPointcut()")
//    public void afterPointcut(JoinPoint joinPoint) {
//        SignatureAttribute.MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
//        Method method = methodSignature.getMethod();
//        KunlongAnnotation annotation = method.getAnnotation(KunlongAnnotation.class);
//        String value = annotation.value();
//        System.out.println("结束" + value);
//    }
//}