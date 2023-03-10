package com.example.ERP.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;
import  java.util.*;

//import java.sql.Date;



@Data
@Entity

public class EmployeeTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;


    private String description;


    private LocalDateTime deadline;


//    private Employee employee;


    private String token;



    // constructors, getters, and setters
}
