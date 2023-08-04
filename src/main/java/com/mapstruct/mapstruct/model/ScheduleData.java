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

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    public ScheduleDataDTO toDTO(ScheduleData saved) {
        ScheduleDataDTO scheduleDataDTO = new ScheduleDataDTO();

        scheduleDataDTO.setEmployees(Employee.toDTO(saved.getEmployee()));
        scheduleDataDTO.setMonth(saved.getMonthAndYear());
        scheduleDataDTO.setScheduleDataDTOId(saved.getId());
        return scheduleDataDTO;
    }
}
