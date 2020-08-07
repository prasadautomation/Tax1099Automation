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
import com.demo.PeopleLeftMenu.ManagePayerAddPayer;
import com.demo.PeopleLeftMenu.ManagePeople;
import com.demo.actiondriver.Action;
import com.demo.dataprovider.DataProviders;
import com.demo.pages.Db;
import com.demo.pages.LoginPage;
import com.demo.pages.OuterLoginButton;
import com.demo.utility.Log;

public class ManagePayerAddPayerTest extends base{
	LoginPage LoginPage; 
	 OuterLoginButton OuterLoginButton; 
	 Db Db;
	 ManagePeople ManagePeople;

	//@BeforeMethod
	public void setUp() {
	launchApp();	
	}
	
	/*
	 * @AfterMethod public void teardown() { driver.quit(); }
	 */
	@Test(priority = 1,dataProvider ="credentials", dataProviderClass = DataProviders.class)
	public void clickonLogin(String Useremail,String Passwd) throws Throwable {
		  launchApp();
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
	@Test(priority = 2,dataProvider ="addPayer",dataProviderClass = DataProviders.class)
	public void AddPayer(
			String Type,
			String EIN,
			String SSN,
			String FirstName,
			String MiddleName,
			String LastName,
			String BusinessName,
			String Address,
			String Suffix,
			String Line2,
			String PayerCity,
			String State,
			String Zipcode,
			String Country,
			String CheckheretoForeignAddress,
			String phone,
			String Email,
			String WithholdingORTaxStateId,
			String LastFiling,
			String ClientID
			
			)  throws Throwable {
		
		WebElement element = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'People')]")));

		 //ManagePeople=new ManagePeople();
		 driver.findElement(By.xpath("//p[contains(text(),'People')]")).click();
		 driver.findElement(By.xpath("//a[contains(text(),'Manage Payer')]")).click();
			WebElement element1 = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='btnAddEditPayer']")));

		 driver.findElement(By.xpath("//input[@id='btnAddEditPayer']")).click();
		// ManagePeople.ClickOnPeople();
		/*
		 * ManagePayerAddPayer ManagePayerAddPayer=new ManagePayerAddPayer();
		 * ManagePayerAddPayer.AddPayer(Type, EIN, SSN, FirstName, MiddleName, LastName,
		 * BusinessName, Address, Suffix, Line2, PayerCity, State, Zipcode, Country,
		 * CheckheretoForeignAddress, phone, Email, WithholdingORTaxStateId, LastFiling,
		 * ClientID);
		 */

	}
}




















