package com.example.demo.form;

import jakarta.validation.constraints.NotNull;

import lombok.Data;

@Data
public class SignUpForm {
	@NotNull(message = "ユーザーIDは必須です")
    private String userId;
	@NotNull(message = "パスワードは必須です")
    private String pass;
	@NotNull(message = "メールアドレスは必須です")
    private String mail;
	@NotNull(message = "氏名は必須です")
    private String name;
	@NotNull(message = "年齢は必須です")
    private Integer age;
}