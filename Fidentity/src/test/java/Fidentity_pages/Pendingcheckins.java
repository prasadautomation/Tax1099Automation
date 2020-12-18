package Fidentity_pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.google.common.collect.Table.Cell;

import Common.Fid_base;
import Object_repo.Changepasswordrepo;
import Object_repo.PendingcheckinsRepo;
import Object_repo.Signuprepo;
import Object_repo.WatchlistRepo;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;

public class Pendingcheckins extends Fid_base {
	
	public void navigate_pendingcheckins() throws InterruptedException {
		

		PageFactory.initElements(driver, PendingcheckinsRepo.class);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		//boolean assistedpage=PendingcheckinsRepo.assistedvisitoricon.isDisplayed();
	
		// System.out.print("\n"+"customer code in loginassisted method:"+customercode);
	//	boolean addonoption=PendingcheckinsRepo.addaonlocationmodal.isDisplayed();
	//if	(addonoption==true) {
	//System.out.print("\n"+"addon location modal available.");}
		
           String Actualtitle=	driver.getTitle();
System.out.println("\n"+"Assisetd actual title is:"+Actualtitle);

String Expectedtitle="Assisted Kiosk | Fidentity";

if(Actualtitle.equalsIgnoreCase(Expectedtitle)) {
//Assert.assertEquals(Expectedtitle, Actualtitle);
		JavascriptExecutor visitoriconexe = (JavascriptExecutor) driver;
		visitoriconexe.executeScript("arguments[0].click();", PendingcheckinsRepo.assistedvisitoricon);
		Thread.sleep(2000);
		JavascriptExecutor pendingcheckinmenu = (JavascriptExecutor) driver;
		pendingcheckinmenu.executeScript("arguments[0].click();", PendingcheckinsRepo.assistedpandingcheckinmenu);
	
		Assert.assertNotSame(Expectedtitle, Actualtitle,"Assisted kiosk not opened");}
else {
	System.out.print("\n"+"Assisted portal not opened");
	
}
	}
	

	public void select_pendingcheckin() throws InterruptedException {
		PageFactory.initElements(driver, PendingcheckinsRepo.class);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		// System.out.print("\n"+"customer code in loginassisted method:"+customercode);
		 String Actualtitle=	driver.getTitle();
		 System.out.println("\n"+"Assisetd actual title is:"+Actualtitle);

		 String Expectedtitle="Assisted Kiosk | Fidentity";

		 if(Actualtitle.equalsIgnoreCase(Expectedtitle)) {
	
		List<WebElement> pendingrecord=driver.findElements(By.xpath("//button[contains(text(),'Accept')]//ancestor::tbody//tr"));
	
		int pendingrecords=pendingrecord.size();
		System.out.print("\n"+"number of pending records:"+pendingrecords);
		if(pendingrecords>=1) {
			
			WebElement recordone=driver.findElement(By.xpath("//button[contains(text(),'Accept')]//ancestor::tbody//tr"));
			JavascriptExecutor pendingcheckinmenu = (JavascriptExecutor) driver;
			pendingcheckinmenu.executeScript("arguments[0].click();", recordone);	
			
		//	Actions actions=new Actions(driver);
		//	actions.moveToElement(recordone).click();
			//JavascriptExecutor pendingcheckinmenu = (JavascriptExecutor) driver;
			//pendingcheckinmenu.executeScript("arguments[0].click();", pendingrecord.get(1));
			Thread.sleep(2000);
			//pendingrecord.get(1).click();
			System.out.print("\n"+"Clicked on first record");
		}}else {
		
			System.out.print("\n"+"Assisted portal not opened");
	}}
	
	
	public void accept_button() {
		
		PageFactory.initElements(driver, PendingcheckinsRepo.class);

        String Actualtitle=	driver.getTitle();
System.out.println("\n"+"Assisetd actual title is:"+Actualtitle);

String Expectedtitle="Assisted Kiosk | Fidentity";

if(Actualtitle.equalsIgnoreCase(Expectedtitle)) {
		WebElement acceptbutton=driver.findElement(By.xpath("//button[contains(text(),'Accept')]"));
		boolean assistedpage=acceptbutton.isDisplayed();
		if(assistedpage==true) {	
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		JavascriptExecutor acceptbuttonexe = (JavascriptExecutor) driver;
		acceptbuttonexe.executeScript("arguments[0].click();", acceptbutton);
		}else {
			System.out.print("\n"+"this is not assisted page");
		}
	}}
	
public void reject_button() {
		
		PageFactory.initElements(driver, PendingcheckinsRepo.class);

        String Actualtitle=	driver.getTitle();
System.out.println("\n"+"Assisetd actual title is:"+Actualtitle);

String Expectedtitle="Assisted Kiosk | Fidentity";

if(Actualtitle.equalsIgnoreCase(Expectedtitle)) {
		WebElement rejectbutton=driver.findElement(By.xpath("//button[contains(text(),'Reject')]"));
		boolean assistedpage=rejectbutton.isDisplayed();
		if(assistedpage==true) {	
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		JavascriptExecutor acceptbuttonexe = (JavascriptExecutor) driver;
		acceptbuttonexe.executeScript("arguments[0].click();", rejectbutton);
		System.out.print("\n"+"Reject button has been clicked");
		}else {
			System.out.print("\n"+"this is not assisted page");
		}
	}}

public void reject_details() throws IOException, InterruptedException {
	 String Actualtitle=	driver.getTitle();
	 System.out.println("\n"+"Assisetd actual title is:"+Actualtitle);

	 String Expectedtitle="Assisted Kiosk | Fidentity";

	 if(Actualtitle.equalsIgnoreCase(Expectedtitle)) {
		 WebElement rejectemplsel=driver.findElement(By.id("employee_search_reject"));
		 JavascriptExecutor empselrejexe = (JavascriptExecutor) driver;
		 empselrejexe.executeScript("arguments[0].click();", rejectemplsel);
		 FileInputStream fis = new FileInputStream(
					"E:\\eclipse-workspace\\Fidentity\\src\\test\\java\\emplist.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(0);
			String name=sheet.getRow(1).getCell(3).getStringCellValue();
		 System.out.println("Whom to report when rejecting pending checkin:"+name);
		 rejectemplsel.sendKeys(name);
		 System.out.print("\n"+"Employee name:"+name);
		 Thread.sleep(2000);
		 System.out.println("need to select employee name from drop down");
		driver.findElement(By.id("reject_reason")).sendKeys("Test reject reason");
		 WebElement rejectsubmit=driver.findElement(By.id("pendingCheckins_rejectModal_submit"));
		 JavascriptExecutor rejectsubmitexe = (JavascriptExecutor) driver;
		 rejectsubmitexe.executeScript("arguments[0].click();", rejectsubmit);
		 System.out.println("Clicked on submit button to submit reject reason");
		 
		 
	 }else {System.out.print("\n"+"this is not assisted page");}
	
	
}
	public void selectOptionWithText(String textToSelect) {
	//	PageFactory.initElements(driver, Signuprepo.class);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		try {
			
			WebElement autoOptions = driver.findElement(By.xpath("//ul[@id='dynmicUserIds']"));
			WebDriverWait wait=new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(autoOptions));
			FileInputStream fis = new FileInputStream(
					"E:\\eclipse-workspace\\Fidentity\\src\\test\\java\\emplist.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(0);
			String name=sheet.getRow(1).getCell(3).getStringCellValue();
			
			WebElement empname=driver.findElement(By.xpath("//ul[@id='dynmicUserIds']//span[contains(@class,'emp-details')]//b[contains(text(),'"+name+"')]"));
			java.util.List<WebElement> optionsToSelect = autoOptions.findElements(By.xpath("//span[contains(text(),'"+empname+"')]"));
		
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

	
	public void accept_details() throws IOException, InterruptedException {
		
		PageFactory.initElements(driver, PendingcheckinsRepo.class);
		String Actualtitle=	driver.getTitle();
		System.out.println("\n"+"Assisetd actual title is:"+Actualtitle);

		String Expectedtitle="Assisted Kiosk | Fidentity";

		if(Actualtitle.equalsIgnoreCase(Expectedtitle)) {	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebElement searchemp=driver.findElement(By.id("employee_search_accept"));
		FileInputStream fis = new FileInputStream(
				"E:\\eclipse-workspace\\Fidentity\\src\\test\\java\\emplist.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		

			System.out.println("\n" + "Employee name:" + sheet.getRow(1).getCell(3).getStringCellValue());
			String name=sheet.getRow(1).getCell(3).getStringCellValue();
			searchemp.sendKeys(sheet.getRow(1).getCell(3).getStringCellValue());
			selectOptionWithText(name);
			
			System.out.print("\n"+"Selected name form dropdown list:"+name);
			
			// password:"+sheet.getRow(i+1).getCell(j+1).getStringCellValue());
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			
		//		Select  empname=new Select(driver.findElement(By.xpath("//ul[@id='dynmicUserIdsrej']")));
			//	empname.selectByIndex(1);
			
			String empname=driver.findElement(By.xpath("//ul[@id='dynmicUserIds']//span[contains(@class,'emp-details')]//b[contains(text(),'"+name+"')]")).getText();
			System.out.print("\n"+"employee name from dropdown"+empname);
			Thread.sleep(3000);
			
			
			PendingcheckinsRepo.acceptreason.sendKeys("Test accept reason");
			JavascriptExecutor acceptsumitexe = (JavascriptExecutor) driver;
			acceptsumitexe.executeScript("arguments[0].click();", PendingcheckinsRepo.acceptsubmit);
			
			
		}

		
		
		
		
	}
	public void employee_list() throws SQLException, ClassNotFoundException, IOException {
		
		Cookie cookie = driver.manage().getCookieNamed("accessauth");
	
		String cookiename = cookie.getValue();
		String cookiedomain = cookie.getDomain();
		System.out.print("\n" + "cookiename: " + cookiename);
		
		String url = "https://" + cookiedomain + "/api/get_session_data.php";
		HttpResponse<JsonNode> response = Unirest.post(url).header("Authorization", cookiename).asJson();
		System.out.print("\n" + "api response: " + response.getBody());
		String customerid = response.getBody().getObject().getJSONObject("data").getString("customer_id");
		String branchid = response.getBody().getObject().getJSONObject("data").getString("branch_id");
		
		
		// String account =
		// response.getBody(\n).getObject().getJSONObject("data").getString("customer_id");
		
		
		DataBase_connection db = new DataBase_connection();
		db.dbconnection();
		ResultSet rs = db.stmt.executeQuery(
				"SELECT customer_id,branch_id,employee_id,employee_name,status "
				+ "FROM test_user_management.employee_list where status='active' "
				+ "and customer_id='"+customerid+"' and branch_id='"+branchid+"';");
			//	+ //"where customer_id='CUST5e99465ac7a3b' and branch_id='BNCH5eface271ec1a';");//and status='active';");
			
		//branch_id='"+branchid+"' and is_picked=false;
		
		

		//	+ "where "
			//	+ "customer_id=\"customerid\" and "/
		//				+ "status='active'"
		//+"and branch_id=\"branch_id\"");
		System.out.print("\n" + "customer id  " + customerid);
		System.out.print("\n"+"branch id "+branchid);
		List<String> headerValues=new ArrayList<String>();

		File file= new File("E:\\eclipse-workspace\\Fidentity\\src\\test\\java\\emplist.xlsx");
		XSSFWorkbook wb= new XSSFWorkbook();
		XSSFSheet sh= wb.createSheet("employeelist");
	
		
		System.out.println("\n"+"resluset is:"+rs);
		//System.out.print("\n"+"number of records:"+recordscount);
		XSSFRow row = sh.createRow(0);
		
		XSSFCell cell;
		 int cc=rs.getMetaData().getColumnCount();
		 System.out.print("\n"+"number of coumns:"+cc);
		 
		 for(int i=1;i<=cc;i++)
	      {
	          String headerVal=rs.getMetaData().getColumnName(i);
	          headerValues.add(headerVal);
	          cell = row.createCell(i-1);
	          cell.setCellValue(rs.getMetaData().getColumnName(i));
	      }
		
		
		 System.out.println(headerValues);

	      int i = 1;
	      while (rs.next())
	      {  

	          XSSFRow row1 = sh.createRow((short) i);
	          for(int p=0;p<headerValues.size();p++)
	          {
	          row1.createCell((short) p).setCellValue(rs.getString(headerValues.get(p)));
	          }
	          i++;
	      } 

			try{
			FileOutputStream fos=new FileOutputStream(file);
			wb.write(fos);
			}catch(Exception e){
			e.printStackTrace();
			
			}
			}
			
		//	String fis = new FileInputStream("E:\\eclipse-workspace\\Fidentity\\src\\test\\java\\emplist.xlsx");
		/*	File file= new File("E:\\eclipse-workspace\\Fidentity\\src\\test\\java\\emplist.xlsx");
			FileOutputStream fos=new FileOutputStream(file);
		        //create the blank workbook
			Workbook wb= new XSSFWorkbook();
		        //create the blank excel sheet
			Sheet sh= wb.createSheet("Webkul");
			//define the position in the excel sheet where write operation needs to perform
		        Row rw= sh.createRow(4);
			Cell cl=(Cell) rw.createCell(1);
		        //define input type
		//	cl.setCellType(CellType.STRING);
		        //define the data value
			((org.apache.poi.ss.usermodel.Cell) cl).setCellValue(employeename);
		        //write the workbook
			wb.write(fos);
			
		*/
		
		
	
	
	public void get_employeelist() throws ClassNotFoundException, SQLException {
		Pendingcheckins pendingcheckins = new Pendingcheckins();
		String empid=null;
		String empname=null;
		//driver.switchTo().w);
	//	pendingcheckins.employee_list(empid,empname);
		
		System.out.print("\n"+"employee id :"+empid+";"+empname);
		
	}
	
}
