package com.demo.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demo.Base.base;
import com.demo.actiondriver.Action;
import com.demo.dataprovider.DataProviders;
import com.demo.pages.DashBoard;
import com.demo.pages.Db;
import com.demo.pages.LoginPage;
import com.demo.pages.OuterLoginButton;
import com.demo.utility.Log;

public class LoginTest extends base {
	
	 LoginPage LoginPage; 
	 OuterLoginButton OuterLoginButton; 
//	 DashBoard DashBoard;
	 Db Db;
	
	
	@BeforeMethod
	public void setUp() {
	launchApp();	
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	@Test(dataProvider ="credentials", dataProviderClass = DataProviders.class)
	public void clickonLogin(String Useremail,String Passwd) throws Throwable {
		  
	      Log.startTestCase("clickonLoginTest ");
	      OuterLoginButton=new OuterLoginButton();
	      Log.info("User is going to clik On Outer Login Button");
		  LoginPage=OuterLoginButton.clickonLogin();
		  Log.info("Enter UserName and Password");
		  //Db Db = LoginPage.login(prop.getProperty("UserName"),prop.getProperty("Password"));
		  Db Db = LoginPage.login(Useremail,Passwd);
//		  WebDriverWait wait = new WebDriverWait(driver, 40);
//		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text()='Dashboard')]")));
		  WebElement element = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[3]/div[1]/div[1]")));
	      Log.info("Verifying User is able to Login");
		  String actURL=Db.GetCurrentURL();
		  String expectedURL="https://1099cloud.com/Protected/Dashboard";
		  Assert.assertEquals(actURL, expectedURL);
		  Log.info("Login Succesful");
	      Log.endTestCase("clickonLoginTest ");

		  
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
