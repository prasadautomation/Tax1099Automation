package com.demo.testcases;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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

public class TC_AddRecipient_006 extends base{
	
	
	LoginPage LoginPage;
	OuterLoginButton OuterLoginButton;
	Db Db;
	ManagePeople ManagePeople;
	ManagePayerAddPayer ManagePayerAddPayer;

	@Test(priority = 1, dataProvider = "credentials", dataProviderClass = DataProviders.class)
	public void clickonLoginTest(String Useremail, String Passwd) throws Throwable {
		launchApp();
		getDriver().manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		Log.startTestCase("clickonLoginTest ");
		OuterLoginButton = new OuterLoginButton();
		Log.info("User is going to clik On Outer Login Button");
		LoginPage = OuterLoginButton.clickonLogin();
		Log.info("Enter UserName and Password");
		// Db Db =
		// LoginPage.login(prop.getProperty("UserName"),prop.getProperty("Password"));
		Db Db = LoginPage.login(Useremail, Passwd);

		/*WebDriverWait wait = new WebDriverWait(getDriver(), 70);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//input[@id='userType']//following-sibling::div//div[contains(text(),'Dashboard')]")));*/
		Log.info("Verifying User is able to Login");
		
		Thread.sleep(60000);
		String actURL = Db.GetCurrentURL();
		String expectedURL = "https://www.tax1099.com/Protected/Dashboard";
		Assert.assertEquals(actURL, expectedURL);
		Log.info("Login Succesful");
		Log.endTestCase("clickonLoginTest ");

	}
	
	@Test(priority=2)
	
	public void addRecipientSSN() throws Throwable {
		
		getDriver().manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		Log.startTestCase("addRecipientEin");

		Thread.sleep(40000);

		WebElement element = getDriver().findElement(By.xpath("//p[contains(text(),'People')]"));
		WebDriverWait wait = new WebDriverWait(getDriver(), 60);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		JavascriptExecutor passwordexecutor = (JavascriptExecutor) getDriver();
		passwordexecutor.executeScript("arguments[0].click();", element);
		//Thread.sleep(60000);
		Log.info("People menu clicked");

		String menutext = getDriver().findElement(By.xpath("//*[@id='firstpane']/div[2]/p")).getText();
		Log.info("menu text:" + menutext);
		getDriver().findElement(By.xpath("//a[contains(text(),'Manage Recipient')]")).click();
		Log.info("Manage recipient clicked");
		Thread.sleep(40000);
		
		WebElement addrecipient=getDriver().findElement(By.id("btnAddPayee"));
		
		WebDriverWait addrecipientwait = new WebDriverWait(getDriver(), 50);
		addrecipientwait.until(ExpectedConditions.elementToBeClickable(addrecipient));
		Thread.sleep(50000);
		addrecipient.click();
		//JavascriptExecutor js = (JavascriptExecutor)getDriver();
		//js.executeScript("arguments[0].click();", addrecipient);
		
		
		Log.info("Add recipient button clicked ");
		Thread.sleep(30000);WebElement Lastname=getDriver().findElement(By.id("PayeeLastName"));
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyyhmmss");
		String formattedDate = sdf.format(date);
		Lastname.sendKeys("Test"+formattedDate);
		Log.info("Last name enetered with time stamp");
		getDriver().findElement(By.xpath("//input[@id='rblPayeeTypeIndividual']")).click();
		
		Thread.sleep(10000);
		Log.info("Individual type selected");
		Random random=new Random();
		int randomnumber=random.nextInt(1000000000);
		getDriver().findElement(By.id("PayeeFedaralID")).clear();
		getDriver().findElement(By.id("PayeeFedaralID")).click();
		getDriver().findElement(By.id("PayeeFedaralID")).sendKeys(""+randomnumber);
		Log.info("Random SSN entered");
		Thread.sleep(10000);
		
		

		getDriver().findElement(By.id("PayeeAddress")).sendKeys("us");	
		Log.info("Entered payee or recipient Address");
		
		getDriver().findElement(By.id("PayeeCity")).sendKeys("us");
		Log.info("Entered payee or recipient city");
		Select statedropdown=new Select(getDriver().findElement(By.id("PayeeState")));
		statedropdown.selectByVisibleText("Alabama");
		Log.info("Selected recipient state");
		getDriver().findElement(By.id("ClientRecipientId")).sendKeys("12345");
		Log.info("Entered payee or recipient ClientRecipientId");
		
		Log.info("Test business name enetered with time stamp");
		getDriver().findElement(By.id("PayeeZIP")).clear();
		getDriver().findElement(By.id("PayeeZIP")).click();
		getDriver().findElement(By.id("PayeeZIP")).sendKeys("35005");
		Log.info("Entered payee or recipient zip code");
		
		Thread.sleep(20000);
	WebElement addbutton=getDriver().findElement(By.xpath("//button[contains(text(),'Add')]"));
	addbutton.click();
		Thread.sleep(2000);
		
		Thread.sleep(20000);
		getDriver().findElement(By.id("alertify-ok")).click();
		Thread.sleep(20000);
		Log.info("Recipient successfully added");
		

	}


}
