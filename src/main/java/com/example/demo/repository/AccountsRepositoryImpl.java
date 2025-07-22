package com.example.demo.repository;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Account;
import com.example.demo.entity.Login;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class AccountsRepositoryImpl implements AccountsRepository {
    public final JdbcTemplate jdbcTemplate;

    @Override
    public Account findByLogin(Login login) {
        String sql = "SELECT employee_id, employee_name, pass, department_code, position_code, email FROM employee WHERE employee_id = ? AND pass = ?";

        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, login.getEmployee_id(), login.getPass());

        if (list.isEmpty()) {
            return null;
        }

        Map<String, Object> one = list.get(0);
        Account account = new Account();
        account.setEmployee_id((String) one.get("employee_id"));
        account.setPass((String) one.get("pass"));
        account.setDepartment_code((String) one.get("department_code"));
        account.setPosition_code((String) one.get("position_code"));
        account.setEmail((String) one.get("email"));


        return account;
    }

    @Override
    public boolean createBySignUp(Account account) {
        String sql = "INSERT INTO ACCOUNTS (USER_ID, PASS, MAIL, NAME, AGE) VALUES (?, ?, ?, ?, ?)";

        int result = jdbcTemplate.update(sql,
            account.getEmployee_id(),
            account.getPass());

        return result == 1;
    }
}