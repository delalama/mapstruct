package com.mapstruct.mapstruct.model;

import com.mapstruct.mapstruct.PersonType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PersonDTO extends Human{
    private PersonType type;
}
