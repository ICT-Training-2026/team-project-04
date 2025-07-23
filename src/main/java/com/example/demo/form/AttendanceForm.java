package com.example.demo.form;

import java.time.LocalDate;

import lombok.Data;

@Data
public class AttendanceForm {
	

    private String workType;        // 勤務形態
    private LocalDate attendanceDate; // 出勤日
    private String startHour;       // 開始時間（時）
    private String startMinute;     // 開始時間（分）
    private String endHour;         // 終了時間（時）
    private String endMinute;       // 終了時間（分）
    private Double breakTime;       // 休憩時間（時間）
}
