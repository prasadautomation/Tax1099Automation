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
import org.openqa.selenium.Keys;
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

public class TC_MISC_AL_WH_Yes_02 extends base {

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
		Thread.sleep(40000);
		LoginPage = OuterLoginButton.clickonLogin();
		Log.info("Enter UserName and Password");
		// Db Db =
		// LoginPage.login(prop.getProperty("UserName"),prop.getProperty("Password"));
		Db Db = LoginPage.login(Useremail, Passwd);
		Thread.sleep(20000);
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
		Thread.sleep(15000);
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
			Thread.sleep(20000);
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
	public void add_Recpt_boxamt() throws Throwable {

		TC_MISC_WorkingFlow_001 caseone = new TC_MISC_WorkingFlow_001();
		caseone.form_addRecipient();
		caseone.singleBox();
		// caseone.saveForm1099();

	}

	@Test(priority = 5)
	public void whamount_AL() throws InterruptedException {

		Log.startTestCase("whamount_AL");

		// getDriver().findElement(By.id("PayerStateNo1")).clear();
		// getDriver().findElement(By.id("PayerStateNo1")).sendKeys("123456789");
		// Log.info("Entered state number:123456789");

		WebElement whamountbox = getDriver().findElement(By.xpath("//input[@id='StateTaxWH1']"));
		whamountbox.sendKeys("200");
		Log.info("Withheld amount entered:200");
		WebElement whamountboxtwo = getDriver().findElement(By.xpath("//input[@id='StateTaxWH2']"));

		whamountboxtwo.sendKeys(Keys.ENTER);

		Thread.sleep(5000);

		WebElement whamountOk = getDriver()
				.findElement(By.xpath("//section[@id='alertify']//button[@id='alertify-ok']"));
		JavascriptExecutor whamountOkexe = (JavascriptExecutor) getDriver();
		whamountOkexe.executeScript("arguments[0].click();", whamountOk);
		Log.info("Clicked OK button on alert ");
		Thread.sleep(10000);

		TC_MISC_WorkingFlow_001 caseone = new TC_MISC_WorkingFlow_001();
		caseone.saveForm1099();

		// TC_MISC_GA_WH_Yes_01 caseWHone=new TC_MISC_GA_WH_Yes_01();
		// caseWHone.verify_VES();

	}

	@Test(priority = 6)
	public void removeStefiling_VES() {

		Log.startTestCase("removeStefiling_VES");
		WebElement stateselected = getDriver().findElement(By.xpath("//input[@id='checkboxStateFiling']"));
		boolean isstatefilingchecked = getDriver().findElement(By.xpath("//input[@id='checkboxStateFiling']"))
				.isSelected();
		Log.info("Is AL state filing selected:" + isstatefilingchecked);
		if (isstatefilingchecked == true) {

			JavascriptExecutor selectexe = (JavascriptExecutor) getDriver();
			selectexe.executeScript("arguments[0].click();", stateselected);
			Log.info("AL statefiling unchecked");

		} else {
			Log.info("AL statefiling not checked so, no need to uncheck ");
		}
	}

	@Test(priority = 7)
	public void verifyVES_ALuncheck() throws InterruptedException {

		Log.startTestCase("verifyVES_ALuncheck");
		getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		WebElement statefilingcheckbox = getDriver().findElement(By.xpath("//input[@id='checkboxStateFiling']"));
		boolean statefilingchecked = statefilingcheckbox.isSelected();
		Log.info("Statefiling for AL checked:" + statefilingchecked);
		Thread.sleep(5000);
		WebElement selectallcheckbox = getDriver().findElement(By.xpath("//input[@id='selectallGlobal']"));
		JavascriptExecutor selectallexe = (JavascriptExecutor) getDriver();
		selectallexe.executeScript("arguments[0].click();", selectallcheckbox);
		Log.info("Select all checkbox checked");

		getDriver().findElement(By.xpath("//input[@id='btnSubmit']")).click();
		Log.info("Next button clicked");
		Thread.sleep(10000);
		getDriver().findElement(By.id("alertify-ok")).click();
		Thread.sleep(5000);

		Log.info("Clicked OK ");
		
		Thread.sleep(5000);
		WebElement submitnext=getDriver().findElement(By.xpath("//input[@id='btnSubmit']"));
		
		JavascriptExecutor submitnextexe = (JavascriptExecutor) getDriver();
		submitnextexe.executeScript("arguments[0].click();", submitnext);
		
		Thread.sleep(5000);
		getDriver().findElement(By.id("alertify-ok")).click();
		
		
		Thread.sleep(5000);
Log.info("Clicked OK again");
		//Thread.sleep(5000);
		//getDriver().findElement(By.xpath("//input[@id='btnSubmit']")).click();

		WebElement alertone = getDriver().findElement(By.xpath("//input[@id='AgreeChkBoxId']"));
		JavascriptExecutor alertoneexe = (JavascriptExecutor) getDriver();
		alertoneexe.executeScript("arguments[0].click();", alertone);
		Log.info("Check box selected for reviewed dialog");
		Thread.sleep(5000);

		WebElement alerttwo = getDriver().findElement(By.id("alertify-ok"));
		JavascriptExecutor alerttwoexe = (JavascriptExecutor) getDriver();
		alerttwoexe.executeScript("arguments[0].click();", alerttwo);
		Log.info("Clicked ok on agree alert box");
	}
	@Test(priority=8)
	public void payment_page_without_statefiling() throws InterruptedException, IOException {
		
		Log.startTestCase("payment_page_without_statefiling");
		//TC_MISC_AL_WH_Yes_01 alcaseone=new TC_MISC_AL_WH_Yes_01();
		//alcaseone.paymentpage();
		
	Log.info("--e-Filing Fee Summary--");
		Thread.sleep(10000);
		
		String Formcounttext = getDriver().findElement(By.xpath("//label[contains(text(),'Form Count')]")).getText();
		String numberofforms = getDriver().findElement(By.xpath("//label[@id='SubmittedFormsCount']")).getText();
		Log.info(Formcounttext + ":" + numberofforms);
		String efilingfeeText = getDriver().findElement(By.xpath("//Label[contains(text(),'e-Filing')]")).getText();
		String priceofefiling = getDriver().findElement(By.xpath("//Label[@id='FilingFee']")).getText();
		Log.info(efilingfeeText + ":" + "$" + priceofefiling);
		String tinMatchtext = getDriver().findElement(By.xpath("//label[contains(text(),'TIN Match Fee:')]")).getText();
		String tinMatchfee = getDriver().findElement(By.xpath("//Label[@id='TinMatchFee']")).getText();
		Log.info(tinMatchtext + ":" + "$" + tinMatchfee);

		String uspsMailingfeetext = getDriver().findElement(By.xpath("//label[contains(text(),'USPS Mailing Fee')]"))
				.getText();
		String uspsMailingfee = getDriver().findElement(By.xpath("//Label[@id='MailingFee']")).getText();
		Log.info(uspsMailingfeetext + ":" + "$" + uspsMailingfee);

		String stateFilingtext = getDriver().findElement(By.xpath("//label[contains(text(),'State Filing')]"))
				.getText();
		String stateFilingfee = getDriver().findElement(By.xpath("//Label[@id='StateFilingFee']")).getText();
		Log.info(stateFilingtext + ":" + "$" + stateFilingfee);
		
		WebElement paybutton=getDriver().findElement(By.id("btnPay"));
		JavascriptExecutor paybuttonexe = (JavascriptExecutor) getDriver();
		paybuttonexe.executeScript("arguments[0].click();", paybutton);
		Log.info("Clicked on payment button");
		Thread.sleep(10000);
		
		
		
		TC_MISC_WorkingFlow_001 firstflow=new TC_MISC_WorkingFlow_001();
		
		firstflow.payment_confirmationPage();
		Thread.sleep(20000);
		firstflow.filing_history();
		Thread.sleep(20000);
		
		
		
		//TC_MISC_WorkingFlow_001 firstflow=new TC_MISC_WorkingFlow_001();
		//firstflow.filing_history();
		
	}

}
