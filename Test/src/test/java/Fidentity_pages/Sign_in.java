package Fidentity_pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import Common.Fid_base;

public class Sign_in extends Fid_base{ 
	
	String user="sridevi903@srtest.com";
	String testurl="https://test-s903.fidentity.com/";
	
	public void loginwith_cedentials() {
		
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(testurl);
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//form[@id='loginForm']//child::input[@id='username']")).sendKeys(user);
		//driver.findElement(By.xpath("//button[contains(text(),'Next')]")).click();
		
		WebElement next= driver.findElement(By.xpath("//button[contains(text(),'Next')]"));
		JavascriptExecutor nextexecutor = (JavascriptExecutor) driver;
		nextexecutor.executeScript("arguments[0].click();", next);
		
		//driver.findElement(By.xpath("//form[@id='password_form']//div[@class='input-field']//input[@id='password']")).clear();
		driver.findElement(By.xpath("//form[@id='password_form']//div[@class='input-field']//input[@id='password']")).sendKeys("Sridevi@1234");
		driver.findElement(By.xpath("//form[@id='password_form']//div[@class='input-field']//span[@class='resend-otp-span']"));
		//span[@class='resend-otp-span']
		//driver.findElement(By.xpath("//a[contains(text(),'Forgot pasword')]"));
		driver.findElement(By.xpath("//form[@id='password_form']//button[contains(text(),'Login')]")).click();
		
		
		
	}
	
	public void fidentitySignIn() throws InterruptedException {
		
		driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@name='signin_email']")).sendKeys("sridevi175@srtest.com");
		driver.findElement(By.xpath("//a[@class='remind-me-button']")).click(); 
		
		driver.findElement(By.xpath("//form[@id='loginForm']//child::input[@id='username']")).sendKeys("sridevi175@srtest.com");
		driver.findElement(By.xpath("//button[contains(text(),'Next')]")).click();
		
		//driver.findElement(By.xpath("//form[@id='password_form']//div[@class='input-field']//input[@id='password']")).clear();
		driver.findElement(By.xpath("//form[@id='password_form']//div[@class='input-field']//input[@id='password']")).sendKeys("Sridevi@1234");
		driver.findElement(By.xpath("//form[@id='password_form']//div[@class='input-field']//span[@class='resend-otp-span']"));
		//span[@class='resend-otp-span']
		//driver.findElement(By.xpath("//a[contains(text(),'Forgot pasword')]"));
		driver.findElement(By.xpath("//form[@id='password_form']//button[contains(text(),'Login')]")).click();
		
	}
	
	
	

}
