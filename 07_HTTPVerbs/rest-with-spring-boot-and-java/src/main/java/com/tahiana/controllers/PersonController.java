package com.tahiana.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tahiana.model.Person;
import com.tahiana.services.PersonServices;

import jakarta.websocket.server.PathParam;


@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonServices personServices;

	@RequestMapping(value = "/{id}", 
			method=RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Person findById(@PathVariable(value = "id") String id) {
		return personServices.findById(id);
	}

	@RequestMapping( 
			method=RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Person> findAll() {
		return personServices.findAll();
	}

	@RequestMapping( 
			method=RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public Person createPerson(@RequestBody Person person) {
		return personServices.createPerson(person);
	}

	@RequestMapping( 
			method=RequestMethod.PUT,
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public Person updatePerson(@RequestBody Person person) {
		return personServices.updatePerson(person);
	}

	@RequestMapping(value = "/{id}", method=RequestMethod.DELETE)
	public void deletePerson(@PathVariable String id) {
		personServices.deletePerson(id);
	}
}
