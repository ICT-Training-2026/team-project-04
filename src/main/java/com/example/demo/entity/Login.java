package com.example.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Login {
    
	private String userId;
    private String pass;
    
    public Login(String userId, String pass) {
		this.userId = userId;
		this.pass = pass;
	}
}