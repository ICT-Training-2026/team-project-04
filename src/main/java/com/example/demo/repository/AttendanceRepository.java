package com.example.demo.repository;

import com.example.demo.entity.Attendance;

public interface AttendanceRepository {
	Attendance findInfo(String current_id);
}
