package com.example.demo.repository;

import com.example.demo.entity.Attendance;
import com.example.demo.entity.AttendanceInfo;

public interface AttendanceRepository {
	Attendance findInfo(String current_id);
	int AttendanceInfo(AttendanceInfo attendanceInfo);
}
