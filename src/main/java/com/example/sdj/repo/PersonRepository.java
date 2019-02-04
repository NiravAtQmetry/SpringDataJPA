package com.example.sdj.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sdj.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
	
	List<Person> findByFirstName(String firstName);
	List<Person> findByFirstNameAndLastName(String firstName,String lastName);
	List<Person> findByAgeGreaterThan(int age);
	List<Person> findByAgeBetween(int ageLower,int ageHigher);
	List<Person> findByFirstNameLike(String name);
	List<Person> findByFirstNameContains(String name);
	List<Person> findByFirstNameIn(List<String> names);
	
}
