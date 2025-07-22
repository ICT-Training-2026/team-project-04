package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.demo.form.LoginForm;

@Controller
public class attendanceController {
	
	@GetMapping("/attendance")
    public String attendance(@ModelAttribute LoginForm loginForm) {
    	System.out.println("勤怠登録画面への遷移が成功");
        return "attendance";
    }
	
}