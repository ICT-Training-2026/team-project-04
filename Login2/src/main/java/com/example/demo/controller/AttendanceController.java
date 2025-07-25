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
import com.example.demo.session.UserSession;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AttendanceController {
	
	private final UserSession userSession; // DIによる注入
	private final AttendanceService attendance; // DIによる注入
	
	@GetMapping("/attendance")
	public String attendance(@Validated @ModelAttribute("departmentID") String departmentID, AttendanceForm attendanceForm, BindingResult result, Model model) {
	    System.out.println("勤怠登録画面への遷移が成功");
	    System.out.println("受け取ったdepartmentID: " + departmentID);

	    // 必要であれば model に再セットして画面に渡す
	    model.addAttribute("departmentID", departmentID);
	    String current_id = userSession.getEmployee_id();	//現ユーザーのemployee_idをゲットする！！！！！！！
    	System.out.print(current_id);
	    Attendance account = attendance.findInfo(current_id);
    	model.addAttribute("currentInfo", account);

	    return "attendance";
	}
	
	@PostMapping("/attendance")
    public String attendancePost(@Validated @ModelAttribute AttendanceForm attendanceForm, BindingResult result, Model model) {
	    System.out.println("attendancePostメソッドの開始");
	   
	    if (result.hasErrors()) {
	    	System.out.println("erorr");
            return "attendance"; // エラーがある場合、フォームに戻る
            
        }
        else {
        	System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        	AttendanceInfo att = new AttendanceInfo(userSession.getEmployee_id(),attendanceForm.getWorkType(),attendanceForm.getWorkDate(),attendanceForm.getStartTimeHour(),attendanceForm.getStartTimeMinute(),attendanceForm.getEndTimeHour(),attendanceForm.getEndTimeMinute(),attendanceForm.getBreakTime());
        	int RIP = attendance.AttendanceInfo(att);
        	if(RIP > 0) {
        		 return "attendance";
        	}else {
        		model.addAttribute("attendanceDate", attendanceForm.getWorkDate());
        		
        		return "complete";
        	}        	 
        }
	}
	
}