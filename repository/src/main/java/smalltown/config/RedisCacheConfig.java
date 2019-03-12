package smalltown.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager.RedisCacheManagerBuilder;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@Configuration
@EnableCaching //启用缓存
@PropertySource("classpath:dbconfig.properties")
public class RedisCacheConfig {
	@Autowired
	Environment env;

	/**
	 * 默认构造器创建的连接工厂会向 localhost 6379 端口连接，且没有密码，可以设置。
	 * @return
	 */
	/*
	 * @SuppressWarnings("deprecation")
	 * 
	 * @Bean public RedisConnectionFactory redisCF(){ JedisConnectionFactory config
	 * = new JedisConnectionFactory();
	 * config.setPort(env.getProperty("redis.port",Integer.class));
	 * config.setHostName(env.getProperty("redis.host")); return config; }
	 * 
	 * @Bean public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory
	 * cf){ return new StringRedisTemplate(cf) ; }
	 * 
	 * @Bean public RedisTemplate<String,Object>
	 * redisTemplate(RedisConnectionFactory cf){ RedisTemplate<String,Object> r =
	 * new RedisTemplate<>() ; r.setConnectionFactory(cf); return r; }
	 * 
	 * @Bean public CacheManager cacheManager(StringRedisTemplate redisTemplate){
	 * RedisCacheManagerBuilder builder =
	 * RedisCacheManagerBuilder.fromConnectionFactory(redisCF()); return
	 * builder.build() ; }
	 */
	@Bean
	public CacheManager cacheManager() {
		return new ConcurrentMapCacheManager() ;
	}
}
