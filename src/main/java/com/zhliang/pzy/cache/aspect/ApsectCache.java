package com.zhliang.pzy.cache.aspect;

import com.zhliang.pzy.cache.annotation.Cacheable;
import com.zhliang.pzy.cache.config.PowerCacheBuilder;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @类描述：缓存切面
 * @创建时间：2020/10/16 18:29
 */
@Aspect
@Component
public class ApsectCache {

    @Autowired
    private PowerCacheBuilder cacheBuilder;

    @Pointcut("@annotation(cacheable)")
    public void pointCut(Cacheable cacheable){}


    @Around("pointCut(cacheable)")
    public Object around(ProceedingJoinPoint point, Cacheable cacheable) throws Throwable {

        String key = cacheable.key();
        long expireTime = cacheable.expireTime();

        Object obj = cacheBuilder.get(key);
        if(obj == null){
            obj = point.proceed();
            cacheBuilder.set(key,obj,expireTime);
        }

        return obj;
    }
}
