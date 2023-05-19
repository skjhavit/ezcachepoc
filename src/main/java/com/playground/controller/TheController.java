package com.playground.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.lang.Object;

import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.playground.model.Person;
import com.playground.service.PersonService;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;

@RestController
public class TheController {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private PersonService personService;

	@RequestMapping("/")
	// @Cacheable("persons")
	public List<Person> get() {
		log.info("Getting all persons");
		long start = new Date().getTime();
		List<Person> persons = personService.getAll();
		log.info("Finishing getting all persons at: " + (new Date().getTime() - start) + " milliseconds");
		return persons;
	}

	@GetMapping(value = "/save")
	public Person save(@RequestParam long id, @RequestParam String name) {
		log.info("save persons");
		long start = new Date().getTime();
		Person person = personService.savePerson(new Person(id, name, name + "@gmail.com"));
		log.info("save and detch person at: " + (new Date().getTime() - start) + " milliseconds");
		return person;
	}

	@GetMapping(value = "/findOne")
	public Person findOne(@RequestParam long id) {
		log.info("findOne persons");
		long start = new Date().getTime();
		Person person = personService.findOne(id);
		log.info("findOne person at: " + (new Date().getTime() - start) + " milliseconds");
		return person;
	}

	@GetMapping("/cache-detail")
	public void printCacheDetails() {
		List<CacheManager> list = CacheManager.ALL_CACHE_MANAGERS;
		for (CacheManager cManager : list) {
			System.err.println("Class Name:::::"+cManager.getClass().getName());
			List<String> cacheNames =
					Arrays.stream(cManager.getCacheNames()).filter(s -> s.equalsIgnoreCase("com.playground.model.Subject") || s.equalsIgnoreCase("com.playground.model.Person")).collect(Collectors.toList());
			for(String cacheName:cacheNames) {
				Ehcache ehCache = cManager.getEhcache(cacheName);
				Cache cache = cManager.getCache(cacheName);
				}
			}

		}
		}


