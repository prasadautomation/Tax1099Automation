package Fidentity_pages;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Common.Fid_base;

public class Addemployee extends Fid_base {
	
	
	
	 public Statement stmt;

		public void dbconnection() throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.jdbc.Driver");
		 // Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://35.153.40.38:3306", "stageuser","stage(password)" );
	 stmt = con.createStatement();

		
		}
	
	public void addemp_Nav() throws SQLException  {
		
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement element= driver.findElement(By.xpath("//div[@class='side-wrapper']//ul[1]//li[@id='service_users_parent']//a"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		WebElement addemp= driver.findElement(By.xpath("//div[@id='service_user_features']//span[2]//a[contains(text(),'Add Employee')]"));
		JavascriptExecutor addempexecutor = (JavascriptExecutor) driver;
		addempexecutor.executeScript("arguments[0].click();", addemp);
		
			
	
	}
		
	
	
	public void emp_fields() throws InterruptedException {
		
		//adding new employee
		
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='invite_first_name']")).sendKeys("SreeTest");
	
		WebElement dropdown = driver.findElement(By.xpath("//input[@class='select-dropdown']"));
		dropdown.click();
		List<WebElement> options = dropdown.findElements(By.xpath("//form[@id='add_staff_form']//div[contains(@class,'my-card')]//div[@class='select-wrapper']//ul//li"));
		options.get(1).click();
		Thread.sleep(5000);
		Random randomGenerator = new Random();  
		int randomInt = randomGenerator.nextInt(1000);  
		driver.findElement(By.xpath("//input[@id='invite_phone']")).sendKeys("1111111"+randomInt);
		driver.findElement(By.xpath("//input[@id='invite_email']")).sendKeys("sree"+randomInt+"@srtest.com");
		WebElement customerType=driver.findElement(By.xpath("//input[@value='Choose gender']"));
		new WebDriverWait(driver, 15).until(
	            ExpectedConditions.elementToBeClickable(customerType));
		customerType.click();
		List<WebElement> gendertype = dropdown.findElements(By.xpath("//input[@value='Choose gender']//following-sibling::ul//li"));
		gendertype.get(2).click();
	//	driver.findElement(By.xpath("//input[@id='add_account']")).clear();
		WebElement element= driver.findElement(By.xpath("//input[@id='add_account']"));

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
			
	}
	public void emprole() {
	//driver.findElement(By.xpath("//input[@id='employee']//following-sibling::label")).click();
	WebElement label= driver.findElement(By.xpath("//input[@id='employee']//following-sibling::label"));
	JavascriptExecutor labelexecutor = (JavascriptExecutor) driver;
	labelexecutor.executeScript("arguments[0].click();", label);
	//driver.findElement(By.xpath("//a[contains(@class,'primary-button') and contains(text(),'Add')]")).click();
	WebElement add= driver.findElement(By.xpath("//a[contains(@class,'primary-button') and contains(text(),'Add')]"));
	JavascriptExecutor addexecutor = (JavascriptExecutor) driver;
	addexecutor.executeScript("arguments[0].click();", add);
	//driver.findElement(By.xpath("//div[@id='add_staff_modal']//a[contains(@class,'primary-button') and contains(text(),'Yes, Add')]")).click();
	
	WebElement element= driver.findElement(By.xpath("//div[@id='add_staff_modal']//a[contains(@class,'primary-button') and contains(text(),'Yes, Add')]"));
	JavascriptExecutor executor = (JavascriptExecutor) driver;
	executor.executeScript("arguments[0].click();", element);
	
}
	public void admin_role() {
		driver.findElement(By.xpath("//input[@id='admin']//following-sibling::label")).click();
		driver.findElement(By.xpath("//a[contains(@class,'primary-button') and contains(text(),'Add')]")).click();
		driver.findElement(By.xpath("//div[@id='add_staff_modal']//a[contains(@class,'primary-button') and contains(text(),'Yes, Add')]")).click();
		
	}

	public void existed_phone() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='invite_first_name']")).sendKeys("SreeTest");
		WebElement dropdown = driver.findElement(By.xpath("//input[@class='select-dropdown']"));
		dropdown.click();
		List<WebElement> options = dropdown.findElements(By.xpath("//form[@id='add_staff_form']//div[contains(@class,'my-card')]//div[@class='select-wrapper']//ul//li"));
		options.get(1).click();
		Thread.sleep(5000);
		Random randomGenerator = new Random();  
		int randomInt = randomGenerator.nextInt(1000);  
		driver.findElement(By.xpath("//input[@id='invite_phone']")).sendKeys("9000119770");
		
		driver.findElement(By.xpath("//input[@id='invite_email']")).sendKeys("sree"+randomInt+"@srtest.com");
		WebElement customerType=driver.findElement(By.xpath("//input[@value='Choose gender']"));
		new WebDriverWait(driver, 15).until(
	            ExpectedConditions.elementToBeClickable(customerType));
		customerType.click();
		List<WebElement> gendertype = dropdown.findElements(By.xpath("//input[@value='Choose gender']//following-sibling::ul//li"));
		gendertype.get(2).click();
	//	driver.findElement(By.xpath("//input[@id='add_account']")).clear();
		WebElement element= driver.findElement(By.xpath("//input[@id='add_account']"));

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);

	}
	
public void existed_email() throws InterruptedException {
	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//input[@id='invite_first_name']")).sendKeys("SreeTest");
		WebElement dropdown = driver.findElement(By.xpath("//input[@class='select-dropdown']"));
		dropdown.click();
		List<WebElement> options = dropdown.findElements(By.xpath("//form[@id='add_staff_form']//div[contains(@class,'my-card')]//div[@class='select-wrapper']//ul//li"));
		options.get(1).click();
		Thread.sleep(5000);
		Random randomGenerator = new Random();  
		int randomInt = randomGenerator.nextInt(1000);
		driver.findElement(By.xpath("//input[@id='invite_phone']")).sendKeys("1111111"+randomInt);
		  
		driver.findElement(By.xpath("//input[@id='invite_email']")).sendKeys("sridevi@zenwork.com");
		WebElement customerType=driver.findElement(By.xpath("//input[@value='Choose gender']"));
		new WebDriverWait(driver, 15).until(
	            ExpectedConditions.elementToBeClickable(customerType));
		customerType.click();
		List<WebElement> gendertype = dropdown.findElements(By.xpath("//input[@value='Choose gender']//following-sibling::ul//li"));
		gendertype.get(2).click();
	//	driver.findElement(By.xpath("//input[@id='add_account']")).clear();
		WebElement element= driver.findElement(By.xpath("//input[@id='add_account']"));

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);

	}
	
	public void phone_error() {
		
		System.out.print("Employee already existed ");
		
		
	}
public void email_error() {
		
		System.out.print("Employee already existed ");
		
		
	}
	
}


