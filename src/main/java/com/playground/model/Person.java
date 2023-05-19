package com.playground.model;

import java.util.Set;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Person {

	@Id
	private Long persionId;
	private String nickname;
	private String email;
	
	@OneToMany
	@JoinColumn(name="personId", nullable=true)
    private Set<Subject> subjects;

	public Person() {
		// TODO Auto-generated constructor stub
	}
	
	public Person(Long persionId, String nickname, String email) {
		super();
		this.persionId = persionId;
		this.nickname = nickname;
		this.email = email;
	}


	public Long getPersionId() {
		return persionId;
	}

	public void setPersionId(Long persionId) {
		this.persionId = persionId;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(Set<Subject> subjects) {
		this.subjects = subjects;
	}

	@Override
	public String toString() {
		return "Person [persionId=" + persionId + ", nickname=" + nickname + ", email=" + email + "]";
	}
	

}
