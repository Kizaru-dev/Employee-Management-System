package com.priyanshu.EmployeManagementSystem.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
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

    @NotBlank(message = "Name should not be empty")
    @Size(max = 100)
    private String firstName ;

    @NotBlank(message = "Last Name should not be empty")
    @Size(max = 50)
    private String lastName ;

    @Email(message = "Please Enter the Valid Email")
    @NotBlank(message = "Email should not be Empty")
    private String email ;

    @NotBlank(message = "Enter Your Phone NO . ")
    @Pattern(
            regexp = "^[0-9]{10}$",
            message = "Phone number must contain exactly 10 digits"
    )
    private String phoneNo ;

    @NotNull(message = "Date should not be Empty")
    @Past(message = "date of birth should be in past")
    private LocalDate dateOfBirth;

    @NotNull(message = "Define the Gender")
    @Enumerated(EnumType.STRING)
    private Gender gender ;

    @NotBlank(message = "Enter the Department")
    @Size(max = 200)
    private String department ;


    @NotBlank(message = "Job Title Should not be Blank")
    @Size(max = 200)
    private String jobTitle ;

    @NotNull()
    @DecimalMin(
            value = "0.0" , inclusive = false,
            message = "Salary must be greater than zero"
    )
    private BigDecimal salary ;

    @PastOrPresent(message = "Joining Dates should not be in Future")
    @NotNull(message = "Joining Date  should not be empty")
    private LocalDate joiningDate ;

    @NotNull(message = "EmployeeStatus Should Not Be Blank")
    @Enumerated(EnumType.STRING)
    private EmployeeStatus employeeStatus ;

    @NotBlank(message = "Address should not be null > ")
    @Size(max = 250)
    private String address ;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
