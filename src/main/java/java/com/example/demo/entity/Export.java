package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Export {
	
	private String employee_id;
	private String employee_name;
	private String department_name;
	private Integer actual_working_minutes;
//	private integer zangyo;
}