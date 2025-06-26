package com.example.FinalProject.tool;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.concurrent.TimeUnit;

@Component
public class RedisCacheUtil {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public void setCacheObject(String key, Object value, long expireTime, TimeUnit timeUnit) {
        // 将对象序列化为 JSON 字符串存储到 Redis
        String jsonValue = JSON.toJSONString(value);
        stringRedisTemplate.opsForValue().set(key, jsonValue, expireTime, timeUnit);
    }

    public <T> T getCacheObject(String key, Class<T> clazz) {
        // 从 Redis 获取 JSON 字符串并反序列化为对象
        String jsonValue = stringRedisTemplate.opsForValue().get(key);
        if (jsonValue != null) {
            return JSON.parseObject(jsonValue, clazz);
        }
        return null;
    }

    public void deleteCache(String key) {
        stringRedisTemplate.delete(key);
    }

    public Set<String> getkey(String pattem){
        return stringRedisTemplate.keys(pattem);
    }
    


}