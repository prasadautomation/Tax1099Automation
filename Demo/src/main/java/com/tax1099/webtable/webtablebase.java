package com.tax1099.webtable;

	import java.util.List;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;

	public class webtablebase {
	
	 WebDriver driver;
	 String xpathString="//*[@id='example']";
	 String xpathString2="//table";

	 // test case#2,8
	 List<WebElement> c;
	 List<WebElement> r;
	 
	 // test case#3
	 String empRole = "Software Engineer";
	 int empPosColumn = 2;
	 int empNameColumn = 1;

	 // test case#4
	 int empAge = 40;
	 int empAgeColumn = 4;

	 // test case#6
	 int rowN = 2;
	 int colN = 3;

	 // test case#7
	 public String getColValue(int row, int col) {
	  WebElement colValue = driver.findElement(By.xpath(""+xpathString+"/tbody/tr[" + row + "]/td[" + col + "]"));
	  return colValue.getText();
	 }
	 // test case#9
	 int getcolNo = 2;

	 // test case#10
	 int noOfColumns = 3;

	 // test case#11
	 int firstColumnNo = 2;
	 int secondColumnNo = 5;

	 public void setup() {
	  System.setProperty("webdriver.chrome.driver",
	    "C:\\Users\\Hitendra\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://www.seleniumeasy.com/test/table-sort-search-demo.html");
	  c = driver.findElements(By.xpath(""+xpathString+"/thead/tr/th"));
	  r = driver.findElements(By.xpath(""+xpathString+"/tbody/tr"));
	 }

}

