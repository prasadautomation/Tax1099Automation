package com.demo.testcases;

import static org.testng.Assert.assertEquals;

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

public class TC_NEC_AL_WH_Yes_01 extends base {

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
		Thread.sleep(30000);
	}

	@Test(priority = 2)
	public void navigate_necform() throws InterruptedException {

		Log.startTestCase("navigate_1099NECform");

		Thread.sleep(20000);
		WebElement formselement = getDriver().findElement(By.xpath("//p[contains(text(),'Forms')]"));

		Thread.sleep(20000);
		// WebDriverWait wait=new WebDriverWait(getDriver(),60);
		formselement.click();

		Log.info("Forms menu clicked");

		WebElement newform = getDriver().findElement(By.xpath("//a[contains(text(),'New Form')]"));
		// WebDriverWait formwait=new WebDriverWait(getDriver(),60);
		// formwait.until(ExpectedConditions.elementToBeClickable(newform));
		Thread.sleep(20000);
		newform.click();
//	JavascriptExecutor newformexe = (JavascriptExecutor) getDriver();
//	newformexe.executeScript("arguments[0].click();", newform);
		Thread.sleep(20000);
		Log.info("New form menu clicked");

		WebElement yearelement = getDriver().findElement(By.xpath("//div[@id='vtab']//h1[contains(text(),'2020')]"));
		Thread.sleep(20000);
		yearelement.click();
		Log.info("year got selected");

		WebElement element1099 = getDriver().findElement(By.xpath("//div[@id='NEC']//h2[contains(text(),'1099')]"));

		Thread.sleep(20000);
		Actions action = new Actions(getDriver());
		action.moveToElement(element1099).click().build().perform();
		// element1099.click();
		Thread.sleep(20000);
		Log.info("1099NEC got selected");

		Thread.sleep(20000);

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
	public void whamount_AL() throws InterruptedException {

		Log.startTestCase("whamount_AL");
		// input[@id='StateWithHeld1']

		WebElement whamountbox = getDriver().findElement(By.xpath("//input[@id='StateWithHeld1']"));
		whamountbox.sendKeys("200");
		Log.info("Withheld amount entered:200");
		// WebElement whamountboxtwo =
		// getDriver().findElement(By.xpath("//input[@id='StateTaxWH2']"));

//		whamountboxtwo.sendKeys(Keys.ENTER);

		Thread.sleep(5000);

		WebElement whamountOk = getDriver()
				.findElement(By.xpath("//section[@id='alertify']//button[@id='alertify-ok']"));
		JavascriptExecutor whamountOkexe = (JavascriptExecutor) getDriver();
		whamountOkexe.executeScript("arguments[0].click();", whamountOk);
		Log.info("Clicked OK button on alert ");
		Thread.sleep(10000);

		// TC_MISC_WorkingFlow_001 caseone = new TC_MISC_WorkingFlow_001();
		// caseone.saveForm1099();

		// TC_MISC_GA_WH_Yes_01 caseWHone=new TC_MISC_GA_WH_Yes_01();
		// caseWHone.verify_VES();

	}

	@Test(priority = 5)
	public void add_Recpt_boxamt() throws Throwable {

		TC_MISC_WorkingFlow_001 caseone = new TC_MISC_WorkingFlow_001();
		caseone.form_addRecipient();
		WebElement nonempcompensation = getDriver().findElement(By.xpath("//input[@id='NonEmployeeComp']"));
		nonempcompensation.sendKeys("20");
		Thread.sleep(10000);
		Log.info("Entered box amount:20");
		WebElement OKbutton = getDriver().findElement(By.xpath("//button[@id='alertify-ok']"));
		JavascriptExecutor okbuttonexe = (JavascriptExecutor) getDriver();
		okbuttonexe.executeScript("arguments[0].click();", OKbutton);
		Thread.sleep(10000);
		Log.info("Clicked OK button on alert");
		// caseone.singleBox();
		caseone.saveForm1099();

		Log.info("Saved form");

	}

	@Test(priority = 6)
	public void VES_Page_NEC_AL() throws InterruptedException {

		Log.startTestCase("VES_Page_NEC_AL");

		WebElement selectallglobal = getDriver().findElement(By.xpath("//input[@id='selectallGlobal']"));
		JavascriptExecutor selectallglobalexe = (JavascriptExecutor) getDriver();
		selectallglobalexe.executeScript("arguments[0].click();", selectallglobal);

		WebElement selectedoption = getDriver()
				.findElement(By.xpath("//input[@id='Forms']//preceding-sibling::span//span[@class='k-input']"));
		String displayedoption = selectedoption.getText();
		Log.info("Displayed form when launch VES page:" + displayedoption);

		String compareformtext = "1099-NEC";

		Log.info("Comparing from text is:" + compareformtext);

		assertEquals(displayedoption, compareformtext, "Wrong form name is displayed ");

		Log.info("Displayed and comparing texts are same");

		WebElement selectedoptionyear = getDriver().findElement(
				By.xpath("//label[contains(text(),'Tax Year')]//following-sibling::span//span[@class='k-input']"));
		String selectedoptionformtext = selectedoptionyear.getText();
		Log.info("Displayed year when launch VES page:" + selectedoptionformtext);
		String compareyeartext = "2020";
		Log.info("Comparing year text is:" + compareyeartext);
		assertEquals(selectedoptionformtext, compareyeartext, "Wrong Form year displayed ");

		/// --10 form status--//
		WebElement selectedformstatus = getDriver().findElement(
				By.xpath("//label[contains(text(),'Form  Status')]//following-sibling::span//span[@class='k-input']"));
		String selectedoptionformstatus = selectedformstatus.getText();
		Log.info("Displayed form status when launch VES page:" + selectedoptionformstatus);
		String formstatustext = "NotSubmitted";
		Log.info("Comparing form status text is :" + formstatustext);
		assertEquals(selectedoptionformstatus, formstatustext, "Wrong Form status displayed");

		// --11.Form type--//
		WebElement formtypeelement = getDriver()
				.findElement(By.xpath("//input[@id='FormType']//preceding-sibling::span//span[@class='k-input']"));
		String formtypedisplayed = formtypeelement.getText();
		Log.info("Displayed form type when launch VES page:" + formtypedisplayed);
		String formtypetext = "Regular";
		Log.info("Comparing form type text is :" + formtypetext);
		assertEquals(formtypedisplayed, formtypetext, "Wrong form type displayed");

		WebElement nextbutton = getDriver().findElement(By.xpath("//input[@id='btnSubmit']"));
		Thread.sleep(5000);
		boolean nextbtncheck = nextbutton.isEnabled();
Log.info("Next button is in enabed mode:"+nextbtncheck);
		if (nextbtncheck == true) {
			Actions action = new Actions(getDriver());

			action.moveToElement(nextbutton).click().build().perform();
			//Log.info("Next button is in enabled mode");
			Log.info("Next button clicked");
		} else {
			Log.info("Next button is in disabled mode");
		}
		// ---15. Submit to IRS popup---//

		String submitIRStext = getDriver()
				.findElement(By.xpath("//a[@id='alertify-resetFocusBack']//following-sibling::article")).getText();
		String popuptextdisplayed = "Please select recipient details to submit to IRS";
		// assertEquals(popuptextdisplayed, submitIRStext,"Both are not equal");
		Thread.sleep(20000);
		Actions okaction = new Actions(getDriver());
		WebElement okbutton = getDriver().findElement(By.xpath("//button[@id='alertify-ok']"));
		okaction.moveToElement(okbutton).click().build().perform();

		Log.info("Ok button clicked");

		Thread.sleep(20000);
		WebElement reviewcheckbox = getDriver().findElement(By.id("AgreeChkBoxId"));
		Thread.sleep(5000);
		Actions reviewcheckboxaction = new Actions(getDriver());
		reviewcheckboxaction.moveToElement(reviewcheckbox).click().build().perform();
		Thread.sleep(20000);
		Log.info("Review check selected");
		Actions okactionreview = new Actions(getDriver());
		WebElement okbuttonreview = getDriver().findElement(By.xpath("//button[@id='alertify-ok']"));
		okactionreview.moveToElement(okbuttonreview).click().build().perform();
		Log.info("Ok button on reviewed popup clicked");

		Thread.sleep(20000);

	}

	@Test(priority=7)
public void state_reconcile_page_AL() throws InterruptedException {
		Log.startTestCase("state_reconcile_page_AL");
		
		String formname = "1099-NEC";
		String displayedformname = getDriver().findElement(By.xpath("//label[@for='FormName:']")).getText();
		Log.info("Displayed form name:" + displayedformname);
		Assert.assertEquals(formname, displayedformname);
		Log.info("Correct form name displayed");
		String taxyear = "2020";
		String displayedtaxyear = getDriver().findElement(By.xpath("//label[@for='Tax_Year:']")).getText();
		Log.info("Displayed tex year:" + displayedtaxyear);
		Assert.assertEquals(taxyear, displayedtaxyear);
		Log.info("Correct tax year displayed.");
		String Statename = getDriver().findElement(By.xpath("//table//tbody//tr//td[3]")).getText();
		Log.info("State Name:" + Statename);
		String formcount = getDriver().findElement(By.xpath("//table//tbody//tr//td[4]")).getText();
		Log.info("Form count:" + formcount);
		String status = "Incomplete";
		String displayedstatus = getDriver().findElement(By.xpath("//table//tbody//tr//td[5]")).getText();
		Log.info("Displayed status:" + displayedstatus);
	//	Assert.assertEquals(status, displayedstatus);
		
		WebElement reconsillationbutton = getDriver().findElement(By.xpath("//a[@id='btnReconciliation']"));
		Actions action = new Actions(getDriver());
		action.moveToElement(reconsillationbutton).click().build().perform();
		Thread.sleep(10000);
		Log.info("Clicked on File reconciliation button");
		
		WebElement schedule=getDriver().findElement(By.xpath("//input[@value='Monthly']"));
		JavascriptExecutor scheduleexe = (JavascriptExecutor) getDriver();
		scheduleexe.executeScript("arguments[0].click();", schedule);

		WebElement alertok=getDriver().findElement(By.xpath("//button[@id='alertify-ok']"));
		JavascriptExecutor alertokexe = (JavascriptExecutor) getDriver();
		alertokexe.executeScript("arguments[0].click();", alertok);
	}
	@Test(priority=8)
	public void Form_A3_AL() throws InterruptedException {
		
		Log.startTestCase("Form_A3_AL");
		WebElement signature=getDriver().findElement(By.xpath("//input[@id='ALtxtsignature']"));
		signature.sendKeys("sreetest");
		
		getDriver().findElement(By.xpath("//input[@id='JanuaryCol1']")).clear();
		getDriver().findElement(By.xpath("//input[@id='FebruaryCol1']")).clear();
		getDriver().findElement(By.xpath("//input[@id='MarchCol1']")).clear();
		getDriver().findElement(By.xpath("//input[@id='AprilCol1']")).clear();
		getDriver().findElement(By.xpath("//input[@id='MayCol1']")).clear();
		getDriver().findElement(By.xpath("//input[@id='JuneCol1']")).clear();
		getDriver().findElement(By.xpath("//input[@id='JulyCol1']")).clear();
		getDriver().findElement(By.xpath("//input[@id='AugustCol1']")).clear();
		getDriver().findElement(By.xpath("//input[@id='SeptemberCol1']")).clear();
		getDriver().findElement(By.xpath("//input[@id='OctoberCol1']")).clear();
		getDriver().findElement(By.xpath("//input[@id='NovemberCol1']")).clear();
		getDriver().findElement(By.xpath("//input[@id='DecemberCol1']")).clear();
		Log.info("");
		
		getDriver().findElement(By.xpath("//input[@id='JanuaryCol1']")).sendKeys("10");
		getDriver().findElement(By.xpath("//input[@id='FebruaryCol1']")).sendKeys("90");
		getDriver().findElement(By.xpath("//input[@id='MarchCol1']")).sendKeys("10");
		getDriver().findElement(By.xpath("//input[@id='AprilCol1']")).sendKeys("10");
		getDriver().findElement(By.xpath("//input[@id='MayCol1']")).sendKeys("10");
		getDriver().findElement(By.xpath("//input[@id='JuneCol1']")).sendKeys("10");
		getDriver().findElement(By.xpath("//input[@id='JulyCol1']")).sendKeys("10");
		getDriver().findElement(By.xpath("//input[@id='AugustCol1']")).sendKeys("10");
		getDriver().findElement(By.xpath("//input[@id='SeptemberCol1']")).sendKeys("10");
		getDriver().findElement(By.xpath("//input[@id='OctoberCol1']")).sendKeys("10");
		getDriver().findElement(By.xpath("//input[@id='NovemberCol1']")).sendKeys("10");
		getDriver().findElement(By.xpath("//input[@id='DecemberCol1']")).sendKeys("10");
		
		getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement savebutton = getDriver().findElement(By.xpath("//button[contains(text(),'Save')]"));
		JavascriptExecutor reconcileexe = (JavascriptExecutor) getDriver();
		reconcileexe.executeScript("arguments[0].click();", savebutton);
		Log.info("Save button clicked");
		Thread.sleep(20000);
		WebElement okbutton = getDriver().findElement(By.xpath("//button[@id='alertify-ok']"));
		Thread.sleep(5000);
		//okbutton.click();
		
		JavascriptExecutor okbuttonexe = (JavascriptExecutor) getDriver();
		okbuttonexe.executeScript("arguments[0].click();", okbutton);
		
	
	}
	@Test(priority=9)
	public void after_formA3_reconcile() throws InterruptedException {
		Log.startTestCase("after_formA3_reconcile");
		String displayedstatus = getDriver().findElement(By.xpath("//table//tbody//tr//td[5]")).getText();
		Log.info("Displayed status:" + displayedstatus);
		WebElement nextbutton=getDriver().findElement(By.xpath("//input[@id='btnNext']"));
		JavascriptExecutor nextexe=(JavascriptExecutor)getDriver();
		nextexe.executeScript("arguments[0].click();", nextbutton);
		Thread.sleep(10000);
		
		
	}
@Test(priority=10)
	public void payment_NEC_AL() throws InterruptedException, IOException {
		Log.startTestCase("payment_NEC_AL");
		Log.info("***Filing Fee Information***");
		
		String totalFilingFeetext = getDriver().findElement(By.xpath("//label[contains(text(),'Total Filing Fee')]"))
				.getText();
		String totalFilingfee = getDriver().findElement(By.xpath("//Label[@id='TotalFilingFee']")).getText();
		Log.info(totalFilingFeetext + ":" + "$" + totalFilingfee);
		
		Log.info("***e-Filing Fee Summary***");
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
		
		String stateReconciliationtext = getDriver().findElement(By.xpath("//label[contains(text(),'State Reconciliation Fee')]"))
				.getText();
		String StateReconciliationFee = getDriver().findElement(By.xpath("//Label[@id='StateRFilingFee']")).getText();
		Log.info(stateReconciliationtext + ":" + "$" + StateReconciliationFee);
		
		WebElement buttonpay=getDriver().findElement(By.xpath("//input[@id='btnPay']"));
		JavascriptExecutor payexe=(JavascriptExecutor)getDriver();
		payexe.executeScript("arguments[0].click();", buttonpay);
		
		Thread.sleep(20000);
		
		TC_MISC_WorkingFlow_001 firstflow=new TC_MISC_WorkingFlow_001();
		firstflow.payment_confirmationPage();
		firstflow.filing_history();
		
	}
@Test(priority=11)
public void manageforms_NEC_AL() throws IOException {
	
	//TC_MISC_WorkingFlow_001 
	Log.startTestCase("manageforms_NEC_AL");
	File file = new File("src\\test\\resources\\TestData\\TestData.xlsx");
	FileInputStream fis = new FileInputStream(file);
	XSSFWorkbook workbook = new XSSFWorkbook(fis);
	XSSFSheet sheet = workbook.getSheet("1099MISCdata");
	String addedpayername = sheet.getRow(3).getCell(1).toString();

	WebElement payernameelement = getDriver().findElement(By.xpath(
			"//label[@id='ReconPaymentPage']//following-sibling::ul//label[contains(text(),'Payer')]//following-sibling::span//span[@class='k-input']"));
	String payernamedisplayed = payernameelement.getText();
	Log.info("Displayed payer name launch VES page:" + payernamedisplayed);
//	String formtypetext="Regular";
	Log.info("Comparing payer name is  :" + addedpayername);

	WebElement selectedoptionyear = getDriver().findElement(
			By.xpath("//label[contains(text(),'Tax Year')]//following-sibling::span//span[@class='k-input']"));
	String selectedoptionformtext = selectedoptionyear.getText();
	Log.info("Displayed year when launch VES page:" + selectedoptionformtext);
	String compareyeartext = "2020";
	Log.info("Comparing year text is:" + compareyeartext);
	Log.info("Correct Tax year displayed");
	assertEquals(selectedoptionformtext, compareyeartext, "Wrong Form year displayed ");
	
	WebElement necformtext=getDriver().findElement(By.xpath("//table//tbody//tr//td[contains(text(),'1099NEC')]"));
	boolean formtypecheck=necformtext.isDisplayed();
	Log.info("Form type 1099NEC should be displayed:"+formtypecheck);
	
	
}
@Test(priority=12)
public void dashboard_NEC_AL() throws IOException, InterruptedException {
	
	Log.startTestCase("dashboard_NEC_AL");
	TC_MISC_WorkingFlow_001 caseoneworkingflow=new TC_MISC_WorkingFlow_001();
	caseoneworkingflow.dashboardsearch_submitted();
}
}
