package com.demo.testcases;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

public class SeacrhAddedPayer extends base {
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
		LoginPage = OuterLoginButton.clickonLogin();
		Log.info("Enter UserName and Password");
		// Db Db =
		// LoginPage.login(prop.getProperty("UserName"),prop.getProperty("Password"));
		Db Db = LoginPage.login(Useremail, Passwd);
	}

	@Test(priority = 2, dataProvider = "addpayerrandombusinessein", dataProviderClass = DataProviders.class)
	public void AddPayerTest(HashMap<String, String> hashMapValue) throws Throwable {

		Log.startTestCase("AddPayerTest");

		Thread.sleep(80000);

		WebElement element = getDriver().findElement(By.xpath("//p[contains(text(),'People')]"));
		WebDriverWait wait = new WebDriverWait(getDriver(), 60);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		JavascriptExecutor passwordexecutor = (JavascriptExecutor) getDriver();
		passwordexecutor.executeScript("arguments[0].click();", element);
		Thread.sleep(60000);
		Log.info("People menu clicked");
		/*
		 * Actions action=new Actions(getDriver()); action.moveToElement(element);
		 * action.click(); action.perform();
		 */
		String menutext = getDriver().findElement(By.xpath("//*[@id='firstpane']/div[2]/p")).getText();
		Log.info("menu text:" + menutext);

		getDriver().findElement(By.xpath("//a[contains(text(),'Manage Payer')]")).click();

		Thread.sleep(10000);

		Log.info("Manage payer clicked");

		Thread.sleep(10000);
		WebElement element1 = (new WebDriverWait(getDriver(), 60))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='btnAddEditPayer']")));
		element1.click();
		// ManagePeople.ClickOnAddPayer();

		Thread.sleep(10000);

		WebElement type = getDriver()
				.findElement(By.xpath("//div[@id='divFederalIdTypeForAllForms']//input[@id='rblPayerTypeBusiness']"));
		type.click();
		Thread.sleep(10000);
		Random random = new Random();
		int randomnumber = random.nextInt(1000000000);
		getDriver().findElement(By.id("PayerFedaralID")).clear();
		getDriver().findElement(By.id("PayerFedaralID")).click();
		getDriver().findElement(By.id("PayerFedaralID")).sendKeys("" + randomnumber);

		Log.info("Random EIN:" + randomnumber);

		WebElement businessname = getDriver().findElement(By.id("PayerLastName"));

		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyyhmmss");
		String formattedDate = sdf.format(date);
		businessname.sendKeys("Test" + formattedDate);

		ManagePayerAddPayer ManagePayerAddPayer = new ManagePayerAddPayer();
		getDriver().findElement(By.id("PayerZIP")).sendKeys("35005");
		ManagePayerAddPayer.AddpayerrandombusinessEIN(
				// hashMapValue.get("type"),
				// hashMapValue.get("einTIN"),
				// hashMapValue.get("ssn"),
				// hashMapValue.get("FirstName"),
				// hashMapValue.get("MiddleName"),
				// hashMapValue.get("LastName"),
				// hashMapValue.get("businessname"),
				hashMapValue.get("address"), hashMapValue.get("suffix"), hashMapValue.get("line2"),
				hashMapValue.get("city"), hashMapValue.get("State"), hashMapValue.get("zipcode"),
				hashMapValue.get("Country"),

				// hashMapValue.get("checkheretoforeignaddress"),
				hashMapValue.get("phone"), hashMapValue.get("email"), hashMapValue.get("withholdingortaxstateid"),
				// hashMapValue.get("lastfiling"),
				hashMapValue.get("clientid"));

		getDriver().findElement(By.id("PayerZIP")).clear();
		getDriver().findElement(By.id("PayerZIP")).click();
		getDriver().findElement(By.id("PayerZIP")).sendKeys("35010");

		ManagePayerAddPayer.validateAddEINpayer();
		Thread.sleep(2000);

		File file=new File("src\\test\\resources\\TestData\\TestData.xlsx");
		 FileInputStream inputStream = new FileInputStream(file);
		 XSSFWorkbook workbook=new XSSFWorkbook(inputStream);
		 XSSFSheet sheet=workbook.getSheet("EIN");
			
		 Row row =sheet.createRow(0);
		 Cell cell = row.createCell(0);
		 
		 cell.setCellValue(randomnumber);
		//Log.info(cell.getStringCellValue());
		 
		 
		 FileOutputStream outputStream = new FileOutputStream(file);
       workbook.write(outputStream);
       workbook.close();
       
	double celvalue=cell.getNumericCellValue();
		Log.info("Cell value is:"+celvalue);
		Thread.sleep(20000);
		
		
		getDriver().findElement(By.xpath("//button[@id='alertify-ok']")).click();
		Thread.sleep(20000);
		getDriver().findElement
		(By.xpath("//div[@id='AssignPayerDialog']//following-sibling::div//button[contains(text(),'Close')]")).click();
		Log.info("Closed popup windows");
		WebElement textelement=getDriver().findElement
				(By.xpath("//a[@id='alertify-resetFocusBack']//following-sibling::article//p[contains(text(),'Successfully')]"));
		String successtext=textelement.getAttribute("innerHTML");
	
		Log.info("When payer added successfully popup text as:"+successtext);
		
		String expecttext= "Payer Info Added Successfully";
		
		Assert.assertEquals(successtext, expecttext,"Popup text not matched with expected text");

	/*	Alert alert = ((WebDriver) getDriver()).switchTo().alert();
		Thread.sleep(2000);
		getDriver().findElement(By.xpath("//button[normalize-space()='Cancel']")).click();*/

	}
	@Test(priority = 3)
	public void SearchPayer() throws Throwable {
		
		File file=new File("src\\test\\resources\\TestData\\TestData.xlsx");
		 FileInputStream inputStream = new FileInputStream(file);
		 XSSFWorkbook workbook=new XSSFWorkbook(inputStream);
		 XSSFSheet sheet=workbook.getSheet("EIN");
		Cell cell= sheet.getRow(0).getCell(0);
		 
		 FileOutputStream outputStream = new FileOutputStream(file);
      workbook.write(outputStream);
      workbook.close();
      
	double celvalue=cell.getNumericCellValue();
	int inrein=(int)celvalue;
		Log.info("Cell value is:"+inrein);
		
		Thread.sleep(60000);
		WebElement taxidfilter=getDriver().findElement(By.xpath("//table//th[@data-title='Tax ID']//span[@title='Filter']"));
		
		taxidfilter.click();
		
		Thread.sleep(10000);
		getDriver().findElement(By.xpath("//input[@title='Value']")).sendKeys(""+inrein);
		
		Thread.sleep(10000);
		
		getDriver().findElement(By.xpath("//button[contains(text(),'Filter')]")).click();
		
		
		 
	}

}
