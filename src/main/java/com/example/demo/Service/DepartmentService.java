package com.example.demo.Service;

import com.example.demo.Model.Department;
import com.example.demo.Model.Employee;
import com.example.demo.Repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;
    public List<Department> getAllDepartments(Integer pageNo, Integer pageSize, String sortBy){
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<Department> pagedResult = departmentRepository.findAll(paging);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Department>();
        }
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
