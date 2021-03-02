package com.demo.testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

public class TC_Verify_DuplicatePayers_UpdatePayerTaxIDwithExistingPayerTaxIDTest_005 extends base{
	
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
	
	@Test(priority=2)
	public void duplicatecheckEditpayer() throws Throwable {
		//--------navigate to add payer-----//
		
				Log.startTestCase("duplicateCheckEditpayer");

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
		getDriver().findElement(By.id("btnEditPayer")).click();
		

		File file=new File("src\\test\\resources\\TestData\\TestData.xlsx");
		 FileInputStream inputStream = new FileInputStream(file);
		 XSSFWorkbook workbook=new XSSFWorkbook(inputStream);
		 XSSFSheet sheet=workbook.getSheet("EIN");
		 Cell cell= sheet.getRow(0).getCell(0);
		
		 double celvalue=cell.getNumericCellValue();
			int inrein=(int)celvalue;
				Log.info("Cell value is:"+inrein);
				getDriver().findElement(By.id("PayerFedaralID")).clear();
				getDriver().findElement(By.id("PayerFedaralID")).click();
				getDriver().findElement(By.id("PayerFedaralID")).sendKeys(""+inrein);
				
				Thread.sleep(10000);
				
				getDriver().findElement(By.xpath("//button[contains(text(),'Update')]")).click();
Thread.sleep(5000);
				WebElement EINexistspopup=getDriver().findElement(By.xpath("//section[@id='alertify']//p[contains(text(),'same EIN/SSN already exists')]"));
				boolean popupdisplay=EINexistspopup.isDisplayed();
				
				if(popupdisplay==true) {
					
					Log.info("SSN/EIN number already existed");
					
					getDriver().findElement(By.id("alertify-ok")).click();
					getDriver().findElement(By.xpath("//button[contains(text(),'Cancel')]")).click();
					SeacrhAddedPayer search=new SeacrhAddedPayer();
					search.SearchPayer();
					Thread.sleep(10000);
					
					List payers=getDriver().findElements(By.xpath("//div[@id='Grid']//table//tbody//tr"));
					int count=payers.size();
					Log.info("Number of records:"+count);
					
					if (count==1) {
						
						Log.info("There are no duplicate records entered for this payer ");
					}
					else {
						
						Log.info("Duplicate records entered for this payer");
					}
					
				}else {
					
					Log.info("SSN/EIN number not existed before");
				}
		
	}

} 
