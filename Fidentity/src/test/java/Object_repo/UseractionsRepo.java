package Object_repo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class UseractionsRepo {
	
	@FindBy(how=How.ID,using="header_products")
	public static WebElement productsicon;
	@FindBy(how=How.ID,using="header_switchProducts_vms")
	public static WebElement vmsmenu;
	@FindBy(how=How.ID,using="header_users")
	public static WebElement usersicon;
	@FindBy(how=How.ID,using="header_viewUsers")
	public static WebElement usersmenu;
	@FindBy (how=How.ID,using="usersView_eventAdminAccess_grant")
	public static WebElement proceedeventadmin;
	@FindBy(how=How.ID,using="grant_event_admin_access")
	public static WebElement grantmodel;
	@FindBy(how=How.ID,using="usersView_eventAdminRevoke_grant")
	public static WebElement revokeeventadmin;
	
	

}
