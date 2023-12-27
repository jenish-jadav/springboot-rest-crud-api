package com.jenish.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jenish.demo.entity.Person;
import com.jenish.demo.services.PersonService;

/**
 * REST controller for managing {@link Person} entities.
 */
@RestController
@RequestMapping("/user")
public class PersonController {
    
    @Autowired
    private final PersonService userService;
    
    public PersonController(PersonService userService){
        this.userService = userService;
    }

    /**
     * Loads dummy data of person.
     */
    @GetMapping("/load")
    public void loadDummyData(){
        Person user= new Person();
        user.setFirstName("Jenish");
        user.setLastName("Jadav");
        user.setEmail("jenish@google.com");
        userService.savePerson(user);
    }

    /**
     * Retrieve a list of al persons
     * @return A list of all persons.
     */
    @GetMapping("/all")
    public List<Person> getAllUsers(){
        return userService.getAllPersons();
    }

    /**
     * Retrieve a person by their unique identifier
     * @param id The unique identifier of the person
     * @return The person with the specified identifier, or null if not found
     */
    @GetMapping("/{id}")
    public ResponseEntity<Person> getUserById(@PathVariable("id") Long id){
        Optional<Person> user = userService.getPersonById(id);
        return user.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }

    /**
     * Creates a new person
     * @param person Ther person to create
     * @return The created person.
     */
    @PostMapping("/add")
    public Person createPerson(@RequestBody Person person){
        return userService.savePerson(person);
    }

    /**
     * Updates the existing person
     * @param id The unique identifier of the person to update.
     * @param person The updated information of user.
     * @return The updated person.
     */
    @PostMapping("/update/{id}")
    public Person updatePerson(@PathVariable("id") Long id,@RequestBody Person person){
        person.setId(id); // Set the ID to ensure we updadte the correct person
        return userService.savePerson(person);
    }

    /**
     * Deletes a person with specified identifier
     * @param id The unique identifier of the person to delete
     */
    @PostMapping("/delete/{id}")
    public void deletePerson(@PathVariable("id") Long id){
        userService.deletePerson(id);
    }
}
