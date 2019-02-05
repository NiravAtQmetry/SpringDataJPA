package com.example.sdj.service;

import java.util.List;
import java.util.NoSuchElementException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.sdj.entity.Contact;
import com.example.sdj.entity.Person;
import com.example.sdj.entity.PersonContact;
import com.example.sdj.exception.EntityNotFoundException;
import com.example.sdj.exception.RequiredFieldMissingException;
import com.example.sdj.repo.ContactRepository;
import com.example.sdj.repo.PersonRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
public class PersonService {

	@Autowired
	PersonRepository personRepository;

	@Autowired
	ContactRepository contactRepository;
	//create
	@Transactional
	public boolean addPerson(Person person) {
		return personRepository.save(person) != null;
	}

	// read
	@Transactional
	public Person getById(Long id) throws EntityNotFoundException {
		Person person = null;
		try {
			person = personRepository.findById(id).get();
		} catch (NoSuchElementException e) {
			throw new EntityNotFoundException("Person",id);
		}
		return person;
	}

	@Transactional
	public List<Person> getAllPersons() {
		return (List<Person>) personRepository.findAll();
	}

	
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

	public boolean createPerson(Person person) throws RequiredFieldMissingException {
		if(person.getFirstName()==null) {
			throw new RequiredFieldMissingException("FirstName");
		}
		if(person.getLastName()==null) {
			throw new RequiredFieldMissingException("LastName");
		}
		return personRepository.createPerson(person);
	}
	
	public List<Contact> findContactByPersonId(Long id) {
		return personRepository.findContactByPersonId(id);
	}
	public Person findPersonByNativeQuery(Long id) {
		
		 return personRepository.findPersonByNativeQuery(id); 
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

	public List<Person> findByNameStartsWith(String startsWith) {
		// TODO Auto-generated method stub
		return personRepository.findByFirstnameStartingWith(startsWith);
	}

	public List<PersonContact> getPersonContacts() {
		// TODO Auto-generated method stub
		return personRepository.getCustomResult();
	}


}
