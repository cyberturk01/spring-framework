package org.yigit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    @RequestMapping("/user")
    public String getUser(){
        return "/user/userinfo.html"; //go to folder static and look for the file
    }
}
