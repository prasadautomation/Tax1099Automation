package com.demo.testcases;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.math3.random.RandomGenerator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
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



public class AddpayerwithRandomBusinessnameandEIN extends base {
	
	
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
		Db Db = LoginPage.login(Useremail, Passwd);}
		
	@Test(priority = 2, dataProvider = "addpayerrandombusinessein", dataProviderClass = DataProviders.class)
	public void AddPayerTest(HashMap<String, String> hashMapValue) throws Throwable {
		
			Log.startTestCase("AddPayerTest");
			
			Thread.sleep(80000);
			
			WebElement element=getDriver().findElement(By.xpath("//p[contains(text(),'People')]"));
		WebDriverWait wait=new WebDriverWait(getDriver(),60);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		JavascriptExecutor passwordexecutor = (JavascriptExecutor) getDriver();
		passwordexecutor.executeScript("arguments[0].click();", element);
		Thread.sleep(60000);
		Log.info("People menu clicked");
			/*Actions action=new Actions(getDriver());
			action.moveToElement(element);
			action.click();
			action.perform();*/
			String menutext=getDriver().findElement(By.xpath("//*[@id='firstpane']/div[2]/p")).getText();
			Log.info("menu text:"+menutext);
			

			getDriver().findElement(By.xpath("//a[contains(text(),'Manage Payer')]")).click();
			
			Thread.sleep(10000);
			
			Log.info("Manage payer clicked");

			Thread.sleep(10000);
			WebElement element1 = (new WebDriverWait(getDriver(), 60))
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='btnAddEditPayer']")));
			element1.click();
			// ManagePeople.ClickOnAddPayer();
			
			Thread.sleep(10000);
			
			WebElement type=getDriver().findElement(By.xpath("//div[@id='divFederalIdTypeForAllForms']//input[@id='rblPayerTypeBusiness']"));
			type.click();
			Thread.sleep(10000);
			Random random=new Random();
			int randomnumber=random.nextInt(1000000000);
			getDriver().findElement(By.id("PayerFedaralID")).clear();
			getDriver().findElement(By.id("PayerFedaralID")).click();
			getDriver().findElement(By.id("PayerFedaralID")).sendKeys(""+randomnumber);
			
			Log.info("Random EIN:"+randomnumber);
			
			WebElement businessname=getDriver().findElement(By.id("PayerLastName"));
			
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyyhmmss");
			String formattedDate = sdf.format(date);
			businessname.sendKeys("Test"+formattedDate);
			
			
			
			ManagePayerAddPayer ManagePayerAddPayer = new ManagePayerAddPayer();
			//getDriver().findElement(By.id("PayerZIP")).sendKeys("35005");
			ManagePayerAddPayer.AddpayerEinNonUs(hashMapValue.get("address"), hashMapValue.get("suffix"),
						hashMapValue.get("line2"), hashMapValue.get("city"), hashMapValue.get("State"),
						hashMapValue.get("zipcode"), hashMapValue.get("Postalcode"),hashMapValue.get("Country"),
						
						// hashMapValue.get("checkheretoforeignaddress"),
						hashMapValue.get("phone"), hashMapValue.get("email"), hashMapValue.get("withholdingortaxstateid"),
						// hashMapValue.get("lastfiling"),
						hashMapValue.get("clientid"));
			
			getDriver().findElement(By.id("PayerZIP")).clear();
			getDriver().findElement(By.id("PayerZIP")).click();
			getDriver().findElement(By.id("PayerZIP")).sendKeys("35010");
			
					ManagePayerAddPayer.validateAddEINpayer();
					Thread.sleep(2000);
					
					Alert alert = ((WebDriver) getDriver()).switchTo().alert();
					Thread.sleep(2000);
					getDriver().findElement(By.xpath("//button[normalize-space()='Cancel']")).click();


		}
	@Test(priority=3)
	public void payerscount_existingaccount() throws InterruptedException {
		Thread.sleep(80000);
		
		getDriver().navigate().refresh();
		Log.startTestCase("AddPayerTest");
		
		
		WebElement element=getDriver().findElement(By.xpath("//p[contains(text(),'People')]"));
	WebDriverWait wait=new WebDriverWait(getDriver(),60);
	wait.until(ExpectedConditions.elementToBeClickable(element));
	JavascriptExecutor passwordexecutor = (JavascriptExecutor) getDriver();
	passwordexecutor.executeScript("arguments[0].click();", element);
	Thread.sleep(60000);
	Log.info("People menu clicked");
		/*Actions action=new Actions(getDriver());
		action.moveToElement(element);
		action.click();
		action.perform();*/
		String menutext=getDriver().findElement(By.xpath("//*[@id='firstpane']/div[2]/p")).getText();
		Log.info("menu text:"+menutext);
		

		getDriver().findElement(By.xpath("//a[contains(text(),'Manage Payer')]")).click();
		
		Thread.sleep(10000);
		
		
		Log.info("Manage payer clicked");
		
		WebElement Text= getDriver().findElement(By.xpath("//div[@id='Forms']//span[contains(text(),'1 - 10 of ')]"));
		String numberofrecords=element.getText();
		Log.info("Total number of records are:"+numberofrecords);
	}


		}

