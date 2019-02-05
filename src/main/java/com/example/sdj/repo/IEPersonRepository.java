package com.example.sdj.repo;

import java.util.List;

import com.example.sdj.entity.Person;
import com.example.sdj.entity.PersonContact;

public interface IEPersonRepository {
	Person findPersonByNativeQuery(Long id);
	
	boolean createPerson(Person person);

	List<PersonContact> getCustomResult();
}
