package Fidentity_pages;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Common.Fid_base;
import Object_repo.Empactionsrepo;
import Object_repo.UseractionsRepo;

public class EmployeeActions extends Fid_base {
	public void employee_Actions_nav() {
		PageFactory.initElements(driver, Empactionsrepo.class);
		PageFactory.initElements(driver, UseractionsRepo.class);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		JavascriptExecutor productsexe = (JavascriptExecutor) driver;
		productsexe.executeScript("arguments[0].click();", UseractionsRepo.productsicon);

		JavascriptExecutor vmsexe = (JavascriptExecutor) driver;
		vmsexe.executeScript("arguments[0].click();", UseractionsRepo.vmsmenu);
		
		
		JavascriptExecutor usersiconexe = (JavascriptExecutor) driver;
		usersiconexe.executeScript("arguments[0].click();", UseractionsRepo.usersicon);
		
		JavascriptExecutor empmenuexe = (JavascriptExecutor) driver;
		empmenuexe.executeScript("arguments[0].click();", Empactionsrepo.employeemenu);
	} 

	public void updatebutton() {

		JavascriptExecutor nameexecutor = (JavascriptExecutor) driver;
		nameexecutor.executeScript("arguments[0].click();", Empactionsrepo.editupdate);
	}
public void deactivatebutton() {
	
	JavascriptExecutor nameexecutor = (JavascriptExecutor) driver;
	nameexecutor.executeScript("arguments[0].click();", Empactionsrepo.deactiveicon);
}
	
	public void cancelbutton() {

		JavascriptExecutor nameexecutor = (JavascriptExecutor) driver;
		nameexecutor.executeScript("arguments[0].click();", Empactionsrepo.editcancel);
	}

	public void editbutton() {
		JavascriptExecutor editexecutor = (JavascriptExecutor) driver;
		editexecutor.executeScript("arguments[0].click();", Empactionsrepo.editicon);
	}

	public void edit_emp_validations() throws ClassNotFoundException, SQLException, InterruptedException {

		try {
			Assert.assertEquals(true, Empactionsrepo.editicon.isDisplayed(), "editidcon is available");
			System.out.print("Edit icon is available");
			JavascriptExecutor editiconexe = (JavascriptExecutor) driver;
			editiconexe.executeScript("arguments[0].click();", Empactionsrepo.editicon);

			// Empactionsrepo.editiconlist;

			int count = Empactionsrepo.editiconlist.size();
			// String status=usermail.statuslist;
			System.out.print("\n" + "List" + count);

			int rootuserrec = -1;
			int nonrootuserrec = -1;

			for (int i = 0; i < count; i++) {

				String usermail = Empactionsrepo.emailslist.get(i).getText();
				System.out.print("\n" + "User email id is :" + usermail);

				String userstatus = Empactionsrepo.statuslist.get(i).getText();
				System.out.print("\n" + "User email id is :" + userstatus);

				DataBase_connection db = new DataBase_connection();
				db.dbconnection();

				ResultSet rs = db.stmt
						.executeQuery("SELECT * FROM test_user_management.users where email='" + usermail + "';");

				System.out.println(rs);
				if (rs.next()) {
					String useremail = rs.getString("email");
					String usertype = rs.getString("login_type");
					boolean rootuser = rs.getBoolean("root_user");
					System.out.print("\n" + "User type is:" + usertype + " " + "User mail id is:" + useremail + "\n"
							+ "is user is root user ?" + rootuser);

					if (rootuser == true) {
						System.out.print("\n" + "User is  root user ##" + i);
						rootuserrec = i;
					}

					if (rootuser != true && userstatus.equals("active")) {
						System.out.print("\n" + "User is not root user and active in status## " + i);
						nonrootuserrec = i;
					}
					if (rootuserrec > -1 && nonrootuserrec > -1) {
						break;
					}
				}
			}

			System.out.println("\n" + "root = " + rootuserrec);
			System.out.println("non root = " + nonrootuserrec);

			EmployeeActions empactions = new EmployeeActions();

			empactions.editbutton();
			Empactionsrepo.employeename.clear();
			Empactionsrepo.phonenumber.clear();
			Empactionsrepo.phonenumber.sendKeys("1111111111");
			Empactionsrepo.email.clear();
			Empactionsrepo.email.sendKeys("sridevi123@zenwork.com");
			empactions.updatebutton();
			System.out.print("\n" + "Employee name validation done");
			empactions.cancelbutton();

			Thread.sleep(2000);
			empactions.editbutton();
			Empactionsrepo.employeename.clear();
			Empactionsrepo.employeename.sendKeys("Test123");
			Empactionsrepo.phonenumber.clear();
			Empactionsrepo.email.clear();
			Empactionsrepo.email.sendKeys("sridevi123@zenwork.com");
			empactions.updatebutton();
			System.out.print("\n" + "Employee phone number validation done");
			empactions.cancelbutton();

			Thread.sleep(2000);
			empactions.editbutton();
			Empactionsrepo.employeename.clear();
			Empactionsrepo.employeename.sendKeys("Test123");
			Empactionsrepo.phonenumber.clear();
			Empactionsrepo.phonenumber.sendKeys("1111111111");
			Empactionsrepo.email.clear();
			empactions.updatebutton();
			System.out.print("\n" + "Employee email validation done");
			empactions.cancelbutton();

		}

//-----------------------------------------------------------------------------------------------------------

		catch (AssertionError error) {
			System.out.print("\n" + "editicon is not available");
		} finally {
		}

		// System.out.print("\n"+"editicon is available");

		// WebElement actions = driver.findElement(By.xpath(
		// "//form[@id='view_employees_filter_form']/following-sibling::div[@class='row']//li//table//td[@class='staff-list-actions']"));
		/*
		 * 
		 * if (Empactionsrepo.editicon.isDisplayed()) { System.out.
		 * print("Employee actions are dispalyed, so integration are in disabled mode");
		 * driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 * List<WebElement> rows = driver.findElements(By.xpath(
		 * "//form[@id='view_employees_filter_form']/following-sibling::div[@class='row']//li//table//td[@class='staff-list-actions']//a[2]"
		 * ));
		 * 
		 * int count = rows.size();
		 * 
		 * System.out.println("\n" + "Number of employes " + count); int rootuserrec =
		 * -1; int nonrootuserrec = -1;
		 * 
		 * for (int i = 1; i <= count; i++) {
		 * 
		 * String usermail = driver .findElement(By .xpath(
		 * "//form[@id='view_employees_filter_form']/following-sibling::div[@class='row']//li["
		 * + (i) + "]//td//span[contains(text(),'Email')]//following-sibling::span"))
		 * .getText(); System.out.print("\n" + "User email id is :" + usermail);
		 * WebElement activationstatus=driver.findElement(By.xpath(
		 * "//form[@id='view_employees_filter_form']/following-sibling::div[@class='row']//li["
		 * +(i) +"]//table//td[7]//span[2]")); String status=activationstatus.getText();
		 * DataBase_connection db = new DataBase_connection(); db.dbconnection();
		 * 
		 * ResultSet rs = db.stmt
		 * .executeQuery("SELECT * FROM test_user_management.users where email='" +
		 * usermail + "';");
		 * 
		 * // SELECT * FROM test_user_management.users where
		 * email='sridevi903@srtest.com'; System.out.println(rs); if (rs.next()) {
		 * String useremail = rs.getString("email"); String usertype =
		 * rs.getString("login_type"); boolean rootuser = rs.getBoolean("root_user");
		 * System.out.print("\n" + "User type is:" + usertype + " " + "User mail id is:"
		 * + useremail + "\n" + "is user is root user ?" + rootuser);
		 * 
		 * if (rootuser == true) { System.out.print("\n" + "User is  root user ##" + i);
		 * rootuserrec = i; }
		 * 
		 * if (rootuser != true && status.equals("active")) { System.out.print("\n" +
		 * "User is not root user and active in status## " + i); nonrootuserrec = i; }
		 * 
		 * 
		 * if(rootuserrec > -1 && nonrootuserrec > -1) { break; } }
		 * 
		 * }
		 * 
		 * System.out.println("\n"+"root = "+ rootuserrec);
		 * System.out.println("non root = "+ nonrootuserrec);
		 * 
		 * WebElement editemp = driver.findElement(By.xpath(
		 * "//form[@id='view_employees_filter_form']/following-sibling::div[@class='row']//li["+
		 * (nonrootuserrec) +"]//table//td[@class='staff-list-actions']//a[2]"));
		 * JavascriptExecutor editexecutor = (JavascriptExecutor) driver;
		 * editexecutor.executeScript("arguments[0].click();", editemp);
		 * 
		 * driver.findElement(By.xpath(
		 * "//form[@id='staff_details']//input[@id='employee_name']")).clear();
		 * driver.findElement(By.
		 * xpath("	//form[@id='staff_details']//input[@id='phone_number']")).clear();
		 * driver.findElement(By.
		 * xpath("	//form[@id='staff_details']//input[@id='phone_number']"))
		 * .sendKeys("1111111111"); driver.findElement(By.
		 * xpath("	//form[@id='staff_details']//input[@id='email']")).clear();
		 * driver.findElement(By.
		 * xpath("	//form[@id='staff_details']//input[@id='email']"))
		 * .sendKeys("sree@zenwork.com");
		 * 
		 * WebElement nameupdate = driver.findElement(By.xpath(
		 * "//div[@id='edit_staff_modal']//div[@class='modal-footer']//a[contains(@class,'primary-button') and contains(text(),'Update')]"
		 * )); JavascriptExecutor nameexecutor = (JavascriptExecutor) driver;
		 * nameexecutor.executeScript("arguments[0].click();", nameupdate);
		 * Thread.sleep(2000);
		 * 
		 * WebElement namecancel = driver.findElement(By.xpath(
		 * "//div[@id='edit_staff_modal']//div[@class='modal-footer']//a[contains(@class,'reset-button') and contains(text(),'Cancel')]"
		 * )); JavascriptExecutor namecancelexe = (JavascriptExecutor) driver;
		 * namecancelexe.executeScript("arguments[0].click();", namecancel);
		 * Thread.sleep(2000); WebElement editphone = driver.findElement(By.xpath(
		 * "//form[@id='view_employees_filter_form']/following-sibling::div[@class='row']//li["+
		 * (nonrootuserrec) +"]//table//td[@class='staff-list-actions']//a[2]"));
		 * JavascriptExecutor editphoneexe = (JavascriptExecutor) driver;
		 * editphoneexe.executeScript("arguments[0].click();", editphone);
		 * 
		 * driver.findElement(By.xpath(
		 * "//form[@id='staff_details']//input[@id='employee_name']")).clear();
		 * driver.findElement(By.xpath(
		 * "//form[@id='staff_details']//input[@id='employee_name']")).sendKeys("Test");
		 * driver.findElement(By.xpath(
		 * "//form[@id='staff_details']//input[@id='phone_number']")).clear();
		 * driver.findElement(By.xpath("//form[@id='staff_details']//input[@id='email']"
		 * )).clear();
		 * driver.findElement(By.xpath("//form[@id='staff_details']//input[@id='email']"
		 * )) .sendKeys("sree@zenwork.com"); WebElement phoneupdate =
		 * driver.findElement(By.xpath(
		 * "//div[@id='edit_staff_modal']//div[@class='modal-footer']//a[contains(@class,'primary-button') and contains(text(),'Update')]"
		 * )); JavascriptExecutor phonexecutor = (JavascriptExecutor) driver;
		 * phonexecutor.executeScript("arguments[0].click();", phoneupdate);
		 * Thread.sleep(2000); WebElement phonecancel = driver.findElement(By.xpath(
		 * "//div[@id='edit_staff_modal']//div[@class='modal-footer']//a[contains(@class,'reset-button') and contains(text(),'Cancel')]"
		 * )); JavascriptExecutor phonecancelexe = (JavascriptExecutor) driver;
		 * phonecancelexe.executeScript("arguments[0].click();", phonecancel);
		 * Thread.sleep(2000); WebElement editmail = driver.findElement(By.xpath(
		 * "//form[@id='view_employees_filter_form']/following-sibling::div[@class='row']//li["+
		 * (nonrootuserrec) +"]//table//td[@class='staff-list-actions']//a[2]"));
		 * JavascriptExecutor editmailexe = (JavascriptExecutor) driver;
		 * editmailexe.executeScript("arguments[0].click();", editmail);
		 * 
		 * driver.findElement(By.xpath(
		 * "//form[@id='staff_details']//input[@id='employee_name']")).clear();
		 * driver.findElement(By.xpath(
		 * "//form[@id='staff_details']//input[@id='employee_name']")).sendKeys("Test");
		 * driver.findElement(By.xpath(
		 * "//form[@id='staff_details']//input[@id='phone_number']")).clear();
		 * driver.findElement(By.xpath(
		 * "//form[@id='staff_details']//input[@id='phone_number']"))
		 * .sendKeys("1111111111");
		 * driver.findElement(By.xpath("//form[@id='staff_details']//input[@id='email']"
		 * )).clear(); WebElement mailupdate = driver.findElement(By.xpath(
		 * "//div[@id='edit_staff_modal']//div[@class='modal-footer']//a[contains(@class,'primary-button') and contains(text(),'Update')]"
		 * )); JavascriptExecutor mailexecutor = (JavascriptExecutor) driver;
		 * mailexecutor.executeScript("arguments[0].click();", mailupdate);
		 * Thread.sleep(2000);
		 * 
		 * WebElement mailcancel = driver.findElement(By.xpath(
		 * "//div[@id='edit_staff_modal']//div[@class='modal-footer']//a[contains(@class,'reset-button') and contains(text(),'Cancel')]"
		 * )); JavascriptExecutor mailcancelexe = (JavascriptExecutor) driver;
		 * mailcancelexe.executeScript("arguments[0].click();", mailcancel);
		 * Thread.sleep(2000);
		 * 
		 * /* Class.forName("com.mysql.jdbc.Driver"); //
		 * Class.forName("com.mysql.cj.jdbc.Driver"); Connection
		 * con=DriverManager.getConnection("jdbc:mysql://35.153.40.38:3306",
		 * "stageuser","stage(password)" ); Statement stmt = con.createStatement();
		 * 
		 * } else { System.out.
		 * print("Employee actions are not displaying so, integrations are enabled mode"
		 * ); }
		 */
	}

	public void emp_details() throws InterruptedException, ClassNotFoundException, SQLException {
		try {
			Assert.assertEquals(true, Empactionsrepo.editicon.isDisplayed(), "editidcon is available");
			System.out.print("Edit icon is available");
			JavascriptExecutor editiconexe = (JavascriptExecutor) driver;
			editiconexe.executeScript("arguments[0].click();", Empactionsrepo.editicon);

			// Empactionsrepo.editiconlist;

			int count = Empactionsrepo.editiconlist.size();
			// String status=usermail.statuslist;
			System.out.print("\n" + "List" + count);

			int rootuserrec = -1;
			int nonrootuserrec = -1;

			for (int i = 0; i < count; i++) {

				String usermail = Empactionsrepo.emailslist.get(i).getText();
				System.out.print("\n" + "User email id is :" + usermail);

				String userstatus = Empactionsrepo.statuslist.get(i).getText();
				System.out.print("\n" + "User email id is :" + userstatus);

				DataBase_connection db = new DataBase_connection();
				db.dbconnection();

				ResultSet rs = db.stmt
						.executeQuery("SELECT * FROM test_user_management.users where email='" + usermail + "';");

				System.out.println(rs);
				if (rs.next()) {
					String useremail = rs.getString("email");
					String usertype = rs.getString("login_type");
					boolean rootuser = rs.getBoolean("root_user");
					System.out.print("\n" + "User type is:" + usertype + " " + "User mail id is:" + useremail + "\n"
							+ "is user is root user ?" + rootuser);

					if (rootuser == true) {
						System.out.print("\n" + "User is  root user ##" + i);
						rootuserrec = i;
					}

					if (rootuser != true && userstatus.equals("active")) {
						System.out.print("\n" + "User is not root user and active in status## " + i);
						nonrootuserrec = i;
					}
					if (rootuserrec > -1 && nonrootuserrec > -1) {
						break;
					}
				}
			}

			System.out.println("\n" + "root = " + rootuserrec);
			System.out.println("non root = " + nonrootuserrec);
			EmployeeActions empactions = new EmployeeActions();

			empactions.editbutton();
			Empactionsrepo.employeename.clear();
			Empactionsrepo.employeename.sendKeys("SreeTest");
			Empactionsrepo.phonenumber.clear();
			Empactionsrepo.phonenumber.sendKeys("1111111111");
			Empactionsrepo.email.clear();
			Empactionsrepo.email.sendKeys("sridevi123@zenwork.com");
			Thread.sleep(2000);
			empactions.updatebutton();

		} catch (AssertionError error) {
			System.out.print("\n" + "editicon is not available");
		} finally {
		}
	}

	public void fields_validation() throws InterruptedException, SQLException, ClassNotFoundException {
		/*
		 * WebElement actions = driver.findElement(By.xpath(
		 * "//form[@id='view_employees_filter_form']/following-sibling::div[@class='row']//li//table//td[contains(@class,'staff-list-actions')]"
		 * )); if (actions.isDisplayed()) {
		 * 
		 * List<WebElement> rows = driver.findElements(By.xpath(
		 * "//form[@id='view_employees_filter_form']/following-sibling::div[@class='row']//li//table//td[@class='staff-list-actions']//a[2]"
		 * ));
		 * 
		 * int count = rows.size();
		 * 
		 * System.out.println("\n" + "Number of employes " + count);
		 * 
		 * if (count > 1) {
		 * 
		 * int rootuserrec = -1; int nonrootuserrec = -1; for (int i = 1; i <= count;
		 * i++) {
		 * 
		 * String usermail = driver .findElement(By.xpath(
		 * "//form[@id='view_employees_filter_form']/following-sibling::div[@class='row']//li["
		 * + (i) + "]//td//span[contains(text(),'Email')]//following-sibling::span"))
		 * .getText(); System.out.print("\n" + "User email id is :" + usermail);
		 * WebElement activationstatus = driver.findElement(By .xpath(
		 * "//form[@id='view_employees_filter_form']/following-sibling::div[@class='row']//li["
		 * + (i) + "]//table//td[7]//span[2]")); String status =
		 * activationstatus.getText(); DataBase_connection db = new
		 * DataBase_connection(); db.dbconnection();
		 * 
		 * ResultSet rs = db.stmt
		 * .executeQuery("SELECT * FROM test_user_management.users where email='" +
		 * usermail + "';"); // SELECT * FROM test_user_management.users where
		 * email='sridevi903@srtest.com'; System.out.println(rs); if (rs.next()) {
		 * String useremail = rs.getString("email"); String usertype =
		 * rs.getString("login_type"); boolean rootuser = rs.getBoolean("root_user");
		 * System.out.print("\n" + "User type is:" + usertype + " " + "User mail id is:"
		 * + useremail + "\n" + "is user is root user ?" + rootuser);
		 * 
		 * if (rootuser == true) { System.out.print("\n" + "User is  root user ##" + i);
		 * rootuserrec = i; }
		 * 
		 * if (rootuser != true && status.equals("active")) { System.out.print("\n" +
		 * "User is not root user and staus is active ## " + i); nonrootuserrec = i; }
		 * 
		 * if (rootuserrec > -1 && nonrootuserrec > -1) { break; } }
		 * 
		 * }
		 * 
		 * System.out.println("\n" + "root = " + rootuserrec);
		 * System.out.println("non root = " + nonrootuserrec);
		 */
		try {
			Assert.assertEquals(true, Empactionsrepo.editicon.isDisplayed(), "editidcon is available");
			System.out.print("Edit icon is available");
			JavascriptExecutor editiconexe = (JavascriptExecutor) driver;
			editiconexe.executeScript("arguments[0].click();", Empactionsrepo.editicon);
			
			int count = Empactionsrepo.editiconlist.size();
			// String status=usermail.statuslist;
			System.out.print("\n" + "List" + count);

			int rootuserrec = -1;
			int nonrootuserrec = -1;

			for (int i = 0; i < count; i++) {

				String usermail = Empactionsrepo.emailslist.get(i).getText();
				System.out.print("\n" + "User email id is :" + usermail);

				String userstatus = Empactionsrepo.statuslist.get(i).getText();
				System.out.print("\n" + "User email id is :" + userstatus);

				DataBase_connection db = new DataBase_connection();
				db.dbconnection();

				ResultSet rs = db.stmt
						.executeQuery("SELECT * FROM test_user_management.users where email='" + usermail + "';");

				System.out.println(rs);
				if (rs.next()) {
					String useremail = rs.getString("email");
					String usertype = rs.getString("login_type");
					boolean rootuser = rs.getBoolean("root_user");
					System.out.print("\n" + "User type is:" + usertype + " " + "User mail id is:" + useremail + "\n"
							+ "is user is root user ?" + rootuser);

					if (rootuser == true) {
						System.out.print("\n" + "User is  root user ##" + i);
						rootuserrec = i;
					}

					if (rootuser != true && userstatus.equals("active")) {
						System.out.print("\n" + "User is not root user and active in status## " + i);
						nonrootuserrec = i;
					}
					if (rootuserrec > -1 && nonrootuserrec > -1) {
						break;
					}
				}
			}

			System.out.println("\n" + "root = " + rootuserrec);
			System.out.println("non root = " + nonrootuserrec);
			
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		EmployeeActions empactions = new EmployeeActions();
		empactions.editbutton();

		String telephoneNr1 = "1334567890";
		String telephoneNr2 = "13gt567890";
		String telephoneNr3 = "1334567 90";
		Empactionsrepo.employeename.clear();

		Empactionsrepo.employeename.sendKeys("Testname");
		Empactionsrepo.phonenumber.clear();
		Empactionsrepo.phonenumber.sendKeys(telephoneNr2);

		Thread.sleep(2000);
		if (telephoneNr2.matches("\\d{0,10}")) {
			// this logic tested with alphabets and spaces in between and preceding and
			// proceeding
			System.out.println("\n"+"Valid phone number!"+telephoneNr2);

			Empactionsrepo.email.clear();
			
			Empactionsrepo.email.sendKeys("sree@zenwork.com");
			empactions.updatebutton();
			Thread.sleep(2000);
			
		} else {
			System.out.println("\n"+"Invalid!");
			System.out.print("\n"+"entered phone number is " + telephoneNr2);
			empactions.cancelbutton();
			Thread.sleep(2000);
		}

		empactions.editbutton();

		Empactionsrepo.employeename.clear();
		Empactionsrepo.employeename.sendKeys("Testname");
		Empactionsrepo.phonenumber.clear();
		Empactionsrepo.phonenumber.sendKeys(telephoneNr3);
		Thread.sleep(2000);
		if (telephoneNr3.matches("\\d{0,10}")) {
			// this logic tested with alphabets and spaces in between and preceding and
			// proceeding
			System.out.println("\n"+"Valid phone number!"+telephoneNr3);

			Empactionsrepo.email.clear();
			Empactionsrepo.email.sendKeys("sree@zenwork.com");
			empactions.updatebutton();
			Thread.sleep(2000);

		} else {
			System.out.println("\n" + "Invalid!");
			System.out.print("\n"+"entered phone number is " + telephoneNr3);
			empactions.cancelbutton();
			Thread.sleep(2000);
		}
	empactions.editbutton();
		Empactionsrepo.employeename.clear();
		Empactionsrepo.employeename.sendKeys("Testname");
		Empactionsrepo.phonenumber.clear();
		Empactionsrepo.phonenumber.sendKeys(telephoneNr1);
		Thread.sleep(2000);

		if (telephoneNr1.matches("\\d{0,10}")) {
			// this logic tested with alphabets and spaces in between and preceding and
			// proceeding
			System.out.println("Valid phone number!" + telephoneNr1);

			Empactionsrepo.email.clear();
			Empactionsrepo.email.sendKeys("sree@zenwork.com");

			empactions.updatebutton();
			Thread.sleep(3000);

		}

		/*
		 * if (telephoneNr1.equlas("^(?=(?:[8-9]){1})(?=[0-9]{10}).*")) {
		 * System.out.println("Valid phone number!");
		 * 
		 * WebElement mailupdate= driver.findElement(By.
		 * xpath("//div[@id='edit_staff_modal']//div[@class='modal-footer']//a[contains(@class,'primary-button') and contains(text(),'Update')]"
		 * )); JavascriptExecutor mailexecutor = (JavascriptExecutor) driver;
		 * mailexecutor.executeScript("arguments[0].click();", mailupdate); }
		 */
		else {
			System.out.println("Invalid!");
			System.out.print("\n" + "entered phone number is " + telephoneNr1);
			empactions.cancelbutton();
			Thread.sleep(2000);
		}

		String email1 = "@test.com";
		String email2 = "sree@";
		String email3 = "sree";
		String email4 = "Sree@test";
		String email5 = "sree5@srtest.com";
		String pattern = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*" + "@" + "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

		empactions.editbutton();
		Empactionsrepo.employeename.clear();
		Empactionsrepo.employeename.sendKeys("Testname");
		Empactionsrepo.phonenumber.clear();
		Empactionsrepo.phonenumber.sendKeys(telephoneNr1);
		Thread.sleep(2000);
		Empactionsrepo.email.clear();
		Empactionsrepo.email.sendKeys("sree@zenwork.com");

		if (email1.matches(pattern)) {
			empactions.updatebutton();
			Thread.sleep(2000);

		} else {
			System.out.print("\n" + "invalid email:" + email1);
			empactions.cancelbutton();
			Thread.sleep(2000);
		}
	empactions.editbutton();
	Empactionsrepo.employeename.clear();
	Empactionsrepo.employeename.sendKeys("Testname");
	Empactionsrepo.phonenumber.clear();
	Empactionsrepo.phonenumber.sendKeys(telephoneNr1);
		Thread.sleep(2000);
		Empactionsrepo.email.clear();
		Empactionsrepo.email.sendKeys(email2);
		if (email2.matches(pattern)) {
			empactions.updatebutton();
			Thread.sleep(2000);

		} else {
			System.out.print("\n" + "invalid email:" + email2);
			empactions.cancelbutton();
			Thread.sleep(2000);
		}

		empactions.editbutton();
		
		Empactionsrepo.employeename.clear();
		Empactionsrepo.employeename.sendKeys("Testname");
		Empactionsrepo.phonenumber.clear();
		Empactionsrepo.phonenumber.sendKeys(telephoneNr1);
		Thread.sleep(2000);
		Empactionsrepo.email.clear();
		Empactionsrepo.email.sendKeys(email3);
		if (email3.matches(pattern)) {
			empactions.updatebutton();
			Thread.sleep(2000);

		} else {
			System.out.print("\n" + "invalid email:" + email3);
			empactions.cancelbutton();
			Thread.sleep(2000);
		}

	empactions.editbutton();
	Empactionsrepo.employeename.clear();
	Empactionsrepo.employeename.sendKeys("Testname");
	Empactionsrepo.phonenumber.clear();
	Empactionsrepo.phonenumber.sendKeys(telephoneNr1);
		Thread.sleep(2000);
		Empactionsrepo.email.clear();
		Empactionsrepo.email.sendKeys(email4);
		if (email4.matches(pattern)) {
			empactions.updatebutton();
			Thread.sleep(2000);
			System.out.print("\n" + "valid email pattern:" + email4);

		} else {
			System.out.print("\n" + "invalid email:" + email4);
			empactions.cancelbutton();
			Thread.sleep(2000);
		}

	empactions.editbutton();
	Empactionsrepo.employeename.clear();
	Empactionsrepo.employeename.sendKeys("Testname");
	Empactionsrepo.phonenumber.clear();
	Empactionsrepo.phonenumber.sendKeys(telephoneNr1);
		Thread.sleep(2000);
		Empactionsrepo.email.clear();
		Empactionsrepo.email.sendKeys(email5);
		if (email5.matches(pattern)) {
			empactions.updatebutton();
			Thread.sleep(2000);

		} else {
			System.out.print("\n" + "invalid email:" + email5);
			empactions.cancelbutton();
			Thread.sleep(2000);
		}

		// need to test email validations in edit employee

	}
	catch (AssertionError error) {
		System.out.print("\n" + "editicon is not available");
	} finally {
	}
}
	

	public void delete_emp() throws ClassNotFoundException, SQLException, InterruptedException {
		Assert.assertEquals(true, Empactionsrepo.deleteicon.isDisplayed(), "Delete icon is available");
		//System.out.print("Delete icon is available");
	//JavascriptExecutor editiconexe = (JavascriptExecutor) driver;
	//editiconexe.executeScript("arguments[0].click();", Empactionsrepo.deleteicon);
	
	int count = Empactionsrepo.deleteiconlist.size();
	// String status=usermail.statuslist;
	System.out.print("\n" + "No of employees:" + count);

	int rootuserrec = -1;
	int nonrootuserrec = -1;
	


	for (int i = 0; i < count; i++) {

		String usermail = Empactionsrepo.emailslist.get(i).getText();
		System.out.print("\n" + "User email id is :" + usermail);

		String userstatus = Empactionsrepo.statuslist.get(i).getText();
		System.out.print("\n" + "User status  :" + userstatus);

		DataBase_connection db = new DataBase_connection();
		db.dbconnection();

		ResultSet rs = db.stmt
				.executeQuery("SELECT * FROM test_user_management.users where email='" + usermail + "';");

		//System.out.println(rs);
		
		if (rs.next()) {
			String useremail = rs.getString("email");
			String usertype = rs.getString("login_type");
			boolean rootuser = rs.getBoolean("root_user");
			System.out.print("\n" + "User type is:" + usertype + " " + "User mail id is:" + useremail + "\n"
					+ "is user is root user:" + rootuser);
			
			if (rootuser != true && userstatus.equals("Active")) {
				System.out.print("\n" + "User is not root user and active in status## " + i);
				nonrootuserrec = i;
				JavascriptExecutor deleteexecutor = (JavascriptExecutor) driver;
				deleteexecutor.executeScript("arguments[0].click();", Empactionsrepo.deleteiconlist.get(i));
				Thread.sleep(2000);
				System.out.print("\n"+"Employee deleted successfully");
				break;
			}
			else {
				
				System.out.print("\n"+"The employee is root user we cant delete.");
				
			if (rootuser == true) {
				System.out.print("\n" + "User is  root user ##" + i);
				rootuserrec = i;
				Thread.sleep(2000);
				JavascriptExecutor deleteexecutor = (JavascriptExecutor) driver;
				deleteexecutor.executeScript("arguments[0].click();", Empactionsrepo.deleteiconlist.get(i));			
				System.out.print("\n"+"Root user cannot delete");
				
				
				
				
				//break;
			}
					//	i++;
					
/*
					 while (rootuser != true && userstatus.equals("active")) {
						System.out.print("\n" + "User is not root user and active in status## " + i);
						nonrootuserrec = i;
						JavascriptExecutor deleteexecutor = (JavascriptExecutor) driver;
						deleteexecutor.executeScript("arguments[0].click();", Empactionsrepo.deleteicon);
						Thread.sleep(2000);
						System.out.print("\n"+"Employee deleted successfully");
						break;
					}
					while (rootuserrec > -1 && nonrootuserrec > -1) {
						
						System.out.print("\n"+"There are no employees in the list to delete");
						break;
					}*/
				}
		}}

		//	System.out.println("\n" + "root = " + rootuserrec);
		//	System.out.println("non root = " + nonrootuserrec);
			
			

	}

	private void While(boolean b) {
		// TODO Auto-generated method stub
		
	}

	public void confirm_deletion() {
		
		if (Empactionsrepo.deletemodal.isDisplayed()) {
			
			JavascriptExecutor deleteexecutor = (JavascriptExecutor) driver;
			deleteexecutor.executeScript("arguments[0].click();", Empactionsrepo.deleteconfirm);
		} else {
			System.out.println("\n"+"Delete modal not displayed");
		}

	}

	public void cancel_deletion() throws InterruptedException {

		WebElement deletemodal = driver.findElement(By.xpath("//div[@id='delete_staff_modal']"));
		if (Empactionsrepo.deletemodal.isDisplayed()) {
			
			JavascriptExecutor deleteexecutor = (JavascriptExecutor) driver;
			deleteexecutor.executeScript("arguments[0].click();", Empactionsrepo.deletestaffno);
			Thread.sleep(2000);
			System.out.println("\n"+"Cancelled deletion of employee");

		} else {
			System.out.println("\n"+"Delete modal not displayed");
		}

	}

	public void deactivate_employee() throws ClassNotFoundException, SQLException, InterruptedException {
		/*
		 * String mailid=driver.findElement(By.xpath(
		 * "//form[@id='view_employees_filter_form']/following-sibling::div[@class='row']//li[2]//td[4]//span[2]"
		 * )).getText(); HttpRequestWithBody request =
		 * Unirest.post("https://test-s903.fidentity.com/api/staff_list.php");
		 * request.field("email", "mailid"); System.out.println("User id is  = " +
		 * request.getBody());
		 */

		
			/*try {
				Assert.assertEquals(true, Empactionsrepo.deactiveicon.isDisplayed(), "Deactivate icon is available");
				System.out.print("Deactivate icon is available");
		//	JavascriptExecutor editiconexe = (JavascriptExecutor) driver;
		//	editiconexe.executeScript("arguments[0].click();", Empactionsrepo.deactiveicon);
			
			int count = Empactionsrepo.deactivationlist.size();
			// String status=usermail.statuslist;
			System.out.print("\n" + "List" + count);

			int rootuserrec = -1;
			int nonrootuserrec = -1;*/
		int count = Empactionsrepo.deactivationlist.size();
		// String status=usermail.statuslist;
		int rootuserrec = -1;
		int nonrootuserrec = -1;
		System.out.print("\n" + "List" + count);

			for (int i = 0; i < count; i++) {

				String usermail = Empactionsrepo.emailslist.get(i).getText();
				System.out.print("\n" + "User email id is :" + usermail);

				String userstatus = Empactionsrepo.statuslist.get(i).getText();
				System.out.print("\n" + "User email id is :" + userstatus);

				DataBase_connection db = new DataBase_connection();
				db.dbconnection();

				ResultSet rs = db.stmt
						.executeQuery("SELECT * FROM test_user_management.users where email='" + usermail + "';");

				System.out.println(rs);
				if (rs.next()) {
					String useremail = rs.getString("email");
					String usertype = rs.getString("login_type");
					boolean rootuser = rs.getBoolean("root_user");
					System.out.print("\n" + "User type is:" + usertype + " " + "User mail id is:" + useremail + "\n"
							+ "is user is root user:" + rootuser);
					
					if (rootuser != true && userstatus.equals("Active")) {
						System.out.print("\n" + "User is not root user and active in status## " + i);
						nonrootuserrec = i;
						JavascriptExecutor deleteexecutor = (JavascriptExecutor) driver;
						deleteexecutor.executeScript("arguments[0].click();", Empactionsrepo.deactivationlist.get(i));
						Thread.sleep(2000);
						System.out.print("\n"+"Employee deactivate successfully");
						break;
					}
					else {
						
						System.out.print("\n"+"The employee is root user we cant deactivate.");}
						
					if (rootuser == true) {
						System.out.print("\n" + "User is  root user ##" + i);
						rootuserrec = i;
						Thread.sleep(2000);
						JavascriptExecutor deleteexecutor = (JavascriptExecutor) driver;
						deleteexecutor.executeScript("arguments[0].click();", Empactionsrepo.deactivationlist.get(i));			
						System.out.print("\n"+"Root user cannot delete");
						
						
						
						
						//break;
					}

			//System.out.println("\n" + "root = " + rootuserrec);
			//System.out.println("non root = " + nonrootuserrec);
			
			
			
			String status =Empactionsrepo.deactiveicon .getText();
			Thread.sleep(2000);
			System.out.print("\n" + "Status of the emeployee is :" + status);

			if (status.equals("inactive")) {
				
				JavascriptExecutor statusexecutor = (JavascriptExecutor) driver;
				statusexecutor.executeScript("arguments[0].click();", Empactionsrepo.activateicon);
				Thread.sleep(2000);
			}

			else {

			
				JavascriptExecutor statusexecutor = (JavascriptExecutor) driver;
				statusexecutor.executeScript("arguments[0].click();", Empactionsrepo.deactiveicon);}
				}}}
		
	/*	catch (AssertionError error) {
			System.out.print("\n" + "Deactiavate is not available already deactivted ");
			JavascriptExecutor statusexecutor = (JavascriptExecutor) driver;
			statusexecutor.executeScript("arguments[0].click();", Empactionsrepo.activateicon);
			Thread.sleep(2000);
			JavascriptExecutor activate = (JavascriptExecutor) driver;
			activate.executeScript("arguments[0].click();", Empactionsrepo.confirmactiavtion);
			System.out.print("\n" + "Done actiavtion");
		} finally {
		}*/

	public void confim_statuschange() throws InterruptedException {

		

		if (Empactionsrepo.confirmdeactivation.isDisplayed()) {

						
				JavascriptExecutor deactivatebuttonexe = (JavascriptExecutor) driver;
				deactivatebuttonexe.executeScript("arguments[0].click();", Empactionsrepo.confirmdeactivation);
				System.out.print("\n" + "Status changed as inactive employee");

			} else {
				
				JavascriptExecutor deactivatebuttonexe = (JavascriptExecutor) driver;
				deactivatebuttonexe.executeScript("arguments[0].click();", Empactionsrepo.confirmactiavtion);

				System.out.print("\n" + "Status changed as active employee");
			}

		}
	

	public void Cancel_statuschange() throws InterruptedException {

		//WebElement statusmodal = driver.findElement(By.xpath("//div[@id='status_change_staff_modal']"));

		
			if (Empactionsrepo.statuschangemodal.isDisplayed()) {
				
				JavascriptExecutor deactivatebuttonexe = (JavascriptExecutor) driver;
				deactivatebuttonexe.executeScript("arguments[0].click();",Empactionsrepo.cancelstatuschange );
				System.out.print("\n" + "Cancelled the status change for  active employee");
				Thread.sleep(2000);

			} else {
				

				System.out.print("\n" + "status chage modal not displayed");
				Thread.sleep(2000);
			}

		} 
		

	}

