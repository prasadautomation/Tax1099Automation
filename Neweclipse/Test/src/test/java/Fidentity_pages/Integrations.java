package Fidentity_pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Common.Fid_base;

public class Integrations extends Fid_base {
	
	
	public void integrationsnav() {
				WebElement element= driver.findElement(By.xpath("//li//a[@id='settings_discover']//i"));

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		
		// WebDriverWait wait = new WebDriverWait(driver, 30);
		// wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li//a[@id='settings_discover']//i")));
		// driver.findElement(By.xpath("//li//a[@id='settings_discover']//i")).click();
	/*	WebElement element = driver.findElement(By.xpath("//li//a[@id='settings_discover']"));

		Actions actions = new Actions(driver);

		actions.moveToElement(element).click().perform();
		 driver.findElement(By.xpath("//div[@id='service_configs'] and .//a[contains(text(),'Integrations')]")).click();
	//	WebDriverWait wait=new WebDriverWait(driver, 100);
//		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Integrations"))).click();*/
		
		WebElement element2 = driver.findElement(By.linkText("Integrations"));

		Actions actions2 = new Actions(driver);

		actions2.moveToElement(element2).click().perform();
	}
	
	public void gsuiteenable() throws InterruptedException {
		
		
		
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);	
		
		
		
		
	//	String status=driver.findElement(By.xpath("//div[@id='gsuite']//div//span//a[contains(text(),'Enable')]")).getAttribute("innerHTML");
	//	System.out.println(" Stautus -- "+status);
		
		
		String status=driver.findElement(By.xpath("//div[@id='gst_directory']//a[@class='waves-effect waves-light']")).getAttribute("innerHTML");
		
		if(status.equals("Enable")) {
			
		driver.findElement(By.xpath("//div[@id='gsuite']//div//span//a[contains(text(),'Enable')]")).click();
		
		driver.findElement(By.xpath("//div[@id='gsuite_confirmation_help']//div[@class='modal-footer']//a[contains(text(),'Proceed')]")).click();
		// Store the current window handle
		String winHandleBefore = driver.getWindowHandle();

		// Perform the click operation that opens new window

		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		   
		}
		 driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys("sridevi@checkon.co");
			driver.findElement(By.xpath("//div[@id='identifierNext']")).click();
			driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
			 driver.findElement(By.xpath("//input[@name='password']")).sendKeys("sridevi@123");
			 Thread.sleep(10000);
				driver.findElement(By.xpath("//div[@id='passwordNext']//span//span[contains(text(),'Next')]")).click();
				Thread.sleep(10000);
				driver.switchTo().window(winHandleBefore);
				// Thread.sleep(10000);
				//WebDriverWait wait = new WebDriverWait(driver, 30);
				// wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Close')]")));
				
			//	driver.findElement(By.xpath("//a[contains(text(),'Close')]")).click();
		// Perform the actions on new window
				
				// driver.close();
			 
		// Close the new window, if that window no more required
		
		// Switch back to original browser (first window)
	//	driver.switchTo().window(winHandleBefore);
	//	System.out.println("gsuite enabled comment");
			
			}else {
			
			System.out.println("Gsuite enabled you can remove");
		}
		
	////div[@id='gsuite']/parent::div[@class='card sticky-action']/following-sibling::div[@class='card sticky-action']/child::div[@class='card-content']
	}
	
	public void activeDirectory() {
	//	driver.findElement(By.xpath("div[@id='gsuite']/parent::div[@class='card sticky-action']/following-sibling::div[@class='card sticky-action']/child::div[@class='card-content']")).click();
		String status=driver.findElement(By.xpath("//div[@id='act_directory']//a[@class='waves-effect waves-light']")).getAttribute("innerHTML");
		
		System.out.println(" Active directory status --"+status);
		
		
		if(status.equals("Enable")) {
	
			driver.findElement(By.xpath("//div[@id='act_directory']//a[contains(text(),'Enable')]")).click();
			System.out.println("Active directory enabled ");
			
			
			for(String Scriptwindow : driver.getWindowHandles()){
			    driver.switchTo().window(Scriptwindow);
			   
			}driver.findElement(By.xpath("//div[@id='view_script_models']//div//a[contains(text(),'Ok')]")).click();
			
			}
		
	
	System.out.println("Active directory already enabled");
	
}
public void activeIntegration() {
	Sign_in signin=new Sign_in();
	System.out.println("user is---"+signin.user);
	
	Sign_in signinurl=new Sign_in();
	System.out.println("Test url is---"+signinurl.testurl);
	
	
	
}	

public void employeelist() {
	
	// driver.findElement(By.xpath("//li//a//i[contains(text(),'person_add')]")).click();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);	
	WebElement element = driver.findElement(By.xpath("//li//a//i[contains(text(),'person_add')]"));

	Actions actions = new Actions(driver);

	actions.click(element).build().perform();
	
//	driver.findElement(By.xpath("//div//span//a[contains(text(),'View Employees')]")).click();
WebElement element2 = driver.findElement(By.xpath("//div[@id='service_user_features']//a[contains(text(),'View Employees')]"));

	Actions actions2 = new Actions(driver);

	actions2.moveToElement(element2).click(element2).build().perform();
	String lastsyndate=driver.findElement(By.xpath("//div[@class='integration-note ng-binding'] and [contains(text(),'Gsuite last sync:  ')]")).getText();
	System.out.println("last syn date--"+lastsyndate);
}
}
