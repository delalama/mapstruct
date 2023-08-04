package com.mapstruct.mapstruct.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ScheduleDataDTO {
    private Long scheduleDataDTOId;
    private String companyName;
    private String month;
    private List<EmployeeDTO> employees;
}
