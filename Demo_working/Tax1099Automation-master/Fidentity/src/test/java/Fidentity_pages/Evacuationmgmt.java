package Fidentity_pages;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;
import Common.Fid_base;
import Object_repo.Empactionsrepo;
import Object_repo.EvacuationmgmtRepo;
import Object_repo.Signuprepo;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
//import net.lightbody.bmp.proxy.jetty.html.Select;


public class Evacuationmgmt extends Fid_base{
	
	public void evacuation_nav() { 
		
		PageFactory.initElements(driver,EvacuationmgmtRepo.class);
	//	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	//	EvacuationmgmtRepo.settingsidemenu.click();
		
	//	JavascriptExecutor settingsiconexe = (JavascriptExecutor) driver;
		//settingsiconexe.executeScript("arguments[0].click();", EvacuationmgmtRepo.Settingsicon);
	//	JavascriptExecutor settingsiconexe = (JavascriptExecutor) driver;
	//	settingsiconexe.executeScript("arguments[0].click();",EvacuationmgmtRepo.settingsidemenu);
		JavascriptExecutor evacuationmenuexe = (JavascriptExecutor) driver;
		evacuationmenuexe.executeScript("arguments[0].click();", EvacuationmgmtRepo.evacuationmenu);
	}
	
	public void evacuation_save() {
		
		
		JavascriptExecutor evacutaionsave=(JavascriptExecutor) driver;
		evacutaionsave.executeScript("arguments[0].click();",EvacuationmgmtRepo.newevacuationsave);
			
	}
	public void create_first_notification_button() throws InterruptedException {
		
		JavascriptExecutor createevacutaionexe=(JavascriptExecutor) driver;
		createevacutaionexe.executeScript("arguments[0].click();",EvacuationmgmtRepo.evacuationcreate);
	Thread.sleep(2000);
	JavascriptExecutor newevacuationsaveexe=(JavascriptExecutor) driver;
	newevacuationsaveexe.executeScript("arguments[0].click();",EvacuationmgmtRepo.evacutionnextnotification);
	
	}
	
	
	public void Required_details_Create_notification() throws InterruptedException {
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		
		PageFactory.initElements(driver,EvacuationmgmtRepo.class);
		Evacuationmgmt evacuation=new Evacuationmgmt();
		EvacuationmgmtRepo.emergencytype.sendKeys("Fire emergency");
		EvacuationmgmtRepo.notificationdesc.sendKeys("Everyone should exit from premises");
		evacuation.evacuation_save();
		
}

	public void create_next_notification_button() {
		
		JavascriptExecutor createevacutaionexe=(JavascriptExecutor) driver;
		createevacutaionexe.executeScript("arguments[0].click();",EvacuationmgmtRepo.evacutionnextnotification);
		
	}
	
	public void create_button() throws InterruptedException {
		
		
		JavascriptExecutor createevacutaionexe=(JavascriptExecutor) driver;
		createevacutaionexe.executeScript("arguments[0].click();",EvacuationmgmtRepo.evacuationcreate);
		Thread.sleep(2000);
	}
	
	public void import_evacuation_notification() throws InterruptedException {
		
		JavascriptExecutor createevacutaionexe=(JavascriptExecutor) driver;
		createevacutaionexe.executeScript("arguments[0].click();",EvacuationmgmtRepo.evacuationcreate);
		Thread.sleep(2000);
		JavascriptExecutor evacuationimportexe=(JavascriptExecutor) driver;
		evacuationimportexe.executeScript("arguments[0].click();",EvacuationmgmtRepo.noalertsevacutionimportnotification);
		System.out.print("\n"+"import notifications button clicked");
		Thread.sleep(3000);
		
	} 
	
	public void select_location_for_import_notification() throws ClassNotFoundException, SQLException {
		
		/*WebDriverWait wait = new WebDriverWait(driver, 10);
	    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(EvacuationmgmtRepo.importalertmodel)); 
		System.out.print("\n"+"can import notifications");*/
		
		boolean evacuationimportmodel= EvacuationmgmtRepo.importalertmodeldropdown.isDisplayed();
		if(evacuationimportmodel==true) {
						
			System.out.print("\n"+"location drop down displayed");
			
		WebElement dropdownelement=driver.findElement(By.id("evacuationManagement_importAlertModel_dropdown"));
		Select dropdown=new Select(dropdownelement);
		dropdown.selectByIndex(1);
			
		}else {
			
			System.out.print("\n"+"there are no location drop down displayedt");
		}
		
			
		Cookie cookie = driver.manage().getCookieNamed("accessauth");
		// Decoder jwt = DecoderContext.decode(cookie);
		// Cookie cookie = driver.manage().getCookieNamed("domain");
		System.out.print("\n" + "cookie " + cookie);
		String cookiename = cookie.getValue();
		String cookiedomain = cookie.getDomain();
		System.out.print("\n" + "cookiename: " + cookiename);
		System.out.print("\n" + "cookiedomain: " + cookiedomain);
		// HttpResponse<JsonNode> response=
		// Unirest.post("https://test-s3377.fidentity.com/api/get_session_data.php").
		//String url = "https://" + cookiedomain + "/api/emergency_evacuation_import_list.php";
		//get_locations.php
		String url = "https://" + cookiedomain + "/api/get_session_data.php";
		HttpResponse<JsonNode> response = Unirest.post(url).header("Authorization", cookiename).asJson();
		System.out.print("\n" + "api response: " + response.getBody());
		String customerid = response.getBody().getObject().getJSONObject("data").getString("customer_id");
		// String account =
		// response.getBody().getObject().getJSONObject("data").getString("customer_id");
		System.out.print("\n" + "customer id  " + customerid);
		
		
		
		
		DataBase_connection db = new DataBase_connection();
		db.dbconnection();
		
		//int branchcount=db.stmt.getUpdateCount("SELECT branch_id,customer_id FROM test_checkon_central.branches where customer_id=@customerid");
/*
		ResultSet rs = db.stmt.executeQuery(
				"SELECT branch_id,customer_id FROM test_checkon_central.branches where customer_id=@customerid").getu;
		
		int branchcount=db.stmt.getUpdateCount(rs);*/
		/*
// SELECT * FROM test_user_management.users where email='sridevi903@srtest.com';
		System.out.println(rs);
		
		if(rs.next()) {
			
			String branchid=rs.getString("branch_id");
			int locations_count=rs.getu
			
			
			System.out.print("\n"+"count of locations"+locations_count);
			if(locations_count.equals("0")) {
				
				System.out.print("\n"+"thereis only onelocation available so we could not import notifications;");
			}
			else {
				
				System.out.print("\n"+"there are more  onelocation available so we can import notifications if they present;");
			}
			
		}*/
		
		
		/*if (rs.next()) {
			String plantype = rs.getString("plan_category");
			String interval = rs.getString("interval_unit");
			String trailstatus = rs.getString("trail_status");
			String schedule_status = rs.getString("is_next_schedule");

			if (trailstatus.equals("1") && schedule_status.equals("1")) {
				System.out.print("\n" + "Customer is in trail period and scheduled next plan;");
			}
			if (trailstatus.equals("1") && schedule_status.equals("0")) {
				System.out.print("\n" + "Customer is in trail period and not scheduled next plan;");

//---------------------continue the same plan----------------------------//				
				WebElement sameplan = driver
						.findElement(By.xpath("//form[@id='license_form']//a[contains(text(),'Continue Same Plan')]"));
				JavascriptExecutor sameplanexe = (JavascriptExecutor) driver;
				sameplanexe.executeScript("arguments[0].click();", sameplan);
		*/
		
		
		
	}
	
	public void select_notification() {
		
		
		//EvacuationmgmtRepo.importnotificationcheckbox.click();
		JavascriptExecutor selectnotificationexe=(JavascriptExecutor) driver;
		selectnotificationexe.executeScript("arguments[0].click();",EvacuationmgmtRepo.importnotificationcheckbox);
		
			
		
		JavascriptExecutor importbuttonexe=(JavascriptExecutor) driver;
		importbuttonexe.executeScript("arguments[0].click();",EvacuationmgmtRepo.importbutton);
		
		
		
	}

	public void alert_menu() {
		
		
		JavascriptExecutor alerteditdeletemenuexe=(JavascriptExecutor) driver;
		alerteditdeletemenuexe.executeScript("arguments[0].click();",EvacuationmgmtRepo.alerteditdeletemenu);}
	
	public void delete_menu() { 
		JavascriptExecutor alertdeleteexe=(JavascriptExecutor) driver;
		alertdeleteexe.executeScript("arguments[0].click();",EvacuationmgmtRepo.alertdelete);}
	public void delete_confirmation() {
		JavascriptExecutor deletealertexe=(JavascriptExecutor) driver;
		deletealertexe.executeScript("arguments[0].click();",EvacuationmgmtRepo.deleteconfirmation);
		
		
		
	}

	public void get_emergency_types() throws ClassNotFoundException, SQLException {
		
		Cookie cookie = driver.manage().getCookieNamed("accessauth");
		// Decoder jwt = DecoderContext.decode(cookie);
		// Cookie cookie = driver.manage().getCookieNamed("domain");
	//	System.out.print("\n" + "cookie " + cookie);
		String cookiename = cookie.getValue();
		String cookiedomain = cookie.getDomain();
		System.out.print("\n" + "cookiename: " + cookiename);
	//	System.out.print("\n" + "cookiedomain: " + cookiedomain);
		// HttpResponse<JsonNode> response=
		// Unirest.post("https://test-s3377.fidentity.com/api/get_session_data.php").
		//String url = "https://" + cookiedomain + "/api/emergency_evacuation_import_list.php";
		//get_locations.php
		String url = "https://" + cookiedomain + "/api/get_session_data.php";
		HttpResponse<JsonNode> response = Unirest.post(url).header("Authorization", cookiename).asJson();
		System.out.print("\n" + "api response: " + response.getBody());
		String customerid = response.getBody().getObject().getJSONObject("data").getString("customer_id");
		String branch_id = response.getBody().getObject().getJSONObject("data").getString("branch_id");
		
		
		// String account =
		// response.getBody().getObject().getJSONObject("data").getString("customer_id");
		System.out.print("\n" + "customer id  " + customerid);
		System.out.print("\n"+"branch id "+branch_id);
		
		DataBase_connection db = new DataBase_connection();
		db.dbconnection();
		ResultSet rs = db.stmt.executeQuery("SELECT * FROM test_checkon_central.emergency_evacuation_notifications where customer_id='"+customerid+"' and status=\"active\"\r\n" + 
		"and branch_id=\'"+branch_id+"'");
		
		//ResultSet rs=db.stmt.executeQuery("SELECT * FROM test_checkon_central.customers where customer_id='"+customerid+"';");
		
		
		
		System.out.println(rs);
		if (rs.next()) {
			
		//	String orgnizationame=rs.getString("organisation_name");
			//System.out.print("\n"+"organization:"+orgnizationame);
			String  alert_id= rs.getString("type_id");
			String alert_name = rs.getString("type_name");
			
			System.out.print("\n" + " alert id is " + alert_id + " " + "alert name is " + alert_name + "\n");
			
			
			driver.findElement(By.xpath("//input[@value='"+alert_id+"']//parent::td//label")).click();
			System.out.print("\n"+"selected notification");
			/*JavascriptExecutor alerteditdeletemenuexe=(JavascriptExecutor) driver;
			alerteditdeletemenuexe.executeScript("arguments[0].click();",EvacuationmgmtRepo.alerteditdeletemenu);
			JavascriptExecutor alertdeleteexe=(JavascriptExecutor) driver;
			alertdeleteexe.executeScript("arguments[0].click();",EvacuationmgmtRepo.alertdelete);*/
			
			
			
			
		/*	String importurl = "https://" + cookiedomain + "/api/get_emergency_evacuation_types.php";
			HttpResponse<JsonNode> importresponse = Unirest.post(importurl).header("Authorization", cookiename).asJson();
			System.out.print("\n" + "api response: " + importresponse.getBody());
			String alert_type_id = response.getBody().getObject().getJSONObject("data").getString("ee_type_id");
			String alert_type_name = response.getBody().getObject().getJSONObject("data").getString("ee_type_name");
			String Current_branch_id = response.getBody().getObject().getJSONObject("data").getString("branch_id");
			
			System.out.print("\n"+"alert type id:"+alert_type_id);
			System.out.print("\n"+"alert type id:"+alert_type_name);
			System.out.print("\n"+"alert type id:"+Current_branch_id);*/
			
			
		/*	WebElement pswdscreen = Signuprepo.otp;
			if (pswdscreen.isDisplayed()) {
				System.out.print("\n" + "Change password screen launched successfully");
				Signuprepo.otp.clear();
				Signuprepo.otp.sendKeys(onetimepswd);
				// driver.findElement(By.xpath("//form[@id='create_password_form']//div//input[@id='otp']")).clear();
				// driver.findElement(By.xpath("//form[@id='create_password_form']//div//input[@id='otp']")).sendKeys(onetimepswd);
			} else {
				System.out.print("\n" + "Change password screen not launched hence we tried signup multiple times");
			}*/
		
		
	}
		else
		{System.out.print("\n"+"There are no records to delete");}
			
		

}
	
	
	public void cancel_deletion() {
		
		JavascriptExecutor canceldeletexe=(JavascriptExecutor) driver;
		canceldeletexe.executeScript("arguments[0].click();",EvacuationmgmtRepo.canceldeleteconfirmation);
	
		
	}
public void edit_menu() throws InterruptedException {
	
	JavascriptExecutor alerteditexe=(JavascriptExecutor) driver;
	alerteditexe.executeScript("arguments[0].click();",EvacuationmgmtRepo.alertedit);
	Thread.sleep(2000);
}
public void edit_alert_details() throws InterruptedException {
	//Thread.sleep(3000);
	PageFactory.initElements(driver,EvacuationmgmtRepo.class);
	
//	String typetext=EvacuationmgmtRepo.emergencytype.getText();
	
	Random randomGenerator = new Random();
	int randomInt = randomGenerator.nextInt(10000);
	WebElement edit_emergencytype=driver.findElement(By.xpath("//form[@id='edit_alert_form']//input[@id='ee_type']"));
	edit_emergencytype.clear();
	System.out.print("\n"+"cleared emergency type");
	edit_emergencytype.sendKeys("Fire emergency"+randomInt);
	System.out.print("\n"+"entered emergency type");
	
	WebElement edit_desc=driver.findElement(By.xpath("//form[@id='edit_alert_form']//textarea[@id='ee_notification']"));
	edit_desc.clear();
	edit_desc.sendKeys("Everyone should exit from premises"+randomInt);
	
	Evacuationmgmt evacuation=new Evacuationmgmt();
	
	evacuation.edit_evacuation_save();
	

	
	
	Thread.sleep(2000);
}

public void edit_evacuation_save() {
JavascriptExecutor alerteditexe=(JavascriptExecutor) driver;
alerteditexe.executeScript("arguments[0].click();",EvacuationmgmtRepo.editedalertsave);
System.out.print("\n"+"clicked save button on edit model window");
}

}
