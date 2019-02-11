package com.thymleafview;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GreetingController {

    @GetMapping("/greeting")
    public String greetingForm(Model model) {
        model.addAttribute("greeting", new Greeting());
        return "greeting";
    }
    @GetMapping("/signup")
    public String signupForm(Model model) {
        model.addAttribute("signup", new Signup());
        return "signup";
    }
    
    @GetMapping("/jsdemo")
    public String jsDemo(Model model) {
    	
    	return "jsdemo";
    }

    @PostMapping("/greeting")
    public String greetingSubmit(@ModelAttribute Greeting greeting) {
        return "result";
    }
    @PostMapping("/signup")
    public String signupSubmit(@ModelAttribute Signup signup) {
        return "formresult";
    }

}
