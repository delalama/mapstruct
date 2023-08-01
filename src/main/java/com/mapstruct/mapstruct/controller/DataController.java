package com.mapstruct.mapstruct.controller;

import com.mapstruct.mapstruct.model.ScheduleDataDTO;
import com.mapstruct.mapstruct.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class DataController {
    @Autowired
    DataService dataService;

    @PostMapping("/scheduleData")
    private long saveCompany(@RequestBody ScheduleDataDTO scheduleDataDTO) {
        return  dataService.saveOrUpdateScheduleData(scheduleDataDTO);
    }

}
