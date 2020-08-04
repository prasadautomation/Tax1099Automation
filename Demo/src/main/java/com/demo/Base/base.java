package com.demo.Base;

	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.ie.InternetExplorerDriver;
	import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.demo.actiondriver.Action;

import io.github.bonigarcia.wdm.WebDriverManager;

	public class base {
		public static Properties prop;
		public static WebDriver driver;

		@BeforeSuite
		public void beforesuite() {
			DOMConfigurator.configure("log4j.xml");
		}
		
		@BeforeTest
		public void loadConfig() {
			
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
		public static void launchApp() {
			String browserName = prop.getProperty("browser");
			if (browserName.equalsIgnoreCase("Chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				// Set Browser to ThreadLocalMap
			} else if (browserName.equalsIgnoreCase("FireFox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			} else if (browserName.equalsIgnoreCase("IE")) {
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
			}
			driver.manage().window().maximize();
			Action.implicitWait(driver, 10);
			Action.pageLoadTimeOut(driver, 30);
			driver.get(prop.getProperty("url"));
		
		}

}


