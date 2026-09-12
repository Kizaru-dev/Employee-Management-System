package com.priyanshu.EmployeManagementSystem.controller;

import com.priyanshu.EmployeManagementSystem.entity.Employee;
import com.priyanshu.EmployeManagementSystem.entity.EmployeeStatus;
import com.priyanshu.EmployeManagementSystem.entity.Gender;
import com.priyanshu.EmployeManagementSystem.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.model.IModel;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService  employeeService ;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService ;
    }

    @GetMapping("/search")
    public String searchFeature(@RequestParam(required = false) String keyword , Model model){
        model.addAttribute("employees",employeeService.searchEmployee(keyword));
        model.addAttribute("keyword",keyword);
        model.addAttribute("searched",true);
        return "home";
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

    @PostMapping("/employee")
    public String addEmployee(@Valid @ModelAttribute Employee employee , BindingResult bindingResult,
                              Model model){

        if(bindingResult.hasErrors()){
            System.out.println("Has Errors : " + bindingResult.hasErrors());
            System.out.println(bindingResult.getAllErrors());
            model.addAttribute("employeeStatuses",EmployeeStatus.values());
            model.addAttribute("genders",Gender.values());
            return "add";
        }

        employeeService.saveEmployee(employee);
        return "redirect:/employees";
    }

    @GetMapping("/update/{id}")
    public String updatePageRender(Model model , @PathVariable Long id){
        Employee employeeById = employeeService.getEmployeeById(id);
        model.addAttribute("employee",employeeById);
        model.addAttribute("genders",Gender.values());
        model.addAttribute("employeeStatus",EmployeeStatus.values());
        return "update";
    }

    @PostMapping("/updated/{id}")
    public String updateEmployee(@ModelAttribute Employee employee , @PathVariable Long id){
        employeeService.updateEmployee(employee,id);
        return "redirect:/employee";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id){
        employeeService.deleteById(id);
        return "redirect:/employee";
    }

}
