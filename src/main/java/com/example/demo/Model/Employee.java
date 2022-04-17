package com.example.demo.Model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NonNull
    private String name;
    @NonNull
    private String phoneNumber;
    @NonNull
    private String gender;
    @NonNull
    private LocalDate hireDate;
    @NonNull
    private String role;
    @NonNull
    private double baseSalary;
    @Transient@Setter@Getter(AccessLevel.NONE)
    private double currSalary;
    @Setter(AccessLevel.NONE)
    @OneToOne(mappedBy = "manager", cascade = CascadeType.ALL)
    private Department manages;
    @NonNull
    @ManyToOne()
    @JoinColumn(name = "address_id")
    private Address address;

    @NonNull
    @ManyToMany()
    @JoinTable(
            name = "Employee_Department",
            joinColumns = @JoinColumn(name = "employee"),
            inverseJoinColumns = @JoinColumn(name = "department")
    )
    private List<Department> department;


    public double getCurrSalary() {
        int numOfYears = LocalDate.now().getYear() - getHireDate().getYear();
        int raise = numOfYears * 200;
        return raise + getBaseSalary();
    }
}
