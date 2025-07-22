package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Account;
import com.example.demo.entity.Login;
import com.example.demo.repository.AccountsRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService{
    
    @Autowired
    private final AccountsRepository accountsRepository;

    @Override
    public boolean execute(Login login) {
        Account account = accountsRepository.findByLogin(login);
        return account != null;
    }
    
    @Override
    public Account judgeDepartment(Login login) {
    	Account account = accountsRepository.findByLogin(login);
        return account;
    }
}
