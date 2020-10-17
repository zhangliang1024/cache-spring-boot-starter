package com.zhliang.pzy.cache.annotation;

import java.lang.annotation.*;

/**
 * @Description: 二级缓存注解
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Cacheable {

    String key() default "";

    long expireTime() default 600L;

}
