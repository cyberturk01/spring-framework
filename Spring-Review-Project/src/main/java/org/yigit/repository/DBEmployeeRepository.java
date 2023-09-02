package org.yigit.repository;

import lombok.Data;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.yigit.model.Employee;
import org.springframework.stereotype.Component;

@Component
public class DBEmployeeRepository implements EmployeeRepository{


    Employee employee;

//    public DBEmployeeRepository(Employee employee) {
//        this.employee = employee;
//    }

    @Override
    public Integer getHourlyRate() {
        Employee employee=new Employee("Gok","IT",12);
        return employee.getHourlyRate();
    }
}
