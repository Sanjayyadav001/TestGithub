package com.testCases;

import org.testng.annotations.Test;

import com.baseClass.BasePage;
import com.pages.HomePage;


public class LandingPageTest extends BasePage {

	
	@Test
	public void landingPage() {
	
		HomePage page=new HomePage();
		page.formPage();
		
		String title=driver.getTitle(); 
		System.out.println("title is : " + title);
		
		
	
}
}
