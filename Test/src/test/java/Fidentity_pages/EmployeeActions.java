package Fidentity_pages;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import Common.Fid_base;

public class EmployeeActions extends Fid_base {
public void employee_Actions_nav() {
	
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	WebElement element= driver.findElement(By.xpath("//div[@class='side-wrapper']//ul[1]//li[@id='service_users_parent']//a"));
	JavascriptExecutor executor = (JavascriptExecutor) driver;
	executor.executeScript("arguments[0].click();", element);
	
	WebElement viewemp= driver.findElement(By.xpath("//div[@id='service_user_features']//span//a[contains(text(),'View Employees')]"));
	JavascriptExecutor empexecutor = (JavascriptExecutor) driver;
	empexecutor.executeScript("arguments[0].click();", viewemp);
	
	
}
	public void edit_emp_validations() throws ClassNotFoundException, SQLException, InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement editemp= driver.findElement(By.xpath("//form[@id='view_employees_filter_form']/following-sibling::div[@class='row']//li[2]//table//td[@class='staff-list-actions']//a[2]"));
		JavascriptExecutor editexecutor = (JavascriptExecutor) driver;
		editexecutor.executeScript("arguments[0].click();", editemp);
		
		driver.findElement(By.xpath("//form[@id='staff_details']//input[@id='employee_name']")).clear();
		driver.findElement(By.xpath("	//form[@id='staff_details']//input[@id='phone_number']")).clear();
		driver.findElement(By.xpath("	//form[@id='staff_details']//input[@id='phone_number']")).sendKeys("1111111111");
		driver.findElement(By.xpath("	//form[@id='staff_details']//input[@id='email']")).clear();
		driver.findElement(By.xpath("	//form[@id='staff_details']//input[@id='email']")).sendKeys("sree@zenwork.com");
			
		
		WebElement nameupdate= driver.findElement(By.xpath("//div[@id='edit_staff_modal']//div[@class='modal-footer']//a[contains(@class,'primary-button') and contains(text(),'Update')]"));
		JavascriptExecutor nameexecutor = (JavascriptExecutor) driver;
		nameexecutor.executeScript("arguments[0].click();", nameupdate);
		Thread.sleep(2000);
		
		WebElement namecancel= driver.findElement(By.xpath("//div[@id='edit_staff_modal']//div[@class='modal-footer']//a[contains(@class,'reset-button') and contains(text(),'Cancel')]"));
		JavascriptExecutor namecancelexe = (JavascriptExecutor) driver;
		namecancelexe.executeScript("arguments[0].click();", namecancel);
		Thread.sleep(2000);
		WebElement editphone= driver.findElement(By.xpath("//form[@id='view_employees_filter_form']/following-sibling::div[@class='row']//li[2]//table//td[@class='staff-list-actions']//a[2]"));
		JavascriptExecutor editphoneexe = (JavascriptExecutor) driver;
		editphoneexe.executeScript("arguments[0].click();", editphone);
		
		
		driver.findElement(By.xpath("//form[@id='staff_details']//input[@id='employee_name']")).clear();
		driver.findElement(By.xpath("//form[@id='staff_details']//input[@id='employee_name']")).sendKeys("Test");
		driver.findElement(By.xpath("//form[@id='staff_details']//input[@id='phone_number']")).clear();
		driver.findElement(By.xpath("//form[@id='staff_details']//input[@id='email']")).clear();
		driver.findElement(By.xpath("//form[@id='staff_details']//input[@id='email']")).sendKeys("sree@zenwork.com");
		WebElement phoneupdate= driver.findElement(By.xpath("//div[@id='edit_staff_modal']//div[@class='modal-footer']//a[contains(@class,'primary-button') and contains(text(),'Update')]"));
		JavascriptExecutor phonexecutor = (JavascriptExecutor) driver;
		phonexecutor.executeScript("arguments[0].click();", phoneupdate);
		Thread.sleep(2000);
		WebElement phonecancel= driver.findElement(By.xpath("//div[@id='edit_staff_modal']//div[@class='modal-footer']//a[contains(@class,'reset-button') and contains(text(),'Cancel')]"));
		JavascriptExecutor phonecancelexe = (JavascriptExecutor) driver;
		phonecancelexe.executeScript("arguments[0].click();", phonecancel);
		Thread.sleep(2000);
		WebElement editmail= driver.findElement(By.xpath("//form[@id='view_employees_filter_form']/following-sibling::div[@class='row']//li[2]//table//td[@class='staff-list-actions']//a[2]"));
		JavascriptExecutor editmailexe = (JavascriptExecutor) driver;
		editmailexe.executeScript("arguments[0].click();", editmail);
		
		
		
		driver.findElement(By.xpath("//form[@id='staff_details']//input[@id='employee_name']")).clear();
		driver.findElement(By.xpath("//form[@id='staff_details']//input[@id='employee_name']")).sendKeys("Test");
		driver.findElement(By.xpath("//form[@id='staff_details']//input[@id='phone_number']")).clear();
		driver.findElement(By.xpath("//form[@id='staff_details']//input[@id='phone_number']")).sendKeys("1111111111");
		driver.findElement(By.xpath("//form[@id='staff_details']//input[@id='email']")).clear();
		WebElement mailupdate= driver.findElement(By.xpath("//div[@id='edit_staff_modal']//div[@class='modal-footer']//a[contains(@class,'primary-button') and contains(text(),'Update')]"));
		JavascriptExecutor mailexecutor = (JavascriptExecutor) driver;
		mailexecutor.executeScript("arguments[0].click();", mailupdate);
		Thread.sleep(2000);
		
		WebElement mailcancel= driver.findElement(By.xpath("//div[@id='edit_staff_modal']//div[@class='modal-footer']//a[contains(@class,'reset-button') and contains(text(),'Cancel')]"));
		JavascriptExecutor mailcancelexe = (JavascriptExecutor) driver;
		mailcancelexe.executeScript("arguments[0].click();", mailcancel);
		Thread.sleep(2000);
			
		/*Class.forName("com.mysql.jdbc.Driver");
		 // Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://35.153.40.38:3306", "stageuser","stage(password)" );
	 Statement stmt = con.createStatement();*/
			
	}
	public void emp_details() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement editemp= driver.findElement(By.xpath("//form[@id='view_employees_filter_form']/following-sibling::div[@class='row']//li[2]//table//td[@class='staff-list-actions']//a[2]"));
		JavascriptExecutor editexecutor = (JavascriptExecutor) driver;
		editexecutor.executeScript("arguments[0].click();", editemp);
		
		driver.findElement(By.xpath("//form[@id='staff_details']//input[@id='employee_name']")).clear();
		driver.findElement(By.xpath("//form[@id='staff_details']//input[@id='employee_name']")).sendKeys("Testname");
		driver.findElement(By.xpath("//form[@id='staff_details']//input[@id='phone_number']")).clear();
		driver.findElement(By.xpath("//form[@id='staff_details']//input[@id='phone_number']")).sendKeys("1111111111");
		driver.findElement(By.xpath("//form[@id='staff_details']//input[@id='email']")).clear();
		driver.findElement(By.xpath("//form[@id='staff_details']//input[@id='email']")).sendKeys("sree@zenwork.com");
		
		WebElement mailupdate= driver.findElement(By.xpath("//div[@id='edit_staff_modal']//div[@class='modal-footer']//a[contains(@class,'primary-button') and contains(text(),'Update')]"));
		JavascriptExecutor mailexecutor = (JavascriptExecutor) driver;
		mailexecutor.executeScript("arguments[0].click();", mailupdate);
		Thread.sleep(2000);
	}
	
	public void fields_validation() throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement editemp= driver.findElement(By.xpath("//form[@id='view_employees_filter_form']/following-sibling::div[@class='row']//li[2]//table//td[@class='staff-list-actions']//a[2]"));
		JavascriptExecutor editexecutor = (JavascriptExecutor) driver;
		editexecutor.executeScript("arguments[0].click();", editemp);
		
		String telephoneNr1 = "1111111111";
		String telephoneNr2 = "125";
		String telephoneNr3 = "sree";
		driver.findElement(By.xpath("//form[@id='staff_details']//input[@id='employee_name']")).clear();
		driver.findElement(By.xpath("//form[@id='staff_details']//input[@id='employee_name']")).sendKeys("Testname");
		driver.findElement(By.xpath("//form[@id='staff_details']//input[@id='phone_number']")).clear();
		driver.findElement(By.xpath("//form[@id='staff_details']//input[@id='phone_number']")).sendKeys(telephoneNr1);
		driver.findElement(By.xpath("//form[@id='staff_details']//input[@id='email']")).clear();
		driver.findElement(By.xpath("//form[@id='staff_details']//input[@id='email']")).sendKeys("sree@zenwork.com");
		
		   if (telephoneNr1.matches("^(?=(?:[8-9]){1})(?=[0-9]{10}).*")) {
	        System.out.println("Valid phone number!");
	        
	        WebElement mailupdate= driver.findElement(By.xpath("//div[@id='edit_staff_modal']//div[@class='modal-footer']//a[contains(@class,'primary-button') and contains(text(),'Update')]"));
			JavascriptExecutor mailexecutor = (JavascriptExecutor) driver;
			mailexecutor.executeScript("arguments[0].click();", mailupdate);
	    }
	    else {
	        System.out.println("Invalid!");
	        System.out.print("\n"+"entered phone number is "+telephoneNr1);
	        WebElement mailcancel= driver.findElement(By.xpath("//div[@id='edit_staff_modal']//div[@class='modal-footer']//a[contains(@class,'reset-button') and contains(text(),'Cancel')]"));
			JavascriptExecutor mailcancelexe = (JavascriptExecutor) driver;
			mailcancelexe.executeScript("arguments[0].click();", mailcancel);
			Thread.sleep(2000);
	    }
		
		
		
	}
	
}
