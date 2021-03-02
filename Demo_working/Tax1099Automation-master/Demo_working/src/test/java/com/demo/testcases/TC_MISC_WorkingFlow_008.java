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

public class TC_MISC_WorkingFlow_008 extends base {

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
	public void form_addpayer(HashMap<String, String> hashMapValue) throws Throwable {

		Log.startTestCase("form_addpayer");
		getDriver().manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		Thread.sleep(50000);

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
			String businessanmetext = businessname.getAttribute("value");
			Log.info("Payer business name:" + businessanmetext);

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

			// String celvalue = cellone.getStringCellValue().toString();
			// Log.info("Random Payer EIN from exceldata :" + celvalue);

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

			WebElement addconfirmationOk=getDriver().findElement(By.id("alertify-ok"));
			Actions action=new Actions(getDriver());
			action.moveToElement(addconfirmationOk).click().build().perform();
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
	public void addrecipient_singlebox_save() throws Throwable {
		Log.startTestCase("addrecipient_singlebox_save");
		TC_MISC_WorkingFlow_001 testcaseone = new TC_MISC_WorkingFlow_001();
		testcaseone.form_addRecipient();
		testcaseone.singleBox();
		testcaseone.saveForm1099();

	}
	@Test(priority = 5)
	public void write_payer() throws IOException {
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

		
	}
	
	@Test(priority=6)
	public void import_payer() throws InterruptedException, IOException {
		Log.startTestCase("import_payer");
		Log.info("Navigate to manage payer.");
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement peoplemenu = getDriver()
				.findElement(By.xpath("//div[@id='firstpane']//p[contains(text(),'People')]"));
		Actions action = new Actions(getDriver());
		action.moveToElement(peoplemenu).click().build().perform();
		Log.info("Clicked on people menu");
		WebElement managerecipient = getDriver()
				.findElement(By.xpath("//div[@id='menu_body2']//a[contains(text(),'Manage Payer')]"));
		Thread.sleep(10000);
		action.moveToElement(managerecipient).click().build().perform();
		Log.info("Clicked on Manage payer menu.");
		Thread.sleep(30000);
		
		/*File file = new File("src\\test\\resources\\TestData\\Payer_Data_Import_Template.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Payer-Import");
		String payerbusinessname=sheet.getRow(1).getCell(3).toString();
		//Select payerlist=new Select(getDriver().findElement(By.xpath("//select[@id='ddlPayer']")));
//		payerlist.selectByVisibleText(payerbusinessname);
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
		}*/
		
		
		//read payer name from test dat--1099misc page
		////////select payer in manage recipine page
		
		//WebElement uploadbutton=getDriver().findElement(By.xpath("//input[@id='upload']//parent::div"));
		WebElement uploadbutton=getDriver().findElement(By.xpath("//input[@id='upload']"));
		Thread.sleep(10000);
		uploadbutton.sendKeys("D:\\Sridevidata\\eclipse-workspace\\Demo_working\\Tax1099Automation-master\\Demo_working\\src\\test\\resources\\TestData\\Payer_Data_Import_Template.xlsx");
		Log.info("Entered recipient file path by send keys");
		WebElement bulkuploadbutton=getDriver().findElement(By.xpath("//input[@id='Next']"));
		bulkuploadbutton.click();
		
		//action.moveToElement(uploadbutton).click().build().perform();
		Thread.sleep(20000);
		WebElement confirmationdialog=getDriver().findElement(By.xpath("//a[@id='alertify-resetFocusBack']"));
		boolean confirmationdisplay=confirmationdialog.isDisplayed();
		Log.info("confirmation dialog displayed:"+confirmationdisplay);
		Assert.assertEquals(confirmationdisplay, true);
		
		WebElement confirmationOk=getDriver().findElement(By.xpath("//button[@id='alertify-ok']"));
		confirmationOk.click();
		
		Log.info("Payer import completed");
	}
	
	@Test(priority = 7)
	public void write_recipient() throws IOException, InterruptedException {

		Log.startTestCase("write_recipient");
		File file = new File("src\\test\\resources\\TestData\\TestData.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("1099MISCdata");
		String rcptTin = String.valueOf(sheet.getRow(8).getCell(1).getRichStringCellValue());
		Log.info("Recipient TIN:" + rcptTin);
		
		

		File importRcptfile = new File("src\\test\\resources\\TestData\\Recipient_Data_Import_Template.xlsx");
		FileInputStream fisRcpt = new FileInputStream(importRcptfile);
		XSSFWorkbook importRcptworkbook = new XSSFWorkbook(fisRcpt);
		XSSFSheet Rcptsheet = importRcptworkbook.getSheet("Import-Recipient");
		Cell recptTINCell = Rcptsheet.getRow(1).getCell(2);
		recptTINCell.setCellValue(rcptTin);

		Random random = new Random();
		int randomnumber = random.nextInt(1000000000);
		String rcptbusinessname = "Imported" + randomnumber;
		Cell recptBN = Rcptsheet.getRow(1).getCell(3);
		recptBN.setCellValue(rcptbusinessname);
		Log.info("Recipient EIN:" + rcptbusinessname);

		Log.info("Entered recpnt TIN from added recpnt data:" + rcptTin);
		
		int twodigitrandom=random.nextInt(100);
		String rcptemail = "Sridevi" + twodigitrandom+"@zenwork.com";
		Cell recptEmail = Rcptsheet.getRow(1).getCell(15);
		recptEmail.setCellValue(rcptemail);
		Log.info("Recipient Email:" + rcptemail);
		
		

		FileOutputStream outputStream2 = new FileOutputStream(importRcptfile);
		importRcptworkbook.write(outputStream2);

		// String Editedpayername = Rcptsheet.getRow(3).getCell(3).toString();
		// Log.info("editor payer name:"+Editedpayername);

	}
	
	

	@Test(priority = 8)
	public void import_recipient() throws InterruptedException, IOException {
		Log.startTestCase("import_recipient");
		Log.info("Navigate to manage recipient.");
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
		
		File file = new File("src\\test\\resources\\TestData\\Payer_Data_Import_Template.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Payer-Import");
		String payerbusinessname=sheet.getRow(1).getCell(3).toString();
		//Select payerlist=new Select(getDriver().findElement(By.xpath("//select[@id='ddlPayer']")));
//		payerlist.selectByVisibleText(payerbusinessname);
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
		
		
		//read payer name from test dat--1099misc page
		////////select payer in manage recipine page
		
		//WebElement uploadbutton=getDriver().findElement(By.xpath("//input[@id='upload']//parent::div"));
		WebElement uploadbutton=getDriver().findElement(By.xpath("//input[@id='upload']"));
		Thread.sleep(10000);
		uploadbutton.sendKeys("D:\\Sridevidata\\eclipse-workspace\\Demo_working\\Tax1099Automation-master\\Demo_working\\src\\test\\resources\\TestData\\Recipient_Data_Import_Template.xlsx");
		Log.info("Entered recipient file path by send keys");
		Thread.sleep(10000);
		WebElement bulkuploadbutton=getDriver().findElement(By.xpath("//input[@id='Next']"));
		bulkuploadbutton.click();
		Log.info("Clicked on bulk upload button");
		
		//action.moveToElement(uploadbutton).click().build().perform();
		Thread.sleep(20000);
		WebElement confirmationdialog=getDriver().findElement(By.xpath("//a[@id='alertify-resetFocusBack']"));
		boolean confirmationdisplay=confirmationdialog.isDisplayed();
		Log.info("confirmation dialog displayed:"+confirmationdisplay);
		Assert.assertEquals(confirmationdisplay, true);
		Thread.sleep(10000);
		WebElement confirmationOk=getDriver().findElement(By.xpath("//button[@id='alertify-ok']"));
		confirmationOk.click();
		Log.info("Ok clicked");
		
		

		/*
		 * Write recipient TIN in down loaded excel The excel should have all the fields
		 * as import recipient data excel file should download from manage recipient
		 * menu edit recipient in excel means enter randOM data except tiN -- SHOULD NOT
		 * CHANGE Tin Upload recipient excel when click on upload and save Verify in VES
		 * page data
		 */

	}

	@Test(priority = 9)

	public void compare_recipientdetails() throws InterruptedException, IOException {
		
		Log.startTestCase("compare_recipientdetails");
		
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement editbutton=getDriver().findElement(By.xpath("//a[@id='btnEditPayee']"));
		Actions action=new Actions(getDriver());
		action.moveToElement(editbutton).click().build().perform();
		Thread.sleep(20000);
		WebElement editrecipientdialog=getDriver().findElement(By.xpath("//span[@id='ui-id-8']//parent::div"));
		boolean editdialogdisplay=editrecipientdialog.isDisplayed();
		if(editdialogdisplay==true) {
			
			Log.info("Edit dialog displayed");
			File file = new File("src\\test\\resources\\TestData\\Recipient_Data_Import_Template.xlsx");
			FileInputStream fis = new FileInputStream(file);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet("Import-Recipient");
			String recipientTINxl=sheet.getRow(1).getCell(2).toString();
			String recipientTINdialog=getDriver().findElement(By.xpath("//input[@id='EditPayeeFedaralID']")).getAttribute("value");
			//Assert.assertEquals(recipientTINxl, recipientTINdialog,"Both are not equal test case failed");
			Log.info("From XL:"+recipientTINxl+"From edit dialog"+recipientTINdialog);
			String recipietbusinessnamexl=sheet.getRow(1).getCell(3).toString();
			String recipientbusinessnamedialog=getDriver().findElement(By.xpath("//input[@id='EditPayeeLastName']")).getAttribute("value");
			//Assert.assertEquals(recipietbusinessnamexl, recipientbusinessnamedialog,"Both are not equal test case failed");
			Log.info("Recipient business name from xl:"+recipietbusinessnamexl+"Recipient business name from edit dialog box:"+recipientbusinessnamedialog);
			Thread.sleep(10000);
			WebElement cancelbutton=getDriver().findElement(By.xpath("//div[@id='EditPayeeDialog']//following-sibling::div//button[contains(text(),'Cancel')]"));
			action.moveToElement(cancelbutton).click().build().perform();
			
			
		}else {Log.info("Edit Recipient dialog not displayed");}
		
		
	}
	
}
