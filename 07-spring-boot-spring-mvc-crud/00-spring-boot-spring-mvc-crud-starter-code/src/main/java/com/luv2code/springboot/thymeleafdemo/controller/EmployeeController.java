package com.luv2code.springboot.cruddemo.controller;


import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    //Since there is only one constructor the @Autowired keyword is optional
    public EmployeeController(EmployeeService theEmployeeService){
        employeeService = theEmployeeService;
    }

    //add mapping for listing the employee
    @GetMapping("/list")
    public String listEmployees(Model themodel){
        //get the employee from db
        List<Employee> theEmployees = employeeService.findAll();

        //add that to the spring model
        themodel.addAttribute("employees", theEmployees);
        return "list-employees";
    }
}
