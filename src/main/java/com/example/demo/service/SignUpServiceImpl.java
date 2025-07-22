package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Account;
import com.example.demo.repository.AccountsRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SignUpServiceImpl implements SignUpService{
    
    @Autowired
    private final AccountsRepository accountsRepository;

    @Override
    public boolean execute(Account account) {
        boolean result = accountsRepository.createBySignUp(account);
        return result;
    }
}