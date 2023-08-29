package org.yigit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TimeApp {
    public static void main(String[] args) {
        ApplicationContext context= new AnnotationConfigApplicationContext(ConfigHours.class);

        context.getBean(Java.class).getTeachingHours();
    }
}
