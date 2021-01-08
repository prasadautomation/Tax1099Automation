package com.demo.MISCtestcases;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.demo.Base.base;
import com.demo.dataprovider.DataProviders;
import com.demo.pages.Db;
import com.demo.pages.LoginPage;
import com.demo.pages.OuterLoginButton;
import com.demo.utility.Log;
import com.demo.FormsLeftmenu.FormsLeftMenu;
import com.demo.MISCformsLIST.MISCformTaxyear2019;

public class MISC2019FormTest extends base{
	 LoginPage LoginPage; 
	 OuterLoginButton OuterLoginButton; 
	 Db Db;
	 FormsLeftMenu FormsLeftMenu;
	 MISCformTaxyear2019 MISCformTaxyear2019;
	 
	@Test(priority = 1,dataProvider ="credentials", dataProviderClass = DataProviders.class)
	public void clickonLoginTest(String Useremail,String Passwd) throws Throwable {
		  launchApp();
	      Log.startTestCase("clickonLoginTest ");
	      OuterLoginButton=new OuterLoginButton();
	      Log.info("User is going to clik On Outer Login Button");
		  LoginPage=OuterLoginButton.clickonLogin();
		  Log.info("Enter UserName and Password");
		  //Db Db = LoginPage.login(prop.getProperty("UserName"),prop.getProperty("Password"));
		  Db Db = LoginPage.login(Useremail,Passwd);
//		  WebgetDriver()Wait wait = new WebDriverWait(driver, 40);
//		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text()='Dashboard')]")));
		  WebElement element = (new WebDriverWait(getDriver(), 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[3]/div[1]/div[1]")));
	      Log.info("Verifying User is able to Login");
		  String actURL=Db.GetCurrentURL();
		  String expectedURL="https://1099cloud.com/Protected/Dashboard";
		  Assert.assertEquals(actURL, expectedURL);
		  Log.info("Login Succesful");
	      Log.endTestCase("clickonLoginTest ");
	}

	@Test(priority = 2,dataProvider ="MISC2019",dataProviderClass = DataProviders.class)
	public void CreateMISC2019FormTest1(HashMap<String,String> hashMapValue) throws Throwable {
		Log.startTestCase("CreateMISC2019FormTest1");
		FormsLeftMenu.ClickOnForms();
		FormsLeftMenu.ClickOnNewForm();
		MISCformTaxyear2019.CreateMISC2019Form(
				hashMapValue.get("Box1"),
				hashMapValue.get("Box2"),
				hashMapValue.get("Box3"),
				hashMapValue.get("Box4"),
				hashMapValue.get("Box5"),
				hashMapValue.get("Box6"),
				hashMapValue.get("Box7"),
				hashMapValue.get("Box8"),
				hashMapValue.get("Box9"),
				hashMapValue.get("Box10"),
				hashMapValue.get("Box13"),
				hashMapValue.get("Box14"),
				hashMapValue.get("Box15"),
				hashMapValue.get("AccntNum"),
				hashMapValue.get("Fatcacheckbox"),
				hashMapValue.get("SecondTINNoticecheckbox"),
				hashMapValue.get("Box15aSection409Adeferrals"),
				hashMapValue.get("Box15bSection409Aincome"),
				hashMapValue.get("Box16a"),
				hashMapValue.get("Box16b"),
				hashMapValue.get("Box17State1"),
				hashMapValue.get("Box17State2"),
				hashMapValue.get("Box18a"),
				hashMapValue.get("Box18b"));
		
	}
	



}
















