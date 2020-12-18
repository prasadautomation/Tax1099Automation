package Fidentity_pages;

import java.awt.AWTException;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Common.Fid_base;
import Object_repo.EventsRepo;
import Object_repo.Visitorsrepo;
import cucumber.api.java.it.Date;

public class Gatepass extends Fid_base {

	public void visitorPassMenu() throws InterruptedException, AWTException {
		PageFactory.initElements(driver, Visitorsrepo.class);
		// driver.findElement(By.xpath("//li[@id='service_vms_parent']//a//i")).click();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		JavascriptExecutor visitorsiconexe = (JavascriptExecutor) driver;
		visitorsiconexe.executeScript("arguments[0].click();", Visitorsrepo.visitorsicon);
		System.out.print("\n" + "visitors menu clicked");
		JavascriptExecutor visitorpassexe = (JavascriptExecutor) driver;
		visitorpassexe.executeScript("arguments[0].click();", Visitorsrepo.visitorpass);
		System.out.print("\n" + "Visitor pass clicked");
		JavascriptExecutor createvisitorexe = (JavascriptExecutor) driver;
		createvisitorexe.executeScript("arguments[0].click();", Visitorsrepo.createvisitorbutton);

	}

	public void gatepassFields() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		String formtag = Visitorsrepo.visitorpassform.getTagName();
		System.out.println("\n" + "format tag:" + formtag);

		// Visitorsrepo.workflowdropdown.click();

		/*
		 * new WebDriverWait(driver, 15).until(
		 * ExpectedConditions.elementToBeClickable(Visitorsrepo.workflowdropdown));
		 * Visitorsrepo.workflowdropdown.click();
		 */
boolean visibletype=Visitorsrepo.chososecheckintype.isDisplayed();
if (visibletype==true) {
		Select chooseworkflow = new Select(Visitorsrepo.chososecheckintype);
		chooseworkflow.selectByIndex(1);
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(100);
		Visitorsrepo.visitioremail.sendKeys("sreee" + randomInt + "@zenwork.com");
		Visitorsrepo.visitiorname.sendKeys("Sree test");
		// WebElement phone=driver.findElement(By.id("invite_country_code"));
		Select phone = new Select(driver.findElement(By.id("invite_country_code")));
		// phone.selectByValue(value);

		phone.selectByIndex(2);
		Random randomGeneratephone = new Random();
		int randomphone = randomGeneratephone.nextInt(100);
		Visitorsrepo.visitorphone.sendKeys("1"+randomphone);

		JavascriptExecutor extendtimexecutor = (JavascriptExecutor) driver;
		extendtimexecutor.executeScript("arguments[0].click();", Visitorsrepo.invitedate);

		System.out.print("\n" + "Clicked on from date field");

		WebElement todaybutton = driver.findElement(By.xpath("//button[contains(text(),'Today')]"));
		JavascriptExecutor todayexe = (JavascriptExecutor) driver;
		todayexe.executeScript("arguments[0].click();", todaybutton);
		System.out.print("\n" + "Selected today's date");
		Thread.sleep(2000);

		WebElement OKbutton = driver.findElement(By.xpath("//button[contains(text(),'Ok')]"));
		JavascriptExecutor OKexe = (JavascriptExecutor) driver;
		OKexe.executeScript("arguments[0].click();", OKbutton);
		System.out.print("\n" + "Clicked on ok button");

		// input[@id='event_from_date']

		JavascriptExecutor fromtimeexe = (JavascriptExecutor) driver;
		fromtimeexe.executeScript("arguments[0].click();", Visitorsrepo.invitetime);
		Thread.sleep(1000);
		System.out.print("\n" + "Click on from time field");

		WebElement eventfromtime = driver.findElement(By
				.xpath("//input[@id='invite_time']//parent::div//following-sibling::div//div[contains(text(),'22')]"));
		String timetext = eventfromtime.getText();
		eventfromtime.click();
		// JavascriptExecutor fromtimeclockexe = (JavascriptExecutor) driver;
		// fromtimeclockexe.executeScript("arguments[0].click();", eventfromtime);
		System.out.print("\n" + "Selected time is :" + timetext);
		System.out.print("\n" + "Selected from time");
		Thread.sleep(5000);

		WebElement fromtimeok = driver.findElement(By.xpath("//button[contains(text(),'OK')]"));
		JavascriptExecutor fromtimeokexe = (JavascriptExecutor) driver;
		fromtimeokexe.executeScript("arguments[0].click();", fromtimeok);
		Select gender = new Select(driver.findElement(By.id("invite_gender")));
		gender.selectByVisibleText("She");
		Select expectedtime = new Select(driver.findElement(By.id("invitee_expected_out_time")));
		expectedtime.selectByVisibleText("1 Hour");

}	//else {SYstem}	// Select workflow=new Select(Visitorsrepo.chososecheckintype);
		// workflow.selectByIndex(2);

		// driver.findElement(By.xpath("//form[@id='generate_gatepss_form']//div//div//div//div//input")).click();

		/*
		 * JavascriptExecutor workflowexe = (JavascriptExecutor) driver;
		 * workflowexe.executeScript("arguments[0].click();",
		 * Visitorsrepo.workflowdropdown); //Visitorsrepo.chososecheckintype.click(); //
		 * Select workflow=new Select(Visitorsrepo.chososecheckintype);
		 * //workflow.selectByVisibleText("Choose a Visitor Type");
		 * 
		 * //workflow.selectByVisibleText("Vistor");
		 * System.out.print("\n"+"Drop down got selected");
		 * 
		 * Select workflow=new Select(driver.findElement(By.xpath(
		 * "//form[@id='generate_gatepss_form']//select[@id='checkin_type']")));
		 * workflow.selectByIndex(2);
		 */

		/*
		 * 
		 * driver.findElement(By.xpath(
		 * "//form[@id='generate_gatepss_form']//div//div[1]//input[@id='invite_email']"
		 * )) .sendKeys("sridevi456@zenwork.com");
		 * 
		 * // driver.findElement(By.xpath("//form[@id='generate_gatepss_form']//input[@
		 * value='USA // (+1)']")).click();
		 * 
		 * java.util.List<WebElement> allOptions = driver .findElements(By.xpath(
		 * "//input[@class='select-dropdown']//following-sibling::ul"));
		 * 
		 * for (WebElement item : allOptions) {
		 * 
		 * String country = item.getText(); if (country.contains("India")) {
		 * driver.findElement(By.xpath("//li//span[contains(text(),'India')]")).click();
		 * System.out.println("India got selected"); } }
		 * 
		 * driver.findElement(By.xpath("//input[@id='invite_name']")).sendKeys("Alexa");
		 * // driver.findElement(By.xpath("//form[@id='generate_gatepss_form']//input[@
		 * value='Visitor // Type']")).click();
		 * 
		 * WebElement visitortype = driver .findElement(By.
		 * xpath("//form[@id='generate_gatepss_form']//input[@value='Visitor Type']"));
		 * JavascriptExecutor typeexecutor = (JavascriptExecutor) driver;
		 * typeexecutor.executeScript("arguments[0].click();", visitortype);
		 * 
		 * // Select visitortype= new // Select(driver.findElement(By.xpath(
		 * "//form[@id='generate_gatepss_form']//div//select[@id='checkin_type']"))); //
		 * visitortype.selectByVisibleText("Other"); //
		 * driver.findElement(By.xpath("//input[@value='Visitor //
		 * Type']//following-sibling::ul//li//span[contains(text(),'Other')]")).click();
		 * 
		 * WebElement Other = driver.findElement( By.
		 * xpath("//input[@value='Visitor Type']//following-sibling::ul//li//span[contains(text(),'Other')]"
		 * )); JavascriptExecutor Othertypeexecutor = (JavascriptExecutor) driver;
		 * Othertypeexecutor.executeScript("arguments[0].click();", Other);
		 * 
		 * driver.findElement(By.xpath("//input[@id='invite_coming_from']")).
		 * sendKeys("Test business"); Calendar calendar =
		 * Calendar.getInstance(TimeZone.getDefault()); java.util.Date date =
		 * calendar.getTime(); int day = calendar.get(Calendar.DATE); int tomorrow = day
		 * + 1; System.out.print("today is :" + day);
		 * 
		 * driver.findElement(By.xpath("//input[@id='invite_date']")).click();
		 * 
		 * driver.findElement(By.xpath(
		 * "//div[@class='picker__footer']//button[contains(text(),'Today')]")).click();
		 * driver.findElement(By.xpath(
		 * "//div[@class='picker__footer']//button[contains(text(),'Ok')]")).click();
		 * 
		 * // driver.findElement(By.xpath("//div//input[@id='invite_time']")).click();
		 * 
		 * WebElement we =
		 * driver.findElement(By.xpath("//div//input[@id='invite_time']"));
		 * JavascriptExecutor passexecutor = (JavascriptExecutor) driver;
		 * passexecutor.executeScript("arguments[0].click();", we);
		 * 
		 * driver.findElement(By.
		 * xpath("//div[@class='clockpicker-tick' and contains(text(),'18')]")).click();
		 * driver.findElement(By.
		 * xpath("//div[@class='clockpicker-tick' and contains(text(),'30')]")).click();
		 * 
		 * Thread.sleep(3000); WebElement generate = driver .findElement(By.
		 * xpath("//a[@class='primary-button' and contains(text(),'Generate')]"));
		 * JavascriptExecutor genearteexecutor = (JavascriptExecutor) driver;
		 * 
		 * genearteexecutor.executeScript("arguments[0].click();", generate);
		 * 
		 * /* WebElement dateWidgetFrom =
		 * driver.findElement(By.xpath("//table[@id='invite_date_table']//tbody"));
		 * 
		 * List<WebElement> allDates=driver.findElements(By.xpath(
		 * "//table[@class='ui-datepicker-calendar']//td//div"));
		 * 
		 * for(WebElement ele:allDates) {
		 * 
		 * System.out.println("/n"+"Selected date is --"+ele); String
		 * selecteddate=ele.getText();
		 * 
		 * if(selecteddate.equals(tomorrow)) {
		 * System.out.println("/n"+"Selected date is if loop --"+ele); ele.click();
		 * break; }
		 * 
		 * }
		 */

		// driver.findElement(By.xpath("//div[@class='picker__footer']//button[contains(text(),'OK')]")).click();*/
	}

	public void save_visitorpass() throws InterruptedException {

		PageFactory.initElements(driver, Visitorsrepo.class);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		JavascriptExecutor savepassexe = (JavascriptExecutor) driver;
		savepassexe.executeScript("arguments[0].click();", Visitorsrepo.createvisitorpass);
		Thread.sleep(2000);
	}

	public void reset_visitorpass() throws InterruptedException {
		PageFactory.initElements(driver, Visitorsrepo.class);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		JavascriptExecutor resetexe = (JavascriptExecutor) driver;
		resetexe.executeScript("arguments[0].click();", Visitorsrepo.resetpass);
		Thread.sleep(2000);

	}

	public void cancel_visitorpass() throws InterruptedException {
		PageFactory.initElements(driver, Visitorsrepo.class);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		JavascriptExecutor cancelexe = (JavascriptExecutor) driver;
		cancelexe.executeScript("arguments[0].click();", Visitorsrepo.cancelvisitorpass);
		Thread.sleep(2000);

	}

	public void check_mandatory() throws InterruptedException {
		PageFactory.initElements(driver, Visitorsrepo.class);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		Gatepass gatepass = new Gatepass();
		gatepass.save_visitorpass();
		System.out.print("\n" + "type error should be displayed ");
		Select chooseworkflow = new Select(Visitorsrepo.chososecheckintype);
		chooseworkflow.selectByIndex(1);
		Thread.sleep(2000);
		gatepass.save_visitorpass();

		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(100);
		Visitorsrepo.visitioremail.sendKeys("sreee" + randomInt + "@zenwork.com");
		Visitorsrepo.visitiorname.sendKeys("Sree test");
		gatepass.save_visitorpass();
		Thread.sleep(2000);
		// WebElement phone=driver.findElement(By.id("invite_country_code"));
		Select phone = new Select(driver.findElement(By.id("invite_country_code")));
		// phone.selectByValue(value);

		phone.selectByIndex(2);
		Visitorsrepo.visitorphone.sendKeys("55555");
		gatepass.save_visitorpass();
		Thread.sleep(2000);

		JavascriptExecutor extendtimexecutor = (JavascriptExecutor) driver;
		extendtimexecutor.executeScript("arguments[0].click();", Visitorsrepo.invitedate);

		System.out.print("\n" + "Clicked on from date field");

		WebElement todaybutton = driver.findElement(By.xpath("//button[contains(text(),'Today')]"));
		JavascriptExecutor todayexe = (JavascriptExecutor) driver;
		todayexe.executeScript("arguments[0].click();", todaybutton);
		System.out.print("\n" + "Selected today's date");
		Thread.sleep(2000);

		WebElement OKbutton = driver.findElement(By.xpath("//button[contains(text(),'Ok')]"));
		JavascriptExecutor OKexe = (JavascriptExecutor) driver;
		OKexe.executeScript("arguments[0].click();", OKbutton);
		System.out.print("\n" + "Clicked on ok button");

		// input[@id='event_from_date']
		gatepass.save_visitorpass();
		Thread.sleep(2000);
		JavascriptExecutor fromtimeexe = (JavascriptExecutor) driver;
		fromtimeexe.executeScript("arguments[0].click();", Visitorsrepo.invitetime);
		Thread.sleep(1000);
		System.out.print("\n" + "Click on from time field");

		WebElement eventfromtime = driver.findElement(By
				.xpath("//input[@id='invite_time']//parent::div//following-sibling::div//div[contains(text(),'22')]"));
		String timetext = eventfromtime.getText();
		eventfromtime.click();
		// JavascriptExecutor fromtimeclockexe = (JavascriptExecutor) driver;
		// fromtimeclockexe.executeScript("arguments[0].click();", eventfromtime);
		System.out.print("\n" + "Selected time is :" + timetext);
		System.out.print("\n" + "Selected from time");
		Thread.sleep(5000);

		WebElement fromtimeok = driver.findElement(By.xpath("//button[contains(text(),'OK')]"));
		JavascriptExecutor fromtimeokexe = (JavascriptExecutor) driver;
		fromtimeokexe.executeScript("arguments[0].click();", fromtimeok);

		gatepass.save_visitorpass();
		Thread.sleep(2000);

		Select gender = new Select(driver.findElement(By.id("invite_gender")));
		gender.selectByVisibleText("She");
		Select expectedtime = new Select(driver.findElement(By.id("invitee_expected_out_time")));
		expectedtime.selectByVisibleText("1 Hour");

	}

	public void nav_visitorpass() throws InterruptedException {

		PageFactory.initElements(driver, Visitorsrepo.class);
		// driver.findElement(By.xpath("//li[@id='service_vms_parent']//a//i")).click();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		JavascriptExecutor visitorsiconexe = (JavascriptExecutor) driver;
		visitorsiconexe.executeScript("arguments[0].click();", Visitorsrepo.visitorsicon);
		System.out.print("\n" + "visitors menu clicked");
		JavascriptExecutor visitorpassexe = (JavascriptExecutor) driver;
		visitorpassexe.executeScript("arguments[0].click();", Visitorsrepo.visitorpass);
		System.out.print("\n" + "Visitor pass clicked");
		Thread.sleep(2000);
	}

	public void Unused_gatepass() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		Select statusfiletr = new Select(driver.findElement(By.id("gatepass_filterByStatus")));
		statusfiletr.selectByVisibleText("Un Used");
		Thread.sleep(2000);
		int flag = 0;
		List<WebElement> allvalue = driver.findElements(By.xpath("//span[contains(text(),'unused')]"));
		// for printing everything in the table

		int count = allvalue.size();
		System.out.print("\n" + "number of unused records:" + count);
		if (count != 0) {
			for (int i = 0; i < count; i++) {
				// System.out.println("Status of location are : " + allvalue.get(i).getText());

				// if (allvalue.get(i).getText().equals("unused")) {

				// flag++;}
				WebElement deleteicon = driver.findElement(By.xpath("//a[contains(@id,'gatepass_delete')]"));
				JavascriptExecutor deleteiconexe = (JavascriptExecutor) driver;
				deleteiconexe.executeScript("arguments[0].click();", deleteicon);
				Thread.sleep(2000);

				JavascriptExecutor deleteconfirmexe = (JavascriptExecutor) driver;
				deleteconfirmexe.executeScript("arguments[0].click();", Visitorsrepo.deletepassconfirm);
				break;
			}
		} else {
			System.out.print("\n" + "there are no unused visitorpass available");
		}
		System.out.println("\n" + "Unused passes : " + flag);

		if (flag >= 1) {
			WebElement firstrow = driver.findElement(
					By.xpath("//div[@class='container-fluid']//div[@class='card my-card']//li//table//tbody//tr[1]"));
			JavascriptExecutor firstrowclick = (JavascriptExecutor) driver;

			firstrowclick.executeScript("arguments[0].click();", firstrow);

			Thread.sleep(3000);
		} else {
			System.out.println("There are no unused passes");
		}
	}

	public void resend_gatepass() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		Select statusfiletr = new Select(driver.findElement(By.id("gatepass_filterByStatus")));
		statusfiletr.selectByVisibleText("Un Used");
		Thread.sleep(2000);
		int flag = 0;
		List<WebElement> allvalue = driver.findElements(By.xpath("//span[contains(text(),'unused')]"));
		// for printing everything in the table

		int count = allvalue.size();
		try {
			System.out.print("\n" + "number of unused records:" + count);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (count != 0) {
			for (int i = 0; i < count; i++) {
				// System.out.println("Status of location are : " + allvalue.get(i).getText());

				// if (allvalue.get(i).getText().equals("unused")) {

				// flag++;}
				WebElement resendiocn = driver.findElement(By.xpath("//a[contains(@id,'gatepass_resend')]"));
				JavascriptExecutor resendiconexe = (JavascriptExecutor) driver;
				resendiconexe.executeScript("arguments[0].click();", resendiocn);
				Thread.sleep(2000);

				JavascriptExecutor resendpassconfirmexe = (JavascriptExecutor) driver;
				resendpassconfirmexe.executeScript("arguments[0].click();", Visitorsrepo.resendpassconfirm);
				break;
			}
		} else {
			System.out.print("\n" + "there are no unused visitorpass available");
		}

	/*	WebElement resend = driver.findElement(By.xpath("//a[@class='primary-button' and contains(text(),'Resend')]"));
		JavascriptExecutor resendexecutorwclick = (JavascriptExecutor) driver;

		resendexecutorwclick.executeScript("arguments[0].click();", resend);

		WebElement sendconfirm = driver.findElement(By
				.xpath("//div[@id='resend_pass_modal']//a[@class='primary-button' and contains(text(),'Yes, Send')]"));
		JavascriptExecutor resendexecutor = (JavascriptExecutor) driver;
		resendexecutor.executeScript("arguments[0].click();", sendconfirm);*/

	}

	public void delete_gatepass() throws InterruptedException {

		List<WebElement> numberofpasses = driver.findElements(By.xpath(
				"//div[@class='container-fluid']//div[@class='card my-card']//li//table//tbody//tr//td[5]//span[2]"));
		int count = numberofpasses.size();
		if (count != 0) {
			System.out.println("\n" + "Count is " + count);
			/*
			 * List<WebElement> elements = driver.findElements(By.
			 * xpath("//div[@class='container-fluid']//div[@class='card my-card']//li//table//tbody//tr//td[5]//span[2]"
			 * )); for(int i =0;i<elements.size();i++){ //
			 * System.out.println("Status of location are : " + allvalue.get(i).getText());
			 * 
			 * if(elements.get(i).getText().equals("unused")) { Thread.sleep(2000);
			 * driver.findElement(By.
			 * xpath("//div[@class='container-fluid']//div[@class='card my-card']//li[i]")).
			 * click(); System.out.print("/n"+"unused row clciked"+"/n"); break;
			 * 
			 * }
			 * 
			 * 
			 * }
			 */

			int flag = 0;
			List<WebElement> allvalue = driver.findElements(By.xpath(
					"//div[@class='container-fluid']//div[@class='card my-card']//li//table//tbody//tr//td[5]//span[2]"));
			// for printing everything in the table

			for (int i = 0; i < allvalue.size(); i++) {

				if (allvalue.get(i).getText().equals("unused")) {

					flag++;
				}

			}
			System.out.println("\n" + "Unused locations : " + flag);

			if (flag >= 1) {
				WebElement firstrow = driver.findElement(By
						.xpath("//div[@class='container-fluid']//div[@class='card my-card']//li//table//tbody//tr[1]"));
				JavascriptExecutor firstrowclick = (JavascriptExecutor) driver;

				firstrowclick.executeScript("arguments[0].click();", firstrow);

				Thread.sleep(3000);

				WebElement deletepass = driver
						.findElement(By.xpath("//a[@class='reset-button' and contains(text(),'Delete')]"));
				JavascriptExecutor deleteexecutor = (JavascriptExecutor) driver;
				deleteexecutor.executeScript("arguments[0].click();", deletepass);
				Thread.sleep(3000);
				WebElement deleteconfirm = driver.findElement(By.xpath(
						"//div[@id='delete_pass_modal']//a[@class='delete-button' and contains(text(),'Yes, Delete')]"));
				JavascriptExecutor deleteconfirmexecutor = (JavascriptExecutor) driver;
				deleteconfirmexecutor.executeScript("arguments[0].click();", deleteconfirm);

			} else {
				System.out.println("There are no unused passes");
			}
		} else {
			System.out.print("\n" + "Ther ein no records");
		}

	}

}
