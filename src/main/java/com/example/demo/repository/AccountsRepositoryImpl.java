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
        String sql = "SELECT USER_ID, PASS, MAIL, NAME, AGE FROM ACCOUNTS WHERE USER_ID = ? AND PASS = ?";

        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, login.getUserId(), login.getPass());

        if (list.isEmpty()) {
            return null;
        }

        Map<String, Object> one = list.get(0);
        Account account = new Account();
        account.setUserId((String) one.get("USER_ID"));
        account.setPass((String) one.get("PASS"));
        account.setMail((String) one.get("MAIL"));
        account.setName((String) one.get("NAME"));
        account.setAge((int) one.get("AGE"));

        return account;
    }

    @Override
    public boolean createBySignUp(Account account) {
        String sql = "INSERT INTO ACCOUNTS (USER_ID, PASS, MAIL, NAME, AGE) VALUES (?, ?, ?, ?, ?)";

        int result = jdbcTemplate.update(sql,
            account.getUserId(),
            account.getPass(),
            account.getMail(),
            account.getName(),
            account.getAge());

        return result == 1;
    }
}