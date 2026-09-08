package com.priyanshu.EmployeManagementSystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    private String firstName ;
    private String lastName ;
    private String email ;
    private String phoneNo ;
    private LocalDate dateOfBirth;

    @Enumerated(EnumType.STRING)
    private Gender gender ;

    private String department ;
    private String jobTitle ;
    private BigDecimal salary ;
    private LocalDate joiningDate ;

    @Enumerated(EnumType.STRING)
    private EmployeeStatus employeeStatus ;

    private String address ;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
