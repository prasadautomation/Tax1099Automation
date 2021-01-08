package Object_repo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
public class DashboardElements {
	
	
	@FindBy(how=How.XPATH,using="//div[@id='Forms']//table//thead//following-sibling::tbody//tr")
	public static WebElement dashboardrecords;

}
