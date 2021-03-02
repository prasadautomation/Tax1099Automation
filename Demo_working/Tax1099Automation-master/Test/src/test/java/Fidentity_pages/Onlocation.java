package Fidentity_pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import Common.Fid_base;

public class Onlocation extends Fid_base {
	
	public void onlocation_nav() {
	
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
	WebElement element= driver.findElement(By.xpath("//div[@class='side-wrapper']//ul[1]//li[@id='service_vms_parent']//a"));

	JavascriptExecutor executor = (JavascriptExecutor) driver;
	executor.executeScript("arguments[0].click();", element);
	
		
	
	 WebElement we = driver.findElement(By.xpath("//div[@id='service_features']//div//span[1]//a[contains(text(),'On-Location')]"));
	 JavascriptExecutor passexecutor = (JavascriptExecutor) driver;
	 passexecutor.executeScript("arguments[0].click();", we);
	 
		System.out.print("Visitor pass clicked");  

}
	
	public void checked_in() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		String checkedin_count=driver.findElement(By.xpath("//div//h1[contains(text(),'Currently Checked-In')]//b")).getText();
		
		
		if(checkedin_count.equals("0")) {
			
			System.out.print("There are no checked in records");
		}else {System.out.print("Number of visitors who are already checked in: "+checkedin_count);}
	
	}
	
	public void select_checkedin() {
		
String checkedin_count=driver.findElement(By.xpath("//div//h1[contains(text(),'Currently Checked-In')]//b")).getText();
		
		
		if(checkedin_count.equals("0")) {
			
			System.out.print("There are no checked in records");
		}else {
		
		 WebElement select = driver.findElement(By.xpath("//table[contains(@class,'responsive-table' )]//tbody//tr"));
		 JavascriptExecutor selectexecutor = (JavascriptExecutor) driver;
		 selectexecutor.executeScript("arguments[0].click();", select);}
		
	}
	public void checked_out() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
String checkedin_count=driver.findElement(By.xpath("//div//h1[contains(text(),'Currently Checked-In')]//b")).getText();
		
		
		if(checkedin_count.equals("0")) {
			
			System.out.print("There are no checked in records");
		}else {
		
		 WebElement checkout = driver.findElement(By.xpath("//a[@class='primary-button' and contains(text(),'Checkout')]"));
		 JavascriptExecutor checkoutexecutor = (JavascriptExecutor) driver;
		 checkoutexecutor.executeScript("arguments[0].click();", checkout);
		
		}
		 
	}
	
	public void cancel_checkout() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
String checkedin_count=driver.findElement(By.xpath("//div//h1[contains(text(),'Currently Checked-In')]//b")).getText();
		
		
		if(checkedin_count.equals("0")) {
			
			System.out.print("There are no checked in records");
		}else {
		
			
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 WebElement checkoutcancel = driver.findElement(By.xpath("//div[@id='checkoutModal']//a[contains(@class,'reset-button') and contains(text(),'No, Cancel')]"));
		 JavascriptExecutor cancelexecutor = (JavascriptExecutor) driver;
		 cancelexecutor.executeScript("arguments[0].click();", checkoutcancel);
	}}
	
	public void confirm_checkout() {
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String checkedin_count=driver.findElement(By.xpath("//div//h1[contains(text(),'Currently Checked-In')]//b")).getText();
				
				
				if(checkedin_count.equals("0")) {
					
					System.out.print("There are no checked in records");
				}else {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		 WebElement checkoutconfirm = driver.findElement(By.xpath("//div[@id='checkoutModal']//a[@class='primary-button' and contains(text(),'Yes, Checkout')]"));
		 JavascriptExecutor confirmexecutor = (JavascriptExecutor) driver;
		 confirmexecutor.executeScript("arguments[0].click();", checkoutconfirm);
		 
				}
	}
	
	public void cancel_successful() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
String checkedin_count=driver.findElement(By.xpath("//div//h1[contains(text(),'Currently Checked-In')]//b")).getText();
		
		
		if(checkedin_count.equals("0")) {
			
			System.out.print("There are no checked in records");
		}else {
		
		System.out.print("/nChecked out cancelled successfully,count of records are  "+checkedin_count);}
	}
	public void checkout_successfully() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
String checkedin_count=driver.findElement(By.xpath("//div//h1[contains(text(),'Currently Checked-In')]//b")).getText();
		
		
		if(checkedin_count.equals("0")) {
			
			System.out.print("There are no checked in records");
		}else {
		
		
		System.out.print("/n count of records are  "+checkedin_count);}
	}
	
	public void extend_Time() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
String checkedin_count=driver.findElement(By.xpath("//div//h1[contains(text(),'Currently Checked-In')]//b")).getText();
		
		
		if(checkedin_count.equals("0")) {
			
			System.out.print("There are no checked in records");
		}else {
	
		
		
		
		WebElement extendtime = driver.findElement(By.xpath("//a[@class='primary-button' and contains(text(),'Extend Time')]"));
		 JavascriptExecutor extendtimeexecutor = (JavascriptExecutor) driver;
		 extendtimeexecutor.executeScript("arguments[0].click();", extendtime);
		 
		//div[@id='extendTImeModal']//form[@id='extendTimeForm']//p[2]//label
		 
		 WebElement selecttime = driver.findElement(By.xpath("//div[@id='extendTImeModal']//form[@id='extendTimeForm']//p//label[@for='time2']"));
		 JavascriptExecutor extendtimexecutor = (JavascriptExecutor) driver;
		 extendtimexecutor.executeScript("arguments[0].click();", selecttime);
		 
		 
		 WebElement extended = driver.findElement(By.xpath("//div[@id='extendTImeModal']//div[@class='modal-footer']//a[@class='primary-button' and contains(text(),'Extend Time')]"));
		 JavascriptExecutor extendedexecutor = (JavascriptExecutor) driver;
		 extendedexecutor.executeScript("arguments[0].click();", extended);
			 
	}}
	
	public void extend_cancel() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
String checkedin_count=driver.findElement(By.xpath("//div//h1[contains(text(),'Currently Checked-In')]//b")).getText();
		
		
		if(checkedin_count.equals("0")) {
			
			System.out.print("There are no checked in records");
		}else {
		
		WebElement extendtime = driver.findElement(By.xpath("//a[@class='primary-button' and contains(text(),'Extend Time')]"));
		 JavascriptExecutor extendtimeexecutor = (JavascriptExecutor) driver;
		 extendtimeexecutor.executeScript("arguments[0].click();", extendtime);
		 
		 Thread.sleep(5000);
		
		 WebElement extendcancel = driver.findElement(By.xpath("//div[@id='extendTImeModal']//a[contains(text(),'Cancel')]"));
		 JavascriptExecutor extendcancelexecutor = (JavascriptExecutor) driver;
		 extendcancelexecutor.executeScript("arguments[0].click();", extendcancel);
		 
		 System.out.print("extended time cancelled");
		 
		}
		
	}
	
		
	}


