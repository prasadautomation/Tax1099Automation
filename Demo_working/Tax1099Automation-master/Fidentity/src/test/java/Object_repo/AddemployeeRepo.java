package Object_repo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddemployeeRepo {
	
	@FindBy(how=How.ID,using="header_users")
	public static WebElement productsicon;
	@FindBy(how=How.ID,using="header_viewEmployees")
	public static WebElement employeesmenu;
	@FindBy(how=How.ID,using="staffView_add")
	public static WebElement addemployeebutton;
	@FindBy(how=How.ID,using="invite_first_name")
	public static WebElement empfirstname;
	@FindBy(how=How.ID,using="invite_email")
	public static WebElement employeeemail;
	@FindBy(how=How.ID,using="invite_phone")
	public static WebElement empphone;
	@FindBy(how=How.ID,using="staffView_addModal_update")
	public static WebElement empupdate;
	@FindBy(how=How.ID,using="staffAdd_addStaffModal_yes")
	public static WebElement addempconfirmation;
	
	
	
	
	
	

}
