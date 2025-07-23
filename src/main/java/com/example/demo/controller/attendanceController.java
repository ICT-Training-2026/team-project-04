package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.demo.entity.Attendance;
import com.example.demo.form.LoginForm;
import com.example.demo.service.AttendanceService;
import com.example.demo.session.UserSession; // 追加

import lombok.RequiredArgsConstructor;
@Controller
@RequiredArgsConstructor // Lombokを使用してコンストラクタを自動生成
public class attendanceController { // クラス名を修正

    private final UserSession userSession; // DIによる注入
    private final AttendanceService attendance; // DIによる注入
    
    
	@GetMapping("/attendance")
    public String attendance(@ModelAttribute LoginForm loginForm,Model model) {
    	System.out.println("勤怠登録画面への遷移が成功");
    	String current_id = userSession.getEmployee_id();	//現ユーザーのemployee_idをゲットする！！！！！！！
    	
    	Attendance account = attendance.findInfo(current_id);
    	
    	model.addAttribute("currentInfo", account);

        System.out.print(account);
        return "attendance";
    }
	
}