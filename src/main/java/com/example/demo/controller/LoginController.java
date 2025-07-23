package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Account;
import com.example.demo.entity.Login;
import com.example.demo.form.LoginForm;
import com.example.demo.service.LoginService;
import com.example.demo.session.UserSession; // 追加

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;
    private final UserSession userSession; // 追加: UserSessionの注入

    @GetMapping("/login")
    public String login(@ModelAttribute LoginForm loginForm) {
        System.out.println("loginメソッドの開始");
        System.out.println(loginForm.getEmployee_id());
        System.out.println(loginForm.getPass());
        return "login";
    }

    @PostMapping("/login")
    public String loginPost(@Validated @ModelAttribute LoginForm loginForm, BindingResult result, Model model) {
        System.out.println("loginPostメソッドの開始");
        System.out.println(loginForm.getEmployee_id());
        System.out.println(loginForm.getPass());

        if (result.hasErrors()) {
            return "login";
        }

        // ログイン処理の実行
        Login login = new Login(loginForm.getEmployee_id(), loginForm.getPass());
        boolean resultLogin = loginService.execute(login);
        Account account = loginService.judgeDepartment(login);
//        System.out.println("部署ID" + account.getDepartment_code());

        // ログイン処理の成否によって処理を分岐
        if (resultLogin) { // ログイン成功時
            // セッションにemployee_idを保存 追加
            userSession.setEmployee_id(loginForm.getEmployee_id());
            if(account.getDepartment_code().equals("D001")) {
                return "somu_template";
            }
            // Modelにユーザー情報を追加（必要に応じて）
            model.addAttribute("employee_id", loginForm.getEmployee_id());
            return "generalMenu";
        } else { // ログイン失敗時
            model.addAttribute("errorMessage", "ユーザーIDまたはパスワードが間違っています。");
            return "login"; // 修正: "generalMenu"から"login"に変更
        }
    }

    @GetMapping("/generalMenu")
    public String generalMenu(@ModelAttribute LoginForm loginForm) {
        System.out.println("generalMenuメソッドの開始");
        return "generalMenu";
    }
}