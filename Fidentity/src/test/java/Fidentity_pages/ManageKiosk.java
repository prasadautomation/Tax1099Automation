package Fidentity_pages;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import Common.Fid_base;

public class ManageKiosk extends Fid_base {

	public void nav_kiosk() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		WebElement usersicon = driver.findElement(By.xpath("//li[@id='service_users_parent']//a"));
		JavascriptExecutor usersiconexe = (JavascriptExecutor) driver;
		usersiconexe.executeScript("arguments[0].click();", usersicon);

		WebElement managekiosk = driver
				.findElement(By.xpath("//div[@id='service_user_features']//a[contains(text(),'Manage Kiosk')]"));
		JavascriptExecutor managekioskexe = (JavascriptExecutor) driver;
		managekioskexe.executeScript("arguments[0].click();", managekiosk);

	}

	public void add_kiosk() {

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement addkiosk = driver
				.findElement(By.xpath("//a[contains(@class,'primary-button') and contains(text(),'Add Kiosk')]"));
		JavascriptExecutor addkioskexe = (JavascriptExecutor) driver;
		addkioskexe.executeScript("arguments[0].click();", addkiosk);
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(10000);
		driver.findElement(By.xpath("//form[@id='add_device_form']//input[@id='alias_name']"))
				.sendKeys("Test" + randomInt);
		driver.findElement(By.xpath("//form[@id='add_device_form']//input[@id='manufacture_name']"))
				.sendKeys("Test manufacture");
		driver.findElement(By.xpath("//form[@id='add_device_form']//input[@id='model_name']")).sendKeys("Test modal");
		WebElement adddevice = driver
				.findElement(By.xpath("//div[contains(@class,'modal-footer')]//a[contains(text(),'Add Device')]"));
		JavascriptExecutor adddevicexe = (JavascriptExecutor) driver;
		adddevicexe.executeScript("arguments[0].click();", adddevice);

		WebElement confirmok = driver
				.findElement(By.xpath("//div[@id='add_device_confirm_modal']//a[contains(text(),'Yes, Proceed')]"));
		JavascriptExecutor confirmokexe = (JavascriptExecutor) driver;
		confirmokexe.executeScript("arguments[0].click();", confirmok);

	}

	public void delete_kiosk() {

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		List<WebElement> records = driver.findElements(By.xpath("//a[contains(text(),'Edit')]"));
		int count = records.size();
		System.out.print("\n" + "number of records are:" + count);

		if (count > 0) {

			WebElement Delete = driver.findElement(By.xpath("//a[contains(text(),'Delete')]"));
			JavascriptExecutor Deletexe = (JavascriptExecutor) driver;
			Deletexe.executeScript("arguments[0].click();", Delete);

			WebElement Deleteconfirm = driver.findElement(By.xpath("//a[contains(text(),'Yes, Delete')]"));
			JavascriptExecutor Deleteconfirmexe = (JavascriptExecutor) driver;
			Deleteconfirmexe.executeScript("arguments[0].click();", Deleteconfirm);

		} else {
			System.out.print("\n" + "Number of records are zero");
		}

	}

	public void editKiosk() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		List<WebElement> records = driver.findElements(By.xpath("//a[contains(text(),'Edit')]"));
		int count = records.size();
		System.out.print("\n" + "number of records are:" + count);

		if (count > 0) {
			WebElement editkiosk = driver.findElement(By.xpath("//a[contains(text(),'Edit')]"));
			JavascriptExecutor editkioskexe = (JavascriptExecutor) driver;
			editkioskexe.executeScript("arguments[0].click();", editkiosk);
			Thread.sleep(3000);

			driver.findElement(By.xpath("//form[@id='edit_device_form']//input[@id='alias_name']")).clear();
			driver.findElement(By.xpath("//form[@id='edit_device_form']//input[@id='alias_name']")).sendKeys("TestS");
			driver.findElement(By.xpath("//form[@id='edit_device_form']//input[@id='manufacture_name']")).clear();
			driver.findElement(By.xpath("//form[@id='edit_device_form']//input[@id='manufacture_name']"))
					.sendKeys("Test manufactureS");
			driver.findElement(By.xpath("//form[@id='edit_device_form']//input[@id='model_name']")).clear();
			driver.findElement(By.xpath("//form[@id='edit_device_form']//input[@id='model_name']"))
					.sendKeys("Test modalS");

			WebElement update = driver.findElement(
					By.xpath("//div[contains(@class,'modal-footer')]//a[contains(text(),'Update Device')]"));
			JavascriptExecutor updateexe = (JavascriptExecutor) driver;
			updateexe.executeScript("arguments[0].click();", update);

			WebElement confirmok = driver.findElement(
					By.xpath("//div[@id='edit_device_confirm_modal']//a[contains(text(),'Yes, Proceed')]"));
			JavascriptExecutor confirmokexe = (JavascriptExecutor) driver;
			confirmokexe.executeScript("arguments[0].click();", confirmok);

		} else {
			System.out.print("\n" + "There are no records to edit");
		}

	}

	public void dettachKiosk() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		List<WebElement> records = driver.findElements(By.xpath("//a[contains(text(),'Edit')]"));
		int count = records.size();
		System.out.print("\n" + "number of records are:" + count);

		if (count > 0) {
			for (int i = 1; i <= count; i++) {

				String status = driver
						.findElement(
								By.xpath("//li[" + i + "]//Span[contains(text(),'Status')]/following-sibling::span"))
						.getAttribute("innerHTML");
				if (status.equals("Device is attached")) {

					WebElement dettach = driver.findElement(By.xpath("//a[contains(text(),'Detach')]"));
					JavascriptExecutor dettachexe = (JavascriptExecutor) driver;
					dettachexe.executeScript("arguments[0].click();", dettach);

					WebElement dettachconfirm = driver.findElement(
							By.xpath("//div[@id='detach_device_confirm_modal']//a[contains(text(),'Yes, Proceed')]"));
					JavascriptExecutor dettachconfirmexe = (JavascriptExecutor) driver;
					dettachconfirmexe.executeScript("arguments[0].click();", dettachconfirm);
					System.out.print("\n" + "This synccode is not attached and status is :" + i + "\n" + status);

					break;

				} else {
					System.out.print("\n" + "This synccode is not attached and status is :" + i + "\n" + status);
				}

			}

		}

	}

	public void canceldettach() {
		
		

	}
}
