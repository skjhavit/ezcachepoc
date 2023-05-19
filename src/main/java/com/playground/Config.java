/*
 * package com.playground;
 * 
 * import java.lang.management.ManagementFactory; import java.util.List;
 * 
 * import javax.annotation.PostConstruct; import javax.management.MBeanServer;
 * 
 * import org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.context.annotation.Scope;
 * 
 * import net.sf.ehcache.CacheManager; import
 * net.sf.ehcache.management.ManagementService;
 * 
 * @Configuration public class Config {
 * 
 * public net.sf.ehcache.CacheManager ehCacheManager() { List<CacheManager> list
 * = CacheManager.ALL_CACHE_MANAGERS; for (CacheManager cManager : list) {
 * System.err.println(cManager.getName());
 * if(cManager.getName().startsWith("Hibernate")){ return cManager; } } return
 * null; }
 * 
 * @Bean
 * 
 * @Scope("singleton") public CacheManager cacheManager() { return
 * ehCacheManager(); }
 * 
 * public MBeanServer mbeanServer() { MBeanServer mBeanServer =
 * ManagementFactory.getPlatformMBeanServer(); return mBeanServer; }
 * 
 * @PostConstruct public void init() {
 * ManagementService.registerMBeans(ehCacheManager(), mbeanServer(), true, true,
 * true, true); }
 * 
 * 
 * }
 */