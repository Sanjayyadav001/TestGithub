package com.pages;

import com.baseClass.BasePage;

public class LoginPage extends BasePage{

	
	public void doLogin(String username,String password) {
		
		type("Username_ID",username);
		type("Password_ID",password);
		click("Login_XPATH");
		
	}
}
