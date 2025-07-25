package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Edit {
	
	//private String employee_id;
	private String attendance_date;
	private String clock_in_time;
	private String clock_out_time;
	private Integer actual_working_minutes;
	private Integer rest_minutes;
	private String attendance_type_code;
	
}
