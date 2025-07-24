package com.example.demo.repository;

import com.example.demo.entity.Account;
import com.example.demo.entity.Login;

public interface AccountsRepository {
    Account findByLogin(Login login);
    boolean createBySignUp(Account account);
}
