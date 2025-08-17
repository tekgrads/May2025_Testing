package com.tekgrads.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@GetMapping("/about")
	public ModelAndView about() {
		ModelAndView mav = new ModelAndView("about"); // maps to about.html in /templates
		mav.addObject("info", "This is the About Page using Thymeleaf + ModelAndView");
		return mav;
	}

}
