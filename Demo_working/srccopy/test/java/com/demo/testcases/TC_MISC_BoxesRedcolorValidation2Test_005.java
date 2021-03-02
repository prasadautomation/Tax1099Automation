package com.demo.testcases;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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

public class TC_MISC_BoxesRedcolorValidation2Test_005 extends base{
	
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
		Thread.sleep(80000);
		LoginPage = OuterLoginButton.clickonLogin();
		Log.info("Enter UserName and Password");
		// Db Db =
		// LoginPage.login(prop.getProperty("UserName"),prop.getProperty("Password"));
		Db Db = LoginPage.login(Useremail, Passwd);
	Thread.sleep(40000);
	}
	@Test(priority=2)
	public void navigate_1099MISCform() throws InterruptedException {
		

		Log.startTestCase("navigate_1099MISCform");
		
		Thread.sleep(40000);
		WebElement formselement=getDriver().findElement(By.xpath("//p[contains(text(),'Forms')]"));
		
		Thread.sleep(20000);
	//WebDriverWait wait=new WebDriverWait(getDriver(),60);
	formselement.click();
	
	//wait.until(ExpectedConditions.elementToBeClickable(formselement));
	//JavascriptExecutor passwordexecutor = (JavascriptExecutor) getDriver();
	//passwordexecutor.executeScript("arguments[0].click();", formselement);
	
	Log.info("Forms menu clicked");
	

	WebElement newform=getDriver().findElement(By.xpath("//a[contains(text(),'New Form')]"));
	//WebDriverWait formwait=new WebDriverWait(getDriver(),60);
	//formwait.until(ExpectedConditions.elementToBeClickable(newform));
	
	newform.click();
//	JavascriptExecutor newformexe = (JavascriptExecutor) getDriver();
//	newformexe.executeScript("arguments[0].click();", newform);
	Thread.sleep(60000);
	Log.info("New form menu clicked");
	
	WebElement yearelement=getDriver().findElement(By.xpath("//div[@id='vtab']//h1[contains(text(),'2020')]"));
	Thread.sleep(20000);
	yearelement.click();
	Log.info("year got selected");
	
	WebElement element1099 =getDriver().findElement(By.xpath("//div[@id='MISC']//h2[contains(text(),'1099')]"));

	Thread.sleep(20000);
	element1099.click();
	Thread.sleep(20000);
	Log.info("1099 misc got selected");
	
	Thread.sleep(60000);
	
			
	}
	@Test(priority = 3, dataProvider = "addpayerrandombusinessein", dataProviderClass = DataProviders.class)
	public void form_addpayer(HashMap<String, String> hashMapValue) throws Throwable {
		
		Log.startTestCase("form_addpayer");
		Thread.sleep(80000);
	
		WebElement addpayerbutton =getDriver().findElement(By.id("btnAddEditPayer"));
		Thread.sleep(80000);
		addpayerbutton.click();
		Log.info("Add payer button clicked");
		WebElement addpayerdialog=getDriver().findElement(By.id("PayerDialog"));
		Thread.sleep(20000);
		boolean addpayerdialogdisplay=addpayerdialog.isDisplayed();
		if(addpayerdialogdisplay==true) {
			Log.info("add payer dialog displayed");
		
Thread.sleep(10000);
			
			WebElement type=getDriver().findElement(By.xpath("//div[@id='divFederalIdTypeForAllForms']//input[@id='rblPayerTypeBusiness']"));
			type.click();
			Thread.sleep(10000);
			Random random=new Random();
			int randomnumber=random.nextInt(1000000000);
			getDriver().findElement(By.id("PayerFedaralID")).clear();
			getDriver().findElement(By.id("PayerFedaralID")).click();
			getDriver().findElement(By.id("PayerFedaralID")).sendKeys(""+randomnumber);
			Thread.sleep(50000);
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
						hashMapValue.get("phone"), 
						hashMapValue.get("email"), 
						hashMapValue.get("withholdingortaxstateid"),
						// hashMapValue.get("lastfiling"),
						hashMapValue.get("clientid"));
			
			getDriver().findElement(By.id("PayerZIP")).clear();
			getDriver().findElement(By.id("PayerZIP")).click();
			getDriver().findElement(By.id("PayerZIP")).sendKeys("35010");
			getDriver().findElement(By.id("PayerEmail")).clear();
			getDriver().findElement(By.id("PayerPhNo")).clear();
			
			getDriver().findElement(By.id("PayerPhNo")).sendKeys("1234567891");
			Select statedropdown=new Select(getDriver().findElement(By.id("PayerState")));
			statedropdown.selectByVisibleText("Alabama");
			Thread.sleep(50000);
		//	ManagePayerAddPayer.validateAddEINpayer();
		//	getDriver().findElement(By.xpath("//button[contains(text(),'Add')]")).click();
			
			WebElement addpayerAdd=getDriver().findElement(By.xpath("//div[@id='PayerDialog']//following-sibling::div//button[contains(text(),'Add')]"));
			WebDriverWait wait=new WebDriverWait(getDriver(),50);
			wait.until(ExpectedConditions.elementToBeClickable(addpayerAdd));
			
		addpayerAdd.click();
			
			Thread.sleep(40000);
			Log.info("Add button clicked on add payer dialog");
			
			getDriver().findElement(By.id("alertify-ok")).click();
			Thread.sleep(20000);
			Log.info("Added payer alert clicked ");
			
			WebElement assignpayerDialog=getDriver().findElement(By.xpath("//div[@id='AssignPayerDialog']"));
			boolean assignpayerdialogdisplay=assignpayerDialog.isDisplayed();
			
		//	getDriver().findElement(By.id("alertify-ok")).click();
			Thread.sleep(50000);
			
			
			if (assignpayerdialogdisplay==true) {
				
				getDriver().findElement(By.xpath("//div[@id='AssignPayerDialog']//following-sibling::div//button[contains(text(),'Close')]")).click();
				Thread.sleep(50000);
				Log.info("Added payer dialog closed");
				
			}else {Log.info("assignpayer dialog not displayed ");}
			
			
			
			
		}
		
		
		
		
		
		
		
	}
	@Test(priority=4)
	public void form_addRecipient() throws Throwable {
		
		getDriver().manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
		getDriver().findElement(By.id("btnAddPayee")).click();
Thread.sleep(50000);
		
		getDriver().findElement(By.xpath("//input[@id='rblPayeeType']")).click();
		
		Thread.sleep(10000);
		Log.info("Business type selected");
		Random random=new Random();
		int randomnumber=random.nextInt(1000000000);
		getDriver().findElement(By.id("PayeeFedaralID")).clear();
		getDriver().findElement(By.id("PayeeFedaralID")).click();
		getDriver().findElement(By.id("PayeeFedaralID")).sendKeys(""+randomnumber);
		Log.info("Random EIN entered");
		Thread.sleep(10000);
		
WebElement businessname=getDriver().findElement(By.id("PayeeLastName"));
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyyhmmss");
		String formattedDate = sdf.format(date);
		businessname.sendKeys("Test"+formattedDate);
		
		Log.info("Test business name enetered with time stamp");
		getDriver().findElement(By.id("PayeeZIP")).clear();
		getDriver().findElement(By.id("PayeeZIP")).click();
		getDriver().findElement(By.id("PayeeZIP")).sendKeys("35005");
		Log.info("Entered payee or recipient zip code");
		
		
	getDriver().findElement(By.id("PayeeAddress")).sendKeys("us");	
	Log.info("Entered payee or recipient Address");
	getDriver().findElement(By.id("PayeeCity")).sendKeys("us");
	Log.info("Entered payee or recipient city");
	Select statedropdown=new Select(getDriver().findElement(By.id("PayeeState")));
	statedropdown.selectByVisibleText("Alabama");
	Log.info("Selected recipient state");
	getDriver().findElement(By.id("ClientRecipientId")).sendKeys("12345");
	Log.info("Entered payee or recipient ClientRecipientId");
	ManagePayerAddPayer ManagePayerAddPayer = new ManagePayerAddPayer();
		
	/*	ManagePayerAddPayer.AddrecipientrandombusinessEIN(
				// hashMapValue.get("type"),
			//	hashMapValue.get("einTIN"),
				// hashMapValue.get("ssn"),
				// hashMapValue.get("FirstName"),
				// hashMapValue.get("MiddleName"),
				 //hashMapValue.get("LastName"),
			//	hashMapValue.get("businessname"), 
				hashMapValue.get("payeeAddress"), hashMapValue.get("suffix"),
				hashMapValue.get("payeeline2"),
				hashMapValue.get("payeecity"), //hashMapValue.get("State"),
				hashMapValue.get("zipcode"), hashMapValue.get("Country"),
				
				// hashMapValue.get("checkheretoforeignaddress"),
				hashMapValue.get("phone"), hashMapValue.get("email"), hashMapValue.get("withholdingortaxstateid"),
				// hashMapValue.get("lastfiling"),
				hashMapValue.get("clientid"));*/
		
		
				ManagePayerAddPayer.validateAddEINpayer();
			Thread.sleep(50000);
			getDriver().findElement(By.id("alertify-ok")).click();
			Log.info("Ok button clicked on Recipient successfully added alert");
			Thread.sleep(20000);
		
	}
	
	@Test(priority=5)
	public void notSelect_BoxValue() throws Throwable {
	
		Log.startTestCase("notSelect_BoxValue");
	//	TC_MISC_VerifyBox4PopupMessageTest_001 navigationmethod=new TC_MISC_VerifyBox4PopupMessageTest_001();
		//navigationmethod.navigate_1099MISCform();
		
		Thread.sleep(50000);
		
		getDriver().findElement(By.xpath("//input[@id='btnSaveContinue']")).click();
		Log.info("Save and continue button clicked");
		Thread.sleep(30000);
		
		WebElement nodataerror=getDriver().findElement(By.xpath("//span[@id='spnError']"));
		boolean errordisplay=nodataerror.isDisplayed();
		
		if(errordisplay==true) {
			
			Log.info("Please fix the errors before proceeding. error displayed");
		}else {Log.info("error not displayed test case failed");}

	}

}
