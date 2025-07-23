package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Attendance;
import com.example.demo.form.AttendanceForm;
import com.example.demo.form.LoginForm;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AttendanceController {
	
	@GetMapping("/attendance")
    public String attendance(@ModelAttribute LoginForm loginForm) {
    	System.out.println("勤怠登録画面への遷移が成功");
        return "attendance";
    }
	
	@PostMapping("/attendance")
    public String attendancePost(@Validated @ModelAttribute AttendanceForm attendanceForm, BindingResult result, Model model) {
	    System.out.println("attendancePostメソッドの開始");
	   
	    if (result.hasErrors()) {
	    	return "attendance";
	    }

        Attendance attendance = new Attendance(attendanceForm.getWorkType(), attendanceForm.getWorkDate(), null, null, null, null, 0);
//        boolean resultLogin = loginService.execute(login);
        boolean resultLogin = true;
       
        if (resultLogin) { // ログイン成功時
            // Modelにユーザー情報を追加
//            model.addAttribute("userId", loginForm.getUserId());
            return "generalMenu";
        } else { // ログイン失敗時
            model.addAttribute("errorMessage", "ユーザーIDまたはパスワードが間違っています。");
            return "login";
        }
    }
	
}