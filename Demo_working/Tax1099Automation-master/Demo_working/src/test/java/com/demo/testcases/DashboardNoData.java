package com.demo.testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

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
import com.demo.dataprovider.DataProviders;
import com.demo.pages.Db;
import com.demo.pages.LoginPage;
import com.demo.pages.OuterLoginButton;
import com.demo.utility.Log;

public class DashboardNoData extends base {


	 LoginPage LoginPage; 
	 OuterLoginButton OuterLoginButton; 
//	 DashBoard DashBoard;
	 Db Db;
	
	
	@BeforeMethod
	public void setUp() {
	launchApp();	
	}
	
	@AfterMethod
	public void teardown() {
		//getDriver().quit();
	}
	
	@Test(dataProvider ="newlogin", dataProviderClass = DataProviders.class)
	public void clickonLogin(String Useremail,String Passwd) throws Throwable {
		
	
		  getDriver().manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	      Log.startTestCase("clickonLoginTest ");
	      OuterLoginButton=new OuterLoginButton();
	      Log.info("User is going to clik On Outer Login Button");
		  LoginPage=OuterLoginButton.clickonLogin();
		  Log.info("Enter UserName and Password");
		  //Db Db = LoginPage.login(prop.getProperty("UserName"),prop.getProperty("Password"));
		  Db Db = LoginPage.login(Useremail,Passwd);
//		  WebDriverWait wait = new WebDriverWait(driver, 40);
//		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text()='Dashboard')]")));
	//	  WebElement element = (new WebDriverWait(getDriver(), 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='userType']//following-sibling::div//div[contains(text(),'Dashboard')]")));
	      Log.info("Verifying User is able to Login");
		  String actURL=Db.GetCurrentURL();
	//	  String expectedURL="https://1099cloud.com/Protected/Dashboard";-->for cloud 
		  String expectedURL = "https://www.tax1099.com/Account/Login";
		  Assert.assertEquals(actURL, expectedURL);
		  Log.info("Login Succesful");
	      Log.endTestCase("clickonLoginTest ");
	      Thread.sleep(5000);
	     	      
	      getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Thread.sleep(10000);
			
	      WebElement closeButton=getDriver().findElement(By.xpath("//span[@id='ui-id-5']//following-sibling::button[@type='button']"));
	      closeButton.click();
	      Log.info("Close button clicked.");
			//getDriver().navigate().refresh();
			List <WebElement> dashboardrecords= getDriver().findElements(By.xpath("//div[@id='Forms']//table//thead//following-sibling::tbody//tr"));
			
			
			
		int recordscount=dashboardrecords.size();
			Log.info("Number of records displaying in dashboard:"+recordscount);
			if(recordscount==0) {
				
				Log.info("There is no records to display");
			}else {
				Log.info("there are records to display");;
			}
	     
	    
		  
	}}
