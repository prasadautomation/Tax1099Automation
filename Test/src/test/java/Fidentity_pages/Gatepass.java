package Fidentity_pages;

import java.awt.AWTException;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Common.Fid_base;
import cucumber.api.java.it.Date;

public class Gatepass extends Fid_base {
	
	public void visitorPassMenu() throws InterruptedException, AWTException {
		
		//driver.findElement(By.xpath("//li[@id='service_vms_parent']//a//i")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		WebElement element= driver.findElement(By.xpath("//div[@class='side-wrapper']//ul[1]//li[@id='service_vms_parent']//a"));

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		
		
		System.out.print("visitors menu clicked");
		
	
		
		 WebElement we = driver.findElement(By.xpath("//div[@id='service_features']//div//span[2]//a[contains(text(),'Visitor Pass')]"));
		 JavascriptExecutor passexecutor = (JavascriptExecutor) driver;
		 passexecutor.executeScript("arguments[0].click();", we);
		 
			System.out.print("Visitor pass clicked");  
    
		 	
	
		
	}
	
	public void gatepassFields() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		  driver.findElement(By.xpath("//form[@id='generate_gatepss_form']//div//div[1]//input[@id='invite_email']")).sendKeys("sridevi456@zenwork.com");
		
		//driver.findElement(By.xpath("//form[@id='generate_gatepss_form']//input[@value='USA (+1)']")).click();
		
		
		java.util.List<WebElement> allOptions = driver.findElements(By.xpath("//input[@class='select-dropdown']//following-sibling::ul"));
		       
		for(WebElement item:allOptions) 
		{ 
				     
		     String country=item.getText();
		     if(country.contains("India")) {
		    	 driver.findElement(By.xpath("//li//span[contains(text(),'India')]")).click();
		    	  System.out.println("India got selected");
		     }
		}
		
		driver.findElement(By.xpath("//input[@id='invite_name']")).sendKeys("Alexa");
	//	driver.findElement(By.xpath("//form[@id='generate_gatepss_form']//input[@value='Visitor Type']")).click();
		
		 WebElement visitortype = driver.findElement(By.xpath("//form[@id='generate_gatepss_form']//input[@value='Visitor Type']"));
		 JavascriptExecutor typeexecutor = (JavascriptExecutor) driver;
		 typeexecutor.executeScript("arguments[0].click();", visitortype);
		
		//Select visitortype= new Select(driver.findElement(By.xpath("//form[@id='generate_gatepss_form']//div//select[@id='checkin_type']")));
		//visitortype.selectByVisibleText("Other");
	//	driver.findElement(By.xpath("//input[@value='Visitor Type']//following-sibling::ul//li//span[contains(text(),'Other')]")).click();
		
		WebElement Other = driver.findElement(By.xpath("//input[@value='Visitor Type']//following-sibling::ul//li//span[contains(text(),'Other')]"));
		 JavascriptExecutor Othertypeexecutor = (JavascriptExecutor) driver;
		 Othertypeexecutor.executeScript("arguments[0].click();", Other);
		
		driver.findElement(By.xpath("//input[@id='invite_coming_from']")).sendKeys("Test business");
		 Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
		java.util.Date date = calendar.getTime();
	      int day = calendar.get(Calendar.DATE);
	     int tomorrow=day+1;
	      System.out.print("today is :"+day);
	      
		driver.findElement(By.xpath("//input[@id='invite_date']")).click();
		
		driver.findElement(By.xpath("//div[@class='picker__footer']//button[contains(text(),'Today')]")).click();
		driver.findElement(By.xpath("//div[@class='picker__footer']//button[contains(text(),'Ok')]")).click();
		
		//driver.findElement(By.xpath("//div//input[@id='invite_time']")).click();
		
		 WebElement we = driver.findElement(By.xpath("//div//input[@id='invite_time']"));
		 JavascriptExecutor passexecutor = (JavascriptExecutor) driver;
		 passexecutor.executeScript("arguments[0].click();", we);
		
		driver.findElement(By.xpath("//div[@class='clockpicker-tick' and contains(text(),'18')]")).click();
		driver.findElement(By.xpath("//div[@class='clockpicker-tick' and contains(text(),'30')]")).click();
		
		 Thread.sleep(3000);
		 WebElement generate = driver.findElement(By.xpath("//a[@class='primary-button' and contains(text(),'Generate')]"));
		 JavascriptExecutor genearteexecutor = (JavascriptExecutor) driver;
		
		 genearteexecutor.executeScript("arguments[0].click();", generate);
		
	/*	 WebElement dateWidgetFrom = driver.findElement(By.xpath("//table[@id='invite_date_table']//tbody"));
		 
			List<WebElement> allDates=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td//div"));
			
			for(WebElement ele:allDates)
			{
				
				System.out.println("/n"+"Selected date is --"+ele);
				String selecteddate=ele.getText();
				
				if(selecteddate.equals(tomorrow))
				{
					System.out.println("/n"+"Selected date is if loop --"+ele);
					ele.click();
					break;
				}
				
			}
		*/
		
		//driver.findElement(By.xpath("//div[@class='picker__footer']//button[contains(text(),'OK')]")).click();
	}
	
	
	
	public void Unused_gatepass() throws InterruptedException {
		int flag=0;
		    List <WebElement> allvalue = driver.findElements(By.xpath("//div[@class='container-fluid']//div[@class='card my-card']//li//table//tbody//tr//td[5]//span[2]"));
	    // for printing everything in the table
	  
	    for(int i =0;i<allvalue.size();i++){
	     //  System.out.println("Status of location are : " + allvalue.get(i).getText());
	      
	       if(allvalue.get(i).getText().equals("unused")) {
	    	  
	             flag++;
	            
	       }
	       
	      
	    }
	    System.out.println("/n"+"Unused locations : "+flag);
	    
	    if(flag>=1) {
	    WebElement firstrow =   driver.findElement(By.xpath("//div[@class='container-fluid']//div[@class='card my-card']//li//table//tbody//tr[1]"));
		 JavascriptExecutor firstrowclick = (JavascriptExecutor) driver;
		
		 firstrowclick.executeScript("arguments[0].click();", firstrow);
		 
		 Thread.sleep(3000);}
	    else {
		    	System.out.println("There are no unused passes");
		    }
	}
		 public void resend_gatepass() {
		 
		  WebElement resend=driver.findElement(By.xpath("//a[@class='primary-button' and contains(text(),'Resend')]"));
		  JavascriptExecutor resendexecutorwclick = (JavascriptExecutor) driver;
			
		  resendexecutorwclick.executeScript("arguments[0].click();", resend);
	    
	   
	    WebElement sendconfirm= driver.findElement(By.xpath("//div[@id='resend_pass_modal']//a[@class='primary-button' and contains(text(),'Yes, Send')]"));
		  JavascriptExecutor resendexecutor = (JavascriptExecutor) driver;
		  resendexecutor.executeScript("arguments[0].click();", sendconfirm);
	
}
		public void delete_gatepass() throws InterruptedException {
			
			/*List<WebElement> elements = driver.findElements(By.xpath("//div[@class='container-fluid']//div[@class='card my-card']//li//table//tbody//tr//td[5]//span[2]"));
			for(int i =0;i<elements.size();i++){
			     //  System.out.println("Status of location are : " + allvalue.get(i).getText());
			      
			       if(elements.get(i).getText().equals("unused")) {
			    	  Thread.sleep(2000);
			    	   driver.findElement(By.xpath("//div[@class='container-fluid']//div[@class='card my-card']//li[i]")).click();
			    	   System.out.print("/n"+"unused row clciked"+"/n");
			    	   break;
			            
			       }
			       
			      
			    }
			*/
			
			
			int flag=0;
		    List <WebElement> allvalue = driver.findElements(By.xpath("//div[@class='container-fluid']//div[@class='card my-card']//li//table//tbody//tr//td[5]//span[2]"));
	    // for printing everything in the table
	  
	    for(int i =0;i<allvalue.size();i++){
	   
	        if(allvalue.get(i).getText().equals("unused")) {
	    	  
	             flag++;
	                   }
	       	      
	    }
	    System.out.println("/n"+"Unused locations : "+flag);
	    
	    if(flag>=1) {
	    WebElement firstrow =   driver.findElement(By.xpath("//div[@class='container-fluid']//div[@class='card my-card']//li//table//tbody//tr[1]"));
		 JavascriptExecutor firstrowclick = (JavascriptExecutor) driver;
		
		 firstrowclick.executeScript("arguments[0].click();", firstrow);
		 
		 Thread.sleep(3000);
		 
		 WebElement deletepass= driver.findElement(By.xpath("//a[@class='reset-button' and contains(text(),'Delete')]"));
		  JavascriptExecutor deleteexecutor = (JavascriptExecutor) driver;
		  deleteexecutor.executeScript("arguments[0].click();", deletepass);
		  Thread.sleep(3000);
		  WebElement deleteconfirm= driver.findElement(By.xpath("//div[@id='delete_pass_modal']//a[@class='delete-button' and contains(text(),'Yes, Delete')]"));
		  JavascriptExecutor deleteconfirmexecutor = (JavascriptExecutor) driver;
		  deleteconfirmexecutor.executeScript("arguments[0].click();", deleteconfirm);
		  
	    }
	    else {
		    	System.out.println("There are no unused passes");
		    }
	}
			
		
			
		}
		 



