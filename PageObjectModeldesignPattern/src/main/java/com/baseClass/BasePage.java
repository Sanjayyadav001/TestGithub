package com.baseClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BasePage {

	
	public static WebDriver driver;
	public static Properties Config=new Properties();
	public static Properties OR=new Properties();
	public static WebDriverWait wait;
	public static Logger logs=Logger.getLogger(BasePage.class.getSimpleName());
	public static FileInputStream fis;
    public static WebElement element;



	public static void getText(String key) {
		try {
		if(key.endsWith("_XPATH")) {
			
		element= driver.findElement(By.xpath(OR.getProperty(key)));
		System.out.println(element.getText());
		}else if(key.endsWith("_ID")) {
			
		 element =driver.findElement(By.id(OR.getProperty(key)));
		 System.out.println(element.getText());
		}else if(key.endsWith("_CSS")) {	
            element = driver.findElement(By.cssSelector(OR.getProperty(key)));
			System.out.println(element.getText());
			
		}
		
		logs.info("successfully get the text : " + key);
		
		}catch(Throwable t) {
			
			logs.info("Error!! while finding an element : " + key + "  Error message is :  "  +   t.getMessage());
			
		}
		
		
		
	}
	
	
	
	
	
	
	public static void click(String key) {
		try {
		if(key.endsWith("_XPATH")) {
			
			driver.findElement(By.xpath(OR.getProperty(key))).click();
		}else if(key.endsWith("_ID")) {
			
			driver.findElement(By.id(OR.getProperty(key))).click();
		}else if(key.endsWith("_CSS")) {
			
			driver.findElement(By.cssSelector(OR.getProperty(key))).click();
		}
		logs.info("Succcessfully !! clicking an element : " + key);
		
		
		}catch(Throwable t) {
			
			logs.info("Error!! not clicking an element : " + key + "  Error message is :  "  +  t.getMessage());
			
		}
		
	}
	
	
	
	
	
	

	public static void type(String key,String value) {
		try {
		if(key.endsWith("_XPATH")) {
			
			driver.findElement(By.xpath(OR.getProperty(key))).sendKeys(value);
		}else if(key.endsWith("_ID")) {
			
			driver.findElement(By.id(OR.getProperty(key))).sendKeys(value);
		}else if(key.endsWith("_CSS")) {
			
			driver.findElement(By.cssSelector(OR.getProperty(key))).sendKeys(value);
		}
		logs.info("Successfully !!!!typing in an element : " + key + "  value is :   " +  value);
		
		
		}catch(Throwable t) {
			
			logs.info("Error while typing in an element : " + key + "  value is : " +  value  + "Error message is : " +  t.getMessage());
			
		}
		
	}
	
	
	
	
	
	
	
	
	@BeforeSuite
	public void setUp()  {
		
		if(driver==null) {
			
			PropertyConfigurator.configure("./src/test/resources/properties/log4j.properties");
			
			try {
				fis=new FileInputStream("./src/test/resources/properties/Config.Properties");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			try {
				Config.load(fis);
				logs.info("Config file loaded!!!");
			} catch (IOException e) {
				logs.info("Config file not loaded!!");
				e.printStackTrace();
			}
			
			
			try {
				fis=new FileInputStream("./src/test/resources/properties/OR.Properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				OR.load(fis);
				logs.info("OR file loaded!!!");
			} catch (IOException e) {
				
				logs.info("OR file not loaded!!!");
				e.printStackTrace();
			}
		
			
			if(Config.getProperty("browser").equals("chrome")){
				
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
				logs.info("chrome launched!!");
				
			}else if(Config.getProperty("browser").equals("firefox")) {
				
				WebDriverManager.firefoxdriver().setup();
				driver=new FirefoxDriver();
				logs.info("firefox launched!!");
			}
			
			
			driver.get(Config.getProperty("testsiteURL"));
			logs.info("navigate to URL : " + Config.getProperty("testsiteURL"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(Config.getProperty("implicit.wait")), TimeUnit.SECONDS);
			wait=new WebDriverWait(driver,Integer.parseInt(Config.getProperty("explicit.wait")));
			
		}
		
		
	}
	
	@AfterSuite
	public void quit() {
		
		
		driver.quit();
		logs.info("test execution completed!!!");
	}
	
	
	
	

	
	
	
	
	
}
