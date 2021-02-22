package com.demo.testcases;

import static org.testng.Assert.assertEquals;

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

public class TC_MISC_WorkingFlow_004 extends base {

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

	@Test(priority = 2)
	public void newForm_selection() throws InterruptedException {
		Log.startTestCase("newForm_selection");
		TC_MISC_WorkingFlow_001 testcaseone = new TC_MISC_WorkingFlow_001();
		testcaseone.navigate_1099MISCform();
	}

	@Test(priority = 3, dataProvider = "addpayerrandombusinessein", dataProviderClass = DataProviders.class)
	public void addPayer_recipient_boxvallue(HashMap<String, String> hashMapValue) throws Throwable {

		Log.startTestCase("form_addpayer");
		Thread.sleep(40000);

		WebElement addpayerbutton = getDriver().findElement(By.id("btnAddEditPayer"));
		Thread.sleep(50000);
		// addpayerbutton.click();
		JavascriptExecutor addapyerexe = (JavascriptExecutor) getDriver();
		addapyerexe.executeScript("arguments[0].click();", addpayerbutton);

		Log.info("Add payer button clicked");
		WebElement addpayerdialog = getDriver().findElement(By.id("PayerDialog"));
		Thread.sleep(20000);
		boolean addpayerdialogdisplay = addpayerdialog.isDisplayed();
		if (addpayerdialogdisplay == true) {
			Log.info("add payer dialog displayed");

			Thread.sleep(10000);
			File file = new File("src\\test\\resources\\TestData\\TestData.xlsx");
			FileInputStream fis = new FileInputStream(file);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet("1099MISCdata");

			WebElement type = getDriver().findElement(
					By.xpath("//div[@id='divFederalIdTypeForAllForms']//input[@id='rblPayerTypeBusiness']"));
			type.click();
			Thread.sleep(10000);
			Random random = new Random();
			int randomnumber = random.nextInt(1000000000);
			getDriver().findElement(By.id("PayerFedaralID")).clear();
			Thread.sleep(10000);
			getDriver().findElement(By.id("PayerFedaralID")).click();
			Thread.sleep(10000);

			getDriver().findElement(By.id("PayerFedaralID")).sendKeys("" + randomnumber);
			Thread.sleep(50000);
			Log.info("Random EIN:" + randomnumber);
			Row row15 = sheet.createRow(15);
			Cell cellzero15 = row15.createCell(0);
			Cell cellone15 = row15.createCell(1);
			cellzero15.setCellValue("Payer EIN number");
			cellone15.setCellValue(randomnumber);

			WebElement businessname = getDriver().findElement(By.id("PayerLastName"));

			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyyhmmss");
			String formattedDate = sdf.format(date);
			businessname.sendKeys("Test" + formattedDate);
			Thread.sleep(50000);
			String businessanmetext = businessname.getAttribute("value");
			Log.info("Payer Last name:" + businessanmetext);
			Row row = sheet.createRow(3);
			Cell cellzero = row.createCell(0);
			Cell cellone = row.createCell(1);
			cellzero.setCellValue("Payer last name");
			cellone.setCellValue(businessanmetext);
			/*
			 * Cell cell2 = row.createCell(1); // cell.setCellValue(selectedstaevalue); //
			 * Log.info(cell.getStringCellValue()); String celvalue =
			 * cellone.getStringCellValue().toString();
			 * Log.info("Random Payer EIN from exceldata :" + celvalue);
			 */

			ManagePayerAddPayer ManagePayerAddPayer = new ManagePayerAddPayer();
			// getDriver().findElement(By.id("PayerZIP")).sendKeys("35005");
			ManagePayerAddPayer.AddpayerEinNonUs(hashMapValue.get("address"), hashMapValue.get("suffix"),
					hashMapValue.get("line2"), hashMapValue.get("city"), hashMapValue.get("State"),
					hashMapValue.get("zipcode"), hashMapValue.get("Postalcode"), hashMapValue.get("Country"),

					// hashMapValue.get("checkheretoforeignaddress"),
					hashMapValue.get("phone"), hashMapValue.get("email"), hashMapValue.get("withholdingortaxstateid"),
					// hashMapValue.get("lastfiling"),
					hashMapValue.get("clientid"));
			String payeraddress = getDriver().findElement(By.xpath("//input[@id='PayerAddress']"))
					.getAttribute("value");
			Row row16 = sheet.createRow(16);
			Cell cellzero16 = row16.createCell(0);
			Cell cellone16 = row16.createCell(1);
			cellzero16.setCellValue("Payer address");
			cellone16.setCellValue(payeraddress);
			Log.info("Payer address:" + payeraddress);

			String payerCity = getDriver().findElement(By.xpath("//input[@id='PayerCity']")).getAttribute("value");
			Row row17 = sheet.createRow(17);
			Cell cellzero17 = row17.createCell(0);
			Cell cellone17 = row17.createCell(1);
			cellzero17.setCellValue("Payer City");
			cellone17.setCellValue(payerCity);
			Log.info("Payer City:" + payerCity);

			getDriver().findElement(By.id("PayerZIP")).clear();
			getDriver().findElement(By.id("PayerZIP")).click();
			getDriver().findElement(By.id("PayerZIP")).sendKeys("35010");
			Thread.sleep(10000);
			String payerZIP = getDriver().findElement(By.xpath("//input[@id='PayerZIP']")).getAttribute("value");
			Row row18 = sheet.createRow(18);
			Cell cellzero18 = row18.createCell(0);
			Cell cellone18 = row18.createCell(1);
			cellzero18.setCellValue("PayerZIP");
			cellone18.setCellValue(payerZIP);
			Log.info("Payer ZIP:" + payerZIP);

			getDriver().findElement(By.id("PayerEmail")).clear();
			getDriver().findElement(By.id("PayerPhNo")).clear();

			getDriver().findElement(By.id("PayerPhNo")).sendKeys("1234567891");
			Thread.sleep(50000);
			String payerphone = getDriver().findElement(By.xpath("//input[@id='PayerPhNo']")).getAttribute("value");
			Row row19 = sheet.createRow(19);
			Cell cellzero19 = row19.createCell(0);
			Cell cellone19 = row19.createCell(1);
			cellzero19.setCellValue("Payer phoneno");
			cellone19.setCellValue(payerphone);
			Log.info("Payer phone number:" + payerphone);

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

			FileOutputStream outputStream = new FileOutputStream(file);
			workbook.write(outputStream);
			workbook.close();

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
		TC_MISC_WorkingFlow_001 testcaseone = new TC_MISC_WorkingFlow_001();
		testcaseone.form_addRecipient();
		Log.info("Added recipient");
		testcaseone.singleBox();
		Log.info("Single box test case completed");
		testcaseone.saveForm1099();
	}

	@Test(priority = 4)
	public void edit_VESpage() throws InterruptedException, IOException {
		Log.startTestCase("edit_VESpage");
		getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Random random = new Random();
		int randomnumber = random.nextInt(1000000000);
		Actions action = new Actions(getDriver());
		// action.click().build().perform();
		WebElement editvesbutton = getDriver().findElement(By.xpath("//a[@id='editButton']"));
		action.moveToElement(editvesbutton).click().build().perform();
		Thread.sleep(50000);
		WebElement editpayer = getDriver().findElement(By.xpath("//input[@id='btnEditPayer']"));
		action.moveToElement(editpayer).click().build().perform();
		Thread.sleep(30000);

		WebElement payerEin = getDriver().findElement(By.xpath("//input[@id='PayerFedaralID']"));
		payerEin.clear();
		payerEin.click();
		payerEin.sendKeys("" + randomnumber);
		String einrandomnumber = payerEin.getAttribute("value");
		Log.info("Edited EIN number as:" + einrandomnumber);
		File file = new File("src\\test\\resources\\TestData\\TestData.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("1099MISCdata");
		// Row= row=sheet.createRow()
		Cell cellzero15 = sheet.getRow(15).createCell(2);
		Cell cellone15 = sheet.getRow(15).createCell(3);
		cellone15.setCellValue(randomnumber);
		cellzero15.setCellValue("Edited Payer EIN");

		WebElement businessname = getDriver().findElement(By.id("PayerLastName"));
		businessname.clear();
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyyhmmss");
		String formattedDate = sdf.format(date);
		businessname.sendKeys("Testedited" + formattedDate);
		Thread.sleep(50000);
		String businessanmetext = businessname.getAttribute("value");
		Log.info("Payer Business name:" + businessanmetext);
		// Row row = sheet.createRow(3);
		Cell cellzero3 = sheet.getRow(3).createCell(2);
		Cell cellone3 = sheet.getRow(3).createCell(3);
		cellzero3.setCellValue("Edited Payer Businessanme");
		cellone3.setCellValue(businessanmetext);

		WebElement payeraddress = getDriver().findElement(By.xpath("//input[@id='PayerAddress']"));
		payeraddress.clear();
		String editedpayeraddress = "US";
		payeraddress.sendKeys(editedpayeraddress);
		Thread.sleep(10000);
		Log.info("Edited payer address:" + editedpayeraddress);

		Cell cellzero16 = sheet.getRow(16).createCell(2);
		Cell cellone16 = sheet.getRow(16).createCell(3);
		cellzero16.setCellValue("Edited Payer Address");
		cellone16.setCellValue(editedpayeraddress);

		WebElement payerCity = getDriver().findElement(By.xpath("//input[@id='PayerCity']"));
		payerCity.clear();
		String editpayerCity = "MOBILE";
		payerCity.sendKeys(editpayerCity);
		Thread.sleep(10000);
		Log.info("Edited payer city:" + editpayerCity);

		Cell cellzero17 = sheet.getRow(17).createCell(2);
		Cell cellone17 = sheet.getRow(17).createCell(3);
		cellzero17.setCellValue("Edited Payer City");
		cellone17.setCellValue(editpayerCity);

		WebElement payerUpdate = getDriver().findElement(
				By.xpath("//div[@id='PayerDialog']//following-sibling::div//button[contains(text(),'Update')]"));
		action.moveToElement(payerUpdate).click().build().perform();
		Log.info("Clicked on update button on edit payer dialog");

		Thread.sleep(30000);

		String okdialogtext = getDriver().findElement(By.xpath("//section[@id='alertify']//p")).getText();

		boolean updateokdialog = getDriver().findElement(By.xpath("//a[@id='alertify-resetFocusBack']")).isDisplayed();
		Assert.assertEquals(updateokdialog, true,"Update confirmation dialog not displayed");
		
		Log.info("Update confirmation dialog displayed.");
		
		WebElement okbutton=getDriver().findElement(By.xpath("//button[@id='alertify-ok']"));
		action.moveToElement(okbutton).click().build().perform();
		Thread.sleep(20000);
		
		WebElement savebutton=getDriver().findElement(By.xpath("//input[@id='btnSaveContinue']"));
		action.moveToElement(savebutton).click().build().perform();
		Thread.sleep(30000);
		
		getDriver().navigate().refresh();
		
		//Thread.sleep(30000);
		
		action.moveToElement(editvesbutton).click().build().perform();
		Log.info("Clicked on Edit button in VES page");
		
		WebElement editrecipientbutton=getDriver().findElement(By.xpath("//input[@id='btnEditPayee']"));
		action.moveToElement(editrecipientbutton).click().build().perform();
		Thread.sleep(30000);
		Log.info("Clicked on Edit button for edit recipient details");
		boolean editrecipientdialog=getDriver().findElement(By.xpath("//div[@id='EditPayeeDialog']")).isDisplayed();
		Assert.assertEquals(editrecipientdialog, true,"Edit recipient dialog not displayed");
		Log.info("Edit Recipient dialog displayed as expected");
		
		WebElement payeeEIN = getDriver().findElement(By.xpath("//input[@id='EditPayeeFedaralID']"));
		payeeEIN.clear();
		payeeEIN.click();
		payeeEIN.sendKeys("" + randomnumber);
		String payeeeinrandomnumber = payeeEIN.getAttribute("value");
		Log.info("Edited Recipient EIN number as:" + randomnumber);
		Cell cellzero8 = sheet.getRow(8).createCell(2);
		Cell cellone8 = sheet.getRow(8).createCell(3);
		cellone8.setCellValue(randomnumber);
		cellzero8.setCellValue("Edited Payee EIN");
		
		WebElement editpayeebusinessname = getDriver().findElement(By.xpath("//input[@id='EditPayeeLastName']"));
		editpayeebusinessname.clear();
		Date payeedate = new Date();
		SimpleDateFormat editsdf = new SimpleDateFormat("MMddyyyyhmmss");
		String editformattedDate = editsdf.format(payeedate);
		editpayeebusinessname.sendKeys("EditTest" + editformattedDate);
		Thread.sleep(50000);
		String editbusinessanmetext = editpayeebusinessname.getAttribute("value");
		Log.info("Payer Business name:" + editbusinessanmetext);
		// Row row = sheet.createRow(3);
		Cell cellzero2 = sheet.getRow(2).createCell(2);
		Cell cellone2 = sheet.getRow(3).createCell(3);
		cellzero2.setCellValue("Edited Payee Businessname");
		cellone2.setCellValue(editbusinessanmetext);
		
		WebElement editPayeeUpdate=getDriver().findElement(By.xpath("//div[@id='EditPayeeDialog']//following-sibling::div//button[contains(text(),'Update')]"));
		action.moveToElement(editPayeeUpdate).click().build().perform();
		Thread.sleep(40000);
		
		boolean updateokdialogrcpt = getDriver().findElement(By.xpath("//a[@id='alertify-resetFocusBack']")).isDisplayed();
		Assert.assertEquals(updateokdialogrcpt, true,"Update confirmation dialog not displayed");
		
		Log.info("Update confirmation dialog displayed.");
		
		WebElement rcptokbutton=getDriver().findElement(By.xpath("//button[@id='alertify-ok']"));
		action.moveToElement(rcptokbutton).click().build().perform();
		Thread.sleep(40000);
		
		
		//WebElement savebutton=getDriver().findElement(By.xpath("//input[@id='btnSaveContinue']"));
		action.moveToElement(savebutton).click().build().perform();
		Thread.sleep(20000);

		FileOutputStream outputStream = new FileOutputStream(file);
		workbook.write(outputStream);
		workbook.close();
		
		///////////////////////goto dashboard//////////////////
		///////////enter edited payer name //////////////////
		//////////////check details//////////////////
		
		
	}
	
	public void compare_Dashboard() {
		
		Log.startTestCase("compare_Dashboard");
		
		
	}

}
