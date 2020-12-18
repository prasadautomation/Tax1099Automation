package com.demo.NECtestcases;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.demo.Base.base;
import com.demo.FormsLeftmenu.FormsLeftMenu;
import com.demo.dataprovider.DataProviders;
import com.demo.pages.Db;
import com.demo.pages.LoginPage;
import com.demo.pages.OuterLoginButton;
import com.demo.utility.Log;
import com.demo.NECformsLIST.NECformTaxyear2020;

public class NEC2020formTest extends base {

	LoginPage LoginPage;
	OuterLoginButton OuterLoginButton;
	Db Db;
	FormsLeftMenu FormsLeftMenu;
	NECformTaxyear2020 NECformTaxyear2020;
	
	@Test(priority = 1,dataProvider ="credentials", dataProviderClass = DataProviders.class)
	public void clickonLoginTest(String Useremail,String Passwd) throws Throwable {
		  launchApp();
	      Log.startTestCase("clickonLoginTest ");
	      OuterLoginButton=new OuterLoginButton();
	      Log.info("User is going to clik On Outer Login Button");
		  LoginPage=OuterLoginButton.clickonLogin();
		  Log.info("Enter UserName and Password");
		  Db Db = LoginPage.login(Useremail,Passwd);
		  WebElement element = (new WebDriverWait(getDriver(), 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[3]/div[1]/div[1]")));
	      Log.info("Verifying User is able to Login");
		  String actURL=Db.GetCurrentURL();
		  String expectedURL="https://1099cloud.com/Protected/Dashboard";
		  Assert.assertEquals(actURL, expectedURL);
		  Log.info("Login Succesful");
	      Log.endTestCase("clickonLoginTest ");
	}
	public void CreateNEC2020FormTest1(HashMap<String,String> hashMapValue) throws Throwable {
		Log.startTestCase("CreateNEC2020FormTest1");
		FormsLeftMenu.ClickOnForms();
		FormsLeftMenu.ClickOnNewForm();
		
	}
}























