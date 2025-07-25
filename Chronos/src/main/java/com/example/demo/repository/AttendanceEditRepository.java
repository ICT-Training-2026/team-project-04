package com.example.demo.repository;

import java.util.List;

import com.example.demo.entity.Edit;

public interface AttendanceEditRepository {
	
	List<Edit> EditByAttendance(String employeeId);
	
}
