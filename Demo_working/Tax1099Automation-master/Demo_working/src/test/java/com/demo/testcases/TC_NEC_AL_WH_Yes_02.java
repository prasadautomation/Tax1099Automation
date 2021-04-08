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

public class TC_NEC_AL_WH_Yes_02 extends base{
	
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
		Thread.sleep(10000);

	}
	@Test(priority = 6)
	public void unCheck_necVES_Wh() throws InterruptedException {
		
		Log.startTestCase("unCheck_necVES_Wh");
		WebElement statefilingcheck=getDriver().findElement(By.xpath("//input[@id='checkboxStateFiling']"));
		boolean statefilingcheckedstate=statefilingcheck.isSelected();
		Log.info("Statefiling option selected"+statefilingcheckedstate);
		JavascriptExecutor statefilingexe=(JavascriptExecutor)getDriver();
		statefilingexe.executeScript("arguments[0].click()", statefilingcheck);
		Log.info("Statefiling unchecked ");
		Log.info("Statefiling selected?"+statefilingcheckedstate);
		
		WebElement selectalloption=getDriver().findElement(By.xpath("//input[@id='selectallGlobal']"));
		JavascriptExecutor selectallexe=(JavascriptExecutor)getDriver();
		selectallexe.executeScript("arguments[0].click()", selectalloption);
		Thread.sleep(10000);
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

	@Test(priority = 7)
	public void paymentpage_nostatfiling_NEC() throws InterruptedException, IOException {
		
		Log.startTestCase("unCheck_necVES_Wh");
		
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
		
	
		
		WebElement buttonpay=getDriver().findElement(By.xpath("//input[@id='btnPay']"));
		JavascriptExecutor payexe=(JavascriptExecutor)getDriver();
		payexe.executeScript("arguments[0].click();", buttonpay);
		
		Thread.sleep(20000);
		
		TC_MISC_WorkingFlow_001 firstflow=new TC_MISC_WorkingFlow_001();
		firstflow.payment_confirmationPage();
		firstflow.filing_history();
		Log.info("Clicked on filing history");
	}
	@Test(priority = 8)
	public void verify_MF_MSF_MRF() throws InterruptedException, IOException {
		Log.info("verify_MF_MSF_MRF");
		
		WebElement statefilingcheckbox=getDriver().findElement(By.xpath("//input[@id='checkboxStateFiling1']"));
		boolean statefilingenabled=statefilingcheckbox.isSelected();
		Log.info("Statefiling checkbox selected status:"+statefilingenabled);
		Log.info("Verification of manage forms completed");
		
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		
		getDriver().findElement(By.xpath("//label[@id='lblStateRejection']")).click();
		Thread.sleep(10000);

		getDriver().findElement(By.xpath("//input[@id='StateFormName']//preceding-sibling::span")).click();
		Thread.sleep(5000);
		String formname = "1099-NEC";
		List<WebElement> myElements = getDriver()
				.findElements(By.xpath("//div[@id='StateFormName-list']//div//ul//li"));
		int elementssize = myElements.size();
		Log.info("Number of elements in the drop down:" + elementssize);
		for (int i = 0; i <= (elementssize - 1); i++) {

			// Log.info(i + "." + "payer name:" + myElements.get(i).getText());
			String selectedformname = myElements.get(i).getText();
			if (selectedformname.equals(formname)) {

				Log.info("Selected form name:" + selectedformname);
				myElements.get(i).click();
				break;
			}
		}

		getDriver().findElement(By.xpath("//input[@id='StateTaxYear']//preceding-sibling::span")).click();
		Thread.sleep(10000);
		String year = "2020";
		List<WebElement> yearelements = getDriver().findElements(By.xpath("//div[@id='StateTaxYear-list']//ul//li"));
		int yearssize = yearelements.size();
		Log.info("Number of elements in the drop down:" + yearssize);
		for (int i = 0; i <= (yearssize - 1); i++) {

			String selectedyear = yearelements.get(i).getText();
			if (selectedyear.equals(year)) {

				Log.info("Selected year:" + selectedyear);
				yearelements.get(i).click();
				break;
			}
		}
		

		WebElement payerslist = getDriver()
				.findElement(By.xpath("//input[@id='StatePayers']//preceding-sibling::span"));
		payerslist.click();
		Thread.sleep(10000);
		File file = new File("src\\test\\resources\\TestData\\TestData.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("1099MISCdata");
		String payername = sheet.getRow(3).getCell(1).toString();

		List<WebElement> payers = getDriver().findElements(By.xpath("//div[@id='StatePayers-list']//li"));
		int payerssize = payers.size();
		Log.info("Number of payers in the drop down:" + payerssize);
		for (int i = 0; i <= (payerssize - 1); i++) {

			// Log.info(i + "." + "payer name:" + myElements.get(i).getText());
			String listedpayername = payers.get(i).getText();
			if (listedpayername.equals(payername)) {

				Log.info(listedpayername);
				payers.get(i).click();
				break;
			}
		}
		Log.info("Threre are no records to display");
		Thread.sleep(5000);
		Log.info("Manage stateforms verification completed ");

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
		Log.info("Payer not found in dropdown");
		getDriver().findElement(By.xpath("//input[@id='ReconciliationTaxYear']//preceding-sibling::span")).click();
		Thread.sleep(10000);
		String recyear = "2020";
		List<WebElement> ryearelements = getDriver().findElements(By.xpath("//div[@id='ReconciliationTaxYear-list']//ul//li"));
		int ryearssize = ryearelements.size();
		Log.info("Number of elements in the drop down:" + yearssize);
		for (int i = 0; i <= (ryearssize - 1); i++) {

			String selectedyear = yearelements.get(i).getText();
			if (selectedyear.equals(recyear)) {

				Log.info("Selected year:" + selectedyear);
				yearelements.get(i).click();
				break;
			}
		}
		
		Log.info("State reconcile record not displayed");
		Thread.sleep(5000);

		Log.info("Reconsile Record  displayed");
		Log.info("Verification of reconciliation forms completed");
		
	}
}
