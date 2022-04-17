package com.example.demo.DTO;

import com.example.demo.Model.Address;
import com.example.demo.Model.Department;
import jdk.jfr.DataAmount;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
public class EmployeeDto {
    private String name;
    private String phoneNumber;
    private String gender;
    private LocalDate hireDate;
    private String role;
    private double baseSalary;
    private double currSalary;
    private Department manages;
    private Address address;
    private List<Department> department;
}
