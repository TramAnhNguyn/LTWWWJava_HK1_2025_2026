package iuh.fit.se.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {
    @GetMapping
    public ModelAndView showForm(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("employee_register");
        return modelAndView;

    }
}
