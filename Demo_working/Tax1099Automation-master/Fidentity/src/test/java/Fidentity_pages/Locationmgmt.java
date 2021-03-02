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
import org.bson.codecs.Decoder;
import org.bson.codecs.DecoderContext;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.json.Json;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.fasterxml.jackson.databind.node.JsonNodeCreator;

import Common.Fid_base;
import Object_repo.Empactionsrepo;
import Object_repo.Locationmgmtrepo;
import Object_repo.Profilerepo;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.util.internal.ThreadLocalRandom;
import kong.unirest.GetRequest;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.json.JSONArray;
import kong.unirest.json.JSONObject;

public class Locationmgmt extends Fid_base {
	int count;

	static Random randomGenerator = new Random();
	static int randomInt = randomGenerator.nextInt(1000);

	public void locationNav() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		PageFactory.initElements(driver, Locationmgmtrepo.class);

		JavascriptExecutor myorgexe = (JavascriptExecutor) driver;
		myorgexe.executeScript("arguments[0].click();", Locationmgmtrepo.myorg);

		JavascriptExecutor locationexe = (JavascriptExecutor) driver;
		locationexe.executeScript("arguments[0].click();", Locationmgmtrepo.locationmanagementmenu);

	} 

	public void edit_location() {

		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		PageFactory.initElements(driver, Locationmgmtrepo.class);
		JavascriptExecutor editexe = (JavascriptExecutor) driver;
		editexe.executeScript("arguments[0].click();", Locationmgmtrepo.editicon);

		System.out.print("\n" + "Edit icon clicked");

		Locationmgmtrepo.Locationname.clear();
		Locationmgmtrepo.Locationname.sendKeys("Hyderabad" + randomInt);
		Locationmgmtrepo.locationaddress.clear();
		Locationmgmtrepo.locationaddress.sendKeys("The platina");
		Locationmgmtrepo.City.clear();
		Locationmgmtrepo.City.sendKeys("Hyderabad");
		Locationmgmtrepo.State.clear();
		Locationmgmtrepo.State.sendKeys("Telangana");
		Locationmgmtrepo.Country.clear();
		Locationmgmtrepo.Country.sendKeys("India");

		/*
		 * WebElement edit= driver.findElement(By.
		 * xpath("//form[@id='location_filter_form']/following-sibling::div//table//td//a[@title='Edit Location']"
		 * )); JavascriptExecutor editexecutor = (JavascriptExecutor) driver;
		 * editexecutor.executeScript("arguments[0].click();", edit);
		 * //driver.findElement(By.
		 * xpath("//input[@name='branch_name' and @id='location_name']")).sendKeys(
		 * randomstring); driver.findElement(By.
		 * xpath("//input[@name='branch_name' and @id='location_name']")).clear();
		 * driver.findElement(By.
		 * xpath("//input[@name='branch_name' and @id='location_name']")).sendKeys(
		 * "Location"+randomInt); driver.findElement(By.
		 * xpath("//input[@name='branch_location' and @id='location_address']")).clear()
		 * ; driver.findElement(By.
		 * xpath("//input[@name='branch_location' and @id='location_address']")).
		 * sendKeys("Hyderabad"+randomInt);
		 * driver.findElement(By.xpath("//input[@name='city' and @id='locality']")).
		 * clear();
		 * driver.findElement(By.xpath("//input[@name='city' and @id='locality']")).
		 * sendKeys("Hyderabad"+randomInt); driver.findElement(By.
		 * xpath("//input[@name='state' and @id='administrative_area_level_1']")).clear(
		 * ); driver.findElement(By.
		 * xpath("//input[@name='state' and @id='administrative_area_level_1']")).
		 * sendKeys("Telangana"+randomInt);
		 * driver.findElement(By.xpath("//input[@name='country' and @id='country']")).
		 * clear();
		 * driver.findElement(By.xpath("//input[@name='country' and @id='country']")).
		 * sendKeys("India"+randomInt);
		 */
	}

	public void update() {

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		PageFactory.initElements(driver, Locationmgmtrepo.class);
		JavascriptExecutor Updatebuttonexe = (JavascriptExecutor) driver;
		Updatebuttonexe.executeScript("arguments[0].click();", Locationmgmtrepo.Updatebutton);

	}

	public void editLocation_vaidations() throws IOException, InterruptedException {

		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		PageFactory.initElements(driver, Locationmgmtrepo.class);
		JavascriptExecutor editexe = (JavascriptExecutor) driver;
		editexe.executeScript("arguments[0].click();", Locationmgmtrepo.editicon);

		Locationmgmtrepo.Locationname.clear();
		Locationmgmtrepo.locationaddress.clear();
		Locationmgmtrepo.City.clear();
		Locationmgmtrepo.State.clear();
		Locationmgmtrepo.Country.clear();
		Locationmgmt location = new Locationmgmt();
		location.update();

		Locationmgmtrepo.Locationname.clear();
		Locationmgmtrepo.Locationname.sendKeys("Hyderabad" + randomInt);
		Locationmgmtrepo.locationaddress.clear();
		Locationmgmtrepo.City.clear();
		Locationmgmtrepo.State.clear();
		Locationmgmtrepo.Country.clear();
		location.update();

		Locationmgmtrepo.Locationname.clear();
		Locationmgmtrepo.Locationname.sendKeys("Hyderabad" + randomInt);
		Locationmgmtrepo.locationaddress.clear();
		Locationmgmtrepo.locationaddress.sendKeys("The platina");
		Locationmgmtrepo.City.clear();
		Locationmgmtrepo.State.clear();
		Locationmgmtrepo.Country.clear();
		location.update();

		Locationmgmtrepo.Locationname.clear();
		Locationmgmtrepo.Locationname.sendKeys("Hyderabad" + randomInt);
		Locationmgmtrepo.locationaddress.clear();
		Locationmgmtrepo.locationaddress.sendKeys("The platina");
		Locationmgmtrepo.City.clear();
		Locationmgmtrepo.City.sendKeys("Hyderabad");
		Locationmgmtrepo.State.clear();
		Locationmgmtrepo.Country.clear();
		location.update();

		Locationmgmtrepo.Locationname.clear();
		Locationmgmtrepo.Locationname.sendKeys("Hyderabad" + randomInt);
		Locationmgmtrepo.locationaddress.clear();
		Locationmgmtrepo.locationaddress.sendKeys("The platina");
		Locationmgmtrepo.City.clear();
		Locationmgmtrepo.City.sendKeys("Hyderabad");
		Locationmgmtrepo.State.clear();
		Locationmgmtrepo.State.sendKeys("Telangana");
		Locationmgmtrepo.Country.clear();
		location.update();

	}

	public static boolean isNullOrEmpty(String str) {
		if (str != null && !str.isEmpty())
			return false;
		return true;
	}

	public void locations_count() {

		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		PageFactory.initElements(driver, Locationmgmtrepo.class);

		count = Locationmgmtrepo.Locationrecord.size();

		System.out.println("\n" + "Number of locations " + count);

		// find number of active locations so that can resrict if one location is in
		// active cannot in activate
		if (count > 1) {

			Random rand = new Random();
			int randomrow = ThreadLocalRandom.current().nextInt(1, count);
			// rand.current().nextInt(0);
			System.out.println("\n" + "Location name:" + Locationmgmtrepo.namevalue.get(randomrow).getText() + " "
					+ "\n" + "Location status:" + Locationmgmtrepo.Statusvalue.get(randomrow).getText());

			System.out.print("\n" + "random row number is:" + randomrow);

		}

		/*
		 * 
		 * Random rand = new Random(); int randomrow = rand.nextInt(1);
		 * System.out.print("\n" +
		 * Locationmgmtrepo.Locationrecord.get(randomrow).getText());
		 * 
		 * 
		 * 
		 * 
		 * 
		 * boolean rowstatus =
		 * Locationmgmtrepo.Locationrecord.get(randomrow).getText().startsWith("active")
		 * ; if (rowstatus == true) { System.out.println("row status is active"); } else
		 * { System.out.println("/n" + "Random row status is active"); }
		 * System.out.print("row number is:" + randomrow);
		 */

	}
public void reports_download() {
	
	WebElement downloadicon=driver.findElement(By.xpath("//a[contains(@id,'viewLocation_grid_download')]"));
	JavascriptExecutor downloadiconexe = (JavascriptExecutor) driver;
	downloadiconexe.executeScript("arguments[0].click();", downloadicon);
	System.out.print("\n"+"Clicked on download icon");
	
}

public void dates_fromto() throws InterruptedException {
	
	JavascriptExecutor fromdateexe = (JavascriptExecutor) driver;
	fromdateexe.executeScript("arguments[0].click();", Locationmgmtrepo.fromdate);
	WebElement todaybutton = driver.findElement(By.xpath("//button[contains(text(),'Today')]"));
	JavascriptExecutor todayexe = (JavascriptExecutor) driver;
	todayexe.executeScript("arguments[0].click();", todaybutton);
	System.out.print("\n" + "Selected today's date");
	Thread.sleep(2000);
	WebElement OKbutton = driver.findElement(By.xpath("//button[contains(text(),'Ok')]"));
	JavascriptExecutor OKexe = (JavascriptExecutor) driver;
	OKexe.executeScript("arguments[0].click();", OKbutton);
	System.out.print("\n" + "Clicked on ok button");
	
Thread.sleep(5000);


	JavascriptExecutor todateexe = (JavascriptExecutor) driver;
	todateexe.executeScript("arguments[0].click();", Locationmgmtrepo.todate);
	
	WebElement todaybuttontodate = driver.findElement(By.xpath("//*[@id='to_date_root']//button[contains(text(),'Today')]"));
	JavascriptExecutor todaybuttontodateexe = (JavascriptExecutor) driver;
	todaybuttontodateexe.executeScript("arguments[0].click();", todaybuttontodate);
	
	System.out.print("\n" + "Selected today's date");
	Thread.sleep(3000);
	
	WebElement OKbuttontodate = driver.findElement(By.xpath("//*[@id='to_date_root']//button[contains(text(),'Ok')]"));
	JavascriptExecutor OKbuttontodateexe = (JavascriptExecutor) driver;
	OKbuttontodateexe.executeScript("arguments[0].click();", OKbuttontodate);
	Thread.sleep(2000);
	System.out.print("\n" + "Clicked on ok button");
	
	
}

public void download_validations() throws InterruptedException {
	
	// from date validation
	select_reporttype();
	Thread.sleep(2000);
	download_submit();
	System.out.print("\n"+"From date validation checked");
	
	JavascriptExecutor fromdateexe = (JavascriptExecutor) driver;
	fromdateexe.executeScript("arguments[0].click();", Locationmgmtrepo.fromdate);
	WebElement todaybutton = driver.findElement(By.xpath("//button[contains(text(),'Today')]"));
	JavascriptExecutor todayexe = (JavascriptExecutor) driver;
	todayexe.executeScript("arguments[0].click();", todaybutton);
	System.out.print("\n" + "Selected today's date");
	Thread.sleep(2000);
	WebElement OKbutton = driver.findElement(By.xpath("//button[contains(text(),'Ok')]"));
	JavascriptExecutor OKexe = (JavascriptExecutor) driver;
	OKexe.executeScript("arguments[0].click();", OKbutton);
	System.out.print("\n" + "Clicked on ok button");
	download_submit();
	System.out.print("\n"+"Todate validation checked");
	
}
public void reset_download() throws InterruptedException {
	JavascriptExecutor resetexe = (JavascriptExecutor) driver;
	resetexe.executeScript("arguments[0].click();",Locationmgmtrepo.resetdownloadreports );
	Thread.sleep(2000);
	
}

public void download_submit() {
	
	JavascriptExecutor Locationmgmtrepoexe = (JavascriptExecutor) driver;
	Locationmgmtrepoexe.executeScript("arguments[0].click();",Locationmgmtrepo.viewreport);
}

public void select_reporttype() {
	Select reporttype=new Select(driver.findElement(By.id("report_name")));
	reporttype.selectByValue("checkins");
	
}
	public void active_inactive_locations() throws InterruptedException {

		int flag = 0;
		int allvalue = Locationmgmtrepo.Locationrecord.size();
		// for printing everything in the table
		// System.out.print("\n"+"allvalue.");
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		for (int i = 0; i < allvalue; i++) {
			

				if (Locationmgmtrepo.Statusvalue.get(i).getText().equals("inactive")) {
					
					System.out.print("\n"+"location is in inactive state");
					JavascriptExecutor deactivate = (JavascriptExecutor) driver;
					deactivate.executeScript("arguments[0].click();", Locationmgmtrepo.activeInactivelocation);
					Thread.sleep(3000);
					JavascriptExecutor confirmdeactivate = (JavascriptExecutor) driver;
					confirmdeactivate.executeScript("arguments[0].click();", Locationmgmtrepo.confirmactivateInactiveloc);
					break;
				}else {
					
					System.out.print("\n"+"location is in active state");
				}
			
			
			// System.out.println("Status of location are : " + allvalue.get(i).getText());

		/*	if (Locationmgmtrepo.Statusvalue.get(i).getText().equals("inactive")) {

				flag++;
				System.out.print("\n" + "Number of active locations:" + flag);
			}

			if (flag > 1) {

				JavascriptExecutor deactivate = (JavascriptExecutor) driver;
				deactivate.executeScript("arguments[0].click();", Locationmgmtrepo.activeInactivelocation);
				Thread.sleep(3000);
				JavascriptExecutor confirmdeactivate = (JavascriptExecutor) driver;
				confirmdeactivate.executeScript("arguments[0].click();", Locationmgmtrepo.confirmactivateInactiveloc);
				// driver.findElement(By.xpath("//div[@class='card
				// my-card']//l[i]//table//tr//td[6]//span[2]")).click();
				break;
			} else {
				System.out.print("\n" + "There are no inactive locations available to activate");
			}*/
		}
	}
	public void inactivelocations() throws InterruptedException {
		int flag = 0;
		int allvalue = Locationmgmtrepo.Locationrecord.size();
		// for printing everything in the table
		// System.out.print("\n"+"allvalue.");
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		for (int i = 0; i < allvalue; i++) {
			// System.out.println("Status of location are : " + allvalue.get(i).getText());

			if (Locationmgmtrepo.Statusvalue.get(i).getText().equals("active")) {

				flag++;
				System.out.print("\n" + "Number of active locations:" + flag);
			}

			if (flag > 1) {

				JavascriptExecutor deactivate = (JavascriptExecutor) driver;
				deactivate.executeScript("arguments[0].click();", Locationmgmtrepo.deactivatelocation);
				Thread.sleep(3000);
				JavascriptExecutor confirmdeactivate = (JavascriptExecutor) driver;
				confirmdeactivate.executeScript("arguments[0].click();", Locationmgmtrepo.confirmdeactivation);
				// driver.findElement(By.xpath("//div[@class='card
				// my-card']//l[i]//table//tr//td[6]//span[2]")).click();
				System.out.print("\n"+"Active location deactivated");
				break;
			} else {
				System.out.print("\n" + "Active locations should be more than 1 then only we can deactivate or delete");
			}
		}
	}
	
public void cancelInactive() throws InterruptedException {
	
	int flag = 0;
	int allvalue = Locationmgmtrepo.Locationrecord.size();
	// for printing everything in the table
	// System.out.print("\n"+"allvalue.");
	driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	for (int i = 0; i < allvalue; i++) {
		// System.out.println("Status of location are : " + allvalue.get(i).getText());

		if (Locationmgmtrepo.Statusvalue.get(i).getText().equals("active")) {

			flag++;
			System.out.print("\n" + "Number of active locations:" + flag);
		}

		if (flag > 1) {

			JavascriptExecutor deactivate = (JavascriptExecutor) driver;
			deactivate.executeScript("arguments[0].click();", Locationmgmtrepo.deactivatelocation);
			Thread.sleep(3000);
			JavascriptExecutor confirmdeactivate = (JavascriptExecutor) driver;
			confirmdeactivate.executeScript("arguments[0].click();", Locationmgmtrepo.cancelconfirmdeactivation);
			// driver.findElement(By.xpath("//div[@class='card
			// my-card']//l[i]//table//tr//td[6]//span[2]")).click();
			System.out.print("\n"+"Cancelled deativating location");
			break;
		} else {
			System.out.print("\n" + "Active locations should be more than 1 then only we can deactivate or delete");
		}
	}
	
}
	public void delete_location() throws InterruptedException {

		int flag = 0;
		int allvalue = Locationmgmtrepo.Locationrecord.size();
		// for printing everything in the table
		// System.out.print("\n"+"allvalue.");
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		for (int i = 0; i < allvalue; i++) {
			// System.out.println("Status of location are : " + allvalue.get(i).getText());

			if (Locationmgmtrepo.Statusvalue.get(i).getText().equals("inactive")) {

				JavascriptExecutor delete = (JavascriptExecutor) driver;
				delete.executeScript("arguments[0].click();", Locationmgmtrepo.deletelocation);
				Thread.sleep(3000);
				JavascriptExecutor acceptdel = (JavascriptExecutor) driver;
				acceptdel.executeScript("arguments[0].click();", Locationmgmtrepo.acceptdelete);
				JavascriptExecutor confirmdel = (JavascriptExecutor) driver;
				confirmdel.executeScript("arguments[0].click();", Locationmgmtrepo.confirmdeletion);
			}

			if (Locationmgmtrepo.Statusvalue.get(i).getText().equals("active")) {
				flag++;
				System.out.print("\n" + "Number of active locations:" + flag);
			}

		}
		if (flag > 1) {

			JavascriptExecutor deactivate = (JavascriptExecutor) driver;
			deactivate.executeScript("arguments[0].click();", Locationmgmtrepo.deactivatelocation);
			Thread.sleep(3000);
			JavascriptExecutor confirmdeactivate = (JavascriptExecutor) driver;
			confirmdeactivate.executeScript("arguments[0].click();", Locationmgmtrepo.confirmdeactivation);
			Thread.sleep(2000);
			JavascriptExecutor delete = (JavascriptExecutor) driver;
			delete.executeScript("arguments[0].click();", Locationmgmtrepo.deletelocation);
			Thread.sleep(3000);
			JavascriptExecutor acceptdel = (JavascriptExecutor) driver;
			acceptdel.executeScript("arguments[0].click();", Locationmgmtrepo.acceptdelete);
			JavascriptExecutor confirmdel = (JavascriptExecutor) driver;
			confirmdel.executeScript("arguments[0].click();", Locationmgmtrepo.confirmdeletion);

			// driver.findElement(By.xpath("//div[@class='card
			// my-card']//l[i]//table//tr//td[6]//span[2]")).click();
		} else {
			System.out.print("\n" + "Active locations should be more than 1 then only we could delete");
		}

	}

	public void createlocationbutton() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		JavascriptExecutor confirmdel = (JavascriptExecutor) driver;
		confirmdel.executeScript("arguments[0].click();", Locationmgmtrepo.createlocationbutton);
		
		//Locationmgmtrepo.createlocationbutton.click();

		/*
		 * WebDriverWait wait = new WebDriverWait(driver, 40);
		 * wait.until(ExpectedConditions.elementToBeClickable(Locationmgmtrepo.
		 * createlocationbutton)); System.out.println("\n" +
		 * "Clicked on create location button"); JavascriptExecutor createlocationexe =
		 * (JavascriptExecutor) driver;
		 * createlocationexe.executeScript("arguments[0].click();",
		 * Locationmgmtrepo.createlocationbutton);
		 * System.out.print("\n"+"clicked create location button");
		 */

	}
	/*
	 * public void required_details_for_location() throws InterruptedException {
	 * Thread.sleep(2000); Random randomGenerator = new Random(); int randomInt =
	 * randomGenerator.nextInt(10000);
	 * Locationmgmtrepo.addlocationname.sendKeys("Test" + randomInt);
	 * Locationmgmtrepo.addlocationaddress.sendKeys("New Mumbai" + randomInt);
	 * Locationmgmtrepo.addlocationcity.sendKeys("New Mumbai" + randomInt);
	 * Locationmgmtrepo.addlocationstate.sendKeys("Maharashtra" + randomInt);
	 * Locationmgmtrepo.addlocationcountry.sendKeys("India"); Select timezone = new
	 * Select(Locationmgmtrepo.utctimezone); timezone.
	 * selectByVisibleText("(GMT +5:30) Bombay, Calcutta, Madras, New Delhi");
	 * 
	 * //Locationmgmtrepo.utctimezone.
	 * selectByVisibleText("(GMT +5:30) Bombay, Calcutta, Madras, New Delhi");
	 * //Locationmgmtrepo.utctimezone.selectByIndex(3); JavascriptExecutor
	 * confirmdel = (JavascriptExecutor) driver;
	 * confirmdel.executeScript("arguments[0].click();",
	 * Locationmgmtrepo.addlocationbutton); JavascriptExecutor confirmation =
	 * (JavascriptExecutor) driver;
	 * confirmation.executeScript("arguments[0].click();",
	 * Locationmgmtrepo.addlocationconfirmation); }
	 */

	public void location_form_details() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);
	//	Locationmgmtrepo.addlocationname.click();
		//Locationmgmtrepo.addlocationname.clear();
		Locationmgmtrepo.addlocationname.sendKeys("Test" + randomInt);

		Locationmgmtrepo.addlocationaddress.sendKeys("New Mumbai" + randomInt);
		String newlocationaddr=Locationmgmtrepo.addlocationaddress.getText();
		System.out.println("\n"+"new location:"+newlocationaddr);
		Locationmgmtrepo.addlocationcity.sendKeys("New Mumbai" + randomInt);
		Locationmgmtrepo.addlocationstate.sendKeys("Maharashtra" + randomInt);
		Locationmgmtrepo.addlocationcountry.sendKeys("India");
		Select timezone = new Select(Locationmgmtrepo.utctimezone);
		timezone.selectByVisibleText("(GMT +5:30) Bombay, Calcutta, Madras, New Delhi");

		JavascriptExecutor confirmdel = (JavascriptExecutor) driver;
		confirmdel.executeScript("arguments[0].click();", Locationmgmtrepo.addlocationbutton);
		JavascriptExecutor confirmation = (JavascriptExecutor) driver;
		confirmation.executeScript("arguments[0].click();", Locationmgmtrepo.addlocationconfirmation);

	}

	public void location_details() throws InterruptedException {

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
		String url = "https://" + cookiedomain + "/api/get_session_data.php";
		HttpResponse<JsonNode> response = Unirest.post(url).header("Authorization", cookiename).asJson();
		System.out.print("\n" + "api response: " + response.getBody());
		String customerid = response.getBody().getObject().getJSONObject("data").getString("customer_id");
		// String account =
		// response.getBody().getObject().getJSONObject("data").getString("customer_id");
		System.out.print("\n" + "customer id  " + customerid);

		String availablelicenseurl = "https://" + cookiedomain + "/api/check_for_available_license.php";
		HttpResponse<JsonNode> availablelicenseresponse = Unirest.post(availablelicenseurl)
				.header("Authorization", cookiename).asJson();
		int availablelicenses = availablelicenseresponse.getBody().getObject().getJSONObject("data")
				.getInt("available_licences");
		System.out.print("\n" + "available licenses are: "
				+ availablelicenseresponse.getBody().getObject().getJSONObject("data").getInt("available_licences"));
		
		String subscribedplanurl = "https://" + cookiedomain + "/api/get_customer_plan_json.php";
		HttpResponse<JsonNode> cutomerplan = Unirest.post(subscribedplanurl)
				.header("Authorization", cookiename).asJson();
		String subscribedplan = cutomerplan.getBody().getObject().getJSONObject("data")
				.getString("plan_name");
		System.out.print("\n" + "subscriberd plan is : "+subscribedplan);
		if(subscribedplan.equals("premium")) {	
			
		      if (availablelicenses > 0) {
			
			System.out.print("\n" + "available licenses are more than zero");
			Locationmgmt locationadd = new Locationmgmt();
			locationadd.createlocationbutton();
			System.out.print("\n" + "create location button clicked");
			locationadd.location_form_details();

		} 
		      
		      else {

			System.out.print("\n" + "available licenses are zero need to buy licences");
			Locationmgmt locationadd = new Locationmgmt();
			locationadd.createlocationbutton();
			JavascriptExecutor buylocationexe = (JavascriptExecutor) driver;
			buylocationexe.executeScript("arguments[0].click();", Locationmgmtrepo.buylocation);
			JavascriptExecutor addinglicensexe = (JavascriptExecutor) driver;
			addinglicensexe.executeScript("arguments[0].click();", Locationmgmtrepo.incrementbaselicense);
			JavascriptExecutor paybuttonexe = (JavascriptExecutor) driver;
			paybuttonexe.executeScript("arguments[0].click();", Locationmgmtrepo.paybutton);
			JavascriptExecutor okexe = (JavascriptExecutor) driver;
			okexe.executeScript("arguments[0].click();", Locationmgmtrepo.paidinfo);
			Locationmgmt addlicense = new Locationmgmt();
			addlicense.locationNav();
			addlicense.createlocationbutton();
			System.out.print("\n" + "create location button clicked");
			locationadd.location_form_details();
			
			
		}} else if(subscribedplan.equals("basic")){
			
			System.out.print("\n"+"Customer current plan is basic so, not allowed to create location");
		}
		
		
		else {
			
			System.out.print("\n"+"Plan is not premium plan check the limit");
			
		}

	}

	public void location_details_old() throws InterruptedException {

		// PageFactory.initElements(driver, Locationmgmtrepo.class);
		// WebElement usethisbutton=Locationmgmtrepo.confirminactivelicense;

		try {
			/*
			 * if(usethisbutton.isDisplayed()) {
			 * Locationmgmtrepo.selectinactivelocation.click();
			 * 
			 * JavascriptExecutor confirm = (JavascriptExecutor) driver;
			 * confirm.executeScript("arguments[0].click();",
			 * Locationmgmtrepo.confirminactivelicense); required_details_for_location();
			 * 
			 * }else {
			 */

			Assert.assertEquals(true, Locationmgmtrepo.addlocationname.isDisplayed(), "Add location form displayed");

			System.out.print("Add location form availble");
			Thread.sleep(2000);

			Locationmgmt location = new Locationmgmt();
			location.location_form_details();

			// driver.close();
			// }

		} catch (AssertionError error) {
			System.out.print("\n" + "Licences are not available to add location need to buy license ");

			JavascriptExecutor buylocation = (JavascriptExecutor) driver;
			buylocation.executeScript("arguments[0].click();", Locationmgmtrepo.buylocation);
			Thread.sleep(2000);
			JavascriptExecutor incrementlicense = (JavascriptExecutor) driver;
			incrementlicense.executeScript("arguments[0].click();", Locationmgmtrepo.incrementbaselicense);

			JavascriptExecutor paybutton = (JavascriptExecutor) driver;
			paybutton.executeScript("arguments[0].click();", Locationmgmtrepo.paybutton);

			JavascriptExecutor infook = (JavascriptExecutor) driver;
			infook.executeScript("arguments[0].click();", Locationmgmtrepo.paidinfo);
			driver.navigate().refresh();
			Thread.sleep(2000);
			Locationmgmt location = new Locationmgmt();
			location.locationNav();
			location.createlocationbutton();
			if (Locationmgmtrepo.addlocationname.isDisplayed()) {

				location.location_form_details();
			}

		}
	}

}

/*
 * int flag = 0; // WebElement // status=driver.findElement(By.xpath(
 * "//form[@id='location_filter_form']/following-sibling::div//li//div//table[@id='loc-grid']//tbody//tr//td[9]//span[contains(text(),'Status')]/following-sibling::span"
 * )); // List <WebElement> rows =
 * driver.findElements(By.xpath("//div[@class='card //
 * my-card']//li//table[@id='loc-grid']"));
 * 
 * List<WebElement> allvalue = driver.findElements(By.xpath(
 * "//form[@id='location_filter_form']/following-sibling::div//li//div//table[@id='loc-grid']//tbody//tr//td[9]//span[contains(text(),'Status')]/following-sibling::span"
 * )); // for printing everything in the table
 * 
 * for (int i = 0; i < allvalue.size(); i++) { //
 * System.out.println("Status of location are : " + allvalue.get(i).getText());
 * 
 * if (allvalue.get(i).getText().equals("active")) {
 * 
 * flag++; System.out.println("active locations : " + flag); }
 * 
 * }
 * 
 * if (flag > 1) {
 * 
 * System.out.print("One location can be delete");
 * 
 * WebElement deactive = driver.findElement(By.xpath(
 * "//form[@id='location_filter_form']/following-sibling::div//li//div//table[@id='loc-grid']//tbody//tr//td[@class='locations-actions']//a[@title='Deactivate Location']//i"
 * )); JavascriptExecutor deactiveexe = (JavascriptExecutor) driver;
 * 
 * deactiveexe.executeScript("arguments[0].click();", deactive);
 * 
 * Thread.sleep(3000);
 * 
 * driver.findElement(By.
 * xpath("//div[@id='deactivate_location_modal']//div//a[@title='Delete Location']"
 * )) .click(); driver.findElement(By.xpath(
 * "//form[@id='location_filter_form']/following-sibling::div//li//div//table[@id='loc-grid']//tbody//tr//td[@class='locations-actions']//a[@title='Delete Location']//i"
 * )) .click();
 * 
 * } else { System.out.print("location cannot be deleted"); }
 */

/*
 * Set<WebElement> distinct=new HashSet<>(allvalue); for(WebElement s:distinct)
 * { System.out.println("active locations : "+" "+s +
 * Collections.frequency(allvalue, s)); }
 */

// List<WebElement> elements = driver.findElements(By.xpath("//*[text()]"));

/*
 * public void CheckActieloc() {
 * 
 * 
 * WebElement table =driver.findElement(By.xpath(
 * "//form[@id='location_filter_form']/following-sibling::div//li//div//table[@id='loc-grid']"
 * )); WebElement tbody=table.findElement(By.tagName("tbody")); List<WebElement>
 * rows=tbody.findElements(By.tagName("tr")); ArrayList<String> ListOdIds=new
 * ArrayList<>(); String rowNo=""; for(int i=0;i<rows.size();i++) { WebElement
 * row =
 * tbody.findElement(By.xpath("//table[@id='tableId']/tbody/tr["+(i+1)+"]"));
 * if(row.getText().trim().contains(value)) { rowNo=Integer.toString(i+1);
 * break; }
 * 
 * }
 * 
 * // return rowNo; }
 * 
 * 
 * }
 */
