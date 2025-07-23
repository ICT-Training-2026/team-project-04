package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.demo.form.LoginForm;

@Controller
public class userRegistController {
	
	@GetMapping("/userRegist")
    public String userRegist(@ModelAttribute LoginForm loginForm) {
	    System.out.println("userRegistメソッドの開始");
	    return "userRegist";
	}
	
}
