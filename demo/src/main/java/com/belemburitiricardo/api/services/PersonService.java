package com.belemburitiricardo.api.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.belemburitiricardo.api.dtos.PersonDTO;
import com.belemburitiricardo.api.entities.Person;
import com.belemburitiricardo.api.repositories.PersonRepository;
import com.belemburitiricardo.api.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepository personRepository;
	
	@Transactional(readOnly = true)
	public Page<PersonDTO> findAllPaged(PageRequest pageRequest) {
		Page<Person> list = personRepository.findAll(pageRequest);

		return list.map(x -> new PersonDTO(x));
	}

	@Transactional(readOnly = true)
	public PersonDTO findById(Long id) {
		Optional<Person> obj = personRepository.findById(id);
		Person entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not Found"));

		return new PersonDTO(entity);
	}

	@Transactional
	public PersonDTO insert(PersonDTO dto) {
		Person entity = new Person();
		entity.setName(dto.getName());

		entity = personRepository.save(entity);

		return new PersonDTO(entity);
	}

	@Transactional
	public PersonDTO update(Long id, PersonDTO dto) {
		try {
			Person entity = personRepository.getReferenceById(id);
			entity.setName(dto.getName());
			entity = personRepository.save(entity);

			return new PersonDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("id not Found " + id);
		}
	}

}
