package Object_repo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Changepasswordrepo {
	@FindBy(how = How.ID, using = "header_profile")
	public static WebElement profileicon;
	@FindBy(how = How.ID, using = "header_changePassword")
	public static WebElement Changepasswordmenu;
	@FindBy(how = How.ID, using = "old_password")
	public static WebElement Oldpassword;
	@FindBy(how = How.ID, using = "new_password")
	public static WebElement Newpassword;
	@FindBy(how=How.ID,using="confirm_password")
	public static WebElement Confirmpassword;
	@FindBy(how=How.ID,using="changePassword_update")
	public static WebElement PasswordUpdateButton;

}
