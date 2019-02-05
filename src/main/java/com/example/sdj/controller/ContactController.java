package com.example.sdj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.sdj.entity.Contact;
import com.example.sdj.service.ContactService;
import com.example.sdj.service.PersonService;

@RestController
@RequestMapping(path = "/demo")
public class ContactController {

	@Autowired
	PersonService personService;

	@Autowired
	ContactService contactService;

	// create contact with Person ID
	@RequestMapping(value = "/person/{personId}/contact", method = RequestMethod.POST)
	public HttpStatus createContact(@PathVariable(value = "personId") Long personId,@RequestBody Contact contact ) {
		return contactService.addContact(contact, personId) ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
	}
	
	
	
}
