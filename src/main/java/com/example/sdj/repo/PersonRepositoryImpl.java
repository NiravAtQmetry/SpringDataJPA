package com.example.sdj.repo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.sdj.entity.Contact;
import com.example.sdj.entity.Person;
import com.example.sdj.entity.PersonContact;


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
		List<Contact> contacts=new ArrayList<>();
		Contact contact = new Contact();
		contact.setAddress("demo address");
		contact.setPhoneNo(8512555L);
		person.setContact(contacts);
		em.persist(person);
		return true;
	}
	
	@Override
	public List<PersonContact> getCustomResult(){
		String sql = "SELECT NEW com.example.sdj.entity.PersonContact(p,c) from Person p inner join Contact c on c.person=p";
		Query query = em.createQuery(sql,PersonContact.class);
		return (List<PersonContact>)query.getResultList();
	}
}
