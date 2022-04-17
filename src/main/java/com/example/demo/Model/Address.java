package com.example.demo.Model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import javax.persistence.*;
import java.util.List;
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Data
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NonNull
    private String city;
    @NonNull
    private String street;
    @JsonBackReference
    @OneToMany(mappedBy = "address")
    private List<Employee> employee;
}
