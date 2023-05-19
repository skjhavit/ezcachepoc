package com.playground.Event;

import com.playground.service.CacheEvictionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CacheEvictionEventListener {
    @Autowired
    CacheEvictionService cacheEvictionService;
    @Async
    @EventListener
    void handleCacheEviction(CacheEvictionEvent event) {
        cacheEvictionService.handleCacheEviction(event);
    }
}
