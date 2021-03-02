package Fidentity_pages;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Common.Fid_base;
import edu.emory.mathcs.backport.java.util.Collections;

public class Locationmgmt extends Fid_base{
	int count;
	
		public void locationNav() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
   WebElement element =driver.findElement(By.xpath("//ul[@class='w-menu-two']//li//a[@data-tooltip='My Organisation']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().perform();
	//	driver.findElement(By.xpath("//div[@id='show_org']//div//span//a[contains(text(),'Billing Management')]")).click();
	//driver.findElement(By.xpath("//div[@id='show_org']//a[contains(text(),'Location Management')]")).click();
	WebElement element2 = driver.findElement(By.xpath("//div[@id='show_org']//a[contains(text(),'Location Management')]"));
		Actions actions2 = new Actions(driver);
		 actions2.moveToElement(element2).click(element2).build().perform();
		Thread.sleep(2000);
		//actions2.moveToElement(getListElements(element2)).click(getListElements(listItemName)).build().perform();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement edit= driver.findElement(By.xpath("//div[@class='table-responsive grid-table']//td//a[@title='Edit Location']"));
		JavascriptExecutor editexecutor = (JavascriptExecutor) driver;
		editexecutor.executeScript("arguments[0].click();", edit);
				 
		}
	public void edit_location() {
		 Random randomGenerator = new Random();  
		//	String randomstring = randomGenerator.toString();
		 int randomInt = randomGenerator.nextInt(1000);  
		driver.findElement(By.xpath("//form[@id='location_filter_form']/following-sibling::div//li//div//table[@id='loc-grid']//tbody//tr//td[@class='locations-actions']//a[@title='Edit Location']//i")).click();	
		//driver.findElement(By.xpath("//input[@name='branch_name' and @id='location_name']")).sendKeys(randomstring);
		driver.findElement(By.xpath("//input[@name='branch_name' and @id='location_name']")).clear();
		driver.findElement(By.xpath("//input[@name='branch_name' and @id='location_name']")).sendKeys("Location"+randomInt);
		driver.findElement(By.xpath("//input[@name='branch_location' and @id='location_address']")).clear();
		driver.findElement(By.xpath("//input[@name='branch_location' and @id='location_address']")).sendKeys("Hyderabad"+randomInt);
		driver.findElement(By.xpath("//input[@name='city' and @id='locality']")).clear();
		driver.findElement(By.xpath("//input[@name='city' and @id='locality']")).sendKeys("Hyderabad"+randomInt);
		driver.findElement(By.xpath("//input[@name='state' and @id='administrative_area_level_1']")).clear();
		driver.findElement(By.xpath("//input[@name='state' and @id='administrative_area_level_1']")).sendKeys("Telangana"+randomInt);
		driver.findElement(By.xpath("//input[@name='country' and @id='country']")).clear();
		driver.findElement(By.xpath("//input[@name='country' and @id='country']")).sendKeys("India"+randomInt);
	
	}
	
	public void update() {
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement update= driver.findElement(By.xpath("//div[@id='edit_location_modal']//a[contains(@class,'primary-button') and contains(text(),'Update')]"));
		JavascriptExecutor updateexecutor = (JavascriptExecutor) driver;
		updateexecutor.executeScript("arguments[0].click();", update);
		
		}
	
	public void editLocation_vaidations() throws IOException, InterruptedException{
		
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@name='branch_name' and @id='location_name']")).clear();
		 Random randomGenerator = new Random();  
			System.out.print("\n"+"location name given");
			 int randomInt = randomGenerator.nextInt(1000);  
		driver.findElement(By.xpath("//input[@name='branch_name' and @id='location_name']")).sendKeys("Test"+randomInt);
		driver.findElement(By.xpath("//input[@name='branch_location' and @id='location_address']")).clear();
		driver.findElement(By.xpath("//input[@name='city' and @id='locality']")).clear();
		 driver.findElement(By.xpath("//input[@name='state' and @id='administrative_area_level_1']")).clear();
		 driver.findElement(By.xpath("//input[@name='country' and @id='country']")).clear();	
		 driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			WebElement update= driver.findElement(By.xpath("//div[@id='edit_location_modal']//a[contains(@class,'primary-button') and contains(text(),'Update')]"));
			JavascriptExecutor updateexecutor = (JavascriptExecutor) driver;
			updateexecutor.executeScript("arguments[0].click();", update);
			Thread.sleep(3000);
			WebElement cancel= driver.findElement(By.xpath("//div[@id='edit_location_modal']//a[contains(@class,'reset-button') and contains(text(),'Cancel')]"));
			JavascriptExecutor cancelexecutor = (JavascriptExecutor) driver;
			cancelexecutor.executeScript("arguments[0].click();", cancel);
			System.out.print("Validation done for location name ");
			Thread.sleep(2000);
			
			System.out.print("\n"+"Location name,Location address given");
			WebElement edit= driver.findElement(By.xpath("//div[@class='table-responsive grid-table']//td//a[@title='Edit Location']"));
			JavascriptExecutor editexecutor = (JavascriptExecutor) driver;
			editexecutor.executeScript("arguments[0].click();", edit);		
			driver.findElement(By.xpath("//input[@name='branch_name' and @id='location_name']")).clear();
			driver.findElement(By.xpath("//input[@name='branch_name' and @id='location_name']")).sendKeys("Test location");
			driver.findElement(By.xpath("//input[@name='branch_location' and @id='location_address']")).clear();
			driver.findElement(By.xpath("//input[@name='branch_location' and @id='location_address']")).sendKeys("Test address");
			driver.findElement(By.xpath("//input[@name='city' and @id='locality']")).clear();
			 driver.findElement(By.xpath("//input[@name='state' and @id='administrative_area_level_1']")).clear();
			 driver.findElement(By.xpath("//input[@name='country' and @id='country']")).clear();	
			
			WebElement updateaddr= driver.findElement(By.xpath("//div[@id='edit_location_modal']//a[contains(@class,'primary-button') and contains(text(),'Update')]"));
			JavascriptExecutor addressexecutor = (JavascriptExecutor) driver;
			addressexecutor.executeScript("arguments[0].click();", updateaddr);
			Thread.sleep(3000);
			WebElement adresscancel= driver.findElement(By.xpath("//div[@id='edit_location_modal']//a[contains(@class,'reset-button') and contains(text(),'Cancel')]"));
			JavascriptExecutor addresscancelexe = (JavascriptExecutor) driver;
			addresscancelexe.executeScript("arguments[0].click();", adresscancel);
			System.out.print("Validation done for location address ");
			Thread.sleep(2000);
			WebElement editaddr= driver.findElement(By.xpath("//div[@class='table-responsive grid-table']//td//a[@title='Edit Location']"));
			JavascriptExecutor editadrrexecutor = (JavascriptExecutor) driver;
			editadrrexecutor.executeScript("arguments[0].click();", editaddr);
			
			System.out.print("\n"+"Location name,Location address,location city given");
			driver.findElement(By.xpath("//input[@name='branch_name' and @id='location_name']")).clear();
			driver.findElement(By.xpath("//input[@name='branch_name' and @id='location_name']")).sendKeys("Test location");
			driver.findElement(By.xpath("//input[@name='branch_location' and @id='location_address']")).clear();
			driver.findElement(By.xpath("//input[@name='branch_location' and @id='location_address']")).sendKeys("Test address");
			driver.findElement(By.xpath("//input[@name='city' and @id='locality']")).clear();
			driver.findElement(By.xpath("//input[@name='city' and @id='locality']")).sendKeys("Test city");
			driver.findElement(By.xpath("//input[@name='state' and @id='administrative_area_level_1']")).clear();
			 driver.findElement(By.xpath("//input[@name='country' and @id='country']")).clear();	
			
			WebElement updatecity= driver.findElement(By.xpath("//div[@id='edit_location_modal']//a[contains(@class,'primary-button') and contains(text(),'Update')]"));
			JavascriptExecutor cityexecutor = (JavascriptExecutor) driver;
			cityexecutor.executeScript("arguments[0].click();", updatecity);
			Thread.sleep(3000);
			WebElement citycancel= driver.findElement(By.xpath("//div[@id='edit_location_modal']//a[contains(@class,'reset-button') and contains(text(),'Cancel')]"));
			JavascriptExecutor citycancelexe = (JavascriptExecutor) driver;
			citycancelexe.executeScript("arguments[0].click();", citycancel);
			System.out.print("Validation done for city ");
			Thread.sleep(2000);
			
			WebElement editcity= driver.findElement(By.xpath("//div[@class='table-responsive grid-table']//td//a[@title='Edit Location']"));
			JavascriptExecutor editcityexe = (JavascriptExecutor) driver;
			editcityexe.executeScript("arguments[0].click();", editcity);			
		
			System.out.print("\n"+"Location name,Location address,location city,location state given");
			driver.findElement(By.xpath("//input[@name='branch_name' and @id='location_name']")).clear();
			driver.findElement(By.xpath("//input[@name='branch_name' and @id='location_name']")).sendKeys("Test location");
			driver.findElement(By.xpath("//input[@name='branch_location' and @id='location_address']")).clear();
			driver.findElement(By.xpath("//input[@name='branch_location' and @id='location_address']")).sendKeys("Test address");
			driver.findElement(By.xpath("//input[@name='city' and @id='locality']")).clear();
			driver.findElement(By.xpath("//input[@name='city' and @id='locality']")).sendKeys("Test city");
			 driver.findElement(By.xpath("//input[@name='state' and @id='administrative_area_level_1']")).clear();
			 driver.findElement(By.xpath("//input[@name='state' and @id='administrative_area_level_1']")).sendKeys("Telangana");
			 driver.findElement(By.xpath("//input[@name='country' and @id='country']")).clear();	
			 WebElement updatestate= driver.findElement(By.xpath("//div[@id='edit_location_modal']//a[contains(@class,'primary-button') and contains(text(),'Update')]"));
				JavascriptExecutor stateexecutor = (JavascriptExecutor) driver;
				stateexecutor.executeScript("arguments[0].click();", updatestate);
			Thread.sleep(3000);
			WebElement statecancel= driver.findElement(By.xpath("//div[@id='edit_location_modal']//a[contains(@class,'reset-button') and contains(text(),'Cancel')]"));
			JavascriptExecutor statecancelexe = (JavascriptExecutor) driver;
			statecancelexe.executeScript("arguments[0].click();", statecancel);
			System.out.print("Validation done for State ");
			Thread.sleep(2000);
			
			WebElement stateedit= driver.findElement(By.xpath("//div[@class='table-responsive grid-table']//td//a[@title='Edit Location']"));
			JavascriptExecutor statexe = (JavascriptExecutor) driver;
			statexe.executeScript("arguments[0].click();", stateedit);
			System.out.print("\n"+"Location name,Location address,location city,location state,country, given");
			driver.findElement(By.xpath("//input[@name='branch_name' and @id='location_name']")).clear();
			driver.findElement(By.xpath("//input[@name='branch_name' and @id='location_name']")).sendKeys("Test location");
			driver.findElement(By.xpath("//input[@name='branch_location' and @id='location_address']")).clear();
			driver.findElement(By.xpath("//input[@name='branch_location' and @id='location_address']")).sendKeys("Test address");
			driver.findElement(By.xpath("//input[@name='city' and @id='locality']")).clear();
			driver.findElement(By.xpath("//input[@name='city' and @id='locality']")).sendKeys("Test city");
			driver.findElement(By.xpath("//input[@name='state' and @id='administrative_area_level_1']")).clear();
			driver.findElement(By.xpath("//input[@name='state' and @id='administrative_area_level_1']")).sendKeys("Telangana");
			driver.findElement(By.xpath("//input[@name='country' and @id='country']")).clear();	
			driver.findElement(By.xpath("//input[@name='country' and @id='country']")).sendKeys("India");
			 WebElement updatecountry= driver.findElement(By.xpath("//div[@id='edit_location_modal']//a[contains(@class,'primary-button') and contains(text(),'Update')]"));
				JavascriptExecutor countryexecutor = (JavascriptExecutor) driver;
				countryexecutor.executeScript("arguments[0].click();", updatecountry);
				System.out.print("Validation done for country ");
				Thread.sleep(2000);
			
			
			
			
		
			
	/*	
		FileInputStream fis = new FileInputStream("E:\\eclipse-workspace\\Fidentity\\src\\test\\java\\passwordvalidations.xlsx");
		 XSSFWorkbook workbook = new XSSFWorkbook(fis);
		 XSSFSheet sheet = workbook.getSheetAt(1);
		 for (int i=1;i<=sheet.getLastRowNum();i++) {
				
				driver.findElement(By.xpath("//input[@name='branch_name' and @id='location_name']")).clear();
			//	System.out.println("\n"+"Location anme :"+sheet.getRow(i).getCell(0).getStringCellValue());
				String loname=sheet.getRow(i).getCell(0).getStringCellValue();
				if(isNullOrEmpty(loname)) {
					driver.findElement(By.xpath("//input[@name='branch_name' and @id='location_name']")).click();
				}else {driver.findElement(By.xpath("//input[@name='branch_name' and @id='location_name']")).sendKeys(sheet.getRow(i).getCell(0).getStringCellValue());}
			
				driver.findElement(By.xpath("//input[@name='branch_location' and @id='location_address']")).clear();
			//	System.out.println("\n"+"Branch location :"+sheet.getRow(i).getCell(1).getStringCellValue());
				String location=sheet.getRow(i).getCell(1).getStringCellValue();
				if(isNullOrEmpty(location)) {
					driver.findElement(By.xpath("//input[@name='branch_location' and @id='location_address']")).click();
				}else {driver.findElement(By.xpath("//input[@name='branch_location' and @id='location_address']")).sendKeys(sheet.getRow(i).getCell(1).getStringCellValue());}
			 			
				
				 driver.findElement(By.xpath("//input[@name='city' and @id='locality']")).clear();
			// System.out.println("\n"+"City:"+sheet.getRow(i).getCell(2).getStringCellValue());
			 String city=sheet.getRow(i).getCell(2).getStringCellValue();
			 if(isNullOrEmpty(city)) {
				 driver.findElement(By.xpath("//input[@name='city' and @id='locality']")).click();
				}else { driver.findElement(By.xpath("//input[@name='city' and @id='locality']")).sendKeys(sheet.getRow(i).getCell(2).getStringCellValue());}
			
			 driver.findElement(By.xpath("//input[@name='state' and @id='administrative_area_level_1']")).clear();
			//  System.out.println("\n"+"State:"+sheet.getRow(i).getCell(2).getStringCellValue());
			  String state=sheet.getRow(i).getCell(2).getStringCellValue();
			  if(isNullOrEmpty(state))  {
					 driver.findElement(By.xpath("//input[@name='state' and @id='administrative_area_level_1']")).click();
					}else { driver.findElement(By.xpath("//input[@name='state' and @id='administrative_area_level_1']")).sendKeys(sheet.getRow(i).getCell(3).getStringCellValue());}
			
			  driver.findElement(By.xpath("//input[@name='country' and @id='country']")).clear();		
		//	 System.out.println("\n"+"Country:"+sheet.getRow(i).getCell(2).getStringCellValue());
			String country=sheet.getRow(i).getCell(2).getStringCellValue();
			  if(isNullOrEmpty(country)) {
				 driver.findElement(By.xpath("//input[@name='country' and @id='country']")).click();
				}else { driver.findElement(By.xpath("//input[@name='country' and @id='country']")).sendKeys(sheet.getRow(i).getCell(4).getStringCellValue());}
			 
			
			 Thread.sleep(3000);
			 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				WebElement update= driver.findElement(By.xpath("//div[@id='edit_location_modal']//a[contains(@class,'primary-button') and contains(text(),'Update')]"));
				JavascriptExecutor updateexecutor = (JavascriptExecutor) driver;
				updateexecutor.executeScript("arguments[0].click();", update);
				Thread.sleep(1000);
				WebElement cancel= driver.findElement(By.xpath("//div[@id='edit_location_modal']//a[contains(@class,'reset-button') and contains(text(),'Cancel')]"));
				JavascriptExecutor cancelexecutor = (JavascriptExecutor) driver;
				cancelexecutor.executeScript("arguments[0].click();", cancel);
				WebElement edit= driver.findElement(By.xpath("//div[@class='table-responsive grid-table']//td//a[@title='Edit Location']"));
				JavascriptExecutor editexecutor = (JavascriptExecutor) driver;
				editexecutor.executeScript("arguments[0].click();", edit);
				
		}*/
		
		
	}
	public static boolean isNullOrEmpty(String str) {
        if(str != null && !str.isEmpty())
            return false;
        return true;
    }
	
	public void locations_count() {
		
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		
		 List <WebElement> rows =  driver.findElements(By.xpath("//div[@class='card my-card']//li//table[@id='loc-grid']"));

		 
	count=rows.size();
	     
	       System.out.println("Number of locations "+count);
	    
	 
	      WebElement location=driver.findElement(By.xpath("//form[@id='location_filter_form']/following-sibling::div//li//div//table[@id='loc-grid']//tbody//tr//td[1]//span"));
			   	WebElement locname=driver.findElement(By.xpath("//form[@id='location_filter_form']/following-sibling::div//li//div//table[@id='loc-grid']//tbody//tr//td[1]//span/following-sibling::span"));
			  			
			  WebElement Statustxt=driver.findElement(By.xpath("//form[@id='location_filter_form']/following-sibling::div//li//div//table[@id='loc-grid']//tbody//tr//td[9]/span[contains(text(),'Status')]"));
			  WebElement	status=driver.findElement(By.xpath("//form[@id='location_filter_form']/following-sibling::div//li//div//table[@id='loc-grid']//tbody//tr//td[9]//span[contains(text(),'Status')]/following-sibling::span"));
			System.out.println(location.getText()+" "+locname.getText()+" "+Statustxt.getText()+" "+status.getText());
			
			//List<WebElement> allProducts = driver.findElements(By.xpath("//*[@id='endecaResultsWrapper']/div[3]"));
		    Random rand = new Random();
		    int randomrow = rand.nextInt(rows.size());
		    System.out.print("/n"+rows.get(randomrow).getText());	
		    boolean rowstatus=rows.get(randomrow).getText().startsWith("active");
		   if(rowstatus==true) {
		    System.out.println("raow status is active");}else {System.out.println("/n"+"Random row status is active");}
		System.out.print("row number is:"+randomrow);
		   		
		  // 	String dataroIndex=driver.findElement(By.xpath("//form[@id='location_filter_form']/following-sibling::div//li[6]//div//table[@id='loc-grid']//tbody//tr//td[9]//span[contains(text(),'Status')]/following-sibling::span[contains(text(),'active')]")).getAttribute("tr[randomrow]");
		//		System.out.print("row number is:"+dataroIndex);
					
	  			
	}
		
	public void active_locations() {
		int flag=0;
	//	WebElement	status=driver.findElement(By.xpath("//form[@id='location_filter_form']/following-sibling::div//li//div//table[@id='loc-grid']//tbody//tr//td[9]//span[contains(text(),'Status')]/following-sibling::span"));
		//List <WebElement> rows =  driver.findElements(By.xpath("//div[@class='card my-card']//li//table[@id='loc-grid']"));

		 
		

	    List <WebElement> allvalue = driver.findElements(By.xpath("//div[@class='card my-card']//li//table//tr//td[6]//span[2]"));
	    // for printing everything in the table
	  
	    for(int i =0;i<allvalue.size();i++){
	     //  System.out.println("Status of location are : " + allvalue.get(i).getText());
	      
	       if(allvalue.get(i).getText().equals("active")) {
	    	  
	             flag++;
	             System.out.println("active employee : "+flag);
	       }
	           
	      
	    if(flag>1) {
	    		    	   	
	    	driver.findElement(By.xpath("//div[@class='card my-card']//l[i]//table//tr//td[6]//span[2]")).click();
	    	break;
	    }
	    }
	}
	public void delete_location() {
		int flag=0;
	//	WebElement	status=driver.findElement(By.xpath("//form[@id='location_filter_form']/following-sibling::div//li//div//table[@id='loc-grid']//tbody//tr//td[9]//span[contains(text(),'Status')]/following-sibling::span"));
		//List <WebElement> rows =  driver.findElements(By.xpath("//div[@class='card my-card']//li//table[@id='loc-grid']"));

		 
		

	    List <WebElement> allvalue = driver.findElements(By.xpath("//form[@id='location_filter_form']/following-sibling::div//li//div//table[@id='loc-grid']//tbody//tr//td[9]//span[contains(text(),'Status')]/following-sibling::span"));
	    // for printing everything in the table
	  
	    for(int i =0;i<allvalue.size();i++){
	     //  System.out.println("Status of location are : " + allvalue.get(i).getText());
	      
	       if(allvalue.get(i).getText().equals("active")) {
	    	  
	             flag++;
	             System.out.println("active locations : "+flag);
	       }
	       
	      
	    }
	    
	    if(flag>1) {
	    	
	    	System.out.print("One location can be delete");
	    	
	    	driver.findElement(By.xpath("//form[@id='location_filter_form']/following-sibling::div//li//div//table[@id='loc-grid']//tbody//tr//td[@class='locations-actions']//a[@title='Deactivate Location']//i")).click();
	    	driver.findElement(By.xpath("//div[@id='deactivate_location_modal']//div//a[@class='delete-button']")).click();
	    	driver.findElement(By.xpath("//form[@id='location_filter_form']/following-sibling::div//li//div//table[@id='loc-grid']//tbody//tr//td[@class='locations-actions']//a[@title='Delete Location']//i")).click();
	    	
	    }else{System.out.print("location cannot be deleted");}
	    
	}	

}
	 /*   Set<WebElement> distinct=new HashSet<>(allvalue);
	    for(WebElement s:distinct) {
	    	 System.out.println("active locations : "+" "+s + Collections.frequency(allvalue, s));
	    }
	  */
	 
	    
	 //   List<WebElement> elements = driver.findElements(By.xpath("//*[text()]"));
	    
		
	    
	

	
	
	
     
/*	public void CheckActieloc() {
		
		
		   WebElement table =driver.findElement(By.xpath("//form[@id='location_filter_form']/following-sibling::div//li//div//table[@id='loc-grid']"));
		   WebElement tbody=table.findElement(By.tagName("tbody"));
		   List<WebElement> rows=tbody.findElements(By.tagName("tr"));
		   ArrayList<String> ListOdIds=new ArrayList<>();
		   String rowNo="";
		   for(int i=0;i<rows.size();i++)
		   {
		     WebElement row = tbody.findElement(By.xpath("//table[@id='tableId']/tbody/tr["+(i+1)+"]"));
		     if(row.getText().trim().contains(value))
		     {
		        rowNo=Integer.toString(i+1); 
		            break;
		     }

		   }

	//	   return rowNo;
		}
		
	
}*/
	
	
	
	
	    	  
	    	   
		
			
	
	
	
	


