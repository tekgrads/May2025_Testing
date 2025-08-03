package com.tekgrads.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/home") 
public class HomeController {

    @RequestMapping("/landingPage")
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView("home"); // Maps to /WEB-INF/views/home.jsp
        mv.addObject("message", "Welcome to Spring MVC using ModelAndView!");
        return mv;
    }

    @RequestMapping("/about")
    public ModelAndView about() {
        ModelAndView mv = new ModelAndView("about"); // Maps to /WEB-INF/views/about.jsp
        mv.addObject("info", "This is the About page powered by Spring XML Config.");
        return mv;
    }
}
