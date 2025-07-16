package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloSpringController {
	
	//URLパターン/helloでリクエストが送られるとメソッドを実行する
	@GetMapping("/hello")
	public String hello() {
		//HTMLテンプレートにhello-spring.htmlを指定
		return "hello-spring";
	}
	
}
