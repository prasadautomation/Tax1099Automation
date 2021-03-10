package com.demo.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestListener;
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
public class testsample extends base  {
	
	
//	@Test(priority=1)
	public void randomnumber() {
		
		
		Random random = new Random();
		long randomnumber = random.nextInt(1000000000);
		
		Log.info("Random number:"+randomnumber);
		
		
		
	}

	/*public void random() {
	Random randomGenerator = new Random();
	int randomInt = randomGenerator.nextInt(100000000);
	System.out.print(randomInt);

}*/
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
		Thread.sleep(10000);
		LoginPage = OuterLoginButton.clickonLogin();
		Log.info("Enter UserName and Password");
		
		
		
		// Db Db =
		// LoginPage.login(prop.getProperty("UserName"),prop.getProperty("Password"));
		Db Db = LoginPage.login(Useremail, Passwd);
		Thread.sleep(10000);
		
		
		WebElement formselement = getDriver().findElement(By.xpath("//p[contains(text(),'Forms')]"));

		Thread.sleep(20000);
		
		formselement.click();
		
		Thread.sleep(5000);
		
		WebElement vesmenu=getDriver().findElement(By.xpath("//div[@id='menu_body1']//a[contains(text(),'View/Edit/Submit Forms')]"));
		vesmenu.click();
		
		Thread.sleep(10000);
getDriver().findElement(By.xpath("//input[@id='TaxYear']//parent::span")).click();
		
		List<WebElement> taxyearelements = getDriver().findElements(By.xpath("//div[@id='TaxYear-list']//ul//li"));
		int yearssize=taxyearelements.size();
		Log.info("Number of payers in the drop down:"+yearssize);
		for(int i=0;i<=(yearssize-1);i++)
		{
			
		//	Log.info(i+"."+"payer name:"+myElements.get(i).getText());
			String taxyear=taxyearelements.get(i).getText();
			if (taxyear.equals("2020")) {
				
				Log.info("Tax year"+taxyear);
				taxyearelements.get(i).click();
				break;
			}
		}
		
		
		
		
		File file = new File("src\\test\\resources\\TestData\\TestData.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("1099MISCdata");
		String payerbusinessname=sheet.getRow(3).getCell(1).toString();
		//Select payerlist=new Select(getDriver().findElement(By.xpath("//select[@id='ddlPayer']")));
//		payerlist.selectByVisibleText(payerbusinessname);
		getDriver().findElement(By.xpath("//input[@id='Payers']//preceding-sibling::span")).click();

		
		List<WebElement> payernameslist=getDriver().findElements(By.xpath("//div[@id='Payers-list']//ul//li"));
		int payerssize=payernameslist.size();
		Log.info("Number of payers in the drop down:"+payerssize);
		for(int i=0;i<=(payerssize-1);i++)
		{
			
		//	Log.info(i+"."+"payer name:"+myElements.get(i).getText());
			String payername=payernameslist.get(i).getText();
			if (payername.equals(payerbusinessname)) {
				
				Log.info("Payername"+payername);
				payernameslist.get(i).click();
				break;
			}
		}
		Thread.sleep(10000);
		WebElement recordcheckbox = getDriver()
				.findElement(By.xpath("//td//input[@type='checkbox' and @class='chkbxq']"));
		boolean recordselectcheck = recordcheckbox.isSelected();
		if (recordselectcheck == true) {
			Log.info("State filing record selected");

		} else {

			Log.info("State filing record not selected");
			Thread.sleep(10000);
			Actions action = new Actions(getDriver());
			action.moveToElement(recordcheckbox).click().build().perform();

			Thread.sleep(10000);
		}

		boolean recordselectchecktwo = recordcheckbox.isSelected();
		if (recordselectchecktwo == true) {
			Log.info("State filing record now selected");

		}

		getDriver().findElement(By.xpath("//input[@id='btnSubmit']")).click();
		Log.info("Please select recipient details to submit to IRS dialog will be displayed");
		Thread.sleep(10000);
		getDriver().findElement(By.id("alertify-ok")).click();
		Thread.sleep(10000);
		WebElement alertdialog = getDriver().findElement(By.xpath("//section[@id='alertify']"));
		boolean alertdialogdisplay = alertdialog.isDisplayed();
		Log.info("is alertDialog displayed:" + alertdialogdisplay);
		if (alertdialogdisplay == true) {

			getDriver().findElement(By.xpath("//input[@id='AgreeChkBoxId']")).click();
			Log.info("Check box selected for reviewed dialog");
			Thread.sleep(5000);

			getDriver().findElement(By.id("alertify-ok")).click();
			Log.info("Clicked ok on alert box");
		} else {

			Log.info("Alert dialog not displayed");
		}

		Thread.sleep(10000);

//		String ActualTitle = getDriver().getTitle();
	//	String ExpectedTitle = "Amazon";
	//	Assert.assertEquals(ActualTitle, ExpectedTitle);
	}
	
	@Test(priority = 2)
	public void state_reconsillation_page() throws IOException, InterruptedException {

		Log.startTestCase("state_reconsillation_page");
		getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		File file = new File("src\\test\\resources\\TestData\\TestData.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("1099MISCdata");
		String payername = sheet.getRow(3).getCell(1).toString();
		String displayedpayername = getDriver().findElement(By.xpath("//label[@for='PayerName:']")).getText();
		Log.info("Displayed payername:" + displayedpayername);
		Assert.assertEquals(payername, displayedpayername);
		Log.info("Correct payer name displayed");
		String formname = "1099-MISC";
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
		Assert.assertEquals(status, displayedstatus);
		WebElement reconsillationbutton = getDriver().findElement(By.xpath("//a[@id='btnReconciliation']"));
		Actions action = new Actions(getDriver());
		action.moveToElement(reconsillationbutton).click().build().perform();
		Thread.sleep(30000);

	}

	@Test(priority = 3)

	public void form_details() throws InterruptedException {

		Log.startTestCase("form_details");
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement GAwithHoldingId=getDriver().findElement(By.xpath("//input[@id='GAWithHoldingID']"));
		GAwithHoldingId.sendKeys(Keys.ENTER);
		GAwithHoldingId.clear();
		GAwithHoldingId.sendKeys("7654321");
				GAwithHoldingId.sendKeys(Keys.ENTER);
		GAwithHoldingId.sendKeys("VV");
		Log.info("Entered GA withholding ID");
		Thread.sleep(10000);
		getDriver().findElement(By.xpath("//input[@id='GASignature']")).sendKeys("Sreetest");
		Log.info("Entered signature");
		Thread.sleep(10000);
		getDriver().findElement(By.xpath("//input[@id='GATitle']")).sendKeys("Test");
		Log.info("Entered Title");
		Thread.sleep(10000);
		WebElement formsavebutton = getDriver().findElement(
				By.xpath("//div[@id='DivFormGAG1003Dialog']//following-sibling::div//button[contains(text(),'Save')]"));
		Actions action = new Actions(getDriver());
		action.moveToElement(formsavebutton).click().build().perform();

	}

	
	//@Test(priority=2)
	public void exceltestretrive() throws IOException {
		
		DataFormatter df = new DataFormatter();
		//String value = df.formatCellValue(cell);
	//	String payerTin = df.formatCellValue(sheet.getRow(15).getCell(1));
		File file = new File("src\\test\\resources\\TestData\\TestData.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("StateID-Validations"); 
		int rowlastnumber=sheet.getLastRowNum();
		System.out.println("Number of rows :"+rowlastnumber);
		for(int i=1;i<=rowlastnumber;i++) {
			
			String statedidvalues=df.formatCellValue(sheet.getRow(i).getCell(1));
			String stateidvalidations=df.formatCellValue(sheet.getRow(i).getCell(2));
			Log.info("State id format: "+statedidvalues+" --> "+stateidvalidations);
		}
		
	}




public void import_recipient() throws InterruptedException, IOException {
	Log.startTestCase("import_recipient");
	Log.info("navigate to manage recipient.");
	getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	WebElement peoplemenu = getDriver()
			.findElement(By.xpath("//div[@id='firstpane']//p[contains(text(),'People')]"));
	Actions action = new Actions(getDriver());
	action.moveToElement(peoplemenu).click().build().perform();
	Log.info("Clicked on people menu");
	WebElement managerecipient = getDriver()
			.findElement(By.xpath("//div[@id='menu_body2']//a[contains(text(),'Manage Recipient')]"));
	Thread.sleep(10000);
	action.moveToElement(managerecipient).click().build().perform();
	Log.info("Clicked on Manage recipient menu.");
	
	Thread.sleep(30000);
	
	
	File file = new File("src\\test\\resources\\TestData\\TestData.xlsx");
	FileInputStream fis = new FileInputStream(file);
	XSSFWorkbook workbook = new XSSFWorkbook(fis);
	XSSFSheet sheet = workbook.getSheet("1099MISCdata");
	String payerbusinessname=sheet.getRow(3).getCell(1).toString();
	//Select payerlist=new Select(getDriver().findElement(By.xpath("//select[@id='ddlPayer']")));
//	payerlist.selectByVisibleText(payerbusinessname);
	WebElement payerlist=getDriver().findElement(By.xpath("//select[@id='ddlPayer']//following-sibling::div[@id='ddlPayer_chosen']"));
	payerlist.click();
	
	List<WebElement> payernameslist=getDriver().findElements(By.xpath("//select[@id='ddlPayer']//following-sibling::div[@id='ddlPayer_chosen']//div//li"));
	int elementssize=payernameslist.size();
	Log.info("Number of payers in the drop down:"+elementssize);
	for(int i=0;i<=(elementssize-1);i++)
	{
		
	//	Log.info(i+"."+"payer name:"+myElements.get(i).getText());
		String payername=payernameslist.get(i).getText();
		if (payername.equals(payerbusinessname)) {
			
			Log.info("Payername"+payername);
			payernameslist.get(i).click();
			break;
		}
	}
	
	
	//WebElement uploadbutton=getDriver().findElement(By.xpath("//input[@id='upload']//parent::div"));
	WebElement uploadbutton=getDriver().findElement(By.xpath("//input[@id='upload']"));
	Thread.sleep(10000);
	uploadbutton.sendKeys("D:\\Sridevidata\\eclipse-workspace\\Demo_working\\Tax1099Automation-master\\Demo_working\\src\\test\\resources\\TestData\\Recipient_Data_Import_Template.xlsx");
	WebElement bulkuploadbutton=getDriver().findElement(By.xpath("//input[@id='Next']"));
	bulkuploadbutton.click();
	
	//action.moveToElement(uploadbutton).click().build().perform();
	Thread.sleep(20000);
	WebElement confirmationdialog=getDriver().findElement(By.xpath("//a[@id='alertify-resetFocusBack']"));
	boolean confirmationdisplay=confirmationdialog.isDisplayed();
	Log.info("confirmation dialog displayed:"+confirmationdisplay);
	Assert.assertEquals(confirmationdisplay, true);
	//Log.info("confirmation dialog displayed:"+confirmationdisplay);
/*	Runtime.getRuntime().e.xec("D:\\Sridevidata\\RecipientImport_x64.exe");	
	

	
	
	Thread.sleep(30000);
	WebElement BulkImportbutton=getDriver().findElement(By.xpath("//input[@id='Next']"));
	action.moveToElement(BulkImportbutton).click().build().perform();*/
	

	/*
	 * Write recipient TIN in down loaded excel The excel should have all the fields
	 * as import recipient data excel file should download from manage recipient
	 * menu edit recipient in excel means enter randOM data except tiN -- SHOULD NOT
	 * CHANGE Tin Upload recipient excel when click on upload and save Verify in VES
	 * page data
	 */

}
//@Test(priority=2)
	public void exceltest() throws IOException {
		Log.startTestCase("write_payer");
		File file = new File("src\\test\\resources\\TestData\\TestData.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("1099MISCdata");
		
		DataFormatter df = new DataFormatter();
		//String value = df.formatCellValue(cell);
		String payerTin = df.formatCellValue(sheet.getRow(15).getCell(1));
		
		File importpayerFile = new File("src\\test\\resources\\TestData\\Payer_Data_Import_Template.xlsx");
		FileInputStream fisPayer = new FileInputStream(importpayerFile);
		XSSFWorkbook importPayerworkbook = new XSSFWorkbook(fisPayer);
		XSSFSheet Payersheet = importPayerworkbook.getSheet("Payer-Import");
		Cell PayerTINCell = Payersheet.getRow(1).getCell(2);
		PayerTINCell.setCellValue(payerTin);

		Random random = new Random();
		int randomnumber = random.nextInt(100000000);
		String payerbusinessname = "Imported" + randomnumber;
		Cell payerBN = Payersheet.getRow(1).getCell(3);
		payerBN.setCellValue(payerbusinessname);
		Log.info("Payer EIN:" + payerbusinessname);

		Log.info("Entered payer TIN from added recpnt data:" + payerTin);
		
		int twodigitrandom=random.nextInt(100);
		String payeremail = "Sridevi" + twodigitrandom+"@zenwork.com";
		Cell payerEmail = Payersheet.getRow(1).getCell(15);
		payerEmail.setCellValue(payeremail);
		Log.info("Payer Email:" + payeremail);
		
		

		FileOutputStream outputStream2 = new FileOutputStream(importpayerFile);
		importPayerworkbook.write(outputStream2);

	
	
	//String Editedpayername = Rcptsheet.getRow(3).getCell(3).toString();
	//Log.info("editor payer name:"+Editedpayername);
	}

public void dashboardsearch_notsubmit() throws IOException, InterruptedException {
	
	Log.startTestCase("manageforms");
	getDriver().manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	
	WebElement formselement = getDriver().findElement(By.xpath("//p[contains(text(),'Forms')]"));
	Thread.sleep(10000);
	formselement.click();
	Log.info("Forms menu clicked");
	
	WebElement manageforms=getDriver().findElement(By.xpath("//div[@id='menu_body1']//a[contains(text(),'Manage Forms')]"));
	Thread.sleep(10000);
	manageforms.click();
	Log.info("Clicked on mange forms menu");


	
	File file = new File("src\\test\\resources\\TestData\\TestData.xlsx");
	FileInputStream fis = new FileInputStream(file);
	XSSFWorkbook workbook = new XSSFWorkbook(fis);
	XSSFSheet sheet = workbook.getSheet("1099MISCdata");
	String addedpayername=sheet.getRow(3).getCell(1).toString();
	Log.info("Payer name:"+addedpayername);
	
	
getDriver().findElement(By.xpath("//div[@id='panelbar-1']//input[@id='Payers']//preceding-sibling::span//span")).click();
	Thread.sleep(20000);
	List<WebElement> myElements = getDriver().findElements(By.xpath("//div[@id='Payers-list']//ul[@id='Payers_listbox']//li"));
	int elementssize=myElements.size();
	Log.info("Number of elements in the drop down:"+elementssize);
	for(int i=0;i<=(elementssize-1);i++)
	{
		
	//	Log.info(i+"."+"payer name:"+myElements.get(i).getText());
		String payername=myElements.get(i).getText();
		if (payername.equals(addedpayername)) {
			
			Log.info(payername);
			myElements.get(i).click();
			break;
		}
	}
	
	WebElement taxyear=getDriver().findElement(By.xpath("//li[@id='Panel1']//div[@id='panelbar-1']//label[contains(text(),'Tax Year')]//following-sibling::span//span[contains(text(),'Select Tax Year...')]"));
	Thread.sleep(10000);
	taxyear.click();
	
	getDriver().findElement(By.xpath("//ul[@id='TaxYear_listbox']//li[contains(text(),'2020')]")).click();
	WebElement selectdropdown=getDriver().findElement(By.xpath("//div[@id='panelbar-1']//table//tbody//tr//td[contains(text(),'Select')]"));
	Thread.sleep(1000);
	selectdropdown.click();
	Log.info("select text has been clicked");
	Thread.sleep(20000);
	WebElement selectdropdownedit=getDriver().findElement(By.xpath("//ul[@id='panelbar']//table//tbody//tr//td//span[contains(text(),'Select')]"));
	Actions sectdropdownaction=new Actions(getDriver());
	sectdropdownaction.moveToElement(selectdropdownedit).click().build().perform();
	Log.info("Select dropdown has clicked");
	Thread.sleep(15000);
	
	WebElement editoption=getDriver().findElement(By.xpath("//div[@id='ActionList-list']//li[contains(text(),'Edit Form')]"));
	Actions editaction=new Actions(getDriver());
	editaction.moveToElement(editoption).click().build().perform();
	Log.info("Edit form option has been selected");
	
	
	
	//div[@id='panelbar-1']//label[contains(text(),'Tax Year')]//following-sibling::span//span[@class='k-input']
/*
WebElement dashboard=getDriver().findElement(By.xpath("//div[@id='firstpane']//a[contains(text(),'Dashboard')]"));
JavascriptExecutor dashboardexe = (JavascriptExecutor) getDriver();
dashboardexe.executeScript("arguments[0].click();", dashboard);
Log.info("Dashboard menu clicked");
*/
//addedpayername
//	getDriver().navigate().refresh();
Thread.sleep(20000);


}


	//	@Test(priority=3)
		public void paymentpage_validations() throws InterruptedException {
			
		
			Log.startTestCase("paymentpage_validations");
			
			Log.info("--- Fee Information--");
			String totalFilingFeetext=getDriver().findElement(By.xpath("//label[contains(text(),'Total Filing Fee')]")).getText();
			String totalFilingfee=getDriver().findElement(By.xpath("//Label[@id='TotalFilingFee']")).getText();
			Log.info(totalFilingFeetext+":"+"$"+totalFilingfee);
			
			String prePaybalancetext=getDriver().findElement(By.xpath("//label[contains(text(),'Prepay Balance')]")).getText();
			String prePayBalancefee=getDriver().findElement(By.xpath("//Label[@id='PrepayBalance']")).getText();
			Log.info(prePaybalancetext+":"+"$"+prePayBalancefee);
			
			String totalAmountPaidtext=getDriver().findElement(By.xpath("//label[contains(text(),'Total Amount to be Paid')]")).getText();
			String totalamount=getDriver().findElement(By.xpath("//Label[@id='AmountToBePaid']")).getText();
			Log.info(totalAmountPaidtext+":"+"$"+totalamount);
			Thread.sleep(10000);
			
			Log.info("--e-Filing Fee Summary--");
			String Formcounttext=getDriver().findElement(By.xpath("//label[contains(text(),'Form Count')]")).getText();
			String numberofforms=getDriver().findElement(By.xpath("//label[@id='SubmittedFormsCount']")).getText();
		Log.info(Formcounttext+":"+numberofforms);	
		String efilingfeeText=getDriver().findElement(By.xpath("//Label[contains(text(),'e-Filing')]")).getText();
		String priceofefiling=getDriver().findElement(By.xpath("//Label[@id='FilingFee']")).getText();
		Log.info(efilingfeeText+":"+"$"+priceofefiling);
		
		String tinMatchtext=getDriver().findElement(By.xpath("//label[contains(text(),'TIN Match Fee:')]")).getText();
		String tinMatchfee=getDriver().findElement(By.xpath("//Label[@id='TinMatchFee']")).getText();
		Log.info(tinMatchtext+":"+"$"+tinMatchfee);
		
		String uspsMailingfeetext=getDriver().findElement(By.xpath("//label[contains(text(),'USPS Mailing Fee')]")).getText();
		String uspsMailingfee=getDriver().findElement(By.xpath("//Label[@id='MailingFee']")).getText();
		Log.info(uspsMailingfeetext+":"+"$"+uspsMailingfee);
		
		String stateFilingtext=getDriver().findElement(By.xpath("//label[contains(text(),'State Filing')]")).getText();
		String stateFilingfee=getDriver().findElement(By.xpath("//Label[@id='StateFilingFee']")).getText();
		Log.info(stateFilingtext+":"+"$"+stateFilingfee);
		
		Log.info("Name on card");
		getDriver().findElement(By.id("CardHolderName")).sendKeys("Sree Test");
		getDriver().findElement(By.id("CreditCardNumber")).sendKeys("4242424242424242");
		
		Select monthdropdown=new Select(getDriver().findElement(By.id("ExpiryMonth")));
		monthdropdown.selectByIndex(2);
		Log.info("Expiry month got selected");
		Select yeardropdown=new Select(getDriver().findElement(By.id("ExpiryYear")));
		yeardropdown.selectByVisibleText("2025");
		
		getDriver().findElement(By.id("CvvNumber")).sendKeys("432");
		
		Log.info("--Enter your billing address----");
		
		getDriver().findElement(By.id("Address")).sendKeys("Test address");
		Thread.sleep(10000);
		String printaddress=getDriver().findElement(By.id("Address")).getAttribute("value");
		Log.info("Address is "+printaddress);
		
		getDriver().findElement(By.id("City")).sendKeys("Test city");
		Thread.sleep(10000);
		String printcity=getDriver().findElement(By.id("City")).getAttribute("value");
		Log.info("City is "+printcity);
		
		Select statedropdown=new Select(getDriver().findElement(By.xpath("//select[@id='ddlAddressStateUS']")));
		statedropdown.selectByVisibleText("Alabama");
		getDriver().findElement(By.id("ZIP")).sendKeys("35010");
		Select countrydropdown=new Select(getDriver().findElement(By.xpath("//select[@id='ddlCountry']")));
		countrydropdown.selectByVisibleText("UNITED STATES");
		String emailid=getDriver().findElement(By.id("Emailid")).getAttribute("value");
		boolean emailpresent=emailid.isEmpty();
		
		if(emailpresent==true) {
			
			Log.info("Email id is not enteered before, should enter now");
			
			getDriver().findElement(By.id("Emailid")).sendKeys("sridevi@zenwork.com");
		}else {
			
			Log.info("emaild is present and displayed email id is:"+emailid);
		}
		WebElement payButton=getDriver().findElement(By.id("btnPay"));
		
		Actions paybuttonaction=new Actions(getDriver());
		paybuttonaction.moveToElement(payButton).click().build().perform();
		
		
		
		}

}
