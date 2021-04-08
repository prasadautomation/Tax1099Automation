package com.demo.testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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

public class TC_MISC_GA_WH_Yes_07 extends base{
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
		WebElement saveAddnew=getDriver().findElement(By.xpath("//input[@id='btnSaveAddNewSame']"));
		
		Thread.sleep(5000);
		saveAddnew.click();
		Thread.sleep(20000);
		casethree.add_Recpt_boxamt();
		casethree.withHeld_amount_GA();
		
		casethree.save_form();
	Thread.sleep(20000);
		
		
		
		//casethree.VES_Page();
	//	casethree.state_reconsillation_page();
		//casethree.form_details();
		//casethree.after_reconsillation_page();
		//casethree.payment_page();
		// casethree.manage_forms_SF_Reconcile();
	}

	
	@Test(priority=5)
	public void VESPage_twoforms() throws InterruptedException {
		Log.startTestCase("recipient_WH_Pay");
		getDriver().manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		WebElement selectall=getDriver().findElement(By.xpath("//input[@id='selectallGlobal']"));
		Thread.sleep(5000);
		selectall.click();
		Thread.sleep(10000);
		
		WebElement nextbutton = getDriver().findElement(By.xpath("//input[@id='btnSubmit']"));
		Actions action = new Actions(getDriver());

		action.moveToElement(nextbutton).click().build().perform();
		Thread.sleep(10000);
		Log.info("Next button clicked");
		
		WebElement okbutton = getDriver().findElement(By.xpath("//button[@id='alertify-ok']"));
		action.moveToElement(okbutton).click().build().perform();
		Thread.sleep(10000);
		Log.info("Ok button clicked");
		WebElement reviewcheckbox = getDriver().findElement(By.id("AgreeChkBoxId"));
		Actions reviewcheckboxaction = new Actions(getDriver());
		reviewcheckboxaction.moveToElement(reviewcheckbox).click().build().perform();
		Thread.sleep(10000);
		Log.info("Review checkbox has been selected");
		Thread.sleep(10000);
		Actions okactionreview = new Actions(getDriver());
		WebElement okbuttonreview = getDriver().findElement(By.xpath("//button[@id='alertify-ok']"));
		okactionreview.moveToElement(okbuttonreview).click().build().perform();
		Log.info("Ok button on reviewed popup clicked");
Thread.sleep(20000);
	}
	
	@Test(priority=6)
	public void submit_reconsillationForm_payment() throws IOException, InterruptedException {
		Log.startTestCase("submit_reconsillationForm_payment");
		getDriver().manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		TC_MISC_GA_WH_Yes_03 casethree = new TC_MISC_GA_WH_Yes_03();
		casethree.state_reconsillation_page();
		casethree.form_details();
		casethree.after_reconsillation_page();
		casethree.payment_page();
		
		
	}
	
	@Test(priority=7)
	public void verify_MF_MSF_MRF() throws InterruptedException, IOException {
		Log.startTestCase("verify_MF_MSF_MRF");
		getDriver().manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		TC_MISC_GA_WH_Yes_06 casesix=new TC_MISC_GA_WH_Yes_06();
		casesix.verify_manageStateForms();
		casesix.verify_Manage_reconciliationForm();
		
		
	}
	@Test(priority=8)
	public void block_oneform_MSF() throws InterruptedException, IOException {
		Log.startTestCase("block_oneform_MSF");
		getDriver().manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		TC_MISC_GA_WH_Yes_06 casesix=new TC_MISC_GA_WH_Yes_06();
		casesix.block_managestateforms();
		Thread.sleep(20000);
	//	WebElement okbutton=getDriver().findElement(By.xpath("//button[@id='alertify-ok']"));
		//boolean okbuttondisplay=okbutton.isDisplayed();
		Thread.sleep(5000);
		//if(okbuttondisplay==true) {okbutton.click();
		//Log.info("Clicked OK on 'Please make sure to edit and save the reconciliation form once you block.'Alert");}
	}
	@Test(priority=9)
	public void Edit_Reconciliation() throws IOException, InterruptedException {
		Log.startTestCase("Edit_Reconciliation");
		getDriver().manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		
		File file = new File("src\\test\\resources\\TestData\\TestData.xlsx");
		
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("1099MISCdata");
		String payername = sheet.getRow(3).getCell(1).toString();
		getDriver().findElement(By.xpath("//label[@id='lblReconciliation']")).click();
		Thread.sleep(5000);
		getDriver().findElement(By.xpath("//input[@id='StateReconciliationPayers']//preceding-sibling::span")).click();

		List<WebElement> reconcilepayers = getDriver()
				.findElements(By.xpath("//div[@id='StateReconciliationPayers-list']//div//ul//li"));
		int reconpayerssize = reconcilepayers.size();
		Log.info("Number of reconcile payers in the drop down:" + reconpayerssize);
		for (int i = 0; i <= (reconpayerssize - 1); i++) {

			// Log.info(i + "." + "payer name:" + myElements.get(i).getText());
			String listedreconpayers = reconcilepayers.get(i).getText();
			if (listedreconpayers.equals(payername)) {

				Log.info(listedreconpayers);
				reconcilepayers.get(i).click();
				break;
			}
		}
		Log.info("State reconcile record displayed");
		Thread.sleep(5000);
		WebElement editbutton=getDriver().findElement(By.xpath("//a[@id='btnReconEdit']"));
		Thread.sleep(5000);
		editbutton.click();
		Thread.sleep(5000);
		

	}
	@Test(priority=10)
	public void block_oneform_details_edit() throws InterruptedException {
		Log.startTestCase("block_oneform_details_edit");
		getDriver().manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		WebElement withehldId=getDriver().findElement(By.xpath("//input[@id='GAWithHoldingID']"));
		Thread.sleep(5000);
		Log.info("GA with holding ID:"+withehldId.getAttribute("value"));
		
		WebElement withHeldamt=getDriver().findElement(By.xpath("//input[@id='GeorgiaTaxWithheld']"));
		Thread.sleep(5000);
		Log.info("Withheld amount after edited:"+withHeldamt.getAttribute("value"));
		
		WebElement savebutton=getDriver().findElement(By.xpath("//button[contains(text(),'Save')]"));
		Thread.sleep(5000);
		savebutton.click();
		Thread.sleep(20000);
		
	}
	
}
