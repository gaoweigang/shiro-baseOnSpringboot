package com.gwg.shiro.web.config;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

/**
 * redis实现共享session
 */
@Slf4j
@Component
public class RedisSessionDAO extends EnterpriseCacheSessionDAO {
	// session 在redis过期时间是30分钟30*60
	private static int expireTime = 1800;

	private static String prefix = "telsale-seat-shiro-session:";

	@Setter
	@Getter
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	// 创建session，保存到数据库
	@Override
	protected Serializable doCreate(Session session) {
		Serializable sessionId = super.doCreate(session);
		log.debug("创建session:{}", session.getId());
		redisTemplate.opsForValue().set(prefix + sessionId.toString(), session);
		return sessionId;
	}

	// 获取session
	@Override
	protected Session doReadSession(Serializable sessionId) {
		log.debug("获取session:{}", sessionId);
		// 先从缓存中获取session，如果没有再去数据库中获取
		Session session = super.doReadSession(sessionId);
		if (session == null) {
			session = (Session) redisTemplate.opsForValue().get(prefix + sessionId.toString());
		}
		return session;
	}

	// 更新session的最后一次访问时间
	@Override
	protected void doUpdate(Session session) {
		super.doUpdate(session);
		log.debug("获取session:{}", session.getId());
		String key = prefix + session.getId().toString();
		if (!redisTemplate.hasKey(key)) {
			redisTemplate.opsForValue().set(key, session);
		}
		redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
	}

	// 删除session
	@Override
	protected void doDelete(Session session) {
		log.debug("删除session:{}", session.getId());
		super.doDelete(session);
		redisTemplate.delete(prefix + session.getId().toString());
	}
}