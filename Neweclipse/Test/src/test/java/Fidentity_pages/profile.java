package Fidentity_pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Common.Fid_base;

public class profile extends Fid_base{
	
	String editedname="Sridevi test";
	String displayname;
	public void profileView() throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		/*		
WebElement element =driver.findElement(By.xpath("//li//a//i[contains(text(),'person_pin')]"));
		
	
		 Actions actions = new Actions(driver);
		actions.moveToElement(element).click().build().perform();
		System.out.println("my profile image clicked");*/
		Thread.sleep(8000);
		 driver.findElement(By.xpath("//li[@ng-class='show_account_div']//a[@ng-click='show_account_menu();closeNav()']")).click();
		//driver.findElement(By.xpath("//span//a[contains(text(),'My Profile')]")).click();
WebElement element2 =driver.findElement(By.xpath("//span//a[contains(text(),'My Profile')]"));
		
		
		Actions actions2 = new Actions(driver);
		actions2.moveToElement(element2).click().build().perform();
		
	}
		
	public void profileEdit() {
	driver.findElement(By.xpath("//div[@class='card']//a[@title='Edit Profile']")).click();
	
			}
	
	public void requiredfileds() throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='full_name']")).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END));
				driver.findElement(By.xpath("//input[@id='full_name']")).sendKeys(editedname);
				
		
	}
	
	public void update() throws InterruptedException {
		
		driver.findElement(By.xpath("//div[@class='input-field']//a[contains(text(),'Update')]")).click();
		Thread.sleep(8000);
		
	}
	public void compare() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		 displayname=driver.findElement(By.xpath("//input[@id='full_name']")).getText();
		
		if(editedname==displayname) {
			
			System.out.println("Edited name and daisplayed name are same"+editedname);
		}
		else {
			
			System.out.println("/n Given name "+editedname);
			System.out.println("/n  displayed name "+displayname);
		}
	}
	}


