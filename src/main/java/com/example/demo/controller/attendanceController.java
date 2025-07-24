package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Attendance;
import com.example.demo.entity.AttendanceInfo;
import com.example.demo.form.AttendanceForm;
import com.example.demo.service.AttendanceService;
import com.example.demo.session.UserSession; // 追加

import lombok.RequiredArgsConstructor;
@Controller
@RequiredArgsConstructor // Lombokを使用してコンストラクタを自動生成
public class attendanceController { // クラス名を修正

    private final UserSession userSession; // DIによる注入
    private final AttendanceService attendance; // DIによる注入
    
	@GetMapping("/attendance")
    public String attendance(@ModelAttribute AttendanceForm attendanceForm,Model model) {
    	System.out.println("勤怠登録画面への遷移が成功");
        System.out.println(attendanceForm.getWorkType());

    	String current_id = userSession.getEmployee_id();	//現ユーザーのemployee_idをゲットする！！！！！！！
    	Attendance account = attendance.findInfo(current_id);
    	model.addAttribute("currentInfo", account);
        return "attendance";
        
        
    }
	
	
	
	@PostMapping("/attendance")
	public String submitAttendance(@Validated @ModelAttribute AttendanceForm attendanceForm, BindingResult result, Model model) {
		System.out.println("勤務登録メソッドの開始");
        System.out.println(attendanceForm.getWorkType());
        System.out.println(attendanceForm.getAttendanceDate());
        
        if (result.hasErrors()) {
            return "attendance"; // エラーがある場合、フォームに戻る
        }
        else {
        	AttendanceInfo att = new AttendanceInfo(userSession.getEmployee_id(),attendanceForm.getWorkType(),attendanceForm.getAttendanceDate(),attendanceForm.getStartHour(),attendanceForm.getStartMinute(),attendanceForm.getEndHour(),attendanceForm.getEndMinute(),attendanceForm.getBreakTime());
        	int RIP = attendance.AttendanceInfo(att);
        	if(RIP > 0) {
        		 return "attendance";
        	}else {
        		model.addAttribute("attendanceDate", attendanceForm.getAttendanceDate());
        		
        		return "complete";
        	}        	 
        }
	}
	
}