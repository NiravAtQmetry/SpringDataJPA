package com.example.sdj.entity;

public class PersonContact {
	private Person p;
	private Contact c;
	public PersonContact(Person p, Contact c) {
		super();
		this.p = p;
		this.c = c;
	}
	public Person getP() {
		return p;
	}
	public void setP(Person p) {
		this.p = p;
	}
	public Contact getC() {
		return c;
	}
	public void setC(Contact c) {
		this.c = c;
	}
}
