package com.tekgrads.controller;

import com.tekgrads.dto.EmployeeDTO;
import com.tekgrads.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/employeeHome")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/getAllEmployees")
    public ModelAndView listEmployees() {
    	ModelAndView mv = new ModelAndView("employee-list"); 
        List<EmployeeDTO> employees = employeeService.getAllEmployees();     
        mv.addObject("employees", employees);
        return mv;
    }

    @GetMapping("/add")
    public ModelAndView showAddForm(Model model) {
    	ModelAndView mv = new ModelAndView("employee-form");        
        mv.addObject("employee", new EmployeeDTO());
        return mv;
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") EmployeeDTO employee) {
        if (employee.getId() == 0) {
            employeeService.addEmployee(employee);
        } else {
            employeeService.updateEmployee(employee);
        }
        return "redirect:/employeeHome/getAllEmployees";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editEmployee(@PathVariable("id") int id, Model model) {
        EmployeeDTO employee = employeeService.getEmployeeById(id);
        ModelAndView mv = new ModelAndView("employee-form");        
        mv.addObject("employee", employee);
        model.addAttribute("employee", employee);
        return mv;
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable("id") int id) {
        employeeService.deleteEmployee(id);
        return "redirect:/employeeHome/getAllEmployees";
    }
}
