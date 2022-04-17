package com.example.demo.DTO;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
public class AddressDto {
    private String city;
    private String street;
}

