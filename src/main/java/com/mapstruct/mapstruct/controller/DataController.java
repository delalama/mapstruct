package com.mapstruct.mapstruct.controller;

import com.mapstruct.mapstruct.model.ScheduleData;
import com.mapstruct.mapstruct.model.ScheduleDataDTO;
import com.mapstruct.mapstruct.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class DataController {
    @Autowired
    DataService dataService;

    @PostMapping(value = "/scheduleData", produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<ScheduleDataDTO> saveCompany(@RequestBody ScheduleDataDTO scheduleDataDTO) {
        return ResponseEntity.accepted()
                .body(dataService.saveOrUpdateScheduleData(scheduleDataDTO));
    }

}
