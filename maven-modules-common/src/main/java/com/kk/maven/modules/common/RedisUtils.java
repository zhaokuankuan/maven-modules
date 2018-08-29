package com.kk.maven.modules.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/** 调用redis的一个工具类
 * @author :Mr.kk
 * @date: 2018/8/28-15:52
 */

@Component
public class RedisUtils {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RedisTemplate redisTemplate;


    /**
     * 存入一个字符串
     * @param key
     * @param value
     * @return
     */
    public boolean insertStrng(final String key, Object value) {
        boolean result = false;
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            result = true;
        } catch (Exception e) {
            logger.error("set error: key {}, value {}",key,value,e);
        }
        return result;
    }

    /**
     * 存入一个带失效时间的字符串
     * @param key
     * @param value
     * @param expireTime
     * @return
     */
    public boolean setStringTime(final String key, Object value, Long expireTime) {
        boolean result = false;
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
            result = true;
        } catch (Exception e) {
            logger.error("set error: key {}, value {},expireTime {}",key,value,expireTime,e);
        }
        return result;
    }

    /**  查询一个key是否存在
     * @param key
     * @return
     */
    public boolean exists(final String key) {
        return redisTemplate.hasKey(key);
    }

    /** 根据key获取一个string字符串
     * @param key
     * @return
     */
    public Object getString(final String key) {
        Object result = null;
        ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
        result = operations.get(key);
        return result;
    }

    /** 删除一个string字符串
     * @param key
     */
    public void removeString(final String key) {
        if (exists(key)) {
            redisTemplate.delete(key);
        }
    }

    /** 根据keys批量删除
     * batch delete
     * @param keys
     */
    public void remove(final String... keys) {
        for (String key : keys) {
            remove(key);
        }
    }

    /**
     *  新增一个hash
     * @param key
     * @param hashKey
     * @param value
     */
    public void insertHash(String key, Object hashKey, Object value){
        HashOperations<String, Object, Object> hash = redisTemplate.opsForHash();
        hash.put(key,hashKey,value);
    }

    /**
     * 查询一个hash
     * @param key
     * @param hashKey
     * @return
     */
    public Object getHash(String key, Object hashKey){
        HashOperations<String, Object, Object>  hash = redisTemplate.opsForHash();
        return hash.get(key,hashKey);
    }

    /**
     *  设置一个list
     * @param k
     * @param v
     */
    public void insertList(String k,Object v){
        ListOperations<String, Object> list = redisTemplate.opsForList();
        list.rightPush(k,v);
    }

    /**
     *  查询list，并且截取l到l1
     * @param k
     * @param l
     * @param l1
     * @return
     */
    public List<Object> getListByIndex(String k, long l, long l1){
        ListOperations<String, Object> list = redisTemplate.opsForList();
        return list.range(k,l,l1);
    }

    /**
     * 设置一个set
     * @param key
     * @param value
     */
    public void insertSet(String key,Object value){
        SetOperations<String, Object> set = redisTemplate.opsForSet();
        set.add(key,value);
    }

    /**
     * 获取set
     * @param key
     * @return
     */
    public Set<Object> getSetAll(String key){
        SetOperations<String, Object> set = redisTemplate.opsForSet();
        return set.members(key);
    }

    /**
     * 新增一个zset
     * @param key
     * @param value
     * @param scoure
     */
    public void insertZset(String key,Object value,double scoure){
        ZSetOperations<String, Object> zset = redisTemplate.opsForZSet();
        zset.add(key,value,scoure);
    }

    /**
     * 获取zset的数据
     * @param key
     * @param scoure
     * @param scoure1
     * @return
     */
    public Set<Object> getZSetByIndex(String key,double scoure,double scoure1){
        ZSetOperations<String, Object> zset = redisTemplate.opsForZSet();
        return zset.rangeByScore(key, scoure, scoure1);
    }
}
