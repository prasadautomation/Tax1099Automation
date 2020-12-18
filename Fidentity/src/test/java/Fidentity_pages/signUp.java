package Fidentity_pages;

import java.awt.List;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Common.Fid_base;
import Object_repo.Locationmgmtrepo;
import Object_repo.Signinrepo;
import Object_repo.Signuprepo;

public class signUp extends Fid_base { 
	Random randomGenerator = new Random();
	int randomInt = randomGenerator.nextInt(10000);
	
	
	public void signupurl() {
		driver.get(signupurl);
		
	}
	
	
	
	public void requierd_fields() throws InterruptedException, IOException, ClassNotFoundException, SQLException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		Thread.sleep(1000);

		driver.manage().deleteAllCookies();
		Thread.sleep(1000);
		driver.navigate().refresh();

		PageFactory.initElements(driver, Signuprepo.class);
		
	
		Signuprepo.personname.sendKeys("Sridevi Maddipati");

		// driver.findElement(By.xpath("//input[@id='person_name']")).clear();
		// driver.findElement(By.xpath("//input[@id='person_name']")).sendKeys("Sridevi
		// Maddipati");
		Signuprepo.personemail.clear();
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(10000);
		String password="Sridevi@1234";
		String username="sridevi" + randomInt + "@srtest.com";
		Signuprepo.personemail.sendKeys(username);	
		Signuprepo.signuppassword.sendKeys(password);

		Thread.sleep(3000);
		// String eneterusername=Signuprepo.personemail.getText();
		
		FileInputStream fis = new FileInputStream(
				"E:\\eclipse-workspace\\Fidentity\\src\\test\\java\\passwordvalidations.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(6);
		//String passwordlength=sheet.getRow(1).getCell(1).setStringCellValue(username);
	//	Row getrow= sheet.getRow(2);
	//	Cell getcellone=getrow.getCell(0);
	//	Cell getcelltwo=getrow.getCell(1);
	//	String cellonevalue=getcellone.getStringCellValue();
	//	String celltwovalue=getcelltwo.getStringCellValue();
	/*	if(getcellone.getStringCellValue()==null || getcelltwo.getStringCellValue()==null) {
			System.out.print("\n"+"there are no values to display");
		}else {
		getrow.removeCell(getcellone);
		getrow.removeCell(getcelltwo);
		
		System.out.print("\n"+"Removed cell  one and cell two user name and password");}*/
		
		Row row= sheet.createRow(1);
	 Cell cell1 =null;
	 cell1=row.getCell(1);
	 if(cell1!=null) {
	// Cell.removeCell(cell1.getcell(1));
	 cell1.setCellType(cell1.CELL_TYPE_STRING);
	 cell1.setCellValue(username);}
	 else {
		 cell1=row.createCell(1);
		 cell1.setCellValue(username);}
	 
	 Cell cell2 =null;
	 cell2=row.getCell(2);
	 if(cell2!=null) {
	// Cell.removeCell(cell1.getcell(1));
	 cell1.setCellType(cell1.CELL_TYPE_STRING);
	 cell1.setCellValue(password);}
	 else {
		 cell2=row.createCell(2);
		 cell2.setCellValue(password);}
	
	 FileOutputStream fos = new FileOutputStream("E:\\eclipse-workspace\\Fidentity\\src\\test\\java\\passwordvalidations.xlsx");
	 workbook.write(fos);
	 fos.close();
	 System.out.println("\n"+"username and password have been written in excel cell1 and cell2");
	 
	 
		System.out.print("\n"+"Username and password:"+username+";"+password);
		JavascriptExecutor signupexe = (JavascriptExecutor) driver;
		signupexe.executeScript("arguments[0].click();", Signuprepo.newsignupbutton);
		
		
}
		
		
		//JavascriptExecutor signupexe2 = (JavascriptExecutor) driver;
		//signupexe2.executeScript("arguments[0].click();", Signuprepo.newsignupbutton);
		
		// driver.findElement(By.xpath("//input[@id='person_email']")).sendKeys("sridevi"
		// + randomInt + "@srtest.com");

	/*	driver.findElement(By.xpath("//div[@class='selected-flag']")).click();

		java.util.List<WebElement> allOptions = Signuprepo.countrylist;

		// driver.findElements(By.xpath("//ul[@id='country-listbox']"));
		// countrylist
		for (WebElement item : allOptions) {
			// System.out.println("Dropdown values are "+ item.getSize()+""+item.getText());

			String country = item.getText();
			if (country.contains("India")) {
				// driver.findElement(By.xpath("//li[@id='iti-item-in']")).click();
				Signuprepo.india.click();
				System.out.println("India got selected");
			}
		}
		Signuprepo.personphone.clear();
		Signuprepo.personphone.sendKeys("9000119770");
		Signuprepo.companyname.sendKeys("zenwork");
		Signuprepo.companywebsite.sendKeys("zenwork");
		JavascriptExecutor trailexe = (JavascriptExecutor) driver;
		trailexe.executeScript("arguments[0].click();", Signuprepo.trailbutton);
		Thread.sleep(4000);
		Signuprepo.subdomainname.sendKeys("s" + randomInt);
		JavascriptExecutor checkexe = (JavascriptExecutor) driver;
		checkexe.executeScript("arguments[0].click();", Signuprepo.checksubdomainavailability);
		Thread.sleep(4000);
		JavascriptExecutor savexe = (JavascriptExecutor) driver;
		savexe.executeScript("arguments[0].click();", Signuprepo.savedomain);
		Thread.sleep(3000);
		Signuprepo.branchname.sendKeys("Test");
		Signuprepo.branchlocation.sendKeys("Hyderabad");
		Signuprepo.addressline2.sendKeys("Gachibowli");
		Signuprepo.city.sendKeys("Hyderabad");
		Signuprepo.state.sendKeys("Telangana");
		Signuprepo.country.sendKeys("India");
		Signuprepo.postalcode.sendKeys("500018");
		Select utc_timezone = new Select(Signuprepo.utctimezone);
		utc_timezone.selectByValue("5:30");
		// Signuprepo.logoupload.click();
		JavascriptExecutor logo = (JavascriptExecutor) driver;
		logo.executeScript("arguments[0].click();", Signuprepo.logoupload);
		Thread.sleep(3000);
		Runtime.getRuntime().exec("C:\\Users\\Sridevi\\Desktop\\test.exe");
		Thread.sleep(3000);
		JavascriptExecutor signup = (JavascriptExecutor) driver;
		signup.executeScript("arguments[0].click();", Signuprepo.signupbutton);
		System.out.println("Customer created successfully");
		Thread.sleep(10000);

		// driver.findElement(By.xpath("//input[@id='person_phone']")).clear();
		// driver.findElement(By.xpath("//input[@id='person_phone']")).sendKeys("9000119770");
		// driver.findElement(By.xpath("//input[@id='company_name']")).sendKeys("zenwork");
		// driver.findElement(By.xpath("//input[@id='company_web_site']")).sendKeys("zenwork");
// driver.findElement(By.xpath("//a[@id='signup_button']")).click();
		/// WebElement trailbutton = driver.findElement(
		// By.xpath("//form[@id='new_user']//a[@id='signup_button']//span[contains(text(),'Start
		/// Trial')]"));
		// JavascriptExecutor trailexe = (JavascriptExecutor) driver;
		// trailexe.executeScript("arguments[0].click();", trailbutton);
//Signup done customer will be created need to add sub domain
		// Thread.sleep(4000);
//driver.findElement(By.xpath("//form[@id='domain_selection_form']//input[@id='subdomain_name']")).sendKeys("s"+randomInt);
		// driver.findElement(By.xpath(
		// "//form[@id='domain_selection_form']//div[contains(@class,'form-fields')]//input[@id='subdomain_name']"))
		// .sendKeys("s" + randomInt);
// driver.findElement(By.xpath("//form[@id='new_user']//a[@id='signup_button']")).click();

//		WebElement savebutton = driver.findElement(By.xpath(
		// "//form[@id='domain_selection_form']//a[@id='save_domain_button']//span[contains(text(),'Save')]"));
		// driver.findElement(By
		// .xpath("//form[@id='add_branch_form']//div[contains(@class,'form-fields')]//input[@id='branch_name']"))
		// .sendKeys("Test");
		// driver.findElement(By.xpath(
		// "//form[@id='add_branch_form']//div[contains(@class,'form-fields')]//input[@id='branch_location']"))
		// .sendKeys("Hyderabad");
		// driver.findElement(By.xpath("//form[@id='add_branch_form']//div[contains(@class,'form-fields')]//input[@id='locality']"))
		// .sendKeys("Hyderabad");
		// driver.findElement(
		// By.xpath("//form[@id='add_branch_form']//div[contains(@class,'form-fields')]//input[@name='state']"))
		// .sendKeys("Telangana");
		// driver.findElement(
		// By.xpath("//form[@id='add_branch_form']//div[contains(@class,'form-fields')]//input[@id='country']"))
		// .sendKeys("India");
		// Select timezone = new
		// Select(driver.findElement(By.xpath("//select[@id='utc_timezone']")));
		// timezone.selectByValue("5:30");
		// driver.findElement(By.xpath("//div[@class='file-field
		// form-fields']")).clic
		 * k();
		// Runtime.getRuntime().exec("C:\\Users\\Sridevi\\Desktop\\test.exe");
*/
	
	
	//step1
	public void organization_details() throws InterruptedException, IOException {
		PageFactory.initElements(driver, Signuprepo.class);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		String entersubdomain="elenadev"+randomInt;
		Signuprepo.subdomain.sendKeys(entersubdomain);
		Signuprepo.organisationname.sendKeys("elenadev"+randomInt);
		Thread.sleep(3000);
		String signupurl="test-"+entersubdomain+".fidentity.com";
		
		FileInputStream fis = new FileInputStream(
				"E:\\eclipse-workspace\\Fidentity\\src\\test\\java\\passwordvalidations.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(6);
		
	/*	Row getrow= sheet.getRow(1);
		Cell getcellzero=getrow.getCell(0);
		if(getcellzero==null ) {
			System.out.print("\n"+"there are no urls to display");
		}
		else {
		
		System.out.print("\n"+"cell zero value url is - "+getcellzero.getStringCellValue());
		
		getrow.removeCell(getcellzero);
		System.out.print("\n"+"Removed cell zero ");}*/
		
		
	
		
		//String passwordlength=sheet.getRow(1).getCell(1).setStringCellValue(username);
	 Row row= sheet.getRow(1);
	 Cell cell0 =null;
	 cell0=row.getCell(0);
	 if(cell0!=null) {
	// Cell.removeCell(cell1.getcell(1));
	 cell0.setCellType(cell0.CELL_TYPE_STRING);
	 cell0.setCellValue(signupurl);}
	 else {
		 cell0=row.createCell(0);
		 cell0.setCellValue(signupurl);}
	 
	 FileOutputStream fos = new FileOutputStream("E:\\eclipse-workspace\\Fidentity\\src\\test\\java\\passwordvalidations.xlsx");
	 workbook.write(fos);
	 fos.close();
	 System.out.println("\n"+"Organization url is:"+signupurl);
		
		
		JavascriptExecutor steponeexe = (JavascriptExecutor) driver;
		steponeexe.executeScript("arguments[0].click();",Signuprepo.steponenextbutton );
		
				
		
		
		
	}
	
	public void resume_signup() throws IOException, InterruptedException {
		
    	FileInputStream fis = new FileInputStream(
				"E:\\eclipse-workspace\\Fidentity\\src\\test\\java\\passwordvalidations.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(6);
		Row row=sheet.getRow(1);
		String resumeurl=row.getCell(0).getStringCellValue();
		String validresumeurl="https://"+resumeurl;
		System.out.print("\n"+"signupurl from excel:"+resumeurl);
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver_win32\\chromedriver.exe");
					
			driver = new ChromeDriver();
    	    	driver.get(validresumeurl);
    	    	
    	    	System.out.print("\n"+"valid resume url:"+validresumeurl);
    	    	
    	   PageFactory.initElements(driver,Signinrepo.class);
    	   String username=row.getCell(1).getStringCellValue();
    	    	Signinrepo.Username.sendKeys(username);
    	    	JavascriptExecutor usernamenxtexe = (JavascriptExecutor) driver;
    	    	usernamenxtexe.executeScript("arguments[0].click();",Signinrepo.usernamenext);
    	    	Thread.sleep(2000);
    	    	String password=row.getCell(2).getStringCellValue();	
    	    	Signinrepo.userpassword.sendKeys(password);

    	    	JavascriptExecutor loginbuttonexe = (JavascriptExecutor) driver;
    	    	loginbuttonexe.executeScript("arguments[0].click();",Signinrepo.Loginbutton);
    	    	location_details();
    	    	logo_upload();
    	    	
	}
	
	public void selectOptionWithText(String textToSelect) {
		PageFactory.initElements(driver, Signuprepo.class);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		try {
			
			WebElement autoOptions = Signuprepo.branchname;
			WebDriverWait wait=new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(autoOptions));

			java.util.List<WebElement> optionsToSelect = autoOptions.findElements(By.xpath("//span[contains(text(),'The Platina')]"));
			for(WebElement option : optionsToSelect){
		        if(option.getText().equals(textToSelect)) {
		        	System.out.println("Trying to select: "+textToSelect);
		            option.click();
		            break;
		        }
		    }
			
		} catch (NoSuchElementException e) {
			System.out.println(e.getStackTrace());
		}
		catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}

	//step2
	public void location_details() throws InterruptedException {
		PageFactory.initElements(driver, Signuprepo.class);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Signuprepo.branchname.sendKeys("elena main branch");
		// WebDriverWait wait = new WebDriverWait(driver, 100);
	//	WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("branchlocation")));

		 Signuprepo.branchlocation.sendKeys("the platina gachibowli");
		 selectOptionWithText("The Platina");
		 
		 System.out.print("\n"+"Selected dropdown address ");
		 Thread.sleep(2000);
	//	 WebElement location=Signuprepo.branchlocation;
		// Thread.sleep(3000);
	

		
		
		  // Signuprepo.branchlocation.click();
		Thread.sleep(8000);
	//	WebDriverWait wait = new WebDriverWait(driver, 100);
	//	WebElement element = wait.until(ExpectedConditions.((Signuprepo.branchlocation,)(Signuprepo.steptwonextbutton));
	
		
	//	WebElement element=Signuprepo.country;
//boolean nxtbuttonvisible=element.isDisplayed();
	//	if(nxtbuttonvisible==true) {
			JavascriptExecutor secondnext=(JavascriptExecutor)driver;
			secondnext.executeScript("arguments[0].click()",Signuprepo.steptwonextbutton);
			Thread.sleep(2000);
			System.out.print("\n"+"element is  visible");
		//}
		//else {System.out.print("\n"+"element is not visible");}
/*	Signuprepo.branchname.sendKeys(Keys.DOWN);
		Signuprepo.branchname.sendKeys(Keys.RETURN);
		Thread.sleep(2000);
		JavascriptExecutor secondnext=(JavascriptExecutor)driver;
		secondnext.executeScript("arguments[0].click()",Signuprepo.steptwonextbutton);
		*/
		
		
	/*	Signuprepo.branchlocation.sendKeys("the platina gachibowli");
		Select dropdown=new Select(Signuprepo.branchlocation);
		dropdown.selectByIndex(3);
		Thread.sleep(2000);*/
	/*	WebElement element = Signuprepo.branchlocation;
		Actions builder = new Actions(driver);
		builder.moveToElement(element, 304, 47).click().perform();*/
		
	/*	WebDriverWait wait = new WebDriverWait(driver, 100);
		//whatever time you think is sufficient for manually entering the data.
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("branchlocation")));
		if(ExpectedConditions.attributeToBeNotEmpty(element,"value"))
		{
		  //continue with the automation flow
		}
		*/
		//WebElement select = Signuprepo.branchlocation;
		//Signuprepo.branchlocation.sendKeys("the platina gachibowli");
	
		//driver.manage().timeouts().implicitlyWait(1,TimeUnit.MINUTES);
		//WebElement dropdown = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='client']"))); 
	//	Driver.findElement(By.xpath("//*[@id='collapseClientInfo']/div/form/div[3]/div[2]/ul/li[1]/a")).sendKeys(Keys.ENTER); }}
		//Select sel = new Select(Signuprepo.branchlocation);
	//	 String address = option.getText();
	//	    if (currentFlavourName.contains(expectedFlavourName)) {
	//	        select.selectByVisibleText(currentFlavourName);
	/*	Signuprepo.branchlocation.sendKeys("the platina gachibowli");
	//	String textToSelect="Main Street Flats";
		Thread.sleep(3000);
		
	java.util.List<WebElement> options = new WebDriverWait(driver, 10).until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector("[role='option']"), 0));
	int index = (int) (Math.random() * options.size());
	options.get(index)
	       .click();
		Thread.sleep(2000);
		Signuprepo.addressline2.sendKeys("Building"+randomInt);
		Signuprepo.country.sendKeys("USA");
		Signuprepo.state.sendKeys("Atlanta");
		Signuprepo.city.sendKeys("Georgia");
		Signuprepo.postalcode.sendKeys("123586");
		 Select timezone = new
		Select(driver.findElement(By.xpath("//select[@id='utc_timezone']")));
		timezone.selectByValue("5:30");
					Thread.sleep(3000);
		JavascriptExecutor steptwoexe = (JavascriptExecutor) driver;
		steptwoexe.executeScript("arguments[0].click();",Signuprepo.steptwonextbutton );
		
		*/}
	
	
	public void logo_upload() throws IOException, InterruptedException {
		PageFactory.initElements(driver, Signuprepo.class);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement logo=driver.findElement(By.xpath("//form[@id='step-three-form']//input[@id='fileInput']"));
		//	JavascriptExecutor browserexe=(JavascriptExecutor)driver;
		//	browserexe.executeScript("arguments[0].click();", browsebanner);
			Actions actions=new Actions(driver);
			actions.moveToElement(logo).click().perform();
			Thread.sleep(2000);
			Runtime.getRuntime().exec("C:\\Users\\Sridevi\\Desktop\\test.exe");
			Thread.sleep(2000);
			JavascriptExecutor donebutton = (JavascriptExecutor) driver;
			donebutton.executeScript("arguments[0].click();",Signuprepo.stepthreedonebutton );
	/*System.out.print("\n"+"Clicked on logo image;");
		
		Thread.sleep(2000);
		Runtime.getRuntime().exec("C:\\Users\\Sridevi\\Desktop\\test.exe");
		Thread.sleep(3000);
		System.out.print("\n"+"uploaded image");
		
		Thread.sleep(3000);
		JavascriptExecutor donebutton = (JavascriptExecutor) driver;
		donebutton.executeScript("arguments[0].click();",Signuprepo.stepthreedonebutton );*/
	//	JavascriptExecutor skipbuttonexe = (JavascriptExecutor) driver;
	//	skipbuttonexe.executeScript("arguments[0].click();",Signuprepo.stepthreeskip);
	}

	public void otp_login() throws ClassNotFoundException, SQLException, InterruptedException {
		PageFactory.initElements(driver, Signuprepo.class);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		// driver.navigate().refresh();
		DataBase_connection db = new DataBase_connection();
		
		db.dbconnection();
		ResultSet rs = db.stmt.executeQuery("SELECT * FROM test_user_management.otp ORDER BY id desc;");
		System.out.println(rs);
		if (rs.next()) {
			String onetimepswd = rs.getString("otp");
			String mailid = rs.getString("destination");
			System.out.print("\n" + " mail id is:" + mailid + " " + "OTP for signup" + onetimepswd + "\n");
			WebElement pswdscreen = Signuprepo.otp;
			if (pswdscreen.isDisplayed()) {
				System.out.print("\n" + "Change password screen launched successfully");
				Signuprepo.otp.clear();
				Signuprepo.otp.sendKeys(onetimepswd);
				// driver.findElement(By.xpath("//form[@id='create_password_form']//div//input[@id='otp']")).clear();
				// driver.findElement(By.xpath("//form[@id='create_password_form']//div//input[@id='otp']")).sendKeys(onetimepswd);
			} else {
				System.out.print("\n" + "Change password screen not launched hence we tried signup multiple times");
			}
		}
	}

	public void newpasswords() throws InterruptedException {

		Signuprepo.password.clear();
		Signuprepo.password.sendKeys("Sridevi@1234");
		Signuprepo.confirmpassword.clear();
		Signuprepo.confirmpassword.sendKeys("Sridevi@1234");
		// driver.findElement(By.xpath("//form[@id='create_password_form']//div//input[@id='password']")).clear();
		// driver.findElement(By.xpath("//form[@id='create_password_form']//div//input[@id='password']"))
		// .sendKeys("Sridevi@1234");
		// driver.findElement(By.xpath("//form[@id='create_password_form']//div//input[@id='cpassword']")).clear();
		// driver.findElement(By.xpath("//form[@id='create_password_form']//div//input[@id='cpassword']"))
		// .sendKeys("Sridevi@1234");
		Thread.sleep(3000);
		JavascriptExecutor signup = (JavascriptExecutor) driver;
		signup.executeScript("arguments[0].click();", Signuprepo.setpassword);
		Thread.sleep(10000);
	}
	
	public void passwordvalidatipons() throws IOException, InterruptedException {
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		FileInputStream fis = new FileInputStream(
				"E:\\eclipse-workspace\\Fidentity\\src\\test\\java\\passwordvalidations.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		String passwordlength=sheet.getRow(1).getCell(1).getStringCellValue();
		Signuprepo.password.sendKeys(passwordlength);
		Signuprepo.password.clear();
		Thread.sleep(1000);
		System.out.print("\n"+"Password leangth should be 8 characters:"+passwordlength);
		String passwordsplchar=sheet.getRow(2).getCell(1).getStringCellValue();
		Signuprepo.password.sendKeys(passwordsplchar);
		Signuprepo.password.clear();
		Thread.sleep(1000);
		System.out.print("\n"+"Password should have special characters:"+passwordsplchar);
		String passwordnumber=sheet.getRow(3).getCell(1).getStringCellValue();
		Signuprepo.password.sendKeys(passwordnumber);
		Signuprepo.password.clear();
		Thread.sleep(1000);
		System.out.print("\n"+"Password should have numbers:"+passwordnumber);
		String passwordcapital=sheet.getRow(4).getCell(1).getStringCellValue();
		Signuprepo.password.sendKeys(passwordcapital);
		Signuprepo.password.clear();
		Thread.sleep(1000);
		System.out.print("\n"+"password should have atleast one capital letter:"+passwordcapital);
		String passwordlower=sheet.getRow(5).getCell(1).getStringCellValue();
		Signuprepo.password.sendKeys(passwordlower);
		Signuprepo.password.clear();
		Thread.sleep(1000);
		System.out.print("\n"+"password should have atleast one lowercase letter:"+passwordlower);
		
			}
	

	public void field_validations() throws IOException, InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		PageFactory.initElements(driver, Signuprepo.class);
		Signuprepo.personname.clear();
		Signuprepo.personname.sendKeys("Sridevi Maddipati");
		System.out.print("\n" + "There is no validation for name");

		FileInputStream fis = new FileInputStream(
				"E:\\eclipse-workspace\\Fidentity\\src\\test\\java\\passwordvalidations.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(2);
		XSSFSheet Branchsignup = workbook.getSheetAt(3);

		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
			Signuprepo.personemail.clear();
			System.out.println("\n" + "Checking multiple forms :" + sheet.getRow(i).getCell(0).getStringCellValue());
			Signuprepo.personemail.sendKeys(sheet.getRow(i).getCell(0).getStringCellValue());
			Thread.sleep(3000);

			JavascriptExecutor trailexe = (JavascriptExecutor) driver;
			trailexe.executeScript("arguments[0].click();", Signuprepo.newsignupbutton);
		}

		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(10000);
		Signuprepo.personemail.clear();
		Signuprepo.personemail.sendKeys("sridevi" + randomInt + "@srtest.com");
		
		Thread.sleep(3000);
		boolean existedemail=Signuprepo.existedemail.isDisplayed();
		if (existedemail==true) {
			
			System.out.print("email already existed ");
			Signuprepo.personemail.clear();
			Signuprepo.personemail.sendKeys("sridevi1" + randomInt + "@srtest.com");
		}else {System.out.print("Entered mail is new email");}

		System.out.print("\n" + "Email validations completed");
		//password vallidations
		
		XSSFSheet passwordsheet = workbook.getSheetAt(5);
	
		for (int i = 1; i <=passwordsheet.getLastRowNum(); i++) {
			Signuprepo.signuppassword.clear();
			System.out.print("\n"+"last cell number:"+passwordsheet.getLastRowNum());
			System.out.println("\n" + "Checking multiple password formats :" + passwordsheet.getRow(i).getCell(0).getStringCellValue());
			Signuprepo.signuppassword.sendKeys(passwordsheet.getRow(i).getCell(0).getStringCellValue());
			System.out.print("\n"+"value of row number:"+i);
			Thread.sleep(3000);
 
			
			JavascriptExecutor trailexe = (JavascriptExecutor) driver;
			trailexe.executeScript("arguments[0].click();", Signuprepo.newsignupbutton);
			Thread.sleep(2000);
			
		}
		Signuprepo.signuppassword.clear();
		Signuprepo.signuppassword.sendKeys("Sridevi@1234");
		JavascriptExecutor trailexe = (JavascriptExecutor) driver;
		trailexe.executeScript("arguments[0].click();", Signuprepo.newsignupbutton);
		/*Signuprepo.signuppassword.clear();
		Signuprepo.signuppassword.sendKeys("Sridevi@1234");
		JavascriptExecutor trailexe = (JavascriptExecutor) driver;
		trailexe.executeScript("arguments[0].click();", Signuprepo.newsignupbutton);*/
			
	//	}else {System.out.print("signup first page completed.");}}
		
		
		//organization details
		Signuprepo.subdomain.clear();
		JavascriptExecutor steponenext = (JavascriptExecutor) driver;
		steponenext.executeScript("arguments[0].click();", Signuprepo.steponenextbutton);
		
		System.out.print("\n"+"Validation for enter sub domain name");
		
		Signuprepo.subdomain.sendKeys("test"+randomInt);
		Thread.sleep(3000);
		//boolean domainavailable=Signuprepo.domainavailable.isDisplayed();
	//	System.out.print("\n"+"subdomain name is visible:"+domainavailable);
		boolean domainavailableenable=Signuprepo.domainavailable.isEnabled();
		System.out.print("\n"+"subdomain name is enable:"+domainavailableenable);
		if(domainavailableenable==true) {
			
			System.out.print("\n"+"Validation for when enter sub domain name is available");
			JavascriptExecutor steponenext1 = (JavascriptExecutor) driver;
			steponenext1.executeScript("arguments[0].click();", Signuprepo.steponenextbutton);
			
			
		}else {
			System.out.print("\n"+"Validation for when enter sub domain name is not available");
			Signuprepo.subdomain.clear();
			Signuprepo.subdomain.sendKeys("testsr"+randomInt);
			JavascriptExecutor steponenext1 = (JavascriptExecutor) driver;
			steponenext1.executeScript("arguments[0].click();", Signuprepo.steponenextbutton);
		}
		
	//	JavascriptExecutor steponenext1 = (JavascriptExecutor) driver;
	//	steponenext1.executeScript("arguments[0].click();", Signuprepo.steponenextbutton);
		
		System.out.print("\n"+"validation for enter company name.");
		
		
		Signuprepo.organisationname.sendKeys("Testsr");
		System.out.print("\n"+"Entered company name");
		Thread.sleep(2000);
		WebElement orgnextbutton =driver.findElement(By.xpath("//form[@id='step-one-form']//span[contains(text(),'Next')]"));
		JavascriptExecutor orgnextbuttonexe = (JavascriptExecutor) driver;
		orgnextbuttonexe.executeScript("arguments[0].click();", orgnextbutton);
		System.out.print("\n"+"Organization details completed");
		//Location details
		WebElement formtwo=driver.findElement(By.id("step-two-form"));
		boolean formtwodisplay=formtwo.isDisplayed();
		if(formtwodisplay==true) {
			JavascriptExecutor steptwonext = (JavascriptExecutor) driver;
			steptwonext.executeScript("arguments[0].click();", Signuprepo.steptwonextbutton);
			
			System.out.print("\n"+"Enter location or unit name validation done");
			
			Signuprepo.branchname.sendKeys("Head office");
			
			JavascriptExecutor steptwonext1 = (JavascriptExecutor) driver;
			steptwonext1.executeScript("arguments[0].click();", Signuprepo.steptwonextbutton);
			System.out.print("\n"+"Enter address validation done");
			

			Signuprepo.branchlocation.sendKeys("the platina");
			JavascriptExecutor steptwonext2 = (JavascriptExecutor) driver;
			steptwonext2.executeScript("arguments[0].click();", Signuprepo.steptwonextbutton);
			System.out.print("\n"+"Enter country validation done");
			
			
			Signuprepo.branchlocation.clear();
			Signuprepo.branchlocation.sendKeys("the platina gachibowli");
			 selectOptionWithText("The Platina");
			 Thread.sleep(2000);

				
			 JavascriptExecutor steptwonext3 = (JavascriptExecutor) driver;
				steptwonext3.executeScript("arguments[0].click();", Signuprepo.steptwonextbutton);}
		else {System.out.print("\n"+"Location form is not displayed");}
		
			//Logo page 
		JavascriptExecutor donebutton = (JavascriptExecutor) driver;
		donebutton.executeScript("arguments[0].click();",Signuprepo.stepthreedonebutton );
		Thread.sleep(3000);
		System.out.print("\n"+"Upload logo validation done");
		logo_upload();
		
					
			/*	JavascriptExecutor donebutton = (JavascriptExecutor) driver;
				donebutton.executeScript("arguments[0].click();",Signuprepo.stepthreedonebutton);
				
				System.out.print("\n"+"Upload logo validation done");
				
				JavascriptExecutor logo = (JavascriptExecutor) driver;
				logo.executeScript("arguments[0].click();", Signuprepo.logoupload);
				System.out.print("\n"+"Clicked on upload logo button");
				
				Thread.sleep(3000);
				Runtime.getRuntime().exec("C:\\Users\\Sridevi\\Desktop\\test.exe");

				Thread.sleep(5000);
				JavascriptExecutor signup = (JavascriptExecutor) driver;
				signup.executeScript("arguments[0].click();", Signuprepo.stepthreedonebutton);*/
				
		}
		
	public void signup_fewsteps() throws ClassNotFoundException, InterruptedException, IOException, SQLException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		requierd_fields();
		organization_details();
		System.out.print("\n"+"Signup few steps completed.");
		Thread.sleep(2000);
		
		
		//driver.quit();
		
		//driver.close();
		
	}	
	
	
	public void windowclose() {
		
	//	driver.quit();
	//	System.out.print("\n"+"closed the browser");
		
	}
	/*	public void close() {
			
			driver.close();
			System.out.print("\n"+"closed the browser");
			
		}*/
	/*	
		WebDriverWait wait=new WebDriverWait(driver,30);
		//WebElement orgnextbutton=wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[@id='stepOne_nextButton']//span"))));
	//	Boolean presencenext=orgnextbutton.isDisplayed();
	//	System.out.print("\n"+"next button is visible."+presencenext);
		orgnextbutton.click();
		System.out.print("\n"+"next button in organization details page clicked");
	
	
		
		Signuprepo.personphone.sendKeys("9000119770");
		System.out.print(
				"\n" + "There is no validation for phone number due to bug phone number is accepting every character");
		Signuprepo.companyname.sendKeys("zenwork");
		System.out.print("\n" + "There is no validation for Comany name");
		Signuprepo.companywebsite.sendKeys("zenwork");
		System.out.print("\n" + "There is no validation for Comany site");
		//JavascriptExecutor trailexe = () driver;
		//trailexe.executeScript("arguments[0].click();", SigJavascriptExecutornuprepo.trailbutton);
		

		// driver.findElement(By.xpath("//form[@id='domain_selection_form']//input[@id='subdomain_name']"))

		JavascriptExecutor checkexe = (JavascriptExecutor) driver;
		checkexe.executeScript("arguments[0].click();", Signuprepo.checksubdomainavailability);
		Thread.sleep(2000);
		Signuprepo.subdomainname.clear();
		Signuprepo.subdomainname.sendKeys("s" + randomInt);
		// driver.findElement(By.xpath(
		// "//form[@id='domain_selection_form']//div[contains(@class,'form-fields')]//input[@id='subdomain_name']"))
		// .clear();
		// driver.findElement(By.xpath(
		// "//form[@id='domain_selection_form']//div[contains(@class,'form-fields')]//input[@id='subdomain_name']"))
		// .sendKeys("s" + randomInt);
		JavascriptExecutor checkexename = (JavascriptExecutor) driver;
		checkexename.executeScript("arguments[0].click();", Signuprepo.checksubdomainavailability);

		// WebElement checkavail = driver.findElement(
		// By.xpath("//form[@id='domain_selection_form']//span[contains(@class,'check-availability')]"));
		// JavascriptExecutor availexe = (JavascriptExecutor) driver;
		// availexe.executeScript("arguments[0].click();", checkavail);
		Thread.sleep(2000);
		Signuprepo.subdomainname.clear();
		Signuprepo.subdomainname.sendKeys("s" + randomInt);
		// driver.findElement(By.xpath(
		// "//form[@id='domain_selection_form']//div[contains(@class,'form-fields')]//input[@id='subdomain_name']"))
		// .clear();
		// driver.findElement(By.xpath(
		// "//form[@id='domain_selection_form']//div[contains(@class,'form-fields')]//input[@id='subdomain_name']"))
		// .sendKeys("s" + randomInt);

		Thread.sleep(2000);
		System.out.print("Subdomain validations completed");

		JavascriptExecutor Saveexe = (JavascriptExecutor) driver;

		Saveexe.executeScript("arguments[0].click();", Signuprepo.savedomain);
		Thread.sleep(2000);

		for (int j = 1; j <= Branchsignup.getLastRowNum(); j++) {

			// driver.findElement(By.xpath("//form[@id='new_user']//input[@id='person_email']")).clear();
			// System.out.println("\n" + "Branch detials validations:" +
			// Branchsignup.getRjw(i).getCell(i).getStringCellValue());
			Signuprepo.branchname.clear();
			Signuprepo.branchname.sendKeys(Branchsignup.getRow(j).getCell(0).getStringCellValue());
			Signuprepo.branchlocation.clear();
			// driver.findElement(By.xpath(
			// "//form[@id='add_branch_form']//div[contains(@class,'form-fields')]//input[@id='branch_location']"))
			// .clear();
			Signuprepo.city.clear();
			Signuprepo.state.clear();
			// driver.findElement(By
			// .xpath("//form[@id='add_branch_form']//div[contains(@class,'form-fields')]//input[@name='state']"))
			// .clear();
			Signuprepo.country.clear();
			// driver.findElement(By
			// .xpath("//form[@id='add_branch_form']//div[contains(@class,'form-fields')]//input[@id='country']"))
			// .clear();

			JavascriptExecutor signup = (JavascriptExecutor) driver;
			signup.executeScript("arguments[0].click();", Signuprepo.signupbutton);
			Thread.sleep(2000);
			Signuprepo.branchlocation.sendKeys(Branchsignup.getRow(j).getCell(1).getStringCellValue());
			Signuprepo.city.clear();
			Signuprepo.state.clear();
			Signuprepo.country.clear();
			JavascriptExecutor signuploc = (JavascriptExecutor) driver;
			signuploc.executeScript("arguments[0].click();", Signuprepo.signupbutton);
			Signuprepo.city.sendKeys(Branchsignup.getRow(j).getCell(2).getStringCellValue());
			Signuprepo.state.clear();
			Signuprepo.country.clear();
			JavascriptExecutor signupcity = (JavascriptExecutor) driver;
			signupcity.executeScript("arguments[0].click();", Signuprepo.signupbutton);
			Signuprepo.state.sendKeys(Branchsignup.getRow(j).getCell(3).getStringCellValue());
			Signuprepo.country.clear();
			JavascriptExecutor signupstate = (JavascriptExecutor) driver;
			signupstate.executeScript("arguments[0].click();", Signuprepo.signupbutton);
			Signuprepo.country.sendKeys(Branchsignup.getRow(j).getCell(4).getStringCellValue());
			JavascriptExecutor signupcountry = (JavascriptExecutor) driver;
			signupcountry.executeScript("arguments[0].click();", Signuprepo.signupbutton);

			Thread.sleep(3000);
		}

		*/

	

	public void Login_page() {

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://test-s2284.fidentity.com/login");

	}

	public void login_required_fields() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// PageFactory.initElements(driver, Signuprepo.class);
		PageFactory.initElements(driver, Signinrepo.class);
		Signinrepo.Username.clear();
		// driver.findElement(By.xpath("//form[@id='loginForm']//input[@id='username']")).clear();
		Signinrepo.Username.sendKeys("sridevi2284@srtest.com");
		JavascriptExecutor nextexecutor = (JavascriptExecutor) driver;
		nextexecutor.executeScript("arguments[0].click();", Signinrepo.usernamenext);

	}

	public void click_forgot_password() throws InterruptedException {
		PageFactory.initElements(driver, Signinrepo.class);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		JavascriptExecutor nextexecutor = (JavascriptExecutor) driver;
		nextexecutor.executeScript("arguments[0].click();", Signinrepo.forgotpasswordtext);
		Thread.sleep(5000);

	}

}