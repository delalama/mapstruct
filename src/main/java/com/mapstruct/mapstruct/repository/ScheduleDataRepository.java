package com.mapstruct.mapstruct.repository;

import com.mapstruct.mapstruct.model.ScheduleData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleDataRepository extends CrudRepository<ScheduleData, Integer> {
}
