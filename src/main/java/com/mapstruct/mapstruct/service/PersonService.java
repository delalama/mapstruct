package com.mapstruct.mapstruct.service;

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

    public List<Person> getAllPerson() {
        return (List<Person>) personRepository.findAll();
    }

    public Optional<Person> getPersonById(int id) {
        return personRepository.findById(id);
    }

    public void delete(int id) {
        Optional<Person> personToDelete = personRepository.findById(id);

        if( personToDelete != null) {
            personRepository.delete(personToDelete.get());
        }

    }

    public Person saveOrUpdate(Person person) {
        Person save = personRepository.save(person);
        return save;
    }

    public Iterable<Person> saveOrUpdateList(List<Person> persons) {
        return personRepository.saveAll(persons);
    }
}
