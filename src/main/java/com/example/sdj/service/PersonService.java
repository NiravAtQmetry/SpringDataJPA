package com.example.sdj.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.sdj.entity.Person;
import com.example.sdj.repo.PersonRepository;

@Service
public class PersonService {

	@Autowired
	PersonRepository personRepository;

	//create
	@Transactional
	public boolean addPerson(Person person) {
		return personRepository.save(person) != null;
	}

	// read
	@Transactional
	public Person getById(Long id) {
		return personRepository.findById(id).get();
	}

	@Transactional
	public List<Person> getAllPersons() {
		return (List<Person>) personRepository.findAll();
	}

	@Transactional
	public List<Person> findByName(String name) {
		return personRepository.findByFirstName(name);
	}
	
	@Transactional
	public List<Person> findByFirstNameAndLastName(String firstName,String lastName) {
		return personRepository.findByFirstNameAndLastName(firstName,lastName);
	}

	@Transactional
	public List<Person> findByAgeGreaterThan(Integer age) {
		return personRepository.findByAgeGreaterThan(age);
	}

	//update
	@Transactional
	public boolean updatePerson(Person person) {
		return personRepository.save(person) != null;
	}


	//delete
	@Transactional
	public void deletePerson(Long personId) {
		personRepository.deleteById(personId);
	}


	//isExist
	@Transactional
	public boolean isPersonExist(Long personId) {
		return personRepository.existsById(personId);
	}
	
	//count
	@Transactional
	public long getTotalcount() {
		return personRepository.count();
	}
	
	public List<Person> findByPagingAndSortingRequest(int pageNo,int pageSize){
		return personRepository.findAll(new PageRequest(pageNo, pageSize,Direction.ASC,"firstName","age")).getContent();
	}


}
