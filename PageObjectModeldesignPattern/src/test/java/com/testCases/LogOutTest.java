package com.testCases;

import org.testng.annotations.Test;

import com.baseClass.BasePage;
import com.pages.LogOutPage;

public class LogOutTest extends BasePage{

	
	@Test
	public void doLogOut() {
		
		LogOutPage logout=new LogOutPage();
		logout.logOut();
		
	}
}
