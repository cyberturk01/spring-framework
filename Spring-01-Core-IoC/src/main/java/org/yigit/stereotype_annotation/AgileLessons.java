package org.yigit.stereotype_annotation;

import org.springframework.stereotype.Component;

@Component
public class AgileLessons {
    public void getTeachingHours(){
        System.out.println("Total teaching hours: 15");
    }
}