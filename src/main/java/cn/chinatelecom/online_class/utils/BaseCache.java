package cn.chinatelecom.online_class.utils;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class BaseCache {
    private Cache<String,Object> tenMiniutesCache = CacheBuilder.newBuilder()
            .initialCapacity(10)
            .maximumSize(100)
            .concurrencyLevel(5)
            .expireAfterWrite(600, TimeUnit.SECONDS)
            .recordStats()
            .build();
    private Cache<String,Object> oneHourCache = CacheBuilder.newBuilder()
            .initialCapacity(30)
            .maximumSize(100)
            .concurrencyLevel(5)
            .expireAfterWrite(3600, TimeUnit.SECONDS)
            .recordStats()
            .build();

    public Cache<String, Object> getOneHourCache() {
        return oneHourCache;
    }

    public void setOneHourCache(Cache<String, Object> oneHourCache) {
        this.oneHourCache = oneHourCache;
    }

    public Cache<String,Object> getTenMiniutesCache(){
        return this.tenMiniutesCache;
    }

    public void setTenMiniutesCache(Cache<String,Object> cache){
        this.tenMiniutesCache =  cache;
    }
}
