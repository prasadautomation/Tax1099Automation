package Fidentity_pages;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Common.Fid_base;

import Object_repo.EventsRepo;
import Object_repo.Signuprepo;

public class Events extends Fid_base {

	public void navigation_products() throws InterruptedException {
		Thread.sleep(10000);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		PageFactory.initElements(driver, EventsRepo.class);
		WebDriverWait wait = new WebDriverWait(driver, 50);
		WebElement icon = wait.until(ExpectedConditions.visibilityOf(EventsRepo.productsicon));
		JavascriptExecutor productsexe = (JavascriptExecutor) driver;
		productsexe.executeScript("arguments[0].click();", icon);

	}

	public void select_eventsproduct() {

		JavascriptExecutor eventsproductexe = (JavascriptExecutor) driver;
		eventsproductexe.executeScript("arguments[0].click();", EventsRepo.eventsproduct);
	}

	public void creteevent_button() {

		JavascriptExecutor eventcreateexe = (JavascriptExecutor) driver;
		eventcreateexe.executeScript("arguments[0].click();", EventsRepo.eventcreatebutton);
	}

	public void selectOptionWithText(String textToSelect) {
		PageFactory.initElements(driver, Signuprepo.class);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		try {

			WebElement autoOptions = EventsRepo.eventlocation;
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(autoOptions));

			java.util.List<WebElement> optionsToSelect = autoOptions
					.findElements(By.xpath("//span[contains(text(),'The Platina')]"));
			for (WebElement option : optionsToSelect) {
				if (option.getText().equals(textToSelect)) {
					System.out.println("Trying to select: " + textToSelect);
					option.click();
					break;
				}
			}

		} catch (NoSuchElementException e) {
			System.out.println(e.getStackTrace());
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}

	public void required_details() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		PageFactory.initElements(driver, EventsRepo.class);
		Thread.sleep(2000);
		Select location_dropdown = new Select(driver.findElement(By.id("branch_id")));
		location_dropdown.selectByIndex(1);

		Thread.sleep(2000);
		System.out.print("\n" + "Selected location");
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(10000);
		EventsRepo.eventname.clear();
		EventsRepo.eventname.sendKeys("TestEvent" + randomInt);

		WebElement location = driver.findElement(By.id("event_location"));
		location.clear();

		location.sendKeys("the platina gachibowli");
		selectOptionWithText("The Platina");
		Thread.sleep(10000);

		/*
		 * WebElement frametext =driver.findElement(By.
		 * xpath("//div//span[contains(text(),'The platina')]/ancestor::div//preceding-sibling::iframe[1]"
		 * )); driver.switchTo().frame(frametext);
		 * System.out.print("\n"+"Switched to frame: "+frametext.getClass());
		 * //driver.switchTo().defaultContent();
		 * 
		 * //driver.switchTo().f List <WebElement> address=driver.findElements(By.xpath(
		 * "//div//span[contains(text(),'Platina')]"));
		 * 
		 * String getadress=address.get(2).getText();
		 * System.out.print("\n"+"getadress:"+getadress); Actions actions=new
		 * Actions(driver); actions.moveToElement(address.get(2)).build().perform();
		 * driver.switchTo().defaultContent(); /*int size=address.size(); for(int
		 * i=0;i<=size;i++) { actions.moveToElement(address.get(i)).build().perform(); }
		 */
		// WebElement
		// address=driver.findElement(By.xpath("//span[contains(text(),'Gachibowli')]"));
		// address.click();
		// WebElement selecttime =
		// driver.findElement(By.xpath("//div[@id='extendTImeModal']//form[@id='extendTimeForm']//p//label[@for='time2']"));
		JavascriptExecutor extendtimexecutor = (JavascriptExecutor) driver;
		extendtimexecutor.executeScript("arguments[0].click();", EventsRepo.eventfromdate);

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
		fromtimeexe.executeScript("arguments[0].click();", EventsRepo.eventfromtime);
		Thread.sleep(1000);
		System.out.print("\n" + "Click on from time field");

		WebElement eventfromtime = driver.findElement(By.xpath(
				"//input[@id='event_from_time']//parent::div//following-sibling::div//div[contains(text(),'22')]"));
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

		System.out.print("\n" + "Selected ok button for from time");

		JavascriptExecutor eventtodateexe = (JavascriptExecutor) driver;
		eventtodateexe.executeScript("arguments[0].click();", EventsRepo.eventtodate);
		System.out.print("\n" + "Clicked on todate field");

		WebElement eventtodate = driver
				.findElement(By.xpath("//div[@id='event_to_date_root']//button[contains(text(),'Today')]"));
		JavascriptExecutor eventtotodayexe = (JavascriptExecutor) driver;
		eventtotodayexe.executeScript("arguments[0].click();", eventtodate);
		Thread.sleep(2000);
		System.out.print("\n" + "Event todate selected");

		WebElement eventtodateok = driver
				.findElement(By.xpath("//div[@id='event_to_date_root']//button[contains(text(),'Ok')]"));
		JavascriptExecutor eventtodateokexe = (JavascriptExecutor) driver;
		eventtodateokexe.executeScript("arguments[0].click();", eventtodateok);
		Thread.sleep(2000);
		System.out.print("\n" + "Event todate ok clicked");

		Thread.sleep(2000);
		JavascriptExecutor eventtotimeexe = (JavascriptExecutor) driver;
		eventtotimeexe.executeScript("arguments[0].click();", EventsRepo.eventtotime);
		Thread.sleep(2000);

		WebElement eventtohr = driver.findElement(By.xpath(
				"//input[@id='event_to_time']//parent::div//following-sibling::div//div[contains(text(),'23')]"));
//JavascriptExecutor eventtohrexe = (JavascriptExecutor) driver;
//eventtohrexe.executeScript("arguments[0].click();", eventtohr);	
		eventtohr.click();
		System.out.print("\n" + "Selected time" + eventtohr.getText());
		Thread.sleep(2000);
		WebElement eventtotimeok = driver.findElement(By.xpath(
				"//input[@id='event_to_time']//parent::div//following-sibling::div//button[contains(text(),'OK')]"));
		JavascriptExecutor eventtotimeokexe = (JavascriptExecutor) driver;
		eventtotimeokexe.executeScript("arguments[0].click();", eventtotimeok);
		System.out.print("\n" + "event totime ok clicked ");
		EventsRepo.contactphone.clear();
		EventsRepo.contactphone.sendKeys("22222");
		;

	}

	public void button_createevent() throws InterruptedException {

		PageFactory.initElements(driver, EventsRepo.class);
		EventsRepo.eventadd.click();
		Thread.sleep(2000);
		// JavascriptExecutor eventaddexe=(JavascriptExecutor)driver;
		// eventaddexe.executeScript("argumnets[0].click();",EventsRepo.eventadd);
	}

	public void confirm_createevent() {
		PageFactory.initElements(driver, EventsRepo.class);
		EventsRepo.eventadd_confirm.click();
		// JavascriptExecutor eventconfirmexe=(JavascriptExecutor)driver;
		// eventconfirmexe.executeScript("argumnets[0].click();",EventsRepo.eventadd_confirm);

	}

	public void cancel_createevent() throws InterruptedException {

		PageFactory.initElements(driver, EventsRepo.class);
		Thread.sleep(2000);
		EventsRepo.button_cancelevent.click();

	}

	public void reset_eventcreation() throws InterruptedException {

		PageFactory.initElements(driver, EventsRepo.class);
		Thread.sleep(2000);
		EventsRepo.reset_eventcreation.click();

	}

	public void choseevent_forbannerchange() throws InterruptedException {

		PageFactory.initElements(driver, EventsRepo.class);
		Thread.sleep(2000);
		List<WebElement> actionsicon = driver.findElements(By.xpath("//button[@id='viewEvents_grid_moreActions']"));
		List<WebElement> editicon = driver.findElements(By.xpath(
				"//button[@id='viewEvents_grid_moreActions']//following-sibling::ul//a[contains(text(),'Edit')]"));
		int actionscount = actionsicon.size();
		// int editount = editicon.size();
		System.out.print("\n" + "Number of events :" + actionscount);
		List<WebElement> status = driver.findElements(By.xpath(
				"//button[contains(@id,'viewEvents_grid_moreActions')][i]//parent::div//preceding-sibling::div//span[2]"));
		for (int i = 0; i < actionscount; i++) {

			// for(int j=1;j<=editount;j++) {

			Thread.sleep(2000);
			// actionsicon.get(i).click();
			// editicon.get(i).click();

			String statustext = status.get(i).getText();
			System.out.print("\n" + "Event status:" + statustext);
			if (statustext.equals("Active")) {

				System.out.print("\n" + "Event is in active state so we cannot edit");

			} else {
				System.out.print("\n" + "Event can edit");

				JavascriptExecutor actionsiconexe = (JavascriptExecutor) driver;
				actionsiconexe.executeScript("arguments[0].click();", actionsicon.get(i));
				System.out.print("\n" + "action name:" + actionsicon.get(i).getText());
				JavascriptExecutor editiconexe = (JavascriptExecutor) driver;
				editiconexe.executeScript("arguments[0].click();", editicon.get(i));
				// required_details();

				break;
			}
		}

	}

	public void chose_event_edit() throws InterruptedException {
		PageFactory.initElements(driver, EventsRepo.class);
		Thread.sleep(2000);
		List<WebElement> actionsicon = driver.findElements(By.xpath("//button[@id='viewEvents_grid_moreActions']"));
		List<WebElement> editicon = driver.findElements(By.xpath(
				"//button[@id='viewEvents_grid_moreActions']//following-sibling::ul//a[contains(text(),'Edit')]"));
		int actionscount = actionsicon.size();
		// int editount = editicon.size();
		System.out.print("\n" + "Number of events :" + actionscount);
		List<WebElement> status = driver.findElements(By.xpath(
				"//button[contains(@id,'viewEvents_grid_moreActions')][i]//parent::div//preceding-sibling::div//span[2]"));
		for (int i = 0; i < actionscount; i++) {

			// for(int j=1;j<=editount;j++) {

			Thread.sleep(2000);
			// actionsicon.get(i).click();
			// editicon.get(i).click();

			String statustext = status.get(i).getText();
			System.out.print("\n" + "Event status:" + statustext);
			if (statustext.equals("Active")) {

				System.out.print("\n" + "Event is in active state so we cannot edit");

			} else {
				System.out.print("\n" + "Event can edit");

				JavascriptExecutor actionsiconexe = (JavascriptExecutor) driver;
				actionsiconexe.executeScript("arguments[0].click();", actionsicon.get(i));
				System.out.print("\n" + "action name:" + actionsicon.get(i).getText());
				JavascriptExecutor editiconexe = (JavascriptExecutor) driver;
				editiconexe.executeScript("arguments[0].click();", editicon.get(i));
				required_details();

				break;
			}
		}
	}

	public void stop_activeaccount() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		PageFactory.initElements(driver, EventsRepo.class);
		Thread.sleep(2000);
		List<WebElement> actionsicon = driver.findElements(By.xpath("//button[@id='viewEvents_grid_moreActions']"));
		List<WebElement> stopicon = driver.findElements(By.xpath(
				"//button[@id='viewEvents_grid_moreActions']//following-sibling::ul//a[contains(text(),'Stop')]"));
		int actionscount = actionsicon.size();
		// int editount = editicon.size();
		System.out.print("\n" + "Number of events :" + actionscount);
		List<WebElement> status = driver.findElements(By.xpath(
				"//button[contains(@id,'viewEvents_grid_moreActions')][i]//parent::div//preceding-sibling::div//span[2]"));
		for (int i = 0; i < actionscount; i++) {
			List<WebElement> selectevent = driver.findElements(By.xpath(
					"//button[contains(@id,'viewEvents_grid_moreActions')]//ancestor::div[contains(@class,'bottom')]//preceding-sibling::div[contains(@class,'top')]"));
			// for(int j=1;j<=editount;j++) {

			Thread.sleep(2000);
			// actionsicon.get(i).click();
			// editicon.get(i).click();

			String statustext = status.get(i).getText();
			System.out.print("\n" + "Event status:" + statustext);
			if (statustext.equals("Active")) {

				System.out.print("\n" + "Event is in active state so we can stop");

				JavascriptExecutor actionsiconexe = (JavascriptExecutor) driver;
				actionsiconexe.executeScript("arguments[0].click();", actionsicon.get(i));
				System.out.print("\n" + "action name:" + actionsicon.get(i).getText());
				JavascriptExecutor starticonexe = (JavascriptExecutor) driver;
				starticonexe.executeScript("arguments[0].click();", stopicon.get(i));
				WebElement stopmodal = driver.findElement(By.id("stop_event_confirm"));
				boolean stopvisible = stopmodal.isDisplayed();
				if (stopvisible == true) {
					WebElement stopbutton = driver.findElement(By.id("viewEvents_stopPopup_stop"));
					JavascriptExecutor stopbuttonexe = (JavascriptExecutor) driver;
					stopbuttonexe.executeScript("arguments[0].click();", stopbutton);
					System.out.print("\n" + "event stopped");

					if (stopvisible == true) {

						System.out.print("\n" + "all the participants should be checked out.");
						WebElement cancelstopevent = driver.findElement(By.id("viewEvents_deletePopup_cancel"));
						JavascriptExecutor cancelstopeventexe = (JavascriptExecutor) driver;
						cancelstopeventexe.executeScript("arguments[0].click();", cancelstopevent);
						System.out.print("\n" + "i number is :" + i);
						JavascriptExecutor selecteventexe = (JavascriptExecutor) driver;
						selecteventexe.executeScript("arguments[0].click();", selectevent.get(i));
						System.out.print("\n" + i + " th event clicked");
						WebElement checkinsmenu = driver.findElement(By.id("header_event_checkins"));
						JavascriptExecutor checkinsmenuexe = (JavascriptExecutor) driver;
						checkinsmenuexe.executeScript("arguments[0].click();", checkinsmenu);
						System.out.print("\n" + "checkins page opened.");
						Thread.sleep(3000);
						WebElement checkoutall = driver.findElement(By.id("viewCheckin_grid_checkoutAll"));
						JavascriptExecutor checkoutallexe = (JavascriptExecutor) driver;
						checkoutallexe.executeScript("arguments[0].click();", checkoutall);
						//checkoutall.click();
						Thread.sleep(2000);
						//JavascriptExecutor checkoutallexe = (JavascriptExecutor) driver;
						//checkoutallexe.executeScript("arguments[0].click();", checkoutall);
						WebElement checkoutallmodal = driver.findElement(By.id("checkout_event_confirm"));
						boolean checkoutallmodalvisible = checkoutallmodal.isDisplayed();

						if (checkoutallmodalvisible == true) {

							System.out.print("\n"+"checkout model displayed need to confirm for checkoutall.");
							Thread.sleep(2000);
							WebElement checkoutallbutton = driver
									.findElement(By.id("viewCheckin_checkoutAllPopup_checkout"));
							JavascriptExecutor checkoutallbuttonexe = (JavascriptExecutor) driver;
							checkoutallbuttonexe.executeScript("arguments[0].click();", checkoutallbutton);
							Thread.sleep(3000);
							System.out.print("\n" + "Checked out all the participants");
							
Thread.sleep(3000);

WebElement backtoevents=driver.findElement(By.id("header_backToEvents"));
JavascriptExecutor backtoeventsexe = (JavascriptExecutor) driver;
backtoeventsexe.executeScript("arguments[0].click();", backtoevents);


driver.navigate().refresh();


						//	JavascriptExecutor actionsiconexe1 = (JavascriptExecutor) driver;

				System.out.print("\n"+"i value is: "+i);
				Thread.sleep(3000);
				
				
			
			//	Actions action=new Actions(driver);
			//	action.moveToElement(actionsicon.get(i)).click();
				boolean actiondisplayed=actionsicon.get(i).isDisplayed();
				boolean result = false;
			    int attempts = 0;
			    while(actiondisplayed==true) {
			        try {
			        	JavascriptExecutor actionsiconexe1 = (JavascriptExecutor) driver;
						actionsiconexe1.executeScript("arguments[0].click();", actionsicon.get(i));
						System.out.print("\n" + "action name:" + actionsicon.get(i).getText());
			            result = true;
			            System.out.print("\n"+"Clicked on action.");
			            break;
			        } catch(StaleElementReferenceException e) {
			        }
			        attempts++;
			        System.out.print("\n"+"number of attempts:"+attempts);
			    }
				
			System.out.print("\n"+"result is:"+result);
				
			//	WebDriverWait wait=new WebDriverWait(driver,40);
				//WebElement checkoutelement=actionsicon.get(i);
			//	wait.until(ExpectedConditions.visibilityOf(actionsicon.get(i)));
				
			//	actionsiconexe.executeScript("arguments[0].click();", actionsicon.get(i));
							System.out.print("\n" + "action name:" + actionsicon.get(i).getText());
							JavascriptExecutor starticonexe1 = (JavascriptExecutor) driver;
							starticonexe1.executeScript("arguments[0].click();", stopicon.get(i));
							WebElement stopmodal1 = driver.findElement(By.id("stop_event_confirm"));
							boolean stopvisible1 = stopmodal1.isDisplayed();
							if (stopvisible1 == true) {
								WebElement stopbutton1 = driver.findElement(By.id("viewEvents_stopPopup_stop"));
								JavascriptExecutor stopbuttonexe1 = (JavascriptExecutor) driver;
								stopbuttonexe1.executeScript("arguments[0].click();", stopbutton1);
								System.out.print("\n" + "event stopped");
break;
							}
							
						}
					}
					// checkoutall();}
					else {
						System.out.print("\n" + "there are no checked in  participants");
					}

					break;

				}

			} else {
				System.out.print("\n" + "Event not started cannot stop");}

				/*
				 * JavascriptExecutor actionsiconexe=(JavascriptExecutor)driver;
				 * actionsiconexe.executeScript("arguments[0].click();",actionsicon.get(i));
				 * System.out.print("\n"+"action name:"+actionsicon.get(i).getText());
				 * JavascriptExecutor editiconexe=(JavascriptExecutor)driver;
				 * editiconexe.executeScript("arguments[0].click();",editicon.get(i));
				 * required_details();
				 * 
				 * 
				 * 
				 * break;
				 */
			

		}
	}

	public void checkoutall() {
		WebElement checkinsmenu = driver.findElement(By.id("header_event_checkins"));
		JavascriptExecutor checkinsmenuexe = (JavascriptExecutor) driver;
		checkinsmenuexe.executeScript("arguments[0].click();", checkinsmenu);
		System.out.print("\n" + "checkins page opened.");
		WebElement checkoutall = driver.findElement(By.id("viewCheckin_grid_checkoutAll"));
		JavascriptExecutor checkoutallexe = (JavascriptExecutor) driver;
		checkoutallexe.executeScript("arguments[0].click();", checkoutall);
		WebElement checkoutallmodal = driver.findElement(By.id("viewCcheckoutmodalheckin_checkoutAllPopup_checkout"));
		boolean checkoutallmodalvisible = checkoutallmodal.isDisplayed();
		if (checkoutallmodalvisible == true) {

			WebElement checkoutallbutton = driver.findElement(By.id("viewCheckin_checkoutAllPopup_checkout"));
			JavascriptExecutor checkoutallbuttonexe = (JavascriptExecutor) driver;
			checkoutallbuttonexe.executeScript("arguments[0].click();", checkoutallbutton);
			System.out.print("\n" + "Checked out all the participants");
		}

	}

	public void event_start() throws InterruptedException {

		PageFactory.initElements(driver, EventsRepo.class);
		Thread.sleep(2000);
		List<WebElement> actionsicon = driver.findElements(By.xpath("//button[@id='viewEvents_grid_moreActions']"));
		List<WebElement> editicon = driver.findElements(By.xpath(
				"//button[@id='viewEvents_grid_moreActions']//following-sibling::ul//a[contains(text(),'Edit')]"));
		List<WebElement> Starticon = driver.findElements(By.xpath(
				"//button[@id='viewEvents_grid_moreActions']//following-sibling::ul//a[contains(text(),'Start')]"));
		int actionscount = actionsicon.size();
		// int editount = editicon.size();
		System.out.print("\n" + "Number of events :" + actionscount);
		List<WebElement> status = driver.findElements(By.xpath(
				"//button[contains(@id,'viewEvents_grid_moreActions')][i]//parent::div//preceding-sibling::div//span[2]"));
		for (int i = 0; i < actionscount; i++) {

			// for(int j=1;j<=editount;j++) {

			Thread.sleep(2000);
			// actionsicon.get(i).click();
			// editicon.get(i).click();

			String statustext = status.get(i).getText();
			System.out.print("\n" + "Event status:" + statustext);
			if (statustext.equals("Active")) {

				System.out.print("\n" + "Event is already started so we cannot start");

			} else if (statustext.equals("Completed")) {

				System.out.print("\n" + "Event is already completed so we cannot start");

			} else {
				System.out.print("\n" + "Event can start");

				JavascriptExecutor actionsiconexe = (JavascriptExecutor) driver;
				actionsiconexe.executeScript("arguments[0].click();", actionsicon.get(i));
				System.out.print("\n" + "action name:" + actionsicon.get(i).getText());
				JavascriptExecutor starticonexe = (JavascriptExecutor) driver;
				starticonexe.executeScript("arguments[0].click();", Starticon.get(i));
				WebElement startmodal = driver.findElement(By.id("start_event_confirm"));
				boolean startmodalvisible = startmodal.isDisplayed();
				if (startmodalvisible == true) {
					System.out.print("\n" + "event start modaldisplayed");
					WebElement startbutton = driver.findElement(By.xpath("//a[@id='viewEvents_startPopup_start']"));

					startbutton.click();
					String sampletext = startbutton.getText();
					System.out.print("\n" + "start button text:" + sampletext);
					// Actions action=new Actions(driver);
					// action.moveToElement(startbutton).click();

					// JavascriptExecutor startbuttonexe1=(JavascriptExecutor)driver;
					// startbuttonexe1.executeScript("arguments[0].click();",startbutton);
					Thread.sleep(2000);
					System.out.print("\n" + "start button clicked");
					// viewEvents_startPopup_start
					System.out.print("\n" + "event started directly without changing any dates");

					break;
				} else {

					JavascriptExecutor actionsexe = (JavascriptExecutor) driver;
					actionsexe.executeScript("arguments[0].click();", actionsicon.get(i));
					System.out.print("\n" + "action name:" + actionsicon.get(i).getText());
					JavascriptExecutor editiconexe = (JavascriptExecutor) driver;
					editiconexe.executeScript("arguments[0].click();", editicon.get(i));
					Thread.sleep(2000);

					JavascriptExecutor editupdatexe = (JavascriptExecutor) driver;
					editupdatexe.executeScript("arguments[0].click();", EventsRepo.eventeditupdate);

					System.out.print("\n" + "event gotohome page after edited date");

					WebElement startbutton = driver.findElement(By.id("viewEvents_startPopup_start"));
					JavascriptExecutor startbuttonexe = (JavascriptExecutor) driver;
					startbuttonexe.executeScript("arguments[0].click();", startbutton);
					System.out.print("\n" + "event started after edited date");

					break;
				}

			}
		}

	}

	/*
	 * WebElement
	 * editform=driver.findElement(By.xpath("//form[@id='edit_event_form']"));
	 * boolean editvisible=editform.isDisplayed(); Thread.sleep(2000);
	 * if(editvisible==true) { System.out.print("\n"+"edit form displayed"); break;
	 * }else {
	 * 
	 * System.out.print("\n"+"Event form not displayed unable to edit "); }
	 */

	// }

	public void edit_save() {

		PageFactory.initElements(driver, EventsRepo.class);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		boolean updatevisible = EventsRepo.eventeditupdate.isDisplayed();
		if (updatevisible == true) {
			JavascriptExecutor updateexe = (JavascriptExecutor) driver;
			updateexe.executeScript("arguments[0].click();", EventsRepo.eventeditupdate);

		} else {
			System.out.print("\n" + "Edit event page not displayed");
		}
	}

	public void cancel_edit() {
		PageFactory.initElements(driver, EventsRepo.class);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		boolean updatevisible = EventsRepo.eventeditupdate.isDisplayed();
		if (updatevisible == true) {
			JavascriptExecutor editcanleexe = (JavascriptExecutor) driver;
			editcanleexe.executeScript("arguments[0].click();", EventsRepo.editeventcancel);
			System.out.print("\n" + "Event edit cancelled");
		} else {
			System.out.print("\n" + "Edit event page not displayed");
		}

	}

	public void reset_editevent() {

		PageFactory.initElements(driver, EventsRepo.class);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		boolean updatevisible = EventsRepo.eventeditupdate.isDisplayed();
		if (updatevisible == true) {
			JavascriptExecutor reseteditexe = (JavascriptExecutor) driver;
			reseteditexe.executeScript("arguments[0].click();", EventsRepo.editeventreset);
			System.out.print("\n" + "Event edit reset done successfully");
		} else {
			System.out.print("\n" + "Edit event page not displayed");
		}
	}

	public void change_banner() throws InterruptedException {

		PageFactory.initElements(driver, EventsRepo.class);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		JavascriptExecutor changebannerexe = (JavascriptExecutor) driver;
		changebannerexe.executeScript("arguments[0].click();", EventsRepo.banneractionsbutton);
		JavascriptExecutor changebannermenuexe = (JavascriptExecutor) driver;
		changebannermenuexe.executeScript("arguments[0].click();", EventsRepo.changebannermenu);
		Thread.sleep(2000);

	}

	public void custom_banner() throws InterruptedException, IOException {
		PageFactory.initElements(driver, EventsRepo.class);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Thread.sleep(2000);
		WebElement browsebanner = driver
				.findElement(By.xpath("//form[@id='banner_form']//input[@id='addEvents_custom_banner']"));
		// JavascriptExecutor browserexe=(JavascriptExecutor)driver;
		// browserexe.executeScript("arguments[0].click();", browsebanner);
		Actions actions = new Actions(driver);
		actions.moveToElement(browsebanner).click().perform();
		Thread.sleep(2000);
		Runtime.getRuntime().exec("C:\\Users\\Sridevi\\Desktop\\test.exe");
		Thread.sleep(2000);

		// EventsRepo.browsecustombanner.click();
		System.out.print("\n" + "Browse custom banner clicked");
		String sentence = "this is event program";
		StringTokenizer stringtext = new StringTokenizer(sentence);
		int countwords = stringtext.countTokens();
		System.out.print("\n" + "number of words:" + countwords);

	}

	public void customebanner_save() {
		PageFactory.initElements(driver, EventsRepo.class);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		JavascriptExecutor saveexe = (JavascriptExecutor) driver;
		saveexe.executeScript("arguments[0].click()", EventsRepo.savecustomebanner);

	}

	public void default_banner() throws InterruptedException {
		PageFactory.initElements(driver, EventsRepo.class);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		JavascriptExecutor defaultexe = (JavascriptExecutor) driver;
		defaultexe.executeScript("arguments[0].click()", EventsRepo.dafaultbannertab);
		Thread.sleep(2000);
		List<WebElement> defaultimages = driver
				.findElements(By.xpath("//div[@id='default_banner']//img//following-sibling::p"));
		int imagescount = defaultimages.size();
		System.out.print("\n" + "number ofimages:" + imagescount);
		JavascriptExecutor saveexe = (JavascriptExecutor) driver;
		saveexe.executeScript("arguments[0].click()", defaultimages.get(2));
		Thread.sleep(10000);
	}

	public void custombanner_reset() {

		PageFactory.initElements(driver, EventsRepo.class);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		JavascriptExecutor resetexe = (JavascriptExecutor) driver;
		resetexe.executeScript("arguments[0].click()", EventsRepo.resetcustombanner);

	}

	public void custombanner_cancel() {

		PageFactory.initElements(driver, EventsRepo.class);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		JavascriptExecutor cancelexe = (JavascriptExecutor) driver;
		cancelexe.executeScript("arguments[0].click()", EventsRepo.cancelcustombanner);

	}

	public void choseevent_analytics() throws InterruptedException {

		PageFactory.initElements(driver, EventsRepo.class);
		Thread.sleep(2000);
		List<WebElement> actionsicon = driver.findElements(By.xpath("//button[@id='viewEvents_grid_moreActions']"));
		List<WebElement> editicon = driver.findElements(By.xpath(
				"//button[@id='viewEvents_grid_moreActions']//following-sibling::ul//a[contains(text(),'Edit')]"));
		int actionscount = actionsicon.size();
		// int editount = editicon.size();
		System.out.print("\n" + "Number of events :" + actionscount);
		List<WebElement> status = driver.findElements(By.xpath(
				"//button[contains(@id,'viewEvents_grid_moreActions')][i]//parent::div//preceding-sibling::div//span[2]"));
		List<WebElement> toplist = driver.findElements(By.xpath(
				"//button[contains(@id,'viewEvents_grid_moreActions')]//ancestor::div[contains(@class,'bottom')]//preceding-sibling::div[contains(@class,'top')]"));

		for (int i = 0; i < actionscount; i++) {

			// for(int j=1;j<=editount;j++) {

			// actionsicon.get(i).click();
			// editicon.get(i).click();
			Thread.sleep(2000);
			// boolean result = false;
			/*
			 * int attempts = 0; while(attempts < 1) { try { boolean
			 * stringvisible=status.get(i).isDisplayed(); stringvisible = true; break; }
			 * catch(StaleElementReferenceException e) { driver.navigate().refresh(); }
			 * attempts++; }
			 */
			for (int j = 0; j <= 2; j++) {
				try {
					String statustext = status.get(i).getText();
					System.out.print("\n" + "Event status:" + statustext);

					// driver.navigate().refresh();
					// driver.navigate().refresh();

					if (statustext.equals("Active")) {

						System.out.print("\n" + "Event is in active state so we can view analytics");

						JavascriptExecutor cancelexe = (JavascriptExecutor) driver;
						cancelexe.executeScript("arguments[0].click()", toplist.get(i));

						System.out.print("\n" + "ACtive event image clicked");

					} else if (statustext.equals("Stopped")) {

						System.out.print("Event already stopped ");
					}

					else {
						System.out.print("\n" + "Event analytics will not be there for not started events");
					}
				} catch (Exception e) {
					System.out.print(e.getMessage());
				}
			}

		}
	}

	public void participants_menuitem() throws InterruptedException {
		PageFactory.initElements(driver, EventsRepo.class);
		Thread.sleep(2000);

		JavascriptExecutor participantsexe = (JavascriptExecutor) driver;
		participantsexe.executeScript("arguments[0].click()", EventsRepo.particpantsmenu);

	}

	public void participants_addbutton() throws InterruptedException {

		PageFactory.initElements(driver, EventsRepo.class);
		Thread.sleep(2000);

		JavascriptExecutor addparticipantsexe = (JavascriptExecutor) driver;
		addparticipantsexe.executeScript("arguments[0].click()", EventsRepo.addparticipantsbutton);

	}

	public void participants_details() throws InterruptedException {

		PageFactory.initElements(driver, EventsRepo.class);
		Thread.sleep(2000);
		Random random = new Random(10);
		EventsRepo.firstname_participant.sendKeys("Sridevi" + random.nextInt());
		// List<WebElement>
		// countrylist=driver.findElements(By.id("invite_country_code"));
		Select selectcountry = new Select(driver.findElement(By.id("invite_country_code")));

		selectcountry.selectByIndex(2);
		EventsRepo.phonenumber_participant.sendKeys("55555");
		EventsRepo.email_participant.sendKeys("Sree" + random.nextInt() + "@stest.com");

	}

	public void add_participant() throws InterruptedException {
		PageFactory.initElements(driver, EventsRepo.class);
		Thread.sleep(2000);
		JavascriptExecutor addparticipantsexe = (JavascriptExecutor) driver;
		addparticipantsexe.executeScript("arguments[0].click()", EventsRepo.add_participant);

	}

	public void add_participant_confirmation() throws InterruptedException {

		PageFactory.initElements(driver, EventsRepo.class);
		Thread.sleep(2000);
		JavascriptExecutor addpromptexe = (JavascriptExecutor) driver;
		addpromptexe.executeScript("arguments[0].click()", EventsRepo.addparticipantprompt);
	}

	/*
	 * get customer id by using that get event ids based on event id get status
	 */
	public void sampleexcel() throws IOException {
		XSSFWorkbook workbook = new XSSFWorkbook();

		// Create a blank sheet
		XSSFSheet sheet = workbook.createSheet("student Details");

		// This data needs to be written (Object[])
		Map<String, Object[]> data = new TreeMap<String, Object[]>();
		data.put("1", new Object[] { "ID", "NAME", "LASTNAME" });
		data.put("2", new Object[] { 1, "Pankaj", "Kumar" });
		data.put("3", new Object[] { 2, "Prakashni", "Yadav" });
		data.put("4", new Object[] { 3, "Ayan", "Mondal" });
		data.put("5", new Object[] { 4, "Virat", "kohli" });

		// Iterate over data and write to sheet
		Set<String> keyset = data.keySet();
		int rownum = 0;
		for (String key : keyset) {
			// this creates a new row in the sheet
			Row row = sheet.createRow(rownum++);
			Object[] objArr = data.get(key);
			int cellnum = 0;
			for (Object obj : objArr) {
				// this line creates a cell in the next column of that row
				Cell cell = row.createCell(cellnum++);
				if (obj instanceof String)
					cell.setCellValue((String) obj);
				else if (obj instanceof Integer)
					cell.setCellValue((Integer) obj);
			}
		}
		FileOutputStream out = new FileOutputStream(new File("E:\\gfgcontribute.xlsx"));
		workbook.write(out);
		out.close();
		System.out.println("gfgcontribute.xlsx written successfully on disk.");

		/*
		 * try { // this Writes the workbook gfgcontribute FileOutputStream out = new
		 * FileOutputStream(new File("E:\\gfgcontribute.xlsx")); workbook.write(out);
		 * out.close();
		 * System.out.println("gfgcontribute.xlsx written successfully on disk."); }
		 * catch (Exception e) { e.printStackTrace(); }
		 */
	}

}
