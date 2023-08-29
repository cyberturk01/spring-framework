package org.yigit;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
//@NoArgsConstructor --> if we have 2 or more constructor we should create allArgsConstructor by ourselves
public class Java {

    OfficeHours officeHours;

/*
    -->Field Injection
    @Autowired
    OfficeHours officeHours;

   --> Constructor Injection
    @Autowired
    public Java(OfficeHours officeHours) {
        this.officeHours = officeHours;
    }
*/

    public void getTeachingHours(){
        System.out.println("Weekly teaching hours: "+ (20+officeHours.getHours()));
    }
}
