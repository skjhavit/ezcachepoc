package com.playground.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.playground.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

	Person save(Person person);

	List<Person> findAll();

	void deleteAll();

}