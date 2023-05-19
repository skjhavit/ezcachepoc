package com.playground.service;

import java.util.Arrays;
import java.util.List;

import com.playground.Event.CacheEvictionEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import com.playground.model.Subject;
import com.playground.repo.SubjectRepository;

@Service
public class SubjectService {
	
	@Autowired
	private SubjectRepository subjectRepository;
	@Autowired
	ApplicationEventPublisher applicationEventPublisher;
	private final String personKey = "com.playground.model.Person";
	private final String subjectKey = "com.playground.model.Subject";

	public List<Subject> getAll() {
		return subjectRepository.findAll();
	}
	
	public Subject findOne(Long id){
		return subjectRepository.findById(id).get();
	}

	public Subject saveSubject(Subject subject) {
		subject = subjectRepository.save(subject);
		applicationEventPublisher.publishEvent(CacheEvictionEvent.builder().keys(Arrays.asList(personKey,
		subjectKey)).build());
		return subject;
	}
	
}
