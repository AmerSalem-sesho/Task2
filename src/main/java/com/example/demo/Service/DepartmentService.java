package com.example.demo.Service;

import com.example.demo.Model.Department;
import com.example.demo.Repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;
    public List<Department> getAllDepartments(){
        return departmentRepository.findAll();
    }

    public void addNewDepartment(Department department) {
        departmentRepository.save(department);
    }

    public void updateDepartment(long id, Department department) {
        Department temp = departmentRepository.findById(id).get();
        temp.setName(department.getName());
        temp.setManager(department.getManager());
    }

    public void deleteDepartment(long id) {
        boolean  exists = departmentRepository.existsById(id);
        if (exists)
            departmentRepository.deleteById(id);
        else
            System.out.println("no department found");
    }
}
