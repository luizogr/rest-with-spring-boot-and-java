package com.luizogr.service;

import com.luizogr.exception.ResourceNotFoundException;
import com.luizogr.model.Person;
import com.luizogr.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {

    private final AtomicLong counter = new AtomicLong();

    private Logger logger = Logger.getLogger(PersonService.class.getName());

    @Autowired
    private PersonRepository personRepository;

    public List<Person> findAll() {
        logger.info("Finding All People!");
        return personRepository.findAll();
    }

    public Person findById(Long id) {
        logger.info("Finding one Person!");

        return personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
    }

    public Person create(Person person){
        logger.info("Creating one Person!");
        personRepository.save(person);
        return person;
    }

    public void delete(Long id) {
        logger.info("deleting one Person!");
        Person p = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        personRepository.delete(p);
    }

    public Person update(Person person){
        logger.info("updating one Person!");
        Person p = personRepository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        p.setFirstName(person.getFirstName());
        p.setLastName(person.getLastName());
        p.setAddress(person.getAddress());
        p.setGender(person.getGender());
        return personRepository.save(p);
    }
}
