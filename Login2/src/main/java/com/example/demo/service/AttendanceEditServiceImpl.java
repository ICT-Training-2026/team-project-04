package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Edit;
import com.example.demo.repository.AttendanceEditRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AttendanceEditServiceImpl implements AttendanceEditService {
	
	private final AttendanceEditRepository repository;
	
	@Override
	public List<Edit> execute(String employeeId) {
		List<Edit> list = repository. EditByAttendance(employeeId);
		
		return list;
	}

}
