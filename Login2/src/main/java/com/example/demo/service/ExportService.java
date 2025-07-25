package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Account;

public interface ExportService {
	List<Account> execute(String export);
}
