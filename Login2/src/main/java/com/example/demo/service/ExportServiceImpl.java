
package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Account;
import com.example.demo.entity.Export;
import com.example.demo.repository.ExportRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class  ExportServiceImpl implements ExportService{
    
    @Autowired
    private final ExportRepository exportRepository;

	@Override
	public List<Account> execute(String userId) {
		List<Export> list = exportRepository.Exinfo(userId);
		
		return list;
	}
}