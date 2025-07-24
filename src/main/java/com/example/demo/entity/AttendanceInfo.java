package com.example.demo.entity;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AttendanceInfo {
	private String employee_id;
    private LocalDate attendance_date;
    private String attendance_type_code;
    private LocalTime clock_in_time;
    private LocalTime clock_out_time;
    private int rest_minute;
    private int actual_working_minute;
    private String used_paid_leave_days;
    private String remaining_paid_leave_days;
    public AttendanceInfo(
    		String current_id,
    		String workType,
    		LocalDate attendanceDate,
    		String startHour,
    		String startMinute,
    		String endHour,
    		String endMinut,
    		Double breakTime) {
    	this.employee_id = current_id;
		this.attendance_date = attendanceDate;
		this.attendance_type_code = workType;
		// 文字列を整数に変換
        int hour = Integer.parseInt(startHour);
        int minute = Integer.parseInt(startMinute);
        // LocalTimeオブジェクトを作成
        this.clock_in_time = LocalTime.of(hour, minute);
        hour = Integer.parseInt(endHour);
        minute = Integer.parseInt(endMinut);
        // LocalTimeオブジェクトを作成
        this.clock_out_time = LocalTime.of(hour, minute);
        this.rest_minute = (int) (breakTime * 60);
		// 出勤時間と退勤時間の差分を計算
        Duration duration = Duration.between(this.clock_in_time, this.clock_out_time);
		// 勤怠時間と休憩時間の差分を計算
        int workMinute = ((int) duration.toMinutes() - this.rest_minute);
        // 差分を分単位で取得
        if(workMinute < 0) {
        	throw new IllegalArgumentException("workMinute cannot be negative. Received: " + workMinute);
        }
        this.actual_working_minute = workMinute;
	}
}
