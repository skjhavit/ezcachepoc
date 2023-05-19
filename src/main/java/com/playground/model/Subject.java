package com.playground.model;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Subject {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long subjectId;
	private String subjectName;
	private String description;
	
	@ManyToOne
	@JoinColumn(name="personId", nullable=true)
	@JsonIgnore
	private Person person;
	
	public Subject() {

	}

	public Subject(String subjectName, String description, Person person) {
		super();
		this.subjectName = subjectName;
		this.description = description;
		this.person = person;
	}

	
	public Long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "Subject [subjectId=" + subjectId + ", subjectName=" + subjectName + ", description=" + description
				+ ", person=" + person + "]";
	}



}
