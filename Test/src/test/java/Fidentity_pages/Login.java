package Fidentity_pages;





// import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.chrome.ChromeDriver;


//import org.openqa.selenium.chrome.ChromeDriver;

import Common.Fid_base;


public class Login  extends Fid_base {

		public void LaunchBrowser() {
		
		System.setProperty("webdriver.chrome.driver","E:\\chromedriver_win32\\chromedriver.exe");
		
		driver=new ChromeDriver();
	}
	
	 public void Launchtestportal() throws InterruptedException {
		 
		 driver.manage().deleteAllCookies();
		 driver.navigate().refresh();
			// driver.get("https://test-onboard.fidentity.com/signup.php"); 
		 //driver.get("https://test-onboard.fidentity.com/signup.php?currency=usd");
		driver.get("https://test-onboard.fidentity.com/signup.php?currency=gbp"); 
		//driver.get("https://test-stest.fidentity.com/");
			Thread.sleep(5000);
		}
	public void LaunchPortal() {
		
		
		driver.get("https://www.fidentity.com/");
		
	}
	
	public void LaunchSignInPortal() {
		
		driver.get("https://test-stest.fidentity.com/login");
	}
	 
	 public void SignIn() throws InterruptedException {
		 
		 driver.findElement(By.xpath("//input[@id='username']")).sendKeys("sridevi592@srtest.com");
		Thread.sleep(1000);
		 driver.findElement(By.xpath("//button[contains(text(),'Next')]")).click();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		
		 //System.out.print("email successfull  ");
		 
		 driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("India@01");
		 
		
		 driver.findElement(By.xpath("//form[@id='password_form']//child::button[contains(text(),'Login')]")).click();
		
	 }
	 
	 public void User() {
		 
		
		// driver.get("<li ng-show='session_data.login_type == 'admin' || session_data.login_type == 'employee'' >");
		 
		// String user=driver.findElement(By.xpath("//li[contains(@ng-show='session_data.login_type')]")).getText();
		
		 
		 String user =driver.findElement(By.xpath("//title[@class='ng-binding']")).getText();
		 
		 
		 System.out.print("User is admin:----"+user);
		 
		 
		 
	        }
	 }

