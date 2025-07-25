package com.example.demo.service;

import com.example.demo.entity.Account;
import com.example.demo.entity.Login;

public interface LoginService {

	boolean execute(Login login);
	Account judgeDepartment(Login login);
}