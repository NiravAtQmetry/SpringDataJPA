package com.example.sdj.repo;

import java.util.List;

import com.example.sdj.entity.Contact;
import com.example.sdj.entity.Person;

public interface IEPersonRepository {
	Person findPersonByNativeQuery(Long id);
	
	boolean createPerson(Person person);
}
