package com.mapstruct.mapstruct.mapper;

import com.mapstruct.mapstruct.model.Human;
import com.mapstruct.mapstruct.model.Person;
import com.mapstruct.mapstruct.model.PersonDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(uses = {Human.class})
public interface PersonDTOToPersonMapper {
    List<Person> map(List<PersonDTO> person);

    @Mapping(target = "id", ignore = true)
    Person personDTOToPerson(PersonDTO person);
}
