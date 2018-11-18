package com.softedge.demo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

@Entity
public class Person {

	@Id
	private String personName;
	private long personContact;
	private String personemail;
	
	
	@ElementCollection
	@JoinTable(name="addresses", joinColumns=@JoinColumn(name="person_name"))
	private Set<Address> addresses = new HashSet<>();
	public Person() {
		super();
	}
	public Person(String personName, long personContact, String personemail, Set<Address> addresses) {
		super();
		this.personName = personName;
		this.personContact = personContact;
		this.personemail = personemail;
		this.addresses = addresses;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public long getPersonContact() {
		return personContact;
	}
	public void setPersonContact(long personContact) {
		this.personContact = personContact;
	}
	public String getPersonemail() {
		return personemail;
	}
	public void setPersonemail(String personemail) {
		this.personemail = personemail;
	}
	public Set<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}
	@Override
	public String toString() {
		return "Person [personName=" + personName + ", personContact=" + personContact + ", personemail=" + personemail
				+ ", addresses=" + addresses + "]";
	}
	
}
