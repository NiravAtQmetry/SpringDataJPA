package com.example.sdj.repo;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.sdj.entity.Contact;
import com.example.sdj.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long>,IEPersonRepository {
	List<Person> findByFirstName(String firstName);

	
	//Join Contact with person
	
	@Query("select c from Contact c inner join c.person p")
	Contact findContactByPersonId(@Param("id") Long id);
	
	
	
}
