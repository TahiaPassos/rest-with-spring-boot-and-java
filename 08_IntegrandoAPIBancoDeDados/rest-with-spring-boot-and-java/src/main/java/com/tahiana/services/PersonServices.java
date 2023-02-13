package com.tahiana.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tahiana.exceptions.ResourceNotFoundException;
import com.tahiana.model.Person;
import com.tahiana.repositories.PersonRepository;

@Service
public class PersonServices {

	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	@Autowired
	PersonRepository personRepository;

	public List<Person> findAll() {

		logger.info("Finding everybody");

		return personRepository.findAll();		
	}

	public Person findById(Long id) {
		logger.info("Finding a person");

		return personRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
	}

	public Person createPerson(Person person) {
		
		logger.info("Creating a person");
		return personRepository.save(person);
	}
	
	public Person updatePerson(Person person) {

		logger.info("Updating a person");
		
		var personEntity =  personRepository.findById(person.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		
		personEntity.setFirstName(person.getFirstName());
		personEntity.setLastName(person.getLastName());
		personEntity.setAddress(person.getAddress());
		personEntity.setGender(person.getGender());
		
		/*Não posso simplesmente salvar o objeto pois salvaria um novo registro
		 * É necessário recuperar o objeto já existente e atualizar as suas propriedades para,
		 * então, salvá-lo
		*/
		return personRepository.save(person);
	}
	
	public void deletePerson(Long id) {
		
		logger.info("Deleting a person");
		
		var personEntity =  personRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

		personRepository.delete(personEntity);
	}	
}
