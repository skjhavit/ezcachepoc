package com.playground.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.playground.model.Person;
import com.playground.model.Subject;
import com.playground.service.PersonService;
import com.playground.service.SubjectService;

@RestController
@RequestMapping("/subject")
public class SubjectController {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SubjectService subjectService;
	
	@Autowired
	private PersonService personService;
	
	@GetMapping(value = "/save")
	public Subject save(@RequestParam long personId, @RequestParam String subjectName, @RequestParam String description) {
		log.info("save subject");
		long start = new Date().getTime();
		Person person = personService.findOne(personId);
		Subject subject = subjectService.saveSubject(new Subject(subjectName, description, person));
		log.info("saved subject at: " + (new Date().getTime() - start) + " milliseconds");
		return subject;
	}
	
	@GetMapping(value = "/all")
	public List<Subject> getAllSubject() {
		return subjectService.getAll();
	}
	

	
}
