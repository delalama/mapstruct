package com.mapstruct.mapstruct.controller;

import com.mapstruct.mapstruct.model.Person;
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
    private List<Person> getAllPerson() {
        return personService.getAllPerson();
    }

    @GetMapping("/Person/{id}")
    private Optional<Person> getPerson(@PathVariable("id") int id) {
        return personService.getPersonById(id);
    }

    @DeleteMapping("/Person/{id}")
    private void deletePerson(@PathVariable("id") int id) {
        personService.delete(id);
    }

    @PostMapping("/Person")
    private long savePerson(@RequestBody Person Person) {
        Person person = personService.saveOrUpdate(Person);
        return person.getId();
    }

    @GetMapping("/RandomPerson")
    private long saveRandomPerson() {
        Iterable<Person> people = personService.saveOrUpdateList(Arrays.asList(Instancio.create(Person.class)));

        return people.iterator().next().getId();
    }

    @GetMapping("/RandomPersons")
    private Iterable<Person> saveRandomPersons() {
        List<Person> persons = Instancio.ofList(Person.class).size(50).create();

        return personService.saveOrUpdateList(persons);
    }
}
