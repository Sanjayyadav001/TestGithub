package com.testcases2;

import org.testng.annotations.Test;

import com.baseClass.BasePage;
import com.pages2.ChallengingDomPage;

public class ChallengingDomTest extends BasePage {

	
	@Test(priority=1)
	public void doCLickButton1() {
		
		ChallengingDomPage dom=new ChallengingDomPage();
		dom.button1();
		
		getText("FirstBTN_XPATH");
		
	}
	
	@Test(priority=2)
	public void doClickButton2() {
		
		ChallengingDomPage dom=new ChallengingDomPage();
		dom.button2();
		
		getText("SecondBTN_XPATH");
		
	}
	
	
	
	@Test(priority=3)
	public void doCLickButton3() {
		
		ChallengingDomPage dom=new ChallengingDomPage();
		dom.button3();
		
		getText("ThirdBTN_XPATH");
	}
	
	
}
