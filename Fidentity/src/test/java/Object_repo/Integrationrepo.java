package Object_repo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Integrationrepo {
	@FindBy(how=How.ID,using="settings_discover")
	public static WebElement settingsicon;
	

}
