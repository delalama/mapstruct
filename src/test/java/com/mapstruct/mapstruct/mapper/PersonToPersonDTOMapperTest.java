package com.mapstruct.mapstruct.mapper;

import com.mapstruct.mapstruct.model.Person;
import com.mapstruct.mapstruct.model.PersonDTO;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonToPersonDTOMapperTest {

    private final PersonToPersonDTOMapper mapper
            = Mappers.getMapper(PersonToPersonDTOMapper.class);

    @Test
    public void givenPersonList_whenMapsList_thenCorrect() {
        List<Person> personsFrom  = Instancio.ofList(Person.class).size(2).create();

        List<PersonDTO> personDTOListMapped = mapper.map(personsFrom);

        for (PersonDTO personDTO : personDTOListMapped) {
            Person personFrom = personsFrom
                    .stream().filter(p -> p.getName().equals(personDTO.getName()))
                            .findAny().get();

            assertAll("Verify Person properties",
                    () -> assertEquals(personDTO.getName()
                            , personFrom.getName()),
                    () -> assertEquals(personDTO.getSurname()
                            , personFrom.getSurname()),
                    () -> assertEquals(personDTO.getType()
                            , personFrom.getType())
            );

        }

    }
}