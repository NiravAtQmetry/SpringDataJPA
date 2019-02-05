package com.example.sdj.repo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.sdj.entity.Contact;
import com.example.sdj.entity.Person;


@Repository
@Transactional
public class PersonRepositoryImpl implements IEPersonRepository{
	
	@PersistenceContext
	private EntityManager em;


	
	//Native Query 
	
	@Override
	public Person findPersonByNativeQuery(Long id) {
		String sql = "SELECT * from people p where id=?";	
		Query query = em.createNativeQuery(sql, Person.class);
		query.setParameter(1, id);
		Person person = (Person) query.getSingleResult();
		
		return person;
	}


	// create with entity manager
	@Override
	public boolean createPerson(Person person) {

		Contact contact = new Contact();
		contact.setAddress("rrr");
		contact.setPerson(person);
		contact.setPhoneNo(2515L);
		
		person.setContact(contact);
		em.persist(person);
		return true;

	}
	

}
