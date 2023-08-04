package com.mapstruct.mapstruct.model;

import com.mapstruct.mapstruct.PersonType;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    @Column
    private String name;
    @Column
    private String pass;
}
