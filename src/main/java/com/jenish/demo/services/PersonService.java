package com.jenish.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jenish.demo.entity.Person;
import com.jenish.demo.repository.PersonRepository;

/**
 * Service class for managing {@link Person} entities.
 */
@Service
public class PersonService {
    
    @Autowired
    private PersonRepository userRepository;

    /**
     * Retrieves a list of all persons.
     * @return A list of all oersins.
     */
    public List<Person> getAllPersons(){
        return userRepository.findAll();
    }

    /**
     * Retrieve a person by their unique identifier
     * @param id The unique identifier of the person
     * @return A person with specified identifier.
     */
    public Optional<Person> getPersonById(Long id){
        return userRepository.findById(id);
    }

    /**
     * Save a new person or updates an existing one
     * @param person The person to save or update
     * @return The saved or updated person
     */
    public Person savePerson(Person person){
        return userRepository.save(person);
    }

    /**
     * Deletes a person with the specified identifier
     * @param id The unique identifier for the person to delete
     */
    public void deletePerson(Long id){
        userRepository.deleteById(id);
    }

}
