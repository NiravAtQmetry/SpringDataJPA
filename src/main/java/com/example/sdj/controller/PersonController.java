package com.example.sdj.controller;


import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.sdj.entity.Contact;
import com.example.sdj.entity.Person;
import com.example.sdj.entity.PersonContact;
import com.example.sdj.exception.EntityNotFoundException;
import com.example.sdj.exception.RequiredFieldMissingException;
import com.example.sdj.service.PersonService;


@RestController
@RequestMapping(path = "/demo")
public class PersonController {

	@Autowired
	PersonService personService;

	//get person by id
	@RequestMapping(value = "/person/{id}", method = RequestMethod.GET)
	public @ResponseBody Person getAllUsers(@PathVariable Long id) throws EntityNotFoundException  {
		Person person=personService.getById(id);
		return person;
	}

	//get person by Name
	@RequestMapping(value = "/personByName/{name}", method = RequestMethod.GET)
	public List<Person> getPersoneByName(@PathVariable String name) {
		return personService.findByName(name);
	}

	//get person by first And Last Name
	@RequestMapping(value = "/personByFirstAndLastName", method = RequestMethod.GET)
	public List<Person> getPersoneByName(@RequestParam String firstName,@RequestParam String lastName) {
		return personService.findByFirstNameAndLastName(firstName, lastName);
	}
	
	//get person by Age Greater Than
	@RequestMapping(value = "/personByAgeGreaterThan/{age}", method = RequestMethod.GET)
	public List<Person> getPersoneByName(@PathVariable Integer age) {
		return personService.findByAgeGreaterThan(age);
	}
	
	// insert with JPA
	@RequestMapping(value = "/person", method = RequestMethod.POST)
	public HttpStatus insertPersone(@RequestBody Person person) {
		return personService.addPerson(person) ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
	}
	
	//get All Person
	@RequestMapping(value = "/person", method = RequestMethod.GET)
	public List<Person> getAll() {
		return personService.getAllPersons();
	}

	//Delete Person By ID
	@RequestMapping(value = "/person/{id}", method = RequestMethod.DELETE)
	public HttpStatus deletePersnone(@PathVariable Long id) {
		personService.deletePerson(id);
		return HttpStatus.NO_CONTENT;
	}

	
	
	/**
	 * 
	 * Inner Joing
	 */
	
	// Get List of Contacts by person Id
	@RequestMapping(value = "/person/{id}/contact", method = RequestMethod.GET)
	public List<Contact> getContactByPersonId(@PathVariable Long id) {
		return personService.findContactByPersonId(id);
	}
	
	/**
	 * 
	 * Native Query
	 */
	
	//Get Person by Id
	@RequestMapping(value = "/person/native/{id}", method = RequestMethod.GET)
	public Person getContactsWithNativeQuery(@PathVariable Long id) {
		return personService.findPersonByNativeQuery(id);
	}

	
	//insert with entity manager
	@RequestMapping(value = "/person/entity", method = RequestMethod.POST)
	public HttpStatus insertPersonewithEntity(@RequestBody Person person) throws RequiredFieldMissingException {
		return personService.createPerson(person) ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
	}
	
	@RequestMapping(value = "/person", method = RequestMethod.PUT)
	public HttpStatus updatePerson(@RequestBody Person person) {
		return personService.updatePerson(person) ? HttpStatus.ACCEPTED : HttpStatus.BAD_REQUEST;
	}

	@RequestMapping(value = "/personPagingRequest", method = RequestMethod.GET)
	public List<Person> pagingAndSortingRequestForPerson(@RequestParam Integer pageNo,@RequestParam Integer pageSize) {
		return personService.findByPagingAndSortingRequest(pageNo,pageSize);
	}
	
	@RequestMapping(value = "/personByNameStartsWith/{name}", method = RequestMethod.GET)
	public List<Person> getPersonByNameStartsWith(@PathVariable String name) {
		return personService.findByNameStartsWith(name);
	}
	
	@RequestMapping(value = "/personContacts", method = RequestMethod.GET)
	public List<PersonContact>  getPersonContacts() {
		return personService.getPersonContacts();
	}
}