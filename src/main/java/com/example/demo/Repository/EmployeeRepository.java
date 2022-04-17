package com.example.demo.Repository;

import com.example.demo.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
     List<Employee> findByGender(String gender);

     @Query(value = "select DISTINCT * from employee e,department d where e.id = d.manager" , nativeQuery = true)
     List<Employee> getManagers();

     @Query(value = "select e.name from employee e where e.id in (select d.employee from employee_department d where d.department in " +
             "(select D.id from department D where D.name = :department))" ,nativeQuery = true)
     List<String>getNamesByDepartment(String department);


}
