package Fidentity_pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Common.Fid_base;
import Object_repo.Locationmgmtrepo;
import Object_repo.PackagedeliveryRepo;
import Object_repo.PendingcheckinsRepo;
import Object_repo.WatchlistRepo;
import io.appium.java_client.events.api.general.JavaScriptEventListener;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.json.JSONArray;

public class WatchlistManagement extends Fid_base {

	public void Navigation_watchlist() {

		PageFactory.initElements(driver, WatchlistRepo.class);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebElement settingsiconelement = WatchlistRepo.settingsicon;
		JavascriptExecutor settingsiconexe = (JavascriptExecutor) driver;
		settingsiconexe.executeScript("arguments[0].click();", WatchlistRepo.settingsicon);
		JavascriptExecutor watchlistexe = (JavascriptExecutor) driver;
		watchlistexe.executeScript("arguments[0].click();", WatchlistRepo.watchlistmenu);
	}

	public void getadminwindowstring(String adminwindow) {

		adminwindow = driver.getWindowHandle();
		driver.switchTo().window(adminwindow);
		System.out.print("\n" + "admin window opened");
		String title = driver.getTitle();
		System.out.print("\n" + "title is :" + title);

	}

	public void create_watchlist() {
		JavascriptExecutor createwatchexe = (JavascriptExecutor) driver;
		createwatchexe.executeScript("arguments[0].click();", WatchlistRepo.createwatchlistbutton);
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(1000);
		WatchlistRepo.watchlistname.sendKeys("Test" + randomInt);
		WatchlistRepo.watchlistdescription.sendKeys("Test" + randomInt);

	}

	public void select_watchlist() {

		List<WebElement> watchlistrecords = driver.findElements(By.xpath("//table//tbody//tr"));
		int count = watchlistrecords.size();
		if (count >= 1) {

			WebElement firstrecord = driver
					.findElement(By.xpath("//table//tbody//tr[1]//td//input[contains(@id,'watchlist_select')]"));
			JavascriptExecutor firstwatchexe = (JavascriptExecutor) driver;
			firstwatchexe.executeScript("arguments[0].click();", firstrecord);
			System.out.print("\n" + "selected watchlist first record for edit");
		} else {
			System.out.print("\n" + "there are no watchlist records");

		}

	}

	public void menudropdown() {
		JavascriptExecutor watchlistmenuexe = (JavascriptExecutor) driver;
		watchlistmenuexe.executeScript("arguments[0].click();", WatchlistRepo.watchlistactions);

	}

	public void editmenu_item() {

		JavascriptExecutor watchlisteditexe = (JavascriptExecutor) driver;
		watchlisteditexe.executeScript("arguments[0].click();", WatchlistRepo.watchlisteditmenu);

	}

	public void edit_details() {

		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(1000);
		WatchlistRepo.watchlisteditname.clear();
		WatchlistRepo.watchlisteditname.sendKeys("Test" + randomInt);
		WatchlistRepo.watchlisteditdescription.clear();
		WatchlistRepo.watchlisteditdescription.sendKeys("Test" + randomInt);

	}

	public void edit_save() {
		JavascriptExecutor watchlisteditsaveexe = (JavascriptExecutor) driver;
		watchlisteditsaveexe.executeScript("arguments[0].click();", WatchlistRepo.watchlisteditsavebutton);

	}

	public void deletemenu_item() {
		JavascriptExecutor watchlistdeleteexe = (JavascriptExecutor) driver;
		watchlistdeleteexe.executeScript("arguments[0].click();", WatchlistRepo.watchlistdeetemenu);

	}

	public void watchlist_delete_confirm() {

		WebElement deletemodel = WatchlistRepo.watchlistdeletemodal;
		boolean deletemodeldisplay = deletemodel.isDisplayed();
		if (deletemodeldisplay == true) {
			JavascriptExecutor deleteconfirmexe = (JavascriptExecutor) driver;
			deleteconfirmexe.executeScript("arguments[0].click();", WatchlistRepo.watchlistdeleteconfirm);

		} else {

			System.out.print("\n" + "delete confirm model not displayed");
		}
	}

	public void onlocation_navigation() throws InterruptedException {

		PageFactory.initElements(driver, WatchlistRepo.class);
		Thread.sleep(2000);

		// JavascriptExecutor productsexe = (JavascriptExecutor) driver;
		// productsexe.executeScript("arguments[0].click();",
		// WatchlistRepo.productsmenu);
		// JavascriptExecutor vmsmoduleexe = (JavascriptExecutor) driver;
		// vmsmoduleexe.executeScript("arguments[0].click();", WatchlistRepo.vmsmodule);
		JavascriptExecutor visitorsexe = (JavascriptExecutor) driver;
		visitorsexe.executeScript("arguments[0].click();", WatchlistRepo.visitorsmenuicon);
		JavascriptExecutor onlocationmenuexe = (JavascriptExecutor) driver;
		onlocationmenuexe.executeScript("arguments[0].click();", WatchlistRepo.onlocationmenu);
	}

	public void add_visitor_watchlist() {

		List<WebElement> visitorslist = driver.findElements(By.xpath("//table//tbody//tr"));
		int visitorscount = visitorslist.size();

		if (visitorscount >= 1) {

			WebElement addwatchlisticon = driver
					.findElement(By.xpath("//table//tbody//tr[1]//td//a[contains(@id,'locate_grid_editWatchlist')]"));
			JavascriptExecutor addwatchlistexe = (JavascriptExecutor) driver;
			addwatchlistexe.executeScript("arguments[0].click();", addwatchlisticon);
			System.out.print("\n" + "Watchlist icon clicked");

		} else {

			System.out.print("\n" + "There are no visitors in onlocation");
		}

	}

	public void select_watchlist_save() throws InterruptedException {
		

		WebElement watchlistelement = driver.findElement(By.id("onLocation_watchlist_dropdown"));
		boolean visible = watchlistelement.isDisplayed();
		if (visible == true) {
			Select watchlistdropdown = new Select(watchlistelement);
			watchlistdropdown.selectByIndex(1);
		} else {
			System.out.print("\n" + "watchlist dropdown element not visible in dom");
			driver.navigate().refresh();
			Thread.sleep(2000);
			Select watchlistdropdown = new Select(watchlistelement);
			watchlistdropdown.selectByIndex(1);
		}
		JavascriptExecutor watchlistaddexe = (JavascriptExecutor) driver;
		watchlistaddexe.executeScript("arguments[0].click();", WatchlistRepo.updatevisitor);

	}

	public void Login_assisted_onlocation() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		Thread.sleep(2000);
		PageFactory.initElements(driver,Locationmgmtrepo.class);
		PageFactory.initElements(driver, PendingcheckinsRepo.class);
		// System.out.print("\n"+"customer code in loginassisted method:"+customercode);
		boolean addonoption=PendingcheckinsRepo.addaonlocationmodal.isDisplayed();
	if	(addonoption==true) {
		System.out.print("\n"+"addon location modal available.");
		
	}else {
		Cookie cookie = driver.manage().getCookieNamed("accessauth");
		String cookiename = cookie.getValue();
		String cookiedomain = cookie.getDomain();

		String getdeviceurl = "https://" + cookiedomain + "/api/get_devices.php";
		HttpResponse<JsonNode> deviceresponse = Unirest.post(getdeviceurl).header("Authorization", cookiename).asJson();

		System.out.print("\n" + "sync code api response: " + deviceresponse.getBody());

		JSONArray devicecodes = deviceresponse.getBody().getObject().getJSONObject("data").getJSONArray("kiosks");
		int size = devicecodes.length();
		// int first=devicecodes(1);
		int datasize = devicecodes.length();
		String devicecode;
		String customer_code = ""; 
		String devicestatus;
		String branchid = "";
		System.out.print("\n" + "number of records" + datasize);
		for (int i = 0; i < datasize; i++) {

			devicecode = devicecodes.getJSONObject(i).getString("device_sync_code");
			devicestatus = devicecodes.getJSONObject(i).getString("device_status");
			branchid = devicecodes.getJSONObject(i).getString("branch_id");
			System.out.print("\n" + "device code and device status:" + devicecode + " , " + devicestatus);
			if (devicestatus.contains("init")) {

				System.out.print("\n" + "device code and device status:" + devicecode + " ," + devicestatus);

				// System.out.print("\n"+"Customer code : "+ customer_code);
				Login login = new Login();
				login.LaunchBrowser();
				driver.get(assistedurl);
				driver.manage().window().maximize();
				driver.navigate().refresh();
				Thread.sleep(3000);

				String url = "https://" + cookiedomain + "/api/get_session_data.php";
				HttpResponse<JsonNode> response = Unirest.post(url).header("Authorization", cookiename).asJson();

				customer_code = response.getBody().getObject().getJSONObject("data").getString("customer_code");
				System.out.print("\n" + "Customer code : " + customer_code);
				branchid = devicecodes.getJSONObject(i).getString("branch_id");
				driver.findElement(By.id("customer_code")).sendKeys(customer_code);
				driver.findElement(By.id("device_sync_code")).sendKeys(devicecode);
				WebElement nextbutton = driver.findElement(By.id("assistedLogin_next"));
				// PackagedeliveryRepo.sessioncustomercode.sendKeys("1234");

				// PackagedeliveryRepo.sessioncustomercode.sendKeys(customercode);
				// PackagedeliveryRepo.synccode.sendKeys(devicecode);
				JavascriptExecutor assistedloginnext = (JavascriptExecutor) driver;
				assistedloginnext.executeScript("arguments[0].click();", nextbutton);
				Thread.sleep(3000);
				WebElement donebutton = driver.findElement(By.id("assistedLogin_done"));
				JavascriptExecutor packagelogindone = (JavascriptExecutor) driver;
				packagelogindone.executeScript("arguments[0].click();", donebutton);

				break;

			}

		}
	}}

	public void select_visitor_record() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		Thread.sleep(2000);
		List<WebElement> visitorrecords = driver.findElements(By.xpath("//table//tbody//tr"));
		int recordscount = visitorrecords.size();
		System.out.print("\n" + "no of records:" + recordscount);
		if (recordscount == 0) {
			System.out.print("\n" + "There are no records in onlocation");

		} else {
			WebElement firstrecord = driver.findElement(By.xpath("//table//tbody//tr[1]"));
			JavascriptExecutor firstrecordexe = (JavascriptExecutor) driver;
			firstrecordexe.executeScript("arguments[0].click();", firstrecord);
			WebElement editicon = driver.findElement(By
					.xpath("//table//tbody//tr[2]//td//div//button[contains(@id,'onLocation_editVisitorWatchList')]"));
			JavascriptExecutor editiconexe = (JavascriptExecutor) driver;
			editiconexe.executeScript("arguments[0].click();", editicon);
		}

	}

	public void update_watchlist() {

		WebElement updatewatchlist = driver
				.findElement(By.xpath("//table//tbody//tr[2]//td//div//select[contains(@id,'watch_list')]"));
		Select watchlistdropdown = new Select(updatewatchlist);
		watchlistdropdown.selectByIndex(1);

		WebElement updatebutton = driver.findElement(
				By.xpath("//table//tbody//tr[2]//td//div//button[contains(@id,'onLocation_watchListUpdate')]"));
		JavascriptExecutor updatebuttonexe = (JavascriptExecutor) driver;
		updatebuttonexe.executeScript("arguments[0].click();", updatebutton);

		System.out.print("\n" + "watchlist added to visitor");

	}

	public void verify_checkin() throws InterruptedException, IOException {

		PageFactory.initElements(driver, WatchlistRepo.class);
		String name = driver.findElement(By.xpath("//table//tbody//tr[1]//td[2]")).getText();
		String phonenumber = driver.findElement(By.xpath("//table//tbody//tr[1]//td[4]")).getText();
		String mailid = driver.findElement(By.xpath("//table//tbody//tr[1]//td[8]")).getText();
		System.out.print("\n" + "watch list visitor details" + name + ";" + phonenumber + ";" + mailid);
		Login login2 = new Login();
		login2.LaunchBrowser();

		Sign_in signin = new Sign_in();
		signin.loginwith_credentials();

		String title = driver.getTitle();
		System.out.print("\n" + "title of portal is:" + title);

		WebElement productsicon = driver.findElement(By.id("header_products"));
		JavascriptExecutor productsexe = (JavascriptExecutor) driver;
		productsexe.executeScript("arguments[0].click();", productsicon);
		WebElement vmselement = driver.findElement(By.id("header_switchProducts_vms"));
		JavascriptExecutor vmsexe = (JavascriptExecutor) driver;
		vmsexe.executeScript("arguments[0].click()", vmselement);
		JavascriptExecutor visitorpassexe=(JavascriptExecutor) driver;
		visitorpassexe.executeScript("arguments[0].click()", WatchlistRepo.visitorpass);
		JavascriptExecutor createpassexe=(JavascriptExecutor) driver;
		createpassexe.executeScript("arguments[0].click();",WatchlistRepo.createvisitorpass);
		Select visitortype=new Select(driver.findElement(By.id("checkin_type")));
		visitortype.selectByIndex(1);
		WatchlistRepo.inviteemail.sendKeys(mailid);
		WatchlistRepo.invitename.sendKeys(name);
		JavascriptExecutor dateexe=(JavascriptExecutor) driver;
		dateexe.executeScript("arguments[0].click();",WatchlistRepo.invitedate);
		WebElement todaybutton=driver.findElement(By.xpath("//div[@id='invite_date_root']//button[contains(text(),'Today')]"));
		JavascriptExecutor buttontodayexe=(JavascriptExecutor) driver;
		buttontodayexe.executeScript("arguments[0].click();",todaybutton);
		WebElement OKbutton=driver.findElement(By.xpath("//div[@id='invite_date_root']//button[contains(text(),'Ok')]"));
		JavascriptExecutor buttonokexe=(JavascriptExecutor) driver;
		buttonokexe.executeScript("arguments[0].click();",OKbutton);
		JavascriptExecutor timeexe=(JavascriptExecutor) driver;
		timeexe.executeScript("arguments[0].click();",WatchlistRepo.invitetime);
		
		
		//div[@id='invite_date_root']//button[contains(text(),'Ok')]
		
	}

}
