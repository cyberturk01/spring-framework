package org.yigit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //Annotate the class with the @Controller stereotype annotation
public class HomeController {
    @RequestMapping("/home") //Use @RequestMapping to associate the action with an HTTP request path
    public String home(){
        return "home.html"; //Return the HTML document name, which browser will display
    }

    @RequestMapping("/welcome")
    public String home2(){
        return "welcome.html";
    }
    @RequestMapping("/")
    public String home3(){
        return "welcome.html";
    }
}
