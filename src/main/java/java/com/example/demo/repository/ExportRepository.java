package com.example.demo.repository;

import java.util.List;

import com.example.demo.entity.Export;

public interface ExportRepository {
	List<Export> Exinfo(String userId);
}
