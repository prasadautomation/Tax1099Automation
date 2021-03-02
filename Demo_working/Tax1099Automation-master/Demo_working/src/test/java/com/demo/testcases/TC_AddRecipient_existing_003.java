package com.demo.testcases;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
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

public class TC_AddRecipient_existing_003 extends base {
		
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
			Db Db = LoginPage.login(Useremail, Passwd);}
	

@Test(priority=2)
public void payercount_existingaccount() throws InterruptedException {
	Log.startTestCase("payercount_newaccount");

	Thread.sleep(40000);

	WebElement element = getDriver().findElement(By.xpath("//p[contains(text(),'People')]"));
	WebDriverWait wait = new WebDriverWait(getDriver(), 60);
	wait.until(ExpectedConditions.elementToBeClickable(element));
	JavascriptExecutor passwordexecutor = (JavascriptExecutor) getDriver();
	passwordexecutor.executeScript("arguments[0].click();", element);
	Thread.sleep(60000);
	Log.info("People menu clicked");

	String menutext = getDriver().findElement(By.xpath("//*[@id='firstpane']/div[2]/p")).getText();
	Log.info("menu text:" + menutext);
	getDriver().findElement(By.xpath("//a[contains(text(),'Manage Recipient')]")).click();

	Thread.sleep(10000);

	Log.info("Manage recipient clicked");
	Thread.sleep(10000);
	//TC_AddRecipient_Nodata_002 addrecipient=new TC_AddRecipient_Nodata_002();
	//addrecipient.payercount();
	//Thread.sleep(50000);
//	addrecipient.recipientCount();
}
@Test(priority=3)
public void payerscountCompare() throws InterruptedException {
	
	Log.startTestCase("payerscountCompare");
	Thread.sleep(2000);
	//----get payer count from drop down in manage recipient page----//

	Select payerlist=new Select(getDriver().findElement(By.id("ddlPayer")));
	List <WebElement>payers=payerlist.getOptions();
	int payerscount=payers.size();
	Log.info("number of payers in manage recipient page:"+payerscount);
	String records=String.valueOf(payerscount);
	
//---get payer count in manage payer page---//
	
	String menutext=getDriver().findElement(By.xpath("//*[@id='firstpane']/div[2]/p")).getText();
	Log.info("menu text:"+menutext);
	

	getDriver().findElement(By.xpath("//a[contains(text(),'Manage Payer')]")).click();
	
	Thread.sleep(10000);
	
	Log.info("Manage payer clicked");
	
	Thread.sleep(20000);
	
	String itemstext=getDriver().findElement(By.xpath("//span[contains(text(),'1 - 10 of ')]")).getText();
	
	
	int lengthoftext=itemstext.length();
	Log.info("Text for number of records and length:"+itemstext+" and "+lengthoftext);
	CharSequence numberofitems=itemstext.subSequence(10,(lengthoftext-6));
	String items=String.valueOf(numberofitems);
	Log.info("Payer count in manage payer page:"+items);
	assertEquals(items,records);

	Log.info("Payer count same in manage payer and manage recipient pages");
	
//	if (items.equals(payerscount)) {}
	
}

}

