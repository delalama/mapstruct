package com.mapstruct.mapstruct.mapper;

import com.mapstruct.mapstruct.model.Human;
import com.mapstruct.mapstruct.model.Person;
import com.mapstruct.mapstruct.model.PersonDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface PersonToPersonDTOMapper {
    List<PersonDTO> map(List<Person> person);
    PersonDTO personToPersonDTO(Person person);
}
