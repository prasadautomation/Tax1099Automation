package com.demo.testcases;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.demo.Base.base;
import com.demo.PeopleLeftMenu.ManagePayerAddPayer;
import com.demo.PeopleLeftMenu.ManagePeople;
import com.demo.dataprovider.DataProviders;
import com.demo.pages.Db;
import com.demo.pages.LoginPage;
import com.demo.pages.OuterLoginButton;
import com.demo.utility.Log;

public class TC_Dashboard_count_006 extends base{
	
	
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
	public void numberOfRecordsinDashboard() throws InterruptedException {
		Thread.sleep(80000);
		getDriver().navigate().refresh();
		Thread.sleep(50000);
		String recordstext=getDriver().findElement(By.xpath("//span[2][contains(text(),'items')]")).getText();
		int lengthoftext=recordstext.length();
		Log.info("Text for number of records and length:"+recordstext+" and "+lengthoftext);
		Log.info("numberofrecords:"+recordstext.subSequence(10,lengthoftext));
		int digits=(lengthoftext-6);
	//	Log.info("Exact records:"+digits);
		
		
		
	}

}
