package com.example.demo.repository;

import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Edit;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class AttendanceEditRepositoryImpl implements AttendanceEditRepository {
	
	private final JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Edit> EditByAttendance(String employeeId) {
		
		String sql = 
				"  SELECT                     " + 
				"    attendance_date,         " + 
				"    clock_in_time,           " + 
				"    clock_out_time,          " + 
				"    actual_working_minutes,  " + 
				"    rest_minutes,            " + 
				"    attendance_type_code     " + 
				"  FROM                       " + 
				"    attendance               " + 
				"  WHERE                      " + 
				"    employee_id = ?        " + 
				"  ORDER BY                   " + 
				"    attendance_date ASC     ";
		
		// SQLで検索（プレースホルダ：引数で受け取ったrestaurantId）
		List<Map<String, Object>> list 
						= jdbcTemplate.queryForList(sql, employeeId);
		
		// 値の取得⇒結果の格納
		
		List<Edit> result = new ArrayList<Edit>(); // 結果の初期化
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // 日付フォーマット
		
		for (Map<String, Object> one : list) {
			Edit review = new Edit();
			// attendance_dateをjava.sql.Dateとして取得
	        Date attendanceDate = (Date) one.get("attendance_date");
	        // 必要に応じてStringに変換
	        review.setAttendance_date(attendanceDate != null ? dateFormat.format(attendanceDate) : null);
			//review.setAttendance_date((String)one.get("attendance_date"));
	        
	        Time clockInTime = (Time) one.get("clock_in_time");
	        System.out.println("clockInTime:" + clockInTime);
	        review.setClock_in_time(clockInTime != null ? clockInTime.toString() : null);
	        
	        Time clockOutTime = (Time) one.get("clock_out_time");
	        System.out.println("clockOutTime:" + clockOutTime);
	        review.setClock_out_time(clockOutTime != null ? clockOutTime.toString() : null);

			review.setActual_working_minutes((Integer)one.get("actual_working_minutes"));
			review.setRest_minutes((Integer)one.get("rest_minutes"));
			review.setAttendance_type_code((String)one.get("attendance_type_code"));
			result.add(review);
		}

		return result;

	}

}
