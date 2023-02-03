package com.tahiana.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.tahiana.model.Person;

@Service
public class PersonServices {

	private final AtomicLong counter = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonServices.class.getName());

	public List<Person> findAll() {

		logger.info("Finding everybody");

		List<Person> persons = new ArrayList<>();
		for (int i = 0; i < 8; i++) {
			Person person = mockPerson(i);
			persons.add(person);
		}
		return persons;		
	}

	public Person findById(String id) {
		logger.info("Finding a person");

		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Tahiana");
		person.setLastName("Passos");
		person.setAddress("Rua Um");
		person.setGender("F");

		return person;
	}

	public Person createPerson(Person person) {
		
		logger.info("Creating a person");
		return person;
	}
	
	public Person updatePerson(Person person) {
		
		logger.info("Updating a person");
		return person;
	}
	
	public void deletePerson(String id) {
		
		logger.info("Updating a person");

	}
	
	private Person mockPerson(int i) {

		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Name:" + i);
		person.setLastName("LastName: " + i);
		person.setAddress("Rua: " + i);
		person.setGender("F");

		return person;
	}

	
}
