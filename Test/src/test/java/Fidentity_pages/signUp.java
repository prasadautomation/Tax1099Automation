package Fidentity_pages;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


import Common.Fid_base;

public class signUp extends Fid_base{
	
	public void requierd_fields() throws InterruptedException, IOException {
	
		
		driver.manage().window().maximize();
		
		/*driver.findElement(By.xpath("//header[@class='main_menu_area']//child::button[contains(text(),'Sign Up')]")).click();
		
		
		System.out.print("sign up clicked");
		we are not click in the sign up button because this sign up main page not created in testing portal we 
		are using prod site so for testing directly goint to the onboard page
		*/
				Thread.sleep(1000);
		
		driver.manage().deleteAllCookies();
		Thread.sleep(1000);
		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);	
		driver.findElement(By.xpath("//input[@id='person_name']")).clear();
		
		driver.findElement(By.xpath("//input[@id='person_name']")).sendKeys("Sridevi Maddipati");	
		 Random randomGenerator = new Random();  
		int randomInt = randomGenerator.nextInt(1000);  
		//emailTextBx.sendKeys("username"+ randomInt +"@gmail.com");
		
		driver.findElement(By.xpath("//input[@id='person_email']")).sendKeys("sridevi"+randomInt+"@srtest.com");

	//	driver.findElement(By.xpath("//input[@id='person_email']")).sendKeys("sridevi@zenwork.com");
	
		driver.findElement(By.xpath("//div[@class='selected-flag']")).click();
			
	
		java.util.List<WebElement> allOptions = driver.findElements(By.xpath("//ul[@id='country-listbox']"));

	       
for(WebElement item:allOptions) 
{ 
	//System.out.println("Dropdown values are "+ item.getSize()+""+item.getText());
     
     String country=item.getText();
     if(country.contains("India")) {
    	 driver.findElement(By.xpath("//li[@id='iti-item-in']")).click();
    	  System.out.println("India got selected");
     }
}

driver.findElement(By.xpath("//input[@id='person_phone']")).clear();
driver.findElement(By.xpath("//input[@id='person_phone']")).sendKeys("9000119770");
driver.findElement(By.xpath("//input[@id='company_name']")).sendKeys("zenwork");
driver.findElement(By.xpath("//input[@id='company_web_site']")).sendKeys("zenwork");
driver.findElement(By.xpath("//a[@id='signup_button']")).click();


//Signup done customer will be created need to add sub domain

 
driver.findElement(By.xpath("//input[@id='subdomain_name']")).sendKeys("s"+randomInt);
driver.findElement(By.xpath("//span[@class='check-availability']")).click();
driver.findElement(By.xpath("//a[@class='start-trail' and @id='save_domain_button']//span")).click();


//Almost done should be added location details
	

	
driver.findElement(By.xpath("//input[@id='branch_name']")).sendKeys("Test");
driver.findElement(By.xpath("//input[@id='branch_location']")).sendKeys("Hyderabad");
driver.findElement(By.xpath("//input[@id='locality']")).sendKeys("Hyderabad");
driver.findElement(By.xpath("//input[@name='state']")).sendKeys("Telangana");
driver.findElement(By.xpath("//input[@id='country']")).sendKeys("India");
Select timezone=new Select(driver.findElement(By.xpath("//select[@id='utc_timezone']")));
timezone.selectByValue("5:30");

// driver.findElement(By.xpath("//span[contains(text(),'Save')]")).click();
Thread.sleep(5000);

driver.findElement(By.xpath("//div[@class='file-field form-fields']")).click();
Thread.sleep(2000);

Runtime.getRuntime().exec("C:\\Users\\Sridevi\\Desktop\\test.exe");

driver.findElement(By.xpath("//span[contains(text(),'Save')]")).click();

Thread.sleep(2000);
//driver.findElement(By.xpath("//button[@id='signup_button']")).click();

System.out.println("Customer created successfully");

//button[@id='signup_button']






}
	


	}
	
	

