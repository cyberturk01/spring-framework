package org.yigit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.yigit.config.AppConfig;
import org.yigit.service.SalaryService;

public class SalaryApp {
    public static void main(String[] args) {
        ApplicationContext context= new AnnotationConfigApplicationContext(AppConfig.class);
        SalaryService salary = context.getBean(SalaryService.class);
        System.out.println(salary.calculateRegularSalary());
    }
}
