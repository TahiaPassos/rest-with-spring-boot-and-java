package com.tahiana.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tahiana.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{}
