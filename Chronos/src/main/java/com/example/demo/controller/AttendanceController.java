//package com.example.demo.controller;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import com.example.demo.entity.Attendance;
//import com.example.demo.entity.AttendanceInfo;
//import com.example.demo.form.AttendanceForm;
//import com.example.demo.service.AttendanceService;
//import com.example.demo.session.UserSession;
//
//import lombok.RequiredArgsConstructor;
//
//@Controller
//@RequiredArgsConstructor
//public class AttendanceController {
//	
//	private final UserSession userSession; // DIによる注入
//	private final AttendanceService attendance; // DIによる注入
//	
//	@GetMapping("/attendance")
//	public String attendance(@Validated @ModelAttribute("departmentID") String departmentID, AttendanceForm attendanceForm, BindingResult result, Model model) {
//	    System.out.println("勤怠登録画面への遷移が成功");
//	    System.out.println("受け取ったdepartmentID: " + departmentID);
//
//	    // 必要であれば model に再セットして画面に渡す
//	    model.addAttribute("departmentID", departmentID);
//	    String current_id = userSession.getEmployee_id();	//現ユーザーのemployee_idをゲットする！！！！！！！
//    	System.out.print(current_id);
//	    Attendance account = attendance.findInfo(current_id);
//    	model.addAttribute("currentInfo", account);
//
//	    return "attendance";
//	}
//	
//	@PostMapping("/attendance")
//    public String attendancePost(@Validated @ModelAttribute AttendanceForm attendanceForm, BindingResult result, Model model) {
//	    System.out.println("attendancePostメソッドの開始");
//	   
//	    if (result.hasErrors()) {
//	    	System.out.println("erorr");
//            return "attendance"; // エラーがある場合、フォームに戻る
//            
//        }
//        else {
//        	System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
//        	AttendanceInfo att = new AttendanceInfo(userSession.getEmployee_id(),attendanceForm.getWorkType(),attendanceForm.getWorkDate(),attendanceForm.getStartTimeHour(),attendanceForm.getStartTimeMinute(),attendanceForm.getEndTimeHour(),attendanceForm.getEndTimeMinute(),attendanceForm.getBreakTime());
//        	System.out.println("もうだめだーーーー");
//        	int RIP = attendance.AttendanceInfo(att);
//        	if(RIP > 0) {
//        		System.out.println("bbbbbbbbbbbbbbbbbbbbb");
//        		 return "attendance";
//        	}else {
//        		model.addAttribute("attendanceDate", attendanceForm.getWorkDate());
//        		System.out.println("ccccccccccccccccccccccccccc");
//        		return "complete";
//        	}        	 
//        }
//	}
	
//}

package com.example.demo.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Attendance; // 既存のAttendanceエンティティ
import com.example.demo.entity.AttendanceInfo; // 既存のAttendanceInfoエンティティ
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
        String current_id = userSession.getEmployee_id(); // 現ユーザーのemployee_idをゲットする
        System.out.print("現在の従業員ID: " + current_id);
        // 従業員の詳細情報を取得し、モデルに追加
        Attendance account = attendance.findInfo(current_id);
        model.addAttribute("currentInfo", account);
        // フォームオブジェクトがモデルに存在しない場合、新しく追加
        if (!model.containsAttribute("attendanceForm")) {
            model.addAttribute("attendanceForm", new AttendanceForm());
        }
        return "attendance";
    }
    @PostMapping("/attendance")
    public String attendancePost(@Validated @ModelAttribute AttendanceForm attendanceForm, BindingResult result, Model model) {
        System.out.println("attendancePostメソッドの開始");
        // バリデーションエラーがある場合
        if (result.hasErrors()) {
            System.out.println("バリデーションエラーが発生しました。");
            // エラーメッセージを画面に表示するために、必要な情報をモデルに再追加
            String current_id = userSession.getEmployee_id();
            Attendance account = attendance.findInfo(current_id);
            model.addAttribute("currentInfo", account);
            // departmentIDも再設定しないと、ヘッダーの表示がおかしくなる可能性があります
            // これは@GetMappingで departmentID を受け取っているため、@PostMappingでも同様に処理が必要です
            // もしくは、セッションや隠しフィールドで departmentID を保持するように設計変更
            // ここでは仮に、セッションから取得する、あるいはフォームに隠しフィールドで持たせることを想定
            // 例: model.addAttribute("departmentID", userSession.getDepartmentId());
            // 今回のコードではdepartmentIDをフォームから直接受け取っていないため、セッションから取得するか、
            // フォームにdepartmentIDを追加することを検討してください。
            // 暫定的に、departmentIDがnullの場合に備えてデフォルト値を設定
            //model.addAttribute("departmentID", userSession.getDepartment_id() != null ? userSession.getDepartment_id() : "default");
            return "attendance"; // エラーがある場合、フォームに戻る
        } else {
            System.out.println("バリデーション成功。勤怠情報の登録を開始します。");
            // AttendanceInfoオブジェクトを作成
            AttendanceInfo att = new AttendanceInfo(
                userSession.getEmployee_id(),
                attendanceForm.getWorkType(),
                attendanceForm.getWorkDate(),
                attendanceForm.getStartTimeHour(),
                attendanceForm.getStartTimeMinute(),
                attendanceForm.getEndTimeHour(),
                attendanceForm.getEndTimeMinute(),
                attendanceForm.getBreakTime()
            );
            // 勤怠情報をデータベースに登録
            int RIP = attendance.AttendanceInfo(att);
            System.out.println("RIP:" + RIP);
            // 登録結果の判定
            if (RIP == 0) {
                System.out.println("勤怠情報の登録が成功しました。complete画面へ遷移します。");
                // 成功した場合、complete画面に遷移
                model.addAttribute("attendanceDate", attendanceForm.getWorkDate()); // complete画面で表示するために日付を渡す
                return "complete"; // 登録成功時はcomplete画面へ遷移
            } else {
                System.out.println("勤怠情報の登録に失敗しました（RIP <= 0）。attendance画面に留まります。");
                // 登録に失敗した場合（RIPが0以下）、attendance画面に留まる
                // エラーメッセージをユーザーに表示するための処理を追加することを検討
                model.addAttribute("errorMessage", "勤怠情報の登録に失敗しました。再度お試しください。");
                // 画面に表示するために、必要な情報をモデルに再追加
                String current_id = userSession.getEmployee_id();
                Attendance account = attendance.findInfo(current_id);
                model.addAttribute("currentInfo", account);
                //model.addAttribute("departmentID", userSession.getDepartment_id() != null ? userSession.getDepartment_id() : "default");
                return "attendance";
            }
        }
    }
}