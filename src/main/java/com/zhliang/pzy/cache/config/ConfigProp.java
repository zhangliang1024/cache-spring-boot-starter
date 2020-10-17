package com.zhliang.pzy.cache.config;

import com.zhliang.pzy.cache.constant.AppConst;
import com.zhliang.pzy.cache.constant.AppField;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.CollectionUtils;
import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @类描述：
 * @创建时间：2020/10/16 13:40
 * @version：V1.0
 */
@Configuration
@ConfigurationProperties(prefix = "cache.power")
public class ConfigProp {

    private static Map<String,String> configMap = new ConcurrentHashMap<>();


    public String isUseLocalCache  = AppConst.IS_USE_LOCAL_CACHE;

    public String isUseRedisCache  = AppConst.IS_USE_REDIS_CACHE;

    public long cacheMaximumSize = AppConst.CACHE_MAXIMUM_SIZE;

    public long cacheMinute = AppConst.CACHE_MINUTE;

    public String cacheVersionKey = AppConst.CACHE_VERSION_KEY;


    public String getIsUseLocalCache() {
        return isUseLocalCache;
    }
    public void setIsUseLocalCache(String isUseLocalCache) {
        this.isUseLocalCache = isUseLocalCache;
    }
    public String getIsUseRedisCache() {
        return isUseRedisCache;
    }
    public void setIsUseRedisCache(String isUseRedisCache) {
        this.isUseRedisCache = isUseRedisCache;
    }
    public long getCacheMaximumSize() {
        return cacheMaximumSize;
    }
    public void setCacheMaximumSize(long cacheMaximumSize) {
        this.cacheMaximumSize = cacheMaximumSize;
    }
    public long getCacheMinute() {
        return cacheMinute;
    }
    public void setCacheMinute(int cacheMinute) {
        this.cacheMinute = cacheMinute;
    }
    public String getCacheVersionKey() {
        return cacheVersionKey;
    }
    public void setCacheVersionKey(String cacheVersionKey) {
        this.cacheVersionKey = cacheVersionKey;
    }

    @PostConstruct
    public void init(){
        if(StringUtils.isNotBlank(isUseLocalCache) && AppConst.IS_USE_LOCAL_CACHE.equals(isUseLocalCache)){
            configMap.put(AppField.IS_USE_LOCAL_CACHE,isUseLocalCache);
        }
        if(StringUtils.isNotBlank(isUseRedisCache) && AppConst.IS_USE_REDIS_CACHE.equals(isUseRedisCache)){
            configMap.put(AppField.IS_USE_REDIS_CACHE,isUseRedisCache);
        }
        if (CollectionUtils.isEmpty(configMap)) {
            throw new RuntimeException("cache bean init error, the config is illegal ");
        }
    }

    /**
     * 根据KEY获取缓存实现
     * @param isUse
     */
    public String getConfigVal(String isUse) {
        return configMap.get(isUse);
    }
}
