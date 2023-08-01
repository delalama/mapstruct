package com.mapstruct.mapstruct.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class EmployeeDTO {
    private Long feId;
    private List<Long> daysOff;
    private String name;

}
