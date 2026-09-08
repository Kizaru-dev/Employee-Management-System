package com.priyanshu.EmployeManagementSystem.repository;

import com.priyanshu.EmployeManagementSystem.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
