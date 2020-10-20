package com.demo.testcases;


	import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.Assert;
	import org.testng.annotations.Test;
	import com.demo.pages.LoginPage;
	import com.demo.Base.base;
	import com.demo.pages.OuterLoginButton;
	import com.demo.utility.Log;
	import com.demo.pages.Db;
	import com.demo.PeopleLeftMenu.*;
	import com.demo.dataprovider.DataProviders;
	
	public class ManualAddPayerTest extends base{
		 LoginPage LoginPage; 
		 OuterLoginButton OuterLoginButton; 
		 Db Db;
		 ManagePeople ManagePeople;
		 ManagePayerAddPayer ManagePayerAddPayer;
		
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
//			  WebDriverWait wait = new WebDriverWait(driver, 40);
//			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text()='Dashboard')]")));
			 // WebElement element = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[3]/div[1]/div[1]")));
			  WebElement element = (new WebDriverWait(getDriver(), 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text()='Dashboard')]")));
			  
			  Log.info("Verifying User is able to Login");
			  String actURL=Db.GetCurrentURL();
			  String expectedURL="https://www.tax1099.com/Protected/Dashboard";
			  Assert.assertEquals(actURL, expectedURL);
			  Log.info("Login Succesful");
		      Log.endTestCase("clickonLoginTest ");
	}
		@Test(priority = 2,dataProvider ="addPayerein",dataProviderClass = DataProviders.class)
		public void AddPayerTest() throws Throwable {
			Log.startTestCase("addPayerTest");
			WebElement element = (new WebDriverWait(getDriver(), 20)).until(ExpectedConditions.elementToBeClickable(By.xpath("//p[contains(text(),'People')]")));
			 //ManagePeople=new ManagePeople();//*[@id='firstpane']/div[2]/p
			getDriver().findElement(By.xpath("//p[contains(text(),'People')]")).click();
			////*[@id="menu_body2"]/a[1]
			getDriver().findElement(By.xpath("//a[contains(text(),'Manage Payer')]")).click();
			WebElement element1 = (new WebDriverWait(getDriver(), 10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='btnAddEditPayer']")));
			getDriver().findElement(By.xpath("//input[@id='btnAddEditPayer']")).click();
			
			Thread.sleep(1000);
			getDriver().findElement(By.id("rblPayerTypeBusiness")).click();
			Thread.sleep(1000);

			WebElement PayerEIN= getDriver().findElement(By.xpath("//input[@id='PayerFedaralID']"));
			PayerEIN.clear();

			getDriver().findElement(By.xpath("//input[@id='PayerFedaralID']")).sendKeys("123456789");
			
			getDriver().findElement(By.xpath("//input[@id='PayerLastName']")).sendKeys("BusinessOCT102020PayerTestAA01");
			getDriver().findElement(By.xpath("//input[@id='PayerAddress']")).sendKeys("us");
			getDriver().findElement(By.xpath("//input[@id='PayerCity']")).sendKeys("city");
			
			Select PayerState = new Select(getDriver().findElement(By.xpath("//select[@id='PayerState']")));
			PayerState.selectByVisibleText("Alabama");
			
			getDriver().findElement(By.xpath("//input[@id='PayerZIP']")).sendKeys("35010");
			
			Select PayerCountry = new Select(getDriver().findElement(By.xpath("//select[@id='PayerCountry']")));
			PayerCountry.selectByVisibleText("United States of America");
			
			getDriver().findElement(By.xpath("//input[@id='PayerPhNo']")).sendKeys("1234567890");
			
			getDriver().findElement(By.xpath("//input[@id='PayerEmail']")).sendKeys("prasad@zenwork.com");
			

		}
	}
	

	
	
	
	
	
	
	
	
	