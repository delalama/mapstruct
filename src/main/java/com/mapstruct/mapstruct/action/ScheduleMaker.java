package com.mapstruct.mapstruct.action;

import com.mapstruct.mapstruct.model.ScheduleData;
import org.joda.time.DateTime;
import org.springframework.stereotype.Component;

import java.time.YearMonth;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Component
public class ScheduleMaker {
    public void generateSchedule(ScheduleData saved) {
        DateTime dateTime = new DateTime(Integer.parseInt(getYear(saved.getMonthAndYear())),
                Integer.parseInt(getMonth(saved.getMonthAndYear())),
                1,
                0,
                0);

        YearMonth yearMonthObject = YearMonth.of(
                Integer.parseInt(getYear(saved.getMonthAndYear())),
                Integer.parseInt(getMonth(saved.getMonthAndYear()))
        );
        int daysInMonth = yearMonthObject.lengthOfMonth();
        System.out.println(daysInMonth);

    }

    private String getMonth(String date) {
        String[] split = date.split("-");
        return split[0];
    }

    private String getYear(String date) {
        String[] split = date.split("-");
        return split[1];
    }
}
