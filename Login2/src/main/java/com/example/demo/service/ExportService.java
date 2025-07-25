package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Export;

public interface ExportService {
	List <Export> execute(String export);
}
