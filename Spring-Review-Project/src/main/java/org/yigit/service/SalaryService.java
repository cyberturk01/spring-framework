package org.yigit.service;

import lombok.Data;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.yigit.repository.DBEmployeeRepository;
import org.yigit.repository.OverTimeHours;
import org.yigit.repository.RegularHours;

@Component
public class SalaryService {
    DBEmployeeRepository hourlyRate;
    RegularHours regularHours;
    OverTimeHours overTimeHours;

    public SalaryService(DBEmployeeRepository hourlyRate, @Qualifier("HOURS") RegularHours regularHours, OverTimeHours overTimeHours) {
        this.hourlyRate = hourlyRate;
        this.regularHours = regularHours;
        this.overTimeHours = overTimeHours;
    }

    public Integer calculateRegularSalary(){
        return hourlyRate.getHourlyRate()+regularHours.getHours();
    }
}
