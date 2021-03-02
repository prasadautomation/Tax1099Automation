package Fidentity_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Common.Fid_base;

public class SigninUrl extends Fid_base{
	@Test
	public void UrlSignIn() {
		
		
	}
		
		public void LaunchBrowser() {
			
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Sridevi\\Downloads\\chromedriver_win32(1)\\chromedriver(1).exe");
			//C:\Users\Sridevi\Downloads\chromedriver_win32 (1)
			driver=new ChromeDriver();
		driver.get("https://test-s963.fidentity.com/");
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("sridevi175@srtest.com");
		
		
		
	}
	

}
