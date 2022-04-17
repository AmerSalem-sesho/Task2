package com.example.demo.Controller;

import com.example.demo.DTO.EmployeeDto;
import com.example.demo.Model.Employee;
import com.example.demo.Service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;


@RestController
@RequestMapping("api/employee")
public class EmployeeController {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private EmployeeService employeeService;

    //GET ALL EMPLOYEES
    @GetMapping("/all")
    public List<EmployeeDto> getAllEmployees( @RequestParam(defaultValue = "0") Integer pageNo,
                                              @RequestParam(defaultValue = "10") Integer pageSize,
                                              @RequestParam(defaultValue = "id") String sortBy){

       return employeeService.getAllEmployees(pageNo,pageSize,sortBy).stream().map(Employee -> modelMapper.map(Employee, EmployeeDto.class)).collect(Collectors.toList());
    }
    @GetMapping ("/findByGender/{gender}")
    public List<Employee> findByGender(@PathVariable String gender){
        return employeeService.getEmployeeByGender(gender);
    }
    @GetMapping("/managers")
    public List<Employee> getManagers(){
        return employeeService.getManagers();
    }
    @GetMapping("/{department}")
    public List<String> getNameByDepartment(@PathVariable String department){
        return employeeService.getNameByDepartment(department);
    }

    //ADD NEW EMPLOYEE
    @PostMapping()
    public void addNewEmployee(@RequestBody EmployeeDto employeeDto){
        Employee temp = modelMapper.map(employeeDto,Employee.class);
        employeeService.addNewEmployee(temp);
    }
    //DELETE EMPLOYEE BY ID
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable long id){
        employeeService.deleteEmployee(id);
    }

    @PutMapping("/{id}")
    public void updateEmployee(@PathVariable long id,@RequestBody EmployeeDto employeeDto){
        Employee temp = modelMapper.map(employeeDto,Employee.class);
        employeeService.updateEmployee(id,temp);
    }









}
