package com.example.demo.form;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import lombok.Data;

@Data
public class LoginForm {
	
	@NotNull(message = "ユーザーIDは必須です")
	@Size(min=6, max=6, message="6桁で指定してください。")
    private String employee_id;
//	private Integer userId;
	
	@NotNull(message = "パスワードは必須です")
	@Size(min=6, max=50, message="6文字から50文字で指定してください。")
    private String pass;
	
//	public LoginForm(Integer userId, String pass) {
//        this.userId = userId;
//        this.pass = pass;
//    }
}
