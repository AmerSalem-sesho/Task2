package com.example.demo.DTO;

import com.example.demo.Model.Employee;
import lombok.Data;



@Data
public class DepartmentDto {
    private String name;
    private Employee manager;
}
