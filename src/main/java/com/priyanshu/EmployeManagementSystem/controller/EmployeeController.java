package com.priyanshu.EmployeManagementSystem.controller;

import com.priyanshu.EmployeManagementSystem.entity.Employee;
import com.priyanshu.EmployeManagementSystem.entity.EmployeeStatus;
import com.priyanshu.EmployeManagementSystem.entity.Gender;
import com.priyanshu.EmployeManagementSystem.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RestController("/employees")
public class EmployeeController {

    private final EmployeeService  employeeService ;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService ;
    }

    //Home Page.
    @GetMapping
    public String homePage(Model model){
        List<Employee> employees = employeeService.getAllEmployee();
        model.addAttribute("employees",employees);
        model.addAttribute("searched",false);
        return "home";
    }

    // Add Employee .
    @GetMapping("/addPage")
    public String addPage(Model model){
        model.addAttribute("employee",new Employee());
        model.addAttribute("employeeStatuses", EmployeeStatus.values());
        model.addAttribute("genders", Gender.values());
        return "add";
    }

}
