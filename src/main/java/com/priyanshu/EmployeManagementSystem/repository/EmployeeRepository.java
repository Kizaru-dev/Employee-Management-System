package com.priyanshu.EmployeManagementSystem.repository;

import com.priyanshu.EmployeManagementSystem.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    List<Employee> findByFirstNameContainingIgnoreCase(String keyword);
}
