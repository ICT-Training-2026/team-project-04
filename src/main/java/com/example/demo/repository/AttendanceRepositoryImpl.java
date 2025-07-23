package com.example.demo.repository;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Attendance;

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

   
}