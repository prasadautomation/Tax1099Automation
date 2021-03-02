package Fidentity_pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.google.common.collect.Table.Cell;
import com.mysql.cj.result.Row;

import Common.Fid_base;
import Object_repo.Changepasswordrepo;
import Object_repo.Signinrepo;

public class Changepassword extends Fid_base {

	public void Changepassword_nav() throws InterruptedException {

		PageFactory.initElements(driver, Changepasswordrepo.class);

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		JavascriptExecutor profileicon = (JavascriptExecutor) driver;
		profileicon.executeScript("arguments[0].click();", Changepasswordrepo.profileicon);
		JavascriptExecutor passwordexecutor = (JavascriptExecutor) driver;
		passwordexecutor.executeScript("arguments[0].click();", Changepasswordrepo.Changepasswordmenu);

	}

	public void details() throws IOException, InterruptedException {

		FileInputStream fis = new FileInputStream(

				"E:\\eclipse-workspace\\Fidentity\\src\\test\\java\\passwordvalidations.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(4);

		System.out.println("\n" + "Password:" + sheet.getRow(1).getCell(1).getStringCellValue());

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		String currentpassword = sheet.getRow(1).getCell(1).getStringCellValue();

		if (currentpassword.equalsIgnoreCase("Sridevi@12345")) {

			System.out.print("\n" + "Current pass word is: Sridevi@12345");
			Changepasswordrepo.Oldpassword.sendKeys("Sridevi@12345");
			Changepasswordrepo.Newpassword.sendKeys("Fidentity@123");
			Changepasswordrepo.Confirmpassword.sendKeys("Fidentity@123");

		}

		else if (currentpassword.equalsIgnoreCase("Fidentity@123")) {
			System.out.print("\n" + "Current pass word is: Fidentity@123");
			Changepasswordrepo.Oldpassword.sendKeys("Fidentity@123");
			Changepasswordrepo.Newpassword.sendKeys("Sridevi@12345");
			Changepasswordrepo.Confirmpassword.sendKeys("Sridevi@12345");
		}

	}

	/*
	 * FileInputStream fis = new FileInputStream(
	 * 
	 * "E:\\eclipse-workspace\\Fidentity\\src\\test\\java\\passwordvalidations.xlsx"
	 * ); XSSFWorkbook workbook = new XSSFWorkbook(fis);
	 * 
	 * XSSFSheet sheet5=workbook.getSheetAt(4);
	 * 
	 * 
	 * String password=sheet5.getRow(1).getCell(1).getStringCellValue();
	 * Changepasswordrepo.Oldpassword.sendKeys(password);
	 * System.out.print("\n"+"current password is:"+password); String
	 * newpswd="Sridevi@12345"; Changepasswordrepo.Newpassword.sendKeys(newpswd);
	 * 
	 * Changepasswordrepo.Confirmpassword.sendKeys("Sridevi@12345");
	 * 
	 * // XSSFRow row = sheet5.createRow(3); XSSFCell cell =
	 * sheet5.getRow(3).createCell(1);
	 * 
	 * //cell.setCellType(cell.CELL_TYPE_STRING); // cell.setCellType(0);
	 * cell.setCellValue(newpswd); System.out.print("\n"+"New password:"+newpswd);
	 * FileOutputStream fos = new FileOutputStream(
	 * "E:\\eclipse-workspace\\Fidentity\\src\\test\\java\\passwordvalidations.xlsx"
	 * ); workbook.write(fos); fos.close();
	 * 
	 * 
	 * 
	 * //XSSFSheet sheetwrite=workbookwrite.sets.getSheetAt(4);
	 * 
	 * 
	 * 
	 * 
	 * //driver.findElement(By.xpath(
	 * "//form[@id='change_password_form']//input[@id='old_password']")) //
	 * .sendKeys("Sridevi@1234"); //driver.findElement(By.xpath(
	 * "//form[@id='change_password_form']//input[@id='new_password']")) //
	 * .sendKeys("Sridevi@12345"); // driver.findElement(By.xpath(
	 * "//form[@id='change_password_form']//input[@id='confirm_password']")) //
	 * .sendKeys("Sridevi@12345");
	 * 
	 * }
	 */
	public void update() throws InterruptedException {
		
		Thread.sleep(4000);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		// WebElement update = driver
		// .findElement(By.xpath("//div[contains(@class,'card-action')]//b[@class='primary-button']"));

		JavascriptExecutor updatexecutor = (JavascriptExecutor) driver;
		updatexecutor.executeScript("arguments[0].click();", Changepasswordrepo.PasswordUpdateButton);
		// div[contains(@class,'card-action')]//b[@class='primary-button']
		Thread.sleep(3000);
	}

	public void successful() {

		String title = driver.getTitle();
		System.out.print("\n" + "Title of the page is : " + title);

		if (title.equals("Login")) {

			System.out.print("\n" + "Changed password successfully");
			
			
			
			
		} else {
			System.out.println("Please enter valid values");
		}
	}

	public void validations() throws IOException, InterruptedException {
		
		FileInputStream fis = new FileInputStream(

				"E:\\eclipse-workspace\\Fidentity\\src\\test\\java\\passwordvalidations.xlsx");
		
	 XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		System.out.print("\n"+"First row number:"+sheet.getFirstRowNum());
		System.out.print("\n"+"Last row number:"+sheet.getLastRowNum());
		int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();

		 System.out.print("\n"+"Number of rows:"+rowCount);
		 
		 for(int i=1;i<rowCount;i++) {
			
			 
			
			 XSSFRow row = sheet.getRow(i); 
			 XSSFCell cellone = row.getCell(0);
			 String oldpassword=cellone.getStringCellValue();
			 System.out.println("\n"+"Old password:"+oldpassword); 
			 XSSFCell cell2 = row.getCell(1); 
			 String newpassword=cell2.getStringCellValue();
			 System.out.println("\n"+"New password:"+newpassword);
			 
			 XSSFCell cell3 = row.getCell(2); 
			 String confirmpassword=cell3.getStringCellValue();
			 System.out.println("\n"+"Confirm password:"+confirmpassword);
			Changepasswordrepo.Oldpassword.sendKeys(oldpassword);
			Changepasswordrepo.Newpassword.sendKeys(newpassword);
			Changepasswordrepo.Confirmpassword.sendKeys(confirmpassword);
			System.out.print("\n"+"row number:"+i);
			update();  			 
			Thread.sleep(5000);
			boolean passwordscreen= Changepasswordrepo.Oldpassword.isDisplayed();
			  		if(passwordscreen==true)	{ 
			  			Changepasswordrepo.Oldpassword.clear();
						Changepasswordrepo.Newpassword.clear();
						Changepasswordrepo.Confirmpassword.clear();
						System.out.print("\n"+"----------------------------------------");}
			  		else {
			  			System.out.print("\n"+"Change password validations completed");
			  		}
						
			 
		 }
		 
		 
		 /*
		 
		 
		 
	
			//Changepasswordrepo.Newpassword.sendKeys("Fidentity@123");
			//Changepasswordrepo.Confirmpassword.sendKeys("Fidentity@123");
			//Changepasswordrepo.Oldpassword.sendKeys(
		  //row.getCell(0).getStringCellValue()); 
		  driver.findElement(By.xpath(
		  "//form[@id='change_password_form']//input[@id='new_password']")).sendKeys(
		 * row.getCell(1).getStringCellValue()); driver.findElement(By.xpath(
		 * "//form[@id='change_password_form']//input[@id='confirm_password']")).
		 * sendKeys(row.getCell(1).getStringCellValue());
		 * System.out.println("\n"+"tried new passowrd "+row.getCell(1).
		 * getStringCellValue());
		 * 
		 * // assert.assert for (int i = 1; i <= sheet.getLastRowNum(); i++) {
		 * 
		 * String password=sheet5.getRow(i).getCell(1).getStringCellValue();
		 * 
		 * Changepasswordrepo.Oldpassword.sendKeys(password); System.out.println("\n" +
		 * "Old password:" + password);
		 * 
		 * System.out.println("\n" + "New password:" +
		 * sheet.getRow(i).getCell(1).getStringCellValue());
		 * Changepasswordrepo.Newpassword.sendKeys(sheet.getRow(i).getCell(1).
		 * getStringCellValue()); System.out.println("\n" + "confirm password:" +
		 * sheet.getRow(i).getCell(2).getStringCellValue());
		 * Changepasswordrepo.Confirmpassword.sendKeys(sheet.getRow(i).getCell(2).
		 * getStringCellValue()); // System.out.println("\n"+"Old //
		 * password:"+sheet.getRow(i+1).getCell(j+1).getStringCellValue());
		 * driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		 * 
		 * JavascriptExecutor updatexecutor = (JavascriptExecutor) driver;
		 * updatexecutor.executeScript("arguments[0].click();",
		 * Changepasswordrepo.PasswordUpdateButton); //
		 * div[contains(@class,'card-action')]//b[@class='primary-button']
		 * Thread.sleep(3000); System.out.print("\n" + "Row number-" + i);
		 * 
		 * Changepasswordrepo.Oldpassword.clear();
		 * Changepasswordrepo.Newpassword.clear();
		 * Changepasswordrepo.Confirmpassword.clear();
		 */

	}

}
