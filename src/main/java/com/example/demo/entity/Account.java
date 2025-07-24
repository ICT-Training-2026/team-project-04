package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    private String employee_id;
    private String employee_name;
    private String pass;
    private String department_code;
    private String position_code;
    private String email;
    private String department_name;
    
}