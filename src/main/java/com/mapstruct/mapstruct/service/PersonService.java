package com.mapstruct.mapstruct.service;

import com.mapstruct.mapstruct.mapper.PersonDTOToPersonMapper;
import com.mapstruct.mapstruct.mapper.PersonToPersonDTOMapper;
import com.mapstruct.mapstruct.mapper.PersonToPersonDTOMapperImpl;
import com.mapstruct.mapstruct.model.Person;
import com.mapstruct.mapstruct.model.PersonDTO;
import com.mapstruct.mapstruct.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    PersonRepository personRepository;
    @Autowired
    PersonToPersonDTOMapper personToPersonDTOMapper;

    public List<PersonDTO> getAllPerson() {
        return personToPersonDTOMapper.map(personRepository.findAll());
    }

    public PersonDTO getPersonById(int id) {
        return personToPersonDTOMapper.personToPersonDTO(personRepository.findById(id).get());
    }

    public void delete(int id) {
        Optional<Person> personToDelete = personRepository.findById(id);

        if( personToDelete != null) {
            personRepository.delete(personToDelete.get());
        }

    }

    public long saveOrUpdate(Person person) {
        Person save = personRepository.save(person);
        return save.getId();
    }

    public Iterable<PersonDTO> saveOrUpdateList(List<Person> persons) {
        return personToPersonDTOMapper.map(personRepository.saveAll(persons));
    }
}
