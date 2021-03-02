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
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
		
		
		String ActualTitle = getDriver().getTitle();
		String ExpectedTitle = "Amazon";
		Assert.assertEquals(ActualTitle, ExpectedTitle);
	}
	
	

//@Test(priority=2)

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
