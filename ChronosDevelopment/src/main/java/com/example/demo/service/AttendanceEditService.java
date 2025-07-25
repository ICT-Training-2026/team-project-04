package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Edit;

public interface AttendanceEditService {
	
	List<Edit> execute(String employeeId);
}
