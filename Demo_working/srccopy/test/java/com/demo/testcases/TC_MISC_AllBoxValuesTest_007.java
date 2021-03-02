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

public class TC_MISC_AllBoxValuesTest_007 extends base {
	
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
		Thread.sleep(60000);
		LoginPage = OuterLoginButton.clickonLogin();
		Log.info("Enter UserName and Password");
		// Db Db =
		// LoginPage.login(prop.getProperty("UserName"),prop.getProperty("Password"));
		Db Db = LoginPage.login(Useremail, Passwd);
		Thread.sleep(40000);
	}

	@Test(priority = 2)
	public void navigate_1099MISCform() throws InterruptedException {

		Log.startTestCase("navigate_1099MISCform");

		Thread.sleep(40000);
		WebElement formselement = getDriver().findElement(By.xpath("//p[contains(text(),'Forms')]"));

		Thread.sleep(20000);
		// WebDriverWait wait=new WebDriverWait(getDriver(),60);
		formselement.click();

		// wait.until(ExpectedConditions.elementToBeClickable(formselement));
		// JavascriptExecutor passwordexecutor = (JavascriptExecutor) getDriver();
		// passwordexecutor.executeScript("arguments[0].click();", formselement);

		Log.info("Forms menu clicked");

		WebElement newform = getDriver().findElement(By.xpath("//a[contains(text(),'New Form')]"));
		// WebDriverWait formwait=new WebDriverWait(getDriver(),60);
		// formwait.until(ExpectedConditions.elementToBeClickable(newform));

		newform.click();
//	JavascriptExecutor newformexe = (JavascriptExecutor) getDriver();
//	newformexe.executeScript("arguments[0].click();", newform);
		Thread.sleep(60000);
		Log.info("New form menu clicked");

		WebElement yearelement = getDriver().findElement(By.xpath("//div[@id='vtab']//h1[contains(text(),'2020')]"));
		Thread.sleep(20000);
		yearelement.click();
		Log.info("year got selected");

		WebElement element1099 = getDriver().findElement(By.xpath("//div[@id='MISC']//h2[contains(text(),'1099')]"));

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

		WebElement addpayerbutton = getDriver().findElement(By.id("btnAddEditPayer"));
		Thread.sleep(80000);
		addpayerbutton.click();
		Log.info("Add payer button clicked");
		WebElement addpayerdialog = getDriver().findElement(By.id("PayerDialog"));
		Thread.sleep(20000);
		boolean addpayerdialogdisplay = addpayerdialog.isDisplayed();
		if (addpayerdialogdisplay == true) {
			Log.info("add payer dialog displayed");

			Thread.sleep(10000);

			WebElement type = getDriver().findElement(
					By.xpath("//div[@id='divFederalIdTypeForAllForms']//input[@id='rblPayerTypeBusiness']"));
			type.click();
			Thread.sleep(10000);
			Random random = new Random();
			int randomnumber = random.nextInt(1000000000);
			getDriver().findElement(By.id("PayerFedaralID")).clear();
			getDriver().findElement(By.id("PayerFedaralID")).click();
			getDriver().findElement(By.id("PayerFedaralID")).sendKeys("" + randomnumber);
			Thread.sleep(80000);
			Log.info("Random EIN:" + randomnumber);

			WebElement businessname = getDriver().findElement(By.id("PayerLastName"));

			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyyhmmss");
			String formattedDate = sdf.format(date);
			businessname.sendKeys("Test" + formattedDate);

			ManagePayerAddPayer ManagePayerAddPayer = new ManagePayerAddPayer();
			// getDriver().findElement(By.id("PayerZIP")).sendKeys("35005");
			ManagePayerAddPayer.AddpayerEinNonUs(hashMapValue.get("address"), hashMapValue.get("suffix"),
					hashMapValue.get("line2"), hashMapValue.get("city"), hashMapValue.get("State"),
					hashMapValue.get("zipcode"), hashMapValue.get("Postalcode"), hashMapValue.get("Country"),

					// hashMapValue.get("checkheretoforeignaddress"),
					hashMapValue.get("phone"), hashMapValue.get("email"), hashMapValue.get("withholdingortaxstateid"),
					// hashMapValue.get("lastfiling"),
					hashMapValue.get("clientid"));

			getDriver().findElement(By.id("PayerZIP")).clear();
			getDriver().findElement(By.id("PayerZIP")).click();
			getDriver().findElement(By.id("PayerZIP")).sendKeys("35010");
			getDriver().findElement(By.id("PayerEmail")).clear();
			getDriver().findElement(By.id("PayerPhNo")).clear();

			getDriver().findElement(By.id("PayerPhNo")).sendKeys("1234567891");
			Select statedropdown = new Select(getDriver().findElement(By.id("PayerState")));
			statedropdown.selectByVisibleText("Alabama");
			Thread.sleep(50000);
			// ManagePayerAddPayer.validateAddEINpayer();
			// getDriver().findElement(By.xpath("//button[contains(text(),'Add')]")).click();

			WebElement addpayerAdd = getDriver().findElement(
					By.xpath("//div[@id='PayerDialog']//following-sibling::div//button[contains(text(),'Add')]"));
			WebDriverWait wait = new WebDriverWait(getDriver(), 50);
			wait.until(ExpectedConditions.elementToBeClickable(addpayerAdd));

			addpayerAdd.click();

			Thread.sleep(40000);
			Log.info("Add button clicked on add payer dialog");

			getDriver().findElement(By.id("alertify-ok")).click();
			Thread.sleep(20000);
			Log.info("Added payer alert clicked ");

			WebElement assignpayerDialog = getDriver().findElement(By.xpath("//div[@id='AssignPayerDialog']"));
			boolean assignpayerdialogdisplay = assignpayerDialog.isDisplayed();

			// getDriver().findElement(By.id("alertify-ok")).click();
			Thread.sleep(50000);

			if (assignpayerdialogdisplay == true) {

				getDriver().findElement(By.xpath(
						"//div[@id='AssignPayerDialog']//following-sibling::div//button[contains(text(),'Close')]"))
						.click();
				Thread.sleep(50000);
				Log.info("Added payer dialog closed");

			} else {
				Log.info("assignpayer dialog not displayed ");
			}

		}

	}

	@Test(priority = 4)
	public void form_addRecipient() throws Throwable {

		getDriver().manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		getDriver().findElement(By.id("btnAddPayee")).click();
		Thread.sleep(50000);

		getDriver().findElement(By.xpath("//input[@id='rblPayeeType']")).click();

		Thread.sleep(10000);
		Log.info("Business type selected");
		Random random = new Random();
		int randomnumber = random.nextInt(1000000000);
		getDriver().findElement(By.id("PayeeFedaralID")).clear();
		getDriver().findElement(By.id("PayeeFedaralID")).click();
		getDriver().findElement(By.id("PayeeFedaralID")).sendKeys("" + randomnumber);
		Log.info("Random EIN entered");
		Thread.sleep(40000);

		WebElement businessname = getDriver().findElement(By.id("PayeeLastName"));

		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyyhmmss");
		String formattedDate = sdf.format(date);
		businessname.sendKeys("Test" + formattedDate);

		Log.info("Test business name enetered with time stamp");
		getDriver().findElement(By.id("PayeeZIP")).clear();
		getDriver().findElement(By.id("PayeeZIP")).click();
		getDriver().findElement(By.id("PayeeZIP")).sendKeys("35005");
		Log.info("Entered payee or recipient zip code");

		getDriver().findElement(By.id("PayeeAddress")).sendKeys("us");
		Log.info("Entered payee or recipient Address");
		getDriver().findElement(By.id("PayeeCity")).sendKeys("us");
		Log.info("Entered payee or recipient city");
		Select statedropdown = new Select(getDriver().findElement(By.id("PayeeState")));
		statedropdown.selectByVisibleText("Alabama");
		Log.info("Selected recipient state");
		getDriver().findElement(By.id("ClientRecipientId")).sendKeys("12345");
		Log.info("Entered payee or recipient ClientRecipientId");
		ManagePayerAddPayer ManagePayerAddPayer = new ManagePayerAddPayer();

		/*
		 * ManagePayerAddPayer.AddrecipientrandombusinessEIN( //
		 * hashMapValue.get("type"), // hashMapValue.get("einTIN"), //
		 * hashMapValue.get("ssn"), // hashMapValue.get("FirstName"), //
		 * hashMapValue.get("MiddleName"), //hashMapValue.get("LastName"), //
		 * hashMapValue.get("businessname"), hashMapValue.get("payeeAddress"),
		 * hashMapValue.get("suffix"), hashMapValue.get("payeeline2"),
		 * hashMapValue.get("payeecity"), //hashMapValue.get("State"),
		 * hashMapValue.get("zipcode"), hashMapValue.get("Country"),
		 * 
		 * // hashMapValue.get("checkheretoforeignaddress"), hashMapValue.get("phone"),
		 * hashMapValue.get("email"), hashMapValue.get("withholdingortaxstateid"), //
		 * hashMapValue.get("lastfiling"), hashMapValue.get("clientid"));
		 */

		ManagePayerAddPayer.validateAddEINpayer();
		Thread.sleep(80000);
		getDriver().findElement(By.id("alertify-ok")).click();
		Log.info("Ok button clicked on Recipient successfully added alert");
		Thread.sleep(20000);

	}
	@Test(priority=5)
	 public void includeBox4_TestValue() throws InterruptedException {
		 
		 Log.startTestCase("includeBox4_TestValue");
		 getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		 
		 Thread.sleep(50000);
		 getDriver().manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		
		//--only box4 entered --// 
		    getDriver().findElement(By.xpath("//input[@id='FederalIncomeTaxWH']")).clear();
			getDriver().findElement(By.xpath("//input[@id='FederalIncomeTaxWH']")).sendKeys("19.20");
			Log.info("Box4 value enetered-19.20");
			Thread.sleep(80000);
		 //	getDriver().findElement(By.xpath("//input[@id='btnSaveContinue']")).click();
		//	Log.info("Save and continue button clicked after enter box4-24 value");
			//Thread.sleep(50000);
			//keyF8();
			//Thread.sleep(20000);
			getDriver().findElement(By.id("alertify-ok")).click();
			Log.info("Alert displayed \r\n"
					+ "Reset Focus\r\n"
					+ "Enter Box 1,2,3,5,6,8,10,13,& 14 amount to calculate Box 4 amount");
			
		//---BOX1 value 10 eneterd---//	
			
			getDriver().findElement(By.xpath("//input[@id='Rents']")).clear();
			getDriver().findElement(By.xpath("//input[@id='Rents']")).sendKeys("10");
			Log.info("Box1 value enetered-10");
			Thread.sleep(80000);
			
		 //	getDriver().findElement(By.xpath("//input[@id='btnSaveContinue']")).click();
			//Log.info("Save and continue button clicked after enter box4-24 and Box1-10 value");
			
	//		keyF8();
	//		Thread.sleep(20000);
			getDriver().findElement(By.id("alertify-ok")).click();
			//Log.info("Box 4 amount should not exceed 24% of Box 1,2,3,5,6,8,10,13,& 14 amount, $2.40");
			Log.info("Alert displayed Enter Box 1,2,3,5,6,8,10,13,& 14 amount to calculate Box 4 amount");
			
			//--Box2 value 10 entered---//
			
			getDriver().findElement(By.xpath("//input[@id='Royalities']")).clear();
			getDriver().findElement(By.xpath("//input[@id='Royalities']")).sendKeys("10");
			Log.info("Box2 value enetered-10");
			Thread.sleep(50000);
			
		 //	getDriver().findElement(By.xpath("//input[@id='btnSaveContinue']")).click();
		//	Log.info("Save and continue button clicked after enter box4-24 and Box2-10 value");
			
		//	keyF8();
		//	Thread.sleep(20000);
			getDriver().findElement(By.id("alertify-ok")).click();
			//Log.info("Box 4 amount should not exceed 24% of Box 1,2,3,5,6,8,10,13,& 14 amount, $2.40");
			Log.info("Box 4 amount should not exceed 24% of Box 1,2,3,5,6,8,10,13,& 14 amount, $4.80.");

//---Box3 value 10 eneterd---//
			
			getDriver().findElement(By.xpath("//input[@id='OtherIncome']")).clear();
			getDriver().findElement(By.xpath("//input[@id='OtherIncome']")).sendKeys("10");
			Log.info("Box3 value enetered-10");
			Thread.sleep(50000);
			
		 //	getDriver().findElement(By.xpath("//input[@id='btnSaveContinue']")).click();
		//	Log.info("Save and continue button clicked after enter box4-24 and Box2-10 value");
			
		//	keyF8();
		//	Thread.sleep(20000);
			getDriver().findElement(By.id("alertify-ok")).click();
			//Log.info("Box 4 amount should not exceed 24% of Box 1,2,3,5,6,8,10,13,& 14 amount, $2.40");
			Log.info("Box 4 amount should not exceed 24% of Box 1,2,3,5,6,8,10,13,& 14 amount, $7.20.");
					
			
			//---Box5 value 10 eneterd---//
			
			getDriver().findElement(By.xpath("//input[@id='Fishing']")).clear();
			getDriver().findElement(By.xpath("//input[@id='Fishing']")).sendKeys("10");
			Log.info("Box5 value enetered-10");
			Thread.sleep(50000);
			
		 //	getDriver().findElement(By.xpath("//input[@id='btnSaveContinue']")).click();
		//	Log.info("Save and continue button clicked after enter box4-24 and Box2-10 value");
			
		//	keyF8();
		//	Thread.sleep(20000);
			getDriver().findElement(By.id("alertify-ok")).click();
			//Log.info("Box 4 amount should not exceed 24% of Box 1,2,3,5,6,8,10,13,& 14 amount, $2.40");
			Log.info("Box 4 amount should not exceed 24% of Box 1,2,3,5,6,8,10,13,& 14 amount, $9.60.");
		 
//---Box6 value 10 eneterd---//
			
			getDriver().findElement(By.xpath("//input[@id='Medical']")).clear();
			getDriver().findElement(By.xpath("//input[@id='Medical']")).sendKeys("10");
			Log.info("Box6 value enetered-10");
			Thread.sleep(50000);
			
		 //	getDriver().findElement(By.xpath("//input[@id='btnSaveContinue']")).click();
		//	Log.info("Save and continue button clicked after enter box4-24 and Box2-10 value");
			
		//	keyF8();
		//	Thread.sleep(20000);
			getDriver().findElement(By.id("alertify-ok")).click();
			//Log.info("Box 4 amount should not exceed 24% of Box 1,2,3,5,6,8,10,13,& 14 amount, $2.40");
			Log.info("Box 4 amount should not exceed 24% of Box 1,2,3,5,6,8,10,13,& 14 amount, $12.00."); 
	
//---Box8 value 10 eneterd---//
			
			getDriver().findElement(By.xpath("//input[@id='DividendsORInterest']")).clear();
			getDriver().findElement(By.xpath("//input[@id='DividendsORInterest']")).sendKeys("10");
			Log.info("Box8 value enetered-10");
			Thread.sleep(50000);
			
		 //	getDriver().findElement(By.xpath("//input[@id='btnSaveContinue']")).click();
		//	Log.info("Save and continue button clicked after enter box4-24 and Box2-10 value");
			
		//	keyF8();
		//	Thread.sleep(20000);
			getDriver().findElement(By.id("alertify-ok")).click();
			//Log.info("Box 4 amount should not exceed 24% of Box 1,2,3,5,6,8,10,13,& 14 amount, $2.40");
			Log.info("Box 4 amount should not exceed 24% of Box 1,2,3,5,6,8,10,13,& 14 amount, $14.40.");
			
//---Box10 value 10 eneterd---//
			
			getDriver().findElement(By.xpath("//input[@id='GrossProceeds']")).clear();
			getDriver().findElement(By.xpath("//input[@id='GrossProceeds']")).sendKeys("10");
			Log.info("Box10 value enetered-10");
			Thread.sleep(50000);
			
		 //	getDriver().findElement(By.xpath("//input[@id='btnSaveContinue']")).click();
		//	Log.info("Save and continue button clicked after enter box4-24 and Box2-10 value");
			
		//	keyF8();
		//	Thread.sleep(20000);
			getDriver().findElement(By.id("alertify-ok")).click();
			//Log.info("Box 4 amount should not exceed 24% of Box 1,2,3,5,6,8,10,13,& 14 amount, $2.40");
			Log.info("Box 4 amount should not exceed 24% of Box 1,2,3,5,6,8,10,13,& 14 amount, $16.80.");
						
//---Box13 value 10 eneterd---//
			
			getDriver().findElement(By.xpath("//input[@id='ExcessGolden']")).clear();
			getDriver().findElement(By.xpath("//input[@id='ExcessGolden']")).sendKeys("10");
			Log.info("Box13 value enetered-10");
			Thread.sleep(50000);
			
		 //	getDriver().findElement(By.xpath("//input[@id='btnSaveContinue']")).click();
		//	Log.info("Save and continue button clicked after enter box4-24 and Box2-10 value");
			
		//	keyF8();
		//	Thread.sleep(20000);
			getDriver().findElement(By.id("alertify-ok")).click();
			//Log.info("Box 4 amount should not exceed 24% of Box 1,2,3,5,6,8,10,13,& 14 amount, $2.40");
			Log.info("Box 4 amount should not exceed 24% of Box 1,2,3,5,6,8,10,13,& 14 amount, $19.20.");
			
			
//---Box14 value 10 eneterd---//
			
			getDriver().findElement(By.xpath("//input[@id='NonqualifiedDefCom']")).clear();
			getDriver().findElement(By.xpath("//input[@id='NonqualifiedDefCom']")).sendKeys("10");
			Log.info("Box14 value enetered-10");
			Thread.sleep(50000);
			
		 //	getDriver().findElement(By.xpath("//input[@id='btnSaveContinue']")).click();
		//	Log.info("Save and continue button clicked after enter box4-24 and Box2-10 value");
			
		//	keyF8();
		//	Thread.sleep(20000);
			getDriver().findElement(By.id("alertify-ok")).click();
			//Log.info("Box 4 amount should not exceed 24% of Box 1,2,3,5,6,8,10,13,& 14 amount, $2.40");
			Log.info("Box 4 amount should not exceed 24% of Box 1,2,3,5,6,8,10,13,& 14 amount, $19.20.");
			
			Thread.sleep(50000);
			getDriver().findElement(By.xpath("//input[@id='btnSaveContinue']")).click();
			
			
			
	}

}
