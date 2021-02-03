package Fidentity_pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Common.Fid_base;
import Object_repo.EventsRepo;
import Object_repo.OnlocationRepo;

public class Onlocation extends Fid_base {
	public static final Logger log = LogManager.getLogger(Packagedelivery.class);

	
	public void onlocation_nav() {
	
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
	
	PageFactory.initElements(driver, OnlocationRepo.class);
	//WebElement element= driver.findElement(By.xpath("//div[@class='side-wrapper']//ul[1]//li[@id='service_vms_parent']//a"));

	JavascriptExecutor productsiconexe = (JavascriptExecutor) driver;
	productsiconexe.executeScript("arguments[0].click();", OnlocationRepo.productsicon);
	JavascriptExecutor vmsmenuexe = (JavascriptExecutor) driver;
	vmsmenuexe.executeScript("arguments[0].click();", OnlocationRepo.VMSmenu);
	JavascriptExecutor onlocationmenuexe = (JavascriptExecutor) driver;
	onlocationmenuexe.executeScript("arguments[0].click();", OnlocationRepo.ONlocationmenu);
	
	
	
	/*	
	
	 WebElement we = driver.findElement(By.xpath("//div[@id='service_features']//div//span[1]//a[contains(text(),'On-Location')]"));
	 JavascriptExecutor passexecutor = (JavascriptExecutor) driver;
	 passexecutor.executeScript("arguments[0].click();", we);
	 
		System.out.print("\n"+"Visitor pass clicked");  */

}
	
	public void checked_in() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		String checkedin_count=driver.findElement(By.xpath("//div//h1[contains(text(),'Currently Checked-In')]//b")).getText();
		
		
		if(checkedin_count.equals("0")) {
			
			System.out.print("\n"+"There are no checked in records");
		}else {System.out.print("\n"+"Number of visitors who are already checked in: "+checkedin_count);}
	
	}
	
	public void select_checkedin() {
		
String checkedin_count=driver.findElement(By.xpath("//div//h1[contains(text(),'Currently Checked-In')]//b")).getText();
		
		
		if(checkedin_count.equals("0")) {
			
			System.out.print("\n"+"There are no checked in records for checkout");
		}else {
		
		 WebElement select = driver.findElement(By.xpath("//table[contains(@class,'responsive-table' )]//tbody//tr"));
		 JavascriptExecutor selectexecutor = (JavascriptExecutor) driver;
		 selectexecutor.executeScript("arguments[0].click();", select);}
		
	}
	public void checked_out() {
		
List<WebElement> checkedout_icon=driver.findElements(By.xpath("//table//tbody//tr//a[contains(@id,'locate_grid_checkout')]"));
int onlocationrecords=	checkedout_icon.size();
log.info("\n"+"Number of records are: "+onlocationrecords);

if(onlocationrecords>=0) {
	
	log.info("\n"+"Number of records are more than 1.");
	for(int i=0;i<=onlocationrecords;i++) {
		WebElement firstrecord=driver.findElement(By.xpath("//table//tbody//tr['+i+']//a[contains(@id,'locate_grid_checkout')]"));
JavascriptExecutor checkedoutexe = (JavascriptExecutor) driver;
		 checkedoutexe.executeScript("arguments[0].click();", firstrecord);
		 //log.info()
		break; 
	}}
else {
			 log.info("\n"+"There are no records in onlocation list.");
		 }
	/*	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
String checkedin_count=driver.findElement(By.xpath("//div//h1[contains(text(),'Currently Checked-In')]//b")).getText();
		
		
		if(checkedin_count.equals("0")) {
			
			System.out.print("\n"+"There are no checked in records to check out");
		}else {
		
		 WebElement checkout = driver.findElement(By.xpath("//a[@class='primary-button' and contains(text(),'Checkout')]"));
		 JavascriptExecutor checkoutexecutor = (JavascriptExecutor) driver;
		 checkoutexecutor.executeScript("arguments[0].click();", checkout);
		
		}
		 */
	}
//	public void confirm_checkout() {}
	
	public void cancel_checkout() {
		
		
		boolean checkoutmodalvisible=OnlocationRepo.checkoutmodal.isDisplayed();
		if(checkoutmodalvisible==true) {
			
			JavascriptExecutor cancelexe=(JavascriptExecutor) driver;
			cancelexe.executeScript("arguments[0].click();",OnlocationRepo.cancelcheckout);
			log.info("\n"+"Visitor checked out cancelled successfully");
		}
		else {log.info("\n"+"checked out modal not displayed");}
	/*	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
String checkedin_count=driver.findElement(By.xpath("//div//h1[contains(text(),'Currently Checked-In')]//b")).getText();
		
		
		if(checkedin_count.equals("0")) {
			
			System.out.print("\n"+"There are no checked in records");
		}else {
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 WebElement checkoutcancel = driver.findElement(By.xpath("//div[@id='checkoutModal']//a[contains(@class,'reset-button') and contains(text(),'No, Cancel')]"));
		 JavascriptExecutor cancelexecutor = (JavascriptExecutor) driver;
		 cancelexecutor.executeScript("arguments[0].click();", checkoutcancel);
	}*/}
	public void add_watchlist() throws InterruptedException {
		
		List<WebElement> addwathclisticon=driver.findElements(By.xpath("//table//tbody//tr//a[contains(@id,'locate_grid_editWatchlist')]"));
		int onlocationrecords=	addwathclisticon.size();
		log.info("\n"+"Number of records are: "+onlocationrecords);

		if(onlocationrecords>=0) {
			
			log.info("\n"+"Number of records are more than 1.");
			WebElement firstrecord=driver.findElement(By.xpath("//table//tbody//tr['+i+']//a[contains(@id,'locate_grid_editWatchlist')]"));
			boolean addwatchlisticondisplay=firstrecord.isDisplayed();
			log.info("\n"+"acc watch list icon is displaying:"+addwatchlisticondisplay);
			
			if (addwatchlisticondisplay==true) {
			for(int i=1;i<=onlocationrecords;i++) {
				Thread.sleep(3000);
		JavascriptExecutor addwathlistexe = (JavascriptExecutor) driver;
		addwathlistexe.executeScript("arguments[0].click();", firstrecord);
				 log.info("\n"+"Clicked on add waitch list icon");
				break; 
			}}else{log.info("\n"+"there are no watch list available to add visitor.");}}
		else {
					 log.info("\n"+"There are no records in onlocation list.");
				 }
		
	}
	public void select_watchlist() throws InterruptedException {
		
		boolean watclistmodaldisplay=OnlocationRepo.watchlistchangemodal.isDisplayed();
		if(watclistmodaldisplay==true) {
			log.info("\n"+"Add watchlist modal is displayed");
			Thread.sleep(3000);
		//	driver.navigate().refresh();
			
			int i=1;
			Select  watchlistdropdown=new Select(driver.findElement(By.id("onLocation_watchlist_dropdown")));
			watchlistdropdown.selectByIndex(i);
			List options=watchlistdropdown.getOptions();
			int size=options.size();
			log.info("\n"+"number of watchlists:"+size);
			log.info("\n"+"i index watchlist got selected ");
			Thread.sleep(3000);
			JavascriptExecutor addwathlistexe = (JavascriptExecutor) driver;
			addwathlistexe.executeScript("arguments[0].click();", OnlocationRepo.updatewatchlistvisitor);
		
			
		}else {log.info("\n"+"Add watchlist modal is not displayed");}
		
	}
	
	public void confirm_checkout() {
		
		boolean checkoutmodalvisible=OnlocationRepo.checkoutmodal.isDisplayed();
		if(checkoutmodalvisible==true) {
			
			JavascriptExecutor cnfirmexe=(JavascriptExecutor) driver;
			cnfirmexe.executeScript("arguments[0].click();",OnlocationRepo.confirmcheckout);
			log.info("\n"+"Visitor checked out successfully");
		}
		else {log.info("\n"+"checked out modal not displayed");}
		/*
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String checkedin_count=driver.findElement(By.xpath("//div//h1[contains(text(),'Currently Checked-In')]//b")).getText();
				
				
				if(checkedin_count.equals("0")) {
					
					System.out.print("\n"+"There are no checked in records for the confirmation");
				}else {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		 WebElement checkoutconfirm = driver.findElement(By.xpath("//div[@id='checkoutModal']//a[@class='primary-button' and contains(text(),'Yes, Checkout')]"));
		 JavascriptExecutor confirmexecutor = (JavascriptExecutor) driver;
		 confirmexecutor.executeScript("arguments[0].click();", checkoutconfirm);
		 
				}*/
	}

	public void cancel_successful() {
	
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
String checkedin_count=driver.findElement(By.xpath("//div//h1[contains(text(),'Currently Checked-In')]//b")).getText();
		
		
		if(checkedin_count.equals("0")) {
			
			System.out.print("There are no checked in records");
		}else {
		
		System.out.print("\n"+"Checked out cancelled successfully,count of records are  "+checkedin_count);}
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
			
			System.out.print("\n"+"There are no checked in records");
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


