package com.demo.testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demo.Base.base;
import com.demo.dataprovider.DataProviders;
import com.demo.pages.Db;
import com.demo.pages.LoginPage;
import com.demo.pages.OuterLoginButton;
import com.demo.utility.Log;

public class TC_AddRecipient_Nodata_002 extends base {

	LoginPage LoginPage;
	OuterLoginButton OuterLoginButton;
//	 DashBoard DashBoard;
	Db Db;

	@BeforeMethod
	public void setUp() {

	}

	@AfterMethod
	public void teardown() {
		// getDriver().quit();
	}

	@Test(priority = 1, dataProvider = "newlogin", dataProviderClass = DataProviders.class)
	public void clickonLogin(String Useremail, String Passwd) throws Throwable {

		// getDriver().manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		launchApp();
		Log.startTestCase("clickonLoginTest ");
		OuterLoginButton = new OuterLoginButton();
		Log.info("User is going to clik On Outer Login Button");
		LoginPage = OuterLoginButton.clickonLogin();
		Log.info("Enter UserName and Password");
		// Db Db =
		// LoginPage.login(prop.getProperty("UserName"),prop.getProperty("Password"));
		Db Db = LoginPage.login(Useremail, Passwd);

		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(10000);

		WebElement closeButton = getDriver()
				.findElement(By.xpath("//span[@id='ui-id-5']//following-sibling::button[@type='button']"));
		closeButton.click();
		Log.info("Close button clicked.");

	}

	@Test(priority = 2)
	public void payercount_newaccount() throws InterruptedException {

		// getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Log.startTestCase("payercount_newaccount");

		Thread.sleep(40000);

		WebElement element = getDriver().findElement(By.xpath("//p[contains(text(),'People')]"));
		WebDriverWait wait = new WebDriverWait(getDriver(), 60);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		JavascriptExecutor passwordexecutor = (JavascriptExecutor) getDriver();
		passwordexecutor.executeScript("arguments[0].click();", element);
		Thread.sleep(60000);
		Log.info("People menu clicked");

		String menutext = getDriver().findElement(By.xpath("//*[@id='firstpane']/div[2]/p")).getText();
		Log.info("menu text:" + menutext);
		getDriver().findElement(By.xpath("//a[contains(text(),'Manage Recipient')]")).click();

		Thread.sleep(10000);

		Log.info("Manage recipient clicked");
		Thread.sleep(10000);

		
		WebElement norecordsok = getDriver().findElement(By.xpath("//button[@id='alertify-ok']"));
		boolean alertvisible=norecordsok.isDisplayed();
		if(alertvisible==true) {
		norecordsok.click();
		Log.info("No records alert displayed");
		}else {Log.info("No records alert not displayed");}

	}

	@Test(priority = 3)
	public void payercount() {

		Select payerlist=new Select(getDriver().findElement(By.id("ddlPayer")));
		List payers=payerlist.getOptions();
		int payerscount=payers.size();
		Log.info("number of payers:"+payerscount);
		
	}
	
	@Test(priority=4)
	public void recipientCount() {
		
		List <WebElement>Recipients=getDriver().findElements(By.xpath("//div[@id='import_drop_zone']//following-sibling::div//table//tbody//tr"));
		int recipientscount=Recipients.size();
		Log.info("number of recipients:"+recipientscount);
		
	}
}
