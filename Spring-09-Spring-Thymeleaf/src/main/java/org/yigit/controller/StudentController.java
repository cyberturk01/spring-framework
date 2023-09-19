package org.yigit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.yigit.bootstrap.DataGenerator;

@Controller
@RequestMapping("/student")
public class StudentController {

    @RequestMapping("/register")
    public String register(Model model){
       model.addAttribute("students", DataGenerator.createStudent());
        return "student/register";
    }

    @RequestMapping("/info")
    public String info(){
        return "student/info";
    }

}
