package Object_repo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;

public class Signinrepo {
	
	@FindBy(how = How.ID, using = "username")
	public static WebElement Username;
	@FindBy(how = How.ID, using = "login_usernameBlock_next")
	public static WebElement usernamenext;
	@FindBy(how = How.ID, using = "login_passwordBlock_forgotPassword")
	public static WebElement forgotpasswordtext;
	@FindBy(how = How.XPATH, using = "//form[@id='password_form']//input[@id='password']")
	public static WebElement userpassword;
	@FindBy(how = How.ID, using = "login_passwordBlock_login")
		public static WebElement Loginbutton;
	
}
