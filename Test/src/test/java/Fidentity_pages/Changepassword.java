package Fidentity_pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

import com.google.common.collect.Table.Cell;
import com.mysql.cj.result.Row;

import Common.Fid_base;

public class Changepassword extends Fid_base {
	
	public void Changepassword_nav() throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebElement profile= driver.findElement(By.xpath("//div[@id='menu']//ul[contains(@class,'w-menu-two')]//li[3]//a"));
		JavascriptExecutor profileicon = (JavascriptExecutor) driver;
		profileicon.executeScript("arguments[0].click();", profile);
		Thread.sleep(3000);
		WebElement changepassword= driver.findElement(By.xpath("//div[@id='show_account']//span//a[contains(text(),'Change Password')]"));
		JavascriptExecutor passwordexecutor = (JavascriptExecutor) driver;
		passwordexecutor.executeScript("arguments[0].click();", changepassword);
		
		//div[@id='show_account']//span[4]//a[contains(text(),'Change Password')]
			}
	public void details() {
		
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//form[@id='change_password_form']//input[@id='old_password']")).sendKeys("Sridevi@1234");
		driver.findElement(By.xpath("//form[@id='change_password_form']//input[@id='new_password']")).sendKeys("Sridevi@12345");
		driver.findElement(By.xpath("//form[@id='change_password_form']//input[@id='confirm_password']")).sendKeys("Sridevi@12345");
		
	}
	public void update() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebElement update= driver.findElement(By.xpath("//div[contains(@class,'card-action')]//b[@class='primary-button']"));
		JavascriptExecutor updatexecutor = (JavascriptExecutor) driver;
		updatexecutor.executeScript("arguments[0].click();", update);
		//div[contains(@class,'card-action')]//b[@class='primary-button']
		Thread.sleep(3000);
	}
	
public void successful() {
	
	String title=driver.getTitle();
	System.out.print("\n"+"Title of the page is : "+title);
	
	if(title.equals("Login")) {
		
		System.out.print("\n"+"Changed password successfully");
	}else {System.out.println("Please enter valid values");}
}
	public void validations() throws IOException, InterruptedException {
		FileInputStream fis = new FileInputStream("E:\\eclipse-workspace\\Fidentity\\src\\test\\java\\passwordvalidations.xlsx");
		 XSSFWorkbook workbook = new XSSFWorkbook(fis);
		 XSSFSheet sheet = workbook.getSheetAt(0);
		                        //I have added test data in the cell A1 as "SoftwareTestingMaterial.com"
		                        //Cell A1 = row 0 and column 0. It reads first row as 0 and Column A as 0.
		 
		 
		/* XSSFRow row = sheet.getRow(1);
		 XSSFCell cellone = row.getCell(0);
		  System.out.println("\n"+"OLd password:"+cellone);
	   XSSFCell cell2 = row.getCell(1);  
	   System.out.println("\n"+"New password:"+cell2);
		
	   driver.findElement(By.xpath("//form[@id='change_password_form']//input[@id='old_password']")).sendKeys(row.getCell(0).getStringCellValue());
		driver.findElement(By.xpath("//form[@id='change_password_form']//input[@id='new_password']")).sendKeys(row.getCell(1).getStringCellValue());
		driver.findElement(By.xpath("//form[@id='change_password_form']//input[@id='confirm_password']")).sendKeys(row.getCell(1).getStringCellValue());
		System.out.println("\n"+"tried new passowrd "+row.getCell(1).getStringCellValue());*/
		
		for (int i=1;i<=sheet.getLastRowNum();i++) {
			
			
				System.out.println("\n"+"Old password:"+sheet.getRow(i).getCell(0).getStringCellValue());
			 driver.findElement(By.xpath("//form[@id='change_password_form']//input[@id='old_password']")).sendKeys(sheet.getRow(i).getCell(0).getStringCellValue());
			 System.out.println("\n"+"New password:"+sheet.getRow(i).getCell(1).getStringCellValue());
			 driver.findElement(By.xpath("//form[@id='change_password_form']//input[@id='new_password']")).sendKeys(sheet.getRow(i).getCell(1).getStringCellValue());
			 System.out.println("\n"+"New password:"+sheet.getRow(i).getCell(2).getStringCellValue());
			 driver.findElement(By.xpath("//form[@id='change_password_form']//input[@id='confirm_password']")).sendKeys(sheet.getRow(i).getCell(2).getStringCellValue());
				//System.out.println("\n"+"Old password:"+sheet.getRow(i+1).getCell(j+1).getStringCellValue());
			 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				WebElement update= driver.findElement(By.xpath("//div[contains(@class,'card-action')]//b[@class='primary-button']"));
				JavascriptExecutor updatexecutor = (JavascriptExecutor) driver;
				updatexecutor.executeScript("arguments[0].click();", update);
				//div[contains(@class,'card-action')]//b[@class='primary-button']
				Thread.sleep(3000);	
			System.out.print("\n"+"Row number-"+i);
			 driver.findElement(By.xpath("//form[@id='change_password_form']//input[@id='old_password']")).clear();
				driver.findElement(By.xpath("//form[@id='change_password_form']//input[@id='new_password']")).clear();
				driver.findElement(By.xpath("//form[@id='change_password_form']//input[@id='confirm_password']")).clear();
				
		}
		
	}
	}

