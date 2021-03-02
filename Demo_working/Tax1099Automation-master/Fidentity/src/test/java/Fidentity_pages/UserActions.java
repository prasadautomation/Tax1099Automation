package Fidentity_pages;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Common.Fid_base;
import Object_repo.UseractionsRepo;

public class UserActions extends Fid_base {

	public void userActions_nav() {
		PageFactory.initElements(driver, UseractionsRepo.class);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		JavascriptExecutor productsexe = (JavascriptExecutor) driver;
		productsexe.executeScript("arguments[0].click();", UseractionsRepo.productsicon);

		JavascriptExecutor vmsexe = (JavascriptExecutor) driver;
		vmsexe.executeScript("arguments[0].click();", UseractionsRepo.vmsmenu);

		JavascriptExecutor usersiconexe = (JavascriptExecutor) driver;
		usersiconexe.executeScript("arguments[0].click();", UseractionsRepo.usersicon);

		JavascriptExecutor usersmenuexe = (JavascriptExecutor) driver;
		usersmenuexe.executeScript("arguments[0].click();", UseractionsRepo.usersmenu);
		/*
		 * List <WebElement> allvalue = driver.findElements(By.
		 * xpath("//div[@class='card my-card']//li//table//tr/td[6]")); //int
		 * count=allvalue.size();
		 * System.out.print("Number of users:--"+allvalue.size()+" ");
		 * if(allvalue.size()>1) {
		 * 
		 * WebElement visibleactions=
		 * driver.findElement(By.xpath("//div[@class='card my-card']//li[2]//div"));
		 * JavascriptExecutor visibleexecutor = (JavascriptExecutor) driver;
		 * visibleexecutor.executeScript("arguments[0].click();", visibleactions);}
		 * 
		 * else {System.out.print("cannot perform user actions on root admin");}
		 */
	}

	public void deactiavte_emp() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		WebElement deactivateelement = driver.findElement(By.xpath("//a[contains(@id,'usersView_grid_deactivate')]"));
		boolean actinsvisible = deactivateelement.isDisplayed();
		if (actinsvisible == true) {

			JavascriptExecutor deactivateexe = (JavascriptExecutor) driver;
			deactivateexe.executeScript("arguments[0].click()", deactivateelement);
			WebElement deactivatebutton = driver.findElement(By.id("usersView_statusChange_yesDeactivate"));
			JavascriptExecutor deactivateyesexe = (JavascriptExecutor) driver;
			deactivateyesexe.executeScript("arguments[0].click()", deactivatebutton);
			System.out.print("\n" + "Deactivation done successfully");

		} else {

			System.out.print("\n" + "Deactivate icon not visible");

		}
		/*
		 * List <WebElement> allvalue = driver.findElements(By.
		 * xpath("//div[@class='card my-card']//li//table//tr/td[6]")); //int
		 * count=allvalue.size();
		 * System.out.print("Number of users:--"+allvalue.size()+" ");
		 * if(allvalue.size()>1) {
		 * 
		 * WebElement status=driver.findElement(By.
		 * xpath("//div[@class='card my-card']//li[2]//div//table//tr/td[6]//span[2]"));
		 * 
		 * if(status.getText().equals("active")) { WebElement deactiavte=
		 * driver.findElement(By.
		 * xpath("//div[@class='card my-card']//li[2]//div[contains(@class,'collapsible-body ')]//span//a[@title='Deactivate account']"
		 * )); JavascriptExecutor deactivatexecutor = (JavascriptExecutor) driver;
		 * deactivatexecutor.executeScript("arguments[0].click();", deactiavte);
		 * Thread.sleep(3000); System.out.print("Deactiavte clciked"); WebElement
		 * confirmdeactiavte= driver.findElement(By.
		 * xpath("//div[@id='status_change_user_modal']//a[contains(@class,'delete-button') and contains(text(),'Yes, Deactivate')]"
		 * )); JavascriptExecutor confirmexecutor = (JavascriptExecutor) driver;
		 * confirmexecutor.executeScript("arguments[0].click();", confirmdeactiavte);
		 * Thread.sleep(3000); System.out.print("Deactiavtion confirmed"); }else
		 * {System.out.print("Employee already deactivated");}} else{System.out.
		 * print("--Only one user available we cannot perform actions---");}
		 * driver.navigate().refresh();
		 */
	}

	public void activate_emp() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement status = driver.findElement(By.xpath("//a[contains(@id,'usersView_grid_activate')]"));
		boolean actiavteicon = status.isDisplayed();

		if (actiavteicon == true) {

			JavascriptExecutor activateexecutor = (JavascriptExecutor) driver;
			activateexecutor.executeScript("arguments[0].click();", status);
			Thread.sleep(3000);
			System.out.print("actiavte clicked");
			WebElement confirmdeactiavte = driver.findElement(By.id("usersView_statusChange_yesActivate"));
			JavascriptExecutor confirmexecutor = (JavascriptExecutor) driver;
			confirmexecutor.executeScript("arguments[0].click();", confirmdeactiavte);
			Thread.sleep(3000);
			System.out.print("Actiavtion confirmed");
		} else {
			System.out.print("there is no deativated employee");
		}
		driver.navigate().refresh();
	}

	public void status_change() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		WebElement status = driver 
				.findElement(By.xpath("//div[@class='card my-card']//li[2]//div//table//tr/td[6]//span[2]"));

		if (status.getText().equals("active")) {
			WebElement deactiavte = driver.findElement(By.xpath(
					"//div[@class='card my-card']//li[2]//div[contains(@class,'collapsible-body ')]//span//a[@title='Deactivate account']"));
			JavascriptExecutor deactivatexecutor = (JavascriptExecutor) driver;
			deactivatexecutor.executeScript("arguments[0].click();", deactiavte);
			Thread.sleep(3000);

			System.out.print("Actiave employee changed as deactive");

		}

		else {
			WebElement activate = driver.findElement(By.xpath(
					"//div[@class='card my-card']//li[2]//div[contains(@class,'collapsible-body ')]//span//a[@title='Activate account']"));
			JavascriptExecutor activateexecutor = (JavascriptExecutor) driver;
			activateexecutor.executeScript("arguments[0].click();", activate);
			Thread.sleep(3000);

			System.out.print("Deactive  employee changed as active");
		}

	}

	public void cancel_status_change() throws InterruptedException {

		WebElement cancelstatus = driver.findElement(By.xpath(
				"//div[@id='status_change_user_modal']//a[contains(@class,'reset-button') and contains(text(),'No, Cancel')]"));
		JavascriptExecutor cancelexecutor = (JavascriptExecutor) driver;
		cancelexecutor.executeScript("arguments[0].click();", cancelstatus);

	}

	public void click_change_password() {

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		WebElement status = driver
				.findElement(By.xpath("//div[@class='card my-card']//li[2]//div//table//tr/td[6]//span[2]"));

		if (status.getText().equals("active")) {

			WebElement resetpassword = driver.findElement(By.xpath(
					"//div[@class='card my-card']//li[2]//div[contains(@class,'collapsible-body')]//a[@title='Reset Password']"));
			JavascriptExecutor passwordexecutor = (JavascriptExecutor) driver;
			passwordexecutor.executeScript("arguments[0].click();", resetpassword);
			Random randomGenerator = new Random();
			int randomInt = randomGenerator.nextInt(1000);

			String random_password = "Sridevi@" + randomInt;

			System.out.print("New password is--" + random_password);
			String user = driver
					.findElement(By.xpath("//div[@class='card my-card']//li[2]//div//table//tr//td[4]//span[2]"))
					.getText();
			System.out.print("  User is--" + user);

			driver.findElement(By.xpath("//div[@id='reset_user_modal']//input[@id='new_password']"))
					.sendKeys(random_password);

			WebElement passwordconfirm = driver.findElement(By.xpath(
					"//div[@id='reset_user_modal']//a[@class='primary-button' and contains(text(),'Yes, Change')]"));
			JavascriptExecutor confirmexecutor = (JavascriptExecutor) driver;
			confirmexecutor.executeScript("arguments[0].click();", passwordconfirm);

		} else {

			System.out.print("User is in inactive state cannot reset password");
		}

	}

	public void enter_password() {

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		WebElement status = driver
				.findElement(By.xpath("//div[@class='card my-card']//li[2]//div//table//tr/td[6]//span[2]"));

		if (status.getText().equals("active")) {

			WebElement resetpassword = driver.findElement(By.xpath(
					"//div[@class='card my-card']//li//div[contains(@class,'collapsible-body')]//a[@title='Reset Password']"));
			JavascriptExecutor passwordexecutor = (JavascriptExecutor) driver;
			passwordexecutor.executeScript("arguments[0].click();", resetpassword);
			Random randomGenerator = new Random();
			int randomInt = randomGenerator.nextInt(1000);

			String random_password = "Sridevi@" + randomInt;

			System.out.print("New password is--" + random_password);
			String user = driver
					.findElement(By.xpath("//div[@class='card my-card']//li[2]//div//table//tr//td[4]//span[2]"))
					.getText();
			System.out.print("  User is--" + user);
			driver.findElement(By.xpath("//div[@id='reset_user_modal']//input[@id='new_password']"))
					.sendKeys(random_password);
		}

		else {
			System.out.print("Employee status is inactive");
		}

	}

	public void cancel_confirmation() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		WebElement passwordconfirm = driver.findElement(By.xpath(
				"//div[@id='reset_user_modal']//a[contains(@class,'reset-button') and contains(text(),'No, Cancel')]"));
		JavascriptExecutor confirmexecutor = (JavascriptExecutor) driver;
		confirmexecutor.executeScript("arguments[0].click();", passwordconfirm);
		Thread.sleep(3000);
		System.out.print("--Deletion cancelled--");
	}

	public void delete_action() throws InterruptedException {

		WebElement deleteelement = driver.findElement(By.xpath("//a[contains(@id,'usersView_grid_delete')]"));
		boolean deletevisible = deleteelement.isDisplayed();
		if (deletevisible == true) {
			JavascriptExecutor deleteexe = (JavascriptExecutor) driver;
			deleteexe.executeScript("arguments[0].click()", deleteelement);

		} else {
			System.out.print("\n" + "Employee cannot be deleted");
		}
	}

	public void confirm_deletion() {

		WebElement deletemodal = driver.findElement(By.id("delete_user_modal"));
		boolean deletemoelvisible = deletemodal.isDisplayed();
		if (deletemoelvisible == true) {
			WebElement deleteyeselement = driver.findElement(By.id("usersView_deleteUser_yes"));
			JavascriptExecutor deleteyesexe = (JavascriptExecutor) driver;
			deleteyesexe.executeScript("arguments[0].click()", deleteyeselement);
		} else {
			System.out.print("\n" + "deletionmodel not displayed");
		}
	}

	/*
	 * List <WebElement> allvalue = driver.findElements(By.
	 * xpath("//div[@class='card my-card']//li//table//tr/td[6]")); //int
	 * count=allvalue.size();
	 * System.out.print("Number of users:--"+allvalue.size()+" ");
	 * if(allvalue.size()>1) {
	 * 
	 * 
	 * driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	 * 
	 * WebElement delete_action= driver.findElement(By.
	 * xpath("//div[@class='card my-card']//li[2]//a[@title='Delete user account']")
	 * ); JavascriptExecutor deletexecutor = (JavascriptExecutor) driver;
	 * deletexecutor.executeScript("arguments[0].click();", delete_action);
	 * Thread.sleep(3000); } else
	 * {System.out.print("\n"+"Delte action:Only one user is there-");}
	 */

	public void cancel_deletion() {

		WebElement deletemodal = driver.findElement(By.id("delete_user_modal"));
		boolean deletemoelvisible = deletemodal.isDisplayed();
		if (deletemoelvisible == true) {
			WebElement deletenoelement = driver.findElement(By.id("usersView_deleteUser_no"));
			JavascriptExecutor deletenoexe = (JavascriptExecutor) driver;
			deletenoexe.executeScript("arguments[0].click()", deletenoelement);
			System.out.print("\n" + "deletion cancelled ");
		} else {
			System.out.print("\n" + "deletionmodel not displayed");
		}
	}

	public void confirm_deletion1() {

		List<WebElement> allvalue = driver.findElements(By.xpath("//div[@class='card my-card']//li//table//tr/td[6]"));

		System.out.print("Number of users:-" + allvalue.size() + " ");
		if (allvalue.size() > 1) {

			WebElement delete_action = driver.findElement(By.xpath(
					"//div[@id='delete_user_modal']//a[contains(@class,'delete-button') and contains(text(),'Yes, Delete')]"));
			JavascriptExecutor deletexecutor = (JavascriptExecutor) driver;
			deletexecutor.executeScript("arguments[0].click();", delete_action);
		}

		else {
			System.out.print("Root admin cannot delete");
		}
	}
	// WebElement element = driver.findElement(locator);

	// Assert.assertFalse(element.isDisplayed());

	public void changeroleicon() {

		WebElement changeroleicon = driver.findElement(By.xpath("//a[contains(@id,'usersView_grid_changeAccType')]"));
		boolean changerollvisible = changeroleicon.isDisplayed();
		if (changerollvisible == true) {
			JavascriptExecutor changeroleexe = (JavascriptExecutor) driver;
			changeroleexe.executeScript("arguments[0].click()", changeroleicon);
		} else {
			System.out.print("\n" + "cannot change role");
		}

	}

	public void changeoption() {
		WebElement changerolemodel = driver.findElement(By.id("change_user_type_modal"));
		boolean changerolemodelvisible = changerolemodel.isDisplayed();
		if (changerolemodelvisible == true) {
			WebElement changeoption = driver.findElement(By.id("viewStaff_addModal_admin"));
			JavascriptExecutor changeopionexe = (JavascriptExecutor) driver;
			changeopionexe.executeScript("arguments[0].click()", changeoption);
		} else {
			System.out.print("\n" + "changerole model not displayed");
		}

	}

	public void savechange() {

		WebElement savechange = driver.findElement(By.id("usersView_changeUserType_yes"));
		boolean savevisible = savechange.isDisplayed();
		if (savevisible == true) {
			JavascriptExecutor saveexe = (JavascriptExecutor) driver;
			saveexe.executeScript("arguments[0].click()", savechange);
		} else {
			System.out.print("\n" + "Save button not displayed");
		}

	}

	public void user_account_type() {

		List<WebElement> allvalue = driver.findElements(By.xpath("//div[@class='card my-card']//li//table//tr/td[6]"));

		for (int i = 0; i < allvalue.size(); i++) {
			WebElement accounttype = driver.findElement(
					By.xpath("//div[@class='card my-card']//li[" + (i + 1) + "]//a[@title='Change Account type']"));
			boolean visible = accounttype.isDisplayed();
			if (visible == true) {

				JavascriptExecutor visiblexecutor = (JavascriptExecutor) driver;
				visiblexecutor.executeScript("arguments[0].click();", accounttype);
				String usertype = driver
						.findElement(
								By.xpath("//div[@class='card my-card']//li[" + (i + 1) + "]//table//tr/td[5]//span[2]"))
						.getText();
				System.out.print("\n" + "account type:" + usertype);
				WebElement usertypemodal = driver.findElement(By.xpath("//div[@id='change_user_type_modal']"));
				boolean modalvisible = usertypemodal.isDisplayed();
				if (modalvisible == true) {

					// String usertype=driver.findElement(By.xpath("//div[@class='card
					// my-card']//li//table//tr/td[5]//span[2]")).getText();
					System.out.print("\n" + "-Employee type:" + usertype);
					if (usertype.equals("admin")) {
						System.out.print("\n" + "usertype is admin and changing as employee--");
						WebElement admin = driver.findElement(By.xpath(
								"//div[@id='change_user_type_modal']//div[@class='input-field login-type-edit']//span//label[2]"));
						JavascriptExecutor adminexecutor = (JavascriptExecutor) driver;
						adminexecutor.executeScript("arguments[0].click();", admin);
					}
					if (usertype.equals("employee")) {
						System.out.print("--usertype is employee and changing as admin--");
						WebElement employee = driver.findElement(By.xpath(
								"//div[@id='change_user_type_modal']//div[@class='input-field login-type-edit']//span//label[1]"));
						JavascriptExecutor employexecutor = (JavascriptExecutor) driver;
						employexecutor.executeScript("arguments[0].click();", employee);
					}

				} else {
					System.out.print("user modal not displayed");
				}
				break;
			} else {
				System.out.print("\n" + "first user type is root admin");
			}
		}
	}

	public void Select_user_type() {
		WebElement usertypemodal = driver.findElement(By.xpath("//div[@id='change_user_type_modal']"));
		boolean visible = usertypemodal.isDisplayed();
		if (visible == true) {
			// System.out.print("--usertype change modal window displaying");
			String usertype = driver.findElement(By.xpath("//div[@class='card my-card']//li//table//tr/td[5]//span[2]"))
					.getText();
			System.out.print("\n" + "-Employee type:" + usertype);
			if (usertype.equals("admin")) {
				System.out.print("--usertype is admin and changing as employee--");
				WebElement admin = driver.findElement(By.xpath(
						"//div[@id='change_user_type_modal']//div[@class='input-field login-type-edit']//span//label[2]"));
				JavascriptExecutor adminexecutor = (JavascriptExecutor) driver;
				adminexecutor.executeScript("arguments[0].click();", admin);
			}
			if (usertype.equals("employee")) {
				System.out.print("--usertype is employee and changing as admin--");
				WebElement employee = driver.findElement(By.xpath(
						"//div[@id='change_user_type_modal']//div[@class='input-field login-type-edit']//span//label[1]"));
				JavascriptExecutor employexecutor = (JavascriptExecutor) driver;
				employexecutor.executeScript("arguments[0].click();", employee);
			}

		} else {
			System.out.print("user modal not displayed");
		}
	}

	public void confirm_account_change() {
		WebElement usertypemodal = driver.findElement(By.xpath("//div[@id='change_user_type_modal']"));
		boolean visible = usertypemodal.isDisplayed();
		if (visible == true) {
			WebElement confirmation = driver.findElement(By.xpath(
					"//div[@id='change_user_type_modal']//div[@class='modal-footer']//a[contains(@class,'primary-button') and contains(text(),'Yes, Change')]"));
			JavascriptExecutor confirmexecutor = (JavascriptExecutor) driver;
			confirmexecutor.executeScript("arguments[0].click();", confirmation);
			driver.navigate().refresh();
		} else {
			System.out.print("user modal not displayed");
		}

	}

	public void Cancel_account_change() {
		WebElement usertypemodal = driver.findElement(By.xpath("//div[@id='change_user_type_modal']"));
		boolean visible = usertypemodal.isDisplayed();
		if (visible == true) {
			WebElement cancelchange = driver.findElement(By.xpath(
					"//div[@id='change_user_type_modal']//div[@class='modal-footer']//a[contains(@class,'reset-button') and contains(text(),'No, Cancel')]"));
			JavascriptExecutor cancelexecutor = (JavascriptExecutor) driver;
			cancelexecutor.executeScript("arguments[0].click();", cancelchange);
		} else {
			System.out.print("user modal not displayed");
		}

	}

	public void logout_nav() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement element = driver
				.findElement(By.xpath("//div[@class='side-wrapper']//ul[1]//li[@id='service_users_parent']//a"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		WebElement viewusers = driver
				.findElement(By.xpath("//div[@id='service_user_features']//span[4]//a[contains(text(),'View users')]"));
		JavascriptExecutor userexecutor = (JavascriptExecutor) driver;
		userexecutor.executeScript("arguments[0].click();", viewusers);

		List<WebElement> allvalue = driver.findElements(By.xpath("//div[@class='card my-card']//li//table//tr/td[6]"));

		for (int i = 1; i <= allvalue.size(); i++) {
			// driver.findElements(By.xpath("//div[@class='card
			// my-card']//li//table//tr/td[6]"));
			WebElement row = driver
					.findElement(By.xpath("//div[@class='card my-card']//li[" + (i) + "]//table//tr/td[6]"));
			JavascriptExecutor rowexecutor = (JavascriptExecutor) driver;
			rowexecutor.executeScript("arguments[0].click();", row);
			WebElement accounttype = driver.findElement(
					By.xpath("//div[@class='card my-card']//li[" + (i) + "]//a[contains(@title,'Logout')]"));
			boolean visible = accounttype.isDisplayed();
			if (visible == true) {
				JavascriptExecutor accountexecutor = (JavascriptExecutor) driver;
				accountexecutor.executeScript("arguments[0].click();", accounttype);
				break;
			} else {
				System.out.print("Logout icon not visible ");
			}
		}
	}

	public void confirm_logout() throws InterruptedException {
		WebElement logoutmodal = driver.findElement(By.xpath("//div[@id='logout_user_modal']"));
		boolean modal = logoutmodal.isDisplayed();
		if (modal == true) {
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			WebElement logoutconfirm = driver.findElement(By.xpath(
					"//div[@id='logout_user_modal']//a[@class='primary-button' and contains(text(),'Yes, Logout')]"));
			JavascriptExecutor confirmexecutor = (JavascriptExecutor) driver;
			confirmexecutor.executeScript("arguments[0].click();", logoutconfirm);
			driver.navigate().refresh();
			Thread.sleep(3000);
		} else {
			System.out.print("logout modal is not displayed");

		}
		// div[@id='logout_user_modal']//a[@class='primary-button' and
		// contains(text(),'Yes, Logout')]
	}

	public void Cancel_logout() throws InterruptedException {
		WebElement logoutmodal = driver.findElement(By.xpath("//div[@id='logout_user_modal']"));
		boolean modal = logoutmodal.isDisplayed();
		if (modal == true) {
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			WebElement cancelconfirm = driver.findElement(By.xpath(
					"//div[@id='logout_user_modal']//a[contains(@class,'reset-button') and contains(text(),'No, Cancel')]"));
			JavascriptExecutor cancelexecutor = (JavascriptExecutor) driver;
			cancelexecutor.executeScript("arguments[0].click();", cancelconfirm);
			driver.navigate().refresh();
			Thread.sleep(3000);
		} else {
			System.out.print("logout modal is not displayed");
		}
		// div[@id='logout_user_modal']//a[@class='primary-button' and
		// contains(text(),'Yes, Logout')]
	}

	public void cancel_change_role() {

		WebElement savechange = driver.findElement(By.id("usersView_changeUserType_yes"));
		boolean savevisible = savechange.isDisplayed();
		if (savevisible == true) {

			WebElement cancelchangerole = driver.findElement(By.id("usersView_changeUserType_no"));
			JavascriptExecutor cancelroleexe = (JavascriptExecutor) driver;
			cancelroleexe.executeScript("arguments[0].click()", cancelchangerole);
			System.out.print("\n" + "Changerole cancelled ");

		} else {
			System.out.print("\n" + "Changerole cannot be cancelled");
		}

	}

	public void mark_eventadmin() {

		WebElement eventadmin = driver.findElement(By.xpath("//a[contains(@id,'usersView_grid_grantEventAdmin')]"));
		boolean eventadminiconvisible = eventadmin.isDisplayed();
		if (eventadminiconvisible == true) {
			WebElement vmsadmin = driver.findElement(By.xpath("//table//tbody//tr[1]//td[4]"));
			String vmsadmindesgn = vmsadmin.getText();
			System.out.print("\n" + "is employee vms admin? " + vmsadmindesgn);
			if (vmsadmindesgn.contains("No")) {

				JavascriptExecutor eventadminexe = (JavascriptExecutor) driver;
				eventadminexe.executeScript("arguments[0].click()", eventadmin);
				System.out.print("\n" + "eventadmin button clicked");

			} else {
				System.out.print("\n" + "Employee is vms admin he cannot become event admin");
			}
		} else {
			System.out.print("\n" + "eventadmin icon not displayed");
		}
	}

	public void grant_eventadmin() {

		boolean grantmodeldisplay = UseractionsRepo.grantmodel.isDisplayed();
		if (grantmodeldisplay == true) {
			System.out.print("\n" + "Events admin grant model displayed so,can proceed");
			JavascriptExecutor grantexe = (JavascriptExecutor) driver;
			grantexe.executeScript("arguments[0].click()", UseractionsRepo.proceedeventadmin);
		} else {
			System.out.print("\n" + "Events admin grant model not displayed");
		}
	}
	
	public void revoke_eventadmin() {
		WebElement eventadmin = driver.findElement(By.xpath("//a[contains(@id,'usersView_grid_grantEventAdmin')]"));
		boolean eventadminiconvisible = eventadmin.isDisplayed();
		if (eventadminiconvisible == true) {
			
			System.out.print("\n"+"To test revoke, employee should marked as event admin");
			
		}else
		{
			System.out.print("\n"+"employee marked as event admin able to revoke");
			
			WebElement revokeelement=driver.findElement(By.xpath("//a[contains(@id,'usersView_grid_revokeEventAdmin')]"));
			JavascriptExecutor revokeexe=(JavascriptExecutor)driver;
			revokeexe.executeScript("arguments[0].click()", revokeelement);
			
			WebElement revokemodel=driver.findElement(By.id("revoke_event_admin_access"));
			boolean revokevisible=revokemodel.isDisplayed();
			if(revokevisible==true) {
				
				System.out.print("\n"+"revoke model is displayed");
				JavascriptExecutor revokeadminexe=(JavascriptExecutor)driver;
				revokeadminexe.executeScript("arguments[0].click()",UseractionsRepo.revokeeventadmin);
				
				
				
			}
			
			
			
					
					
		}
		
	}
	

}
