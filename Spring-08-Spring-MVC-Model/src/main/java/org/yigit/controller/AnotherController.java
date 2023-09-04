package org.yigit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.yigit.enums.Gender;
import org.yigit.model.Mentor;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/another")
public class AnotherController {
    @RequestMapping("/mentor")
    public String getMentor(Model model) {

        List<Mentor> mentors = new ArrayList<>();
        mentors.add(new Mentor("Mike", "Smith", 45, Gender.MALE));
        mentors.add(new Mentor("Tom", "Hanks", 65, Gender.MALE));
        mentors.add(new Mentor("Ammy", "Bryan", 41, Gender.FEMALE));
        model.addAttribute("mentors", mentors);
        return "mentor/mentor-list";
    }
}
