package com.mapstruct.mapstruct.service;

import com.mapstruct.mapstruct.action.ScheduleMaker;
import com.mapstruct.mapstruct.model.Employee;
import com.mapstruct.mapstruct.model.EmployeeDTO;
import com.mapstruct.mapstruct.model.ScheduleData;
import com.mapstruct.mapstruct.model.ScheduleDataDTO;
import com.mapstruct.mapstruct.repository.ScheduleDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DataService {
    @Autowired
    ScheduleDataRepository dataRepository;

    @Autowired
    ScheduleMaker scheduleMaker;

    public ScheduleDataDTO saveOrUpdateScheduleData(ScheduleDataDTO scheduleDataDTO) {
        ScheduleData scheduleData = getScheduleData(scheduleDataDTO);

        ScheduleData saved = dataRepository.save(scheduleData);

//        scheduleMaker.generateSchedule(saved);

        return saved.toDTO(saved);
    }

    private ScheduleData getScheduleData(ScheduleDataDTO scheduleDataDTO) {
        ScheduleData scheduleData = new ScheduleData();

        scheduleData.setEmployee(mapEmployees(scheduleDataDTO.getEmployees(), scheduleData));
        scheduleData.setMonthAndYear(scheduleDataDTO.getMonth());
        scheduleData.setId(null);

        return scheduleData;
    }

    private List<Employee> mapEmployees(List<EmployeeDTO> employeeDTOList, ScheduleData scheduleData) {
        List<Employee> employees = new ArrayList<>();
        if (employeeDTOList != null) {

            employeeDTOList.forEach(e -> {
                Employee employee = new Employee();
                employee.setId(null);
                employee.setFeId(e.getFeId());
                employee.setName(e.getName());
                employee.setDaysOff(e.getDaysOff());
                employee.setScheduleData(scheduleData);

                employees.add(employee);
            });
        }
        return employees;
    }
}
