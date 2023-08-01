package com.mapstruct.mapstruct.repository;

import com.mapstruct.mapstruct.model.Employee;
import com.mapstruct.mapstruct.model.EmployeeDTO;
import com.mapstruct.mapstruct.model.ScheduleData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
}
