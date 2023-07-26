package com.mapstruct.mapstruct.model;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class Human {
    private String name;
    private String surname;
}
