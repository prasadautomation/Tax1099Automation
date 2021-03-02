package Fidentity_pages;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Common.Fid_base;
import Object_repo.BillingmanagementRepo;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.json.JSONArray;

public class BillingManagement extends Fid_base {

	static String plantype;

	static String interval;
	static String trailstatus;
	static String schedule_status;

	@Test(enabled = true)

	public void nav_billing() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		PageFactory.initElements(driver, BillingmanagementRepo.class);
		Thread.sleep(2000);
		JavascriptExecutor myorgexe = (JavascriptExecutor) driver;
		myorgexe.executeScript("arguments[0].click()", BillingmanagementRepo.myorgicon);

		JavascriptExecutor billexe = (JavascriptExecutor) driver;
		myorgexe.executeScript("arguments[0].click()", BillingmanagementRepo.billingmenu);
		Thread.sleep(2000);

		/*
		 * ChromeOptions options = new ChromeOptions();
		 * options.setCapability(CapabilityType.HAS_NATIVE_EVENTS, false);
		 * 
		 * WebElement element = driver .findElement(By.
		 * xpath("//ul[@class='w-menu-two']//li//a[@data-tooltip='My Organisation']"));
		 * Actions actions = new Actions(driver);
		 * actions.moveToElement(element).click().perform(); Thread.sleep(2000);
		 * 
		 * // WebDriverWait wait = new WebDriverWait(driver, 120); //
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * "//div[@id='show_org']//div/span[3]//a"))); /* WebElement element2 =
		 * driver.findElement(By.
		 * xpath("//div[@id='show_org']//a[contains(text(),'Billing Management')]"));
		 * Actions actions2 = new Actions(driver);
		 * actions2.moveToElement(element2).click(element2).perform();
		 */
		// driver.findElement(By.xpath("//div[@id='show_org']//a[contains(text(),'Billing
		// Management')]")).click();

		/*
		 * WebElement billicon=driver.findElement(By.
		 * xpath("//div[@id='show_org']//a[contains(text(),'Billing Management')]"));
		 * WebDriverWait wait4 = new WebDriverWait(driver, 30);
		 * wait4.until(ExpectedConditions.elementToBeClickable(billicon));
		 * billicon.click();
		 */
		/*
		 * WebElement billicon = driver .findElement(By.
		 * xpath("//div[@id='show_org']//a[contains(text(),'Billing Management')]"));
		 * JavascriptExecutor billiconEXE = (JavascriptExecutor) driver;
		 * billiconEXE.executeScript("arguments[0].click();", billicon);
		 * 
		 * System.out.print("\n" + "billing management clicked"); Thread.sleep(5000); //
		 * driver.findElement(By.xpath("//div//span//a[contains(text(),'Manage //
		 * Subscription')]")).click();
		 * 
		 * driver.findElement(By.
		 * xpath("//div[@id='billing_features']//a[contains(text(),'Manage Subscription')]"
		 * )) .click(); // driver.navigate().refresh(); // choose different plan
		 * Thread.sleep(3000);
		 */

	}

	public void overview() {

		JavascriptExecutor billview = (JavascriptExecutor) driver;
		billview.executeScript("arguments[0].click()", BillingmanagementRepo.overview);

	}

	public void billdetails() {
		// WebElement billdetails=driver.findElement(By.xpath("//a"))
		JavascriptExecutor detailsexe = (JavascriptExecutor) driver;
		detailsexe.executeScript("arguments[0].click()", BillingmanagementRepo.billdetails);
	}

	public void billhistory() {

		JavascriptExecutor billhistory = (JavascriptExecutor) driver;
		billhistory.executeScript("arguments[0].click()", BillingmanagementRepo.billhistory);

	}

	public void billestimate() {

		JavascriptExecutor billestimate = (JavascriptExecutor) driver;
		billestimate.executeScript("arguments[0].click()", BillingmanagementRepo.billestimate);
	}

	public void manage_subscription() throws InterruptedException {

		JavascriptExecutor managesubexe = (JavascriptExecutor) driver;
		managesubexe.executeScript("arguments[0].click()", BillingmanagementRepo.managesubscription);
		Thread.sleep(2000);
	}

	public void cancel_subscription() {
		JavascriptExecutor cancelsubexe = (JavascriptExecutor) driver;
		cancelsubexe.executeScript("arguments[0].click()", BillingmanagementRepo.cancelsubscription);
	}

	public void notconfirm_cancel() {
		JavascriptExecutor notconfirmexe = (JavascriptExecutor) driver;
		notconfirmexe.executeScript("arguments[0].click()", BillingmanagementRepo.notconfirmcancel);

	}

	public void selectdiff_plan() {
		JavascriptExecutor selectexe = (JavascriptExecutor) driver;
		selectexe.executeScript("arguments[0].click()", BillingmanagementRepo.selectdifferentplan);
	}

	public void downgrade_plan() throws InterruptedException {

		// check whether customer is in trail period
		// get the current plan
		// and find lower plan than current plan and subscribe

		Cookie cookie = driver.manage().getCookieNamed("accessauth");

		System.out.print("\n" + "cookie " + cookie);
		String cookiename = cookie.getValue();
		String cookiedomain = cookie.getDomain();
		System.out.print("\n" + "cookiename: " + cookiename);
		System.out.print("\n" + "cookiedomain: " + cookiedomain);

		String url = "https://" + cookiedomain + "/api/get_customer_plan_details.php";
		HttpResponse<JsonNode> response = Unirest.post(url).header("Authorization", cookiename).asJson();
		System.out.print("\n" + "api response: " + response.getBody());

		String trailplan = response.getBody().getObject().getJSONObject("data").getString("free_trail");
		boolean planpresent = trailplan.matches("true");
		System.out.print("\n" + "customer is in trail period:" + planpresent);
		if (planpresent = true) {
			// System.out.print("\n"+"customer is in trail period:"+planpresent);
			JSONArray planname = response.getBody().getObject().getJSONObject("data")
					.getJSONObject("subscription_details").getJSONArray("subscription_line_items");
			String plancategory = planname.getJSONObject(0).getJSONObject("plan_details").getString("plan_category");
			// .getJSONObject(""").getJSONObject("plan_details").getString("plan_category");
			System.out.print("\n" + "Plan category is :" + plancategory);

			if (plancategory.equalsIgnoreCase("premium")) {

				System.out.print("\n" + "Plan is premium then can down grade to standard");
//		String stdannual="Annual";
				Thread.sleep(2000);
				selectdiff_plan();
				Select stddropdown = new Select(driver.findElement(By.id("choosePlans_plan_standard")));
				Thread.sleep(2000);
				stddropdown.selectByIndex(0);
				System.out.print("\n" + "Selected standard annual plan");
				JavascriptExecutor choosestdexe = (JavascriptExecutor) driver;
				choosestdexe.executeScript("arguments[0].click()", BillingmanagementRepo.choosestdbutton);
				JavascriptExecutor updateexe = (JavascriptExecutor) driver;
				updateexe.executeScript("arguments[0].click()", BillingmanagementRepo.updatesubscription);
				JavascriptExecutor confirmchange = (JavascriptExecutor) driver;
				confirmchange.executeScript("arguments[0].click()", BillingmanagementRepo.confirmchangesub);
				Thread.sleep(2000);
				// driver.navigate().refresh();
				JavascriptExecutor reloadexe = (JavascriptExecutor) driver;
				reloadexe.executeScript("arguments[0].click()", BillingmanagementRepo.reloadbutton);
				Thread.sleep(2000);

			} else {
				System.out.print("\n" + "Plan is already downgrade(standard) then we cannot down grade");
			}
		} else {
			System.out.print(
					"\n" + "Customer is in trail period this testcase verifies downgrade plan for paid customer");
		}
		// int first=devicecodes(1);
//	int datasize=devicecodes.length();
		// String devicecode;
		// String devicestatus;
		// System.out.print("\n" + "number of records" + datasize);

	}

	public void upgarde_plan() throws InterruptedException {

		Cookie cookie = driver.manage().getCookieNamed("accessauth");

		System.out.print("\n" + "cookie " + cookie);
		String cookiename = cookie.getValue();
		String cookiedomain = cookie.getDomain();
		System.out.print("\n" + "cookiename: " + cookiename);
		System.out.print("\n" + "cookiedomain: " + cookiedomain);

		String url = "https://" + cookiedomain + "/api/get_customer_plan_details.php";
		HttpResponse<JsonNode> response = Unirest.post(url).header("Authorization", cookiename).asJson();
		System.out.print("\n" + "api response: " + response.getBody());

		String trailplan = response.getBody().getObject().getJSONObject("data").getString("free_trail");
		boolean planpresent = trailplan.matches("true");
		System.out.print("\n" + "customer is in trail period:" + planpresent);
		if (planpresent = true) {
			// System.out.print("\n"+"customer is in trail period:"+planpresent);
			JSONArray planname = response.getBody().getObject().getJSONObject("data")
					.getJSONObject("subscription_details").getJSONArray("subscription_line_items");
			String plancategory = planname.getJSONObject(0).getJSONObject("plan_details").getString("plan_category");
			// .getJSONObject(""").getJSONObject("plan_details").getString("plan_category");
			System.out.print("\n" + "Plan category is :" + plancategory);

			if (plancategory.equalsIgnoreCase("standard")) {

				System.out.print("\n" + "Plan is standard then can upgrade to premium");
//			String stdannual="Annual";
				Thread.sleep(2000);
				selectdiff_plan();
				Select premiumdropdown = new Select(driver.findElement(By.id("choosePlans_plan_premium")));
				Thread.sleep(2000);
				premiumdropdown.selectByIndex(0);
				System.out.print("\n" + "Selected premium annual plan");
				JavascriptExecutor choospremexe = (JavascriptExecutor) driver;
				choospremexe.executeScript("arguments[0].click()", BillingmanagementRepo.choosepremiumplan);
				JavascriptExecutor updateexe = (JavascriptExecutor) driver;
				updateexe.executeScript("arguments[0].click()", BillingmanagementRepo.updatesubscription);
				JavascriptExecutor confirmchange = (JavascriptExecutor) driver;
				confirmchange.executeScript("arguments[0].click()", BillingmanagementRepo.confirmchangesub);
				Thread.sleep(2000);
				// driver.navigate().refresh();
				JavascriptExecutor reloadexe = (JavascriptExecutor) driver;
				reloadexe.executeScript("arguments[0].click()", BillingmanagementRepo.reloadbutton);
				Thread.sleep(2000);

			} else {
				System.out.print("\n" + "Plan is already upgrade(premium) then we cannot upgrade");
			}
		} else {
			System.out.print(
					"\n" + "Customer is in trail period this testcase verifies downgrade plan for paid customer");
		}
		// int first=devicecodes(1);
//		int datasize=devicecodes.length();
		// String devicecode;
		// String devicestatus;
		// System.out.print("\n" + "number of records" + datasize);

	}

	public void trail_sameplan() {

		JavascriptExecutor sameplanexe = (JavascriptExecutor) driver;
		sameplanexe.executeScript("arguments[0].click()", BillingmanagementRepo.chosesameplantrail);
	}

	public void card_details() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		PageFactory.initElements(driver, BillingmanagementRepo.class);
		BillingmanagementRepo.cardholdername.sendKeys("sree");
		System.out.print("\n" + "Entered card holders name");
		Thread.sleep(4000);
		driver.switchTo().frame(1);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("card-number")));

		Thread.sleep(10000);
		element.sendKeys("4242424242424242");

		BillingmanagementRepo.cardexpiry.sendKeys("0725");
		driver.switchTo().defaultContent();
		Thread.sleep(2000);

		WebElement cvcframe = driver.findElement(By.xpath("//div[@id='card-cvc']//iframe"));
		driver.switchTo().frame(cvcframe);
		System.out.print("\n" + "Switched to cvc frame");
		driver.findElement(By.xpath("//input[contains(@name,'cvc')]")).sendKeys("123");
		// driver.switchTo().frame(driver.findElement(By.xpath("//div[@id='card-cvc']//iframe")));

		driver.switchTo().defaultContent();
		JavascriptExecutor agreeconditionsexe = (JavascriptExecutor) driver;
		agreeconditionsexe.executeScript("arguments[0].click()", BillingmanagementRepo.agreeconditions);
		JavascriptExecutor cardsubmitexe = (JavascriptExecutor) driver;
		cardsubmitexe.executeScript("arguments[0].click()", BillingmanagementRepo.submitcarddetails);
	}

	public void edit_carddetails() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		PageFactory.initElements(driver, BillingmanagementRepo.class);
		// JavascriptExecutor editcardexe=(JavascriptExecutor)driver;
		// editcardexe.executeScript("arguments[0].click()",BillingmanagementRepo.editcard);
		BillingmanagementRepo.editcard.click();
		System.out.print("\n" + "Clicked edit card in billing detials");
		BillingmanagementRepo.cardholdername.sendKeys("sreeedit");
		System.out.print("\n" + "Entered card holders name");
		Thread.sleep(4000);
		WebElement cardnumberframe = driver.findElement(By.xpath("//div[@id='card-number']//iframe"));
		driver.switchTo().frame(cardnumberframe);
		Thread.sleep(3000);
		System.out.print("\n" + "swithced to frame one for card number");
		Thread.sleep(2000);
		WebElement cardnumber = driver.findElement(
				By.xpath("//div[contains(@class,'CardNumber')]//span//input[contains(@name,'cardnumber')] "));

		// String number = "4242424242424242";
		// cardnumber.sendKeys(number);

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].value='4242424242424242';", cardnumber);

		System.out.print("\n" + "Entered card number");
		/*
		 * WebDriverWait wait = new WebDriverWait(driver, 40); WebElement element =
		 * wait.until(
		 * ExpectedConditions.presenceOfElementLocated(By.name("cardnumber")));
		 * 
		 * Thread.sleep(10000); element.sendKeys("4242424242424242");
		 */
		driver.switchTo().defaultContent();
	//	Thread.sleep(3000);
		WebElement cardexpiryframe = driver.findElement(By.xpath("//div[contains(@id,'card-expiry')]//iframe"));
		driver.switchTo().frame(cardexpiryframe);
		WebElement cardexpiry = driver.findElement(By.xpath("//input[contains(@name,'exp-date')]"));
		cardexpiry.sendKeys("0725");
		driver.switchTo().defaultContent();
		Thread.sleep(2000);

		WebElement cvcframe = driver.findElement(By.xpath("//div[@id='card-cvc']//iframe"));
		driver.switchTo().frame(cvcframe);
		System.out.print("\n" + "Switched to cvc frame");
		driver.findElement(By.xpath("//input[contains(@name,'cvc')]")).sendKeys("123");
		// driver.switchTo().frame(driver.findElement(By.xpath("//div[@id='card-cvc']//iframe")));

		driver.switchTo().defaultContent();
		JavascriptExecutor agreeconditionsexe = (JavascriptExecutor) driver;
		agreeconditionsexe.executeScript("arguments[0].click()", BillingmanagementRepo.agreeconditions);
		JavascriptExecutor cardsubmitexeedit = (JavascriptExecutor) driver;
		cardsubmitexeedit.executeScript("arguments[0].click()", BillingmanagementRepo.carddetailssubmit);
	}

	public void billingMgmt_sameplan() throws InterruptedException, ClassNotFoundException, SQLException {
		// System.out.print("billing managemnt started");

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		DataBase_connection db = new DataBase_connection();
		db.dbconnection();

		ResultSet rs = db.stmt.executeQuery(
				"select a.customer_id,b.trail_status,b.status,c.plan_code,d.plan_category,d.interval_unit,b.is_next_schedule from test_checkon_central.customers a inner join test_checkon_central.customer_subscriptions_v2 b inner join \r\n"
						+ "test_checkon_central.customer_subscriptions_line_items_v2 c inner join test_checkon_central.plans_v2 d on a.customer_id=b.customer_id and  b.customer_id=c.customer_id and c.plan_code=d.plan_code and a.checkon_website_address=\"https://test-s2284.fidentity.com/\";");
// SELECT * FROM test_user_management.users where email='sridevi903@srtest.com';
		System.out.println(rs);
		if (rs.next()) {
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

				driver.findElement(By.xpath("//input[@id='cardholdername']")).sendKeys("SreeTest");
				Thread.sleep(2000);
				// List<WebElement>
				// frames=driver.findElements(By.xpath("//div[@id='card-number']//iframe"));
				// int iframessize=frames.size();
				// System.out.println("\n"+"Number of iframes are : "+iframessize);
				driver.switchTo().frame(1);
				driver.findElement(By.xpath("//form//span//input[contains(@name,'cardnumber')]"))
						.sendKeys("4242424242424242");

				// driver.findElement(By.tagName("//div[@id='card-expiry']//div"));
				// WebElement frame =
				// driver.findElement(By.xpath("//div[@id='card-element']//div[@id='card-expiry']//div//iframe"));
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[contains(@name,'exp-date')]")).sendKeys("0223");
				driver.switchTo().defaultContent();
				Thread.sleep(2000);
				WebElement cvcframe = driver.findElement(By.xpath("//div[@id='card-cvc']//iframe"));
				driver.switchTo().frame(cvcframe);
				System.out.print("\n" + "Switched to cvc frame");
				driver.findElement(By.xpath("//input[contains(@name,'cvc')]")).sendKeys("123");
				// driver.switchTo().frame(driver.findElement(By.xpath("//div[@id='card-cvc']//iframe")));

				driver.switchTo().defaultContent();
				WebElement agree = driver.findElement(By.xpath("//div[contains(@class,'credit-card-footer')]//label"));
				JavascriptExecutor agreexe = (JavascriptExecutor) driver;
				agreexe.executeScript("arguments[0].click();", agree);
				Thread.sleep(3000);

				// driver.switchTo().frame(0);
//---------------------for testing--------------------------------------//							
				WebElement backbutton = driver
						.findElement(By.xpath("//div[contains(@class,'left-box')]//a[contains(@class,'back-button')]"));
				JavascriptExecutor backbuttonexe = (JavascriptExecutor) driver;
				backbuttonexe.executeScript("arguments[0].click();", backbutton);
				System.out.print("Plan is not submitted for testing purpose ");

			} else {
				System.out.print("\n" + "Current plan and interval:" + plantype + "-" + interval);
			}
		}

	}

	public void choose_stdmonthly_plan() throws ClassNotFoundException, SQLException, InterruptedException {
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		DataBase_connection db = new DataBase_connection();
		db.dbconnection();

		ResultSet rs = db.stmt.executeQuery(
				"select a.customer_id,b.trail_status,b.status,c.plan_code,d.plan_category,d.interval_unit,b.is_next_schedule from test_checkon_central.customers a inner join test_checkon_central.customer_subscriptions_v2 b inner join \r\n"
						+ "test_checkon_central.customer_subscriptions_line_items_v2 c inner join test_checkon_central.plans_v2 d on a.customer_id=b.customer_id and  b.customer_id=c.customer_id and c.plan_code=d.plan_code and a.checkon_website_address=\"https://test-s2284.fidentity.com/\";");
//SELECT * FROM test_user_management.users where email='sridevi903@srtest.com';
		System.out.println(rs);
		if (rs.next()) {
			String plantype = rs.getString("plan_category");
			String interval = rs.getString("interval_unit");
			String trailstatus = rs.getString("trail_status");
			String schedule_status = rs.getString("is_next_schedule");

			if (trailstatus.equals("1") && schedule_status.equals("1")) {
				System.out.print("\n" + "Customer is in trail period and scheduled next plan;");
			}
			if (trailstatus.equals("1") && schedule_status.equals("0")) {
				System.out.print("\n" + "Customer is in trail period and not scheduled next plan;");

//---------------------Choose different plan----------------------------//				
				WebElement diffplan = driver.findElement(
						By.xpath("//form[@id='license_form']//a[contains(text(),'Choose Different Plan')]"));
				JavascriptExecutor diffplanexe = (JavascriptExecutor) driver;
				diffplanexe.executeScript("arguments[0].click();", diffplan);
				Select stdplan = new Select(driver.findElement(By.xpath("//div[@id='standard-box']//select")));
				stdplan.selectByValue("plan_FkPhtD0pMsHDOY");
				WebElement monthlyplan = driver.findElement(By.xpath("//a[@id='choose-standard']"));
				JavascriptExecutor monthlyplanexe = (JavascriptExecutor) driver;
				monthlyplanexe.executeScript("arguments[0].click();", monthlyplan);

				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@id='cardholdername']")).sendKeys("SreeTest");
				Thread.sleep(2000);
				// List<WebElement>
				// frames=driver.findElements(By.xpath("//div[@id='card-number']//iframe"));
				// int iframessize=frames.size();
				// System.out.println("\n"+"Number of iframes are : "+iframessize);
				driver.switchTo().frame(1);
				driver.findElement(By.xpath("//form//span//input[contains(@name,'cardnumber')]"))
						.sendKeys("4242424242424242");

				// driver.findElement(By.tagName("//div[@id='card-expiry']//div"));
				// WebElement frame =
				// driver.findElement(By.xpath("//div[@id='card-element']//div[@id='card-expiry']//div//iframe"));
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[contains(@name,'exp-date')]")).sendKeys("0223");
				driver.switchTo().defaultContent();
				Thread.sleep(2000);
				WebElement cvcframe = driver.findElement(By.xpath("//div[@id='card-cvc']//iframe"));
				driver.switchTo().frame(cvcframe);
				// System.out.print("\n" + "Switched to cvc frame");
				driver.findElement(By.xpath("//input[contains(@name,'cvc')]")).sendKeys("123");
				// driver.switchTo().frame(driver.findElement(By.xpath("//div[@id='card-cvc']//iframe")));

				driver.switchTo().defaultContent();
				WebElement agree = driver.findElement(By.xpath("//div[contains(@class,'credit-card-footer')]//label"));
				JavascriptExecutor agreexe = (JavascriptExecutor) driver;
				agreexe.executeScript("arguments[0].click();", agree);
				Thread.sleep(3000);

				// driver.switchTo().frame(0);
//---------------------for testing--------------------------------------//							
				WebElement backbutton = driver
						.findElement(By.xpath("//div[contains(@class,'left-box')]//a[contains(@class,'back-button')]"));
				JavascriptExecutor backbuttonexe = (JavascriptExecutor) driver;
				backbuttonexe.executeScript("arguments[0].click();", backbutton);
				System.out.print("\n" + "Plan is not submitted for testing purpose ");

			} else {
				System.out.print("\n" + "Current plan and interval:" + plantype + "-" + interval);
			}
		}

	}

	public void choose_stdyearly_plan() throws ClassNotFoundException, SQLException, InterruptedException {
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		DataBase_connection db = new DataBase_connection();
		db.dbconnection();

		ResultSet rs = db.stmt.executeQuery(
				"select a.customer_id,b.trail_status,b.status,c.plan_code,d.plan_category,d.interval_unit,b.is_next_schedule from test_checkon_central.customers a inner join test_checkon_central.customer_subscriptions_v2 b inner join \r\n"
						+ "test_checkon_central.customer_subscriptions_line_items_v2 c inner join test_checkon_central.plans_v2 d on a.customer_id=b.customer_id and  b.customer_id=c.customer_id and c.plan_code=d.plan_code and a.checkon_website_address=\"https://test-s2284.fidentity.com/\";");
//SELECT * FROM test_user_management.users where email='sridevi903@srtest.com';
		System.out.println(rs);
		if (rs.next()) {
			String plantype = rs.getString("plan_category");
			String interval = rs.getString("interval_unit");
			String trailstatus = rs.getString("trail_status");
			String schedule_status = rs.getString("is_next_schedule");

			if (trailstatus.equals("1") && schedule_status.equals("1")) {
				System.out.print("\n" + "Customer is in trail period and scheduled next plan;");
			}
			if (trailstatus.equals("1") && schedule_status.equals("0")) {
				System.out.print("\n" + "Customer is in trail period and not scheduled next plan;");

//---------------------Choose different plan----------------------------//				
				WebElement diffplan = driver.findElement(
						By.xpath("//form[@id='license_form']//a[contains(text(),'Choose Different Plan')]"));
				JavascriptExecutor diffplanexe = (JavascriptExecutor) driver;
				diffplanexe.executeScript("arguments[0].click();", diffplan);
				Select stdplan = new Select(driver.findElement(By.xpath("//div[@id='standard-box']//select")));
				stdplan.selectByValue("plan_FkPrByHYLlxtJX");
				WebElement monthlyplan = driver.findElement(By.xpath("//a[@id='choose-standard']"));
				JavascriptExecutor monthlyplanexe = (JavascriptExecutor) driver;
				monthlyplanexe.executeScript("arguments[0].click();", monthlyplan);

				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@id='cardholdername']")).sendKeys("SreeTest");
				Thread.sleep(2000);
				// List<WebElement>
				// frames=driver.findElements(By.xpath("//div[@id='card-number']//iframe"));
				// int iframessize=frames.size();
				// System.out.println("\n"+"Number of iframes are : "+iframessize);
				driver.switchTo().frame(1);
				driver.findElement(By.xpath("//form//span//input[contains(@name,'cardnumber')]"))
						.sendKeys("4242424242424242");

				// driver.findElement(By.tagName("//div[@id='card-expiry']//div"));
				// WebElement frame =
				// driver.findElement(By.xpath("//div[@id='card-element']//div[@id='card-expiry']//div//iframe"));
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[contains(@name,'exp-date')]")).sendKeys("0223");
				driver.switchTo().defaultContent();
				Thread.sleep(2000);
				WebElement cvcframe = driver.findElement(By.xpath("//div[@id='card-cvc']//iframe"));
				driver.switchTo().frame(cvcframe);
				// System.out.print("\n" + "Switched to cvc frame");
				driver.findElement(By.xpath("//input[contains(@name,'cvc')]")).sendKeys("123");
				// driver.switchTo().frame(driver.findElement(By.xpath("//div[@id='card-cvc']//iframe")));

				driver.switchTo().defaultContent();
				WebElement agree = driver.findElement(By.xpath("//div[contains(@class,'credit-card-footer')]//label"));
				JavascriptExecutor agreexe = (JavascriptExecutor) driver;
				agreexe.executeScript("arguments[0].click();", agree);
				Thread.sleep(3000);

				// driver.switchTo().frame(0);
//---------------------for testing--------------------------------------//							
				WebElement backbutton = driver
						.findElement(By.xpath("//div[contains(@class,'left-box')]//a[contains(@class,'back-button')]"));
				JavascriptExecutor backbuttonexe = (JavascriptExecutor) driver;
				backbuttonexe.executeScript("arguments[0].click();", backbutton);
				System.out.print("\n" + "Plan is not submitted for testing purpose ");

			} else {
				System.out.print("\n" + "Current plan and interval:" + plantype + "-" + interval);
			}
		}

	}

	public void choose_premium_yearly_plan() throws ClassNotFoundException, SQLException, InterruptedException {
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		DataBase_connection db = new DataBase_connection();
		db.dbconnection();

		ResultSet rs = db.stmt.executeQuery(
				"select a.customer_id,b.trail_status,b.status,c.plan_code,d.plan_category,d.interval_unit,b.is_next_schedule from test_checkon_central.customers a inner join test_checkon_central.customer_subscriptions_v2 b inner join \r\n"
						+ "test_checkon_central.customer_subscriptions_line_items_v2 c inner join test_checkon_central.plans_v2 d on a.customer_id=b.customer_id and  b.customer_id=c.customer_id and c.plan_code=d.plan_code and a.checkon_website_address=\"https://test-s2284.fidentity.com/\";");
//SELECT * FROM test_user_management.users where email='sridevi903@srtest.com';
		System.out.println(rs);
		if (rs.next()) {
			String plantype = rs.getString("plan_category");
			String interval = rs.getString("interval_unit");
			String trailstatus = rs.getString("trail_status");
			String schedule_status = rs.getString("is_next_schedule");

			if (trailstatus.equals("1") && schedule_status.equals("1")) {
				System.out.print("\n" + "Customer is in trail period and scheduled next plan;");
			}
			if (trailstatus.equals("1") && schedule_status.equals("0")) {
				System.out.print("\n" + "Customer is in trail period and not scheduled next plan;");

//---------------------Choose different plan----------------------------//				
				WebElement diffplan = driver.findElement(
						By.xpath("//form[@id='license_form']//a[contains(text(),'Choose Different Plan')]"));
				JavascriptExecutor diffplanexe = (JavascriptExecutor) driver;
				diffplanexe.executeScript("arguments[0].click();", diffplan);
				Select premiumplan = new Select(driver.findElement(By.xpath("//div[@id='premium-box']//select")));
				premiumplan.selectByValue("plan_FkPrjJyRJkpWJU");
				WebElement annualplan = driver.findElement(By.xpath("//a[@id='choose-premium']"));
				JavascriptExecutor annualplanexe = (JavascriptExecutor) driver;
				annualplanexe.executeScript("arguments[0].click();", annualplan);

				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@id='cardholdername']")).sendKeys("SreeTest");
				Thread.sleep(2000);
				// List<WebElement>
				// frames=driver.findElements(By.xpath("//div[@id='card-number']//iframe"));
				// int iframessize=frames.size();
				// System.out.println("\n"+"Number of iframes are : "+iframessize);
				driver.switchTo().frame(1);
				driver.findElement(By.xpath("//form//span//input[contains(@name,'cardnumber')]"))
						.sendKeys("4242424242424242");

				// driver.findElement(By.tagName("//div[@id='card-expiry']//div"));
				// WebElement frame =
				// driver.findElement(By.xpath("//div[@id='card-element']//div[@id='card-expiry']//div//iframe"));
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[contains(@name,'exp-date')]")).sendKeys("0223");
				driver.switchTo().defaultContent();
				Thread.sleep(2000);
				WebElement cvcframe = driver.findElement(By.xpath("//div[@id='card-cvc']//iframe"));
				driver.switchTo().frame(cvcframe);
				// System.out.print("\n" + "Switched to cvc frame");
				driver.findElement(By.xpath("//input[contains(@name,'cvc')]")).sendKeys("123");
				// driver.switchTo().frame(driver.findElement(By.xpath("//div[@id='card-cvc']//iframe")));

				driver.switchTo().defaultContent();
				WebElement agree = driver.findElement(By.xpath("//div[contains(@class,'credit-card-footer')]//label"));
				JavascriptExecutor agreexe = (JavascriptExecutor) driver;
				agreexe.executeScript("arguments[0].click();", agree);
				Thread.sleep(3000);

				// driver.switchTo().frame(0);
//---------------------for testing--------------------------------------//							
				WebElement backbutton = driver
						.findElement(By.xpath("//div[contains(@class,'left-box')]//a[contains(@class,'back-button')]"));
				JavascriptExecutor backbuttonexe = (JavascriptExecutor) driver;
				backbuttonexe.executeScript("arguments[0].click();", backbutton);
				System.out.print("\n" + "Plan is not submitted for testing purpose ");

			} else {
				System.out.print("\n" + "Current plan and interval:" + plantype + "-" + interval);
			}
		}

	}

	public void choose_plan() {

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebElement sameplan = driver
				.findElement(By.xpath("//form[@id='license_form']//a[contains(text(),'Continue Same Plan')]"));
		JavascriptExecutor sameplanexe = (JavascriptExecutor) driver;
		sameplanexe.executeScript("arguments[0].click();", sameplan);

	}

	public void check_mandatory() throws InterruptedException {
		// ---------------no details given and click on submit---------------//
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebElement agree = driver.findElement(By.xpath("//div[contains(@class,'credit-card-footer')]//label"));
		JavascriptExecutor agreexe = (JavascriptExecutor) driver;
		agreexe.executeScript("arguments[0].click();", agree);

		WebElement submit = driver.findElement(By.xpath("//a[contains(text(),'Submit')]"));
		JavascriptExecutor submitexe = (JavascriptExecutor) driver;
		submitexe.executeScript("arguments[0].click();", submit);

		// ---------------Only name entered and click on submit---------------//

		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='cardholdername']")).sendKeys("SreeTest");
		WebElement agreename = driver.findElement(By.xpath("//input[@id='agree_conditions']/following-sibling::label"));
		JavascriptExecutor agreenamexe = (JavascriptExecutor) driver;
		agreenamexe.executeScript("arguments[0].click();", agreename);
		WebElement submitname = driver.findElement(By.xpath("//a[contains(text(),'Submit')]"));
		JavascriptExecutor submitnamexe = (JavascriptExecutor) driver;
		submitnamexe.executeScript("arguments[0].click();", submitname);

		// ---------------Validation for card number is incomplete---------------//

		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='cardholdername']")).clear();
		driver.findElement(By.xpath("//input[@id='cardholdername']")).sendKeys("SreeTest");
		driver.switchTo().frame(1);
		driver.findElement(By.xpath("//form//span//input[contains(@name,'cardnumber')]")).sendKeys("42424");
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		WebElement incompletecard = driver
				.findElement(By.xpath("//input[@id='agree_conditions']/following-sibling::label"));
		JavascriptExecutor incompletecardexe = (JavascriptExecutor) driver;
		incompletecardexe.executeScript("arguments[0].click();", incompletecard);

		WebElement submitincompletecard = driver.findElement(By.xpath("//a[contains(text(),'Submit')]"));
		JavascriptExecutor submitincompletecardexe = (JavascriptExecutor) driver;
		submitincompletecardexe.executeScript("arguments[0].click();", submitincompletecard);

		// ---------------Without expiry date and cvc---------------//

		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='cardholdername']")).clear();
		driver.findElement(By.xpath("//input[@id='cardholdername']")).sendKeys("SreeTest");
		driver.switchTo().frame(1);
		driver.findElement(By.xpath("//form//span//input[contains(@name,'cardnumber')]"))
				.sendKeys("4242 4242 4242 4242");
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		WebElement noexpire = driver.findElement(By.xpath("//input[@id='agree_conditions']/following-sibling::label"));
		JavascriptExecutor noexpirexe = (JavascriptExecutor) driver;
		noexpirexe.executeScript("arguments[0].click();", noexpire);

		WebElement noexpiresubmit = driver.findElement(By.xpath("//a[contains(text(),'Submit')]"));
		JavascriptExecutor noexpiresubmitexe = (JavascriptExecutor) driver;
		noexpiresubmitexe.executeScript("arguments[0].click();", noexpiresubmit);
	}

	public void check_plan() throws ClassNotFoundException, SQLException {

		DataBase_connection db = new DataBase_connection();
		db.dbconnection();

		ResultSet rs = db.stmt.executeQuery(
				"select a.customer_id,b.trail_status,b.status,c.plan_code,d.plan_category,d.interval_unit,b.is_next_schedule from test_checkon_central.customers a\r\n"
						+ " inner join test_checkon_central.customer_subscriptions_v2 b\r\n"
						+ " inner join test_checkon_central.customer_subscriptions_line_items_v2 c\r\n"
						+ " inner join test_checkon_central.plans_v2 d on a.customer_id=b.customer_id and  b.customer_id=c.customer_id and c.plan_code=d.plan_code  and \r\n"
						+ " a.checkon_website_address=\"https://test-s3377.fidentity.com/\"  and c.status='active' and b.status='active';");
//SELECT * FROM test_user_management.users where email='sridevi903@srtest.com';
		System.out.println(rs);
		if (rs.next()) {
			plantype = rs.getString("plan_category");
			interval = rs.getString("interval_unit");
			trailstatus = rs.getString("trail_status");
			schedule_status = rs.getString("is_next_schedule");

			if (trailstatus.equals("1") && schedule_status.equals("1")) {
				System.out.print("\n" + "Customer is in trail period and scheduled next plan;");
			}
			if (trailstatus.equals("1") && schedule_status.equals("0")) {
				System.out.print("\n" + "Customer is in trail period and no scheduled next plan;");

			}
			if (trailstatus.equals("0") && schedule_status.equals("0")) {
				System.out
						.print("\n" + "Customer is paid customer and his active plan is :" + plantype + "-" + interval);
			}

		}
	}

	public void upgrade_plan() {

		// myOrganization myorg=new myOrganization();

		if (plantype.equals("premium") && interval.equals("month")) {

			WebElement diffplan = driver
					.findElement(By.xpath("//form[@id='license_form']//a[contains(text(),'Choose Different Plan')]"));
			JavascriptExecutor diffplanexe = (JavascriptExecutor) driver;
			diffplanexe.executeScript("arguments[0].click();", diffplan);

			Select premiumplan = new Select(driver.findElement(By.xpath("//div[@id='premium-box']//select")));
			premiumplan.selectByValue("plan_FkPrjJyRJkpWJU");
			WebElement annualplan = driver.findElement(By.xpath("//a[@id='choose-premium']"));
			JavascriptExecutor annualplanexe = (JavascriptExecutor) driver;
			annualplanexe.executeScript("arguments[0].click();", annualplan);

			WebElement choseplan = driver.findElement(By.xpath("//div[@id='premium-box']//a[@id='choose-premium']"));
			JavascriptExecutor choseplanexe = (JavascriptExecutor) driver;
			choseplanexe.executeScript("arguments[0].click();", choseplan);

			WebElement updatesub = driver.findElement(By.xpath("//a[contains(text(),'Update Subscription')]"));
			JavascriptExecutor updatesubexe = (JavascriptExecutor) driver;
			updatesubexe.executeScript("arguments[0].click();", updatesub);

			WebElement OKele = driver
					.findElement(By.xpath("//div[@id='view_payment_status']//a[contains(text(),'Ok')]"));
			JavascriptExecutor OKexe = (JavascriptExecutor) driver;
			OKexe.executeScript("arguments[0].click();", OKele);
			// div[@id='view_payment_status']//a[contains(text(),'Ok')]

			System.out.print("\n" + "Premium monthly plan upgrade to premium yearly plan");

			driver.navigate().refresh();

		} else {
			System.out.print("\n" + "customer is not premium monthly customer");
		}
		if (plantype.equals("standard") && interval.equals("month")) {

			WebElement diffplan = driver
					.findElement(By.xpath("//form[@id='license_form']//a[contains(text(),'Choose Different Plan')]"));
			JavascriptExecutor diffplanexe = (JavascriptExecutor) driver;
			diffplanexe.executeScript("arguments[0].click();", diffplan);

			Select premiumplan = new Select(driver.findElement(By.xpath("//div[@id='standard-box']//select")));
			premiumplan.selectByValue("plan_FkPrByHYLlxtJX");
			WebElement annualplan = driver.findElement(By.xpath("//a[@id='choose-premium']"));
			JavascriptExecutor annualplanexe = (JavascriptExecutor) driver;
			annualplanexe.executeScript("arguments[0].click();", annualplan);

			WebElement choseplan = driver.findElement(By.xpath("//div[@id='standard-box']//a[@id='choose-standard']"));
			JavascriptExecutor choseplanexe = (JavascriptExecutor) driver;
			choseplanexe.executeScript("arguments[0].click();", choseplan);

			WebElement updatesub = driver.findElement(By.xpath("//a[contains(text(),'Update Subscription')]"));
			JavascriptExecutor updatesubexe = (JavascriptExecutor) driver;
			updatesubexe.executeScript("arguments[0].click();", updatesub);

			WebElement OKele = driver
					.findElement(By.xpath("//div[@id='view_payment_status']//a[contains(text(),'Ok')]"));
			JavascriptExecutor OKexe = (JavascriptExecutor) driver;
			OKexe.executeScript("arguments[0].click();", OKele);
			// div[@id='view_payment_status']//a[contains(text(),'Ok')]

			System.out.print("\n" + "Standard monthly plan upgrade to standard yearly plan");

			driver.navigate().refresh();

		} else {
			System.out.print("\n" + "customer is not Standard monthly customer");
		}

		if (plantype.equals("standard") && interval.equals("year")) {

			WebElement diffplan = driver
					.findElement(By.xpath("//form[@id='license_form']//a[contains(text(),'Choose Different Plan')]"));
			JavascriptExecutor diffplanexe = (JavascriptExecutor) driver;
			diffplanexe.executeScript("arguments[0].click();", diffplan);

			Select premiumplan = new Select(driver.findElement(By.xpath("//div[@id='premium-box']//select")));
			premiumplan.selectByValue("plan_FkPhxtQHRqslfy");
			WebElement monthlyplan = driver.findElement(By.xpath("//a[@id='choose-premium']"));
			JavascriptExecutor monthlyplanexe = (JavascriptExecutor) driver;
			monthlyplanexe.executeScript("arguments[0].click();", monthlyplan);

			WebElement choseplan = driver.findElement(By.xpath("//div[@id='premium-box']//a[@id='choose-premium']"));
			JavascriptExecutor choseplanexe = (JavascriptExecutor) driver;
			choseplanexe.executeScript("arguments[0].click();", choseplan);

			WebElement updatesub = driver.findElement(By.xpath("//a[contains(text(),'Update Subscription')]"));
			JavascriptExecutor updatesubexe = (JavascriptExecutor) driver;
			updatesubexe.executeScript("arguments[0].click();", updatesub);

			WebElement OKele = driver
					.findElement(By.xpath("//div[@id='view_payment_status']//a[contains(text(),'Ok')]"));
			JavascriptExecutor OKexe = (JavascriptExecutor) driver;
			OKexe.executeScript("arguments[0].click();", OKele);
			// div[@id='view_payment_status']//a[contains(text(),'Ok')]

			System.out.print("\n" + "Standard yearly plan upgrade to Premium monthly plan");

			driver.navigate().refresh();

		} else {
			System.out.print("\n" + "customer is not Standard yearly customer");
		}
		if (plantype.equals("premium") && interval.equals("year")) {

			System.out.print("\n" + "No need to upgrade premium yearly customer");
		}

	}

	public void olddowngrade_plan() {

		// ---------------down grade premium yearly to standard
		// monthly-----------------//
		if (plantype.equals("premium") && interval.equals("year")) {

			WebElement diffplan = driver
					.findElement(By.xpath("//form[@id='license_form']//a[contains(text(),'Choose Different Plan')]"));
			JavascriptExecutor diffplanexe = (JavascriptExecutor) driver;
			diffplanexe.executeScript("arguments[0].click();", diffplan);

			Select stdplan = new Select(driver.findElement(By.xpath("//div[@id='standard-box']//select")));
			stdplan.selectByValue("plan_FkPhtD0pMsHDOY");

			WebElement stdmonthly = driver.findElement(By.xpath("//a[@id='choose-standard']"));
			JavascriptExecutor stdmonthlyexe = (JavascriptExecutor) driver;
			stdmonthlyexe.executeScript("arguments[0].click();", stdmonthly);

			WebElement updatesub = driver.findElement(By.xpath("//a[contains(text(),'Update Subscription')]"));
			JavascriptExecutor updatesubexe = (JavascriptExecutor) driver;
			updatesubexe.executeScript("arguments[0].click();", updatesub);

			WebElement OKele = driver
					.findElement(By.xpath("//div[@id='view_payment_status']//a[contains(text(),'Ok')]"));
			JavascriptExecutor OKexe = (JavascriptExecutor) driver;
			OKexe.executeScript("arguments[0].click();", OKele);
			// div[@id='view_payment_status']//a[contains(text(),'Ok')]

			System.out.print("\n" + "Premium yearly plan downgrade to standard monthly plan");

			driver.navigate().refresh();

		} else {
			System.out.print("\n" + "Customer is not premium yearly customer");
		}

		if (plantype.equals("premium") && interval.equals("month")) {

			WebElement diffplan = driver
					.findElement(By.xpath("//form[@id='license_form']//a[contains(text(),'Choose Different Plan')]"));
			JavascriptExecutor diffplanexe = (JavascriptExecutor) driver;
			diffplanexe.executeScript("arguments[0].click();", diffplan);

			Select stdplan = new Select(driver.findElement(By.xpath("//div[@id='standard-box']//select")));
			stdplan.selectByValue("plan_FkPhtD0pMsHDOY");

			WebElement stdmonthly = driver.findElement(By.xpath("//a[@id='choose-standard']"));
			JavascriptExecutor stdmonthlyexe = (JavascriptExecutor) driver;
			stdmonthlyexe.executeScript("arguments[0].click();", stdmonthly);

			WebElement updatesub = driver.findElement(By.xpath("//a[contains(text(),'Update Subscription')]"));
			JavascriptExecutor updatesubexe = (JavascriptExecutor) driver;
			updatesubexe.executeScript("arguments[0].click();", updatesub);

			WebElement OKele = driver
					.findElement(By.xpath("//div[@id='view_payment_status']//a[contains(text(),'Ok')]"));
			JavascriptExecutor OKexe = (JavascriptExecutor) driver;
			OKexe.executeScript("arguments[0].click();", OKele);
			// div[@id='view_payment_status']//a[contains(text(),'Ok')]

			System.out.print("\n" + "Premium monthly plan downgrade to standard monthly plan");

			driver.navigate().refresh();

		} else {
			System.out.print("\n" + "Customer is not premium monthly customer");
		}

	}

	public void trailtobasic() throws InterruptedException {

		if (trailstatus.equals("1") && schedule_status.equals("0")) {
			// System.out.print("\n" + "Customer is in trail period and no scheduled next
			// plan;");

			WebElement diffplan = driver
					.findElement(By.xpath("//form[@id='license_form']//a[contains(text(),'Choose Different Plan')]"));
			JavascriptExecutor diffplanexe = (JavascriptExecutor) driver;
			diffplanexe.executeScript("arguments[0].click();", diffplan);

			WebElement basicplan = driver.findElement(By.xpath("//a[@id='choose-basic']"));
			JavascriptExecutor basicplanexe = (JavascriptExecutor) driver;
			basicplanexe.executeScript("arguments[0].click();", basicplan);
			Thread.sleep(2000);
			if (basicplan.isDisplayed()) {

				WebElement basicplanr = driver.findElement(By.xpath("//a[@id='choose-basic']"));
				JavascriptExecutor basicplanexer = (JavascriptExecutor) driver;
				basicplanexer.executeScript("arguments[0].click();", basicplanr);
			}
			System.out.print("\n" + "For testing purpose not updating plan");
			WebElement backbutton = driver.findElement(By.xpath("//a[contains(text(),'Back')]"));
			JavascriptExecutor backbuttonexe = (JavascriptExecutor) driver;
			backbuttonexe.executeScript("arguments[0].click();", backbutton);

			// System.out.print("Plan is not submitted for testing purpose ");

		}

	}
}
