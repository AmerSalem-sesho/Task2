package com.example.demo.Utility;

import com.example.demo.Model.Address;
import com.example.demo.Model.Department;
import com.example.demo.Model.Employee;
import com.example.demo.Repository.AddressRepository;
import com.example.demo.Repository.DepartmentRepository;
import com.example.demo.Repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.time.LocalDate;
import java.util.List;

@Configuration
public class BeanManager {
    @Bean
    CommandLineRunner commandLineRunner(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository, AddressRepository addressRepository){


        return args -> {

            Address address1 = new Address("Al-Bireh", "yafa.st");
            Address address2 = new Address("Al-Bireh", "long.st");
            Address address3 = new Address("Salfeet", "salfeet.st");
            Address address4 = new Address("Khalil", "musleh.st");

            Department dep1 = new Department("IT",new Employee());
            Department dep2 = new Department("science",new Employee());
            Department dep3 = new Department("art",new Employee());
            Department dep4 = new Department("nursing",new Employee());



            Employee emp1 = new Employee("Amer Salem","05998848484" ,"male", LocalDate.of(2019,8,20),"Accountant",2000,address1,List.of(dep1,dep2,dep3,dep4));
            Employee emp2 = new Employee("Ahmad Abed", "0593746274", "male",LocalDate.of(2021,8,20), "programmer",2300,address2,List.of(dep1));
            Employee emp3 = new Employee("Mohammad ishtaya", "0594234243", "male",LocalDate.of(2017,8,20), "Cleaner",1900,address3,List.of(dep1,dep2,dep3));
            Employee emp4 = new Employee("Lana Mosleh", "e059331231", "female",LocalDate.of(2015,8,20), "manager",5000,address4,List.of(dep1,dep3));
            Employee emp5 = new Employee("Farah", "059331231", "female",LocalDate.of(2016,12,20), "cleaner",1000,address4,List.of(dep1,dep3));
            Employee emp6 = new Employee("Sondos Taweel", "0549331231", "female",LocalDate.of(2015,8,21), "co-manager",5000,address4,List.of(dep1,dep3));

            dep1.setManager(emp1);
            dep2.setManager(emp2);
            dep3.setManager(emp3);
            dep4.setManager(emp4);

            addressRepository.saveAll(List.of(address1,address2,address3,address4));
            departmentRepository.saveAll(List.of(dep1,dep2,dep3,dep4));
            employeeRepository.saveAll(List.of(emp1,emp2,emp3,emp4));



        };

    }

}
