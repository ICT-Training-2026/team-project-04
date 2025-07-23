package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Attendance {
    private String employee_id;
    private String employee_name;
    private String department_code;
    private String department_name;
}