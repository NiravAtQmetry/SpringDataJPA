package com.example.sdj.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sdj.entity.Contact;
import com.example.sdj.entity.Person;
import com.example.sdj.repo.PersonRepository;

@Service
@Transactional
public class PersonService {
	
	@Autowired
	PersonRepository personRepository;

	
	public List<Person> getAllPersons() {
		return (List<Person>) personRepository.findAll();
	}

	
	public List<Person> findByName(String name) {
		return personRepository.findByFirstName(name);
	}

	
	public Person getById(Long id) {
		return personRepository.findById(id).get();
	}

	
	public void deletePerson(Long personId) {
		personRepository.deleteById(personId);
	}

	
	public boolean addPerson(Person person) {
		return personRepository.save(person) != null;
	}

	public boolean createPerson(Person person) {
		return personRepository.createPerson(person);
	}
	
	public boolean updatePerson(Person person) {
		return personRepository.save(person) != null;
	}
	
	public Contact findContactByPersonId(Long id) {
		return personRepository.findContactByPersonId(id);
	}
	public Person findPersonByNativeQuery(Long id) {
		
		 return personRepository.findPersonByNativeQuery(id); 
	}
}
