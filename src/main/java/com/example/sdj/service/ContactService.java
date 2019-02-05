package com.example.sdj.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sdj.entity.Contact;
import com.example.sdj.entity.Person;
import com.example.sdj.repo.ContactRepository;
import com.example.sdj.repo.PersonRepository;

@Service
@Transactional
public class ContactService {

	@Autowired
	PersonRepository personRepository;

	@Autowired
	ContactRepository contactRepository;

	// create Contact
	public boolean addContact(Contact contact, Long personId) {

		Optional<Person> person = personRepository.findById(personId);
		contact.setPerson(person.get());
		contactRepository.save(contact);
		return true;
	}
}
