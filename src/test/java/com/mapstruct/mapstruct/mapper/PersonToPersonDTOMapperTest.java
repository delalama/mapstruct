package com.mapstruct.mapstruct.mapper;

import com.mapstruct.mapstruct.model.Person;
import com.mapstruct.mapstruct.model.PersonDTO;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonToPersonDTOMapperTest {

    private final PersonToPersonDTOMapper mapper
            = Mappers.getMapper(PersonToPersonDTOMapper.class);

    @Test
    public void givenPersonList_whenMapsList_thenCorrect() {
        Person personFrom = new Person();
        personFrom.setName("DestinationName");
        personFrom.setSurname("DestinationDescription");

        List<PersonDTO> personDTOListMapped = mapper.map(List.of(personFrom));

        for (PersonDTO personDTO : personDTOListMapped) {
            assertEquals(personFrom.getName(), personDTO.getName());
            assertEquals(personFrom.getSurname(),
                    personDTO.getSurname());
            assertEquals(personFrom.getType(),
                    personDTO.getType());
        }

    }
}