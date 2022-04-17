package com.example.demo.Controller;


import com.example.demo.DTO.DepartmentDto;
import com.example.demo.Model.Department;
import com.example.demo.Model.Employee;
import com.example.demo.Repository.DepartmentRepository;
import com.example.demo.Service.DepartmentService;
import com.example.demo.Service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/department")
public class DepartmentController {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private DepartmentService departmentService;


    @GetMapping("/all")
    public List<Department> getAllDepartments(@RequestParam(defaultValue = "0") Integer pageNo,
                                              @RequestParam(defaultValue = "10") Integer pageSize,
                                              @RequestParam(defaultValue = "id") String sortBy){
        return departmentService.getAllDepartments(pageNo,pageSize,sortBy);
    }
    @PostMapping
    public void addDepartment(@RequestBody DepartmentDto departmentDto){
        Department temp = modelMapper.map(departmentDto,Department.class);
        departmentService.addNewDepartment(temp);
    }
    @PutMapping("/{id}")
    public void updateDepartment(@PathVariable long id,@RequestBody  DepartmentDto departmentDto){
        Department temp = modelMapper.map(departmentDto,Department.class);
        departmentService.updateDepartment(id,temp);
    }
    @DeleteMapping("/{id}")
    public void deleteDepartment(@PathVariable long id){
        departmentService.deleteDepartment(id);
    }
}
