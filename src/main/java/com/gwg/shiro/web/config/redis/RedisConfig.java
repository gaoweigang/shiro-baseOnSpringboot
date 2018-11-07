package com.gwg.shiro.web.config.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.util.HashMap;
import java.util.Map;

/**
 **
 */
@Configuration
@EnableCaching//启用缓存，在这里使用的是redis缓存，启用后才能使用@Cacheable注解
public class RedisConfig {
	/**
	 * 注入 RedisConnectionFactory
	 */
	@Autowired
	RedisConnectionFactory redisConnectionFactory;

	/**
	 * 实例化 RedisTemplate 对象
	 *
	 * @return
	 */
	@Bean
	public RedisTemplate<String, Object> functionDomainRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
		RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String,Object>();
		initDomainRedisTemplate(redisTemplate, redisConnectionFactory);
		return redisTemplate;
	}

	@Bean
	public CacheManager cacheManager(RedisTemplate<String, Object> redisTemplate) {
		RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);

		cacheManager.setDefaultExpiration(21600);
	    // 设置缓存的过期时间
	    Map<String, Long> expires = new HashMap<String, Long>();
	    expires.put("seat-dicContent", 1000L);
	    expires.put("user-role", 300L);
	    expires.put("basic-info", 300L);
		expires.put("personal-center", 300L);
	    cacheManager.setExpires(expires);

		return cacheManager;
	}

	/**
	 * 设置数据存入 redis 的序列化方式
	 * JdkSerializationRedisSerializer与StringRedisSerializer
	 * JdkSerializationRedisSerializer支持对所有实现了Serializable的类进行序列化
	 *
	 * @param redisTemplate
	 * @param factory
	 */
	private void initDomainRedisTemplate(RedisTemplate<String, Object> redisTemplate, RedisConnectionFactory factory) {
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.setHashKeySerializer(new StringRedisSerializer());
		redisTemplate.setHashValueSerializer(new JdkSerializationRedisSerializer());
		redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
		redisTemplate.setConnectionFactory(factory);
	}

}