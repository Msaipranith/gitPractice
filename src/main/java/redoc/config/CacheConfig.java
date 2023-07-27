package redoc.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.cache.CacheManager;

@Configuration
@EnableCaching
public class CacheConfig {

	@Bean
	public CacheManager cacheManager() {
		return new ConcurrentMapCacheManager(); // You can replace this with a custom cache manager if needed
	}
}
