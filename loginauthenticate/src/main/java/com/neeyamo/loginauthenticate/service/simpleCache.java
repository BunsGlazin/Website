package com.neeyamo.loginauthenticate.service;

import org.springframework.boot.autoconfigure.cache.CacheManagerCustomizer;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;

public class simpleCache implements CacheManagerCustomizer<ConcurrentMapCacheManager> {

	@Override
	public void customize(ConcurrentMapCacheManager cacheManager) {
		cacheManager.setCacheNames(java.util.Arrays.asList("users", "transactions"));
	}

}
