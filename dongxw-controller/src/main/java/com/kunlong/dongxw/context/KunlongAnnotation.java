package com.kunlong.dongxw.context;


import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface KunlongAnnotation {
    String value() default "";
}