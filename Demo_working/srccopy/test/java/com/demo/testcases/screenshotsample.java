package com.demo.testcases;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

import com.demo.Base.base;
import com.demo.PeopleLeftMenu.ManagePayerAddPayer;
import com.demo.PeopleLeftMenu.ManagePeople;
import com.demo.pages.Db;
import com.demo.pages.LoginPage;
import com.demo.pages.OuterLoginButton;

public class screenshotsample extends base{
	
	LoginPage LoginPage;
	OuterLoginButton OuterLoginButton;
	Db Db;
	ManagePeople ManagePeople;
	ManagePayerAddPayer ManagePayerAddPayer;
		    @Test

		    public void testGuru99TakeScreenShot() throws Exception{

				
		    	launchApp();
		    	

		        //Call take screenshot function

		        this.takeSnapShot() ;     

		    }

		
		    public  static void takeSnapShot() throws Exception{

		        //Convert web driver object to TakeScreenshot

		        TakesScreenshot scrShot =((TakesScreenshot)getDriver());

		        //Call getScreenshotAs method to create image file

		                File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

		            //Move image file to new destination

		                File DestFile=new File("test-output\\testoutput.png");

		                //Copy file at destination

		                FileUtils.copyFile(SrcFile, DestFile);

		    }

		}
		
