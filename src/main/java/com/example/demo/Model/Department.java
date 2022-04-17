package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NonNull
    private String name;
    @JsonIgnore@NonNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "manager")
    private Employee manager;

    @JsonIgnore
    @ManyToMany(mappedBy = "department")
    private List<Employee> employee;
}
