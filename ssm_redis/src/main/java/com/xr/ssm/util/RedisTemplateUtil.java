package com.xr.ssm.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Service
public class RedisTemplateUtil {

    /**
     * 操作String类型set
     */
    public void setString(String key, Object value){
        System.out.println("bangDingzhiLe");
        ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
        valueOperations.set(key, value);
//设置有效时间 .expire()， TimeUnit.SECONDS为时间单位
        redisTemplate.expire(key, 5000, TimeUnit.SECONDS);

    }

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    /*
        操作String
     */
    public Object getString(String key){
        return redisTemplate.opsForValue().get(key);
    }

    /*
        操作List  set/get
     */
    public void setList(String key, List<?> value){
        ListOperations<String, Object> listOperations = redisTemplate.opsForList();
        listOperations.leftPush(key,value);
    }

    public Object getList(String key){
        return redisTemplate.opsForList().leftPop(key);
    }


    /*
        操作set  set/get
     */
    public void setSet(String key,Set<?> value){
        SetOperations<String, Object> setOperations = redisTemplate.opsForSet();
        setOperations.add(key,value);
    }

    public Object getSet(String key){
        return redisTemplate.opsForSet().members(key);
    }

    /*
        操作hash get/set
     */
    public void setHash(String key, Map<String,?> value){
        HashOperations<String, Object, Object> hashOperations = redisTemplate.opsForHash();
        hashOperations.putAll(key,value);
    }

    public Object getHash(String key){
        return redisTemplate.opsForHash().entries(key);
    }

    /*
        根据key键删除数据
     */
    public void delete(String key){
        redisTemplate.delete(key);
    }
}
