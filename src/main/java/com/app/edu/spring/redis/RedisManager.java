package com.app.edu.spring.redis;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class RedisManager<T> {
	

	@Autowired
	private RedisTemplate redisTemplate;
	@Resource(name = "redisTemplate")
	private ValueOperations<String, T> valueOps;
	@Resource(name = "redisTemplate")
	private ValueOperations<String, List<T>> valueOpsList;

	public RedisManager() {

	}

	public T getValue(String key) {
		try {
			log.info("redis call getValue----------key:"+key);
			return valueOps.get(key);
			
		} catch (Exception e) {
			log.error("error getValue: " ,e);
			return null;
		}

	}

	public List<T> getListValue(String key) {
		try {
			log.info("redis call getListValue--------key:"+key);
			return valueOpsList.get(key);
		} catch (Exception e) {
			log.error("error getListValue : ",e);
			return null;
		}

	}

	@SuppressWarnings("unchecked")
	public void put(String key, T val, long timeout, TimeUnit timeUnit) {
		try {
			valueOps.set(key, val, timeout, timeUnit);
			log.info("redis put put put------------key:"+key);
		} catch (Exception e) {
			log.error("error put : ",e);
		}
	}
	public void putList(String key, List<T> list, long timeout, TimeUnit timeUnit){
		try {
			valueOpsList.set(key, list, timeout, timeUnit);
			log.info("redis putList putList putList----key:"+key);
		} catch (Exception e) {
			log.error("error putList : ",e);
		}
	}
	
	

	@SuppressWarnings("unchecked")
	public void delete(String key) {
		try {
			redisTemplate.delete(key);
			log.info("redis delete ---------------key:"+key);
		} catch (Exception e) {
			log.error("error getListValue : ",e);
		}

	}

}
