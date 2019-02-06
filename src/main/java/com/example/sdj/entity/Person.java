package com.example.sdj.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.OneToMany;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name = "people")
// Lombok annotations..
@EqualsAndHashCode @ToString

/**
 * Stored procedure execute in DB
 * 
  	CREATE DEFINER=`root`@`localhost` PROCEDURE `plus1inout`(IN arg int, OUT res int)
	BEGIN 
		set res = arg + 1;
	END
 *
 */

@NamedStoredProcedureQuery(name = "Person.plus1", procedureName = "plus1inout",parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "arg", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "res", type =Integer.class) }
)
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "age")
	private Integer age;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<Contact> contacts;	
	

	public List<Contact> getContact() {
		return contacts;
	}
	public void setContact(List<Contact> contacts) {
		this.contacts = contacts;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Override
	public String toString() {
		return "Person{" + "id=" + id + ", age=" + age + ", firstName='" + firstName + '\'' + ", lastName='" + lastName
				+ '\'' + '}';
	}
}
