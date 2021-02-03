package com.demo.testcases;

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
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class testsample extends base {

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
		Thread.sleep(80000);
		LoginPage = OuterLoginButton.clickonLogin();
		Log.info("Enter UserName and Password");
		// Db Db =
		// LoginPage.login(prop.getProperty("UserName"),prop.getProperty("Password"));
		Db Db = LoginPage.login(Useremail, Passwd);
		Thread.sleep(40000);
	}
@Test(priority=2)
	public void Navigate_payer() throws InterruptedException, IOException {
		
		Log.startTestCase("Navigate_payer");

		Thread.sleep(40000);
		WebElement formselement = getDriver().findElement(By.xpath("//p[contains(text(),'Forms')]"));

		Thread.sleep(20000);
		// WebDriverWait wait=new WebDriverWait(getDriver(),60);
		formselement.click();

		// wait.until(ExpectedConditions.elementToBeClickable(formselement));
		// JavascriptExecutor passwordexecutor = (JavascriptExecutor) getDriver();
		// passwordexecutor.executeScript("arguments[0].click();", formselement);
Thread.sleep(20000);
		Log.info("Forms menu clicked");
		Thread.sleep(20000);
		WebElement sumitforms=getDriver().findElement(By.xpath("//div[@id='menu_body1']//a[contains(text(),'Submit Forms')]"));
		//sumitforms.click();
		JavascriptExecutor submitformsexe = (JavascriptExecutor) getDriver();
		submitformsexe.executeScript("arguments[0].click();", sumitforms);
		
		//Actions submitmenuaction=new Actions(getDriver());
		//submitmenuaction.moveToElement(sumitforms).click().build().perform();
		Thread.sleep(20000);
		Log.info("VES form clicked");
		File file = new File("src\\test\\resources\\TestData\\TestData.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("1099MISCdata");
		
		
		String addedpayername=sheet.getRow(3).getCell(1).toString();
		Log.info("Payername is:"+addedpayername);
		
		Thread.sleep(20000);
		
		getDriver().findElement(By.xpath("//span[contains(text(),'Select Payer.')]")).click();
		
		List<WebElement> myElements = getDriver().findElements(By.xpath("//div[@id='Payers-list']//ul[@id='Payers_listbox']//li"));
		int elementssize=myElements.size();
		Log.info("Number of elements in the drop down:"+elementssize);
		for(int i=0;i<=(elementssize-1);i++)
		{
			
			Log.info(i+"."+"payer name:"+myElements.get(i).getText());
			String payername=myElements.get(i).getText();
			if (payername.equals(addedpayername)) {
				
				Log.info(payername);
				myElements.get(i).click();
				break;
			}
		}
		
		/*
	       for(WebElement e : myElements) {
	         if(e.getText().equalsIgnoreCase(addedpayername)) {
	             Log.info("Selected payer name:"+e);
	        	 e.click();
	             
	         }
	}*/
		
		Thread.sleep(10000);
		
		getDriver().findElement(By.xpath("	//span[contains(text(),'Select Tax')]")).click();	
		
		List<WebElement> yearelements = getDriver().findElements(By.xpath("//div[@id='TaxYear-list']//ul[@id='TaxYear_listbox']//li"));
		int yearelementssize=yearelements.size();
		Log.info("Number of years in the drop down:"+yearelementssize);
		for(int i=0;i<=(yearelementssize-1);i++)
		{
			
			Log.info(i+"."+"year:"+yearelements.get(i).getText());
			String year=yearelements.get(i).getText();
			Log.info("Selected year is:"+year);
			if (year.equals("2020")) {
				
				Log.info(year);
				yearelements.get(i).click();
				break;
			}

}
		
		WebElement selectallGlobal=getDriver().findElement(By.xpath("//input[@id='selectallGlobal']"));
		boolean selectGlobalChecked=selectallGlobal.isSelected();
		Log.info("Is Selectall global option selected?  "+selectGlobalChecked);
		if(selectGlobalChecked==false) {
			
			JavascriptExecutor selectallexe = (JavascriptExecutor) getDriver();
			selectallexe.executeScript("arguments[0].click();", selectallGlobal);
			Log.info("Selectall global option selected now.  ");
		}
		Thread.sleep(20000);

		boolean selectGlobalCheckedafter=selectallGlobal.isSelected();
		Log.info("Is Selectall global option selected?  "+selectGlobalCheckedafter);
		
		boolean selectallcheck=getDriver().findElement(By.xpath("//input[@id='selectall']")).isSelected();
		boolean formdetailscheck=getDriver().findElement(By.xpath("//input[@class='chkbxq']")).isSelected();
		
		Log.info("is selectallchecked:"+selectallcheck+"is form details checked:"+formdetailscheck);
		
		if(selectallcheck==true && formdetailscheck==true ) {

		Log.info("Select all checkbox validation completed");
		
		}else {
			
			Log.info("Select all validation failed"); 
		}
		//------14.Next button validation---------//
		Thread.sleep(20000);
		WebElement nextbutton=getDriver().findElement(By.xpath("//input[@id='btnSubmit']"));
		boolean nextbtncheck=nextbutton.isEnabled();
		
		if(nextbtncheck==true) {
		Actions action=new Actions(getDriver());
		
		action.moveToElement(nextbutton).click().build().perform();
		Log.info("Next button is in enabled mode");
		Log.info("Next button clicked");
		}else{
			Log.info("Next button is in disabled mode");
		}
		//---15. Submit to IRS popup---//
		
		String submitIRStext=getDriver().findElement(By.xpath("//a[@id='alertify-resetFocusBack']//following-sibling::article")).getText();
		String popuptextdisplayed="Please select recipient details to submit to IRS";
		Log.info(submitIRStext);
		Log.info(popuptextdisplayed);
		Thread.sleep(20000);
		Actions okaction=new Actions(getDriver());
		WebElement okbutton=getDriver().findElement(By.xpath("//button[@id='alertify-ok']"));
		okaction.moveToElement(okbutton).click().build().perform();
		
		Log.info("Ok button clicked");
		
		
		Thread.sleep(10000);
		WebElement reviewcheckbox=getDriver().findElement(By.id("AgreeChkBoxId"));
		Actions reviewcheckboxaction=new Actions(getDriver());
		reviewcheckboxaction.moveToElement(reviewcheckbox).click().build().perform();
		Thread.sleep(20000);
		
		Actions okactionreview=new Actions(getDriver());
		WebElement okbuttonreview=getDriver().findElement(By.xpath("//button[@id='alertify-ok']"));
		okactionreview.moveToElement(okbuttonreview).click().build().perform();
		Log.info("Ok button on reviewed popup clicked");
		
		Thread.sleep(20000);
		

}}
