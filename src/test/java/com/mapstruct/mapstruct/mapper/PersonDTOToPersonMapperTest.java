package com.mapstruct.mapstruct.mapper;

import com.mapstruct.mapstruct.model.Person;
import com.mapstruct.mapstruct.model.PersonDTO;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class PersonDTOToPersonMapperTest {

    private final PersonDTOToPersonMapper mapper
            = Mappers.getMapper(PersonDTOToPersonMapper.class);

    @Test
    public void givenPersonDTOList_whenMapsList_thenCorrect() {
        List<PersonDTO> personsFrom  = Instancio.ofList(PersonDTO.class).size(2).create();

        List<Person> personListMapped = mapper.map(personsFrom);

        for (Person personTo : personListMapped) {
            PersonDTO personToAssert = personsFrom.stream()
                    .filter(p -> p.getName().equals(personTo.getName()))
                    .findAny().get();

            assertAll("Verify Person properties",
                    () -> assertEquals(personToAssert.getName()
                            , personTo.getName()),
                    () -> assertEquals(personToAssert.getSurname()
                            , personTo.getSurname()),
                    () -> assertEquals(personToAssert.getType()
                            , personTo.getType())
            );
        }
    }
}