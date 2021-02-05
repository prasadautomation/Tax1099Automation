package com.demo.testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.demo.Base.base;
import com.demo.PeopleLeftMenu.ManagePayerAddPayer;
import com.demo.PeopleLeftMenu.ManagePeople;
import com.demo.dataprovider.DataProviders;
import com.demo.pages.Db;
import com.demo.pages.LoginPage;
import com.demo.pages.OuterLoginButton;
import com.demo.utility.Log;

public class verifyIRSreference extends base{

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
		Thread.sleep(30000);
		LoginPage = OuterLoginButton.clickonLogin();
		Log.info("Enter UserName and Password");
		// Db Db =
		// LoginPage.login(prop.getProperty("UserName"),prop.getProperty("Password"));
		Db Db = LoginPage.login(Useremail, Passwd);
		Thread.sleep(40000);
	}
	@Test(priority=2)
	public void navigate_history() throws InterruptedException, IOException {

		Thread.sleep(10000);
		WebElement historyelement = getDriver().findElement(By.xpath("//p[contains(text(),'History')]"));

		Thread.sleep(10000);
		// WebDriverWait wait=new WebDriverWait(getDriver(),60);
		historyelement.click();
		
		WebElement filinghistorymenuitem=getDriver().findElement(By.xpath("//div[@id='menu_body4']//a[@href='/Protected/FilingHistory']"));
		Thread.sleep(20000);
	//	filinghistorymenuitem.click();
		Actions linkaction=new Actions(getDriver());
		linkaction.moveToElement(filinghistorymenuitem).click().build().perform();
		File file = new File("src\\test\\resources\\TestData\\TestData.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("1099MISCdata");
		String celltype=sheet.getRow(4).getCell(1).getCellType().toString();
		Log.info("cell type is:"+celltype);
		
		//String referencenumber=(int)sheet.getRow(4).getCell(1).getNumericCellValue()+"";	
		String referencenumber=String.valueOf(sheet.getRow(4).getCell(1).getRichStringCellValue());
		Log.info("Reference number:"+referencenumber);
		
		boolean formdisplay=getDriver().findElement(By.xpath("//tr//td[contains(text(),'"+referencenumber+"')]//following-sibling::td//span//a[contains(text(),'Click here')]")).isDisplayed();
		
		Log.info("referencenumber is displayed or not :"+formdisplay);
		
		//By.xpath("//*[contains(text(),'"+searchText+"')]"));
		
		WebElement filinghistorylink=getDriver().findElement(By.xpath("//tr//td[contains(text(),'"+referencenumber+"')]//following-sibling::td//span//a[contains(text(),'Click here')]"));
		
		Actions filinglinkaction=new Actions(getDriver());
		filinglinkaction.moveToElement(filinghistorylink).click().build().perform();
		Log.info("Clicked on filing history link");
	}
}
