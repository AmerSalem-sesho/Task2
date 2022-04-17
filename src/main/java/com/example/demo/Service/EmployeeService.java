package com.example.demo.Service;

import com.example.demo.DTO.EmployeeDto;
import com.example.demo.Model.Employee;
import com.example.demo.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees(Integer pageNo, Integer pageSize, String sortBy){
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<Employee> pagedResult = employeeRepository.findAll(paging);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Employee>();
        }
    }

    public void addNewEmployee(Employee employee) {
        employeeRepository.save(employee);
    }
    public void deleteEmployee(long id) {
        boolean exists = employeeRepository.existsById(id);
        if(!exists)
            System.out.println("employee not found");
        else
        employeeRepository.deleteById(id);
    }
    public void updateEmployee(long id,Employee employee) {
       Employee temp =  employeeRepository.findById(id).get();
       temp.setAddress(employee.getAddress());
       temp.setBaseSalary(employee.getBaseSalary());
       temp.setDepartment(employee.getDepartment());
       temp.setHireDate(employee.getHireDate());
       temp.setName(employee.getName());
       temp.setPhoneNumber(employee.getPhoneNumber());
       temp.setGender(employee.getGender());
       temp.setRole(employee.getRole());
        employeeRepository.save(temp);
    }

    public List<Employee> getEmployeeByGender(String gender) {
        return employeeRepository.findByGender(gender);
    }
    public List<Employee> getManagers(){return employeeRepository.getManagers();}
    public List<String> getNameByDepartment(String department){return employeeRepository.getNamesByDepartment(department);}
}
