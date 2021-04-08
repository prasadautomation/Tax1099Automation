package com.demo.testcases;

import java.io.File;
import java.io.FileInputStream;
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
import org.testng.annotations.Test;

import com.demo.Base.base;
import com.demo.PeopleLeftMenu.ManagePayerAddPayer;
import com.demo.PeopleLeftMenu.ManagePeople;
import com.demo.dataprovider.DataProviders;
import com.demo.pages.Db;
import com.demo.pages.LoginPage;
import com.demo.pages.OuterLoginButton;
import com.demo.utility.Log;

public class TC_MISC_GA_WH_Yes_08 extends base{
	
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
		Log.info("User is going to click on outer Login button");
		Thread.sleep(60000);
		LoginPage = OuterLoginButton.clickonLogin();
		Log.info("Enter UserName and Password");
		// Db Db =
		// LoginPage.login(prop.getProperty("UserName"),prop.getProperty("Password"));
		Db Db = LoginPage.login(Useremail, Passwd);
		Thread.sleep(40000);
	}

	@Test(priority = 2)
	public void navigate_miscform() throws InterruptedException {

		// Log.startTestCase("navigate_miscforn ");
		TC_MISC_WorkingFlow_001 caseone = new TC_MISC_WorkingFlow_001();
		caseone.navigate_1099MISCform();

	}

	@Test(priority = 3, dataProvider = "addpayerrandombusinessein", dataProviderClass = DataProviders.class)
	public void form_addpayer(HashMap<String, String> hashMapValue) throws Throwable {

		Log.startTestCase("form_addpayer");
		Thread.sleep(20000);

		WebElement addpayerbutton = getDriver().findElement(By.id("btnAddEditPayer"));
		Thread.sleep(30000);
		// addpayerbutton.click();
		JavascriptExecutor addapyerexe = (JavascriptExecutor) getDriver();
		addapyerexe.executeScript("arguments[0].click();", addpayerbutton);

		Log.info("Add payer button clicked");
		WebElement addpayerdialog = getDriver().findElement(By.id("PayerDialog"));
		Thread.sleep(10000);
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
			Thread.sleep(20000);
			Random random = new Random();
			long randomnumber = random.nextInt(1000000000);
			getDriver().findElement(By.id("PayerFedaralID")).clear();
			getDriver().findElement(By.id("PayerFedaralID")).click();
			getDriver().findElement(By.id("PayerFedaralID")).sendKeys("" + randomnumber);
			Thread.sleep(10000);
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
			Log.info("Payer ZIP:" + "35010");

			getDriver().findElement(By.id("PayerEmail")).clear();
			getDriver().findElement(By.id("PayerPhNo")).clear();

			getDriver().findElement(By.id("PayerPhNo")).sendKeys("1234567891");
			Thread.sleep(30000);
			String payerphone = getDriver().findElement(By.xpath("//input[@id='PayerPhNo']")).getAttribute("value");
			Row row19 = sheet.createRow(19);
			Cell cellzero19 = row19.createCell(0);
			Cell cellone19 = row19.createCell(1);
			cellzero19.setCellValue("Payer Phone Number");
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
			Thread.sleep(30000);

			FileOutputStream outputStream = new FileOutputStream(file);
			workbook.write(outputStream);
			workbook.close();

			if (assignpayerdialogdisplay == true) {

				getDriver().findElement(By.xpath(
						"//div[@id='AssignPayerDialog']//following-sibling::div//button[contains(text(),'Close')]"))
						.click();
				Thread.sleep(30000);
				Log.info("Added payer dialog closed");

			} else {
				Log.info("assignpayer dialog not displayed ");
			}

		}

	}

	@Test(priority = 4)
	public void recipient_WH_Pay() throws Throwable {

		Log.startTestCase("recipient_WH_Pay");
		TC_MISC_GA_WH_Yes_03 casethree = new TC_MISC_GA_WH_Yes_03();
		casethree.add_Recpt_boxamt();
		casethree.withHeld_amount_GA();
		Thread.sleep(10000);
		casethree.save_form();
		}
	@Test(priority = 5)
public void VES_Page_reconsillation_verify() throws InterruptedException, IOException {
	Log.startTestCase("VES_Page");
	TC_MISC_GA_WH_Yes_07 caseSeven = new TC_MISC_GA_WH_Yes_07();
	caseSeven.VESPage_twoforms();
	
	TC_MISC_GA_WH_Yes_03 casethree = new TC_MISC_GA_WH_Yes_03();
	casethree.state_reconsillation_page();
	casethree.form_details();
	casethree.after_reconsillation_page();
	
	//caseSeven.submit_reconsillationForm_payment();
	//caseSeven.verify_MF_MSF_MRF();
	
}
//	@Test(priority = 6)
	public void editState_MF() throws InterruptedException {
		Log.startTestCase("editState_MF");
		getDriver().manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		WebElement MFtab=getDriver().findElement(By.xpath("//input[@id='tab1']//following-sibling::label[contains(text(),'Manage Federal Forms')]"));
		Thread.sleep(5000);
		MFtab.click();
		Log.info("Manage Federal tab clicked");
		Thread.sleep(10000);
		WebElement StateName=getDriver().findElement(By.xpath("//input[@id='checkboxStateFiling1']//following-sibling::label"));
		Thread.sleep(5000);
		String Statename=StateName.getText();
		Log.info("State name is :"+Statename);
		WebElement selecttext=getDriver().findElement(By.xpath("//ul[@id='panelbar']//table//tbody//tr//td[contains(text(),'Select')]"));
		Actions secttextaction=new Actions(getDriver());
		secttextaction.moveToElement(selecttext).click().build().perform();
		Log.info("Select text clicked ");
		Thread.sleep(20000);
		WebElement selectdropdown=getDriver().findElement(By.xpath("//ul[@id='panelbar']//table//tbody//tr//td//span[contains(text(),'Select')]"));
		Actions sectdropdownaction=new Actions(getDriver());
		sectdropdownaction.moveToElement(selectdropdown).click().build().perform();
		Log.info("Select dropdown has clicked");
		Thread.sleep(15000);
		WebElement editoption=getDriver().findElement(By.xpath("//div[@id='ActionList-list']//li[contains(text(),'Edit Form')]"));
		Actions editaction=new Actions(getDriver());
		editaction.moveToElement(editoption).click().build().perform();
		Log.info("Edit form option has been selected");
		Thread.sleep(20000);
		Log.info("Form Wizard displayed with state GA");
		Select statedropdown=new Select(getDriver().findElement(By.xpath("//select[@id='State1']")));
		Thread.sleep(5000);
		statedropdown.selectByVisibleText("AL");
		Log.info("AL state has been selected");
		Thread.sleep(5000);
		WebElement alerttextelement=getDriver().findElement(By.xpath("//section[@id='alertify']//p"));
		Thread.sleep(5000);
		String alertText=alerttextelement.getText();
		Log.info("Text on alert:"+alertText);
		WebElement alertokbutton=getDriver().findElement(By.xpath("//a[@id='alertify-resetFocusBack']//following-sibling::article//button[@id='alertify-ok']"));
		Thread.sleep(5000);
		alertokbutton.click();
		Log.info("Ok Button has been clicked ");
		Thread.sleep(10000);
		WebElement saveandcontinue=getDriver().findElement(By.xpath("//input[@id='btnSaveContinue1']"));
		WebDriverWait wait=new WebDriverWait(getDriver(),20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='btnSaveContinue1']")));
		
		Actions action=new Actions(getDriver());
		action.moveToElement(saveandcontinue).click().build().perform();
		//saveandcontinue.click();
		Log.info("Clicked on Save and Continue button");
		Thread.sleep(20000);
		WebElement okbutton=getDriver().findElement(By.xpath("//button[@id='alertify-ok']"));
		Thread.sleep(5000);
		okbutton.click();
		WebElement displayedState=getDriver().findElement(By.xpath("//input[@id='checkboxStateFiling1']//following-sibling::label"));
		Thread.sleep(5000);
		String editedState=displayedState.getText();
		Log.info("State Edited as :"+editedState);
		//statedropdown.click();
		
	}
	
	
}
