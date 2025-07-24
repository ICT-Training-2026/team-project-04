package com.example.demo.entity;

import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Attendance {
	
	private String workType;
	private String workDate;
	private LocalTime startTimeHour;
	private LocalTime startTimeMinute;
	private LocalTime endTimeHour;
	private LocalTime endTimeMinute;
	private double breakTime;

}