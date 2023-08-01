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
@Table( name = "EMPLOYEE")
public class Employee {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column
    private long feId;

    @ElementCollection
    private List<Long> daysOff;

    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name="scheduleData_id", nullable=false)
    private ScheduleData scheduleData;
}
