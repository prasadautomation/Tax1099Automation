package com.demo.testcases;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.demo.Base.base;
import com.demo.PeopleLeftMenu.ManagePayerAddPayer;
import com.demo.PeopleLeftMenu.ManagePeople;
import com.demo.dataprovider.DataProviders;
import com.demo.pages.Db;
import com.demo.pages.LoginPage;
import com.demo.pages.OuterLoginButton;
import com.demo.utility.Log;

public class TC_AddRecipient_001 extends base{


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
		LoginPage = OuterLoginButton.clickonLogin();
		Log.info("Enter UserName and Password");
		// Db Db =
		// LoginPage.login(prop.getProperty("UserName"),prop.getProperty("Password"));
		Db Db = LoginPage.login(Useremail, Passwd);
	}
	
	@Test(priority=2)
public void geturl_pagename() throws InterruptedException {
		
		Log.startTestCase("geturl_pagename");
		
		Thread.sleep(80000);
		
		WebElement element=getDriver().findElement(By.xpath("//p[contains(text(),'People')]"));
	WebDriverWait wait=new WebDriverWait(getDriver(),60);
	wait.until(ExpectedConditions.elementToBeClickable(element));
	JavascriptExecutor passwordexecutor = (JavascriptExecutor) getDriver();
	passwordexecutor.executeScript("arguments[0].click();", element);
	Thread.sleep(60000);
	Log.info("People menu clicked");
	
	String menutext=getDriver().findElement(By.xpath("//*[@id='firstpane']/div[2]/p")).getText();
	Log.info("menu text:"+menutext);
	

	getDriver().findElement(By.xpath("//a[contains(text(),'Manage Recipient')]")).click();
	
	Thread.sleep(10000);
	
	Log.info("Manage recipient clicked");
	Thread.sleep(10000);
	
	String url = getDriver().getCurrentUrl();

Log.info("Url of recipient page:"+url);

String title= getDriver().getTitle();
Log.info("Page title is :"+title);

String expectedpagename="Manage Recipient";
Log.info("expected page name is:"+expectedpagename);
String actualpagename=getDriver().findElement(By.xpath("//div[@class='dashboard-header-mid']//h3[contains(text(),'Manage Recipient')]")).getText();
Log.info("Actual page name is:"+actualpagename);
assertEquals(actualpagename, expectedpagename,"Maange payer page name displayed correctly");


		
	}
	
}
