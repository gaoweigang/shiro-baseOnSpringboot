package com.gwg.shiro.web.config.shiro;

import lombok.Getter;
import lombok.Setter;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.springframework.data.redis.core.RedisTemplate;

@SuppressWarnings("rawtypes")
public class CustomShiroCacheManager implements CacheManager {

	@Setter
	@Getter
	private RedisTemplate redisTemplate; // RedisTemplate，如果不明白怎么使用的，请参考http://blog.csdn.net/liuchuanhong1/article/details/54601037

	@SuppressWarnings("unchecked")
	@Override
	public <K, V> Cache<K, V> getCache(String name) throws CacheException {
		return new ShiroCache<K, V>(redisTemplate);// 为了简化代码的编写，此处直接new一个Cache
	}

}