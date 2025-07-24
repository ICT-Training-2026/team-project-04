package com.example.demo.repository;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Attendance;
import com.example.demo.entity.AttendanceInfo;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class AttendanceRepositoryImpl implements AttendanceRepository {
    public final JdbcTemplate jdbcTemplate;

    @Override
    public Attendance findInfo(String current_id) {
    	String sql = "SELECT employee_id,employee_name,employee.department_code,department.department_name FROM employee inner join department on employee.department_code = department.department_code WHERE employee_id = ?";
    	List<Map<String, Object>> list = jdbcTemplate.queryForList(sql,current_id);

        if (list.isEmpty()) {
            return null;
        }

        Map<String, Object> one = list.get(0);
        Attendance account = new Attendance();
        account.setEmployee_id((String) one.get("employee_id"));
        account.setEmployee_name((String) one.get("employee_name"));
        account.setDepartment_code((String) one.get("department_code"));
        account.setDepartment_name((String) one.get("department_name"));
        
        System.out.print(account);
        return account;
	}

	@Override
	public int AttendanceInfo(AttendanceInfo attendanceInfo) {
		
		String sql = "INSERT INTO attendance(attendance_date, employee_id, attendance_type_code, clock_in_time, clock_out_time, rest_minute, actual_working_minute, used_paid_leave_days, remaining_paid_leave_days) VALUES (?,?,?,?,?,?, (SELECT MAX(actual_working_minute) FROM attendance WHERE employee_id = ?) + TIMESTAMPDIFF(MINUTE, ?, ?)  - ? AS actual_working_minute, (SELECT MAX(used_paid_leave_days) FROM attendance WHERE employee_id = ?) AS used_paid_leave_days,(SELECT MIN(remaining_paid_leave_days) FROM attendance WHERE employee_id = ?) AS remaining_paid_leave_days)";
    	int result = jdbcTemplate.update(sql,attendanceInfo.getAttendance_date(), attendanceInfo.getEmployee_id(), attendanceInfo.getAttendance_type_code(), attendanceInfo.getClock_in_time(), attendanceInfo.getClock_out_time(), attendanceInfo.getRest_minute() ,attendanceInfo.getEmployee_id(), attendanceInfo.getClock_out_time(),attendanceInfo.getClock_in_time(),attendanceInfo.getRest_minute(),attendanceInfo.getEmployee_id(),attendanceInfo.getEmployee_id());
    	if(result > 0){
    	    System.out.println("データが正常に挿入されました。");
    	    return 0;
    	} else {
    	    System.out.println("データの挿入に失敗しました。");
    	    return 1;
    	}
	}



   
}