//package com.example.demo.controller;
//
//import java.util.List;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.example.demo.entity.Edit;
//import com.example.demo.service.AttendanceEditService;
//import com.example.demo.session.UserSession;
//
//import lombok.RequiredArgsConstructor;
//
//@Controller
//@RequiredArgsConstructor
//public class AttendanceEditController {
//	
//	private final AttendanceEditService service;
//	private final UserSession userSession;
//	
//	@GetMapping("/attendanceEdit")
//	public String attendanceEdit(@RequestParam("employee_id") String employeeId, Model model) {
//	    System.out.println("勤怠実績画面への遷移が成功");
//	    String tmp = userSession.getEmployee_id();
//	    System.out.println("Employee IDaaaaaaaaaaaaa: " + tmp);
//	    System.out.println("Employee ID: " + employeeId);
//	    
//	    //データベースから取得したデータを格納するlist
//	    List<Edit> list = service.execute(employeeId);
//	    System.out.println(list);
//	    model.addAttribute("attendanceList", list);
//	    model.addAttribute("employeeID", employeeId);
//	    
//	    return "oldAttendance";
//	}
//	
//	@GetMapping("/completeCorrection")
//	private String completeCorrection() {
//		return "completeCorrection";
//	}
//	
//	@GetMapping("/applicationPermission")
//	private String applicationPermission() {
//		return "applicationPermission";
//	}
//	
//}
package com.example.demo.controller;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes; // RedirectAttributesをインポート

import com.example.demo.entity.Edit;
import com.example.demo.form.FindIdForm; // 新しく作成したフォームクラスをインポート
import com.example.demo.service.AttendanceEditService;
import com.example.demo.session.UserSession;

import lombok.RequiredArgsConstructor;
@Controller
@RequiredArgsConstructor
public class AttendanceEditController {
	
	private final AttendanceEditService service;
	private final UserSession userSession;
	
    /**
     * 勤怠管理画面（検索フォーム）の初期表示を処理します。
     * ユーザーがこのページにGETリクエストでアクセスした際に呼び出されます。
     * @param model ビューにデータを渡すためのModelオブジェクト
     * @return 勤怠管理画面のビュー名
     */
    @GetMapping("/attendanceManagement") // 勤怠管理画面のGETリクエストパス
    public String showAttendanceManagement(Model model) {
        System.out.println("勤怠管理画面への遷移が成功 (GET)");
        // 検索フォームオブジェクトをモデルに追加し、初期化
        model.addAttribute("findId", new FindIdForm());
        return "att_mag"; // att_mag.html テンプレートを返します
    }
    /**
     * 勤怠管理画面から社員番号検索フォームのPOSTリクエストを処理します。
     * 入力された社員番号を/attendanceEditにリダイレクトして渡します。
     * @param findId フォームから送信された社員番号を保持するFindIdFormオブジェクト
     * @param redirectAttributes リダイレクト先に属性を追加するためのRedirectAttributesオブジェクト
     * @return /attendanceEditへのリダイレクトパス
     */
	@PostMapping("/findAttendance")
	public String findAttendance(@ModelAttribute FindIdForm findId, RedirectAttributes redirectAttributes) {
	    String kensakuId = findId.getKensaku_id(); // フォームからkensaku_idを取得
	    System.out.println("検索ID (kensaku_id) を受け取りました: " + kensakuId);
	    // kensaku_id を employee_id という名前で /attendanceEdit にクエリパラメータとしてリダイレクト
	    redirectAttributes.addAttribute("employee_id", kensakuId);
	    return "redirect:/attendanceEdit"; // /attendanceEditへのリダイレクト
	}
    /**
     * 勤怠実績画面を表示し、指定された社員IDの勤怠データを取得します。
     * @param employeeId URLクエリパラメータから渡される社員ID（任意）
     * @param model ビューにデータを渡すためのModelオブジェクト
     * @return 勤怠実績画面のビュー名
     */
	@GetMapping("/attendanceEdit")
	public String attendanceEdit(@RequestParam(name = "employee_id", required = false) String employeeId, Model model) {
	    System.out.println("勤怠実績画面への遷移が成功");
	    String tmpEmployeeId; // 最終的に検索に使用する社員ID
	   
	    // employeeIdがURLパラメータで提供されていない、または空の場合、セッションから取得
	    if (employeeId == null || employeeId.isEmpty()) {
	    	tmpEmployeeId = userSession.getEmployee_id(); // ログイン中のユーザーID
	    	System.out.println("URLパラメータにemployee_idがないため、セッションからIDを取得: " + tmpEmployeeId);
	    } else {
	    	tmpEmployeeId = employeeId; // URLパラメータから取得したIDを使用
	    	System.out.println("URLパラメータからemployee_idを取得: " + tmpEmployeeId);
	    }
	   
	    System.out.println("最終的な検索対象Employee ID: " + tmpEmployeeId);
	  
	    // データベースから取得したデータを格納するリスト
	    List<Edit> list = service.execute(tmpEmployeeId);
	    System.out.println("取得した勤怠実績リスト: " + list);
	   
	    model.addAttribute("attendanceList", list); // 勤怠実績リストをモデルに追加
	    model.addAttribute("employeeID", tmpEmployeeId); // 検索対象の社員IDをモデルに追加
	  
	    return "oldAttendance"; // oldAttendance.html テンプレートを返します
	}
	
    /**
     * 修正完了画面を表示します。
     * @return 修正完了画面のビュー名
     */
	@GetMapping("/completeCorrection")
	private String completeCorrection() {
		return "completeCorrection";
	}
	
    /**
     * 申請許可画面を表示します。
     * @return 申請許可画面のビュー名
     */
	@GetMapping("/applicationPermission")
	private String applicationPermission() {
		return "applicationPermission";
	}
}
