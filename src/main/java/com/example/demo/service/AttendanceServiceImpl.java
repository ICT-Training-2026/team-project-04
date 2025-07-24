package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Attendance;
import com.example.demo.entity.AttendanceInfo;
import com.example.demo.repository.AttendanceRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class  AttendanceServiceImpl implements AttendanceService{
    
    @Autowired
    private final  AttendanceRepository  attendanceRepository;

    @Override
    public Attendance findInfo(String current_id) {
    	Attendance account = attendanceRepository.findInfo(current_id);
    	return account;
    }

	@Override
	public int AttendanceInfo(AttendanceInfo attendanceInfo) {
		int result = attendanceRepository.AttendanceInfo(attendanceInfo);

		return result;
	}
}
