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

public class TC_MISC_WorkingFlow_004 extends base{
	
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
	}
	
	@Test(priority=6)
	public void selectTIN_USPS() throws Throwable {
		
		Log.startTestCase("selectTIN_USPS");
		WebElement tinmatch=getDriver().findElement(By.xpath("//input[@id='checkboxTinMatch']"));
		boolean tinmatchcheck=tinmatch.isSelected();
		
		if(tinmatchcheck==true) {
			Log.info("Tin match option selected before");
			
		}else {
			
			Log.info("Tin match check box not selected, click on check option to select");
			Actions tinselection=new Actions(getDriver());
			tinselection.moveToElement(tinmatch).click().build().perform();
			boolean tinmatchchecknow=tinmatch.isSelected();
			Log.info("Tin match check box selected now:"+tinmatchchecknow);
			
		}
		Thread.sleep(20000);
		WebElement uspsmail=getDriver().findElement(By.xpath("//input[@id='checkboxUsps']"));
		boolean uspsmailcheck=uspsmail.isSelected();
		
		if(uspsmailcheck==true) {
			Log.info("USPS mail option checked before");
			
		}else {
			
			Log.info("USPS mailcheck box not selected, click on check option to select");
			Actions uspsselection=new Actions(getDriver());
			uspsselection.moveToElement(uspsmail).click().build().perform();
			boolean uspsmailchecknow=uspsmail.isSelected();
			Log.info("USPS mail check box selected now:"+uspsmailchecknow);
			
		}
		
		
	}
	@Test(priority=7)
	public void paymentDetails_page() throws InterruptedException, IOException {
		
		Log.startTestCase("paymentDetails_page");
		TC_MISC_WorkingFlow_001 testcaseone=new TC_MISC_WorkingFlow_001();
		testcaseone.launch_paymentPage();
		Thread.sleep(20000);
		testcaseone.paymentpage_validations();
		Thread.sleep(20000);
		testcaseone.payment_confirmationPage();
		Thread.sleep(10000);
		testcaseone.filing_history();
		Thread.sleep(10000);
		
		testcaseone.manageforms();
		String uspsrequest=getDriver().findElement(By.xpath("//a[@id='USPSid']")).getText(); 
		
		if(uspsrequest.equals("USPS Requested")) {
			
			Log.info("Usps Mail requested text displayed in grid");
		}else {Log.info("Usps mail not requested");}
		
	Thread.sleep(10000);
	}

}
