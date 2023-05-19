package com.playground.service;

import com.playground.Event.CacheEvictionEvent;
import lombok.AllArgsConstructor;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Component
@AllArgsConstructor
public class CacheEvictionService {
    public void handleCacheEviction(CacheEvictionEvent event) {
        List<CacheManager> list = CacheManager.ALL_CACHE_MANAGERS;
        for (CacheManager cManager : list) {
            if(CollectionUtils.isEmpty(event.getKeys())) {
                Ehcache ehCache = cManager.getEhcache(event.getKey());
                ehCache.removeAll();
            } else {
                event.getKeys().forEach(key -> {
                    Ehcache ehCache = cManager.getEhcache(key);
                    ehCache.removeAll();
                });

        }
    }
    }
}
