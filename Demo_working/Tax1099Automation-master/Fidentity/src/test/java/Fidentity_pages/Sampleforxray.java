package Fidentity_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Object_repo.Empactionsrepo;

public class Sampleforxray {
	public static WebDriver driver;
	public void launchbrowser() {
		
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver_win32\\chromedriver.exe");  
		 driver=new ChromeDriver();
	}
public void testurl() {
	
	driver.get("https://www.amazon.com/");
	driver.manage().window().maximize();
}
public void selectitem() throws InterruptedException {
	driver.findElement(By.id("twotabsearchtextbox")).sendKeys("kids books");
	
	 WebElement booklink=driver.findElement(By.id("pdagDesktopSparkleHeadline"));
	JavascriptExecutor editiconexe = (JavascriptExecutor) driver;
	editiconexe.executeScript("arguments[0].click();", booklink);
	
	 WebElement booktype=driver.findElement(By.xpath("//span[contains(text(),'Novelty books')]"));
		JavascriptExecutor booktypeexe = (JavascriptExecutor) driver;
		booktypeexe.executeScript("arguments[0].click();", booktype);
	
	
	Thread.sleep(2000);
	
	
}



}
