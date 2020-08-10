package com.demo.testcases;

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

public class ManageRecipientAddRecipientTest extends base {
	LoginPage LoginPage;
	OuterLoginButton OuterLoginButton;
	Db Db;

	@Test(priority = 1, dataProvider = "credentials", dataProviderClass = DataProviders.class)
	public void clickonLoginTest(String Useremail, String Passwd) throws Throwable {
		launchApp();
		Log.startTestCase("clickonLoginTest ");
		OuterLoginButton = new OuterLoginButton();
		Log.info("User is going to clik On Outer Login Button");
		LoginPage = OuterLoginButton.clickonLogin();
		Log.info("Enter UserName and Password");
		
		Db Db = LoginPage.login(Useremail, Passwd);
		WebElement element = (new WebDriverWait(driver, 10)).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='col-xs-6 chromeXpathFinder chromeXpathFinder0']")));

		Log.info("Verifying User is able to Login");
		String actURL = Db.GetCurrentURL();
		String expectedURL = "https://1099cloud.com/Protected/Dashboard";
		Assert.assertEquals(actURL, expectedURL);
		Log.info("Login Succesful");
		Log.endTestCase("clickonLoginTest ");
	}

	@Test
	public void AddRecipientTest(HashMap<String, String> hashMapValue) throws Throwable {

		driver.findElement(By.xpath("//p[contains(text(),'People')]")).click();
		WebElement element = (new WebDriverWait(driver, 10)).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Manage Recipient')]")));
		driver.findElement(By.xpath("//a[contains(text(),'Manage Recipient')]")).click();
	}
}
