package com.mapstruct.mapstruct.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "SCHEDULEDATA")
public class ScheduleData {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column
    private String monthAndYear;

    @OneToMany(mappedBy="scheduleData", cascade = CascadeType.ALL)
    private List<Employee> employee;
}
