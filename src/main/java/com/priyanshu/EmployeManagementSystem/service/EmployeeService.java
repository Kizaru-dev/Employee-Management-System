package com.priyanshu.EmployeManagementSystem.service;

import com.priyanshu.EmployeManagementSystem.entity.Employee;
import com.priyanshu.EmployeManagementSystem.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository ;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id){
        return employeeRepository.findById(id).orElseThrow(()-> new RuntimeException("Invalid Id."));
    }

    public Employee saveEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Employee newEmployee , Long id){
        Employee oldEmployee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Invalid Id"));
        oldEmployee.setAddress(newEmployee.getAddress());
        oldEmployee.setDateOfBirth(newEmployee.getDateOfBirth());
        oldEmployee.setDepartment(newEmployee.getDepartment());
        oldEmployee.setEmail(newEmployee.getEmail());
        oldEmployee.setEmployeeStatus(newEmployee.getEmployeeStatus());
        oldEmployee.setFirstName(newEmployee.getFirstName());
        oldEmployee.setGender(newEmployee.getGender());
        oldEmployee.setJobTitle(newEmployee.getJobTitle());
        oldEmployee.setJoiningDate(newEmployee.getJoiningDate());
        oldEmployee.setLastName(newEmployee.getLastName());
        oldEmployee.setPhoneNo(newEmployee.getPhoneNo());
        oldEmployee.setSalary(newEmployee.getSalary());
        return employeeRepository.save(oldEmployee);
    }

    public void deleteById(Long id){
        employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Invalid Exception"));
        employeeRepository.deleteById(id);
    }
}

