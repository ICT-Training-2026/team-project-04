package com.example.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Login {
    
	private String employee_id;
    private String pass;
    
    public Login(String employee_id, String pass) {
		this.employee_id = employee_id;
		this.pass = pass;
	}
}