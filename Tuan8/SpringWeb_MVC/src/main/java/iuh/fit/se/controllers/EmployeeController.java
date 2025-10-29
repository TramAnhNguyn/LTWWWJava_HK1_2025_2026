package iuh.fit.se.controllers;

import iuh.fit.se.entities.Employee;
import iuh.fit.se.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // Hiển thị form đăng ký nhân viên
    @GetMapping("/register")
    public ModelAndView showForm() {
        ModelAndView mv = new ModelAndView("employee_register");
        mv.addObject("employee", new Employee()); // ✅ thêm đối tượng model
        return mv;
    }

    // Xử lý form submit
    @PostMapping("/save")
    public ModelAndView saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.save(employee);
        ModelAndView mv = new ModelAndView("employee_success");
        mv.addObject("employee", employee);
        return mv;
    }
}
