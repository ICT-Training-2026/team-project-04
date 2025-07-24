package com.example.demo.service;

import com.example.demo.entity.Attendance;
import com.example.demo.entity.AttendanceInfo;

public interface AttendanceService {
	Attendance findInfo(String current_id);
	int AttendanceInfo(AttendanceInfo attendanceInfo);
}
