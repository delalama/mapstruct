package com.mapstruct.mapstruct.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ScheduleDataDTO {
    private String month;
    private List<EmployeeDTO> employees;
}
