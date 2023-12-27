package com.jenish.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jenish.demo.entity.Person;

/**
 * Repository interface for managing {@link Person} entities using Spring Data Jpa.
 */
public interface PersonRepository extends JpaRepository<Person, Long> {

}
