package com.tax1099.webtable;


	
	import java.util.List;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.Test;

	public class webtable  extends webtablebase {

	 @Test(priority = 1, description = "Get the Table Headers")
	 public void getTableHeaders() {
	  setup();
	  System.out.println("=========Get Table Headers======================");
	  List<WebElement> allHeadersOfTable = driver.findElements(By.xpath(""+xpathString+"/thead/tr/th"));
	  System.out.println("Headers in table are below:");
	  System.out.println("Total headers found: " + allHeadersOfTable.size());
	  for (WebElement header : allHeadersOfTable) {
	   System.out.println(header.getText());
	  }
	  System.out.println("================================================");
	 }

	 @Test(priority = 2, description = "Count total Rows And Coulmns")
	 public void countRowsAndCoulmns() {
	  setup();
	  System.out.println("=========countRowsAndCoulmns===================");
	  // Total Columns are
	  System.out.println("Total Columns: " + c.size());
	  // Total Rows are
	  System.out.println("Total Rows: " + r.size());
	  System.out.println("================================================");
	 }

	 @Test(priority = 3, description = "Get the Employee Position whose designation is SW Engg.")
	 public void getEmpPosition() {
	  setup();
	  System.out.println("=======Get All Emp Names of "+empRole+" position=======");
	  for (int i = 1; i <= r.size(); i++) {
	   WebElement posColumn = driver.findElement(By.xpath(""+xpathString+"/tbody/tr[" + i + "]/td["+empPosColumn+"]"));
	   if (posColumn.getText().toLowerCase().equalsIgnoreCase(empRole)) {
	    WebElement empNameColumn1 = driver
	      .findElement(By.xpath(""+xpathString+"/tbody/tr[" + i + "]/td["+empNameColumn+"]"));
	    System.out.println(empNameColumn1.getText());
	   }
	  }
	  System.out.println("===================================================");
	 }

	 @Test(priority = 4, description = "Get the name of the employees Age>40")
	 public void getAge() {
	  setup();
	  System.out.println("=======Get All Emp Names whose age>40===========");
	  for (int i = 1; i <= r.size(); i++) {
	   WebElement ageColumn = driver.findElement(By.xpath(""+xpathString+"/tbody/tr[" + i + "]/td["+empAgeColumn+"]"));
	   if (Integer.parseInt(ageColumn.getText()) >= empAge) {
	    WebElement empName = driver.findElement(By.xpath(""+xpathString+"/tbody/tr[" + i + "]/td["+empNameColumn+"]"));
	    System.out.println(empName.getText());
	   }
	  }
	  System.out.println("===================================================");
	 }

	 @Test(priority = 5, description = "Print the Last Row")
	 public void printLastRow() {
	  setup();
	  System.out.println("================Get Last Row of table================");
	  List<WebElement> columnOfLastRow = driver.findElements(By.xpath(""+xpathString+"/tbody/tr[last()]/td"));
	  for (WebElement e : columnOfLastRow) {
	   System.out.print(e.getText() + "   ");
	  }
	  System.out.println();
	  System.out.println("===================================================");
	 }

	 @Test(priority = 6, description = "Get particular Cell Value")
	 public void getCellValue() {
	  setup();
	  System.out.println("====Retrive cell value by providing row and column number========");
	  WebElement colValue = driver
	    .findElement(By.xpath(""+xpathString+"/tbody/tr[" + rowN + "]/td[" + colN + "]"));
	  System.out.println("Cell Value : " + colValue.getText());
	  System.out.println("===================================================");
	 }

	 @Test(priority = 7, description = "Get Cell Value By CustomMethod")
	 public void getCellValueByCustomMethod() {
	  setup();
	  System.out.println("====Retrive cell value by providing row and column number========");
	  System.out.println(getColValue(2, 3));
	  System.out.println("===================================================");
	 }

	 @Test(priority = 8, description = "Get All TableData")
	 public void getAllTableData() {
	  setup();
	  System.out.println("====================Retrive All table data============");
	  for (int i = 1; i <= r.size(); i++) {

	   for (int j = 1; j <= c.size(); j++) {

	    System.out.print(
	      driver.findElement(By.xpath(""+xpathString+"/tbody/tr[" + i + "]/td[" + j + "]")).getText()
	        + "   ");
	   }
	   System.out.println();
	   System.out.println();
	  }
	  System.out.println("===================================================");
	 }

	 @Test(priority = 9, description = "Get Particular Column")
	 public void getParticularColumn() {
	  setup();
	  System.out.println("===========================get particular Column========================");
	  for (int i = 1; i <= r.size(); i++) {
	   WebElement element = driver
	     .findElement(By.xpath(""+xpathString+"/tbody/tr[" + i + "]/td[" + getcolNo + "]"));
	   System.out.println(element.getText());
	  }
	  System.out.println("===================================================");
	 }

	 @Test(priority = 10, description = "Retrive More Than One Column")
	 public void retriveMoreThanOneColumn() {
	  setup();
	  System.out.println("===========retriveMoreThanOneColumns==========");
	  for (int i = 1; i <= r.size(); i++) {

	   for (int j = 1; j <= noOfColumns; j++) {

	    System.out.print(
	      driver.findElement(By.xpath(""+xpathString+"/tbody/tr[" + i + "]/td[" + j + "]")).getText()
	        + "   ");
	   }
	   System.out.println();
	  }
	  System.out.println("===================================================");
	 }
	 @AfterMethod
	 public void tearDown() {
	  driver.close();
	 }
}

