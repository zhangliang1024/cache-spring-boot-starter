package com.zhliang.pzy.cache.config;

import org.springframework.context.annotation.Configuration;

/**
 * @创建时间：2020/10/16 20:02
 * @version：V1.0
 */
@Configuration
//@EnableConfigurationProperties(ConfigProp.class)
public class CacheAutoConfig {
    /*
    private static final Logger logger = LoggerFactory.getLogger(CacheAutoConfig.class);

    @Bean
    @ConditionalOnMissingBean
    public PowerCacheBuilder powerCacheBuilder(){
        logger.info("cacheBuilder init ...");
        return new PowerCacheBuilder();
    }
    @Scope("prototype")
    @Bean(name = "localCacheService")
    @ConditionalOnMissingBean
    @ConditionalOnProperty(value = "cache.power.isuselocalcache",havingValue = "local")
    public CacheProviderService localCacheService(){
        return new LocalCacheProviderImpl();
    }
    @Bean(name = "redisCacheService")
    @ConditionalOnMissingBean
    @ConditionalOnProperty(value = "cache.power.isuserediscache",havingValue = "redis")
    public CacheProviderService redisCacheService(){
        return new RedisCacheProviderImpl();
    }
    @Bean
    public ApsectCache apsectCache(){
        return new ApsectCache();
    }
    */

}
