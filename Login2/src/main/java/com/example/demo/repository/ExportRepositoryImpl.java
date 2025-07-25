package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.AttendanceInfo;
import com.example.demo.entity.Export;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ExportRepositoryImpl implements ExportRepository {
    public final JdbcTemplate jdbcTemplate;

    
	@Override
	public List<Export> Exinfo(String userId) {
		String sql = "SELECT employee_id,employee_name,department.department_name FROM employee inner join department on employee.department_code = department.department_code WHERE employee_id = ?";
    	List<Map<String, Object>> list = jdbcTemplate.queryForList(sql,userId);

        if (list.isEmpty()) {
            return null;
        }
        
        List<Export> ex =new ArrayList<Export>();
		for(Map<String,Object> result:list) {
	        Export account = new Export();
	        account.setEmployee_id((String) result.get("employee_id"));
	        account.setEmployee_name((String) result.get("employee_name"));
	        account.setDepartment_name((String) result.get("department_name"));
	        ex.add(account);
		}
		return ex;
	}


	@Override
	public int AttendanceInfo(AttendanceInfo attendanceInfo) {

		//最も大きい有休取得日数を取得
		String sql1 = "SELECT MAX(used_paid_leave_days) FROM attendance WHERE employee_id = ?;";
		Integer paid = jdbcTemplate.queryForObject(sql1, Integer.class, attendanceInfo.getEmployee_id());

		
		//最も小さい有休残り日数を取得
		String sql2 = "SELECT MAX(remaining_paid_leave_days) "
				+ " FROM attendance "
				+ " WHERE employee_id = ?;";
		Integer remai = jdbcTemplate.queryForObject(sql2, Integer.class, attendanceInfo.getEmployee_id());
		
		String sql3 = "INSERT INTO attendance (attendance_date,employee_id,attendance_type_code,clock_in_time,clock_out_time,rest_minutes,actual_working_minutes,used_paid_leave_days, remaining_paid_leave_days) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

	    int result = jdbcTemplate.update(sql3,attendanceInfo.getAttendance_date(), attendanceInfo.getEmployee_id(), attendanceInfo.getAttendance_type_code(), attendanceInfo.getClock_in_time(), attendanceInfo.getClock_out_time(), attendanceInfo.getRest_minute(),attendanceInfo.getActual_working_minute(),paid,remai);
    	
		if(result > 0){
    	    System.out.println("データが正常に挿入されました。");
    	    return 0;
    	} else {
    	    System.out.println("データの挿入に失敗しました。");
    	    return 1;
    	}
	}
}