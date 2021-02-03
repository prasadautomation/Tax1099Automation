package com.demo.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.demo.Base.base;
import com.demo.PeopleLeftMenu.ManagePayerAddPayer;
import com.demo.PeopleLeftMenu.ManagePeople;
import com.demo.dataprovider.DataProviders;
import com.demo.pages.Db;
import com.demo.pages.LoginPage;
import com.demo.pages.OuterLoginButton;
import com.demo.utility.Log;

public class TC_MISC_BoxesRedcolorValidation1Test_004 extends base{
	
	
	LoginPage LoginPage;
	OuterLoginButton OuterLoginButton;
	Db Db;
	ManagePeople ManagePeople;
	ManagePayerAddPayer ManagePayerAddPayer;
	@Test(priority = 1, dataProvider = "credentials", dataProviderClass = DataProviders.class)
	public void clickonLoginTest(String Useremail, String Passwd) throws Throwable {
		launchApp();
		getDriver().manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Log.startTestCase("clickonLoginTest ");
		OuterLoginButton = new OuterLoginButton();
		Log.info("User is going to clik On Outer Login Button");
		Thread.sleep(80000);
		LoginPage = OuterLoginButton.clickonLogin();
		Log.info("Enter UserName and Password");
		// Db Db =
		// LoginPage.login(prop.getProperty("UserName"),prop.getProperty("Password"));
		Db Db = LoginPage.login(Useremail, Passwd);
	Thread.sleep(40000);
	}
	@Test(priority=2)
	public void redcolouralert() throws InterruptedException {
		Log.startTestCase("redcolouralert");
	//TC_MISC_VerifyBox4PopupMessageTest_001 navigationmethod=new TC_MISC_VerifyBox4PopupMessageTest_001();
	//navigationmethod.navigate_1099MISCform();
	
	Thread.sleep(50000);
	
	getDriver().findElement(By.xpath("//input[@id='btnSaveContinue']")).click();
	Log.info("Save and continue button clicked");
	Thread.sleep(30000);
	
	WebElement nodataerror=getDriver().findElement(By.xpath("//span[@id='spnError']"));
	boolean errordisplay=nodataerror.isDisplayed();
	
	if(errordisplay==true) {
		
		Log.info("Please fix the errors before proceeding. error displayed");
	}else {Log.info("error not displayed test case failed");}

}}
