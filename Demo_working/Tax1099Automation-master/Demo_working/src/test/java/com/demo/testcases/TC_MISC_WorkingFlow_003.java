package com.demo.testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.demo.Base.base;
import com.demo.PeopleLeftMenu.ManagePayerAddPayer;
import com.demo.PeopleLeftMenu.ManagePeople;
import com.demo.dataprovider.DataProviders;
import com.demo.pages.Db;
import com.demo.pages.LoginPage;
import com.demo.pages.OuterLoginButton;
import com.demo.utility.Log;

@Listeners(CustomListener.class)
public class TC_MISC_WorkingFlow_003 extends base{
	
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
	public void newForm_selection() throws InterruptedException {
		Log.startTestCase("newForm_selection");
		TC_MISC_WorkingFlow_001 testcaseone=new TC_MISC_WorkingFlow_001();
		testcaseone.navigate_1099MISCform();
	}

	@Test(priority = 3, dataProvider = "addpayerrandombusinessein", dataProviderClass = DataProviders.class)
	public void form_addpayer(HashMap<String, String> hashMapValue) throws Throwable {

		Log.startTestCase("form_addpayer");
		Thread.sleep(50000);

		WebElement addpayerbutton = getDriver().findElement(By.id("btnAddEditPayer"));
		Thread.sleep(50000);
		//addpayerbutton.click();
		JavascriptExecutor addapyerexe = (JavascriptExecutor) getDriver();
		addapyerexe.executeScript("arguments[0].click();", addpayerbutton);
		
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
			Thread.sleep(50000);
			Log.info("Random EIN:" + randomnumber);
			
			WebElement businessname = getDriver().findElement(By.id("PayerLastName"));

			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyyhmmss");
			String formattedDate = sdf.format(date);
			businessname.sendKeys("Test" + formattedDate);
			Thread.sleep(50000); 
			String businessanmetext=businessname.getAttribute("value");
			Log.info("Payer business name:" +businessanmetext );
			
			File file = new File("src\\test\\resources\\TestData\\TestData.xlsx");
			FileInputStream fis = new FileInputStream(file);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet("1099MISCdata");
			Row row = sheet.createRow(3);
			Cell cellzero = row.createCell(0);
			Cell cellone = row.createCell(1);
			cellzero.setCellValue("Payer Business name");
			cellone.setCellValue(businessanmetext);
			// Cell cell2 = row.createCell(1);
			// cell.setCellValue(selectedstaevalue);
			// Log.info(cell.getStringCellValue());

			FileOutputStream outputStream = new FileOutputStream(file);
			workbook.write(outputStream);
			workbook.close();

	//		String celvalue = cellone.getStringCellValue().toString();
		//	Log.info("Random Payer EIN from exceldata :" + celvalue);

			

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
			//Once done will execute all Work flows in one testNG.xml file

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
	@Test(priority=4)
	public void addrecipient_singlebox_save() throws Throwable {
		Log.startTestCase("addrecipient_singlebox_save");
		TC_MISC_WorkingFlow_001 testcaseone=new TC_MISC_WorkingFlow_001();
		testcaseone.form_addRecipient();
		testcaseone.singleBox();
		testcaseone.saveForm1099();
		
	}
	@Test(priority=5)
	public void validate_VESPage_details() throws Throwable {
		
		Log.startTestCase("validate_VESPage_details");
		TC_MISC_WorkingFlow_001 testcaseone=new TC_MISC_WorkingFlow_001();
		testcaseone.validateVES_data();
		Thread.sleep(20000);
		TC_MISC_WorkingFlow_002 selectups=new TC_MISC_WorkingFlow_002();
		selectups.selectTIN_USPS();
		selectups.paymentDetails_page();
		Thread.sleep(50000);
		selectups.manageForms_notAllowEdit();
		
		
		
	}
	@Test(priority=6)
	public void edit_payer() throws InterruptedException, IOException {
		
		getDriver().manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		WebElement editbutton=getDriver().findElement(By.xpath("//input[@id='btnEditPayer']"));
		WebElement editpayeebutton=getDriver().findElement(By.xpath("//input[@id='btnEditPayee']"));
		
		Actions editaction=new Actions(getDriver());
		editaction.moveToElement(editbutton).click().build().perform();	
				Thread.sleep(50000);
				Log.info("clicked on edit button on edit form");
		WebElement payerphone=getDriver().findElement(By.xpath("//input[@id='PayerPhNo']"));
		payerphone.clear();
		payerphone.sendKeys("523145631");
		Log.info("enetered new phone number");
		WebElement updatebutton=getDriver().findElement(By.xpath("//div[@id='PayerDialog']//following-sibling::div//button[contains(text(),'Update')]"));
		editaction.moveToElement(updatebutton).click().build().perform();
		Log.info("clicked on update button");
		WebElement updateok=getDriver().findElement(By.xpath("//a[@id='alertify-resetFocusBack']//following-sibling::article//button[@id='alertify-ok']"));
		Thread.sleep(10000);
		boolean okdisplay=updateok.isDisplayed();
		if(okdisplay==true) {
			editaction.moveToElement(updateok).click().build().perform();
			Thread.sleep(20000);
			Log.info("Ok button cliked on update popup");
			
		}else {Log.info("update payer is not possible");}
		Thread.sleep(20000);
		editaction.moveToElement(editpayeebutton).click().build().perform();
		Thread.sleep(20000);
		WebElement clientrecipientid=getDriver().findElement(By.xpath("//input[@id='EditClientRecipientId']"));
		clientrecipientid.clear();
		clientrecipientid.sendKeys("54321");
		Log.info("New client recipient id is enetered");
		WebElement payeeupdate=getDriver().findElement(By.xpath("//div[@id='EditPayeeDialog']//following-sibling::div//button[contains(text(),'Update')]"));
		editaction.moveToElement(payeeupdate).click().build().perform();
		Thread.sleep(20000);
		
		WebElement payeerupdateok=getDriver().findElement(By.xpath("//a[@id='alertify-resetFocusBack']//following-sibling::article//button[@id='alertify-ok']"));
		boolean payeeokdisplay=payeerupdateok.isDisplayed();
		if(payeeokdisplay==true) {
			editaction.moveToElement(payeerupdateok).click().build().perform();
			Thread.sleep(10000);
			Log.info("Ok button cliked on update popup");
			
		}else {Log.info("update payee is not possible");}
		File file = new File("src\\test\\resources\\TestData\\TestData.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("1099MISCdata");
		String scheduledate=sheet.getRow(7).getCell(1).toString();
		
		Log.info("Scheduled date is "+scheduledate);
		Date displaydate=new Date();
		SimpleDateFormat date=new SimpleDateFormat("MM/dd/yyyy");
		String todaysdate=date.format(displaydate);
		Log.info("Todays date in format:"+todaysdate);
		int compare=scheduledate.compareTo(todaysdate);
		Log.info("compare:"+compare);
		if(compare==1) {
			
			
			Log.info("Today's date is before schedule date");
			Log.info("Update payer or recipient data is possible");
		}
		else {Log.info("Today's date is after schedule date");
		Log.info("Update payer or recipient data is not possible");}
		
		
		
		
	}
	
	
	
	}