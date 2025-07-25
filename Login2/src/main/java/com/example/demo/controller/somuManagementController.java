package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.Export;
import com.example.demo.form.LoginForm;
import com.example.demo.service.ExportService;
import com.example.demo.session.UserSession;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor // Lombokを使用してコンストラクタを自動生成
public class somuManagementController {
	private final UserSession userSession; // DIによる注入
    private final ExportService exportService; // DIによる注入
    
	
	String departmentID = "";
	
	@GetMapping("/somuMenu")
    public String somuMenu(@ModelAttribute LoginForm loginForm, Model model, RedirectAttributes redirectAttributes) {
	    System.out.println("somuMenuメソッドの開始");
	    departmentID = (String) model.asMap().get("departmentID");
	    redirectAttributes.addFlashAttribute("departmentID", departmentID);
//	    model.addAttribute("departmentID", departmentID);
	    System.out.println("総務メニューのdepartmentID" + departmentID);
	    return "somuMenu";
	}
	
	@GetMapping("/toAttendance")
	public String toAttendance(RedirectAttributes redirectAttributes, Model model) {
	    System.out.println("toAttendanceメソッドの開始");
	    System.out.println("toAttendance:" + departmentID);

	    // Flash属性にセット（リダイレクト先に渡す）
	    redirectAttributes.addFlashAttribute("departmentID", departmentID);

	    // /attendance にリダイレクト
	    return "redirect:/attendance";
	}

	
	@GetMapping("/attendanceManagement")
    public String attendanceManagement(@ModelAttribute LoginForm loginForm) {
	    System.out.println("attendanceManagementメソッドの開始");
	    return "attendanceManagement";
	}
	
	@GetMapping("/fileExport")
    public String fileExport(@ModelAttribute LoginForm loginForm,Model model) {
	    System.out.println("fileメソッドの開始");
	    List<Export> allEmployees = exportService.execute(userSession.getEmployee_id());
	    System.out.println("コントローラー:::"+allEmployees);
	    
	    model.addAttribute("employees", allEmployees);
	    
	    return "fileExport";
	}
	
}