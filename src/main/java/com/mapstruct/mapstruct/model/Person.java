package com.mapstruct.mapstruct.model;

import com.mapstruct.mapstruct.PersonType;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class Person extends Human {
    private long id;
    private PersonType type;

}
