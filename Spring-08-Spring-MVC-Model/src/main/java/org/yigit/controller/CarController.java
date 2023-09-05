package org.yigit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/car")
public class CarController {

    @RequestMapping("/info")  //localhost:8080/car/info?make=Honda
    public String carInfo(@RequestParam String make, @RequestParam String mode, Model model) {
        model.addAttribute("make", make);
        model.addAttribute("mode", mode);
        return "car/car-info";
    }

    @RequestMapping("/info2")  //localhost:8080/car/info?make=Honda
    public String carInfo2(@RequestParam(required = false, defaultValue = "BMW") String make,
                           @RequestParam(value = "year", required = false, defaultValue = "2019") Integer year,
                           Model model) {
        model.addAttribute("make", make);
        model.addAttribute("year", year);
        return "car/car-info";
    }

    @RequestMapping("/info/{make}/{year}")  //localhost:8080/car/info?make=Honda
    public String carInfo3(@PathVariable String make, @PathVariable Integer year, Model model) {
        model.addAttribute("make", make);
        return "car/car-info";
    }
}
