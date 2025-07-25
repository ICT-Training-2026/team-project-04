package com.example.demo.controller;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;

import jakarta.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Export;
import com.example.demo.service.ExportService;
import com.example.demo.session.UserSession;

import lombok.RequiredArgsConstructor;
@Controller
@RequiredArgsConstructor // Lombokを使用してコンストラクタを自動生成
public class ExportController {
	
	private final UserSession userSession; // DIによる注入
    private final ExportService exportService; // DIによる注入
    
    
	@PostMapping("/export")
	public void exportCSV(@RequestParam(name = "empIds", required = false) List<String> empIds,
	                      HttpServletResponse response) throws IOException {
	    if (empIds == null || empIds.isEmpty()) {
	        response.sendError(HttpServletResponse.SC_BAD_REQUEST, "チェックが選択されていません");
	        return;
	    }
	    // 固定のデータ
	    List<Export> allEmployees = exportService.execute(userSession.getEmployee_id());
	    System.out.println(allEmployees);
	    List<Export> selected = allEmployees.stream()
	        .filter(emp -> empIds.contains(emp.getEmployee_id()))
	        .toList();
	    // レスポンス設定
	    response.setContentType("text/csv; charset=UTF-8");
	    response.setHeader("Content-Disposition", "attachment; filename=selected_employees.csv");
	    // BOM付きUTF-8で出力するためのOutputStreamWriter
	    OutputStreamWriter writer = new OutputStreamWriter(response.getOutputStream(), StandardCharsets.UTF_8);
	    // UTF-8のBOMを先頭に書く（これが超重要！）
	    writer.write('\uFEFF');
	    // CSV出力
	    writer.write("社員番号,名前,所属\n");
	    for (Export emp : selected) {
	        writer.write(String.format("%s,%s,%s,%s\n",
	            emp.getEmployee_id(),
	            emp.getEmployee_name(),
	            emp.getDepartment_name(),
	            emp.getActual_working_minutes()));
	    }
	    writer.flush();
	    writer.close();
	}
}

