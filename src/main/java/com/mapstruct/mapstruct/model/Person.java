package com.mapstruct.mapstruct.model;

import com.mapstruct.mapstruct.PersonType;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table
public class Person extends Human {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    @Column
    private PersonType type;
}
