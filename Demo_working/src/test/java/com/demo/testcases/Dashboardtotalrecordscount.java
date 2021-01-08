package com.demo.testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.demo.Base.base;
import com.demo.PeopleLeftMenu.ManagePayerAddPayer;
import com.demo.PeopleLeftMenu.ManagePeople;
import com.demo.dataprovider.DataProviders;
import com.demo.pages.Db;
import com.demo.pages.LoginPage;
import com.demo.pages.OuterLoginButton;
import com.demo.utility.Log;

public class Dashboardtotalrecordscount extends base {
	
	
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
	Thread.sleep(10000);	
	}




@Test(priority = 2)
public void dashBoardtotalrecordscount() {
	//getDriver().manage().timeouts().implicitlyWait(60, TimeUnits.SECONDS);
	WebElement element= getDriver().findElement(By.xpath("//div[@id='Forms']//span[contains(text(),'1 - 10 of ')]"));
	String numberofrecords=element.getText();
	Log.info("Total number of records are:"+numberofrecords);
	Select payerlist=new Select(getDriver().findElement(By.id("ddlPayer")));
	List <WebElement>payers=payerlist.getOptions();
	int payerscount=payers.size();
	Log.info("number of payers:"+payerscount);
	
}}