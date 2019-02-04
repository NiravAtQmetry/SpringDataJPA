package com.example.sdj.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.sdj.entity.Person;
import com.example.sdj.service.PersonService;


@RestController
@RequestMapping(path = "/demo")
public class PersonController {

	@Autowired
	PersonService personService;

	@RequestMapping(value = "/person/{id}", method = RequestMethod.GET)
	public @ResponseBody Person getAllUsers(@PathVariable Long id) {
		return personService.getById(id);
	}

	@RequestMapping(value = "/personByName/{name}", method = RequestMethod.GET)
	public List<Person> getPersoneByName(@PathVariable String name) {
		return personService.findByName(name);
	}

	@RequestMapping(value = "/personByFirstAndLastName", method = RequestMethod.GET)
	public List<Person> getPersoneByName(@RequestParam String firstName,@RequestParam String lastName) {
		return personService.findByFirstNameAndLastName(firstName, lastName);
	}
	
	@RequestMapping(value = "/personByAgeGreaterThan/{age}", method = RequestMethod.GET)
	public List<Person> getPersoneByName(@PathVariable Integer age) {
		return personService.findByAgeGreaterThan(age);
	}
	
	@RequestMapping(value = "/person", method = RequestMethod.GET)
	public List<Person> getAll() {
		return personService.getAllPersons();
	}

	@RequestMapping(value = "/person/{id}", method = RequestMethod.DELETE)
	public HttpStatus deletePersnone(@PathVariable Long id) {
		personService.deletePerson(id);
		return HttpStatus.NO_CONTENT;
	}

	@RequestMapping(value = "/person", method = RequestMethod.POST)
	public HttpStatus insertPersone(@RequestBody Person person) {
		return personService.addPerson(person) ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
	}

	@RequestMapping(value = "/person", method = RequestMethod.PUT)
	public HttpStatus updatePerson(@RequestBody Person person) {
		return personService.updatePerson(person) ? HttpStatus.ACCEPTED : HttpStatus.BAD_REQUEST;
	}
}