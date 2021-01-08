package com.demo.Base;

	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
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
				WebDriverManager.chromedriver().setup();
				driver.set( new ChromeDriver());
				// Set Browser to ThreadLocalMap
			} else if (browserName.equalsIgnoreCase("FireFox")) {
				WebDriverManager.firefoxdriver().setup();
				driver.set(new FirefoxDriver());
			} else if (browserName.equalsIgnoreCase("IE")) {
				WebDriverManager.iedriver().setup();
				driver.set(new InternetExplorerDriver());
			}
			getDriver().manage().window().maximize();
			//Delete all the cookies
			getDriver().manage().deleteAllCookies();
			//Implicit TimeOuts
			getDriver().manage().timeouts().implicitlyWait
			(Integer.parseInt(prop.getProperty("implicitWait")),TimeUnit.SECONDS);
			//PageLoad TimeOuts
			getDriver().manage().timeouts().pageLoadTimeout
			(Integer.parseInt(prop.getProperty("pageLoadTimeOut")),TimeUnit.SECONDS);
			//Launching the URL
			getDriver().get(prop.getProperty("url"));
		
		}
		@AfterSuite
		public void afterSuite() {
			ExtentManager.endReport();
		}
}


