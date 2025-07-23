package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.demo.form.LoginForm;

@Controller
public class somuManagementController {
	
	@GetMapping("/somuMenu")
    public String somuMenu(@ModelAttribute LoginForm loginForm) {
	    System.out.println("somuMenuメソッドの開始");
	    return "somuMenu";
	}
	
	@GetMapping("/attendanceManagement")
    public String attendanceManagement(@ModelAttribute LoginForm loginForm) {
	    System.out.println("attendanceManagementメソッドの開始");
	    return "attendanceManagement";
	}
	
	@GetMapping("/fileExport")
    public String fileExport(@ModelAttribute LoginForm loginForm) {
	    System.out.println("fileメソッドの開始");
	    return "fileExport";
	}
	
}