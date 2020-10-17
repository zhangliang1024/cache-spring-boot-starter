## JAVA二级缓存系统 基于Guava+Redis
> 在项目开发中，我们经常会用到“缓存”来提升系统性能。使用好缓存也是一个开发人员要具备的基本技能。

[演示Demo]()

### 一、项目介绍



### 二、使用说明
> pom
```xml
 <!--二级缓存-->
<dependency>
    <groupId>com.zhliang.pzy</groupId>
    <artifactId>cache-spring-boot-starter</artifactId>
    <version>0.0.1-SNAPSHOT</version>
</dependency>
```
> java
```java
/**
 * 扫描二级缓存组件
 */
@Configuration
@ComponentScan(basePackages = "com.zhliang.pzy.cache")
public class CustomerCacheAutoConfig {

}
```
> application
```yaml
## 二级缓存Redis相关配置
spring:
  redis:
    host: localhost
    port: 6379
    database: 0
    password:
    # redis连接超时时间(默认：5分钟，单位：毫秒)
    timeout: 300000ms
    jedis:
      pool:
        # redis连接池最大连接数
        max-active: 512
        # redis连接池最小空闲连接
        min-idle: 0
        # redis连接池最大空闲连接
        max-idle: 8
        # redis连接池最大阻塞等待时间(-1表示没有限制)
        max-wait: -1ms


## 启用二级缓存配置
cache:
  power:
    # 启用本地缓存
    is-use-local-cache: local
    # 启用redis缓存
    is-use-redis-cache: redis
    # 本地缓存最大队列数
    cache-maximum-size: 10
    # 本地缓存分片(应对不同的过期时间，创建不同的缓存分片)
    cache-minute: 10
    # 缓存版本配置
    cache-version-key: version:v0
```


### 三、参考文档
> 

[贼厉害，手撸的 SpringBoot缓存系统，性能杠杠的！](https://blog.csdn.net/qq_17231297/article/details/108544347)
[]()
[]()

