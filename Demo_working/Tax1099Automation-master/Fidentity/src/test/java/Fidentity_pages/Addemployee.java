package Fidentity_pages;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.gson.JsonObject;

import Common.Fid_base;
import Object_repo.AddemployeeRepo;
import Object_repo.Signuprepo;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.json.JSONArray;
import kong.unirest.json.JSONObject;

public class Addemployee extends Fid_base {
	
	
	
	 public Statement stmt;

		public void dbconnection() throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.jdbc.Driver");
		 // Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://35.153.40.38:3306", "stageuser","stage(password)" );
	 stmt = con.createStatement();
 
		
		}
	
	public void addemp_Nav() throws SQLException, InterruptedException  {
		
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(4000);
		PageFactory.initElements(driver, AddemployeeRepo.class);
		JavascriptExecutor addexe = (JavascriptExecutor) driver;
		addexe.executeScript("arguments[0].click();", AddemployeeRepo.productsicon);
		JavascriptExecutor empmeuexe = (JavascriptExecutor) driver;
		empmeuexe.executeScript("arguments[0].click();", AddemployeeRepo.employeesmenu);
		
		
		
		
	/*	WebElement element= driver.findElement(By.xpath("//div[@class='side-wrapper']//ul[1]//li[@id='service_users_parent']//a"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		WebElement addemp= driver.findElement(By.xpath("//div[@id='service_user_features']//span[2]//a[contains(text(),'Add Employee')]"));
		JavascriptExecutor addempexecutor = (JavascriptExecutor) driver;
		addempexecutor.executeScript("arguments[0].click();", addemp);*/
				
				
	}
		
	public void addemployee_button() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(4000);
		PageFactory.initElements(driver, AddemployeeRepo.class);
		JavascriptExecutor addempexe = (JavascriptExecutor) driver;
		addempexe.executeScript("arguments[0].click();", AddemployeeRepo.addemployeebutton);
		
	}
	
	public void grant_adminaccess() throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(4000);
		PageFactory.initElements(driver, AddemployeeRepo.class);
		WebElement adminaccess=driver.findElement(By.xpath("//input[@id='viewStaff_addModal_admin']/following-sibling::span"));
		
		JavascriptExecutor adminaccessexe = (JavascriptExecutor) driver;
		adminaccessexe.executeScript("arguments[0].click();", adminaccess);
	}
	
	
	public void existed_phone1() {
		
		
	}
	
	public void emp_fields() throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(4000);
		PageFactory.initElements(driver, AddemployeeRepo.class);
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(10000);
		
		AddemployeeRepo.empfirstname.sendKeys("sridevi"+randomInt);
		AddemployeeRepo.employeeemail.sendKeys("sree"+randomInt+"@zenwork.com");
		
		Select countrylist=new Select(driver.findElement(By.id("invite_country_code")));
		countrylist.selectByIndex(1);
		AddemployeeRepo.empphone.sendKeys("11111"+randomInt);
		
		Select genderlist=new Select(driver.findElement(By.id("invite_gender")));
		genderlist.selectByIndex(2);
		//AddemployeeRepo.empphone.sendKeys("11111");
		
		
	
		
		/*driver.findElement(By.xpath("//input[@id='invite_first_name']")).sendKeys("SreeTest");
					WebElement countrycodedd= driver.findElement(By.xpath("//form[@id='add_staff_form']//div//div[2]//div//div//input"));
				JavascriptExecutor countryexe = (JavascriptExecutor) driver;
				countryexe.executeScript("arguments[0].click();", countrycodedd);
		WebElement selectcountry= driver.findElement(By.xpath("//ul[contains(@id,'select-options')]//li[2]//span"));
		JavascriptExecutor selectcountryexe = (JavascriptExecutor) driver;
		selectcountryexe.executeScript("arguments[0].click();", selectcountry);
		Random randomGenerator = new Random();  
		int randomInt = randomGenerator.nextInt(1000);  
		driver.findElement(By.xpath("//input[@id='invite_phone']")).sendKeys("1111111"+randomInt);
		driver.findElement(By.xpath("//input[@id='invite_email']")).sendKeys("sree"+randomInt+"@srtest.com");
		Thread.sleep(2000);
		WebElement customerType=driver.findElement(By.xpath("//input[@value='Choose gender']"));
		new WebDriverWait(driver, 15).until(
	            ExpectedConditions.elementToBeClickable(customerType));
		customerType.click();
		Thread.sleep(2000);
		WebElement dropdown = driver.findElement(By.xpath("//input[@class='select-dropdown']"));
				List<WebElement> gendertype = dropdown.findElements(By.xpath("//input[@value='Choose gender']//following-sibling::ul//li"));
		gendertype.get(2).click();
		
		
	//	driver.findElement(By.xpath("//input[@id='add_account']")).clear();
		WebElement element= driver.findElement(By.xpath("//input[@id='add_account']"));

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);*/
			
	}
	public void addemployee_update() throws InterruptedException {
		
		
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(4000);
		PageFactory.initElements(driver, AddemployeeRepo.class);
		JavascriptExecutor empupdateexe = (JavascriptExecutor) driver;
		empupdateexe.executeScript("arguments[0].click();", AddemployeeRepo.empupdate);
		
		
		
	}
	
	public void emp_loginaccount() throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(4000);
		PageFactory.initElements(driver, AddemployeeRepo.class);
		WebElement loginswitch=driver.findElement(By.xpath("//input[@id='viewStaff_addModal_addAccount']/following-sibling::span"));
		
		JavascriptExecutor loginaccountexe = (JavascriptExecutor) driver;
		loginaccountexe.executeScript("arguments[0].click();", loginswitch);
		
	}
	
	
	
	public void addemp_confirmation() throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(4000);
		PageFactory.initElements(driver, AddemployeeRepo.class);
		JavascriptExecutor addconfirmexe = (JavascriptExecutor) driver;
		addconfirmexe.executeScript("arguments[0].click();", AddemployeeRepo.addempconfirmation);
		
	}
	
	public void empvalidation_existedphone() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(4000);
	//	PageFactory.initElements(driver, AddemployeeRepo.class);
		
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(10000);
		
		AddemployeeRepo.empfirstname.sendKeys("sridevi"+randomInt);
		AddemployeeRepo.employeeemail.sendKeys("sree"+randomInt+"@zenwork.com");
		
		Cookie cookie = driver.manage().getCookieNamed("accessauth");
		// Decoder jwt = DecoderContext.decode(cookie);
		// Cookie cookie = driver.manage().getCookieNamed("domain");
		System.out.print("\n" + "cookie " + cookie);
		String cookiename = cookie.getValue();
		String cookiedomain = cookie.getDomain();
		System.out.print("\n" + "cookiename: " + cookiename);
		System.out.print("\n" + "cookiedomain: " + cookiedomain);
		String url = "https://" + cookiedomain + "/api/staff_list.php";
		HttpResponse<JsonNode> response = Unirest.post(url).header("Authorization", cookiename).asJson();
		System.out.print("\n" + "api response: " + response.getBody());
		
		String message=response.getBody().getObject().getString("message");
		 
		//String messagetext=message.getString("message");
		System.out.print("\n"+"message text:"+message);
		String messagetext="There are not employees to display";
		
		if(message.equals(messagetext)) {
			
			System.out.print("\n"+"There are no employees in the list no phone validation msg displayed");
			Select countrylist=new Select(driver.findElement(By.id("invite_country_code")));
			countrylist.selectByIndex(1);
			AddemployeeRepo.empphone.sendKeys("11111"+randomInt);
			Select genderlist=new Select(driver.findElement(By.id("invite_gender")));
			genderlist.selectByIndex(2);
		}
		else {
		int i=1;
		JSONArray data = response.getBody().getObject().getJSONObject("data").getJSONArray("data");//.getString("phone_number");
		
		
		int size=data.length();
		
		
		String phone=data.getJSONObject(0).getString("phone_number");
		
		
		
		//int number=phone.length();
		
	//String phonenumber=phone.getJSONObject(i).getString("phone_number");
	System.out.print("\n"+"employee phone number:"+phone);
		AddemployeeRepo.empphone.sendKeys(phone);
		/*	Select countrylist=new Select(driver.findElement(By.id("invite_country_code")));
		countrylist.selectByIndex(1);
		AddemployeeRepo.empphone.sendKeys("11111"+randomInt);*/
		
		Select genderlist=new Select(driver.findElement(By.id("invite_gender")));
		genderlist.selectByIndex(2);}
	}
	
	public void empvalidation_existedemail() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(4000);
	//	PageFactory.initElements(driver, AddemployeeRepo.class);
		
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(10000);
		
		AddemployeeRepo.empfirstname.sendKeys("sridevi"+randomInt);
		//AddemployeeRepo.employeeemail.sendKeys("sree"+randomInt+"@zenwork.com");
		
		Cookie cookie = driver.manage().getCookieNamed("accessauth");
		// Decoder jwt = DecoderContext.decode(cookie);
		// Cookie cookie = driver.manage().getCookieNamed("domain");
		System.out.print("\n" + "cookie " + cookie);
		String cookiename = cookie.getValue();
		String cookiedomain = cookie.getDomain();
		System.out.print("\n" + "cookiename: " + cookiename);
		System.out.print("\n" + "cookiedomain: " + cookiedomain);
		String url = "https://" + cookiedomain + "/api/staff_list.php";
		HttpResponse<JsonNode> response = Unirest.post(url).header("Authorization", cookiename).asJson();
		System.out.print("\n" + "api response: " + response.getBody());
		
		String message=response.getBody().getObject().getString("message");
		 
		//String messagetext=message.getString("message");
		System.out.print("\n"+"message text:"+message);
		String messagetext="There are not employees to display";
		
		if(message.equals(messagetext)) {
			
			System.out.print("\n"+"There are no employees in the list no email validation msg displayed");
			AddemployeeRepo.employeeemail.sendKeys("sree"+randomInt+"@zenwork.com");
			Select countrylist=new Select(driver.findElement(By.id("invite_country_code")));
			countrylist.selectByIndex(1);
			AddemployeeRepo.empphone.sendKeys("11111"+randomInt);
			Select genderlist=new Select(driver.findElement(By.id("invite_gender")));
			genderlist.selectByIndex(2);
		}
		else {
		int i=1;
		JSONArray data = response.getBody().getObject().getJSONObject("data").getJSONArray("data");//.getString("phone_number");
		
		
		int size=data.length();
		
		
		String email=data.getJSONObject(0).getString("email");
		
		
		
		//int number=phone.length();
		
	//String phonenumber=phone.getJSONObject(i).getString("phone_number");
	System.out.print("\n"+"employee email:"+email);
		AddemployeeRepo.employeeemail.sendKeys(email);
		/*	Select countrylist=new Select(driver.findElement(By.id("invite_country_code")));
		countrylist.selectByIndex(1);
		AddemployeeRepo.empphone.sendKeys("11111"+randomInt);*/
		AddemployeeRepo.empphone.sendKeys("11111"+randomInt);
		Select genderlist=new Select(driver.findElement(By.id("invite_gender")));
		genderlist.selectByIndex(2);}
	}
	
	public void field_validation() throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(4000);
		PageFactory.initElements(driver, AddemployeeRepo.class);
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(10000);
		
		AddemployeeRepo.empfirstname.clear();
		AddemployeeRepo.employeeemail.sendKeys("sree"+randomInt+"@zenwork.com");
		AddemployeeRepo.empphone.sendKeys("11111"+randomInt);
		Select genderlist=new Select(driver.findElement(By.id("invite_gender")));
		genderlist.selectByIndex(2);
		
		AddemployeeRepo.empupdate.click();
		System.out.print("\n"+"firstname validation displayed");
	Thread.sleep(2000);
	
		AddemployeeRepo.empfirstname.sendKeys("sridevi"+randomInt);
		AddemployeeRepo.employeeemail.clear();
		AddemployeeRepo.empphone.clear();
		AddemployeeRepo.empphone.sendKeys("11111"+randomInt);
		
		genderlist.selectByIndex(2);
		AddemployeeRepo.empupdate.click();
		System.out.print("\n"+"email validation displayed");
		Thread.sleep(3000);
		
		AddemployeeRepo.empfirstname.clear();
		AddemployeeRepo.empfirstname.sendKeys("sridevi"+randomInt);
		AddemployeeRepo.employeeemail.sendKeys("sree"+randomInt+"@zenwork.com");
		AddemployeeRepo.empphone.clear();
		
		genderlist.selectByIndex(2);
		AddemployeeRepo.empupdate.click();
		System.out.print("\n"+"Phone number validation displayed");
		Thread.sleep(2000);
		
		AddemployeeRepo.empfirstname.clear();
		
		AddemployeeRepo.employeeemail.clear();
		AddemployeeRepo.empphone.clear();
		
		AddemployeeRepo.empupdate.click();
		System.out.print("\n"+"All fields empty check ");
		/*driver.findElement(By.xpath("//input[@id='invite_email']")).clear();
		WebElement empname= driver.findElement(By.xpath("//button[contains(text(),'Add')]"));
		JavascriptExecutor nameexe = (JavascriptExecutor) driver;
		nameexe.executeScript("arguments[0].click();", empname);
		
	//No fileds
		
		
		driver.findElement(By.xpath("//input[@id='invite_first_name']")).sendKeys("SreeTest");
		driver.findElement(By.xpath("//input[@id='invite_phone']")).clear();
		driver.findElement(By.xpath("//input[@id='invite_email']")).clear();
		WebElement empphone= driver.findElement(By.xpath("//button[contains(text(),'Add')]"));
		JavascriptExecutor phonexe = (JavascriptExecutor) driver;
		phonexe.executeScript("arguments[0].click();", empphone);
		
//only first name  number		
		
		driver.findElement(By.xpath("//input[@id='invite_first_name']")).clear();
		driver.findElement(By.xpath("//input[@id='invite_first_name']")).sendKeys("SreeTest");
		driver.findElement(By.xpath("//input[@id='invite_phone']")).clear();
		WebElement countrycodedd= driver.findElement(By.xpath("//form[@id='add_staff_form']//div//div[2]//div//div//input"));
		JavascriptExecutor countryexe = (JavascriptExecutor) driver;
		countryexe.executeScript("arguments[0].click();", countrycodedd);

driver.findElement(By.xpath("//ul[contains(@id,'select-options')]//li[2]//span")).click();
		Thread.sleep(5000);
		Random randomGenerator = new Random();  
		int randomInt = randomGenerator.nextInt(1000);  
		driver.findElement(By.xpath("//input[@id='invite_phone']")).sendKeys("1111111"+randomInt);
		
		driver.findElement(By.xpath("//input[@id='invite_email']")).clear();
		WebElement emailele= driver.findElement(By.xpath("//button[contains(text(),'Add')]"));
		JavascriptExecutor emailexe = (JavascriptExecutor) driver;
		emailexe.executeScript("arguments[0].click();", emailele);

//only name and phone number		
		
		driver.findElement(By.xpath("//input[@id='invite_first_name']")).clear();
		driver.findElement(By.xpath("//input[@id='invite_first_name']")).sendKeys("SreeTest");
		driver.findElement(By.xpath("//input[@id='invite_phone']")).clear();
		WebElement countrycoded1= driver.findElement(By.xpath("//form[@id='add_staff_form']//div//div[2]//div//div//input"));
		JavascriptExecutor countryexe1 = (JavascriptExecutor) driver;
		countryexe1.executeScript("arguments[0].click();", countrycoded1);

//driver.findElement(By.xpath("//ul[contains(@id,'select-options')]//li[2]//span")).click();

WebElement countryname= driver.findElement(By.xpath("//ul[contains(@id,'select-options')]//li[2]//span"));
JavascriptExecutor countrynamexe = (JavascriptExecutor) driver;
countrynamexe.executeScript("arguments[0].click();", countryname);

		Thread.sleep(5000);
		Random randomGenerator1 = new Random();  
		int randomInt1 = randomGenerator1.nextInt(1000);  
		driver.findElement(By.xpath("//input[@id='invite_phone']")).sendKeys("1111111"+randomInt1);
		
		driver.findElement(By.xpath("//input[@id='invite_email']")).clear();
		driver.findElement(By.xpath("//input[@id='invite_email']")).sendKeys("sree"+randomInt+"@srtest.com");
		
		WebElement allele= driver.findElement(By.xpath("//button[contains(text(),'Add')]"));
		JavascriptExecutor allexe = (JavascriptExecutor) driver;
		allexe.executeScript("arguments[0].click();", allele);
		//only name and phone number and mail		
		Thread.sleep(5000);
		
		
		/*		WebElement customerType=driver.findElement(By.xpath("//input[@value='Choose gender']"));
		new WebDriverWait(driver, 15).until(
	            ExpectedConditions.elementToBeClickable(customerType));
		JavascriptExecutor customerTypeexe = (JavascriptExecutor) driver;
		customerTypeexe.executeScript("arguments[0].click();", customerType);*/
	/*Thread.sleep(1000);
	driver.findElement(By.xpath("//input[@id='invite_first_name']")).clear();
	driver.findElement(By.xpath("//input[@id='invite_first_name']")).sendKeys("SreeTest");
	driver.findElement(By.xpath("//input[@id='invite_phone']")).clear();
	WebElement countrycoded2= driver.findElement(By.xpath("//form[@id='add_staff_form']//div//div[2]//div//div//input"));
	JavascriptExecutor countryexe2 = (JavascriptExecutor) driver;
	countryexe2.executeScript("arguments[0].click();", countrycoded2);

//driver.findElement(By.xpath("//ul[contains(@id,'select-options')]//li[2]//span")).click();

WebElement countryname1= driver.findElement(By.xpath("//ul[contains(@id,'select-options')]//li[2]//span"));
JavascriptExecutor countrynamexe1 = (JavascriptExecutor) driver;
countrynamexe1.executeScript("arguments[0].click();", countryname1);

	Thread.sleep(5000);
	Random randomGenerator2 = new Random();  
	int randomInt2 = randomGenerator2.nextInt(1000);  
	driver.findElement(By.xpath("//input[@id='invite_phone']")).sendKeys("1111111"+randomInt2);
	
	driver.findElement(By.xpath("//input[@id='invite_email']")).clear();
	driver.findElement(By.xpath("//input[@id='invite_email']")).sendKeys("sree"+randomInt+"@srtest.com");
	
	WebElement genderele = driver.findElement(By.xpath("//input[@class='select-dropdown']"));
	JavascriptExecutor genderelexe = (JavascriptExecutor) driver;
	genderelexe.executeScript("arguments[0].click();", genderele);
	
		WebElement gendertypele = driver.findElement(By.xpath("//input[@value='Choose gender']//following-sibling::ul//li[2]//span"));
		JavascriptExecutor gendertypexe = (JavascriptExecutor) driver;
		gendertypexe.executeScript("arguments[0].click();", gendertypele);
		Thread.sleep(2000);
		WebElement addele= driver.findElement(By.xpath("//button[contains(text(),'Add')]"));
		JavascriptExecutor addexe = (JavascriptExecutor) driver;
		addexe.executeScript("arguments[0].click();", addele);
		
		
Thread.sleep(5000);
		
		WebElement confirmele= driver.findElement(By.xpath("//div[@id='add_staff_modal']//div//a[contains(@class,'primary-button')]"));
		JavascriptExecutor confirmedexe = (JavascriptExecutor) driver;
		confirmedexe.executeScript("arguments[0].click();", confirmele);
		
		//div[@id='add_staff_modal']//a[contains(@class,'primary-button')]
		
		*/
		
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


