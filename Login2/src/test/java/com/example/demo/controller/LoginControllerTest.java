package com.example.demo.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import com.example.demo.entity.Login;
import com.example.demo.form.LoginForm;
import com.example.demo.service.LoginService;

@DisplayName("LoginControllerのテスト")
class LoginControllerTest {

    private LoginController loginController;
    private LoginForm loginForm;
    private Model model;

    // テスト用のLoginServiceスタブクラス
    private static class TestLoginService implements LoginService {
        private boolean returnValue;

        public void setReturnValue(boolean returnValue) {
            this.returnValue = returnValue;
        }

        @Override
        public boolean execute(Login login) {
            return returnValue;
        }
    }

    @BeforeEach
    void setUp() {
        TestLoginService testLoginService = new TestLoginService();
        loginController = new LoginController(testLoginService);
        
        loginForm = new LoginForm();
        loginForm.setUserId("testUser");
        loginForm.setPass("testPass");
        
        model = new ExtendedModelMap();
    }

    @Test
    @DisplayName("GETリクエストで\"login\"が返される")
    void testLogin_ReturnsLoginView() {
    	
        String result = loginController.login(loginForm);
        
        assertEquals("login", result);
    }

    @Test
    @DisplayName("LoginServiceのexecute()がtrueを返す場合、\"loginOK\"が返される")
    void testLoginPost_WhenLoginServiceReturnsTrue_ReturnsLoginOKView() {
        
    	TestLoginService testLoginService = new TestLoginService();
        testLoginService.setReturnValue(true);
        loginController = new LoginController(testLoginService);

        String result = loginController.loginPost(loginForm, model);

        assertEquals("loginOK", result);
    }

    @Test
    @DisplayName("LoginServiceのexecute()がtrueを返す場合、モデルにユーザー情報が設定される")
    void testLoginPost_WhenLoginServiceReturnsTrue_AddsUserIdToModel() {
        
    	TestLoginService testLoginService = new TestLoginService();
        testLoginService.setReturnValue(true);
        loginController = new LoginController(testLoginService);

        loginController.loginPost(loginForm, model);

        assertEquals("testUser", model.asMap().get("userId"));
        assertFalse(model.asMap().containsKey("errorMessage"));
    }

    @Test
    @DisplayName("LoginServiceのexecute()がfalseを返す場合、\"login\"が返される")
    void testLoginPost_WhenLoginServiceReturnsFalse_ReturnsLoginView() {
        
    	TestLoginService testLoginService = new TestLoginService();
        testLoginService.setReturnValue(false);
        loginController = new LoginController(testLoginService);

        String result = loginController.loginPost(loginForm, model);

        assertEquals("login", result);
    }

    @Test
    @DisplayName("LoginServiceのexecute()がfalseを返す場合、モデルにエラーメッセージが設定される")
    void testLoginPost_WhenLoginServiceReturnsFalse_AddsErrorMessageToModel() {
        
    	TestLoginService testLoginService = new TestLoginService();
        testLoginService.setReturnValue(false);
        loginController = new LoginController(testLoginService);

        loginController.loginPost(loginForm, model);

        assertEquals("ユーザーIDまたはパスワードが間違っています。", model.asMap().get("errorMessage"));
        assertFalse(model.asMap().containsKey("userId"));
    }
}