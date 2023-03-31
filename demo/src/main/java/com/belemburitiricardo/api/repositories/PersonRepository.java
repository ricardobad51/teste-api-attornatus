package com.belemburitiricardo.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.belemburitiricardo.api.entities.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{

}
