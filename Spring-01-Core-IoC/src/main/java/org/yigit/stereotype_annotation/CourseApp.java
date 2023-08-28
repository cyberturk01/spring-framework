package org.yigit.stereotype_annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CourseApp {
    public static void main(String[] args) {

        ApplicationContext context= new AnnotationConfigApplicationContext(ConfigCourse.class);
        context.getBean(JavaLessons.class).getTeachingHours();
        context.getBean(AgileLessons.class).getTeachingHours();
    }
}
