package com.mapstruct.mapstruct.mapper;

import com.mapstruct.mapstruct.model.Person;
import com.mapstruct.mapstruct.model.PersonDTO;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonDTOToPersonMapperTest {

    private final PersonDTOToPersonMapper mapper
            = Mappers.getMapper(PersonDTOToPersonMapper.class);

    @Test
    public void givenPersonDTOList_whenMapsList_thenCorrect() {
        PersonDTO personFrom = new PersonDTO();
        personFrom.setName("DestinationName");
        personFrom.setSurname("DestinationDescription");

        List<PersonDTO> personDTOS = Arrays.asList(personFrom);

        List<Person> personListMapped = mapper.map(personDTOS);

        for (Person personTo : personListMapped) {
            assertEquals(personFrom.getName(), personTo.getName());
            assertEquals(personFrom.getSurname(),
                    personTo.getSurname());
        }

    }
}