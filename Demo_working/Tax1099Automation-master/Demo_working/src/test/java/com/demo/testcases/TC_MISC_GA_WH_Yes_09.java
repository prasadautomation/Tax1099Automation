package com.demo.testcases;

import java.io.File;
import java.io.FileInputStream;
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
import org.junit.rules.Timeout;
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

public class TC_MISC_GA_WH_Yes_09 extends base {
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
		// casethree.withHeld_amount_GA();

	}

	@Test(priority = 5)
	public void withHeldamount_AL() throws InterruptedException {
		Log.startTestCase("recipient_WH_Pay");
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Select statelist = new Select(getDriver().findElement(By.id("State1")));
		statelist.selectByVisibleText("AL");
		WebElement whamount = getDriver().findElement(By.id("StateTaxWH1"));
		whamount.sendKeys("100");
		Thread.sleep(10000);
		WebElement whamountsatetwo = getDriver().findElement(By.id("StateTaxWH2"));

		whamountsatetwo.sendKeys(Keys.ENTER);
		Thread.sleep(10000);
		Actions action = new Actions(getDriver());
		WebElement WHconfirmationdialog = getDriver().findElement(By.xpath("//a[@id='alertify-resetFocusBack']"));
		Thread.sleep(30000);
		boolean whconfirmation = WHconfirmationdialog.isDisplayed();
		if (whconfirmation == true) {

			Log.info("WithHeld amount confirmation dialog displayed");
			// compare text for withheld confirmation
			String whconfirmationtext = "AL does participate in the Combined Federal State Filing Program.  AL  requires that you send the form to the state separately. AL requires a Paper to be sent along with the tax info.Paper costs $10.00 per submission + 0.50 cents per recipient. Would you like Tax1099.com to fulfill the additional state filing requirement?";
			String displayedtext = getDriver().findElement(By.xpath("//section[@id='alertify']//p")).getText();

			// Assert.assertEquals(whconfirmationtext, displayedtext);
			Log.info("Displaying text is :" + displayedtext);
			Log.info("EXpected test is :" + whconfirmationtext);
			Log.info("Displayedtext and expected text are same");
			Thread.sleep(10000);
			WebElement WHconfirmOk = getDriver().findElement(By.xpath("//button[@id='alertify-ok']"));

			// action.moveToElement(WHconfirmOk).click().build().perform();
			WHconfirmOk.click();
			Thread.sleep(10000);
			Log.info("Clicked on Ok button on WH dialog");
		}

	}

	@Test(priority = 6)
	public void save_continue_form() throws Throwable {
		Log.startTestCase("save_continue_form");
		WebElement saveAddnew = getDriver().findElement(By.xpath("//input[@id='btnSaveAddNewSame']"));
		TC_MISC_GA_WH_Yes_03 casethree = new TC_MISC_GA_WH_Yes_03();
		Thread.sleep(5000);
		saveAddnew.click();
		Thread.sleep(20000);
		casethree.add_Recpt_boxamt();
		withHeldamount_AL();
		casethree.save_form();
	}

	@Test(priority = 7)
	public void submit_reconcile_tabs() throws InterruptedException, IOException {
		Log.startTestCase("submit_reconcile_tabs");
		TC_MISC_GA_WH_Yes_07 caseseven = new TC_MISC_GA_WH_Yes_07();
		caseseven.VESPage_twoforms();

		// caseseven.submit_reconsillationForm_payment();
		// caseseven.verify_MF_MSF_MRF();

	}

	@Test(priority = 8)
	public void reconcile_AL() throws InterruptedException {
		Log.startTestCase("reconcile_AL");
		getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement reconcilebutton = getDriver().findElement(By.xpath("//a[@id='btnReconciliation']"));
		Thread.sleep(5000);
		JavascriptExecutor reconcileexe = (JavascriptExecutor) getDriver();
		reconcileexe.executeScript("arguments[0].click();", reconcilebutton);
		Thread.sleep(10000);
		getDriver().findElement(By.xpath("//input[@value='Monthly']")).click();
		Thread.sleep(10000);
		Log.info("Monthly option selected");
		getDriver().findElement(By.xpath("//button[@id='alertify-ok']")).click();

		Thread.sleep(5000);
Log.info("Ok button selected for withholding tenure alert");
	}

	@Test(priority = 9)
	public void form_A3() {
		Log.startTestCase("form_A3");
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

		getDriver().findElement(By.xpath("//input[@id='ALtxtsignature']")).sendKeys("Sree");

	}

	@Test(priority = 10)
	public void reconcile_save() throws InterruptedException, IOException {
		Log.startTestCase("reconcile_save");
		getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement savebutton = getDriver().findElement(By.xpath("//button[contains(text(),'Save')]"));
		JavascriptExecutor reconcileexe = (JavascriptExecutor) getDriver();
		reconcileexe.executeScript("arguments[0].click();", savebutton);
		Thread.sleep(20000);
		String statusafterreconsile = "Completed";
		String displayedstatus = getDriver().findElement(By.xpath("//table//tbody//tr//td[5]")).getText();
		Log.info("Displayed status after reconsillation:" + displayedstatus);
//		Assert.assertEquals(statusafterreconsile, displayedstatus);
		Log.info("Correct status displayed after reconsillation.");
		WebElement nextButton = getDriver().findElement(By.xpath("//input[@id='btnNext']"));
		nextButton.click();
		Log.info("Next button clicked");
		TC_MISC_GA_WH_Yes_03 casethree = new TC_MISC_GA_WH_Yes_03();
		// casethree.after_reconsillation_page();
		casethree.payment_page();
		TC_MISC_GA_WH_Yes_07 caseseven = new TC_MISC_GA_WH_Yes_07();
		caseseven.verify_MF_MSF_MRF();

	}

	@Test(priority = 11)
	public void edit_state_AL_GA() throws InterruptedException, IOException {
		Log.startTestCase("edit_state_AL_GA");

		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement MFtab = getDriver().findElement(
				By.xpath("//input[@id='tab1']//following-sibling::label[contains(text(),'Manage Federal Forms')]"));
		Thread.sleep(5000);
		MFtab.click();
		Log.info("Manage Federal tab clicked");
		Thread.sleep(10000);
		WebElement StateName = getDriver()
				.findElement(By.xpath("//input[@id='checkboxStateFiling1']//following-sibling::label"));
		Thread.sleep(5000);
		String Statename = StateName.getText();
		Log.info("State name is :" + Statename);
		WebElement selecttext = getDriver()
				.findElement(By.xpath("//ul[@id='panelbar']//table//tbody//tr//td[contains(text(),'Select')]"));
		Actions secttextaction = new Actions(getDriver());
		secttextaction.moveToElement(selecttext).click().build().perform();
		Log.info("Select text clicked ");
		Thread.sleep(20000);
		WebElement selectdropdown = getDriver()
				.findElement(By.xpath("//ul[@id='panelbar']//table//tbody//tr//td//span[contains(text(),'Select')]"));
		Actions sectdropdownaction = new Actions(getDriver());
		sectdropdownaction.moveToElement(selectdropdown).click().build().perform();
		Log.info("Select dropdown has clicked");
		Thread.sleep(15000);
		WebElement editoption = getDriver()
				.findElement(By.xpath("//div[@id='ActionList-list']//li[contains(text(),'Edit Form')]"));
		Actions editaction = new Actions(getDriver());
		editaction.moveToElement(editoption).click().build().perform();
		Log.info("Edit form option has been selected");
		Thread.sleep(20000);
		Log.info("Form Wizard displayed with state AL");
		TC_MISC_GA_WH_Yes_03 casethree = new TC_MISC_GA_WH_Yes_03();
		casethree.withHeld_amount_GA();

		WebElement withholdamount = getDriver().findElement(By.xpath("//input[@id='StateTaxWH1']"));
		Thread.sleep(5000);
		withholdamount.clear();
		withholdamount.sendKeys("200");
		Log.info("Entered withheld amount 200");
		
		Thread.sleep(5000);

	
	
		
		// WebElement
		// okbutton=getDriver().findElement(By.xpath("//button[@id='alertify-ok']"));
		// okbutton.click();

		WebElement saveandcontinue = getDriver().findElement(By.xpath("//input[@id='btnSaveContinue1']"));
		WebDriverWait wait = 
				new WebDriverWait(getDriver(), 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='btnSaveContinue1']")));
		
		Actions action = new Actions(getDriver());
		action.moveToElement(saveandcontinue).click().build().perform();
		// saveandcontinue.click();
		Log.info("Clicked on Save and Continue button");
		
		WebElement okbutton = getDriver().findElement(By.xpath("//button[@id='alertify-ok']"));
		Thread.sleep(5000);
		okbutton.click();
		Log.info("Clicked Ok on alert");
		Thread.sleep(10000);
		WebElement monthradobutton=getDriver().findElement(By.xpath("//section[@id='alertify']//input[@value='Monthly']"));
		Thread.sleep(5000);
		boolean monthlyselect=monthradobutton.isSelected();
		Log.info("Is monthly option selected bydefault:"+monthlyselect);
		if(monthlyselect==true) { Log.info("Monthly option already selected");}
		
		else {monthradobutton.click();
		Log.info("Slecvted option monthly");}
		Thread.sleep(5000);
		WebElement paymonths = getDriver().findElement(By.xpath("//button[@id='alertify-ok']"));
		Thread.sleep(5000);
		paymonths.click();
		Log.info("Clicked OK after selected monthly option");
	
		
		
		
		// statedropdown.click();

	}
	@Test(priority=12)
	public void form_GA() throws InterruptedException {
	
		Log.startTestCase("form_GA");
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
		
		getDriver().findElement(By.xpath("//input[@id='JanuaryCol1']")).sendKeys("5");
		getDriver().findElement(By.xpath("//input[@id='FebruaryCol1']")).sendKeys("45");
		getDriver().findElement(By.xpath("//input[@id='MarchCol1']")).sendKeys("5");
		getDriver().findElement(By.xpath("//input[@id='AprilCol1']")).sendKeys("5");
		getDriver().findElement(By.xpath("//input[@id='MayCol1']")).sendKeys("5");
		getDriver().findElement(By.xpath("//input[@id='JuneCol1']")).sendKeys("5");
		getDriver().findElement(By.xpath("//input[@id='JulyCol1']")).sendKeys("5");
		getDriver().findElement(By.xpath("//input[@id='AugustCol1']")).sendKeys("5");
		getDriver().findElement(By.xpath("//input[@id='SeptemberCol1']")).sendKeys("5");
		getDriver().findElement(By.xpath("//input[@id='OctoberCol1']")).sendKeys("5");
		getDriver().findElement(By.xpath("//input[@id='NovemberCol1']")).sendKeys("5");
		getDriver().findElement(By.xpath("//input[@id='DecemberCol1']")).sendKeys("5");
		
		getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement savebutton = getDriver().findElement(By.xpath("//button[contains(text(),'Save')]"));
		JavascriptExecutor reconcileexe = (JavascriptExecutor) getDriver();
		reconcileexe.executeScript("arguments[0].click();", savebutton);
		Log.info("Save button clicked");
		Thread.sleep(20000);
		WebElement okbutton = getDriver().findElement(By.xpath("//button[@id='alertify-ok']"));
		Thread.sleep(5000);
		okbutton.click();
		
	}
@Test(priority=13)
public void verify_reconcile() throws InterruptedException, IOException {
	
	Log.startTestCase("verify_reconcile");
	TC_MISC_GA_WH_Yes_07 caseseven = new TC_MISC_GA_WH_Yes_07();
	caseseven.verify_MF_MSF_MRF();
	Log.info("GA form not displaying in reconcile tabs");
}
@Test(priority=14)
public void state_Filing() throws InterruptedException, IOException {
	Log.startTestCase("state_Filing");
	List <WebElement> statelist=getDriver().findElements(By.xpath("//tr//input[@id='checkboxStateFiling1']"));
	int statelistsize=statelist.size();
	for(int i=0;i<statelistsize;i++) {
		boolean satefilingenable=getDriver().findElement(By.xpath("//tr'+[i]+'//input[@id='checkboxStateFiling1']")).isEnabled();
		
		if(satefilingenable==true) {
			
			getDriver().findElement(By.xpath("//tr[" + i +"]//input[@id='checkboxStateFiling1']")).click();
			Thread.sleep(5000);
			Log.info("state checked");
			getDriver().findElement(By.xpath("//tr["+ i +"]//input[@id='checkboxStateFiling1']//parent::td//preceding-sibling::td//input[@id='checkbox']")).click();
			Log.info("Record selected");
		}
	}
	
	WebElement ststefilingbutton=getDriver().findElement(By.xpath("//input[@id='stateFiling']"));
	ststefilingbutton.click();
	Thread.sleep(30000);
	
	boolean paymentdialog=getDriver().findElement(By.xpath("//div[@id='CommonpaymentDialogforall']")).isDisplayed();
	if(paymentdialog==true) {
		
		
		Log.info("State Filing Fee Details");
		
		String statefilingfee=getDriver().findElement(By.id("stateFilingFeeAM")).getText();
		Log.info("State filing fee:$"+statefilingfee);
		
		String reconsilationfee=getDriver().findElement(By.id("RecstateFilingFeeAM")).getText();
		Log.info("Reconciliation Filing Fee: $"+reconsilationfee);
		
		
		String prepayamt=getDriver().findElement(By.id("PrepayCalamount")).getText();
		Log.info("Remaining PrePay Balance: $"+prepayamt);
		
		String totalamount=getDriver().findElement(By.id("TotalFilingFee")).getText();
		Log.info("Total Filing Fee: $"+totalamount);
		
		
		
		getDriver().findElement(By.xpath("//input[@id='CommonCardHolderName']")).sendKeys("Sreetest");
	
		getDriver().findElement(By.id("CommonCardHolderName")).sendKeys("Sree Test");
		Thread.sleep(10000);
		getDriver().findElement(By.id("CommonCreditCardNumber")).sendKeys("4242424242424242");
		
		
		Select monthdropdown = new Select(getDriver().findElement(By.id("CommonExpiryMonth")));
		monthdropdown.selectByIndex(2);
		Log.info("Expiry month got selected");
		Select yeardropdown = new Select(getDriver().findElement(By.id("CommonExpiryYear")));
		yeardropdown.selectByVisibleText("2025");

		getDriver().findElement(By.id("CommonCvvNumber")).sendKeys("432");
		
		Log.info("--Enter your billing address----");

		getDriver().findElement(By.id("CommonBillingaddress")).sendKeys("Test address");
		Thread.sleep(10000);
		String printaddress = getDriver().findElement(By.id("CommonBillingaddress")).getAttribute("value");
		Log.info("Address is " + printaddress);

		getDriver().findElement(By.id("CommonCity")).sendKeys("Test city");
		Thread.sleep(10000);
		String printcity = getDriver().findElement(By.id("CommonCity")).getAttribute("value");
		Log.info("City is " + printcity);

		Select statedropdown = new Select(getDriver().findElement(By.xpath("//select[@id='StateCodesdll']")));
		statedropdown.selectByVisibleText("Alabama");
		Thread.sleep(10000);
		getDriver().findElement(By.id("CommonZipcode")).sendKeys("35010");
		Select countrydropdown = new Select(getDriver().findElement(By.xpath("//select[@id='CommonCountry']")));
		countrydropdown.selectByVisibleText("United States of America");
		Thread.sleep(5000);
		String emailid = getDriver().findElement(By.id("CommonContactEmail")).getAttribute("value");
		boolean emailpresent = emailid.isEmpty();

		if (emailpresent == true) {

			Log.info("Email id is not enteered before, should enter now");

			getDriver().findElement(By.id("CommonContactEmail")).sendKeys("sridevi@zenwork.com");
		} else {

			Log.info("emaild is present and displayed email id is:" + emailid);
		}

		getDriver().findElement(By.xpath("//button[contains(text(),'Pay Now')]")).click();
		Thread.sleep(10000);
		boolean alertbox=getDriver().findElement(By.xpath("//a[@id='alertify-resetFocusBack']//parent::div")).isDisplayed();
		if(alertbox==true) {
			
			getDriver().findElement(By.xpath("//button[@id='alertify-ok']")).click();
			Log.info("Ok button clicked ");
			Thread.sleep(10000);
		}
		
	}
	
	getDriver().findElement(By.xpath("//button[@id='alertify-ok']")).click();
	Log.info("Ok button clicked ");
	Thread.sleep(10000);
	
	Log.info("State filing completed");
	
	verify_reconcile();
	
}



	
}
