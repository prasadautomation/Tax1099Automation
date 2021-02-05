package Fidentity_pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Common.Fid_base;
import Object_repo.Changepasswordrepo;
import Object_repo.Signinrepo;

public class Sign_in extends Fid_base{ 
	
	//String user="sridevi@zenwork.com";
	//String testurl="https://test-s3377.fidentity.com/";
	
	
	//String user="sridevifidentity@gmail.com";
	String user="sridevifidentity@gmail.com";
//	String user="sridevi2284@srtest.com";
//	String testurl="https://test-s2284.fidentity.com/";
	
	
	public void loginwith_credentials() throws InterruptedException, IOException {
	
		
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		driver.get(testurl); 
		
		driver.manage().window().maximize();
		Thread.sleep(5000);
		PageFactory.initElements(driver, Signinrepo.class);
		
	//	driver.findElement(By.xpath("//form[@id='loginForm']//child::input[@id='username']")).sendKeys(user);
	//	driver.findElement(By.xpath("//form[@id='loginForm']//input[@id='username']")).sendKeys(user);
		//driver.findElement(By.xpath("//button[contains(text(),'Next')]")).click();
		
FileInputStream fis = new FileInputStream(
				
				"E:\\eclipse-workspace\\Fidentity\\src\\test\\java\\passwordvalidations.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(4);

		

			System.out.println("\n" + "User name: " + sheet.getRow(1).getCell(0).getStringCellValue());
			String user = sheet.getRow(1).getCell(0).getStringCellValue();
			Signinrepo.Username.sendKeys(user);
			
			System.out.println("\n" + "Password:" + sheet.getRow(1).getCell(1).getStringCellValue());
			 String pswd = sheet.getRow(1).getCell(1).getStringCellValue();
			
			 Thread.sleep(2000);
		JavascriptExecutor nextexecutor = (JavascriptExecutor) driver;
		nextexecutor.executeScript("arguments[0].click();", Signinrepo.usernamenext);
		Thread.sleep(2000);
		
		Signinrepo.userpassword.sendKeys(pswd);
		System.out.print("\n"+"Password enetered:"+pswd);
		
		JavascriptExecutor login = (JavascriptExecutor) driver;
		login.executeScript("arguments[0].click();", Signinrepo.Loginbutton);
	
		

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
