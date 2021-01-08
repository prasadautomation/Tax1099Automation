package com.demo.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.demo.actiondriver.Action;
import com.demo.utility.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.internal.org.jline.utils.Log;

public class base {
	public static Properties prop;
//		public static WebDriver driver;
	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

	@BeforeSuite
	public void loadConfig() {
		ExtentManager.setExtent();
		DOMConfigurator.configure("log4j.xml");

		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "\\Configuration\\config.properties");
			prop.load(ip);
			System.out.println("driver:  " + driver);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static WebDriver getDriver() {
		// Get Driver from threadLocalmap
		return driver.get();
	}

	public static void launchApp() {
		String browserName = prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("Chrome")) {
			
			ChromeOptions options = new ChromeOptions();
			options.setPageLoadStrategy(PageLoadStrategy.NONE);
			// Instantiate the chrome driver
			//driver = new ChromeDriver(options);
			WebDriverManager.chromedriver().setup();
			driver.set(new ChromeDriver(options));
			
			// Set Browser to ThreadLocalMap
		} else if (browserName.equalsIgnoreCase("FireFox")) {
			WebDriverManager.firefoxdriver().setup();
			driver.set(new FirefoxDriver());
		} else if (browserName.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			driver.set(new InternetExplorerDriver());
		}
		getDriver().manage().window().maximize();
		// Delete all the cookies
		getDriver().manage().deleteAllCookies();
		// Implicit TimeOuts
		getDriver().manage().timeouts().implicitlyWait(Integer.parseInt(prop.getProperty("implicitWait")),
				TimeUnit.SECONDS);
		// PageLoad TimeOuts
		getDriver().manage().timeouts().pageLoadTimeout(Integer.parseInt(prop.getProperty("pageLoadTimeOut")),
				TimeUnit.SECONDS);
		// Launching the URL
		getDriver().get(prop.getProperty("url"));
		System.setProperty("webdriver.chrome.driver","E:\\selenium\\chromedriver_2.41\\chromedriver.exe");
		//mention the below chrome option to solve timeout exception issue
		

	}
	
	public void  getIntRandomNumber(){
		Random rand = new Random();
	      System.out.println("Random numbers...");
	      for (int i = 1; i<= 10; i++) {
	          int resRandom = rand.nextInt((9999 - 100) + 1) + 10;
	       
	        
	      }}
	  public void random(String totalString) {
		  
		  Random rd = new Random();

		  int rdnum;

		  rdnum = rd.nextInt(10);

		  //System.out.println("Random Number is : "+rdnum);

		  String m[] = new String[10];

		   totalString = "";
		  for(int i=0;i<9;i++) {
		  rdnum = rd.nextInt(10);

		  m[i] = Integer.toString(rdnum);

		  totalString =totalString+m[i];

		  //String totalString = m[0]+m[1]+m[2]+m[3]+m[4]+m[5]+m[6]+m[7]+m[8];
		  }

		  System.out.println("The TIN Number is :"+totalString);
return ;
		  //System.out.println("The TIN Number is :"+m[0]+m[1]+m[2]+m[3]+m[4]+m[5]+m[6]+m[7]+m[8]);	  
	  }
    

	public static void takeSnapShot() throws Exception {

		// Convert web driver object to TakeScreenshot

		TakesScreenshot scrShot = ((TakesScreenshot) getDriver());

		// Call getScreenshotAs method to create image file

		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

		// Move image file to new destination
		
		 String filename =  new SimpleDateFormat("yyyyMMddhhmmss'.txt'").format(new Date());
		  //  File dest = new File("filePath/" + filename);

		File DestFile = new File("test-output\\"+"testoutput"+filename+".png");

		// Copy file at destination

		FileUtils.copyFile(SrcFile, DestFile);
System.out.print("File of screen shot is: "+DestFile.getName());
	}

	@AfterSuite
	public void afterSuite() {
		ExtentManager.endReport();
	}
}
