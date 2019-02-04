package service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.Person;
import repo.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	PersonRepository personRepository;

	@Transactional
	public List<Person> getAllPersons() {
		return (List<Person>) personRepository.findAll();
	}

	@Transactional
	public List<Person> findByName(String name) {
		return personRepository.findByFirstName(name);
	}

	@Transactional
	public Person getById(Long id) {
		return personRepository.findById(id).get();
	}

	@Transactional
	public void deletePerson(Long personId) {
		personRepository.deleteById(personId);
	}

	@Transactional
	public boolean addPerson(Person person) {
		return personRepository.save(person) != null;
	}

	@Transactional
	public boolean updatePerson(Person person) {
		return personRepository.save(person) != null;
	}
}
