package Fidentity_pages;

import org.openqa.selenium.chrome.ChromeDriver;

import Common.Fid_base;

public class trailxray extends Fid_base{
	
	
	public void fidentity_site() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.get("https://test-s3377.fidentity.com/");
		driver.manage().window().maximize();
		Thread.sleep(5000);
	}

}
