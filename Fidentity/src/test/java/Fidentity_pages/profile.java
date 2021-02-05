package Fidentity_pages;

import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Common.Fid_base;
import Object_repo.Changepasswordrepo;
import Object_repo.Profilerepo;

public class profile extends Fid_base {

	String editedname = "Sridevi test";
	String displayname;

	public void profileView() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		PageFactory.initElements(driver, Changepasswordrepo.class);
		PageFactory.initElements(driver, Profilerepo.class);
		/*
		 * WebElement element
		 * =driver.findElement(By.xpath("//li//a//i[contains(text(),'person_pin')]"));
		 * 
		 * 
		 * Actions actions = new Actions(driver);
		 * actions.moveToElement(element).click().build().perform();
		 * System.out.println("my profile image clicked");
		 */
		Thread.sleep(8000);

		// WebElement profile=
		// driver.findElement(By.xpath("//div[@id='menu']//ul[contains(@class,'w-menu-two')]//li[3]//a"));
		JavascriptExecutor profileicon = (JavascriptExecutor) driver;
		profileicon.executeScript("arguments[0].click();", Changepasswordrepo.profileicon);

//WebElement myprofile= driver.findElement(By.xpath("//span//a[contains(text(),'My Profile')]"));
		JavascriptExecutor myprofileexe = (JavascriptExecutor) driver;
		myprofileexe.executeScript("arguments[0].click();", Profilerepo.myprofilemenu);

	}

	public void profileEdit() {

		// WebElement editprofile=
		// driver.findElement(By.xpath("//div[@class='my_profile_details']//div[@class='card']//a[@title='Edit
		// Profile']"));
		JavascriptExecutor editprofileexe = (JavascriptExecutor) driver;
		editprofileexe.executeScript("arguments[0].click();", Profilerepo.editprofile);
	}

	public void requiredfileds() throws InterruptedException, IOException {

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		PageFactory.initElements(driver, Profilerepo.class);

		WebElement target = driver.findElement(By.id("myProfile_mouseOver_forEdit"));

		Actions action = new Actions(driver);
		action.moveToElement(target).perform();
		System.out.print("\n" + "Mouse over done on Image ");

		WebElement profileimg = driver.findElement(By.id("profileImageUpload"));
		action.moveToElement(profileimg).click().perform();

		System.out.print("\n" + "image upload clicked");
		Thread.sleep(5000);
		Runtime.getRuntime().exec("C:\\Users\\Sridevi\\Desktop\\testflower.exe");
		Thread.sleep(5000);


		//Thread.sleep(5000);

		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(10000);
		// driver.findElement(By.xpath("//input[@id='full_name']")).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END));
		// driver.findElement(By.xpath("//input[@id='full_name']")).clear();
		Profilerepo.fullname.clear();
		Profilerepo.fullname.sendKeys(editedname + randomInt);
		Profilerepo.designation.clear();
		// driver.findElement(By.xpath("//div[contains(@class,'row
		// my-profile-details')]//div[@class='input-field']//input[@id='designation']")).clear();
		Profilerepo.designation.sendKeys("Sqa");
		// driver.findElement(By.xpath("//div[contains(@class,'row
		// my-profile-details')]//div[@class='input-field']//input[@id='department']")).clear();
		Profilerepo.department.clear();
		Profilerepo.department.sendKeys("Quality Assurance");

		// Select gender=new
		// Select(driver.findElement(By.xpath("//div[contains(@class,'row
		// my-profile-details')]//select[@id='gender']")));
		
		Select genderdropdwnibj = new Select(Profilerepo.genderdropdwn);

		genderdropdwnibj.selectByIndex(3);
	}

	public void update() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		// WebElement editprofile=
		// driver.findElement(By.xpath("//div[@class='input-field']//a[contains(@class,'primary-button')
		// and contains(text(),'Update')]"));
		JavascriptExecutor editprofileexe = (JavascriptExecutor) driver;
		editprofileexe.executeScript("arguments[0].click();", Profilerepo.profileupdate);

	}

	public void compare() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		displayname = driver.findElement(By.xpath("//input[@id='full_name']")).getText();

		if (editedname.equals(displayname)) {

			System.out.println("Edited name and daisplayed name are same" + editedname);
		} else {

			System.out.println("\n"+" Given name " + editedname);
			System.out.println("\n"+"displayed name " + displayname);
		}
	}
}
