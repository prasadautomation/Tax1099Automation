package com.demo.testcases;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.demo.pages.LoginPage;
import com.demo.Base.base;
import com.demo.pages.OuterLoginButton;
import com.demo.utility.Log;



import com.demo.pages.Db;
import com.demo.PeopleLeftMenu.*;
import com.demo.dataprovider.DataProviders;

public class ManagePayerAddPayerTest extends base {
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
		getDriver().manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Log.startTestCase("clickonLoginTest ");
		OuterLoginButton = new OuterLoginButton();
		Log.info("User is going to clik On Outer Login Button");
		LoginPage = OuterLoginButton.clickonLogin();
		Log.info("Enter UserName and Password");
		// Db Db =
		// LoginPage.login(prop.getProperty("UserName"),prop.getProperty("Password"));
		Db Db = LoginPage.login(Useremail, Passwd);}
		
		
//		  WebDriverWait wait = new WebDriverWait(driver, 40);
//		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text()='Dashboard')]")));
		// WebElement element = (new WebDriverWait(driver,
		// 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[3]/div[1]/div[1]")));
	
		
		
		/*-----prasad code---**
		
		//	WebElement element = (new WebDriverWait(getDriver(), 10))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text()='Dashboard')]")));*/

	//	WebElement dashboard=getDriver().findElement(By.xpath("input[@id='userType']//following-sibling::div//div[contains(text(),'Dashboard')]"));
		
		/*WebDriverWait wait=new WebDriverWait(getDriver(),70);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='userType']//following-sibling::div//div[contains(text(),'Dashboard')]")));
		Log.info("Verifying User is able to Login");
		String actURL = Db.GetCurrentURL();
		String expectedURL = "https://www.tax1099.com/Protected/Dashboard";
		Assert.assertEquals(actURL, expectedURL);
		Log.info("Login Succesful");
		Log.endTestCase("clickonLoginTest ");
	}*/

	private void WebdriverWait(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Test(priority = 2, dataProvider = "addPayerein", dataProviderClass = DataProviders.class)
	public void AddPayerTest(HashMap<String, String> hashMapValue) throws Throwable {
		
			Log.startTestCase("addPayerTest");
			
			
		//	WebDriverWait wait = new WebDriverWait (getDriver(), 30);
	//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='firstpane']/div[2]/p"))).click();
		
			/*WebElement element = (new WebDriverWait(getDriver(), 20))
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='firstpane']/div[2]/p")));
			Thread.sleep(20000);*/
			Thread.sleep(20000);
			
			WebElement element=getDriver().findElement(By.xpath("//*[@id='firstpane']/div[2]/img"));
			element.click();
			/*Actions action=new Actions(getDriver());
			action.moveToElement(element);
			action.click();
			action.perform();*/
			String menutext=getDriver().findElement(By.xpath("//*[@id='firstpane']/div[2]/p")).getText();
			Log.info("menu text:"+menutext);
			
			
			
			
			// ManagePeople=new ManagePeople();//*[@id='firstpane']/div[2]/p
		//	getDriver().findElement(By.xpath("//p[contains(text(),'People')]")).click();
			//// *[@id="menu_body2"]/a[1]
	
			
			getDriver().findElement(By.xpath("//a[contains(text(),'Manage Payer')]")).click();
			WebElement element1 = (new WebDriverWait(getDriver(), 10))
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='btnAddEditPayer']")));
			getDriver().findElement(By.xpath("//input[@id='btnAddEditPayer']")).click();
			// ManagePeople.ClickOnAddPayer();
			ManagePayerAddPayer ManagePayerAddPayer = new ManagePayerAddPayer();
			ManagePayerAddPayer.AddPayerEIN(
					// hashMapValue.get("type"),
					hashMapValue.get("einTIN"),
					// hashMapValue.get("ssn"),
					// hashMapValue.get("FirstName"),
					// hashMapValue.get("MiddleName"),
					// hashMapValue.get("LastName"),
					hashMapValue.get("businessname"), hashMapValue.get("address"), hashMapValue.get("suffix"),
					hashMapValue.get("line2"), hashMapValue.get("city"), hashMapValue.get("State"),
					hashMapValue.get("zipcode"), hashMapValue.get("Country"),
					// hashMapValue.get("checkheretoforeignaddress"),
					hashMapValue.get("phone"), hashMapValue.get("email"), hashMapValue.get("withholdingortaxstateid"),
					// hashMapValue.get("lastfiling"),
					hashMapValue.get("clientid"));
					ManagePayerAddPayer.validateAddEINpayer();
					Thread.sleep(2000);
					
					Alert alert = ((WebDriver) driver).switchTo().alert();
					Thread.sleep(2000);
					getDriver().findElement(By.xpath("//button[normalize-space()='Cancel']")).click();

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
