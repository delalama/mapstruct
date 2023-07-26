package com.mapstruct.mapstruct.controller;

import com.mapstruct.mapstruct.model.Person;
import com.mapstruct.mapstruct.model.PersonDTO;
import com.mapstruct.mapstruct.service.PersonService;
import org.instancio.Instancio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
public class PersonController {
    @Autowired
    PersonService personService;

    @GetMapping("/person")
    private List<PersonDTO> getAllPerson() {
        return personService.getAllPerson();
    }

    @GetMapping("/Person/{id}")
    private PersonDTO getPerson(@PathVariable("id") int id) {
        return personService.getPersonById(id);
    }

    @DeleteMapping("/Person/{id}")
    private void deletePerson(@PathVariable("id") int id) {
        personService.delete(id);
    }

    @PostMapping("/Person")
    private long savePerson(@RequestBody Person Person) {
        return  personService.saveOrUpdate(Person);
    }

    @GetMapping("/RandomPerson")
    private Iterable<PersonDTO> saveRandomPerson() {
        List<Person> list = Arrays.asList(Instancio.create(Person.class));
        return personService.saveOrUpdateList(list);
    }

    @GetMapping("/RandomPersons")
    private Iterable<PersonDTO> saveRandomPersons() {
        List<Person> persons = Instancio.ofList(Person.class).size(50).create();

        return personService.saveOrUpdateList(persons);
    }
}
