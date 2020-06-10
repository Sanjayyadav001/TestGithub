package com.testCases;

import org.testng.annotations.Test;

import com.baseClass.BasePage;
import com.pages.LoginPage;

public class LoginTest extends BasePage {

	
	@Test(priority=1)
	public void doLogin() {
		
		LoginPage lp=new LoginPage();
		lp.doLogin("sanjayyadavanshi96@gamil.com", "1234567");
		
		
		getText("InvalidgetText_CSS");
		
	}
	
	
	
	@Test(priority=2)
	public void doLoginTest() {
		
		LoginPage lp=new LoginPage();
		lp.doLogin("tomsmith", "SuperSecretPassword!");
		
	
		getText("InvalidgetText_CSS");
		
	}
}
