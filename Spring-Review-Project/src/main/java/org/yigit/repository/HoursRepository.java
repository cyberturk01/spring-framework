package org.yigit.repository;

import org.springframework.stereotype.Component;
import org.yigit.model.Employee;

@Component
public interface HoursRepository {
    int getHours();
}
