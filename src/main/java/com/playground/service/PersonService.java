package com.playground.service;

import java.util.List;

import com.playground.Event.CacheEvictionEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import com.playground.model.Person;
import com.playground.repo.PersonRepository;

@Service
public class PersonService {

	@Autowired
	PersonRepository personRepository;

	@Autowired
	ApplicationEventPublisher applicationEventPublisher;
	private final String personKey = "com.playground.model.Person";

	//@Cacheable
	public List<Person> getAll() {
		return personRepository.findAll();
	}
	
	public Person findOne(Long id){
		return personRepository.findById(id).get();
	}

	public Person savePerson(Person person) {
		person= personRepository.save(person);
		applicationEventPublisher.publishEvent(CacheEvictionEvent.builder().key(personKey).build());
		return person;
	}
}
