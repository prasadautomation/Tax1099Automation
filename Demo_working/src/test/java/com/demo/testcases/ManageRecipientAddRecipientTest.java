package com.demo.testcases;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.demo.Base.base;
import com.demo.PeopleLeftMenu.ManagePayerAddPayer;
import com.demo.PeopleLeftMenu.ManagePeople;
import com.demo.dataprovider.DataProviders;
import com.demo.pages.Db;
import com.demo.pages.LoginPage;
import com.demo.pages.OuterLoginButton;
import com.demo.utility.Log;

public class ManageRecipientAddRecipientTest extends base {
	LoginPage LoginPage;
	OuterLoginButton OuterLoginButton;
	Db Db;
	ManagePeople ManagePeople;
	ManagePayerAddPayer ManagePayerAddPayer;

	// @BeforeMethod
	/*
	 * public void setUp() { launchApp(); }
	 */

	/*
	 * @AfterMethod public void teardown() { driver.quit(); }
	 */
	@Test(priority = 1, dataProvider = "credentials", dataProviderClass = DataProviders.class)
	public void clickonLoginTest(String Useremail, String Passwd) throws Throwable {
		launchApp();
		Log.startTestCase("clickonLoginTest ");
		OuterLoginButton = new OuterLoginButton();
		Log.info("User is going to clik On Outer Login Button");
		LoginPage = OuterLoginButton.clickonLogin();
		Log.info("Enter UserName and Password");
		// Db Db =
		// LoginPage.login(prop.getProperty("UserName"),prop.getProperty("Password"));
		Db Db = LoginPage.login(Useremail, Passwd);
		
		WebDriverWait wait=new WebDriverWait(getDriver(),70);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='userType']//following-sibling::div//div[contains(text(),'Dashboard')]")));
		Log.info("Verifying User is able to Login");
		String actURL = Db.GetCurrentURL();
		String expectedURL = "https://www.tax1099.com/Protected/Dashboard";
		Assert.assertEquals(actURL, expectedURL);
		Log.info("Login Succesful");
		Log.endTestCase("clickonLoginTest ");

}

	@Test
	public void AddRecipientTest(HashMap<String, String> hashMapValue) throws Throwable {

		getDriver().findElement(By.xpath("//p[contains(text(),'People')]")).click();
		WebElement element = (new WebDriverWait(getDriver(), 10)).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Manage Recipient')]")));
		getDriver().findElement(By.xpath("//a[contains(text(),'Manage Recipient')]")).click();
	}
}
