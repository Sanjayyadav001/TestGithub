package com.pages;

import com.baseClass.BasePage;

public class LogOutPage extends BasePage {

	public void logOut() {
		
		click("//*[@id=\"content\"]/div/a");
	}
}
