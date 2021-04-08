package com.demo.testcases;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.demo.Base.base;
import com.demo.PeopleLeftMenu.ManagePayerAddPayer;
import com.demo.PeopleLeftMenu.ManagePeople;
import com.demo.dataprovider.DataProviders;
import com.demo.pages.Db;
import com.demo.pages.LoginPage;
import com.demo.pages.OuterLoginButton;
import com.demo.utility.Log;

@Listeners(CustomListener.class)
public class TC_MISC_WorkingFlow_001 extends base {

	LoginPage LoginPage;
	OuterLoginButton OuterLoginButton;
	Db Db;
	ManagePeople ManagePeople;
	ManagePayerAddPayer ManagePayerAddPayer;

	@Test(priority = 1, dataProvider = "credentials", dataProviderClass = DataProviders.class)
	public void clickonLoginTest(String Useremail, String Passwd) throws Throwable {
		launchApp();

		getDriver().manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Log.startTestCase("clickonLoginTest ");
		OuterLoginButton = new OuterLoginButton();
		Log.info("User is going to clik On Outer Login Button");
		Thread.sleep(80000);
		LoginPage = OuterLoginButton.clickonLogin();
		Log.info("Enter UserName and Password");
		// Db Db =
		// LoginPage.login(prop.getProperty("UserName"),prop.getProperty("Password"));
		Db Db = LoginPage.login(Useremail, Passwd);
		Thread.sleep(40000);
	}

	@Test(priority = 2)
	public void navigate_1099MISCform() throws InterruptedException {

		Log.startTestCase("navigate_1099MISCform");

		Thread.sleep(20000);
		WebElement formselement = getDriver().findElement(By.xpath("//p[contains(text(),'Forms')]"));

		Thread.sleep(20000);
		// WebDriverWait wait=new WebDriverWait(getDriver(),60);
		formselement.click();

		// wait.until(ExpectedConditions.elementToBeClickable(formselement));
		// JavascriptExecutor passwordexecutor = (JavascriptExecutor) getDriver();
		// passwordexecutor.executeScript("arguments[0].click();", formselement);

		Log.info("Forms menu clicked");

		WebElement newform = getDriver().findElement(By.xpath("//a[contains(text(),'New Form')]"));
		// WebDriverWait formwait=new WebDriverWait(getDriver(),60);
		// formwait.until(ExpectedConditions.elementToBeClickable(newform));
Thread.sleep(5000);
		newform.click();
//	JavascriptExecutor newformexe = (JavascriptExecutor) getDriver();
//	newformexe.executeScript("arguments[0].click();", newform);
		Thread.sleep(20000);
		Log.info("New form menu clicked");

		WebElement yearelement = getDriver().findElement(By.xpath("//div[@id='vtab']//h1[contains(text(),'2020')]"));
		Thread.sleep(20000);
		yearelement.click();
		Log.info("year got selected");

		WebElement element1099 = getDriver().findElement(By.xpath("//div[@id='MISC']//h2[contains(text(),'1099')]"));

		Thread.sleep(20000);
		Actions action=new Actions(getDriver());
		action.moveToElement(element1099).click().build().perform();
	//	element1099.click();
		Thread.sleep(20000);
		Log.info("1099MISC got selected");

		Thread.sleep(20000);

	}

	@Test(priority = 3, dataProvider = "addpayerrandombusinessein", dataProviderClass = DataProviders.class)
	public void form_addpayer(HashMap<String, String> hashMapValue) throws Throwable {

		Log.startTestCase("form_addpayer");
		Thread.sleep(30000);

		WebElement addpayerbutton = getDriver().findElement(By.id("btnAddEditPayer"));
		Thread.sleep(50000);
		// addpayerbutton.click();
		JavascriptExecutor addapyerexe = (JavascriptExecutor) getDriver();
		addapyerexe.executeScript("arguments[0].click();", addpayerbutton);

		Log.info("Add payer button clicked");
		WebElement addpayerdialog = getDriver().findElement(By.id("PayerDialog"));
		Thread.sleep(20000);
		boolean addpayerdialogdisplay = addpayerdialog.isDisplayed();
		if (addpayerdialogdisplay == true) {
			Log.info("add payer dialog displayed");

			Thread.sleep(10000);
			File file = new File("src\\test\\resources\\TestData\\TestData.xlsx");
			FileInputStream fis = new FileInputStream(file);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet("1099MISCdata");

			WebElement type = getDriver().findElement(
					By.xpath("//div[@id='divFederalIdTypeForAllForms']//input[@id='rblPayerTypeBusiness']"));
			type.click();
			Thread.sleep(10000);
			Random random = new Random();
			int randomnumber = random.nextInt(1000000000);
			getDriver().findElement(By.id("PayerFedaralID")).clear();
			getDriver().findElement(By.id("PayerFedaralID")).click();
			getDriver().findElement(By.id("PayerFedaralID")).sendKeys("" + randomnumber);
			Thread.sleep(50000);
			Log.info("Random EIN:" + randomnumber);
			Row row15 = sheet.createRow(15);
			Cell cellzero15 = row15.createCell(0);
			Cell cellone15 = row15.createCell(1);
			cellzero15.setCellValue("Payer EIN number");
			cellone15.setCellValue(randomnumber);

			WebElement businessname = getDriver().findElement(By.id("PayerLastName"));

			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyyhmmss");
			String formattedDate = sdf.format(date);
			businessname.sendKeys("Test" + formattedDate);
			Thread.sleep(50000);
			String businessanmetext = businessname.getAttribute("value");
			Log.info("Payer Last name:" + businessanmetext);
			Row row = sheet.createRow(3);
			Cell cellzero = row.createCell(0);
			Cell cellone = row.createCell(1);
			cellzero.setCellValue("Payer last name");
			cellone.setCellValue(businessanmetext);
			/*
			 * Cell cell2 = row.createCell(1); // cell.setCellValue(selectedstaevalue); //
			 * Log.info(cell.getStringCellValue()); String celvalue =
			 * cellone.getStringCellValue().toString();
			 * Log.info("Random Payer EIN from exceldata :" + celvalue);
			 */

			ManagePayerAddPayer ManagePayerAddPayer = new ManagePayerAddPayer();
			// getDriver().findElement(By.id("PayerZIP")).sendKeys("35005");
			ManagePayerAddPayer.AddpayerEinNonUs(hashMapValue.get("address"), hashMapValue.get("suffix"),
					hashMapValue.get("line2"), hashMapValue.get("city"), hashMapValue.get("State"),
					hashMapValue.get("zipcode"), hashMapValue.get("Postalcode"), hashMapValue.get("Country"),

					// hashMapValue.get("checkheretoforeignaddress"),
					hashMapValue.get("phone"), hashMapValue.get("email"), hashMapValue.get("withholdingortaxstateid"),
					// hashMapValue.get("lastfiling"),
					hashMapValue.get("clientid"));
			String payeraddress = getDriver().findElement(By.xpath("//input[@id='PayerAddress']"))
					.getAttribute("value");
			Row row16 = sheet.createRow(16);
			Cell cellzero16 = row16.createCell(0);
			Cell cellone16 = row16.createCell(1);
			cellzero16.setCellValue("Payer address");
			cellone16.setCellValue(payeraddress);
			Log.info("Payer address:" + payeraddress);

			String payerCity = getDriver().findElement(By.xpath("//input[@id='PayerCity']")).getAttribute("value");
			Row row17 = sheet.createRow(17);
			Cell cellzero17 = row17.createCell(0);
			Cell cellone17 = row17.createCell(1);
			cellzero17.setCellValue("Payer City");
			cellone17.setCellValue(payerCity);
			Log.info("Payer City:" + payerCity);

			getDriver().findElement(By.id("PayerZIP")).clear();
			getDriver().findElement(By.id("PayerZIP")).click();
			getDriver().findElement(By.id("PayerZIP")).sendKeys("35010");
			Thread.sleep(10000);
			String payerZIP = getDriver().findElement(By.xpath("//input[@id='PayerZIP']")).getAttribute("value");
			Row row18 = sheet.createRow(18);
			Cell cellzero18 = row18.createCell(0);
			Cell cellone18 = row18.createCell(1);
			cellzero18.setCellValue("PayerZIP");
			cellone18.setCellValue(payerZIP);
			Log.info("Payer ZIP:" + payerZIP);

			getDriver().findElement(By.id("PayerEmail")).clear();
			getDriver().findElement(By.id("PayerPhNo")).clear();

			getDriver().findElement(By.id("PayerPhNo")).sendKeys("1234567891");
			Thread.sleep(50000);
			String payerphone = getDriver().findElement(By.xpath("//input[@id='PayerPhNo']")).getAttribute("value");
			Row row19 = sheet.createRow(19);
			Cell cellzero19 = row19.createCell(0);
			Cell cellone19 = row19.createCell(1);
			cellzero19.setCellValue("Payer Phone Number");
			cellone19.setCellValue(payerphone);
			Log.info("Payer phone number:" + payerphone);

			Select statedropdown = new Select(getDriver().findElement(By.id("PayerState")));
			statedropdown.selectByVisibleText("Alabama");
			Thread.sleep(50000);
			// ManagePayerAddPayer.validateAddEINpayer();
			// getDriver().findElement(By.xpath("//button[contains(text(),'Add')]")).click();

			WebElement addpayerAdd = getDriver().findElement(
					By.xpath("//div[@id='PayerDialog']//following-sibling::div//button[contains(text(),'Add')]"));
			WebDriverWait wait = new WebDriverWait(getDriver(), 50);
			wait.until(ExpectedConditions.elementToBeClickable(addpayerAdd));

			addpayerAdd.click();

			Thread.sleep(40000);
			Log.info("Add button clicked on add payer dialog");

			getDriver().findElement(By.id("alertify-ok")).click();
			Thread.sleep(20000);
			Log.info("Added payer alert clicked ");

			WebElement assignpayerDialog = getDriver().findElement(By.xpath("//div[@id='AssignPayerDialog']"));
			boolean assignpayerdialogdisplay = assignpayerDialog.isDisplayed();

			// getDriver().findElement(By.id("alertify-ok")).click();
			Thread.sleep(50000);

			FileOutputStream outputStream = new FileOutputStream(file);
			workbook.write(outputStream);
			workbook.close();

			if (assignpayerdialogdisplay == true) {

				getDriver().findElement(By.xpath(
						"//div[@id='AssignPayerDialog']//following-sibling::div//button[contains(text(),'Close')]"))
						.click();
				Thread.sleep(50000);
				Log.info("Added payer dialog closed");

			} else {
				Log.info("assignpayer dialog not displayed ");
			}

		}

	}

	@Test(priority = 4)
	public void form_addRecipient() throws Throwable {

		Log.startTestCase("form_addRecipient");
		getDriver().manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		File file = new File("src\\test\\resources\\TestData\\TestData.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("1099MISCdata");
		getDriver().findElement(By.id("btnAddPayee")).click();
		Thread.sleep(50000);
Actions addpayeeaction=new Actions(getDriver());

	WebElement addpayeebutton=	getDriver().findElement(By.xpath("//input[@id='rblPayeeType']"));
	addpayeeaction.moveToElement(addpayeebutton).click().build().perform();
		Thread.sleep(10000);
		Log.info("Business type selected");
		Random random = new Random();
		int randomnumber = random.nextInt(1000000000);
		getDriver().findElement(By.id("PayeeFedaralID")).clear();
		getDriver().findElement(By.id("PayeeFedaralID")).click();
		getDriver().findElement(By.id("PayeeFedaralID")).sendKeys("" + randomnumber);
		Thread.sleep(10000);

		Log.info("Random EIN entered");
		Thread.sleep(10000);
		String recipientEIN = getDriver().findElement(By.xpath("//input[@id='PayeeFedaralID']")).getAttribute("value");

		Row row8 = sheet.createRow(8);
		Cell cellzero8 = row8.createCell(0);
		Cell cellone8 = row8.createCell(1);
		cellzero8.setCellValue("Recipient EIN");
		cellone8.setCellValue(recipientEIN);
		Log.info("Recipient EIN:" + recipientEIN);

		WebElement businessname = getDriver().findElement(By.id("PayeeLastName"));

		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyyhmmss");
		String formattedDate = sdf.format(date);
		businessname.sendKeys("Test" + formattedDate);

		Log.info("Test business name entered with time stamp");

		String businessName = businessname.getAttribute("value");

		Row row = sheet.createRow(2);
		Cell cellzero = row.createCell(0);
		Cell cellone = row.createCell(1);
		cellzero.setCellValue("Recipient BusinessName");
		cellone.setCellValue(businessName);
		// Cell cell2 = row.createCell(1);
		// cell.setCellValue(selectedstaevalue);
		// Log.info(cell.getStringCellValue());

		String celvalue = cellone.getStringCellValue().toString();
		Log.info("Recipient Businessname:" + celvalue);
		String payeezipcode = "35005";
		getDriver().findElement(By.id("PayeeZIP")).clear();
		getDriver().findElement(By.id("PayeeZIP")).click();
		getDriver().findElement(By.id("PayeeZIP")).sendKeys(payeezipcode);
		Log.info("Entered payee or recipient zip code:" + payeezipcode);
		Row row9 = sheet.createRow(9);
		Cell cellzero9 = row9.createCell(0);
		Cell cellone9 = row9.createCell(1);
		cellzero9.setCellValue("Recipient zipcode");
		cellone9.setCellValue(payeezipcode);

		String payeeaddress = "US";
		getDriver().findElement(By.id("PayeeAddress")).sendKeys(payeeaddress);
		Log.info("Entered payee or recipient Address:" + payeeaddress);
		String payeecity = "Birmingham";
		getDriver().findElement(By.id("PayeeCity")).sendKeys(payeecity);
		Log.info("Entered payee or recipient city:" + payeecity);
		Row row10 = sheet.createRow(10);
		Cell cellzero10 = row10.createCell(0);
		Cell cellone10 = row10.createCell(1);
		cellzero10.setCellValue("Recipient city");
		cellone10.setCellValue(payeecity);

		String payeestate = "Alabama";
		Select statedropdown = new Select(getDriver().findElement(By.id("PayeeState")));
		statedropdown.selectByVisibleText(payeestate);
		Log.info("Selected recipient state:" + payeestate);
		Row row11 = sheet.createRow(11);
		Cell cellzero11 = row11.createCell(0);
		Cell cellone11 = row11.createCell(1);
		cellzero11.setCellValue("Recipient state");
		cellone11.setCellValue(payeestate);
		int randomclientid = random.nextInt(100000);
		String ClientRecipientId = String.valueOf(randomclientid);
		getDriver().findElement(By.id("ClientRecipientId")).sendKeys(ClientRecipientId);
		Log.info("Entered  ClientRecipientId:" + ClientRecipientId);
		Thread.sleep(30000);
		ManagePayerAddPayer ManagePayerAddPayer = new ManagePayerAddPayer();
		Row row12 = sheet.createRow(12);
		Cell cellzero12 = row12.createCell(0);
		Cell cellone12 = row12.createCell(1);
		cellzero12.setCellValue("ClientRecipientId");
		cellone12.setCellValue(ClientRecipientId);

		/*
		 * ManagePayerAddPayer.AddrecipientrandombusinessEIN( //
		 * hashMapValue.get("type"), // hashMapValue.get("einTIN"), //
		 * hashMapValue.get("ssn"), // hashMapValue.get("FirstName"), //
		 * hashMapValue.get("MiddleName"), //hashMapValue.get("LastName"), //
		 * hashMapValue.get("businessname"), hashMapValue.get("payeeAddress"),
		 * hashMapValue.get("suffix"), hashMapValue.get("payeeline2"),
		 * hashMapValue.get("payeecity"), //hashMapValue.get("State"),
		 * hashMapValue.get("zipcode"), hashMapValue.get("Country"),
		 * 
		 * // hashMapValue.get("checkheretoforeignaddress"), hashMapValue.get("phone"),
		 * hashMapValue.get("email"), hashMapValue.get("withholdingortaxstateid"), //
		 * hashMapValue.get("lastfiling"), hashMapValue.get("clientid"));
		 */

		ManagePayerAddPayer.validateAddEINpayer();
		Thread.sleep(50000);
		// getDriver().findElement(By.xpath("//section[@id='alertify']//a[@id='alertify-resetFocus']")).click();
		WebElement okbutton = getDriver().findElement(By.xpath("//button[@id='alertify-ok']"));
		Actions action = new Actions(getDriver());

		action.moveToElement(okbutton).click().build().perform();
		Thread.sleep(20000);
		Log.info("Recipient successfully added");
		Thread.sleep(20000);

		FileOutputStream outputStream = new FileOutputStream(file);
		workbook.write(outputStream);
		workbook.close();

	}

	@Test(priority = 5)
	public void singleBox() throws IOException {
		Log.startTestCase("singleBox");
		String box1value = "20";
		getDriver().manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		getDriver().findElement(By.id("Rents")).sendKeys(box1value);
		Log.info("Entered box1 value rents:" + box1value);

		File file = new File("src\\test\\resources\\TestData\\TestData.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("1099MISCdata");
		Row row13 = sheet.createRow(13);
		Cell cellzero13 = row13.createCell(0);
		Cell cellone13 = row13.createCell(1);
		cellzero13.setCellValue("Box1 value");
		cellone13.setCellValue(box1value);

		FileOutputStream outputStream = new FileOutputStream(file);
		workbook.write(outputStream);
		workbook.close();

	}

	@Test(priority = 6)
	public void saveForm1099() throws InterruptedException {
		Log.startTestCase("saveForm1099");
		getDriver().manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		WebElement saveButton = getDriver().findElement(By.id("btnSaveContinue"));
		// saveButton.click();
		JavascriptExecutor saveexe = (JavascriptExecutor) getDriver();

		saveexe.executeScript("arguments[0].click();", saveButton);

		Thread.sleep(80000);
		Log.info("Save button clicked and launched VES page");
	}

	@Test(priority = 7)

	public void validateVES_data() throws IOException, InterruptedException {
		getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Log.startTestCase("validateVES_data");
		Thread.sleep(50000);
		getDriver().manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		// -----------Verfiy recpt name---//
		File file = new File("src\\test\\resources\\TestData\\TestData.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("1099MISCdata");
		Row row = sheet.getRow(2);

		String businessname = row.getCell(1).getStringCellValue().toString();
		Log.info("Businessname:" + businessname);

		String businessnameAdded = getDriver().findElement(By.xpath("//table//tbody//tr//td[7]")).getText();
		Log.info("businessnameAdded:" + businessnameAdded);

		if (businessname.equals(businessnameAdded)) {
			Log.info("Both values are same ,Testcase passed");

		} else {

			Log.info("Test case failed , Both values are not same");
		}

		Log.info("1. Verified recipient data");

		// ---enable USPS mail--//

		WebElement uspsMail = getDriver().findElement(By.xpath("//table//tbody//tr//td//input[@id='checkboxUsps']"));
		boolean uspsEnable = uspsMail.isSelected();

		if (uspsEnable == true) {

			Log.info("Usps mail already enabled");
		} else {

			// uspsMail.click();
			Actions action = new Actions(getDriver());
			action.moveToElement(uspsMail).click().build().perform();
			if (uspsEnable == true) {

				Log.info("Usps mail already enabled when clicked now");
			}

		}
		Log.info("2.USPS mail enable completed");

		// 3. Enable email recipient
		WebElement emailenble = getDriver().findElement(By.xpath("//table//th//input[@id='selectallRecipient']"));
		boolean emailenablechk = emailenble.isSelected();
		if (emailenablechk == true) {
			// input[@id='selectallRecipient']
			Log.info("email already enabled");
		} else {

			Actions action = new Actions(getDriver());
			action.moveToElement(emailenble).click().build().perform();
			// JavascriptExecutor emailexe = (JavascriptExecutor) getDriver();
			// emailexe.executeScript("arguments[0].click();", emailenble);

			// emailenble.click();
			Log.info("Email now got enabled");
			if (emailenablechk == true) {

				Log.info("email enabled when clicked now");
			}
		}
		Log.info("3. Email enabled check completed");

		// -----------TIN check when there is not given tin----------//

		WebElement tincheck = getDriver()
				.findElement(By.xpath("//table//tbody//tr//td//input[@id='checkboxTinMatch']"));
		boolean tincheckenable = tincheck.isSelected();

		Log.info("Is TIN check enabled:" + tincheckenable);

		Log.info("4.TIN check validation completed");

		// ----------5. State filing check ---//
		WebElement statefiling = getDriver().findElement(By.xpath("//input[@id='checkboxStateFiling']"));
		boolean statefilingcheck = statefiling.isEnabled();

		Log.info("Is state filing option disabled:" + statefilingcheck);

		if (statefilingcheck == false) {

			Log.info("5.State filing chheck completed.That is statefiling option is in disabled mode");
		} else {

			Log.info("5.State filing chheck failed. beacause satefiling is in enabled mode");
		}
		// -- 6.Verify view TIN validation---//

		WebElement viewtin = getDriver().findElement(By.xpath("//input[@id='viewTIN']"));
		boolean viewtinselect = viewtin.isSelected();
		if (viewtinselect == false) {
			Log.info("View tin checkbox not selected, Let select checkbox.");
			// viewtin.click();
			JavascriptExecutor viewtinexe = (JavascriptExecutor) getDriver();
			viewtinexe.executeScript("arguments[0].click();", viewtin);
			Thread.sleep(50000);
			Log.info("Is ViewTIN checkbox selected");

			if (viewtinselect == true) {
				Log.info("View tin checkbox selected, and Verify TIN.");

			} else {
				Log.info("TIN checkbox not selected even clicked on that");
			}

		} else {

			Log.info("Vie TIN checkbox selected verify TIN");
		}

		Row payerEINrow = sheet.getRow(3);
		String payerEIN = payerEINrow.getCell(1).toString();
		Log.info("Payer EIN from excel:" + payerEIN);
		WebElement vesTIN = getDriver().findElement(By.xpath(" //*[@id=\"Grid\"]//table//tbody//tr//td[6]"));
		String vestinText = vesTIN.getAttribute("innerHTML");
		Log.info("Payer TIN displayed in VES page:" + vestinText);
		if (vestinText.equals(payerEIN)) {

			Log.info("Displaying TIN is equals Payer TIN. So,Test case passed");

		} else {

			Log.info("Dispyed TIN is not equal to Payer EIN . So, Test case failed");
		}
		Log.info("6. View TIN validation completed");

		// ---7. Scheduled date--//

		Date displaydate = new Date();
		SimpleDateFormat date = new SimpleDateFormat("MM/dd/yyyy");
		String todaysdate = date.format(displaydate);
		Log.info("Todays date in format:" + todaysdate);

		Calendar c = Calendar.getInstance();
		c.setTime(displaydate);

		c.add(Calendar.DAY_OF_MONTH, 7);

		Date scheduledate = c.getTime();

		String newscheduledate = date.format(scheduledate);
		Log.info("Scheduled date is :" + newscheduledate);

		// need to add this date to excel or get displayed date and add that one to
		// excel

		String Displayeddate = getDriver().findElement(By.xpath("//td[@id='scheduleddateinfotxt']//input"))
				.getAttribute("value");
		Log.info("Displayed schedule date is :" + Displayeddate);

		Row scheduledaterow = sheet.createRow(7);
		Cell scheduledatecell = scheduledaterow.createCell(0);
		scheduledatecell.setCellValue("SchedlueDate");
		Cell scheduledatecellvalue = scheduledaterow.createCell(1);
		scheduledatecellvalue.setCellValue(Displayeddate);

		FileOutputStream outputStream = new FileOutputStream(file);
		workbook.write(outputStream);
		workbook.close();

		// --8.Form name 1099MISC---//

		// input[@id='Forms']//preceding-sibling::span//span[@class='k-input']
		Thread.sleep(20000);
		// Select formdropdown=new
		// Select(getDriver().findElement(By.xpath("//input[@id='Forms']//preceding-sibling::span//span[@class='k-input']")));
		WebElement selectedoption = getDriver()
				.findElement(By.xpath("//input[@id='Forms']//preceding-sibling::span//span[@class='k-input']"));
		String displayedoption = selectedoption.getText();
		Log.info("Displayed form when launch VES page:" + displayedoption);

		String compareformtext = "1099-MISC";

		Log.info("Comparing from text is:" + compareformtext);

		assertEquals(displayedoption, compareformtext, "Wrong form name is displayed ");

		// 9.form year---//
//	Select yeardropdown=new Select(getDriver().findElement(By.xpath("//label[contains(text(),'Tax Year')]//following-sibling::span//span[@class='k-input']")));
		WebElement selectedoptionyear = getDriver().findElement(
				By.xpath("//label[contains(text(),'Tax Year')]//following-sibling::span//span[@class='k-input']"));
		String selectedoptionformtext = selectedoptionyear.getText();
		Log.info("Displayed year when launch VES page:" + selectedoptionformtext);
		String compareyeartext = "2020";
		Log.info("Comparing year text is:" + compareyeartext);
		assertEquals(selectedoptionformtext, compareyeartext, "Wrong Form year displayed ");

		/// --10 form status--//
		WebElement selectedformstatus = getDriver().findElement(
				By.xpath("//label[contains(text(),'Form  Status')]//following-sibling::span//span[@class='k-input']"));
		String selectedoptionformstatus = selectedformstatus.getText();
		Log.info("Displayed form status when launch VES page:" + selectedoptionformstatus);
		String formstatustext = "NotSubmitted";
		Log.info("Comparing form status text is :" + formstatustext);
		assertEquals(selectedoptionformstatus, formstatustext, "Wrong Form status displayed");

		// --11.Form type--//
		WebElement formtypeelement = getDriver()
				.findElement(By.xpath("//input[@id='FormType']//preceding-sibling::span//span[@class='k-input']"));
		String formtypedisplayed = formtypeelement.getText();
		Log.info("Displayed form type when launch VES page:" + formtypedisplayed);
		String formtypetext = "Regular";
		Log.info("Comparing form type text is :" + formtypetext);
		assertEquals(formtypedisplayed, formtypetext, "Wrong form type displayed");

		// ---12. Payer name get from excel and compare---//

		String addedpayername = sheet.getRow(3).getCell(1).toString();

		WebElement payernameelement = getDriver().findElement(
				By.xpath("//label[contains(text(),'Payer')]//following-sibling::span//span[@class='k-input']"));
		String payernamedisplayed = payernameelement.getText();
		Log.info("Displayed payer name launch VES page:" + payernamedisplayed);
//	String formtypetext="Regular";
		Log.info("Comparing payer name is  :" + addedpayername);

//======================================================================================================	
//	assertEquals(payernamedisplayed, addedpayername, "Wrong payer got displayed");

//===========================================================================================================
//--13.select all validation--//

		WebElement selectallGlobal = getDriver().findElement(By.xpath("//input[@id='selectallGlobal']"));
		boolean selectGlobalChecked = selectallGlobal.isSelected();
		Log.info("Is Selectall global option selected?  " + selectGlobalChecked);
		if (selectGlobalChecked == false) {

			JavascriptExecutor selectallexe = (JavascriptExecutor) getDriver();
			selectallexe.executeScript("arguments[0].click();", selectallGlobal);
			Log.info("Selectall global option selected now.  ");
		}
		Thread.sleep(20000);

		boolean selectGlobalCheckedafter = selectallGlobal.isSelected();
		Log.info("Is Selectall global option selected?  " + selectGlobalCheckedafter);

		boolean selectallcheck = getDriver().findElement(By.xpath("//input[@id='selectall']")).isSelected();
		boolean formdetailscheck = getDriver().findElement(By.xpath("//input[@class='chkbxq']")).isSelected();

		Log.info("is selectallchecked:" + selectallcheck + "is form details checked:" + formdetailscheck);

		if (selectallcheck == true && formdetailscheck == true) {

			Log.info("Select all checkbox validation completed");

		} else {

			Log.info("Select all validation failed");
		}
		// ------14.Next button validation---------//
		Thread.sleep(20000);
		WebElement nextbutton = getDriver().findElement(By.xpath("//input[@id='btnSubmit']"));
		boolean nextbtncheck = nextbutton.isEnabled();

		if (nextbtncheck == true) {
			Actions action = new Actions(getDriver());

			action.moveToElement(nextbutton).click().build().perform();
			Log.info("Next button is in enabled mode");
			Log.info("Next button clicked");
		} else {
			Log.info("Next button is in disabled mode");
		}
		// ---15. Submit to IRS popup---//

		String submitIRStext = getDriver()
				.findElement(By.xpath("//a[@id='alertify-resetFocusBack']//following-sibling::article")).getText();
		String popuptextdisplayed = "Please select recipient details to submit to IRS";
		// assertEquals(popuptextdisplayed, submitIRStext,"Both are not equal");
		Thread.sleep(20000);
		Actions okaction = new Actions(getDriver());
		WebElement okbutton = getDriver().findElement(By.xpath("//button[@id='alertify-ok']"));
		okaction.moveToElement(okbutton).click().build().perform();

		Log.info("Ok button clicked");

		Thread.sleep(10000);
		WebElement reviewcheckbox = getDriver().findElement(By.id("AgreeChkBoxId"));
		Actions reviewcheckboxaction = new Actions(getDriver());
		reviewcheckboxaction.moveToElement(reviewcheckbox).click().build().perform();
		Thread.sleep(20000);

		Actions okactionreview = new Actions(getDriver());
		WebElement okbuttonreview = getDriver().findElement(By.xpath("//button[@id='alertify-ok']"));
		okactionreview.moveToElement(okbuttonreview).click().build().perform();
		Log.info("Ok button on reviewed popup clicked");

		Thread.sleep(20000);

		// ---16.Dashboard seacrh---//

		WebElement dashboard = getDriver()
				.findElement(By.xpath("//div[@id='firstpane']//a[contains(text(),'Dashboard')]"));
		JavascriptExecutor dashboardexe = (JavascriptExecutor) getDriver();
		dashboardexe.executeScript("arguments[0].click();", dashboard);
		Log.info("Dashboard menu clicked");

		// addedpayername

		WebElement dashboardsearch = getDriver().findElement(By.id("filter-TIN"));

		dashboardsearch.sendKeys(addedpayername);

		Log.info("Payer record displayed");

		// --17.Navigate back to VES page--//

		// Log.startTestCase("Navigate_payer");
///----Navigate to VES page---//
		Thread.sleep(40000);
		WebElement formselement = getDriver().findElement(By.xpath("//p[contains(text(),'Forms')]"));

		Thread.sleep(20000);
		// WebDriverWait wait=new WebDriverWait(getDriver(),60);
		formselement.click();

		// wait.until(ExpectedConditions.elementToBeClickable(formselement));
		// JavascriptExecutor passwordexecutor = (JavascriptExecutor) getDriver();
		// passwordexecutor.executeScript("arguments[0].click();", formselement);
		Thread.sleep(20000);
		Log.info("Forms menu clicked");
		Thread.sleep(20000);
		WebElement sumitforms = getDriver()
				.findElement(By.xpath("//div[@id='menu_body1']//a[contains(text(),'Submit Forms')]"));
		// sumitforms.click();
		JavascriptExecutor submitformsexe = (JavascriptExecutor) getDriver();
		submitformsexe.executeScript("arguments[0].click();", sumitforms);

		// Actions submitmenuaction=new Actions(getDriver());
		// submitmenuaction.moveToElement(sumitforms).click().build().perform();
		Thread.sleep(20000);
		Log.info("VES form clicked");

		/// ------Select payer-------//

//	String addedpayername=sheet.getRow(3).getCell(1).toString();
		Log.info("Payername is:" + addedpayername);

		Thread.sleep(50000);

		getDriver().findElement(By.xpath("//span[contains(text(),'Select Payer.')]")).click();

		List<WebElement> myElements = getDriver()
				.findElements(By.xpath("//div[@id='Payers-list']//ul[@id='Payers_listbox']//li"));
		int elementssize = myElements.size();
		Log.info("Number of elements in the drop down:" + elementssize);
		for (int i = 0; i <= (elementssize - 1); i++) {

		//	Log.info(i + "." + "payer name:" + myElements.get(i).getText());
			String payername = myElements.get(i).getText();
			if (payername.equals(addedpayername)) {

				Log.info(payername);
				myElements.get(i).click();
				break;
			}
		}
		Thread.sleep(50000);

		//// ----Select year---//

		getDriver().findElement(By.xpath("	//span[contains(text(),'Select Tax')]")).click();

		List<WebElement> yearelements = getDriver()
				.findElements(By.xpath("//div[@id='TaxYear-list']//ul[@id='TaxYear_listbox']//li"));
		int yearelementssize = yearelements.size();
		Log.info("Number of years in the drop down:" + yearelementssize);
		for (int i = 0; i <= (yearelementssize - 1); i++) {

		//	Log.info(i + "." + "year:" + yearelements.get(i).getText());
			String year = yearelements.get(i).getText();
			Log.info("Selected year is:" + year);
			if (year.equals("2020")) {

				Log.info(year);
				yearelements.get(i).click();
				break;
			}

		}
		Log.info("Record displaying correctly in VES page");

	}

	@Test(priority = 8)
	public void launch_paymentPage() throws InterruptedException {

		getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		Log.startTestCase("launch_paymentPage");
		WebElement selectallGlobal = getDriver().findElement(By.xpath("//input[@id='selectallGlobal']"));
		boolean selectGlobalChecked = selectallGlobal.isSelected();
		Log.info("Is Selectall global option selected?  " + selectGlobalChecked);
		if (selectGlobalChecked == false) {

			JavascriptExecutor selectallexe = (JavascriptExecutor) getDriver();
			selectallexe.executeScript("arguments[0].click();", selectallGlobal);
			Log.info("Selectall global option selected now.  ");
		}
		Thread.sleep(20000);

		boolean selectGlobalCheckedafter = selectallGlobal.isSelected();
		Log.info("Is Selectall global option selected?  " + selectGlobalCheckedafter);

		boolean selectallcheck = getDriver().findElement(By.xpath("//input[@id='selectall']")).isSelected();
		boolean formdetailscheck = getDriver().findElement(By.xpath("//input[@class='chkbxq']")).isSelected();

		Log.info("is selectallchecked:" + selectallcheck + "is form details checked:" + formdetailscheck);

		if (selectallcheck == true && formdetailscheck == true) {

			Log.info("Select all checkbox validation completed");

		} else {

			Log.info("Select all validation failed");
		}
		// ------14.Next button validation---------//
		Thread.sleep(20000);
		WebElement nextbutton = getDriver().findElement(By.xpath("//input[@id='btnSubmit']"));
		boolean nextbtncheck = nextbutton.isEnabled();

		if (nextbtncheck == true) {
			Actions action = new Actions(getDriver());

			action.moveToElement(nextbutton).click().build().perform();
			Log.info("Next button is in enabled mode");
			Log.info("Next button clicked");
		} else {
			Log.info("Next button is in disabled mode");
		}
		// ---15. Submit to IRS popup---//
Thread.sleep(20000);
		String submitIRStext = getDriver()
				.findElement(By.xpath("//a[@id='alertify-resetFocusBack']//following-sibling::article")).getText();
		String popuptextdisplayed = "Please select recipient details to submit to IRS";
		// assertEquals(popuptextdisplayed, submitIRStext,"Both are not equal");
		Thread.sleep(20000);
		Actions okaction = new Actions(getDriver());
		WebElement okbutton = getDriver().findElement(By.xpath("//button[@id='alertify-ok']"));
		okaction.moveToElement(okbutton).click().build().perform();

		Log.info("Ok button clicked");

		Thread.sleep(10000);
		WebElement reviewcheckbox = getDriver().findElement(By.id("AgreeChkBoxId"));
		Actions reviewcheckboxaction = new Actions(getDriver());
		reviewcheckboxaction.moveToElement(reviewcheckbox).click().build().perform();
		Thread.sleep(20000);

		Actions okactionreview = new Actions(getDriver());
		WebElement okbuttonreview = getDriver().findElement(By.xpath("//button[@id='alertify-ok']"));
		okactionreview.moveToElement(okbuttonreview).click().build().perform();
		Log.info("Ok button on reviewed popup clicked");

		Thread.sleep(20000);

	}

	@Test(priority = 9)
	public void paymentpage_validations() throws InterruptedException {

		getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Log.startTestCase("paymentpage_validations");

		Log.info("--- Fee Information--");
		String totalFilingFeetext = getDriver().findElement(By.xpath("//label[contains(text(),'Total Filing Fee')]"))
				.getText();
		String totalFilingfee = getDriver().findElement(By.xpath("//Label[@id='TotalFilingFee']")).getText();
		Log.info(totalFilingFeetext + ":" + "$" + totalFilingfee);

		String prePaybalancetext = getDriver().findElement(By.xpath("//label[contains(text(),'Prepay Balance')]"))
				.getText();
		String prePayBalancefee = getDriver().findElement(By.xpath("//Label[@id='PrepayBalance']")).getText();
		Log.info(prePaybalancetext + ":" + "$" + prePayBalancefee);

		String totalAmountPaidtext = getDriver()
				.findElement(By.xpath("//label[contains(text(),'Total Amount to be Paid')]")).getText();
		String totalamount = getDriver().findElement(By.xpath("//Label[@id='AmountToBePaid']")).getText();
		Log.info(totalAmountPaidtext + ":" + "$" + totalamount);
		Thread.sleep(10000);

		Log.info("--e-Filing Fee Summary--");
		String Formcounttext = getDriver().findElement(By.xpath("//label[contains(text(),'Form Count')]")).getText();
		String numberofforms = getDriver().findElement(By.xpath("//label[@id='SubmittedFormsCount']")).getText();
		Log.info(Formcounttext + ":" + numberofforms);
		String efilingfeeText = getDriver().findElement(By.xpath("//Label[contains(text(),'e-Filing')]")).getText();
		String priceofefiling = getDriver().findElement(By.xpath("//Label[@id='FilingFee']")).getText();
		Log.info(efilingfeeText + ":" + "$" + priceofefiling);

		String tinMatchtext = getDriver().findElement(By.xpath("//label[contains(text(),'TIN Match Fee:')]")).getText();
		String tinMatchfee = getDriver().findElement(By.xpath("//Label[@id='TinMatchFee']")).getText();
		Log.info(tinMatchtext + ":" + "$" + tinMatchfee);

		String uspsMailingfeetext = getDriver().findElement(By.xpath("//label[contains(text(),'USPS Mailing Fee')]"))
				.getText();
		String uspsMailingfee = getDriver().findElement(By.xpath("//Label[@id='MailingFee']")).getText();
		Log.info(uspsMailingfeetext + ":" + "$" + uspsMailingfee);

		String stateFilingtext = getDriver().findElement(By.xpath("//label[contains(text(),'State Filing')]"))
				.getText();
		String stateFilingfee = getDriver().findElement(By.xpath("//Label[@id='StateFilingFee']")).getText();
		Log.info(stateFilingtext + ":" + "$" + stateFilingfee);

		Log.info("Name on card");
		Thread.sleep(10000);
		getDriver().findElement(By.id("CardHolderName")).sendKeys("Sree Test");
		Thread.sleep(10000);
		getDriver().findElement(By.id("CreditCardNumber")).sendKeys("4242424242424242");

		Select monthdropdown = new Select(getDriver().findElement(By.id("ExpiryMonth")));
		monthdropdown.selectByIndex(2);
		Log.info("Expiry month got selected");
		Select yeardropdown = new Select(getDriver().findElement(By.id("ExpiryYear")));
		yeardropdown.selectByVisibleText("2025");

		getDriver().findElement(By.id("CvvNumber")).sendKeys("432");

		Log.info("--Enter your billing address----");

		getDriver().findElement(By.id("Address")).sendKeys("Test address");
		Thread.sleep(10000);
		String printaddress = getDriver().findElement(By.id("Address")).getAttribute("value");
		Log.info("Address is " + printaddress);

		getDriver().findElement(By.id("City")).sendKeys("Test city");
		Thread.sleep(10000);
		String printcity = getDriver().findElement(By.id("City")).getAttribute("value");
		Log.info("City is " + printcity);

		Select statedropdown = new Select(getDriver().findElement(By.xpath("//select[@id='ddlAddressStateUS']")));
		statedropdown.selectByVisibleText("Alabama");
		Thread.sleep(10000);
		getDriver().findElement(By.id("ZIP")).sendKeys("35010");
		Select countrydropdown = new Select(getDriver().findElement(By.xpath("//select[@id='ddlCountry']")));
		countrydropdown.selectByVisibleText("UNITED STATES");
		String emailid = getDriver().findElement(By.id("Emailid")).getAttribute("value");
		boolean emailpresent = emailid.isEmpty();

		if (emailpresent == true) {

			Log.info("Email id is not enteered before, should enter now");

			getDriver().findElement(By.id("Emailid")).sendKeys("sridevi@zenwork.com");
		} else {

			Log.info("emaild is present and displayed email id is:" + emailid);
		}
		WebElement payButton = getDriver().findElement(By.id("btnPay"));

		Actions paybuttonaction = new Actions(getDriver());
		paybuttonaction.moveToElement(payButton).click().build().perform();

	}

	@Test(priority = 10)
	public void payment_confirmationPage() throws IOException, InterruptedException {
		getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Log.startTestCase("payment_confirmationPage");
		String irs = "IRS";
		String displayedText = getDriver()
				.findElement(By.xpath("//p[contains(text(),'Your return has been submitted')]")).getText();

		boolean irssubmission = displayedText.contains(irs);

		if (irssubmission == true) {

			Log.info("Text contains IRS, so form submitted to IRS");
		}

		File file = new File("src\\test\\resources\\TestData\\TestData.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("1099MISCdata");
		Row row = sheet.createRow(4);
		Cell cellzero = row.createCell(0);
		Cell cellone = row.createCell(1);
		String referencenumber = getDriver().findElement(By.xpath("//label[@for='ReferenceNumber']")).getText();

		Log.info("Reference number is:" + referencenumber);
		cellzero.setCellValue("Reference number");

		cellone.setCellValue(referencenumber);
		FileOutputStream outputStream = new FileOutputStream(file);
		workbook.write(outputStream);
		workbook.close();
	}

	@Test(priority = 11)
	public void filing_history() throws InterruptedException, IOException {

		Log.startTestCase("filing_history");
		File file = new File("src\\test\\resources\\TestData\\TestData.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("1099MISCdata");
		String referencenumber = getDriver().findElement(By.xpath("//label[@for='ReferenceNumber']")).getText();

		Log.info("Reference number is:" + referencenumber);
		WebElement filinghistorymenuitem = getDriver()
				.findElement(By.xpath("//p//a[@href='/Protected/FilingHistory']"));
		Thread.sleep(10000);
		// filinghistorymenuitem.click();
		Actions linkaction = new Actions(getDriver());
		linkaction.moveToElement(filinghistorymenuitem).click().build().perform();

		String celltype = sheet.getRow(4).getCell(1).getCellType().toString();
		Log.info("cell type is:" + celltype);
		// String
		// referencenumber=(int)sheet.getRow(4).getCell(1).getNumericCellValue()+"";
		String referencenumberexcel = String.valueOf(sheet.getRow(4).getCell(1).getRichStringCellValue());
		Log.info("Reference number:" + referencenumberexcel);

		boolean formdisplay = getDriver().findElement(By.xpath("//tr//td[contains(text(),'" + referencenumberexcel
				+ "')]//following-sibling::td//span//a[contains(text(),'Click here')]")).isDisplayed();

		Log.info("referencenumber is displayed or not :" + formdisplay);

		// By.xpath("//*[contains(text(),'"+searchText+"')]"));

		WebElement filinghistorylink = getDriver().findElement(By.xpath("//tr//td[contains(text(),'" + referencenumber
				+ "')]//following-sibling::td//span//a[contains(text(),'Click here')]"));

		Actions filinglinkaction = new Actions(getDriver());
		filinglinkaction.moveToElement(filinghistorylink).click().build().perform();
		Log.info("Clicked on filing history link");

		////// By.xpath("//*[contains(text(),'"+searchText+"')]"));

	}

	@Test(priority = 12)
	public void manageforms() throws IOException {
		getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Log.startTestCase("manageforms");
		File file = new File("src\\test\\resources\\TestData\\TestData.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("1099MISCdata");
		String addedpayername = sheet.getRow(3).getCell(1).toString();

		WebElement payernameelement = getDriver().findElement(By.xpath(
				"//label[@id='ReconPaymentPage']//following-sibling::ul//label[contains(text(),'Payer')]//following-sibling::span//span[@class='k-input']"));
		String payernamedisplayed = payernameelement.getText();
		Log.info("Displayed payer name launch VES page:" + payernamedisplayed);
//		String formtypetext="Regular";
		Log.info("Comparing payer name is  :" + addedpayername);

		WebElement selectedoptionyear = getDriver().findElement(
				By.xpath("//label[contains(text(),'Tax Year')]//following-sibling::span//span[@class='k-input']"));
		String selectedoptionformtext = selectedoptionyear.getText();
		Log.info("Displayed year when launch VES page:" + selectedoptionformtext);
		String compareyeartext = "2020";
		Log.info("Comparing year text is:" + compareyeartext);
		Log.info("Correct Tax year displayed");
		assertEquals(selectedoptionformtext, compareyeartext, "Wrong Form year displayed ");
		/// ********************************upto payername completed need to do tax year
		/// and table data***************///
	}

	@Test(priority = 13)
	public void dashboardsearch_submitted() throws IOException, InterruptedException {
		getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Log.startTestCase("dashboardsearch_submitted");
		File file = new File("src\\test\\resources\\TestData\\TestData.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("1099MISCdata");
		String addedpayername = sheet.getRow(3).getCell(1).toString();

		WebElement dashboard = getDriver()
				.findElement(By.xpath("//div[@id='firstpane']//a[contains(text(),'Dashboard')]"));
		JavascriptExecutor dashboardexe = (JavascriptExecutor) getDriver();
		dashboardexe.executeScript("arguments[0].click();", dashboard);
		Log.info("Dashboard menu clicked");
		Thread.sleep(20000);
		// addedpayername
		// getDriver().navigate().refresh();
		Thread.sleep(20000);
		WebElement dashboardsearch = getDriver().findElement(By.id("filter-TIN"));
		Thread.sleep(10000);
		dashboardsearch.sendKeys(addedpayername);
		Thread.sleep(10000);
		Log.info("Entered payer name" + addedpayername);
		Log.info("Payer record displayed");
		Thread.sleep(20000);
		Select statusfilter = new Select(getDriver().findElement(By.id("filter-status")));
		statusfilter.selectByVisibleText("Submitted");
		Thread.sleep(10000);
		Select yearfilter = new Select(getDriver().findElement(By.id("filter-year")));
		yearfilter.selectByVisibleText("2020");
		Thread.sleep(10000);
		
		
		String addedreference = sheet.getRow(4).getCell(1).toString();
		
		boolean referencenumber = getDriver()
				.findElement(By.xpath("//div[@id='Forms']//table//tr//td[contains(text(),'" + addedreference + "')]"))
				.isDisplayed();
if(referencenumber==true) {
		Log.info("record displayed with reference number:" + addedreference + " is " + referencenumber);
}else {
	
	Log.info("Record is not displayed with this reference number");
}
		// referencenumber.getAttribute("value");

	}

}
