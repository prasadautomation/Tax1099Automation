package Object_repo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PendingcheckinsRepo {
	
	@FindBy(how=How.ID,using="assistedSidebar_visitors")
	public static WebElement assistedvisitoricon;
	@FindBy(how=How.ID,using="assistedSidebar_pendingCheckIns")
	public static WebElement assistedpandingcheckinmenu;
	
	@FindBy(how=How.ID,using="addon_and_location_upselling_modal")
	public static WebElement addaonlocationmodal;
	@FindBy(how=How.ID,using="accept_reason")
	public static WebElement acceptreason;
	@FindBy(how=How.ID,using="pendingCheckins_checkinModal_submit")
	public static WebElement acceptsubmit;
	
	
	
	

}
