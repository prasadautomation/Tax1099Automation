package Fidentity_pages;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Common.Fid_base;
import Object_repo.Locationmgmtrepo;
import Object_repo.PackagedeliveryRepo;
import Object_repo.PendingcheckinsRepo;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.json.JSONArray;

public class Packagedelivery extends Fid_base {


	public static final Logger log = LogManager.getLogger(Packagedelivery.class);

//	public String customercode;

	public void navigate_packagedelivery() {
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		PageFactory.initElements(driver, PackagedeliveryRepo.class);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		PageFactory.initElements(driver, PackagedeliveryRepo.class);
		JavascriptExecutor producticonexe = (JavascriptExecutor) driver;
		producticonexe.executeScript("arguments[0].click();", PackagedeliveryRepo.productsicon);
//WebElement packagesidebarmenu=driver.findElement(By.xpath("//a[@id='assistedSidebar_packageDelivery']"));
		WebElement packagesidebarmenu = driver.findElement(By.id("header_switchProducts_package"));

		String packagedeliverytext = packagesidebarmenu.getText();
		System.out.print("\n" + "package delivery text:" + packagedeliverytext);
		JavascriptExecutor packageproductexe = (JavascriptExecutor) driver;
		packageproductexe.executeScript("arguments[0].click();", packagesidebarmenu);

	}

	public void createPackageKiosk() {

		JavascriptExecutor kioskmenuexe = (JavascriptExecutor) driver;
		kioskmenuexe.executeScript("arguments[0].click();", PackagedeliveryRepo.unlicencedkiosk);
		driver.navigate().refresh();
		JavascriptExecutor createkioskexe = (JavascriptExecutor) driver;
		createkioskexe.executeScript("arguments[0].click();", PackagedeliveryRepo.createkioskbutton);
	}

	public void kiosk_details() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);

		/*
		 * 
		 * boolean result = false; int attempts = 0; while(attempts < 2) { try { Select
		 * dropdown=new Select(driver.findElement(By.id("pwa_device_branch")));
		 * dropdown.selectByIndex(1); result = true; break; }
		 * catch(StaleElementReferenceException e) { } attempts++; }
		 */
		// WebElement locationdropdown=driver.findElement(By.id("pwa_device_branch"));
		// Select dropdown=new Select(driver.findElement(By.id("pwa_device_branch")));
		WebDriverWait wait;

		wait = new WebDriverWait(driver, 30);

		WebElement element = wait
				.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("pwa_device_branch"))));
		Select dropdown = new Select(element);
		dropdown.selectByIndex(1);
		Thread.sleep(2000);
		System.out.print("\n" + "seleted location");
		// WebElement storedropdown=driver.findElement(By.id("pwa_store_id"));

		Select storeroomdropdown = new Select(driver.findElement(By.id("pwa_store_id")));
		storeroomdropdown.selectByIndex(1);
		System.out.print("\n" + "seleted store");
		Thread.sleep(2000);
		PackagedeliveryRepo.aliasnametext.sendKeys("stest");

		Thread.sleep(2000);
		// JavascriptExecutor kioskcreateexe = (JavascriptExecutor) driver;
		// kioskcreateexe.executeScript("arguments[0].click();",
		// PackagedeliveryRepo.createkioskbutton);
		WebElement createkiosk = driver
				.findElement(By.xpath("//div[@id='add_pwa_device_modal']//a[contains(text(),'Create')]"));
		createkiosk.click();
		System.out.print("\n" + "Clicked create button");
		JavascriptExecutor proceedcreation = (JavascriptExecutor) driver;
		proceedcreation.executeScript("arguments[0].click();", PackagedeliveryRepo.kioskproceed);

	}

	public void kiosk_login() throws InterruptedException {

		PageFactory.initElements(driver, PackagedeliveryRepo.class);

		Cookie cookie = driver.manage().getCookieNamed("accessauth");

		System.out.print("\n" + "cookie " + cookie);
		String cookiename = cookie.getValue();
		String cookiedomain = cookie.getDomain();
		System.out.print("\n" + "cookiename: " + cookiename);
		System.out.print("\n" + "cookiedomain: " + cookiedomain);

		String url = "https://" + cookiedomain + "/api/get_session_data.php";
		HttpResponse<JsonNode> response = Unirest.post(url).header("Authorization", cookiename).asJson();
		System.out.print("\n" + "api response: " + response.getBody());
		// customercode =
		// response.getBody().getObject().getJSONObject("data").getString("customer_code");

		// System.out.print("\n" + "customer code " + customercode);

		String getdeviceurl = "https://" + cookiedomain + "/api/sync_codes_get.php";
		HttpResponse<JsonNode> deviceresponse = Unirest.post(getdeviceurl).header("Authorization", cookiename).asJson();

		System.out.print("\n" + "sync code api response: " + deviceresponse.getBody());

		JSONArray devicecodes = deviceresponse.getBody().getObject().getJSONArray("data");
		int size = devicecodes.length();
		// int first=devicecodes(1);
		int datasize = devicecodes.length();
		String devicecode;
		String devicestatus;
		System.out.print("\n" + "number of records" + datasize);
		for (int i = 0; i < datasize; i++) {

			devicecode = devicecodes.getJSONObject(i).getString("device_code");
			devicestatus = devicecodes.getJSONObject(i).getString("status");
			System.out.print("\n" + "device code and device status:" + devicecode + " , " + devicestatus);
			if (devicestatus.contains("init")) {

				System.out.print("\n" + "device code and device status:" + devicecode + " ," + devicestatus);
				String customer_code = response.getBody().getObject().getJSONObject("data").getString("customer_code");
				// System.out.print("\n"+"Customer code : "+ customercode);
				Login login = new Login();
				login.LaunchBrowser();
				driver.get(packagekioskurl);
				driver.manage().window().maximize();
				driver.navigate().refresh();
				driver.findElement(By.id("customer_code")).sendKeys(customer_code);
				driver.findElement(By.id("device_sync_code")).sendKeys(devicecode);
				WebElement nextbutton = driver.findElement(By.id("assistedLogin_next"));
				// PackagedeliveryRepo.sessioncustomercode.sendKeys("1234");

				// PackagedeliveryRepo.sessioncustomercode.sendKeys(customercode);
				// PackagedeliveryRepo.synccode.sendKeys(devicecode);
				JavascriptExecutor assistedloginnext = (JavascriptExecutor) driver;
				assistedloginnext.executeScript("arguments[0].click();", nextbutton);
				Thread.sleep(2000);
				WebElement donebutton = driver.findElement(By.id("assistedLogin_done"));
				JavascriptExecutor packagelogindone = (JavascriptExecutor) driver;
				packagelogindone.executeScript("arguments[0].click();", donebutton);

				break;

			}

		}
	}

	public void storelocationmenu() {

		JavascriptExecutor storelocationexe = (JavascriptExecutor) driver;
		storelocationexe.executeScript("arguments[0].click();", PackagedeliveryRepo.storelocationmenu);

	}

	public void createstore_button() {

		JavascriptExecutor createstoreexe = (JavascriptExecutor) driver;
		createstoreexe.executeScript("arguments[0].click();", PackagedeliveryRepo.createstorebutton);
	}

	public void store_details() {

		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(1000);

		PackagedeliveryRepo.storename.sendKeys("Test" + randomInt);

		PackagedeliveryRepo.storeaddress.sendKeys("Test address" + randomInt);

	}

	public void save_store() {

		JavascriptExecutor savestoreexe = (JavascriptExecutor) driver;
		savestoreexe.executeScript("arguments[0].click();", PackagedeliveryRepo.savestore);
	}

	public void store_actions_menu() {

		JavascriptExecutor storeactionsexe = (JavascriptExecutor) driver;
		storeactionsexe.executeScript("arguments[0].click();", PackagedeliveryRepo.storelocationmenu);

	}

	public void store_delete_item() {

		JavascriptExecutor storedeleteexe = (JavascriptExecutor) driver;
		storedeleteexe.executeScript("arguments[0].click();", PackagedeliveryRepo.storedeleteitem);
	}

	public void select_store_from_list() throws InterruptedException {

		List<WebElement> Locations = driver
				.findElements(By.xpath("//table//tr//td//input[starts-with(@id,'storeLocation')]"));
		// table//tr[1]//td//input[starts-with(@id,'storeLocation')]
		int count = Locations.size();

		System.out.print("\n" + "No of store locations:" + count);

		for (int i = 1; i <= count; i++) {

			WebElement store = driver
					.findElement(By.xpath("//table//tr[" + (i) + "]//td//input[starts-with(@id,'storeLocation')]"));
			JavascriptExecutor storeexe = (JavascriptExecutor) driver;
			storeexe.executeScript("arguments[0].click();", store);
			System.out.print("\n" + "store number:" + i);
			store_actions_menu();
			store_delete_item();
			JavascriptExecutor deleteconfirmexe = (JavascriptExecutor) driver;
			deleteconfirmexe.executeScript("arguments[0].click();", PackagedeliveryRepo.storedeleteconfirm);
			Thread.sleep(2000);
			WebElement transfermodalelement = PackagedeliveryRepo.transfermodal;
			boolean transferelement = transfermodalelement.isDisplayed();

			WebElement transferinfo = PackagedeliveryRepo.transferinformodal;
			boolean transferok = transferinfo.isDisplayed();
			if (transferelement == true) {

				System.out.print("\n" + "store location  has pending packages");
				JavascriptExecutor canceltranfrpackexe = (JavascriptExecutor) driver;
				canceltranfrpackexe.executeScript("arguments[0].click();", PackagedeliveryRepo.tranferpackagecancel);

			} else if (transferok == true) {
				JavascriptExecutor transferokexe = (JavascriptExecutor) driver;
				transferokexe.executeScript("arguments[0].click();", PackagedeliveryRepo.transferokinfo);
				System.out.print("\n" + "Only one store available so we cannot tranfer packages and delete");
				break;
			} else {

				System.out.print("\n" + "store location " + i + " does not have pending packages");
				break;
			}

		}
	}

	public void delete_store_with_packages() throws InterruptedException {

		List<WebElement> Locations = driver
				.findElements(By.xpath("//table//tr//td//input[starts-with(@id,'storeLocation')]"));
		// table//tr[1]//td//input[starts-with(@id,'storeLocation')]
		int count = Locations.size();

		System.out.print("\n" + "Number  of store locations:" + count);

		for (int i = 1; i <= count; i++) {

			WebElement store = driver
					.findElement(By.xpath("//table//tr[" + (i) + "]//td//input[starts-with(@id,'storeLocation')]"));
			JavascriptExecutor storeexe = (JavascriptExecutor) driver;
			storeexe.executeScript("arguments[0].click();", store);
			System.out.print("\n" + "store number:" + i);
			store_actions_menu();
			store_delete_item();
			JavascriptExecutor deleteconfirmexe = (JavascriptExecutor) driver;
			deleteconfirmexe.executeScript("arguments[0].click();", PackagedeliveryRepo.storedeleteconfirm);
			Thread.sleep(2000);
			WebElement transfermodalelement = PackagedeliveryRepo.transfermodal;
			boolean transferelement = transfermodalelement.isDisplayed();

			WebElement transferinfo = PackagedeliveryRepo.transferinformodal;
			boolean transferok = transferinfo.isDisplayed();

			if (transferelement == true) {

				System.out.print("\n" + "store location  has pending packages");
				JavascriptExecutor tranferyesnoexe = (JavascriptExecutor) driver;
				tranferyesnoexe.executeScript("arguments[0].click();", PackagedeliveryRepo.tranferpackoption);
				Select storedropdown = new Select(PackagedeliveryRepo.storelistdropdown);

				List<WebElement> listOptionDropdown = storedropdown.getOptions();
				int storecount = listOptionDropdown.size();

				if (storecount == 0) {

					System.out.print("\n" + "There are no other locations to tranfer ");
					break;

				}

				else {

					storedropdown.selectByIndex(2);
					JavascriptExecutor transferndeleteexe = (JavascriptExecutor) driver;
					transferndeleteexe.executeScript("arguments[0].click();",
							PackagedeliveryRepo.tranferanddeletebutton);
					break;
				}

				// JavascriptExecutor canceltranfrpackexe = (JavascriptExecutor) driver;
				// canceltranfrpackexe.executeScript("arguments[0].click();",PackagedeliveryRepo.tranferpackagecancel);

			} else if (transferok == true) {
				JavascriptExecutor transferokexe = (JavascriptExecutor) driver;
				transferokexe.executeScript("arguments[0].click();", PackagedeliveryRepo.transferokinfo);
				System.out.print("\n" + "Only one store available so we cannot tranfer packages and delete");
				break;
			} else {

				System.out.print("\n" + "store location " + i + " does not have pending packages");
				break;
			}

		}

	}

	public void navigate_kioskmgmt() {

		JavascriptExecutor kioskmenuexe = (JavascriptExecutor) driver;
		kioskmenuexe.executeScript("arguments[0].click();", PackagedeliveryRepo.packageproduct);
		JavascriptExecutor unlicensedexe = (JavascriptExecutor) driver;
		unlicensedexe.executeScript("arguments[0].click();", PackagedeliveryRepo.unlicencedkiosk);
		log.info("\n"+"Clicked on kiosk management menu");
	}

	public void select_edit() {

		List<WebElement> kioskslist = driver.findElements(By.xpath("//div[@id='view_pwa_devices']//table//tbody//tr"));
		int size = kioskslist.size();

	//	System.out.print("\n" + "number of records:" + size);
		log.error("\n"+"number of records:" + size);
		
		if(size==0) {
			
			log.info("\n"+"There are no records of kiosks to edit");
		}
		else {
			log.info("\n"+"There are records of kiosks to edit");
			for(int i=1;i<size;i++) {
			WebElement editicon=driver.findElement(By.xpath("//div[@id='view_pwa_devices']//table//tbody//tr["+i+"]//a[contains(@id,'kioskManagePwa_grid_edit')]"));	
			JavascriptExecutor editiconexe = (JavascriptExecutor) driver;
			editiconexe.executeScript("arguments[0].click();", editicon);
			log.info("\n"+"clicked on first record");break;}
		}}
		public void edit_details() {
			boolean editmodal=PackagedeliveryRepo.pwaeditmodal.isDisplayed();
			if(editmodal==true) {
				
				log.info("\n"+"pwa edit modal is displayed."+editmodal);
				WebElement editpwatext=driver.findElement(By.xpath("//form[@id='edit_device_form']//input[@id='alias_name']"));

				Random randomGenerator = new Random();
				int randomInt = randomGenerator.nextInt(1000);
				editpwatext.clear();
				editpwatext.sendKeys("stest"+randomInt);
				
			}else {log.info("\n"+"pwa edit modal is not displayed."+editmodal);}
			
			
		}
		
		public void editpwa_validations() {
			
			boolean editmodal=PackagedeliveryRepo.pwaeditmodal.isDisplayed();
			if(editmodal==true) {
				
				log.info("\n"+"pwa edit modal is displayed for validations."+editmodal);
				
				WebElement editpwatext=driver.findElement(By.xpath("//form[@id='edit_device_form']//input[@id='alias_name']"));
				editpwatext.clear();
				
				
				Random randomGenerator = new Random();
				int randomInt = randomGenerator.nextInt(1000);
				
				editpwatext.sendKeys("stest"+randomInt);
				
			}else {log.info("\n"+"pwa edit modal is not displayed."+editmodal);}
				
			
		}
		
		
		// div[@id='view_pwa_devices']//table//tbody//tr

	
	
	public void pwa_update() {
		
		JavascriptExecutor editiconexe = (JavascriptExecutor) driver;
		editiconexe.executeScript("arguments[0].click();",PackagedeliveryRepo.pwaeditupdate );}
	
	public void pwa_updateprompt() {
		
		boolean promptdisplay=PackagedeliveryRepo.pwaeditupdatepromptmodal.isDisplayed();
		
		if(promptdisplay==true) {
			
			log.info("\n"+"");
		JavascriptExecutor pwaeditpromptexe = (JavascriptExecutor) driver;
		pwaeditpromptexe.executeScript("arguments[0].click();",PackagedeliveryRepo.pwaeditupdateprompt );
		}
		
	}
	
	public void pwa_editvalidations() {
		boolean editmodal=PackagedeliveryRepo.pwaeditmodal.isDisplayed();
		if(editmodal==true) 
			{
			
			log.info("\n"+"Edit modal displayed ");
			WebElement editpwatext=driver.findElement(By.xpath("//form[@id='edit_device_form']//input[@id='alias_name']"));
			
			editpwatext.clear();	
			log.info("\n"+"Alias name cleared");
			pwa_update();
}
		
	}
	
	public void packagekiosk_editcancel() {
		boolean editmodal=PackagedeliveryRepo.pwaeditmodal.isDisplayed();
		if(editmodal==true) 
			{
			log.info("\n"+"Edit modal displayed ");
			
			JavascriptExecutor editcancelexe = (JavascriptExecutor) driver;
			editcancelexe.executeScript("arguments[0].click();",PackagedeliveryRepo.packagekioskeditcancelbutton );
			log.info("\n"+"Package delivery kiosk Edit details cancelled ");
			}	
		
		
	}
	
public void dettach_packagekiosk() {
	
	List<WebElement> Activekioskslist = driver.findElements(By.xpath("//div[@id='view_pwa_devices']//table//tbody//tr//td//span[contains(text(),'Active')]"));
	int size = Activekioskslist.size();

//	System.out.print("\n" + "number of records:" + size);
	log.info("\n"+"number of active records:" + size);
	
	if(size==0) {
		
		log.info("\n"+"There are no active kiosks to dettach");
	}
	else {
		
		log.info("\n"+"There are kiosks to dettach");
		for(int i=1;i<=size;i++) {
		WebElement dettachicon=driver.findElement(By.xpath
				("//div[@id='view_pwa_devices']//table//tbody//tr["+i+"]//td//span[contains(text(),'Active')]//parent::td//following-sibling::td//a[contains(@id,'kioskManagePwa_grid_detach')]"));	
		
		
		//div[@id='view_pwa_devices']//table//tbody//tr//td//span[contains(text(),'Active')]//parent::td//following-sibling::td//a[contains(@id,'kioskManagePwa_grid_detach')]
		
		JavascriptExecutor editiconexe = (JavascriptExecutor) driver;
		editiconexe.executeScript("arguments[0].click();", dettachicon);
		log.info("\n"+"clicked on first record");break;}
	}}	
	
public void confirm_packagekioskdettach() {
	
	boolean dettachmodaldisplay=PackagedeliveryRepo.confirmmodaldettachpackagekiosk.isDisplayed();
	
	if(dettachmodaldisplay==true) {
		
		JavascriptExecutor dettachproceed = (JavascriptExecutor) driver;
		dettachproceed.executeScript("arguments[0].click();", PackagedeliveryRepo.kioskManagePwadetachModalproceed);
		
	}
}

public void cancel_packagekioskdettach() {
	
boolean dettachmodaldisplay=PackagedeliveryRepo.confirmmodaldettachpackagekiosk.isDisplayed();
	
	if(dettachmodaldisplay==true) {
		log.info("\n"+"dettachmodel diplsayed for dettach kiosk");
		JavascriptExecutor kioskdettachcancel = (JavascriptExecutor) driver;
		kioskdettachcancel.executeScript("arguments[0].click();", PackagedeliveryRepo.kioskManagePwadetachModalcancel);
		log.info("\n"+"Cancelled dettach package kiosk ");
	}
	
	
}

public void delete_nonactivepackagekiosk() {
	
	List<WebElement> nonactivekioskslist = driver.findElements(By.xpath("//div[@id='view_pwa_devices']//table//tbody//tr//td//span[contains(text(),'Connect')]"));
	int size = nonactivekioskslist.size();
	//div[@id='view_pwa_devices']//table//tbody//tr//td//span[contains(text(),'Connect')]
	//parent::td//following-sibling::td//a[contains(@id,'kioskManagePwa_grid_delete')]
//	System.out.print("\n" + "number of records:" + size);
	log.info("\n"+"number of non-active records:" + size);
	
	if(size==0) {
		
		log.info("\n"+"There are no active kiosks to dettach");
	}
	else {
		
		log.info("\n"+"There are kiosks to dettach");
		for(int i=1;i<=size;i++) {
		WebElement deleteicon=driver.findElement(By.xpath
				("//div[@id='view_pwa_devices']//table//tbody//tr//td//span[contains(text(),'Connect')]\r\n" + 
						"	//parent::td//following-sibling::td//a[contains(@id,'kioskManagePwa_grid_delete')]"));	
		
		
		//div[@id='view_pwa_devices']//table//tbody//tr//td//span[contains(text(),'Active')]//parent::td//following-sibling::td//a[contains(@id,'kioskManagePwa_grid_detach')]
		
		JavascriptExecutor deleteiconexe = (JavascriptExecutor) driver;
		deleteiconexe.executeScript("arguments[0].click();", deleteicon);
		log.info("\n"+"Deleted non-active record");break;}
	}
	
	
}

public void confirm_deletenonactivekiosk() {
	
	boolean deletemoadaldisplay=PackagedeliveryRepo.deletepwadeviceconfirmmodal.isDisplayed();
	
	if(deletemoadaldisplay==true) {
		
		log.info("\n"+"Non-active package kiosk Delete confirmation modal has been displayed");
		JavascriptExecutor cancelconfirmexe = (JavascriptExecutor) driver;
		cancelconfirmexe.executeScript("arguments[0].click();", PackagedeliveryRepo.kioskManagePwadeleteModaldelete);
		log.info("\n"+"Deleted non-active record");
		
	}else {log.info("\n"+"Non-active package kiosk Delete confirmation modal not displayed");}
	
	
}

public void cancel_deletenonactivekiosk() {
	
	boolean deletemoadaldisplay=PackagedeliveryRepo.deletepwadeviceconfirmmodal.isDisplayed();
	
	if(deletemoadaldisplay==true) {
		
		log.info("\n"+"Non-active package kiosk Delete confirmation modal has been displayed");
		JavascriptExecutor cancelconfirmexe = (JavascriptExecutor) driver;
		cancelconfirmexe.executeScript("arguments[0].click();", PackagedeliveryRepo.kioskManagePwadeleteModalcancel);
		log.info("\n"+"Cancelled deletion of non-active record");
		
	}else {log.info("\n"+"Non-active package kiosk Delete confirmation modal not displayed");}
	
	
}


	public void edit_menu() {

		JavascriptExecutor editmenuexe = (JavascriptExecutor) driver;
		editmenuexe.executeScript("arguments[0].click();", PackagedeliveryRepo.editmenuitem);

	}

	public void select_store() {
		WebElement store = driver.findElement(By.xpath("//table//tr//td//input[starts-with(@id,'storeLocation')]"));
		JavascriptExecutor storeexe = (JavascriptExecutor) driver;
		storeexe.executeScript("arguments[0].click();", store);
	}

	public void save_edit() {

		JavascriptExecutor saveeditedexe = (JavascriptExecutor) driver;
		saveeditedexe.executeScript("arguments[0].click();", PackagedeliveryRepo.saveeditedbutton);
	}

	public void edit_cancel() {
		JavascriptExecutor canceleditexe = (JavascriptExecutor) driver;
		canceleditexe.executeScript("arguments[0].click();", PackagedeliveryRepo.canceleditbutton);
	}

	public void edit_store() {

		List<WebElement> Locations = driver
				.findElements(By.xpath("//table//tr//td//input[starts-with(@id,'storeLocation')]"));
		// table//tr[1]//td//input[starts-with(@id,'storeLocation')]
		int count = Locations.size();

		System.out.print("\n" + "No of store locations:" + count);

		if (count == 0) {

			System.out.print("\n" + "There are no store locations available");
		} else {

			select_store();
			store_actions_menu();
			edit_menu();
			Random randomGenerator = new Random();
			int randomInt = randomGenerator.nextInt(1000);
			PackagedeliveryRepo.editstorename.clear();
			PackagedeliveryRepo.editstorename.sendKeys("Testedited" + randomInt);
			PackagedeliveryRepo.editstoreaddress.clear();
			PackagedeliveryRepo.editstoreaddress.sendKeys("Testaddressedited" + randomInt);
			save_edit();
			System.out.print("\n" + "store name and store address edited successfully");

			select_store();
			store_actions_menu();
			edit_menu();
			PackagedeliveryRepo.editstorename.clear();
			PackagedeliveryRepo.editstoreaddress.clear();
			PackagedeliveryRepo.editstoreaddress.sendKeys("Testaddressedited" + randomInt);
			save_edit();
			System.out.print("\n" + "Store name is mandatory to save");
			edit_cancel();

			select_store();
			store_actions_menu();
			edit_menu();
			PackagedeliveryRepo.editstorename.clear();
			PackagedeliveryRepo.editstorename.sendKeys("Testedited" + randomInt);
			PackagedeliveryRepo.editstoreaddress.clear();
			save_edit();
			System.out.print("\n" + "Store address is mandatory to save");
			edit_cancel();

		}
	}

	public void create_store_save() {

	}

	public void createstore_validations() {
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(1000);

		PackagedeliveryRepo.storename.clear();
		PackagedeliveryRepo.storeaddress.clear();
		createstore_button();
		System.out.print("\n" + "enter store name error message displayed");

		PackagedeliveryRepo.storename.clear();
		PackagedeliveryRepo.storename.sendKeys("Test" + randomInt);
		PackagedeliveryRepo.storeaddress.clear();
		createstore_button();
		System.out.print("\n" + "enter store address error message displayed");
		JavascriptExecutor craetestorecancelexe = (JavascriptExecutor) driver;
		craetestorecancelexe.executeScript("arguments[0].click();", PackagedeliveryRepo.cancelcreatestore);

	}

	public void navigate_kiosk_create() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		Thread.sleep(2000);
		PageFactory.initElements(driver, Locationmgmtrepo.class);
		PageFactory.initElements(driver, PackagedeliveryRepo.class);
		JavascriptExecutor myorgexe = (JavascriptExecutor) driver;
		myorgexe.executeScript("arguments[0].click();", Locationmgmtrepo.myorg);

		// JavascriptExecutor myorgiconexe = (JavascriptExecutor) driver;
		// myorgiconexe.executeScript("arguments[0].click();",PackagedeliveryRepo.myorgicon);
		JavascriptExecutor kioskmanagementexe = (JavascriptExecutor) driver;
		kioskmanagementexe.executeScript("arguments[0].click();", PackagedeliveryRepo.kioskmangementmenu);
		JavascriptExecutor licencedkioskexe = (JavascriptExecutor) driver;
		licencedkioskexe.executeScript("arguments[0].click();", PackagedeliveryRepo.licencedkioskmenu);
	}

	public void create_kiosk() {
		JavascriptExecutor createlicencekioskexe = (JavascriptExecutor) driver;
		createlicencekioskexe.executeScript("arguments[0].click();", PackagedeliveryRepo.createlicencekioskbutton);
		WebElement assistedmodal = PackagedeliveryRepo.createassistedmodal;

		if (assistedmodal.isDisplayed()) {

			Select devicedropdown = new Select(PackagedeliveryRepo.devicebranchdropdown);
			devicedropdown.selectByIndex(1);

			PackagedeliveryRepo.devicealiasname.sendKeys("Test");

			JavascriptExecutor kiosktypeexe = (JavascriptExecutor) driver;
			kiosktypeexe.executeScript("arguments[0].click();", PackagedeliveryRepo.selectkiosktype);

		} else {

			System.out.print("\n" + "Unable to create kiosk");
		}

		/*
		 * Cookie cookie = driver.manage().getCookieNamed("accessauth"); String
		 * cookiename = cookie.getValue(); String cookiedomain = cookie.getDomain();
		 * 
		 * String getdeviceurl = "https://" + cookiedomain + "/api/get_devices.php";
		 * HttpResponse<JsonNode> deviceresponse =
		 * Unirest.post(getdeviceurl).header("Authorization", cookiename).asJson();
		 * 
		 * JSONArray
		 * devicecodes=deviceresponse.getBody().getObject().getJSONObject("data").
		 * getJSONArray("kiosks"); int size=devicecodes.length(); //int
		 * first=devicecodes(1); int datasize=devicecodes.length(); String devicecode;
		 * String devicestatus; System.out.print("\n" + "number of records" + datasize);
		 * for(int i= 0;i<datasize;i++) {
		 * 
		 * devicecode=devicecodes.getJSONObject(i).getString("device_sync_code");
		 * devicestatus=devicecodes.getJSONObject(i).getString("device_status");
		 * System.out.print("\n"+"device code and device status:"+devicecode+" , "
		 * +devicestatus); if(devicestatus.contains("active")) { //System.out.print(
		 * "\n"+"ready to assign devices available so no need to create new device");
		 * i++;
		 * 
		 * } else {
		 */

		// System.out.print("\n"+" ready to assign devices not available so need to
		// create new device");

	}
	// }
	// }

	public void assistedkioskproceed() {

		JavascriptExecutor savekiassistedproceedexe = (JavascriptExecutor) driver;
		savekiassistedproceedexe.executeScript("arguments[0].click();", PackagedeliveryRepo.assistedkioskproceed);

	}

	public void save_kiosk() {

		boolean kiosksave = PackagedeliveryRepo.savekioskbutton.isDisplayed();
		if (kiosksave == true) {

			JavascriptExecutor savekioskexe = (JavascriptExecutor) driver;
			savekioskexe.executeScript("arguments[0].click();", PackagedeliveryRepo.savekioskbutton);
		} else {

			System.out.print("\n" + "there are no kiosks created to save.");
		}

	}

	public void Login_assisted() throws InterruptedException, ClassNotFoundException, SQLException {
		PageFactory.initElements(driver, PendingcheckinsRepo.class);
		boolean addonlocation = PendingcheckinsRepo.addaonlocationmodal.isDisplayed();
		if (addonlocation == true) {

			System.out.print("\n" + "Addon loaction option available");

		} else {

			System.out.print("\n" + "there are no created kiosks to proceed.");
			// Packagedelivery package=new Packagedelivery();

			// System.out.print("\n"+"customer code in loginassisted method:"+customercode);
			Cookie cookie = driver.manage().getCookieNamed("accessauth");
			String cookiename = cookie.getValue();
			String cookiedomain = cookie.getDomain();

			String getdeviceurl = "https://" + cookiedomain + "/api/get_devices.php";
			HttpResponse<JsonNode> deviceresponse = Unirest.post(getdeviceurl).header("Authorization", cookiename)
					.asJson();

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

			navigate_package_delivery();
			nonpicked_packages(customer_code, branchid);
		}
	}

	public void navigate_package_delivery() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		Thread.sleep(2000);
		// WebDriverWait some_element = new WebDriverWait(driver,100);
		// some_element.until(ExpectedConditions.visibilityOf(PackagedeliveryRepo.assisitedkioskvisitormenu));
		WebElement assistedvisitorsmenu = driver.findElement(By.xpath("//li[1]//a[@id='assistedSidebar_visitors']"));
		// JavascriptExecutor assistedvisitors = (JavascriptExecutor) driver;
		// assistedvisitors.executeScript("arguments[0].click();",PackagedeliveryRepo.assisitedkioskvisitormenu);
		JavascriptExecutor assistedpacakagemenu = (JavascriptExecutor) driver;
		assistedpacakagemenu.executeScript("arguments[0].click();", assistedvisitorsmenu);
		WebElement assistedpackmenu = driver.findElement(By.id("assistedSidebar_packageDelivery"));
		JavascriptExecutor assistedpacakagedel = (JavascriptExecutor) driver;
		assistedpacakagedel.executeScript("arguments[0].click();", assistedpackmenu);

	}

	public void receive_package() throws InterruptedException {
		Thread.sleep(2000);
		WebElement recievepackbutton = driver.findElement(By.id("packageDelivery_receivePackage"));
		JavascriptExecutor receivepackageexe = (JavascriptExecutor) driver;
		receivepackageexe.executeScript("arguments[0].click();", recievepackbutton);

	}

	public void package_details() throws InterruptedException {
		Thread.sleep(2000);
		WebElement recievepackbutton = driver.findElement(By.id("delivered_to"));
		recievepackbutton.sendKeys("sri");
		String empnamecontains = recievepackbutton.getText();
		// Select emplist=new Select(driver.findElement(By.id("dynmicUserIds")));

		List<WebElement> options = driver.findElements(By.id("dynmicUserIds"));

		for (WebElement option : options) {
			if (option.getText().contains(empnamecontains)) {
				option.click();
				break;
			}
		}
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(1000);
		driver.findElement(By.id("delivered_from")).sendKeys("Delhi");
		driver.findElement(By.id("delivered_through")).sendKeys("amazon");
		driver.findElement(By.id("delivery_reference_number")).sendKeys("1" + randomInt);

		Select locationlist = new Select(driver.findElement(By.id("stored_location")));
		locationlist.selectByIndex(1);

	}

	public void packdetails_save() throws InterruptedException {
		Thread.sleep(2000);
		WebElement savebutton = driver.findElement(By.id("packageDelivery_receivePackageModal_save"));
		JavascriptExecutor receivepackageexe = (JavascriptExecutor) driver;
		receivepackageexe.executeScript("arguments[0].click();", savebutton);

	}

	public void nonpicked_packages(String customer_code, String branchid)
			throws ClassNotFoundException, SQLException, InterruptedException {
		/*
		 * //Cookie cookie = driver.manage().getCookieNamed("accessauth");
		 * 
		 * //String cookiename = cookie.getValue(); ///String cookiedomain =
		 * cookie.getDomain();
		 * 
		 * String url =
		 * "https://test-app.fidentity.com/assisted_kiosk/api/v1/get_non_picked_package_deliveries.php";
		 * 
		 * // HttpResponse<JsonNode> response =
		 * Unirest.post(url).header("Authorization", cookiename).asJson();
		 * HttpResponse<JsonNode> response = Unirest.post(url).getBody()
		 * System.out.print("\n" + "api response: " + response.getBody());
		 * 
		 * 
		 * JSONArray transactions=response.getBody().getObject().getJSONArray("data");
		 * int size=transactions.length(); //int first=devicecodes(1);
		 * 
		 * System.out.print("\n" + "number of records: " + size);
		 * 
		 * String
		 * firsttransactionid=transactions.getJSONObject(0).getString("transaction_id");
		 */

		System.out.println("\n" + "customer code and branch id are " + customer_code + "," + branchid);
		DataBase_connection db = new DataBase_connection();
		db.dbconnection();
		ResultSet rs = db.stmt.executeQuery("SELECT * FROM test_vms.package_delivery_transactions where branch_id='"
				+ branchid + "' and is_picked=false;");
		System.out.println(rs);
		while (rs.next()) {
			String transactionid = rs.getString("transaction_id");
			String customerid = rs.getString("customer_id");
			String branch_id = rs.getString("branch_id");
			String storename = rs.getString("store_name");
			String pickupcode = rs.getString("pickup_code");

			System.out.print("\n" + "transcation id:" + transactionid);
			System.out.print("\n" + "customer id:" + customerid);
			System.out.print("\n" + "branch id:" + branch_id);
			System.out.print("\n" + "store name:" + storename);
			System.out.print("\n" + "pickup code:" + pickupcode);

			// Thread.sleep(2000);
			WebElement pickupbutton = driver
					.findElement(By.xpath("//table//tbody//tr[1]//button[contains(@id,'packageDelivery_pickup')]"));
			JavascriptExecutor pickupexe = (JavascriptExecutor) driver;
			pickupexe.executeScript("arguments[0].click();", pickupbutton);

			driver.findElement(By.id("pickup_code")).sendKeys(pickupcode);

			WebElement pickupyes = driver.findElement(By.id("packageDelivery_pickupDeliveryModal_yes"));
			JavascriptExecutor pickyesexe = (JavascriptExecutor) driver;
			pickyesexe.executeScript("arguments[0].click()", pickupyes);

			break;
		}

		/*
		 * Cookie cookie = driver.manage().getCookieNamed("accessauth"); String
		 * cookiename = cookie.getValue(); String cookiedomain = cookie.getDomain();
		 * 
		 * String url = "https://" + cookiedomain + "/api/get_session_data.php";
		 * HttpResponse<JsonNode> response = Unirest.post(url).header("Authorization",
		 * cookiename).asJson(); customercode =
		 * response.getBody().getObject().getJSONObject("data").getString(
		 * "customer_code");
		 */

		/*
		 * DataBase_connection db = new DataBase_connection(); db.dbconnection();
		 * ResultSet rs = db.stmt.
		 * executeQuery("SELECT * FROM test_user_management.otp ORDER BY id desc;");
		 * System.out.println(rs); if (rs.next()) { String onetimepswd =
		 * rs.getString("otp"); String mailid = rs.getString("destination");
		 * System.out.print("\n" + " mail id is:" + mailid + " " + "OTP for signup" +
		 * onetimepswd + "\n"); WebElement pswdscreen = Signuprepo.otp; if
		 * (pswdscreen.isDisplayed()) { System.out.print("\n" +
		 * "Change password screen launched successfully"); Signuprepo.otp.clear();
		 * Signuprepo.otp.sendKeys(onetimepswd); // driver.findElement(By.xpath(
		 * "//form[@id='create_password_form']//div//input[@id='otp']")).clear(); //
		 * driver.findElement(By.xpath(
		 * "//form[@id='create_password_form']//div//input[@id='otp']")).sendKeys(
		 * onetimepswd); } else { System.out.print("\n" +
		 * "Change password screen not launched hence we tried signup multiple times");
		 * }
		 * 
		 * }
		 * 
		 * 
		 * 
		 * }
		 */}
}