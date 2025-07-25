package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Edit;
import com.example.demo.service.AttendanceEditService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AttendanceEditController {
	
	private final AttendanceEditService service;
	
	@GetMapping("/attendanceEdit")
	public String attendanceEdit(@RequestParam("employee_id") String employeeId, Model model) {
	    System.out.println("勤怠実績画面への遷移が成功");
	    System.out.println("Employee ID: " + employeeId);
	    
	    //データベースから取得したデータを格納するlist
	    List<Edit> list = service.execute(employeeId);
	    System.out.println(list);
	    model.addAttribute("attendanceList", list);
	    model.addAttribute("employeeID", employeeId);
	    
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