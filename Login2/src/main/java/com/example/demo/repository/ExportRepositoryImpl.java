package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Export;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ExportRepositoryImpl implements ExportRepository {
    public final JdbcTemplate jdbcTemplate;

    
	@Override
	public List<Export> Exinfo(String userId) {
		String sql = "SELECT e.employee_id,e.employee_name,d.department_name,MAX(a.actual_working_minutes) AS max_working_minutes FROM employee AS e INNER JOIN department AS d on e.department_code = d.department_code INNER JOIN attendance AS a on e.employee_id = a.employee_id GROUP BY"
				+ "    e.employee_id, e.employee_name, d.department_name";
    	List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);

        if (list.isEmpty()) {
            return null;
        }
        List<Export> ex =new ArrayList<Export>();
        for (Map<String, Object> result : list) {
            Export account = new Export();
            account.setEmployee_id((String) result.get("employee_id"));
            account.setEmployee_name((String) result.get("employee_name"));
            account.setDepartment_name((String) result.get("department_name"));

            // Nullチェックとデフォルト値の設定
            Integer actualWorkingMinutes = (Integer) result.get("max_working_minutes");
            if (actualWorkingMinutes != null) {
                account.setActual_working_minutes(actualWorkingMinutes);
            } else {
                account.setActual_working_minutes(0); // デフォルト値を設定
            }

            ex.add(account);
        }
		System.out.println("レポジトリー:::"+ex);
		return ex;
	}


//	@Override
//	public int AttendanceInfo(AttendanceInfo attendanceInfo) {
//
//		//最も大きい有休取得日数を取得
//		String sql1 = "SELECT MAX(used_paid_leave_days) FROM attendance WHERE employee_id = ?;";
//		Integer paid = jdbcTemplate.queryForObject(sql1, Integer.class, attendanceInfo.getEmployee_id());
//
//		
//		//最も小さい有休残り日数を取得
//		String sql2 = "SELECT MAX(remaining_paid_leave_days) "
//				+ " FROM attendance "
//				+ " WHERE employee_id = ?;";
//		Integer remai = jdbcTemplate.queryForObject(sql2, Integer.class, attendanceInfo.getEmployee_id());
//		
//		String sql3 = "INSERT INTO attendance (attendance_date,employee_id,attendance_type_code,clock_in_time,clock_out_time,rest_minutes,actual_working_minutes,used_paid_leave_days, remaining_paid_leave_days) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
//
//	    int result = jdbcTemplate.update(sql3,attendanceInfo.getAttendance_date(), attendanceInfo.getEmployee_id(), attendanceInfo.getAttendance_type_code(), attendanceInfo.getClock_in_time(), attendanceInfo.getClock_out_time(), attendanceInfo.getRest_minute(),attendanceInfo.getActual_working_minute(),paid,remai);
//    	
//		if(result > 0){
//    	    System.out.println("データが正常に挿入されました。");
//    	    return 0;
//    	} else {
//    	    System.out.println("データの挿入に失敗しました。");
//    	    return 1;
//    	}
//	}
}