package com.demo.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demo.Base.base;
import com.demo.pages.OuterLoginButton;
import com.demo.utility.Log;

public class BeforeLoginTest extends base {
	OuterLoginButton OuterLoginButton;

	// LoginPage LoginPage;
	@BeforeMethod
	public void setUp() {
		launchApp();
	}

	@AfterMethod
	public void teardown() {
		getDriver().quit();
	}

	@Test
	public void verifyouterTax1099Logo() throws Throwable {

		Log.startTestCase("verifyouter Tax1099Logo Test");
		OuterLoginButton = new OuterLoginButton();
		boolean result = OuterLoginButton.validateLogo();
		Assert.assertTrue(result);
		Log.endTestCase("verifyouter Tax1099Logo Was Succesful");
	}

	@Test
	public void GetTitle() {
		String actualTitle = getDriver().getTitle();
		System.out.println("actual title is---" + "actualTitle");

	}

	
	  @Test 
	  public void verifyTitle() { 
		 
		  Log.startTestCase("Verified that the user landed on the Home Page.");
		  String actTitle=getDriver().getTitle();
		  Log.info(actTitle+"--------------------------");
	  System.out.println("actual title is---"+actTitle);
	  
	  String expectedTitle="File 1099 Online | eFile 1099 MISC, W2, 941, 1095 Forms – Tax1099";
	  
	  Assert.assertEquals(actTitle, expectedTitle);
	  
	  }
	 
}