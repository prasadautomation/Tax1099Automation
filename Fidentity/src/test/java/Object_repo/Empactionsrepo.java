package Object_repo;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Empactionsrepo {
	
	@FindBy(how = How.ID, using = "header_users")
	public static WebElement usersmenu;
	@FindBy(how = How.ID, using = "header_viewEmployees")
	public static WebElement viewemployeesmenu;
	@FindBy(how=How.ID,using="staffView_grid_edit_0")
	public static WebElement editicon;
	@FindBy(how=How.ID,using="staffView_grid_delete_0")
	public static WebElement deleteicon;
	@FindBy(how=How.XPATH,using="//a[contains(@id,'staffView_grid_deactivate_0')]")
	public static WebElement deactiveicon;
	@FindBy(how=How.XPATH,using="//a[contains(@id,'staffView_grid_activate')]")
	public static WebElement activateicon;
	@FindBy(how=How.ID,using="delete_staff_modal")
	public static WebElement deletemodal;
	@FindBy(how=How.ID,using="staffView_deleteStaff_yes")
	public static WebElement deleteconfirm;
	@FindBy(how=How.ID,using="staffView_deleteStaff_no")
	public static WebElement deletestaffno;
	@FindBy(how=How.ID,using="status_change_staff_modal")
	public static WebElement statuschangemodal;
	@FindBy(how=How.ID,using="staffView_statusChange_yesDeactivate")
	public static WebElement confirmdeactivation;
	@FindBy(how=How.ID,using="staffView_statusChange_yesActivate")
	public static WebElement confirmactiavtion;
	@FindBy(how=How.ID,using="staffView_statusChange_no")
	public static WebElement cancelstatuschange;
	
	@FindBy(how=How.XPATH,using="//a[contains(@id,'staffView_grid_deactivate')]")
	public static List<WebElement> deactivationlist;
	
	@FindBy(how=How.XPATH,using="//a[contains(@id,'staffView_grid_edit')]")
	public static List<WebElement> editiconlist;
	@FindBy(how=How.XPATH,using="//a[contains(@id,'staffView_grid_delete')]")
	public static List<WebElement> deleteiconlist;
	
	//a[contains(@id,"staffView_grid_edit")]
	@FindBy(how=How.XPATH,using="//tbody//tr//td[4]")
	public static List<WebElement>emailslist;
	@FindBy(how=How.XPATH,using="//tbody//tr//td[7]")
	public static List<WebElement>statuslist;
	@FindBy(how=How.ID,using="employee_name")
	public static WebElement employeename;
	@FindBy(how=How.ID,using="phone_number")
	public static WebElement phonenumber;
	@FindBy(how=How.ID,using="email")
	public static WebElement email;
	@FindBy(how=How.ID,using="staffView_editModal_update")
	public static WebElement editupdate;
	@FindBy(how=How.ID,using="staffView_editModal_cancel")
	public static WebElement editcancel;
	@FindBy(how=How.ID,using="header_viewEmployees")
	public static WebElement employeemenu;
	
	
	
	
	
	
}
