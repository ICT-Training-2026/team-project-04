package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.demo.form.LoginForm;

@Controller
public class AttendanceEditController {
	
	@GetMapping("/attendanceEdit")
    public String attendanceEdit(@ModelAttribute LoginForm loginForm) {
    	System.out.println("勤怠実績画面への遷移が成功");
        return "oldAttendance";
    }
	
	@GetMapping("/completeCorrection")
	private String completeCorrection() {
		return "completeCorrection";
	}
	
	@GetMapping("/applicationPermission")
	private String applicationPermission() {
		return "applicationPermission";
	}
	
}