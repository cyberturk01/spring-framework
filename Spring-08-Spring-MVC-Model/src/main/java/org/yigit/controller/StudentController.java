package org.yigit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.yigit.model.Student;

import java.util.Arrays;
import java.util.List;
import java.util.Random;


@Controller
public class StudentController {

    @RequestMapping("welcome")
    public String homePage(Model model){
        model.addAttribute("name", "Gokhan");
        model.addAttribute("course", "Java Developer");

        String subject= "Collections";
        model.addAttribute("subject", subject);

        //Create a random studentId(0-1000) and show it in the UI
        int studentId = (int) (Math.random() * 1000)+1;
        model.addAttribute("studentId",studentId);

        List<Integer> numbers= Arrays.asList(4,5,6,7,8,10);
        model.addAttribute("numbers", numbers);

        Student student= new Student(1, "Mike", "Smith");
        model.addAttribute("student", student);

        return "student/welcome";
    }
}
